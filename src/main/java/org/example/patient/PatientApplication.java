package org.example.patient;

import org.example.patient.entities.Patient;
import org.example.patient.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class PatientApplication  implements CommandLineRunner {
    @Autowired
    private PatientRepo patientRepo;
    public static void main(String[] args) {
        SpringApplication.run(PatientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepo.save(new Patient(null, "Hassan", Date.valueOf("2000-10-10"), false, 5));
        patientRepo.save(new Patient(null, "Amina", Date.valueOf("2001-01-01"), true, 6));
        patientRepo.save(new Patient(null, "Yassine", Date.valueOf("2002-02-02"), false, 7));
        patientRepo.save(new Patient(null, "Omar", Date.valueOf("2003-03-03"), true, 8));
        patientRepo.save(new Patient(null, "Yasmine", Date.valueOf("2004-04-04"), false, 9));
        List<Patient> patients = patientRepo.findAll();
     patients.forEach( p->{
         System.out.println(p.toString());
             });
     Patient p = patientRepo.findById(1L).get();
     System.out.println("************");
     System.out.println(p.getId());
     System.out.println(p.getName());
     System.out.println(p.getDateNaissance());
     System.out.println(p.getScore());
        System.out.println("************");


        // Consulter un patient par ID
        Optional<Patient> optionalPatient = patientRepo.findById(1L);
        if (optionalPatient.isPresent()) {
            Patient pp = optionalPatient.get();
            System.out.println("Patient trouvé : " + pp);
        } else {
            System.out.println("Patient avec ID 1 non trouvé !");
        }

        //Chercher des patients
        List<Patient> patientsMalades = patientRepo.findByMalade(true);
        System.out.println("Patients malades :");
        patientsMalades.forEach(System.out::println);

        //  Mettre à jour un patient
        if (optionalPatient.isPresent()) {
            Patient patientToUpdate = optionalPatient.get();
            patientToUpdate.setScore(10); // Changer le score
            patientRepo.save(patientToUpdate);
            System.out.println("Patient mis à jour : " + patientToUpdate);
        }

        //  Supprimer un patient
        if (optionalPatient.isPresent()) {
            patientRepo.deleteById(1L);
            System.out.println(" Patient avec ID 1 supprimé !");
        }

        // Vérifier après suppression
        List<Patient> updatedPatients = patientRepo.findAll();
        System.out.println(" Liste après suppression :");
        updatedPatients.forEach(System.out::println);

    }
}

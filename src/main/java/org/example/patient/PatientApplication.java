package org.example.patient;

import org.example.patient.entities.Medecin;
import org.example.patient.entities.Patient;
import org.example.patient.repo.MedecinRepo;
import org.example.patient.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@SpringBootApplication
public class PatientApplication  implements CommandLineRunner {
    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private MedecinRepo medecinRepo;

    public static void main(String[] args) {
        SpringApplication.run(PatientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       patientRepo.save(Patient.builder().name("P1").dateNaissance(new Date(2000, 1, 1)).score(10).malade(true).build());
       patientRepo.save(Patient.builder().name("P2").dateNaissance(new Date(2000, 1, 1)).score(10).malade(true).build());
       patientRepo.save(Patient.builder().name("P3").dateNaissance(new Date(2000, 1, 1)).score(10).malade(true).build());
        patientRepo.save(Patient.builder().name("P4").dateNaissance(new Date(2000, 1, 1)).score(10).malade(true).build());
        patientRepo.save(Patient.builder().name("P5").dateNaissance(new Date(2000, 1, 1)).score(10).malade(true).build());
        List<Patient> patients = patientRepo.findAll();
     patients.forEach( p->{
         System.out.println(p.toString());
             });
     //medecin
        Stream.of("aymane","mohamed").forEach(name->{
            Medecin m = new Medecin();
            m.setNom(name);
            m.setEmail(name+"@gmail.com");
            m.setSpecialite(Math.random()>0.5?"cardiologue":"dentiste");
            medecinRepo.save(m);
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

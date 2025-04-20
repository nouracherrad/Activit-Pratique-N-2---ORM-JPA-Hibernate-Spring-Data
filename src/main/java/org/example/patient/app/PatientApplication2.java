package org.example.patient.app;

import org.example.patient.PatientApplication;
import org.example.patient.entities.*;
import org.example.patient.repo.MedecinRepo;
import org.example.patient.repo.PatientRepo;
import org.example.patient.repo.RendezVousRepo;
import org.example.patient.repo.consultationRepo;
import org.example.patient.service.IHospital;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.stream.Stream;
@SpringBootApplication
public class PatientApplication2   {
    public static void main(String[] args) {
        SpringApplication.run(PatientApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospital hospital , PatientRepo patientRepo , MedecinRepo medecinRepo , RendezVousRepo rendezVousRepo , consultationRepo consultationRepo){
        return args -> {
            Stream.of("aymane","mohamed").forEach(name->{
                Patient p = new Patient();
                p.setName(name);
                p.setDateNaissance(new Date(2000, 1, 1));
                p.setScore(10);
                p.setMalade(true);
                hospital.savepatient(p);

            });
            Stream.of("imane","mouna").forEach(name->{
                Medecin m = new Medecin();
                m.setNom(name);
                m.setEmail(name+"@gmail.com");
                m.setSpecialite(Math.random()>0.5?"cardiologue":"dentiste");
                hospital.savemedecin(m);

            });
            Patient p = patientRepo.findById(1L).orElse(null);
            Patient p2 = patientRepo.findByName("aymane");
            System.out.println("************");
            Medecin m = medecinRepo.findByNom("imane");
            RendezVous rdv = new RendezVous();
            rdv.setDate(new Date(2022, 1, 1));
            rdv.setStatus(StatusRDV.PENDING);
            rdv.setPatient(p);
            rdv.setMedecin(m);
            hospital.saverendezvous(rdv);
            RendezVous  rdv2 = rendezVousRepo.findAll().get(0);
            Consultation c = new Consultation();
            c.setRendezVous(rdv);
            c.setDateConsultation(new Date(2022, 1, 1));
            c.setRapport("rapport");
            hospital.saveconsultation(c);
        };


    }
}

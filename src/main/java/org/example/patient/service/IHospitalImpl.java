package org.example.patient.service;

import org.example.patient.entities.Consultation;
import org.example.patient.entities.Medecin;
import org.example.patient.entities.Patient;
import org.example.patient.entities.RendezVous;
import org.example.patient.repo.MedecinRepo;
import org.example.patient.repo.PatientRepo;
import org.example.patient.repo.RendezVousRepo;
import org.example.patient.repo.consultationRepo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IHospitalImpl implements IHospital {
    private PatientRepo patientRepo;
    private MedecinRepo medecinRepo;
    private RendezVousRepo rendezVousRepo;
    private consultationRepo conultationRepo;
    @Override
    public Patient savepatient(Patient patient) {
        return patientRepo.save(patient);
    }

    @Override
    public Medecin savemedecin(Medecin medecin) {
        return medecinRepo.save(medecin);
    }

    @Override
    public RendezVous saverendezvous(RendezVous rendezvous) {
rendezvous.setId(UUID.randomUUID().toString());
        return rendezVousRepo.save(rendezvous);
    }

    @Override
    public Consultation saveconsultation(Consultation consultation) {
        return conultationRepo.save(consultation);
    }

    public IHospitalImpl(PatientRepo patientRepo, MedecinRepo medecinRepo, RendezVousRepo rendezVousRepo, consultationRepo conultationRepo) {
        this.patientRepo = patientRepo;
        this.medecinRepo = medecinRepo;
        this.rendezVousRepo = rendezVousRepo;
        this.conultationRepo = conultationRepo;
    }
}

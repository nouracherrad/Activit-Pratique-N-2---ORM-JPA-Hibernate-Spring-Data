package org.example.patient.service;

import org.example.patient.entities.Consultation;
import org.example.patient.entities.Medecin;
import org.example.patient.entities.Patient;
import org.example.patient.entities.RendezVous;

public interface IHospital {
    Patient savepatient(Patient patient);
    Medecin savemedecin(Medecin medecin);
    RendezVous saverendezvous(RendezVous rendezvous);
    Consultation saveconsultation(Consultation consultation);
}

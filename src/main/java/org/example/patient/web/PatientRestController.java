package org.example.patient.web;

import org.example.patient.entities.Patient;
import org.example.patient.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class PatientRestController {
    @Autowired
    private PatientRepo patientRepo;
    @GetMapping("/patients")
    public List<Patient> patientsList(){
        return patientRepo.findAll();

    }
}

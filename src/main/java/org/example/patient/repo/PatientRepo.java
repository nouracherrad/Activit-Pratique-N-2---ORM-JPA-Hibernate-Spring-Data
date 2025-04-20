package org.example.patient.repo;

import org.example.patient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepo extends JpaRepository<Patient,Long> {
     Patient findByName(String name);
    List<Patient> findByMalade(boolean malade);

    // Trouver les patients ayant un score supérieur à une valeur donnée
    List<Patient> findByScoreGreaterThan(int score);

    // Trouver les patients par nom (ignorant la casse)
    List<Patient> findByNameIgnoreCase(String name);

}

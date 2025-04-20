package org.example.patient.repo;

import org.example.patient.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepo extends JpaRepository<Medecin, Long> {
Medecin findByNom(String nom);

}

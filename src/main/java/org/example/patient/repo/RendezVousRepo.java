package org.example.patient.repo;

import org.example.patient.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepo extends JpaRepository<RendezVous, String> {
}

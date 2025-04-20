package org.example.patient.repo;

import org.example.patient.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface consultationRepo extends JpaRepository<Consultation,Long> {
}

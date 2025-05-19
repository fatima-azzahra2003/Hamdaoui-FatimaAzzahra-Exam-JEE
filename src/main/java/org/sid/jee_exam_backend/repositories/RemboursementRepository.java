package org.sid.jee_exam_backend.repositories;

import org.sid.jee_exam_backend.entities.Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemboursementRepository extends JpaRepository<Remboursement, Long> {}
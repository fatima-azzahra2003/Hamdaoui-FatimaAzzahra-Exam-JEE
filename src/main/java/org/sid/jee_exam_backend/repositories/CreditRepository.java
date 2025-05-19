package org.sid.jee_exam_backend.repositories;

import org.sid.jee_exam_backend.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit, Long> {}

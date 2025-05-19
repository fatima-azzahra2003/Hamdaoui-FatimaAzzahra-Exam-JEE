package org.sid.jee_exam_backend.repositories;

import org.sid.jee_exam_backend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {}

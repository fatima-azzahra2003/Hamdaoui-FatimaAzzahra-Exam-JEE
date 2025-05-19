package org.sid.jee_exam_backend.dtos;

import lombok.Data;

@Data
public class ClientDTO {
    private Long id;
    private String nom;
    private String email;
}

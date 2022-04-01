package com.desafio.desafio.domain;

import com.desafio.desafio.enumeration.TypeServiceEnum;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Scheduling {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String cpf;
    private String phone;
    private String email;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private TypeServiceEnum serviceType;
    
    private boolean isApproved = false;

}

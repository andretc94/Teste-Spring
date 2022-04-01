package com.desafio.desafio.controller.dto;

import com.desafio.desafio.domain.Scheduling;
import com.desafio.desafio.enumeration.TypeServiceEnum;
import lombok.Data;

import java.time.LocalDate;

import static java.util.Optional.ofNullable;

@Data
public class SchedulingCreate {

    private String name;
    private String cpf;
    private String phone;
    private String email;
    private LocalDate date;
    private TypeServiceEnum serviceType;

    public static Scheduling to (SchedulingCreate dto){

        if(dto==null){
            return null;
        }

        Scheduling entity = new Scheduling();

        ofNullable(dto.getName()).ifPresent(entity::setName);

        ofNullable(dto.getCpf()).ifPresent(entity::setCpf);

        ofNullable(dto.getPhone()).ifPresent(entity::setPhone);

        ofNullable(dto.getEmail()).ifPresent(entity::setEmail);

        ofNullable(dto.getDate()).ifPresent(entity::setDate);

        ofNullable(dto.getServiceType()).ifPresent(entity::setServiceType);

        return entity;
    }
}

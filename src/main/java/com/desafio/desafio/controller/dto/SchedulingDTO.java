package com.desafio.desafio.controller.dto;

import com.desafio.desafio.domain.Scheduling;
import com.desafio.desafio.enumeration.TypeServiceEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SchedulingDTO {

    private Long id;
    private String name;
    private String cpf;
    private String phone;
    private String email;
    private LocalDate date;
    private TypeServiceEnum serviceType;
    private boolean isApproved;

    public static SchedulingDTO of(Scheduling entity){
        if(entity==null){
            return null;
        }

        SchedulingDTO dto = new SchedulingDTO();

        if(entity.getId() != null){
            dto.setId(entity.getId());
        }

        if(entity.getName() != null){
            dto.setName(entity.getName());
        }

        if(entity.getCpf() != null){
            dto.setCpf(entity.getCpf());
        }

        if(entity.getPhone() != null){
            dto.setPhone(entity.getPhone());
        }

        if(entity.getEmail() != null){
            dto.setEmail(entity.getEmail());
        }

        if(entity.getDate() != null){
            dto.setDate(entity.getDate());
        }

        if(entity.getServiceType() != null){
            dto.setServiceType(entity.getServiceType());
        }

        dto.setApproved(entity.isApproved());

        return dto;
    }
}

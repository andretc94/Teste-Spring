package com.desafio.desafio.controller;


import com.desafio.desafio.controller.dto.SchedulingCreate;
import com.desafio.desafio.controller.dto.SchedulingDTO;
import com.desafio.desafio.domain.Scheduling;
import com.desafio.desafio.repository.SchedulingRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
public class SchedulingController implements SchedulingAPI {

    private final SchedulingRepository schedulingRepository;

    @Override
    public ResponseEntity<List<SchedulingDTO>> list(String cpf) {
        if(cpf!= null  && !cpf.isEmpty()){
            List<SchedulingDTO> list = this.schedulingRepository.findAllByCpf(cpf).stream().map(SchedulingDTO::of).collect(Collectors.toList());
            return ResponseEntity.ok(list);
        }
        List<SchedulingDTO> list = this.schedulingRepository.findAll().stream().map(SchedulingDTO::of).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity getById(Long id) {
        Optional<Scheduling> modelOptional = this.schedulingRepository.findById(id);
        if(modelOptional.isPresent()) {
            return ResponseEntity.ok(SchedulingDTO.of(modelOptional.get()));
        }else throw new IllegalArgumentException("Not found by id: " + id);
    }

    @Override
    public ResponseEntity<SchedulingDTO> create(SchedulingCreate dto) {
        Scheduling scheduling = this.schedulingRepository.save(SchedulingCreate.to(dto));
        SchedulingDTO schedulingDTO = SchedulingDTO.of(scheduling);
        return ResponseEntity.status(HttpStatus.CREATED).body(schedulingDTO);
    }

    @Override
    public ResponseEntity update(Long id, Scheduling dto) {
        Optional<Scheduling> optionalModel = this.schedulingRepository.findById(id);
        if(optionalModel.isPresent()){
            dto.setId(optionalModel.get().getId());
            this.schedulingRepository.save(dto);
            return ResponseEntity.ok(dto);
        }else throw new IllegalArgumentException("Not found by id: " + id);
    }

    @Override
    public ResponseEntity delete(Long id) {
        Optional<Scheduling> model = this.schedulingRepository.findById(id);
        model.ifPresent(this.schedulingRepository::delete);
        return ResponseEntity.noContent().build();
    }
}

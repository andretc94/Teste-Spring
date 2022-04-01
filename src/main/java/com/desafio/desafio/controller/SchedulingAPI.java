package com.desafio.desafio.controller;

import com.desafio.desafio.controller.dto.SchedulingCreate;
import com.desafio.desafio.controller.dto.SchedulingDTO;
import com.desafio.desafio.domain.Scheduling;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/model")
public interface SchedulingAPI {

    @GetMapping
    ResponseEntity<List<SchedulingDTO>> list(@RequestParam(required = false) String cpf);

    @GetMapping(path = "{id}")
    ResponseEntity<SchedulingDTO> getById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<SchedulingDTO> create(@RequestBody SchedulingCreate dto);

    @PutMapping(path = "{id}")
    ResponseEntity<SchedulingDTO> update(@PathVariable Long id, @RequestBody Scheduling dto);

    @DeleteMapping(path = "{id}")
    ResponseEntity delete(@PathVariable Long id);

}

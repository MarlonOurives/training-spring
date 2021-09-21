package br.com.training.controller;

import br.com.training.model.dto.MuscleDTO;
import br.com.training.service.MuscleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/muscle")
public class MuscleController {

    @Autowired
    private MuscleService muscleService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MuscleDTO> save(@Valid @RequestBody MuscleDTO muscleDTO){
        return ResponseEntity.ok(muscleService.save(muscleDTO));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MuscleDTO>> findAll(){
        return ResponseEntity.ok(muscleService.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MuscleDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(muscleService.findById(id));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MuscleDTO> update(@Valid @RequestBody MuscleDTO muscleDTO){
        return ResponseEntity.ok(muscleService.update(muscleDTO));
    }
}

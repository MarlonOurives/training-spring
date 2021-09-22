package br.com.training.controller;

import br.com.training.model.dto.TrainingDTO;
import br.com.training.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/training")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrainingDTO> save(@Valid @RequestBody TrainingDTO trainingDTO){
        return ResponseEntity.ok(trainingService.save(trainingDTO));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrainingDTO>> findAll(){
        return ResponseEntity.ok(trainingService.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrainingDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(trainingService.findById(id));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrainingDTO> update(@Valid @RequestBody TrainingDTO trainingDTO){
        return ResponseEntity.ok(trainingService.update(trainingDTO));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrainingDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(trainingService.deleteById(id));
    }
}

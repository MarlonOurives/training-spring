package br.com.training.controller;

import br.com.training.model.dto.MembershipDTO;
import br.com.training.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/membership")
public class MembershipController {

    @Autowired
    private MembershipService membershipService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MembershipDTO> save(@Valid @RequestBody MembershipDTO membershipDTO){
        return ResponseEntity.ok(membershipService.save(membershipDTO));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MembershipDTO>> findAll(){
        return ResponseEntity.ok(membershipService.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MembershipDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(membershipService.findById(id));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MembershipDTO> update(@Valid @RequestBody MembershipDTO membershipDTO){
        return ResponseEntity.ok(membershipService.update(membershipDTO));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MembershipDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(membershipService.deleteById(id));
    }
}

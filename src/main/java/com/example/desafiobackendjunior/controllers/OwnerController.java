package com.example.desafiobackendjunior.controllers;

import com.example.desafiobackendjunior.dtos.OwnerCreateDTO;
import com.example.desafiobackendjunior.models.Owner;
import com.example.desafiobackendjunior.services.OwnerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public ResponseEntity<List<Owner>> findAllOwners() {
        return ResponseEntity.status(HttpStatus.OK).body(this.ownerService.findAllOwners());
    }

    @PostMapping
    public ResponseEntity<Owner> createOwner(@RequestBody @Valid OwnerCreateDTO ownerCreateDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.ownerService.createOwner(ownerCreateDTO));
    }
}

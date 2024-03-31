package com.example.desafiobackendjunior.controllers;

import com.example.desafiobackendjunior.models.Vehicle;
import com.example.desafiobackendjunior.dtos.VehicleCreateDTO;
import com.example.desafiobackendjunior.services.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<Vehicle>> findAllVehicles() {
        return ResponseEntity.status(HttpStatus.OK).body(this.vehicleService.findAllVehicles());
    }

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody @Valid VehicleCreateDTO veiculoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.vehicleService.createVehicle(veiculoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> findVehicleById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.vehicleService.findVehicleById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id) {
        this.vehicleService.deleteVehicle(id);

        return ResponseEntity.noContent().build();
    }
}

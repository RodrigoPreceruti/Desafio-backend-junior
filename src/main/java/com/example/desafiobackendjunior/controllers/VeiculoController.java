package com.example.desafiobackendjunior.controllers;

import com.example.desafiobackendjunior.dtos.VeiculoDTO;
import com.example.desafiobackendjunior.models.Veiculo;
import com.example.desafiobackendjunior.services.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<List<Veiculo>> listarVeiculos() {
        return ResponseEntity.status(HttpStatus.OK).body(this.veiculoService.listarVeiculos());
    }

    @PostMapping
    public ResponseEntity<Veiculo> cadastrarVeiculo(@RequestBody @Valid VeiculoDTO veiculoDTO) {
        Veiculo veiculo = this.veiculoService.cadastrarVeiculo(veiculoDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Veiculo>> listarVeiculo(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.veiculoService.listarVeiculo(id));
    }
}

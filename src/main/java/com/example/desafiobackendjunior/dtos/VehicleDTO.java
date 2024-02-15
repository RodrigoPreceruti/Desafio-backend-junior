package com.example.desafiobackendjunior.dtos;

import jakarta.validation.constraints.NotBlank;

public record VehicleDTO(@NotBlank String proprietario, @NotBlank String cpf, @NotBlank String placa) {
}

package com.example.desafiobackendjunior.dtos;

import com.example.desafiobackendjunior.models.Owner;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VehicleCreateDTO(@NotBlank String placa, @NotNull Owner owner) {
}

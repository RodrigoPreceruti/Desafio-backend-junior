package com.example.desafiobackendjunior.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VehicleApiDTO(@NotBlank String marca, @NotBlank String modelo, @NotBlank String chassi,
                            @NotNull boolean licenciado) {
}

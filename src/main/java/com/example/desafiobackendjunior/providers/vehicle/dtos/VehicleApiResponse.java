package com.example.desafiobackendjunior.providers.vehicle.dtos;

import jakarta.validation.constraints.NotBlank;

public record VehicleApiResponse(
        @NotBlank String marca,
        @NotBlank String modelo,
        @NotBlank String chassi,
        @NotBlank Boolean licenciado
) {
}

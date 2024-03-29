package com.example.desafiobackendjunior.models;

import com.example.desafiobackendjunior.dtos.VehicleCreateDTO;
import com.example.desafiobackendjunior.providers.vehicle.dtos.VehicleApiResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String plate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    private String chassi;

    private String brand;

    private String model;

    private boolean licensed;

    public Vehicle(VehicleCreateDTO vehicleDTO, VehicleApiResponse vehicleApiDTO) {
        this.plate = vehicleDTO.placa();
        this.owner = vehicleDTO.owner();
        this.chassi = vehicleApiDTO.chassi();
        this.brand = vehicleApiDTO.marca();
        this.model = vehicleApiDTO.modelo();
        this.licensed = vehicleApiDTO.licenciado();
    }
}

package com.example.desafiobackendjunior.models;

import com.example.desafiobackendjunior.dtos.VehicleApiDTO;
import com.example.desafiobackendjunior.dtos.VehicleDTO;
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

    private String owner;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String plate;

    private String chassi;

    private String brand;

    private String model;

    private boolean licensed;

    public Vehicle(VehicleDTO vehicleDTO, VehicleApiDTO vehicleApiDTO) {
        this.owner = vehicleDTO.proprietario();
        this.cpf = vehicleDTO.cpf();
        this.plate = vehicleDTO.placa();
        this.chassi = vehicleApiDTO.chassi();
        this.brand = vehicleApiDTO.marca();
        this.model = vehicleApiDTO.modelo();
        this.licensed = vehicleApiDTO.licenciado();
    }
}

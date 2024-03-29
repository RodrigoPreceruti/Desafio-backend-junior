package com.example.desafiobackendjunior.services;

import com.example.desafiobackendjunior.models.Vehicle;
import com.example.desafiobackendjunior.providers.vehicle.VehicleApi;
import com.example.desafiobackendjunior.dtos.VehicleCreateDTO;
import com.example.desafiobackendjunior.providers.vehicle.dtos.VehicleApiResponse;
import com.example.desafiobackendjunior.repositories.VehicleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleApi vehicleApi;

    public Vehicle createVehicle(VehicleCreateDTO vehicleCreateDTO) {
        VehicleApiResponse vehicleApiResponse = this.vehicleApi.getVehicleByPlaca(vehicleCreateDTO.placa());

        Vehicle veiculo = new Vehicle(vehicleCreateDTO, vehicleApiResponse);
        this.vehicleRepository.save(veiculo);

        return veiculo;
    }

    public List<Vehicle> findAllVehicles() {
        return this.vehicleRepository.findAll();
    }

    public Vehicle findVehicleById(Long id) throws EntityNotFoundException {
        Vehicle vehicle = this
                .vehicleRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return vehicle;
    }

    public void deleteVehicle(Long id) throws EntityNotFoundException {
        Vehicle vehicle = this.vehicleRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        this.vehicleRepository.delete(vehicle);
    }
}

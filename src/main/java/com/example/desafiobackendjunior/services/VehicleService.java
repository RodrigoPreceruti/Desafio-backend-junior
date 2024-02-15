package com.example.desafiobackendjunior.services;

import com.example.desafiobackendjunior.dtos.VehicleApiDTO;
import com.example.desafiobackendjunior.dtos.VehicleDTO;
import com.example.desafiobackendjunior.models.Vehicle;
import com.example.desafiobackendjunior.repositories.VehicleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle createVehicle(VehicleDTO veiculoDTO) {
        RestTemplate restTemplate = new RestTemplate();

        VehicleApiDTO veiculoApiDTO = restTemplate.getForEntity("https://my.api.mockaroo.com/veiculos?key=55ad1cd0&placa=" + veiculoDTO.placa(), VehicleApiDTO.class).getBody();

        Vehicle veiculo = new Vehicle(veiculoDTO, veiculoApiDTO);
        this.vehicleRepository.save(veiculo);

        return veiculo;
    }

    public List<Vehicle> findAllVehicles() {
        return this.vehicleRepository.findAll();
    }

    public Optional<Vehicle> findVehicleById(Long id) throws EntityNotFoundException {
        Optional<Vehicle> vehicle = this.vehicleRepository.findById(id);

        if (vehicle.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return vehicle;
    }

    public void deleteVehicle(Long id) throws EntityNotFoundException{
        Optional<Vehicle> vehicle = this.vehicleRepository.findById(id);

        if (vehicle.isEmpty()) {
            throw new EntityNotFoundException();
        }

        this.vehicleRepository.delete(vehicle.get());
    }
}

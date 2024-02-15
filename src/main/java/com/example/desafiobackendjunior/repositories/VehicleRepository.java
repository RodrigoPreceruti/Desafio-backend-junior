package com.example.desafiobackendjunior.repositories;

import com.example.desafiobackendjunior.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}

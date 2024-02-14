package com.example.desafiobackendjunior.repositories;

import com.example.desafiobackendjunior.models.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}

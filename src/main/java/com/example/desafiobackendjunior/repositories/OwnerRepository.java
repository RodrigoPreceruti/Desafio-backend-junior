package com.example.desafiobackendjunior.repositories;

import com.example.desafiobackendjunior.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}

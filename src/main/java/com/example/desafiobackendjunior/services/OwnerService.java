package com.example.desafiobackendjunior.services;

import com.example.desafiobackendjunior.dtos.OwnerCreateDTO;
import com.example.desafiobackendjunior.models.Owner;
import com.example.desafiobackendjunior.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    public List<Owner> findAllOwners() {
        return this.ownerRepository.findAll();
    }

    public Owner createOwner(OwnerCreateDTO ownerCreateDTO) {
        Owner owner = new Owner(ownerCreateDTO);
        this.ownerRepository.save(owner);

        return owner;
    }
}

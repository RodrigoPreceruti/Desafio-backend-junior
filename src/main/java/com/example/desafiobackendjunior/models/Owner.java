package com.example.desafiobackendjunior.models;

import com.example.desafiobackendjunior.dtos.OwnerCreateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "owners")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String document;

    public Owner(OwnerCreateDTO dto) {
        this.name = dto.name();
        this.document = dto.document();
    }
}

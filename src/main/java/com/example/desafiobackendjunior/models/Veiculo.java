package com.example.desafiobackendjunior.models;

import com.example.desafiobackendjunior.dtos.VeiculoApiDTO;
import com.example.desafiobackendjunior.dtos.VeiculoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "veiculos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String proprietario;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String placa;

    private String chassi;

    private String marca;

    private String modelo;

    private boolean licenciado;

    public Veiculo(VeiculoDTO veiculoDTO, VeiculoApiDTO veiculoApiDTO) {
        this.proprietario = veiculoDTO.proprietario();
        this.cpf = veiculoDTO.cpf();
        this.placa = veiculoDTO.placa();
        this.chassi = veiculoApiDTO.chassi();
        this.marca = veiculoApiDTO.marca();
        this.modelo = veiculoApiDTO.modelo();
        this.licenciado = veiculoApiDTO.licenciado();
    }
}

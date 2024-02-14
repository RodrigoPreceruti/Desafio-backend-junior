package com.example.desafiobackendjunior.services;

import com.example.desafiobackendjunior.dtos.VeiculoApiDTO;
import com.example.desafiobackendjunior.dtos.VeiculoDTO;
import com.example.desafiobackendjunior.models.Veiculo;
import com.example.desafiobackendjunior.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo cadastrarVeiculo(VeiculoDTO veiculoDTO) {
        RestTemplate restTemplate = new RestTemplate();

        VeiculoApiDTO veiculoApiDTO = restTemplate.getForEntity("https://my.api.mockaroo.com/veiculos?key=55ad1cd0&placa=" + veiculoDTO.placa(), VeiculoApiDTO.class).getBody();

        Veiculo veiculo = new Veiculo(veiculoDTO, veiculoApiDTO);
        this.veiculoRepository.save(veiculo);

        return veiculo;
    }
}

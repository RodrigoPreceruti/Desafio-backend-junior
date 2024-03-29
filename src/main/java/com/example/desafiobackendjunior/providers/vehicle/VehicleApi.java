package com.example.desafiobackendjunior.providers.vehicle;

import com.example.desafiobackendjunior.providers.vehicle.dtos.VehicleApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VehicleApi {
    public VehicleApiResponse getVehicleByPlaca(String placa) {
        RestTemplate restTemplate = new RestTemplate();

        VehicleApiResponse response = restTemplate.getForObject("https://my.api.mockaroo.com/veiculos?key=55ad1cd0&placa="
                + placa, VehicleApiResponse.class);

        return response;
    }
}

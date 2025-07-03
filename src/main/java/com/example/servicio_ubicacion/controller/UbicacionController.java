package com.example.servicio_ubicacion.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ubicacion")
public class UbicacionController {

    private final RestTemplate restTemplate;

    public UbicacionController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/regiones")
    public ResponseEntity<String> obtenerRegiones() {
        String url = "https://apis.digital.gob.cl/dpa/regiones";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("User-Agent", "SpringBootApp");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }

    @GetMapping("/regiones/{codigo}/comunas")
    public ResponseEntity<String> obtenerComunas(@PathVariable String codigo) {
        String url = "https://apis.digital.gob.cl/dpa/regiones/" + codigo + "/comunas";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("User-Agent", "SpringBootApp");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }

}

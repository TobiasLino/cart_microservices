package com.example.eureka.zip;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name = "viacep")
public interface ViaCEPClient {

    @GetMapping("/{zip}/json")
    Address findByZipCode(@PathVariable("zip") String zip);
}

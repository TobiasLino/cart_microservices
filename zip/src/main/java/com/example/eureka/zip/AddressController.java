package com.example.eureka.zip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/address")
@EnableCircuitBreaker
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/find/{zip}")
    public Address getOne(@PathVariable("zip") String zip) {
        return addressService.getOne(zip);
    }

    @GetMapping("/find/from/{uf}")
    public List<Address> getAllFrom(@PathVariable("uf") String uf) {
        return addressService.getAllFrom(uf);
    }
}

package com.example.eureka.cart;

import com.example.eureka.zip.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "zip", name = "zip")
public interface ZipClient {

    @GetMapping("/rest/address/find/{zip}")
    Address findByZipCode(@PathVariable(value = "zip") String zip);
}

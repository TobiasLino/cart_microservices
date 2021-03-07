package com.example.eureka.zip;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;

@Service
public class AddressService {

    private final List<Address> addresses = simpleAddresses();

    @Autowired
    private ViaCEPClient viaCEPClient;

    public Address getOne(String zip) {
        return viaCEPClient.findByZipCode(zip);
    }

    public List<Address> getAllFrom(String uf) {
        var list = new LinkedList<Address>();
        for (var i : addresses) {
            if (i.getUf().equalsIgnoreCase(uf)) {
                list.add(viaCEPClient.findByZipCode(i.getCep()));
            }
        }
        return list;
    }

    private List<Address> simpleAddresses() {
        var list = new LinkedList<Address>();
        list.add(Address.builder().cep("12289456").uf("SP").build());
        list.add(Address.builder().cep("12289350").uf("SP").build());
        return list;
    }
}

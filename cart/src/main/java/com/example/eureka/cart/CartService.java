package com.example.eureka.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private ZipClient zipClient;

    @Autowired
    private KafkaProducer kafkaProducer;

    private final List<Cart> carts = simpleCarts();

    public List<Cart> getOne(@PathVariable String name) {
        return carts.stream()
                .filter(cart -> cart.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Cart> getAll() {
        var list = new LinkedList<Cart>();
        list.add(Cart.builder().name("Tobias").email("tslino@sonda").address(zipClient.findByZipCode("12289456")).build());
        list.add(Cart.builder().name("Ana").email("analino@sonda").address(zipClient.findByZipCode("12289350")).build());
        list.add(Cart.builder().name("Fabio").email("fabio@sonda").address(zipClient.findByZipCode("12282350")).build());

        kafkaProducer.send(list.getFirst().toString());
        return list;
    }

    private List<Cart> simpleCarts() {
        var list = new LinkedList<Cart>();
        list.add(Cart.builder().name("Tobias").email("tslino@sonda").build());
        list.add(Cart.builder().name("Ana").email("analino@sonda").build());
        list.add(Cart.builder().name("Fabio").email("fabio@sonda").build());
        return list;
    }
}

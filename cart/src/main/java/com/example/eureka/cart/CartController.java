package com.example.eureka.cart;

import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{name}")
    public List<Cart> getOne(@PathVariable String name) {
        return cartService.getOne(name);
    }

    @GetMapping("/all")
    public List<Cart> getAll() {
        return cartService.getAll();
    }
}

package com.example.eureka.cart;

import com.example.eureka.zip.Address;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Cart {
    private String name;
    private String email;
    private Address address;
}

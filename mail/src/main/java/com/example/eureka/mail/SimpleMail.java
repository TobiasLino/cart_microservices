package com.example.eureka.mail;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SimpleMail {

    private String text;
    private String to;
    private String from;
}

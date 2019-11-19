package com.sdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SamedaydeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamedaydeliveryApplication.class, args);
	}

    @GetMapping
    public String print(){

	    return "Hello World Application";
    }

}

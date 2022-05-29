package com.paoprojectdelivery.www.paoproject;

import com.paoprojectdelivery.www.paoproject.customer.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class PaoprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaoprojectApplication.class, args);
	}

}

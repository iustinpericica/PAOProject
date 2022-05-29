package com.paoprojectdelivery.www.paoproject.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class CustomerConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository) {
        return args -> {
            Customer c1 = new Customer(
                    1L,
                    "Iustin",
                    "iustinpericica@yahoo.com",
                    "0741198606",
                    21
            );

            Customer c2 = new Customer(
                    2L,
                    "Andreea",
                    "andreea@yahoo.com",
                    "0741198900",
                    19
            );
            repository.saveAll(List.of(c1, c2));
        };
    }
}

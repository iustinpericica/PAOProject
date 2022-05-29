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
                    "Pericica",
                    LocalDate.of(2001, 10, 10),
                    "M",
                    "pass",
                    "iustinpericica@yahoo.com"
            );

            Customer c2 = new Customer(
                    2L,
                    "Iustin",
                    "Pericica",
                    LocalDate.of(2001, 10, 10),
                    "M",
                    "pass",
                    "iustinpericica2@yahoo.com"
            );
            repository.saveAll(List.of(c1, c2));
        };
    }
}

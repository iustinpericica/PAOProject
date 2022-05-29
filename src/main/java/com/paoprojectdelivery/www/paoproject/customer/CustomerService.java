package com.paoprojectdelivery.www.paoproject.customer;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerService {
    public List<Customer> getCustomers() {
        return List.of(new Customer("Iustin", "iustin@yahoo.com", LocalDate.of(2001, 11, 1), 21 ));
    }
}

package com.paoprojectdelivery.www.paoproject.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerByEmail = customerRepository.findCustomerByEmail(customer.getEmailAddress());
        if (customerByEmail.isPresent())
            throw new IllegalStateException("email taken");

        customerRepository.save(customer);
        System.out.println(customer);
    }

    public void deleteCustomer(Long id) {
        boolean existsById = customerRepository.existsById(id);
        if (!existsById)
            throw new IllegalStateException("student with id " + id + " does not exist");
        customerRepository.deleteById(id);
    }

    public void updateCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }
}

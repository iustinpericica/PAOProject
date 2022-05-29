package com.paoprojectdelivery.www.paoproject.worker;

import com.paoprojectdelivery.www.paoproject.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
    @Query("SELECT c FROM Customer c WHERE c.emailAddress = ?1")
    Optional<Customer> findCustomerByEmail(String email);
}
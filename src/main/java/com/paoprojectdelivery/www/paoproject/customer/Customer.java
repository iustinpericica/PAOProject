package com.paoprojectdelivery.www.paoproject.customer;

import com.paoprojectdelivery.www.paoproject.utils.Person;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Customer extends Person {
    @Id
    @SequenceGenerator(
            name = "customer_seq",
            sequenceName = "customer_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_seq"
    )
    private Long id;

    public Customer(Long id) {
        this.id = id;
    }

    public Customer(String firstName, String lastName, LocalDate dateOfBirth, String gender, String password, String emailAddress) {
        super(firstName, lastName, dateOfBirth, gender, password, emailAddress);
    }

    public Customer(Long id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String password, String emailAddress) {
        super(firstName, lastName, dateOfBirth, gender, password, emailAddress);
        this.id = id;
    }

    public Customer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}

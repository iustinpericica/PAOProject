package com.paoprojectdelivery.www.paoproject.worker;

import com.paoprojectdelivery.www.paoproject.utils.Person;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Worker extends Person {
    @Id
    @SequenceGenerator(
            name = "worker_seq",
            sequenceName = "worker_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "worker_seq"
    )
    private Long id;
    private float salary;

    public Worker(Long id) {
        this.id = id;
    }

    public Worker(String firstName, String lastName, LocalDate dateOfBirth, String gender, String password, String emailAddress, float salary) {
        super(firstName, lastName, dateOfBirth, gender, password, emailAddress);
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Worker(Long id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String password, String emailAddress, float salary) {
        super(firstName, lastName, dateOfBirth, gender, password, emailAddress);
        this.salary = salary;
        this.id = id;
    }

    public Worker() {

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

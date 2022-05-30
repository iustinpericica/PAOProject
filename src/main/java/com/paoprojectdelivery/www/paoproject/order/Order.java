package com.paoprojectdelivery.www.paoproject.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.paoprojectdelivery.www.paoproject.OrderItem.OrderItem;
import com.paoprojectdelivery.www.paoproject.customer.Customer;
import com.paoprojectdelivery.www.paoproject.worker.Worker;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "placed_order")
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_seq",
            sequenceName = "order_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_seq"
    )
    private Long id;

    @ManyToOne
    private Worker worker;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    private Date orderDate;

    private OrderStatus orderStatus;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", worker=" + worker +
                ", orderItems=" + orderItems +
                ", customer=" + customer +
                ", orderDate=" + orderDate +
                ", orderStatus=" + orderStatus +
                '}';
    }

    public Order(Worker worker, List<OrderItem> orderItems, Date orderDate, OrderStatus orderStatus, Customer customer) {
        this.worker = worker;
        this.orderItems = orderItems;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.customer = customer;
    }

    @JsonManagedReference
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Order() {
    }

    public Order(Long id) {
        this.id = id;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
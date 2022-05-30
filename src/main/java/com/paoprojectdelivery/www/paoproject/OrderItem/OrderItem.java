package com.paoprojectdelivery.www.paoproject.OrderItem;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.paoprojectdelivery.www.paoproject.order.Order;

import javax.persistence.*;

@Entity
public class OrderItem {
    @Id
    @SequenceGenerator(
            name = "order_item_seq",
            sequenceName = "order_item_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_item_seq"
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    private Long priceUnit;

    private int quantity;

    // TODO: Improve this: add reference to existing Table ( items )
    private String description;

    @JsonBackReference
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Long getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(Long priceUnit) {
        this.priceUnit = priceUnit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderItem() {
    }

    public OrderItem(Long id) {
        this.id = id;
    }

    public OrderItem(Long priceUnit, int quantity, String description) {
        this.priceUnit = priceUnit;
        this.quantity = quantity;
        this.description = description;
    }
}
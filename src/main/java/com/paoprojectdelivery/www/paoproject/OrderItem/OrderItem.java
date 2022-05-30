package com.paoprojectdelivery.www.paoproject.OrderItem;

import com.paoprojectdelivery.www.paoproject.order.Order;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
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

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private Long priceUnit;

    private int quantity;

    // TODO: Improve this: add reference to existing Table ( items )
    private String description;

    public Order getOrder_id() {
        return order;
    }

    public void setOrder_id(Order order) {
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
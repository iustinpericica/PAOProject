package com.paoprojectdelivery.www.paoproject.order;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PlacedOrder")
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

    private Date orderDate;

    private OrderStatus orderStatus;

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
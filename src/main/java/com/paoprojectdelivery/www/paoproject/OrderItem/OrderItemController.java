package com.paoprojectdelivery.www.paoproject.OrderItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/orderItem")
public class OrderItemController {
    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping
    public List<OrderItem> getWorkers() {
        return orderItemService.getOrderItems();
    }

    @PostMapping
    public void addNewOrderItem(@RequestBody OrderItem orderItem) {
        orderItemService.addNewOrderItem(orderItem);
    }

    @PutMapping
    public void updateOrderItem(@RequestBody OrderItem orderItem) {
        orderItemService.updateOrderItem(orderItem);
    }

    @DeleteMapping(path = {"{orderItemId}"})
    public void deleteOrderItem(@PathVariable("orderItemId") Long id) {
        orderItemService.deleteOrderItem(id);
    }
}

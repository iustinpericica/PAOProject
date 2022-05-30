package com.paoprojectdelivery.www.paoproject.OrderItem;

import com.paoprojectdelivery.www.paoproject.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> getOrderItems() {
        return orderItemRepository.findAll();
    }

    public void addNewOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    public void deleteOrderItem(Long id) {
        boolean existsById = orderItemRepository.existsById(id);
        if (!existsById)
            throw new IllegalStateException("Worker with id " + id + " does not exist");
        orderItemRepository.deleteById(id);
    }

    public void updateOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }
}

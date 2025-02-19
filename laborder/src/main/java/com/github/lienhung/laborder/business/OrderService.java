package com.github.lienhung.laborder.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.lienhung.laborder.dao.OrderRepository;
import com.github.lienhung.laborder.models.Order;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDTO> getOrders() {
        List<Order> orders = orderRepository.findAll();

        return orders.stream().map(order -> {
            return new OrderDTO(order.getId(), order.getCustomerId(), order.getDate(), order.getTotal());
        }).toList();
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public OrderDTO getOrderById(String orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        return new OrderDTO(orderId, order.getCustomerId(), order.getDate(), order.getTotal());
    }
}

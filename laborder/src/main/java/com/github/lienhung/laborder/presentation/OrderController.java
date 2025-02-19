package com.github.lienhung.laborder.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.lienhung.laborder.business.OrderDTO;
import com.github.lienhung.laborder.business.OrderService;
import com.github.lienhung.laborder.models.Order;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public List<OrderDTO> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping("/")
    public void addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
    }

    @GetMapping("/{orderId}")
    public void getOrderById(@PathVariable String orderId) {
        orderService.getOrderById(orderId);
    }
}

package com.github.lienhung.laborder.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.lienhung.laborder.dao.CustomerRepository;
import com.github.lienhung.laborder.dao.OrderRepository;
import com.github.lienhung.laborder.models.Customer;
import com.github.lienhung.laborder.models.Order;

@Service
public class CustomerService {
    
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDTO> getCustomers() {
        List<Customer> customers = customerRepository.findAll();

        return customers.stream().map(customer -> {
            return new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress(), customer.getPhone(), customer.getVipStatus());
        }).toList();
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
        // Update orders as the customer no longer exists
        List<Order> orders = orderRepository.findByCustomerId(customerId);
        orderRepository.deleteAll(orders);
        orders.stream().forEach(order -> {
            order.setCustomerId("");
        });
        orderRepository.saveAll(orders);
    }

    public CustomerDTO getCustomerById(String customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress(), customer.getPhone(), customer.getVipStatus());
    }

    public List<OrderDTO> getCustomerOrders(String customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        List<Order> orders = orderRepository.findByCustomerId(customerId);

        return orders.stream().map(order -> {
            if (customer.getVipStatus()) {
                order.setTotal(order.getTotal() * 0.9); // 10% discount
            }
            return new OrderDTO(order.getId(), order.getCustomerId(), order.getDate(), order.getTotal());
        }).toList();
    }
}

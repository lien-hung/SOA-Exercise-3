package com.github.lienhung.laborder.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.lienhung.laborder.business.CustomerDTO;
import com.github.lienhung.laborder.business.CustomerService;
import com.github.lienhung.laborder.business.OrderDTO;
import com.github.lienhung.laborder.models.Customer;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public List<CustomerDTO> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping("/")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable String customerId) {
        customerService.deleteCustomer(customerId);
    }

    @GetMapping("/{customerId}")
    public CustomerDTO getCustomerById(@PathVariable String customerId) {
        return customerService.getCustomerById(customerId);
    }

    @GetMapping("/{customerId}/orders")
    public List<OrderDTO> getCustomerOrders(@PathVariable String customerId) {
        return customerService.getCustomerOrders(customerId);
    }
}

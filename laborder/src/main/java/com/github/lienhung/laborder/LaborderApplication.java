package com.github.lienhung.laborder;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.lienhung.laborder.dao.CustomerRepository;
import com.github.lienhung.laborder.dao.OrderRepository;
import com.github.lienhung.laborder.models.Customer;
import com.github.lienhung.laborder.models.Order;

@SpringBootApplication
public class LaborderApplication implements CommandLineRunner {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(LaborderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		clearData();
		// Uncomment the following lines to initialize test data once.
		// seedData();

		// for (Customer customer : customerRepository.findAll()) {
		// 	System.out.println(customer);
		// }

		// for (Order order : orderRepository.findAll()) {
		// 	System.out.println(order);
		// }
	}

	public void clearData() {
		// Clear prior data
		customerRepository.deleteAll();
		orderRepository.deleteAll();
	}

	public void seedData() {
		// Sample customer data
		Customer c1 = new Customer("Vo Van Hai", "123 Main St.", "0912345678", false);
		Customer c2 = new Customer("Le Van Thanh", "456 Wall St.", "0939012345", true);
		customerRepository.save(c1);
		customerRepository.save(c2);

		// Sample order data
		List<Order> orders = List.of(
			new Order(c1.getId(), LocalDate.of(2024, 8, 25), 4800),
			new Order(c1.getId(), LocalDate.of(2024, 9, 4), 9200),
			new Order(c2.getId(), LocalDate.of(2024, 8, 9), 5500),
			new Order(c2.getId(), LocalDate.of(2024, 10, 5), 8000),
			new Order(c2.getId(), LocalDate.of(2024, 10, 16), 6700)
		);
		orderRepository.saveAll(orders);
	}
}

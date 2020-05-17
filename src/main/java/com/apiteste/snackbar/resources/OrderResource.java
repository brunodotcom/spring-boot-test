package com.apiteste.snackbar.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiteste.snackbar.models.Order;
import com.apiteste.snackbar.repository.OrderRepository;
import com.apiteste.snackbar.services.OrderService;

/**
 * Controller to hold all methods to interact to order model 
 * 
 * @author Bruno de Souza Rocha
 */
//TODO Add all methods documentation
//TODO Add Store Validation
@RestController
@RequestMapping(value="/api")
public class OrderResource {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderService orderService;
	
	/**
	 * Returns a List with all orders
	 * 
	 * @return List
	 */
	@GetMapping("/orders")	
	public List<Order> index() {
		return orderRepository.findAll();
	}
	
	/**
	 * Returns only one order by a given Id
	 * 
	 * @param id
	 * @return order
	 */
	@GetMapping("/orders/{id}")	
	public Order show(@PathVariable(value="id") long id) {
		return orderRepository.findById(id);
	}
	
	/**
	 * Creates a new order
	 * 
	 * @param order
	 * @return order
	 */
	// TODO Find out why order isn't returning with its ingredients
	@PostMapping("/orders")
	public Order store(@RequestBody Order order) {
		order.setTotalValue(orderService.calcTotalValue(order));
		return orderRepository.save(order);
	}
	
	
	/**
	 * Destroy an order by a given Id 
	 * 
	 * @param order
	 */
	@DeleteMapping("/orders")
	public void destroy(@RequestBody Order order) {
		orderRepository.delete(order);		
		
	}
	
	/**
	 * Updates an order
	 * 
	 * @param order
	 * @return order
	 */
	@PutMapping("/orders")
	public Order update(@RequestBody Order order) {
		return orderRepository.save(order);		
		
	}
	
}

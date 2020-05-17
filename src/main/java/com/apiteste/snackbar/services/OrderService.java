package com.apiteste.snackbar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiteste.snackbar.models.Order;
import com.apiteste.snackbar.models.Sandwich;
import com.apiteste.snackbar.repository.SandwichRepository;

/**
 * Service to hold all business operations to orders 
 * 
 * @author Bruno de Souza Rocha
 *
 */
@Service
public class OrderService {
	
	@Autowired
	SandwichRepository sandwichRepository;
	
	@Autowired
	SandwichService  sandwichService;


	/**
	 * Call order total value based on choosen sandwiches
	 * 
	 * TODO Add quantity calc
	 * TODO Add Validation
	 * TODO Add Exceptions
	 * 
	 * @param Order
	 * @return Double
	 */
	public Double calcTotalValue(Order order) {
		Double totalValue = 0.0;
		for(Sandwich sandwich : order.getSandwiches()) {
			sandwich = sandwichRepository.findById(sandwich.getId());
			totalValue += sandwichService.calcValue(sandwich);
		}
		
		return totalValue;
	}
	
}

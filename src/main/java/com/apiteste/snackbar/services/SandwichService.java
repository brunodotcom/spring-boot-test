package com.apiteste.snackbar.services;

import org.springframework.stereotype.Service;

import com.apiteste.snackbar.models.Ingredient;
import com.apiteste.snackbar.models.Sandwich;

/**
 * Service to hold all business operations to sandwiches 
 * 
 * @author Bruno de Souza Rocha
 *
 */
@Service
public class SandwichService {
	
	/**
	 * Calc sandwich value based on its ingredients
	 * 
	 * TODO Add quantity calc
	 * TODO Add Validation
	 * TODO Add Exceptions
	 * 
	 * @param Sandwich
	 * @return Double
	 */
	public Double calcValue(Sandwich sandwich) {
		Double sandwichValue = 0.0;
		for(Ingredient ingredient : sandwich.getIngredients()) {		    						
			sandwichValue += ingredient.getValue();
		}
		
		return sandwichValue;
	}	
}

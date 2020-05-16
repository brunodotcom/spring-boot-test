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

import com.apiteste.snackbar.models.Ingredient;
import com.apiteste.snackbar.repository.IngredientRepository;

/**
 * Controller to hold all methods to interact to ingredient model 
 * 
 * @author Bruno de Souza Rocha
 */
//TODO Add all methods documentation
//TODO Add Store Validation
@RestController
@RequestMapping(value="/api")
public class IngredientResource {

	@Autowired
	IngredientRepository ingredientRepository;
	
	/**
	 * Returns a List with all ingredients
	 * 
	 * @return List
	 */
	@GetMapping("/ingredients")	
	public List<Ingredient> index() {
		return ingredientRepository.findAll();
	}
	
	/**
	 * Returns only one ingredient by a given Id
	 * 
	 * @param id
	 * @return ingredient
	 */
	@GetMapping("/ingredients/{id}")	
	public Ingredient show(@PathVariable(value="id") long id) {
		return ingredientRepository.findById(id);
	}
	
	/**
	 * Creates a new ingredient
	 * 
	 * @param ingredient
	 * @return ingredient
	 */
	@PostMapping("/ingredients")
	public Ingredient store(@RequestBody Ingredient ingredient) {
		return ingredientRepository.save(ingredient);		
		
	}
	
	
	/**
	 * Destroy an ingredient by a given Id 
	 * 
	 * @param ingredient
	 */
	@DeleteMapping("/ingredients")
	public void destroy(@RequestBody Ingredient ingredient) {
		ingredientRepository.delete(ingredient);		
		
	}
	
	/**
	 * Updates an ingredient
	 * 
	 * @param ingredient
	 * @return ingredient
	 */
	@PutMapping("/ingredients")
	public Ingredient update(@RequestBody Ingredient ingredient) {
		return ingredientRepository.save(ingredient);		
		
	}
	
}

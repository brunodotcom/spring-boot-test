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

import com.apiteste.snackbar.models.Sandwich;
import com.apiteste.snackbar.repository.SandwichRepository;

/**
 * Controller to hold all methods to interact to sandwich model 
 * 
 * @author Bruno de Souza Rocha
 */
//TODO Add all methods documentation
//TODO Add Store Validation
@RestController
@RequestMapping(value="/api")
public class SandwichResource {

	@Autowired
	SandwichRepository sandwichRepository;
	
	/**
	 * Returns a List with all sandwiches
	 * 
	 * @return List
	 */
	@GetMapping("/sandwiches")	
	public List<Sandwich> index() {
		return sandwichRepository.findAll();
	}
	
	/**
	 * Returns only one sandwich by a given Id
	 * 
	 * @param id
	 * @return sandwich
	 */
	@GetMapping("/sandwiches/{id}")	
	public Sandwich show(@PathVariable(value="id") long id) {
		return sandwichRepository.findById(id);
	}
	
	/**
	 * Creates a new sandwich
	 * 
	 * @param sandwich
	 * @return sandwich
	 */
	// TODO Find out why sandwich isn't returning with its ingredients
	@PostMapping("/sandwiches")
	public Sandwich store(@RequestBody Sandwich sandwich) {
		return sandwichRepository.save(sandwich);		
		
	}
	
	
	/**
	 * Destroy an sandwich by a given Id 
	 * 
	 * @param sandwich
	 */
	@DeleteMapping("/sandwiches")
	public void destroy(@RequestBody Sandwich sandwich) {
		sandwichRepository.delete(sandwich);		
		
	}
	
	/**
	 * Updates an sandwich
	 * 
	 * @param sandwich
	 * @return sandwich
	 */
	@PutMapping("/sandwiches")
	public Sandwich update(@RequestBody Sandwich sandwich) {
		return sandwichRepository.save(sandwich);		
		
	}
	
}

package com.apiteste.snackbar.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Controller to hold all methods to interact to sandwich model 
 * 
 * @author Bruno de Souza Rocha
 */
//TODO Add all methods documentation
//TODO Add Store Validation
@RestController
@RequestMapping(value="/api")
@Api(value="Sandwiches")
@CrossOrigin(origins = "*")
public class SandwichResource {

	@Autowired
	SandwichRepository sandwichRepository;
	
	/**
	 * Returns a List with all sandwiches with its ingredients
	 * 
	 * @return List
	 */
	@GetMapping("/sandwiches")
	@ApiOperation(value = "Returns a List with all sandwiches with its ingredients")
	public List<Sandwich> index() {
		return sandwichRepository.findAll();
	}
	
	/**
	 * Returns only one sandwich with its ingredientes by a given Id
	 * 
	 * @param id
	 * @return sandwich
	 */
	@GetMapping("/sandwiches/{id}")	
	@ApiOperation(value = "Returns only one sandwich with its ingredientes by a given Id")
	public Sandwich show(@PathVariable(value="id") long id) {
		return sandwichRepository.findById(id);
	}
	
	/**
	 * Creates a new sandwich with its ingredients
	 * 
	 * @param sandwich
	 * @return sandwich
	 */
	// TODO Find out why sandwich isn't returning with its ingredients
	@PostMapping("/sandwiches")
	@ApiOperation(value = "Creates a new sandwich with its ingredients")
	public Sandwich store(@RequestBody Sandwich sandwich) {
		return sandwichRepository.save(sandwich);		
		
	}
	
	
	/**
	 * Destroy a sandwich by a given Id 
	 * 
	 * TODO FIX Create a validation to avoid delete sandwiches in use
	 * @param sandwich
	 */
	@DeleteMapping("/sandwiches")
	@ApiOperation(value = "Delete a sandwich by a given Id ")
	public void destroy(@RequestBody Sandwich sandwich) {
		sandwichRepository.delete(sandwich);		
		
	}
	
	/**
	 * Updates a sandwich
	 * 
	 * @param sandwich
	 * @return sandwich
	 */
	@PutMapping("/sandwiches")
	@ApiOperation(value = "Updates a sandwich")
	public Sandwich update(@RequestBody Sandwich sandwich) {
		return sandwichRepository.save(sandwich);		
		
	}
	
}

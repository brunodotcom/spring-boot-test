package com.apiteste.snackbar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiteste.snackbar.models.Ingredient;

/**
 * Repository Class to allow access to ingredient data
 * 
 * @author Bruno de Souza Rocha
 */
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

	// Makes findById returns a ingredient object 
	Ingredient findById(long id);
}

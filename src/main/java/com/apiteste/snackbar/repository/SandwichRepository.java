package com.apiteste.snackbar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiteste.snackbar.models.Sandwich;

/**
 * Repository Class to allow access to sandwich data
 * 
 * @author Bruno de Souza Rocha
 */
public interface SandwichRepository extends JpaRepository<Sandwich, Long> {

	// Makes findById returns a sandwich object 
	Sandwich findById(long id);
}

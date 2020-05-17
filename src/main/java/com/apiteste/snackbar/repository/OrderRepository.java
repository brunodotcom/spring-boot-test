package com.apiteste.snackbar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiteste.snackbar.models.Order;

/**
 * Repository Class to allow access to ingredient data
 * 
 * @author Bruno de Souza Rocha
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

	// Makes findById returns a order object 
	Order findById(long id);
}

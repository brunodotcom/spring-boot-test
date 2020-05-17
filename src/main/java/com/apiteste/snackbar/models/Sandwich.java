package com.apiteste.snackbar.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Model class to hold sandwich data
 *
 * @author Bruno de Souza Rocha
 */
// TODO Add Validation
// TODO Add Relationship Between Ingredients and Sandwiches
// TODO Add Seeder to Sandwich model
@Entity
@Table(name = "sandwiches")
public class Sandwich implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//TODO FIX - Find out why id number continues from Ingridient model ID 
	private long id;	
	
	private String name;
	
	@ManyToMany()
	@MapsId("id")
	private List<Ingredient> ingredients;
	
	@ManyToMany(mappedBy = "sandwiches")
	private List<Order> orders;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
}

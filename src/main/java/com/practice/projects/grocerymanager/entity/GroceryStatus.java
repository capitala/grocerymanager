package com.practice.projects.grocerymanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class GroceryStatus {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String status;
	@OneToOne
	private GroceryEntity groceryEntity;

	public GroceryStatus() {
		// TODO Auto-generated constructor stub
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public GroceryEntity getGroceryEntity() {
		return groceryEntity;
	}

	public void setGroceryEntity(GroceryEntity groceryEntity) {
		this.groceryEntity = groceryEntity;
	}

}

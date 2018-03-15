package com.practice.projects.grocerymanager.entity;

import java.util.Date;

import javax.persistence.PostLoad;

public class GroceryListener {
	@PostLoad
	public void setDetails(GroceryEntity obj) {
		obj.setDateOfPurchase(new Date());
		obj.setProbableEndDate(new Date(obj.getDateOfPurchase().getDate()+7));
		obj.setTotalPrice(obj.getPrice()*obj.getQuantity());
		
		
	}
}

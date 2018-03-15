package com.practice.projects.grocerymanager.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;

@Entity
public class GroceryEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private Date probableEndDate;
	private int quantity;
	private double price;
	private double totalPrice;
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="id")
	private GroceryStatus status;
	public GroceryStatus getStatus() {
		return status;
	}
	public void setStatus(GroceryStatus status) {
		this.status = status;
	}
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
	public Date getProbableEndDate() {
		return probableEndDate;
	}
	public void setProbableEndDate(Date probableEndDate) {
		this.probableEndDate = probableEndDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	private Date dateOfPurchase;
/*	@PostLoad
	public void setDetails() {
		dateOfPurchase=new Date();
		setProbableFinishingDate();
		setTotalPrice();
		
		
	}
	public void setProbableFinishingDate() {
		probableEndDate=new Date(dateOfPurchase.getDate()+7*quantity);
	}
	public void setTotalPrice() {
		totalPrice=quantity*price;
	}*/

}

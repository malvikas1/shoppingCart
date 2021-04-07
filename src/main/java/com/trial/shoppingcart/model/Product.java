package com.trial.shoppingcart.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
	
	private String name;
	
	private double cost;
	
	private int quantity;
	
	public Product() {}
	
	public Product(String name, double cost, int quantity) {
		this.name = name;
		this.cost = cost;
		this.setQuantity(quantity);
	}

	public double getCost() {
		return cost;
	}
	
	public double getUnitPrice() {
		double unitPrice = Math.round(cost * 100.0)/100.0;
		return unitPrice;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (name.equals(other.name))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", cost=" + cost + ", quantity=" + quantity + "]";
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

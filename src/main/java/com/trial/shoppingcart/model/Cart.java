package com.trial.shoppingcart.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	
	private Map<String, Product> productsInCart;
	
	private int totalItem;
	
	private CartBill bill;
	
	private static final int ADD_OPERATOR = 1;
	private static final int DELETE_OPERATOR = -1;
	
	public Cart() {
		productsInCart = new HashMap<String, Product>();
		bill = new CartBill();
	}
	
	public Cart(double salesTax) {
		productsInCart = new HashMap<String, Product>();
		bill = new CartBill(salesTax);
	}
	
	public void addProduct(Product productToBeAdded) {
		Product product = null;
		if(productToBeAdded.getQuantity() == 0) {
			return;
		}
		if(productsInCart.containsKey(productToBeAdded.getName())) {
			product = productsInCart.get(productToBeAdded.getName());
		}
		if(product == null || product.getQuantity() == 0) {
			product = productToBeAdded;
			totalItem += productToBeAdded.getQuantity();
		}else {
			product.setQuantity(product.getQuantity() + productToBeAdded.getQuantity());
			totalItem += productToBeAdded.getQuantity();
		}
		productsInCart.put(product.getName(), product);
		bill.updatePayableAmount(productToBeAdded, ADD_OPERATOR);
		
	}
	
	public void removeProduct(Product productToBeRemoved) {

		Product product = null;
		if(productToBeRemoved.getQuantity() == 0) {
			return;
		}
		if(productsInCart.containsKey(productToBeRemoved.getName())) {
			product = productsInCart.get(productToBeRemoved.getName());
		}
		if(product == null || product.getQuantity() == 0) {
			return;
		}else if(product.getQuantity() < productToBeRemoved.getQuantity()) {
			return;
		}
		else {
			product.setQuantity(product.getQuantity() - productToBeRemoved.getQuantity());
			totalItem -= productToBeRemoved.getQuantity();
		}
		productsInCart.put(product.getName(), product);
		bill.updatePayableAmount(productToBeRemoved, DELETE_OPERATOR);
		
	}
	
	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}
	
	public Product getProductFromCart(String productName) {
		if(productsInCart.containsKey(productName)) {
			return productsInCart.get(productName);
		}else {
			return null;
		}
	}
	
	public CartBill getBill() {
		return bill;
	}
	

}

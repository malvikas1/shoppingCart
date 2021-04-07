package com.trial.shoppingcart.model;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CartTest {

	private Cart cartWithSalesTax;
	
	private Cart cart;
	
	private Product dove;
	
	@Before
	public void setup() {
		cartWithSalesTax = new Cart(10);
		cart = new Cart();
		dove = new Product("Dove", 40.0, 1);
	}
	
	@After
	public void tearDown() {
		cartWithSalesTax = null;
		cart = null;
		dove = null;
	}
	
	@Test
	public void addProduct_whenCartIsEmpty_onlyPayableAmountIsOfProduct() {
		cart.addProduct(dove);
		assertEquals(40.0, cart.getBill().getPayableAmount(), 0.00);
	}
	
	@Test
	public void addProduct_whenCartIsEmpty_onlyPayableAmountIsOfProductWithTax() {
		cartWithSalesTax.addProduct(dove);
		assertEquals(44.0, cartWithSalesTax.getBill().getPayableAmount(), 0.00);
	}
	
	@Test
	public void removeProduct_whenCartIsEmpty_doesNothing() {
		cart.removeProduct(dove);
		assertEquals(0.0, cart.getBill().getPayableAmount(), 0.00);
	}
	
	@Test
	public void removeProduct_whenCartWithSalesTaxIsEmpty_doesNothing() {
		cartWithSalesTax.removeProduct(dove);
		assertEquals(0.0, cartWithSalesTax.getBill().getPayableAmount(), 0.00);
	}
	
}

package com.trial.shoppingcart.testingsteps;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.trial.shoppingcart.model.Cart;
import com.trial.shoppingcart.model.CartBill;
import com.trial.shoppingcart.model.Product;

public class Step3 {
	
	private Cart cart;
	
	private Product dove;
	
	private Product axe;
	
	@Before
	public void setUp() {
		cart = new Cart(12.5);
		dove = new Product("Dove", 39.99, 2);
		axe = new Product("Axe", 99.99, 2);
		cart.addProduct(dove);
		cart.addProduct(axe);
	}
	
	@After
	public void tearDown() {
		cart = null;
		dove = null;
		axe = null;
	}
	
	@Test
	public void addProduct_whenProductCheckedIsDove_thenQuantityAndPriceShouldBeAsAssert() {
		
		Product p_dove = cart.getProductFromCart("Dove");
		
		assertEquals(2, p_dove.getQuantity());
		assertEquals(39.99, p_dove.getCost(), 0.00);
	}
	
	@Test
	public void addProduct_whenProductCheckedIsAxe_thenQuantityAndPriceShouldBeAsAssert() {
		
		Product p_axe = cart.getProductFromCart("Axe");
		
		assertEquals(2, p_axe.getQuantity());
		assertEquals(99.99, p_axe.getCost(), 0.00);
	}
	
	@Test
	public void getSalesTaxAmount_whenBothProductsAdded_thenAmountShouldBeAs35() {
		CartBill bill = cart.getBill();
		assertEquals(35.00, bill.getSalesTaxAmount(), 0.00);
	}
	
	@Test
	public void getTotalPayableAmount_whenAllProductsAddedAndTaxApplied_thenAmountShouldBeAsInAssert() {
		assertEquals(314.96, cart.getBill().getPayableAmount(), 0.00);
	}

}

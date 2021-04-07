package com.trial.shoppingcart.testingsteps;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.trial.shoppingcart.model.Cart;
import com.trial.shoppingcart.model.Product;

public class Step1 {
	
	private Cart cart;
	
	private Product dove;
	
	@Before
	public void setUp() {
		cart = new Cart();
		dove = new Product("Dove", 39.99, 5);
		cart.addProduct(dove);
	}
	
	@Test
	public void getItemsInCart_when5DoveAreAdded_thenResultShouldBe5() {
		assertEquals(5, cart.getTotalItem());
		Product p_dove = cart.getProductFromCart("Dove");
		assertEquals(39.99, p_dove.getUnitPrice(), 0.00);
	}
	
	@Test
	public void getPayableAmount_whenAdd5DoveProduct_thenResultShouldBeAsInAssert() {
		assertEquals(199.95, cart.getBill().getPayableAmount(), 0.00);
	}

}

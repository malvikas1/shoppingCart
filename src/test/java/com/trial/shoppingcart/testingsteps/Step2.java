package com.trial.shoppingcart.testingsteps;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.trial.shoppingcart.model.Cart;
import com.trial.shoppingcart.model.Product;

public class Step2 {
	
	private Cart cart;
	
	private Product dove;
	
	private Product dove_reorder;
	
	@Before
	public void setUp() {
		cart = new Cart();
		dove = new Product("Dove", 39.99, 5);
		dove_reorder = new Product("Dove", 39.99, 3);
		cart.addProduct(dove);
		cart.addProduct(dove_reorder);
	}
	
	@Test
	public void getProductQtyAndPricePerUnit_whenAdd3DoveProductWith5AlreadyPresent_thenItemQuantityShouldBe8() {
		assertEquals(8, cart.getTotalItem());
		Product p_dove = cart.getProductFromCart("Dove");
		assertEquals(39.99, p_dove.getUnitPrice(), 0.00);
	}
	
	@Test
	public void getCartTotalPrice_whenAll8ProductsAdded_thenPayableAmountShouldBeAsAssert() {
		assertEquals(319.92, cart.getBill().getPayableAmount(), 0.00);
	}

}

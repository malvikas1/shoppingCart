package com.trial.shoppingcart.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class CartBillTest {
	
	private Product product;
	
	private CartBill cartBill;
	
	private CartBill cartBillWithSTax;
	
	@Before
	public void setUp() {
		product = new Product("Dove", 40d, 2);
		cartBill = new CartBill();
		cartBillWithSTax = new CartBill(10d);
	}
	
	public void tearDown() {
		product = null;
		cartBill = null;
		cartBillWithSTax = null;
	}
	
	@Test
	public void updatePayableAmount_whenCartHasSalesTax_payableAmountShouldAddTaxInBill() {
		cartBillWithSTax.updatePayableAmount(product, 1);
		assertEquals(88.00, cartBillWithSTax.getPayableAmount(), 0.00);
	}
	
	@Test
	public void updatePayableAmount_whenCartHasNoSalesTax_payableAmountShouldNotHaveTax() {
		cartBill.updatePayableAmount(product, 1);
		assertEquals(80.00, cartBill.getPayableAmount(), 0.00);
	}
	
	@Test
	public void updatePayableAmount_whenProductsAreRemovedFromEmptySalesTaxCart_payableAmountShouldRemainZero() {
		cartBillWithSTax.updatePayableAmount(product, -1);
		assertEquals(0.00, cartBillWithSTax.getPayableAmount(), 0.00);
	}
	
	@Test
	public void updatePayableAmount_whenProductsAreRemovedFromEmptyCart_payableAmountShouldRemainZero() {
		cartBill.updatePayableAmount(product, -1);
		assertEquals(0.00, cartBill.getPayableAmount(), 0.00);
	}

}

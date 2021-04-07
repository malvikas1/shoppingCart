package com.trial.shoppingcart.model;


public class CartBill {
	
	private double salesTaxPercent;
	
	private double salesTax;
	
	private double taxableAmount;
	
	private double payableAmount;
	
	public CartBill() {}
	
	public CartBill(double salesTax) {
		this.salesTaxPercent = salesTax;
	}

	public double getSalesTaxPercent() {
		return salesTaxPercent;
	}

	public void setSalesTaxPercent(double salesTax) {
		this.salesTaxPercent = salesTax;
	}
	
	public double getSalesTaxAmount() {
		if(salesTaxPercent != 0) {
			salesTax = (salesTaxPercent * taxableAmount)/100d;
			salesTax = Math.ceil(salesTax * 100.0)/100.0;
			return salesTax;
		}
		return 0d;
	}

	public double getPayableAmount() {
		payableAmount = taxableAmount + getSalesTaxAmount();
		payableAmount = Math.ceil(payableAmount * 100.0)/100.0;
		return payableAmount;
	}

	public void setPayableAmount(double payableAmount) {
		this.payableAmount = payableAmount;
	}
	
	@Override
	public String toString() {
		return "CartBill [salesTaxPercent=" + salesTaxPercent + ", payableAmount=" + payableAmount + "]";
	}

	public void updatePayableAmount(Product productsUpdated, int operator) {
		if(operator == -1 && taxableAmount ==0) {
			return;
		}
		taxableAmount += (operator * productsUpdated.getCost() 
				* productsUpdated.getQuantity());
	}

	public void setTaxableAmount(double taxableAmount) {
		this.taxableAmount = taxableAmount;
	}

}

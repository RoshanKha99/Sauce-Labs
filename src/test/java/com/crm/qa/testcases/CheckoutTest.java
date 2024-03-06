package com.crm.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.CheckOutPage;

public class CheckoutTest extends AddToCartTest {

	CheckOutPage checkout;

	public CheckoutTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		checkout = new CheckOutPage();

	}

	@Test
	public void AddToCartTest1() {
		checkout.checkout(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("firstname"),
				prop.getProperty("lastname"), prop.getProperty("postalcode"));

	}

}

package com.crm.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AddToCart;

public class AddToCartTest extends TestBase {
	AddToCart addtocart;

	public AddToCartTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		addtocart = new AddToCart();

	}

	@Test
	public void AddToCartTest1() {
		addtocart.addtocart(prop.getProperty("username"), prop.getProperty("password"));

	}

}
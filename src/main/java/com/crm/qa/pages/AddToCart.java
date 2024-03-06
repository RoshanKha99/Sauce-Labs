package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class AddToCart extends TestBase {

	@FindBy(id = "user-name")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "login-button")
	WebElement loginBtn;

	@FindBy(xpath = "(//div[@class='inventory_item_price'])[1]")
	WebElement itemprice;

	@FindBy(xpath = "(//div[@class = 'inventory_item_name '])[1]")
	WebElement itemname;

	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement addtocart;

	@FindBy(xpath = "//a[@class = 'shopping_cart_link']")
	WebElement cartlink;

	@FindBy(xpath = "(//div[@class='inventory_item_name'])[1]")
	WebElement bagname;

	@FindBy(xpath = "(//div[@class='inventory_item_price'])[1]")
	WebElement bagprice;

	public AddToCart() {
		PageFactory.initElements(driver, this);
	}

	public void addtocart(String un, String pwd) {

		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		String itemn = itemname.getText();
		String itemp = itemprice.getText();
		addtocart.click();
		cartlink.click();
		String bagn = bagname.getText();
		String bagp = bagprice.getText();

		Assert.assertEquals(itemn, bagn, "Item Prices are NOT equal.");
		System.out.println("Item Prices are equal.");

		Assert.assertEquals(itemp, bagp, "Item Names are NOT equal.");
		System.out.println("Item Names are equal.");

	}

}

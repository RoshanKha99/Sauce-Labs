package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckOutPage extends AddToCart {

	AddToCart ac = new AddToCart();

	@FindBy(id = "checkout")
	WebElement Checkoutbtn;

	@FindBy(id = "first-name")
	WebElement firstname;

	@FindBy(id = "last-name")
	WebElement lastname;

	@FindBy(id = "postal-code")
	WebElement postalcode;

	@FindBy(id = "continue")
	WebElement Continuebtn;
	
	@FindBy(xpath = "//div[normalize-space()='Payment Information']")
	WebElement PayInfo1;
	
	@FindBy(xpath = "//div[normalize-space()='SauceCard #31337']")
	WebElement PayInfo2;
	
	@FindBy(xpath = "//div[normalize-space()='Shipping Information']")
	WebElement ShipInfo1;
	
	@FindBy(xpath = "//div[normalize-space()='Free Pony Express Delivery!']")
	WebElement ShipInfo2;
	
	@FindBy(xpath = "(//div[@class='summary_info_label'])[3]")
	WebElement Price;
	
	@FindBy(xpath = "//div[@class='summary_subtotal_label']")
	WebElement itemtotal;
	
	@FindBy(xpath = "//div[@class='summary_tax_label']")
	WebElement Tax;	
	
	@FindBy(xpath = "(//div[@class='summary_info_label summary_total_label'])")
	WebElement Total;

	@FindBy(id = "finish")
	WebElement finishbtn;

	public CheckOutPage() {
		PageFactory.initElements(driver, this);
	}

	public void checkout(String un, String pwd, String Firstname, String Lastname, String zipcode) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		System.out.println("Logged IN");
		addtocart.click();
		String itemn = itemname.getText();
		String itemp = itemprice.getText();
		cartlink.click();
		System.out.println("Added to cart");

		System.out.println("Cart Link Opened");
		String bagn = bagname.getText();
		String bagp = bagprice.getText();
		Checkoutbtn.click();
		Assert.assertEquals(itemn, bagn, "Item Prices are NOT equal.");
		System.out.println("Item Prices are equal.");

		Assert.assertEquals(itemp, bagp, "Item Names are NOT equal.");
		System.out.println("Item Names are equal.");

		System.out.println("Checkout Button Clicked");
		firstname.sendKeys(Firstname);
		System.out.println("Entered Roshan as Frist name");
		lastname.sendKeys(Lastname);
		System.out.println("Entered Khapekar as Last name");
		postalcode.sendKeys(zipcode);
		System.out.println("Zipcode Entered");
		Continuebtn.click();
		System.out.println("Continue button clicked");
		System.out.println(PayInfo1.getText());
		System.out.println(PayInfo2.getText());
		System.out.println(ShipInfo1.getText());
		System.out.println(ShipInfo2.getText());
		System.out.println(Price.getText());
		System.out.println(itemtotal.getText());
		System.out.println(Tax.getText());
		finishbtn.click();
		System.out.println("Completed");
	}

}
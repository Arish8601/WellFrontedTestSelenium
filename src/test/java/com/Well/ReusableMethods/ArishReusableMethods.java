package com.Well.ReusableMethods;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.zaproxy.clientapi.core.ClientApiException;

import com.Well.Engine.ArishBaseClass;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ArishReusableMethods extends ArishBaseClass {
	
	public void Login() throws IOException, InterruptedException, ClientApiException {
		
//	  testlog.info("Given User navigate to Wellcertified page");
//	  CommonMethod.sendKeys("ArishUsername", "student");
//	  CommonMethod.sendKeys("ArishPassword", "Password123");
//	  CommonMethod.findElement("ArishSubmit").click();
//	  String actualLoginSuccessfulText=CommonMethod.getText("ArishSuccessfullyLoginText");
//	  String expectedLoginSuccessfulText = "Logged In Successfully";
//	  CommonMethod.assertActualContainsExpected(actualLoginSuccessfulText.toLowerCase(), 
//	  expectedLoginSuccessfulText.toLowerCase());
//	  System.out.println(actualLoginSuccessfulText);
//	  System.out.println("*** Successfully Logged In ***");
	  }
	
	public void endToEndTestCase() throws IOException, InterruptedException, ClientApiException {

	    System.out.println("endToEndTestCase");
	    
	    // Get all products
	    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishGetAllProductsAddToCartButton", 0);
	    List<WebElement> products = CommonMethod.findElements("ArishGetAllProductsAddToCartButton");

        for (int i = 0; i < products.size(); i++) {
           // Click ADD TO CART
           products.get(i).click();
           if(i==3) {
        	   System.out.println(+i+1+" Product Added in Cart Successfully: ");
        	   break;
           }
        }
	    // Open Cart
        CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishOpenCart", 0);
	    CommonMethod.click("ArishOpenCart");

	    // Checkout
	    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishCartCheckOut", 0);
	    CommonMethod.click("ArishCartCheckOut");

	    // Apply Promo
	    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishAddPromoCode", 0);
	    CommonMethod.sendKeys("ArishAddPromoCode", "rahulshettyacademy");

	    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishClickPromoCodeApplyBtn", 0);
	    CommonMethod.click("ArishClickPromoCodeApplyBtn");

	    // Place Order
	    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishClickPlaceOrderBtn", 0);
	    CommonMethod.click("ArishClickPlaceOrderBtn");

	    // Select Country
	    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishSelectCountry", 0);
	    CommonMethod.selectdropdownValue("ArishSelectCountry", "India");

	    // Agree Checkbox
	    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishAgreeCheckBox", 0);
	    CommonMethod.click("ArishAgreeCheckBox");

	    // Proceed
	    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishClickProceedBtn", 0);
	    CommonMethod.click("ArishClickProceedBtn");
	    
	    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishSuccessfulMsg", 0);
	    String actualText = CommonMethod.getText("ArishSuccessfulMsg").toLowerCase();
	    System.out.println("Actual Text: "+actualText);
	    String expectedText = "your order has been placed successfully".toLowerCase();
	    CommonMethod.assertActualContainsExpected(actualText, expectedText);
	}
	
	
	public void placeOrderOfAboveHunderedRupees() throws IOException, InterruptedException, ClientApiException {

	    System.out.println("placeOrderOfAboveHunderedRupees");
	    
	    CommonMethod.openNewTab("https://rahulshettyacademy.com/seleniumPractise/#/");
	    // Get all products
	    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishGetAllProductsPrice", 0);
	    List<WebElement> products = CommonMethod.findElements("ArishGetAllProductsPrice");

        int amount = 100;

        for (int i = 0; i < products.size(); i++) {

        	String priceText = products.get(i).getText();
        	int price = Integer.parseInt(priceText);

            if (price > amount) {

                System.out.println("Adding product in cart for above 100 Rs: " + price);
                // Click ADD TO CART   
                driver.findElement(By.xpath("//p[text()='" + price + "']//parent::div//button")).click();             
            }
        }
	    // Open Cart
        CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishOpenCart", 0);
	    CommonMethod.click("ArishOpenCart");
	    Thread.sleep(10000);

	    // Checkout
	    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishCartCheckOut", 0);
	    CommonMethod.click("ArishCartCheckOut");

	    // Apply Promo
	    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishAddPromoCode", 0);
	    CommonMethod.sendKeys("ArishAddPromoCode", "rahulshettyacademy");

	    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishClickPromoCodeApplyBtn", 0);
	    CommonMethod.click("ArishClickPromoCodeApplyBtn");

	    // Place Order
	    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishClickPlaceOrderBtn", 0);
	    CommonMethod.click("ArishClickPlaceOrderBtn");

	    // Select Country
	    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishSelectCountry", 0);
	    CommonMethod.selectdropdownValue("ArishSelectCountry", "India");

	    // Agree Checkbox
	    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishAgreeCheckBox", 0);
	    CommonMethod.click("ArishAgreeCheckBox");

	    // Proceed
	    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishClickProceedBtn", 0);
	    CommonMethod.click("ArishClickProceedBtn");
	    
	    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishSuccessfulMsg", 0);
	    String actualText = CommonMethod.getText("ArishSuccessfulMsg").toLowerCase();
	    System.out.println("Actual Text: "+actualText);
	    String expectedText = "your order has been placed successfully".toLowerCase();
	    CommonMethod.assertActualContainsExpected(actualText, expectedText);
	}



public void placeOrderOfLastTwoProducts() throws IOException, InterruptedException, ClientApiException {

    System.out.println("placeOrderOfLastTwoProducts");
    
    CommonMethod.openNewTab("https://rahulshettyacademy.com/seleniumPractise/#/");
    // Get all products
    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishGetAllProductsPrice", 0);
    List<WebElement> products = CommonMethod.findElements("ArishGetAllProductsPrice");
    List<WebElement> addToCartBtn = CommonMethod.findElements("ArishGetAllProductsAddToCartButton");
    
    int amt = 75;

    for (int i=0; i<products.size(); i++) {

        String productName = products.get(i).getText();
        int p = Integer.parseInt(productName.replaceAll("₹", ""));

        if (p == amt) {

            addToCartBtn.get(i).click();

            System.out.println(p + " added to cart");
           
        } 
    }
    
    // Open Cart
    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishOpenCart", 0);
    CommonMethod.click("ArishOpenCart");
    Thread.sleep(10000);

    // Checkout
    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishCartCheckOut", 0);
    CommonMethod.click("ArishCartCheckOut");

    // Apply Promo
    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishAddPromoCode", 0);
    CommonMethod.sendKeys("ArishAddPromoCode", "rahulshettyacademy");

    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishClickPromoCodeApplyBtn", 0);
    CommonMethod.click("ArishClickPromoCodeApplyBtn");

    // Place Order
    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishClickPlaceOrderBtn", 0);
    CommonMethod.click("ArishClickPlaceOrderBtn");

    // Select Country
    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishSelectCountry", 0);
    CommonMethod.selectdropdownValue("ArishSelectCountry", "India");

    // Agree Checkbox
    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishAgreeCheckBox", 0);
    CommonMethod.click("ArishAgreeCheckBox");

    // Proceed
    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishClickProceedBtn", 0);
    CommonMethod.click("ArishClickProceedBtn");
    
    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishSuccessfulMsg", 0);
    String actualText = CommonMethod.getText("ArishSuccessfulMsg").toLowerCase();
    System.out.println("Actual Text: "+actualText);
    String expectedText = "your order has been placed successfully".toLowerCase();
    CommonMethod.assertActualContainsExpected(actualText, expectedText);
}



public void placeOrderWhosePriceExactSeventyFive() throws IOException, InterruptedException, ClientApiException {

    System.out.println("placeOrderWhosePriceExactSeventyFive");
    
    CommonMethod.openNewTab("https://rahulshettyacademy.com/seleniumPractise/#/");
    // Get all products
    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishGetAllProductsPrice", 0);
    List<WebElement> products = CommonMethod.findElements("ArishGetAllProductsPrice");
    List<WebElement> addToCartBtn = CommonMethod.findElements("ArishGetAllProductsAddToCartButton");
    int c = 0;

    for (int i = products.size() - 1; i >= 0; i--) {

        String productName = products.get(i).getText();

        if (c < 2) {

            addToCartBtn.get(i).click();

            System.out.println(productName + " added to cart");

            c++;
        } 
        else {
            break;
        }
    }
    // Open Cart
    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishOpenCart", 0);
    CommonMethod.click("ArishOpenCart");
    Thread.sleep(10000);

    // Checkout
    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishCartCheckOut", 0);
    CommonMethod.click("ArishCartCheckOut");

    // Apply Promo
    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishAddPromoCode", 0);
    CommonMethod.sendKeys("ArishAddPromoCode", "rahulshettyacademy");

    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishClickPromoCodeApplyBtn", 0);
    CommonMethod.click("ArishClickPromoCodeApplyBtn");

    // Place Order
    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishClickPlaceOrderBtn", 0);
    CommonMethod.click("ArishClickPlaceOrderBtn");

    // Select Country
    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishSelectCountry", 0);
    CommonMethod.selectdropdownValue("ArishSelectCountry", "India");

    // Agree Checkbox
    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishAgreeCheckBox", 0);
    CommonMethod.click("ArishAgreeCheckBox");

    // Proceed
    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishClickProceedBtn", 0);
    CommonMethod.click("ArishClickProceedBtn");
    
    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ArishSuccessfulMsg", 0);
    String actualText = CommonMethod.getText("ArishSuccessfulMsg").toLowerCase();
    System.out.println("Actual Text: "+actualText);
    String expectedText = "your order has been placed successfully".toLowerCase();
    CommonMethod.assertActualContainsExpected(actualText, expectedText);
}
}

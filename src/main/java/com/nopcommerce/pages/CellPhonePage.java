package com.nopcommerce.pages;

import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.By;

public class CellPhonePage extends Utility {
    //Verify text cell phones
    By verifyCellPhoneText = By.xpath("//h1[normalize-space()='Cell phones']");
    //Click on list view tab
    By clickOnListView = By.xpath("//a[normalize-space()='List']");
    // Click on product name “Nokia Lumia 1020” link
    By ProductName = By.xpath("//h1[normalize-space()='Nokia Lumia 1020']");
    //Verify the price “$349.00”
    By verifyPrice = By.xpath("//div[@class='product-price']//span[normalize-space()='$349.00']");
    //Update quantity
    By updateQuantity = By.xpath("//input[@id='product_enteredQuantity_20']");
    //Click add to cart
    By addToCart = By.xpath("//button[@id='add-to-cart-button-20']");
    //Verify text
    By verifySuccessfulText = By.xpath("//div[@id='bar-notification']");
    //Close bar clicking on cross
    By closeNotificationBar = By.xpath("//span[@title='Close']");

    public String verifyCellPhoneText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(verifyCellPhoneText);
    }


    public void clickOnListViewIcon(){
        clickOnElement(clickOnListView);
    }


    public void selectPhoneFromList(String phone) throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'"+phone+"')]"));
    }

    public String getProductNameText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(ProductName);
    }

    //Verify price
    public String getPriceText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(verifyPrice);
    }
    public void updateQuantity(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(updateQuantity,value);
    }
//Click on add to cart
    public void clickOnAddToCart() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(addToCart);
    }
//Successfully added to cart
    public String getSuccessfulAddedToCartText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(verifySuccessfulText);
    }

    public void closeNotificationBar() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(closeNotificationBar);
    }

}

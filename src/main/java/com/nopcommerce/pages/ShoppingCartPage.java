package com.nopcommerce.pages;

import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.By;

public class ShoppingCartPage extends Utility {
    By verifyShoppingCartText = By.xpath("//h1[normalize-space()='Shopping cart']");
    By verifyPrice = By.xpath("//span[@class='value-summary']//strong");
    By changeQuantity = By.xpath("//input[contains(@id,'itemquantity')]");
    By updateShoppingCart = By.xpath("//button[@id='updatecart']");
    By termsAndConditions = By.xpath("//input[@id='termsofservice']");
    By clickOnCheckOut = By.xpath("//button[@id='checkout']");
    By hoverOnShoppingCart =By.xpath("//span[@class='cart-label']");
    By goToCart =By.xpath("//button[normalize-space()='Go to cart']");
    By quantityValue =By.xpath("//input[contains(@id,'itemquantity')]");


    public String getShoppingCartText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(verifyShoppingCartText);
    }

    public String getPriceText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(verifyPrice);
    }


    public void changeValueOfQuantity(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(changeQuantity,value);
    }

    public void updateShoppingCart() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(updateShoppingCart);
    }

    public void selectTermsAndCondition() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(termsAndConditions);
    }

    public void clickOnCheckOut() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(clickOnCheckOut);
    }


    public void mouseHoverToShoppingCart() throws InterruptedException {
        Thread.sleep(1000);
        mouseHoverToElement(hoverOnShoppingCart);
    }


    public void mouseHoverToGoToCardAndClick() throws InterruptedException {
        Thread.sleep(1000);
        mouseHoverToElementAndClick(goToCart);
    }


    public String getNumberOfQuantityValue() throws InterruptedException {
        Thread.sleep(1000);
        return getAttributeValueFromElement(quantityValue);
    }


}

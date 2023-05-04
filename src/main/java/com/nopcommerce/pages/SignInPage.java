package com.nopcommerce.pages;

import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.By;

public class SignInPage extends Utility {
    By welcomeText = By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]");

    By guestCheckout = By.xpath("//button[normalize-space()='Checkout as Guest']");

    By registerButton = By.xpath("//button[contains(text(),'Register')]");

    public String getWelcomeText(){
        return getTextFromElement(welcomeText);
    }

    public void clickOnGuestCheckout(){
        clickOnElement(guestCheckout);
    }
    public void clickOnRegister() {
        clickOnElement(registerButton);
    }


}

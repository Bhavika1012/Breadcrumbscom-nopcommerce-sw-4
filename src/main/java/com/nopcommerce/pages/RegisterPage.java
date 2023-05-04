package com.nopcommerce.pages;

import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.By;

public class RegisterPage extends Utility {
    By firstName = By.xpath("//input[@id='FirstName']");
    By lastName = By.xpath("//input[@id='LastName']");
    By email = By.xpath("//input[@id='Email']");
    By password = By.xpath("//input[@id='Password']");
    By confirmPassword = By.xpath("//input[@id='ConfirmPassword']");
    By registerButton = By.xpath("//button[@id='register-button']");
    By registrationCompleted = By.xpath("//div[@class='result']");

    public void enterFirstname(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(firstName,value);
    }


    public void enterLastname(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(lastName,value);
    }


    public void enterEmail(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(email,value);
    }

    public void enterPassword(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(password,value);
    }

    public void enterConfirmPassword(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(confirmPassword,value);
    }

    public void clickOnRegisterButton() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(registerButton);
    }

    public String verifyRegistrationCompletedText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(registrationCompleted);
    }

}

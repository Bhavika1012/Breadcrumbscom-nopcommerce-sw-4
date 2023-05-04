package com.nopcommerce.pages;

import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.By;

public class CheckoutPage extends Utility {
    //Mandatory details
    By firstName = By.xpath("//input[@id='BillingNewAddress_FirstName']");
    By lastName = By.xpath("//input[@id='BillingNewAddress_LastName']");
    By email = By.xpath("//input[@id='BillingNewAddress_Email']");
    By country = By.xpath("//select[@id='BillingNewAddress_CountryId']");
    By city = By.xpath("//input[@id='BillingNewAddress_City']");
    By address = By.xpath("//input[@id='BillingNewAddress_Address1']");
    By zipCode = By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
    By phoneNumber = By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");
    By continueButton = By.xpath("//button[@onclick='Billing.save()']");
    By shippingContinueButton = By.xpath("//button[@class='button-1 shipping-method-next-step-button']");
    By paymentContinueButton = By.xpath("//button[@class='button-1 payment-method-next-step-button']");
    By paymentInfoButton = By.xpath("//button[@class='button-1 payment-info-next-step-button']");
    By nextDayAirRadioButton = By.xpath("//input[@id='shippingoption_1']");
    By creditCard = By.xpath("//input[@id='paymentmethod_1']");
    By creditCardType = By.xpath("//select[@id='CreditCardType']");
    By cardHolderName = By.xpath("//input[@id='CardholderName']");
    By cardNumber = By.xpath("//input[@id='CardNumber']");
    By selectMonth = By.xpath("//select[@id='ExpireMonth']");
    By selectYear = By.xpath("//select[@id='ExpireYear']");
    By cardCode = By.xpath("//input[@id='CardCode']");
    By verifyCreditCardText = By.xpath("//span[normalize-space()='Credit Card']");
    By verifyShippingMethodText = By.xpath("//span[normalize-space()='Next Day Air']");
    By verifyTotal = By.xpath("//span[@class='product-subtotal']");
    By confirmButton = By.xpath("//button[normalize-space()='Confirm']");
    By thankYouText = By.xpath("//h1[contains(text(),'Thank you')]");
    By orderSuccessMessage = By.xpath("//div[@class='section order-completed']/div[@class='title']/strong");


    //Enter first name
    public void enterFirstname(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(firstName,value);
    }

    //enter last name
    public void enterLastname(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(lastName,value);
    }

    //enter email
    public void enterEmail(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(email,value);
    }

    //select country
    public void selectCountry(String value) throws InterruptedException {
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(country,value);
    }

    public void enterCity(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(city,value);
    }

    public void enterAddress1(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(address,value);
    }

    public void enterZipCode(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(zipCode,value);
    }

    public void enterPhoneNumber(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(phoneNumber,value);
    }

    public void clickOnContinue() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(continueButton);
    }

    public void selectNextDayAir() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(nextDayAirRadioButton);
    }

    public void clickOnShippingContinue() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(shippingContinueButton);
    }

    public void clickOnCreditCard() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(creditCard);
    }

    public void clickOnPaymentContinue() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(paymentContinueButton);
    }

    public void selectCreditCardType(String value) throws InterruptedException {
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(creditCardType,value);
    }

    public void enterCardHolderName(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(cardHolderName,value);
    }

    public void enterCardNumber(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(cardNumber,value);
    }

    public void selectExpirationDate(String month,String year) throws InterruptedException {
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(selectMonth,month);
        selectByVisibleTextFromDropDown(selectYear,year);
    }

    public void enterCVV(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(cardCode,value);
    }


    public String getPaymentTypeText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(verifyCreditCardText);
    }
//verify shipping method text
    public String getShippingMethodText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(verifyShippingMethodText);
    }

    //verify total price
    public String getTotalPriceText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(verifyTotal);
    }

  //Click on confirm button
    public void clickOnConfirm() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(confirmButton);
    }

    //Click on payment info
    public void clickOnPaymentInfoContinue() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(paymentInfoButton);
    }

    public String getTextThankYou() throws InterruptedException {
        Thread.sleep(2000);
        return getTextFromElement(thankYouText);
    }

    public String getTextOrderSuccessfullyPlaced() {
        return getTextFromElement(orderSuccessMessage);
    }


}

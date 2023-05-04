package com.nopcommerce.testsuite;

import com.nopcommerce.pages.*;
import com.nopcommerce.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite extends BaseTest {
    HomePage homePage = new HomePage();
    ComputersPage computersPage = new ComputersPage();
    BuildYourOwnComputerPage buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    SignInPage signInPage = new SignInPage();

    CheckoutPage checkoutPage = new CheckoutPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        //1.1 Click on Computer Menu.
        homePage.hoverOnComputer();
        //1.2 Click on Desktop
        homePage.clickOnDesktop();
        //1.3 Select Sort By position "Name: Z to A"
        String actualOrder = computersPage.sortDesktopByPositionZtoA().toString();
        String ExceptedOrder = computersPage.getAllProductNames().toString();
        Assert.assertTrue(ExceptedOrder.contains(actualOrder));

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        homePage.hoverOnComputer();
        //2.2 Click on Desktop
        computersPage.clickOnDesktop();
        //2.3 Select Sort By position "Name: A to Z"
        computersPage.selectValueDropDown("Name: A to Z");
        //2.4 Click on "Add To Cart"
        computersPage.clickAddToCartByProductName("Build your own computer");
        //2.5 Verify the Text "Build your own computer"
        String expectedMessage = "Build your own computer";
        String actualMessage = buildYourOwnComputerPage.getBuildYourOwnComputerText();
        Assert.assertEquals(expectedMessage, actualMessage, "Unable to click on add to card");
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        buildYourOwnComputerPage.selectProcessor("2.2 GHz Intel Pentium Dual-Core E2200");
        //2.7.Select "8GB [+$60.00]" using Select class.
        buildYourOwnComputerPage.selectRam("8GB [+$60.00]");
        //2.8 Select HDD radio "400 GB [+$100.00]"
        buildYourOwnComputerPage.selectHDD("400 GB [+$100.00]");
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        buildYourOwnComputerPage.selectOs("Vista Premium");
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        buildYourOwnComputerPage.selectMicrosoftOfficeSoftwareOption();
        buildYourOwnComputerPage.selectTotalCommanderSoftwareOption();
        //2.11 Verify the price "$1,475.00"
        expectedMessage = "$1,475.00";
        actualMessage = buildYourOwnComputerPage.getTotalPriceText();
        Assert.assertEquals(expectedMessage, actualMessage, "Wrong Configuration");
        //2.12 Click on "ADD TO CARD" Button.
        buildYourOwnComputerPage.clickOnAddToCart();
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        expectedMessage = "The product has been added to your shopping cart";
        actualMessage = buildYourOwnComputerPage.verifySuccessfullyAddedToCartText();
        Assert.assertEquals(expectedMessage, actualMessage, "Not added in cart");
        //After that close the bar clicking on the cross button.
        buildYourOwnComputerPage.closeNotificationBar();
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        buildYourOwnComputerPage.mouseHoverToShoppingCartAndClickOnCart();
        //2.15 Verify the message "Shopping cart"
        expectedMessage = "Shopping cart";
        actualMessage = shoppingCartPage.getShoppingCartText();
        Assert.assertEquals(expectedMessage, actualMessage, "Unable to click on cart");
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        shoppingCartPage.changeValueOfQuantity("2");
        shoppingCartPage.updateShoppingCart();
        //2.17 Verify the Total"$2,950.00"
        expectedMessage = "$2,950.00";
        actualMessage = shoppingCartPage.getPriceText();
        Assert.assertEquals(expectedMessage, actualMessage, "Price not Updated");
        //2.18 click on checkbox “I agree with the terms of service”
        shoppingCartPage.selectTermsAndCondition();
        shoppingCartPage.clickOnCheckOut();
        //2.19 Click on “CHECKOUT”
        signInPage.clickOnGuestCheckout();
        //2.20 Verify the Text “Welcome, Please Sign In!”
        expectedMessage = "Welcome, Please Sign In!";
        actualMessage = signInPage.getWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage, "Unable to checkout");
        //2.22 Fill the all mandatory field
        checkoutPage.enterFirstname("John");
        checkoutPage.enterLastname("Smith");
        checkoutPage.enterEmail("johnsmith@gmail.com");
        checkoutPage.selectCountry("United Kingdom");
        checkoutPage.enterCity("London");
        checkoutPage.enterAddress1("101 East Lane");
        checkoutPage.enterZipCode("NW1 6YZ");
        checkoutPage.enterPhoneNumber("07857485478");
        //2.23 Click on “CONTINUE”
        checkoutPage.clickOnContinue();
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        checkoutPage.selectNextDayAir();
        //2.25 Click on “CONTINUE”
        checkoutPage.clickOnShippingContinue();
        //2.26 Select Radio Button “Credit Card”
        checkoutPage.clickOnCreditCard();
        checkoutPage.clickOnPaymentContinue();
        //2.27 Select “Master card” From Select credit card dropdown
        checkoutPage.selectCreditCardType("Master card");
        //2.28 Fill all the details
        checkoutPage.enterCardHolderName("John Smith");
        checkoutPage.enterCardNumber("1111222233334444");
        checkoutPage.selectExpirationDate("01","2026");
        //2.29 Click on “CONTINUE”
        checkoutPage.enterCVV("123");
        checkoutPage.clickOnPaymentInfoContinue();
        //2.30 Verify “Payment Method” is “Credit Card”
        expectedMessage = "Credit Card";
        actualMessage = checkoutPage.getPaymentTypeText();
        Assert.assertEquals(expectedMessage, actualMessage, "Unable to checkout");
        //2.32 Verify “Shipping Method” is “Next Day Air”
        expectedMessage = "Next Day Air";
        actualMessage = checkoutPage.getShippingMethodText();
        Assert.assertEquals(expectedMessage, actualMessage, "Unable to checkout");
        //2.33 Verify Total is “$2,950.00”
        expectedMessage = "$2,950.00";
        actualMessage = checkoutPage.getTotalPriceText();
        Assert.assertEquals(expectedMessage, actualMessage, "Unable to checkout");
        //2.34 Click on “CONFIRM”
        checkoutPage.clickOnConfirm();
        //2.35 Verify the Text “Thank You”
        expectedMessage = "Thank you";
        actualMessage = checkoutPage.getTextThankYou();
        //2.36 Verify the message “Your order has been successfully processed!”
        Assert.assertEquals(expectedMessage, actualMessage, "Unable to checkout");
        expectedMessage = "Your order has been successfully processed!";
        actualMessage = checkoutPage.getTextOrderSuccessfullyPlaced();
        Assert.assertEquals(expectedMessage, actualMessage, "Unable to checkout");
        //2.37 Click on “CONTINUE”
        checkoutPage.clickOnContinue();
        //2.37 Verify the text “Welcome to our store”
        expectedMessage = "Welcome to our store";
        actualMessage = homePage.verifyWelcomeToOurStoreText();
        Assert.assertEquals(expectedMessage, actualMessage, "Unable to checkout");

    }


}

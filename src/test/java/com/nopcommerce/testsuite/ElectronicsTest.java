package com.nopcommerce.testsuite;

import com.nopcommerce.pages.*;
import com.nopcommerce.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElectronicsTest extends BaseTest {
    String email;
    HomePage homePage = new HomePage();
    CellPhonePage cellPhonePage = new CellPhonePage();

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    SignInPage signInPage = new SignInPage();

    RegisterPage registerPage = new RegisterPage();

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {
        //1.1 Mouse Hover on “Electronics” Tab
        homePage.hoverOnElectronicsTab();
        //1.2 Mouse Hover on “Cell phones” and click
        homePage.clickOnCellPhonesTab();
        //1.3 Verify the text “Cell phones”
        String expectedMessage = "Cell phones";
        String actualMessage = cellPhonePage.verifyCellPhoneText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        homePage.hoverOnElectronicsTab();
        //2.2 Mouse Hover on “Cell phones” and click
        homePage.clickOnCellPhonesTab();
        //2.3 Verify the text “Cell phones”
        String expectedMessage = "Cell phones";
        String actualMessage = cellPhonePage.verifyCellPhoneText();
        Assert.assertEquals(expectedMessage, actualMessage);
        //2.4 Click on List View Tab
        cellPhonePage.clickOnListViewIcon();
        //2.5 Click on product name “Nokia Lumia 1020” link
        cellPhonePage.selectPhoneFromList("Nokia Lumia 1020");
        //2.6 Verify the text “Nokia Lumia 1020”
        expectedMessage = "Nokia Lumia 1020";
        actualMessage = cellPhonePage.getProductNameText();
        Assert.assertEquals(expectedMessage, actualMessage);
        //2.7 Verify the price “$349.00”
        expectedMessage = "$349.00";
        actualMessage = cellPhonePage.getPriceText();
        Assert.assertEquals(expectedMessage, actualMessage);
        //2.8 Change quantity to 2
        cellPhonePage.updateQuantity("2");
        //2.9 Click on “ADD TO CART” tab
        cellPhonePage.clickOnAddToCart();
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        expectedMessage = "The product has been added to your shopping cart";
        actualMessage = cellPhonePage.getSuccessfulAddedToCartText();
        Assert.assertEquals(actualMessage, expectedMessage);
        //After that close the bar clicking on the cross button.
        cellPhonePage.closeNotificationBar();
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        shoppingCartPage.mouseHoverToShoppingCart();
        shoppingCartPage.mouseHoverToGoToCardAndClick();
        //2.12 Verify the message "Shopping cart"
        expectedMessage = "Shopping cart";
        actualMessage = shoppingCartPage.getShoppingCartText();
        Assert.assertEquals(actualMessage, expectedMessage);
        //2.13 Verify the quantity is 2
        //expected and actual not matching
        expectedMessage = "2";
        actualMessage = shoppingCartPage.getNumberOfQuantityValue();
        Assert.assertEquals(actualMessage, expectedMessage);
        //2.14 Verify the Total $698.00
        expectedMessage = "$698.00";
        actualMessage = shoppingCartPage.getPriceText();
        Assert.assertEquals(actualMessage, expectedMessage);
        //2.15 click on checkbox “I agree with the terms of service”
        shoppingCartPage.selectTermsAndCondition();
        //2.16 Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckOut();
        //2.17 Verify the Text “Welcome, Please Sign In!”
        expectedMessage = "Welcome, Please Sign In!";
        actualMessage = signInPage.getWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage);
        //2.18 Click on “REGISTER” tab
        signInPage.clickOnRegister();
        //2.20 Fill the mandatory fields
        registerPage.enterFirstname("John");
        registerPage.enterLastname("Smith");
        registerPage.enterEmail(email);
        registerPage.enterPassword("Jsmith123!");
        registerPage.enterConfirmPassword("Jsmith123!");
        //2.21 Click on “REGISTER” Button
        registerPage.clickOnRegisterButton();
        //2.22 Verify the message “Your registration completed”
        expectedMessage = "Your registration completed";
        actualMessage = registerPage.verifyRegistrationCompletedText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }
}

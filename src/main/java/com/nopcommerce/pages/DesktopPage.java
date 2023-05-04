package com.nopcommerce.pages;

import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.By;

public class DesktopPage extends Utility {
    By sortBy = By.xpath("//select[@id='products-orderby']");
    By addToCartButton = By.xpath("//div[@data-productid='1']//button[text()='Add to cart']");

    public void selectSortByZtoA() {
        selectByVisibleTextFromDropDown(sortBy, "Name: Z to A");
    }

    public void selectSortByAtoZ() {
        selectByVisibleTextFromDropDown(sortBy, "Name: A to Z");
    }

    public void addToCart() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(addToCartButton);
    }
}

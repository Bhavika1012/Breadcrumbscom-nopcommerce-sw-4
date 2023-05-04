package com.nopcommerce.pages;

import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputersPage extends Utility {
    By desktopOption = By.xpath("//ul[@class='top-menu notmobile']//a[text()='Desktops ']");

    By sortFilter = By.xpath("//select[@id='products-orderby']");


    public void clickOnDesktop() {
        mouseHoverToElementAndClick(desktopOption);
    }

    public void selectValueDropDown(String text) throws InterruptedException {
        Thread.sleep(1000);
        WebElement dropDown = driver.findElement(sortFilter);
        Select select = new Select(dropDown);
        // Select by visible text
        select.selectByVisibleText(text);
        Thread.sleep(1000);
    }

    public void clickAddToCartByProductName(String productName) throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(By.xpath("(//h2//a[normalize-space()='" + productName + "']//following::button)[1]"));
    }

    public List<String> sortDesktopByPositionZtoA() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> beforeSortValue = driver.findElements(By.xpath("//h2[@class='product-title']//a"));
        List<String> beforeSortDesktopValue = new ArrayList<>();
        for (WebElement value : beforeSortValue) {
            beforeSortDesktopValue.add(value.getText());
        }
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
        Thread.sleep(2000);
        waitUntilVisibilityOfElementLocated(By.xpath("//div[@class='picture']//img"), 5);

        // After shorting value
        List<WebElement> afterSortValue = driver.findElements(By.xpath("//h2[@class='product-title']//a"));
        List<String> afterSortDesktopValue = new ArrayList<>();

        for (WebElement value1 : afterSortValue) {
            afterSortDesktopValue.add(value1.getText());
        }
        // Ascending order
        Collections.sort(beforeSortDesktopValue);
        //descending order
        Collections.reverse(beforeSortDesktopValue);

        return beforeSortDesktopValue;
    }

    public List<String> getAllProductNames() {
        waitUntilVisibilityOfElementLocated(By.xpath("//div[@class='picture']//img"), 5);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
        waitUntilVisibilityOfElementLocated(By.xpath("//div[@class='picture']//img"), 5);

        // After sorting value
        List<WebElement> afterSortValue = driver.findElements(By.xpath("//h2[@class='product-title']//a"));
        List<String> afterSortDesktopValue = new ArrayList<>();

        for (WebElement value1 : afterSortValue) {
            afterSortDesktopValue.add(value1.getText());
        }
        return afterSortDesktopValue;
    }
}

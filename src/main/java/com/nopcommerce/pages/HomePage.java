package com.nopcommerce.pages;

import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {
    By headerMenu = By.xpath("//div[@class = 'header-menu']/ul/li");
    By computerTab = By.xpath("//ul[@class='top-menu notmobile']/li/a[text()='Computers ']");
    By desktopOption = By.xpath("//ul[@class='top-menu notmobile']//a[text()='Desktops ']");
    By verifyWelcomeToStoreText = By.xpath("//div[@class='topic-block-title']/h2");
    By electronicsTab = By.xpath("//ul[@class='top-menu notmobile']/li/a[text()='Electronics ']");
    By cellPhonesTab = By.xpath("//ul[@class='top-menu notmobile']/li/ul[@class='sublist first-level']/li/a[text()='Cell phones ']");
    By pageTitle = By.xpath("//div[@class='page-title']");

    public String getTitleOfPage() {
        return getTextFromElement(pageTitle);
    }

    public void selectMenu(String menu) {
        List<WebElement> menuList = driver.findElements(headerMenu);
        try {
            //loop through list with for loop
            for (WebElement menuOption : menuList) {
                System.out.println(menuOption.getText());
                //if the option matches with the parameter then click
                if (menuOption.getText().equals(menu)) {
                    menuOption.click();
                }
            }
            //catch exceptions
        } catch (StaleElementReferenceException e) {
            menuList = driver.findElements(headerMenu);
        }
    }

    public void hoverOnComputer() {
        mouseHoverToElement(computerTab);
    }

    public void hoverOnElectronicsTab() {
        mouseHoverToElement(electronicsTab);
    }

    public void clickOnCellPhonesTab() {
        clickOnElement(cellPhonesTab);
    }

    public void clickOnDesktop() {
        mouseHoverToElementAndClick(desktopOption);
    }

    public String verifyWelcomeToOurStoreText() {
        return getTextFromElement(verifyWelcomeToStoreText);
    }

}

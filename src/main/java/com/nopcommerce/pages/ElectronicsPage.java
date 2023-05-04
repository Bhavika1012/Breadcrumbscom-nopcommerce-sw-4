package com.nopcommerce.pages;

import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.By;

public class ElectronicsPage extends Utility {
    By books = By.xpath("//h1[contains(text(),'Books')]");
    By electronicsTabText = By.xpath("//h1[normalize-space()='Electronics']");
    public String getElectronicsHeaderText(){
        return getTextFromElement(electronicsTabText);
    }


}

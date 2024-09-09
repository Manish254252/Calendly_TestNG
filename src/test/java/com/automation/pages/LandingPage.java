package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {
    @FindBy(xpath = "//ul[@id='right-side-components']//a[contains(@class,'button-link') and @data-testid='login-header']")
    WebElement loginLink;

    public void openWebsite() {
        driver.get("https://calendly.com/");
    }

    public void clickOnLoginLink() {
        loginLink = driver.findElement(By.xpath("//ul[@id='right-side-components']//a[contains(@class,'button-link') and @data-testid='login-header']"));
        waitUntilElementVisible( loginLink);
        loginLink.click();
    }

    public boolean isLandingPageDisplayed() {
        return loginLink.isDisplayed();
    }
}

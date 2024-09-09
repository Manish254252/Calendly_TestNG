package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {
    @FindBy(xpath = "//ul[@id='right-side-components']//a[contains(@class,'button-link') and @data-testid='login-header']")
    WebElement loginLink;

    @FindBy(xpath = "//ul[@id='right-side-components']//span[text()='Get started']")
    WebElement getStartedBtn;

    @FindBy(xpath = "//img[@alt='Calendly logo']")
    WebElement logoImg;

    public void openWebsite() {
        driver.get("https://calendly.com/");
    }

    public void clickOnLoginLink() {
        try{
            loginLink = driver.findElement(By.xpath("//ul[@id='right-side-components']//a[contains(@class,'button-link') and @data-testid='login-header']"));
            waitUntilElementVisible( loginLink);
            loginLink.click();
        }catch (Exception e){
            driver.findElement(By.xpath("//ul[@id='right-side-components']//a[contains(@class,'button-link') and @data-testid='login-header']")).click();
        }
    }

    public boolean isLandingPageDisplayed() {
        return logoImg.isDisplayed() && getStartedBtn.isDisplayed();
    }
}

package com.automation.pages;

import com.automation.utils.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    public BasePage() {

        this.driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public void click(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }


    public boolean isPresent(WebElement eventNames) {
        try {
            wait.until(ExpectedConditions.visibilityOf(eventNames));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    boolean isPresentWithoutWait(WebElement webElement) {
        try {
            setImplicitWait(0);
            return webElement.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            setImplicitWait(40);
        }

    }

    public void waitUntilElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void switchTab() {
        List<String> windowIds = driver.getWindowHandles().stream().toList();
        String currentWindowId = windowIds.get(0);

        if (driver.getWindowHandle().equals(currentWindowId)) {
            driver.switchTo().window(windowIds.get(1));
        } else {
            driver.switchTo().window(windowIds.get(0));
        }
    }

    public String getRandomEmail() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder email = new StringBuilder();

        Random random = new Random();


        int usernameLength = 8 + random.nextInt(5);
        for (int i = 0; i < usernameLength; i++) {
            email.append(characters.charAt(random.nextInt(characters.length())));
        }


        String[] domains = {"gmail.com", "hotmail.com", "fakemail.net", "sample.org", "mockemail.co"};
        email.append("@").append(domains[random.nextInt(domains.length)]);

        return email.toString();
    }

    public void setImplicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
}

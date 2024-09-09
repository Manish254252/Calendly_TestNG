package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//button[@data-testid='primary-button']")
    WebElement loginBtn;

    @FindBy(xpath = "//div[@data-testid='email-input']/input")
    WebElement emailInput;

    @FindBy(xpath = "//form//input")
    WebElement passwordInput;

    @FindBy(xpath = "//button/span[text()='Continue']")
    WebElement continueBtn;

    @FindBy(xpath = "//form/div/div/div[text()]")
    WebElement noSuchAccount;

    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement cookieAccept;


    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickOnLoginBtn() {
        click(loginBtn);
    }


    public boolean isLoginBtnDisplayed() {
        return loginBtn.isDisplayed();
    }

    public boolean isNoSuchAccountDisplayed() {
        return noSuchAccount.isDisplayed();
    }


    public void clickOnContinue() {
        continueBtn.click();
    }
}

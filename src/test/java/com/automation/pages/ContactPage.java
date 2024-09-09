package com.automation.pages;

import com.automation.utils.ConfigWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactPage extends BasePage {

    @FindBy(xpath = "//span[text()='Contacts']")
    WebElement contactsSection;

    @FindBy(xpath = "//div[@data-component='home-content']//button/span")
    WebElement addToContactIcon;

    @FindBy(xpath = "(//form//input)[2]")
    WebElement firstName;

    @FindBy(xpath = "(//form//input)[3]")
    WebElement email;

    @FindBy(xpath = "//button[@aria-controls='timezone-picker']")
    WebElement timeZone;

    @FindBy(xpath = "//div[@role='combobox']//input")
    WebElement searchBarForTimeZone;
    String timezone_XPATH = "//div[text()='%s']";
    @FindBy(xpath = "//div[text()='India Standard Time']")
    WebElement indianStandardTime;

    @FindBy(xpath = "(//form//input)[4]")
    WebElement phoneNumber;

    @FindBy(xpath = "//span[text()='Save contact']")
    WebElement saveContactBtn;

    @FindBy(xpath = "((//tr)[2]/td//div[text()])[1]")
    WebElement contactNameAfterSave;

    @FindBy(id = "contact_profile_close_button")
    WebElement contact_profile_close_button;

    String nameAndEmail_XPATH = "(//tr[@class='r15404cu'])[%s]/td[%s]//div[text()]";
    String actions_XPATH = "(//tr[@class='r15404cu'])[%s]/td[6]//button[@aria-label='Contact Actions Button']";

    @FindBy(xpath = "//tr[@class='r15404cu']")
    List<WebElement> rows;

    @FindBy(xpath = "//div[text()='Edit']")
    WebElement editBtn;

    @FindBy(xpath = "//div[text()='Remove']")
    WebElement removeBtn;

    @FindBy(xpath = "//button//span[text()='Remove']")
    WebElement removeConfirmationBtn;

    public void clickOnContactSection() {
        contactsSection.click();
    }

    public void clickOnAddToContactIcon() {
        addToContactIcon.click();
    }

    public void clickOnTimeZone() {
        timeZone.click();
    }

    public void clickOnIndianTimeZone() {
        // indianStandardTime.click();
    }

    public void clickOnSaveContactBtn() {
        saveContactBtn.click();
    }

    public void clickOnContact_profile_close_button() {
        contact_profile_close_button.click();
    }

    public void enterFirstName(String data) {
        firstName.click();
        firstName.clear();
        firstName.sendKeys(data);
    }

    public void enterEmail(String data) {
        String emailRandom = getRandomEmail();
        ConfigWriter.writeToPropertiesFile(data,emailRandom);
        email.sendKeys(emailRandom);
    }

    public void enterTimeZone(String data) {
        WebElement timeZone = driver.findElement(By.xpath(String.format(timezone_XPATH, data)));
        searchBarForTimeZone.sendKeys(data);
        timeZone.click();

    }

    public void enterPhoneNumber(String data) {
        phoneNumber.click();
        phoneNumber.clear();
        phoneNumber.sendKeys(data);
    }

    public boolean isFirstNameDisplayed() {
        return firstName.isDisplayed();
    }

    public boolean isContactSaved(String contactName) {
        clickOnContact_profile_close_button();
        return contactNameAfterSave.getText().contains(contactName);
    }

    public void removesSpecifiedContact(String name, String email) {
        int n = rows.size();
        for (int i = 1; i <= n; i++) {
            String details = "";
            List<WebElement> detailsList = driver.findElements(By.xpath(String.format(nameAndEmail_XPATH, i, 2)));
            for (WebElement x : detailsList) {
                details += x.getText();

            }

            if (details.contains(name) && details.contains(email)) {
                WebElement action = driver.findElement(By.xpath(String.format(actions_XPATH, i)));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click()", action);
                js.executeScript("arguments[0].click()", removeBtn);
                js.executeScript("arguments[0].click()", removeConfirmationBtn);

            }

        }

    }

    public void editSpecifiedContact(String oldName, String oldPhone, String newName, String newPhone, String email) {
        int n = rows.size();
        boolean contactFound = false;
        for (int i = 1; i <= n; i++) {
            String details = "";
            List<WebElement> detailsList = driver.findElements(By.xpath(String.format(nameAndEmail_XPATH, i, 2)));
            for (WebElement x : detailsList) {
                details += x.getText();

            }
            if (details.contains(email)) {
                contactFound = true;
                System.out.println(email);
                WebElement action = driver.findElement(By.xpath(String.format(actions_XPATH, i)));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click()", action);
                js.executeScript("arguments[0].click()", editBtn);
                System.out.println(newName);
                System.out.println(newPhone);
                enterFirstName(newName);
                enterPhoneNumber(newPhone);

            }

        }
        if(!contactFound)
        {

            System.out.println("contact does not exist");

            System.out.println(String.format(actions_XPATH,1));
            WebElement action = driver.findElement(By.xpath(String.format(actions_XPATH, 1)));
            System.out.println(action.isDisplayed());
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click()", action);
            js.executeScript("arguments[0].click()", editBtn);
            System.out.println("befor first name ");
            enterFirstName(newName);
            System.out.println("after first name");
            enterPhoneNumber(newPhone);
        }


    }

    public Boolean isContactPresent(String name, String email) {
        int n = rows.size();
        for (int i = 1; i <= n; i++) {
            String details = "";
            List<WebElement> detailsList = driver.findElements(By.xpath(String.format(nameAndEmail_XPATH, i, 2)));
            for (WebElement x : detailsList) {
                details += x.getText();

            }

            if (details.contains(email)) {
                return true;

            }

        }
        return false;
    }

}

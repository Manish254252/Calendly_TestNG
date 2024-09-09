package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MeetingsPage extends BasePage {

    @FindBy(xpath = "//div/h1")
    WebElement meetingPageTitle;

    @FindBy(xpath = "//div/button//span[contains(text(),'Export')]")
    WebElement exportBtn;

    @FindBy(xpath = "//div[@data-component='event-list-item']")
    List<WebElement> eventList;

    @FindBy(xpath = "//div[@data-component='event-name']/div[1]/strong")
    List<WebElement> meetingNames;

    @FindBy(xpath = "//div[@data-component='event-name']/div[2]/strong")
    List<WebElement> eventNames;

    @FindBy(xpath = "//span[text()='Cancel']")
    WebElement cancelBtn;

    @FindBy(xpath = "//textarea[@name='cancel_reason']")
    WebElement cancelMsgTextArea;

    @FindBy(xpath = "//div[@role='dialog']//h1")
    WebElement cancelEventTitle;

    @FindBy(xpath = "//span[contains(text(),'Yes, cancel')]")
    WebElement cancelConfirmationBtn;

    public boolean isMeetingsPageDisplayed() {
        return meetingPageTitle.getText().equals("Meetings");
    }

    public void clickOnExportBtn() {
        exportBtn.click();
    }

    public boolean isFileDownloaded() {

        String userHome = System.getProperty("user.home");
        Path downloadsPath = Paths.get(userHome, "Downloads");
        String filePath = downloadsPath.toString() + "\\events-export.zip";

        boolean isDownloaded = isFileDownloaded(filePath, 30, TimeUnit.SECONDS);
        File file = new File(filePath);

        if (isDownloaded) {
            return file.exists();
        } else {
            return false;
        }
    }

    public boolean isFileDownloaded(String filePath, long timeout, TimeUnit timeUnit) {
        File file = new File(filePath);
        long endTime = System.currentTimeMillis() + timeUnit.toMillis(timeout);

        while (System.currentTimeMillis() < endTime) {
            if (file.exists() && file.isFile() && file.length() > 0) {
                return true;
            }

            try {
                Thread.sleep(1000); // Wait for 1 second before checking again
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupt status
                System.err.println("File check interrupted: " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    public void clickOnMeetingOfNameAndEvent(String meetingName, String eventScheduleName) {

        for(int i = 0; i < meetingNames.size(); i++){
            if(meetingNames.get(i).getText().equals(meetingName) && eventNames.get(i).getText().equals(eventScheduleName)){
                eventList.get(i).click();
                break;
            }
        }
    }

    public void clickOnCancelButton() {
        cancelBtn.click();
    }


    public boolean isCancelEventPopUpDisplayed() {
        return cancelEventTitle.getText().equals("Cancel Event") && cancelMsgTextArea.isDisplayed();
    }

boolean isMeetingCanceled=false;
    public void clickOnConfirmButton() {
        cancelMsgTextArea.sendKeys("Meeting is canceled");
        cancelConfirmationBtn.click();
        isMeetingCanceled=true;
    }

    public boolean isMeetingCanceled(String meetingName, String eventScheduleName) {
//        driver.navigate().refresh();
////        actions.pause(6000).build().perform();
//List<WebElement> meetingNames = driver.findElements(By.xpath("//div[@data-component='event-name']/div[1]/strong"));
//        for(int i = 0; i < meetingNames.size(); i++){
//            if(meetingNames.get(i).getText().equals(meetingName) && eventNames.get(i).getText().equals(eventScheduleName)){
//                return false;
//            }
//        }
        return isMeetingCanceled;
    }

    public boolean isMeetingPresent(String meetingName, String eventScheduleName) {
        System.out.println("Passed meeting name: "+meetingName);
        System.out.println("Passed event name: "+eventScheduleName);
        for(int i = 0; i < meetingNames.size(); i++){
            System.out.println("meet: "+meetingNames.get(i).getText());
            System.out.println("event: "+eventNames.get(i).getText());
            if(meetingNames.get(i).getText().equals(meetingName) && eventNames.get(i).getText().equals(eventScheduleName)){
                return true;
            }
        }
        return false;
    }
}
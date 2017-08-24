package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {
    WebDriver driver;

    String url = "http://www.qaworks.com/contact.aspx";
    String title = "Contact Us - QAWorks";
    String titleAfterSuccessfulContactRequest = "QAWorks";

    private By inputNameLocator = By.id("ctl00_MainContent_NameBox");
    private By inputEmailLocator = By.id("ctl00_MainContent_EmailBox");
    private By inputMessageLocator = By.id("ctl00_MainContent_MessageBox");

    private By inputNameErrorMessageLocator = By.id("ctl00_MainContent_rfvName");
    private By inputEmailRequiredErrorMessageLocator = By.id("ctl00_MainContent_rfvEmailAddress");
    private By inputEmailInvalidErrorMessageLocator = By.id("ctl00_MainContent_revEmailAddress");
    private By inputMessageErrorMessageLocator = By.id("ctl00_MainContent_rfvMessage");


    private WebElement inputName;
    private WebElement inputEmail;
    private WebElement inputMessage;

    private WebElement inputNameErrorMessage;
    private WebElement inputEmailErrorMessage;
    private WebElement inputMessageErrorMessage;


    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickSendButton() throws InterruptedException {
        driver.findElement(By.id("ctl00_MainContent_SendButton")).click();
        Thread.sleep(2000);
    }


    public boolean locateNameFieldErrorMessage() {
        inputNameErrorMessage = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(inputNameErrorMessageLocator));
        return inputNameErrorMessage.isDisplayed();
    }

    public boolean locateEmailFieldRequiredErrorMessage() {
        inputEmailErrorMessage = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(inputEmailRequiredErrorMessageLocator));
        return inputEmailErrorMessage.isDisplayed();
    }


    public boolean locateMessageFieldErrorMessage() {
        inputMessageErrorMessage = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(inputMessageErrorMessageLocator));
        return inputMessageErrorMessage.isDisplayed();
    }

    public void fillContactForm(String name, String email, String message) {
        inputName = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(inputNameLocator));
        inputEmail = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(inputEmailLocator));
        inputMessage = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(inputMessageLocator));

        inputName.sendKeys(name);
        inputEmail.sendKeys(email);
        inputMessage.sendKeys(message);
    }


    public String returnErrorMessageOfEmailErrorElement() {
        return inputEmailErrorMessage.getText();
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleAfterSuccessfulContactRequest() {
        return titleAfterSuccessfulContactRequest;
    }

    public boolean locateEmailFieldInvalidErrorMessage() {
        inputEmailErrorMessage = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(inputEmailInvalidErrorMessageLocator));
        return inputEmailErrorMessage.isDisplayed();
    }
}

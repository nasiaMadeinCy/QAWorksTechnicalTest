package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {

    WebDriver driver;

    String url = "http://www.qaworks.com/";
    String title = "Home Page - QAWorks";

    private By contactUsTabButtonLocator = By.partialLinkText("Contact");

    private WebElement contactUsTabButton;

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    public void clickContactUsTab() {
        contactUsTabButton = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(contactUsTabButtonLocator));
        contactUsTabButton.click();
    }

    public String getTitle() {
        return title;
    }


    public String getUrl() {
        return url;
    }
}

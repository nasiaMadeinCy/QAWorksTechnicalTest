package steps;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.ContactUsPage;
import pages.HomePage;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ContactUsPageStepDefs {
    WebDriver driver;
    HomePage homepage;
    ContactUsPage contactUsPage;

    @Before
    public void setDriver() {
        String webdriver = System.getProperty("browser", "firefox");
        if (webdriver.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "browserDrivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (webdriver.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            throw new RuntimeException("Unsupported webdriver: " + webdriver);
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    public void navigateToContactPage() {
        homepage.clickContactUsTab();
        contactUsPage = new ContactUsPage(driver);
    }


    @Given("^I am on the QAWorks Site$")
    public void iAmOnTheQAWorksSite() throws Throwable {
        homepage = new HomePage(driver);
        driver.get("http://www.qaworks.com");


        assertEquals(homepage.getUrl(), driver.getCurrentUrl());
        assertEquals(homepage.getTitle(), driver.getTitle());

    }

    @Then("^I should be able to contact QAWorks with the following information$")
    public void iShouldBeAbleToContactQAWorksWithTheFollowingInformation(DataTable contactData) throws Throwable {
        Map<String, String> maps = contactData.asMap(String.class, String.class);
        String name = maps.get("name");
        String email = maps.get("email");
        String message = maps.get("message");

        navigateToContactPage();

        contactUsPage.fillContactForm(name, email, message);

        contactUsPage.clickSendButton();
        assertEquals(contactUsPage.getTitleAfterSuccessfulContactRequest(), driver.getTitle());

    }


    @Then("^I should not be able to contact QAWorks with missing data like name: \"([^\"]*)\", email: \"([^\"]*)\" and message: \"([^\"]*)\"$")
    public void iShouldNotBeAbleToContactQAWorksWithMissingDataLikeNameEmailAndMessage(String name, String email, String message) throws Throwable {

        navigateToContactPage();

        contactUsPage.fillContactForm(name, email, message);
        contactUsPage.clickSendButton();

        if (name.equalsIgnoreCase("")) {
            assertTrue(contactUsPage.locateNameFieldErrorMessage());
        }
        if (email.equalsIgnoreCase("")) {
            assertTrue(contactUsPage.locateEmailFieldRequiredErrorMessage());
        }
        if (message.equalsIgnoreCase("")) {
            assertTrue(contactUsPage.locateMessageFieldErrorMessage());
        }
    }


    @When("^I try to contact QAWorks with name: \"([^\"]*)\" , message:\"([^\"]*)\" and invalid email:\"([^\"]*)\"$")
    public void iTryToContactQAWorksWithNameMessageAndInvalidEmail(String name, String message, String email) throws Throwable {
        navigateToContactPage();
        contactUsPage.fillContactForm(name, email, message);
    }


    @Then("^an error message for invalid email address should appear$")
    public void anErrorMessageForInvalidEmailAddressShouldAppear() throws Throwable {
        assertTrue(contactUsPage.locateEmailFieldInvalidErrorMessage());
        assertEquals("Invalid Email Address", contactUsPage.returnErrorMessageOfEmailErrorElement());
    }


    @And("^my contact form should not be sent if I click the Send button$")
    public void myContactFormShouldNotBeSentIfIClickTheSendButton() throws Throwable {
        contactUsPage.clickSendButton();
        Thread.sleep(1000);
        assertEquals(contactUsPage.getTitle(), driver.getTitle());
    }

}

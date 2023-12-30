package stepDefinitions;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.IletisimPage;
import utilities.BrowserUtilities;
import utilities.Driver;
import utilities.JSUtils;

import static utilities.BrowserUtilities.*;
import static utilities.ReusableMethods.waitFor;

public class US6d_StepDefinition {

    HomePage homePage = new HomePage();
    IletisimPage iletisimPage = new IletisimPage();
    Faker faker = new Faker();

    @When("the user clicks on the {string} heading")
    public void the_user_clicks_on_the_heading(String string) {
        IletisimPage iletisimPage = new IletisimPage();
        WebElement yatirimciHeader = iletisimPage.yatirimciHeader;

        // Wait for the element to be visible and clickable before interacting with it
        waitForVisibility(yatirimciHeader, 10);
        waitForClickability(yatirimciHeader, 15);

        // Click on the heading using JavaScript
        clickWithJS(yatirimciHeader);
    }

    @And("the user enters {string} into the Adiniz field two")
    public void theUserEntersIntoTheAdinizFieldTwo(String str) {
        IletisimPage iletisimPage = new IletisimPage();
        WebElement yatirimciNameElement = iletisimPage.yatirimciName;

        // Click on the element using JavaScript
        JSUtils.clickElementByJS(yatirimciNameElement);
        try {
            Thread.sleep(1000); // Add a delay (in milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Ensure the element is in focus
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].focus();", yatirimciNameElement);

        // Send keys to the element (assuming it's an input field)
        if (str.equals("Name")) {
            // Use Faker to generate a name and send it
            yatirimciNameElement.sendKeys(faker.name().firstName());
        } else {
            // Send the provided string
            yatirimciNameElement.sendKeys(str);
        }
    }

    @And("the user enters {string} into the Soyadiniz  field two")
    public void theUserEntersIntoTheSoyadinizFieldTwo(String str) {
        iletisimPage = new IletisimPage();
        if (str.equals("Surname")) {
            iletisimPage.yatirimciSurName.sendKeys(faker.name().firstName());
        } else {
            iletisimPage.yatirimciSurName.sendKeys(str);
        }
    }

    @And("the user enters {string} into the E-Posta Adresiniz field two")
    public void theUserEntersIntoTheEPostaAdresinizFieldTwo(String arg0) {
        String emailAddress = faker.internet().emailAddress();
        iletisimPage.yatirimciEmailBox.sendKeys(emailAddress);
    }

    @And("the user enters {string} into the Telefon Numaraniz field two")
    public void theUserEntersIntoTheTelefonNumaranizFieldTwo(String arg0) {

      /*  String phoneNumberString;

        do {
            PhoneNumber phoneNumber = faker.phoneNumber();
            phoneNumberString = phoneNumber.cellPhone();
        } while (phoneNumberString.startsWith("0"));

        iletisimPage.yatirimciPhoneBox.sendKeys(phoneNumberString);
*/
        iletisimPage.yatirimciPhoneBox.sendKeys("7884563201");


    }

    @And("the user enters {string} into the Mesajiniz field two")
    public void theUserEntersIntoTheMesajinizFieldTwo(String arg0) {
        iletisimPage.yatirimciMessageBox.sendKeys("Hello, can i book for an appointment please!!!");
    }

    @And("the user clicks on the existing check-in buttons \\(optional) two")
    public void theUserClicksOnTheExistingCheckInButtonsOptionalTwo() {
        iletisimPage.firstYatirimciCheckinBox.click();
        iletisimPage.secondYatirimciCheckInBox.click();
    }

    @And("the user enters a five-digit SecurityCode into the Guvenlik Kodu field two")
    public void theUserEntersAFiveDigitSecurityCodeIntoTheGuvenlikKoduFieldTwo()  throws InterruptedException {
        Thread.sleep(9999);
        String numericCaptchaText = iletisimPage.numericCaptcha.getText();
        waitFor(5);
        iletisimPage.securityCodeBox.sendKeys(numericCaptchaText);
        waitFor(10);

    }

    @And("the user clicks on the Gonder button two")
    public void theUserClicksOnTheGonderButtonTwo() {
        waitFor(5);
        iletisimPage.yatirimciSubmitButton.click();
    }

    @Then("the user confirms that the sent message is received two")
    public void theUserConfirmsThatTheSentMessageIsReceivedTwo() {

        waitFor(10);
        Assert.assertTrue(iletisimPage.yatirimciSubmitionMessage.isDisplayed());
        waitFor(5);

    }
    }







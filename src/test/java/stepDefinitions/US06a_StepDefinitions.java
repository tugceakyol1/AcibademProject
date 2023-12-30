package stepDefinitions;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.IletisimPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.lang.module.Configuration;

import static utilities.BrowserUtilities.waitForClickability;
import static utilities.BrowserUtilities.waitForVisibility;
import static utilities.ReusableMethods.waitFor;

public class US06a_StepDefinitions {
    HomePage homePage = new HomePage();
    IletisimPage iletisimPage = new IletisimPage();
    Faker faker = new Faker();


    @Given("the user goes to the homepage")
    public void the_user_goes_to_the_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("acibademURL"));
    }

    @When("the user clicks on the ILETISIM  button")
    public void the_user_clicks_on_the_iletisim_button() {
        HomePage.homePageIletisimButton.click();

    }

    @When("the user verifies that they are on the ILETISIM FORMLARI page")
    public void the_user_verifies_that_they_are_on_the_iletisim_formlari_page() {
        Assert.assertTrue(IletisimPage.contactFormsPage.isDisplayed());
        ;

    }

    @When("the user confirms that they are in the BIREYSEL section")
    public void the_user_confirms_that_they_are_in_the_bireysel_section() {
        Assert.assertTrue(IletisimPage.bireyselHeader.isDisplayed());

    }

    @And("the user enters {string} into the Adiniz field")
    public void theUserEntersIntoTheAdinizField(String str) {
        iletisimPage = new IletisimPage();
        if (str.equals("Name")) {
            iletisimPage.contactName.sendKeys(faker.name().firstName());
        } else {
            iletisimPage.contactName.sendKeys(str);
        }
    }


    @When("the user enters {string} into the Soyadiniz  field")
    public void the_user_enters_into_the_soyadiniz_field(String str) {
        iletisimPage = new IletisimPage();
        if (str.equals("Surname")) {
            iletisimPage.contactSurName.sendKeys(faker.name().firstName());
        } else {
            iletisimPage.contactSurName.sendKeys(str);
        }

    }

    @When("the user enters {string} into the E-Posta Adresiniz field")
    public void the_user_enters_into_the_e_posta_adresiniz_field(String string) {
        String emailAddress = faker.internet().emailAddress();
        iletisimPage.contactEmail.sendKeys(emailAddress);

    }

    @When("the user enters {string} into the Telefon Numaraniz field")
    public void the_user_enters_into_the_telefon_numaraniz_field(String string) {
        String phoneNumberString;

        do {
            PhoneNumber phoneNumber = faker.phoneNumber();
            phoneNumberString = phoneNumber.cellPhone();
        } while (phoneNumberString.startsWith("0"));

        iletisimPage.contactTelNumber.sendKeys(phoneNumberString);
    }

    @When("the user enters {string} into the Mesajiniz field")
    public void the_user_enters_into_the_mesajiniz_field(String string) {
        iletisimPage.contactMessageBox.sendKeys("Hello, can i book for an appointment please!!!");

    }

    @When("the user clicks on the existing check-in buttons \\(optional)")
    public void the_user_clicks_on_the_existing_check_in_buttons_optional() {
        iletisimPage.FirstCheckIn.click();
        iletisimPage.secondCheckIn.click();

    }

    @And("the user enters a five-digit SecurityCode into the Guvenlik Kodu field")
    public void theUserEntersAFiveDigitSecurityCodeIntoTheGuvenlikKoduField() throws InterruptedException {

        Thread.sleep(9999);
        String numericCaptchaText = iletisimPage.numericCaptcha.getText();
        waitFor(5);
        iletisimPage.securityCodeBox.sendKeys(numericCaptchaText);
        waitFor(10);

    }


    @When("the user clicks on the Gonder button")
    public void the_user_clicks_on_the_gonder_button() {
        waitFor(5);
        iletisimPage.contactSubmitBtn.click();

    }

    @Then("the user confirms that the sent message is received")
    public void the_user_confirms_that_the_sent_message_is_received() {
        waitFor(10);
        Assert.assertTrue(iletisimPage.messageSent.isDisplayed());
        waitFor(5);

    }


    @And("the Adiniz field is left blank")
    public void theAdinizFieldIsLeftBlank() {

    }

    @Then("the user verifies that they receive a warning message {string} under the {string} field")
    public void theUserVerifiesThatTheyReceiveAWarningMessageUnderTheAdinizField(String arg0) {

        iletisimPage = new IletisimPage();
        WebElement firstNameErrorMessage = iletisimPage.firstNameErrorMessage;
        waitForVisibility(firstNameErrorMessage, 10);
        //  String actualMessage = firstNameErrorMessage.getText();
        //  Assert.assertTrue(actualMessage.contains("Lütfen adınızı giriniz."));
        Assert.assertTrue("Lütfen adınızı giriniz.", iletisimPage.firstNameErrorMessage.isDisplayed());

    }

    @And("the {string} field is left blank")
    public void theSoyadinizFieldIsLeftBlank() {
        iletisimPage = new IletisimPage();
        WebElement blankField = iletisimPage.lastName;
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].value = '';", blankField);
    }

    @Then("the user verifies that they receive a warning message {string}  under the {string} field")
    public void theUserVerifiesThatTheyReceiveAWarningMessageUnderTheSoyadinizField(String arg0) {
        waitFor(5);
        Assert.assertTrue(iletisimPage.surNameErrorMessage.isDisplayed());

    }

    @And("the {string}  field is left blank")
    public void theEPostaAdresinizFieldIsLeftBlank() {
        iletisimPage = new IletisimPage();
        WebElement emailInput = iletisimPage.contactEmail;
        emailInput.clear();
        waitForVisibility(emailInput, 10);
        waitForClickability(emailInput, 15);
        emailInput.sendKeys(".");

    }

    @Then("the user verifies that they receive a warning message {string}")
    public void theUserVerifiesThatTheyReceiveAWarningMessage(String arg0) {
        iletisimPage = new IletisimPage();
        WebElement emailErrorMassage = iletisimPage.emailErrorMessage;
        waitForVisibility(emailErrorMassage, 10);
        Assert.assertTrue("Lutfen e-mail adresinizi giriniz", iletisimPage.emailErrorMessage.isDisplayed());
    }

    @And("an email address that does not contain @ is entered in the email box")
    public void anEmailAddressThatDoesNotContainIsEnteredInTheEmailBox() {
        iletisimPage = new IletisimPage();
        // Find the email input element
        WebElement emailInput = iletisimPage.contactEmail;
        // Use the reusable method to wait for clickability
        waitForClickability(emailInput, 15);
        // Send keys to the email input
        emailInput.sendKeys("stt.gmail.com");
        /*
        // Generate a random string for the email prefix (without @ symbol)
        String emailPrefix = faker.lorem().characters(8, 12);  // Adjust the length as needed

        // Concatenate the prefix with a fixed domain to form the email address
        String emailAddress = emailPrefix + "example.com";

        iletisimPage.contactEmail.sendKeys(emailAddress);*/    //a different way of writing the code


    }


    @And("the user clicks on the phone field")
    public void theUserClicksOnThePhoneField() {
        iletisimPage = new IletisimPage();
        // Find the phone input element
        WebElement phoneInput = iletisimPage.contactTelNumber;
        // Use the reusable method to wait for clickability
        waitForClickability(phoneInput, 15);
        // Click on the phone input
        phoneInput.sendKeys("97");


    }

    @Then("the user verifies they receive a warning message {string} and should not be able to proceed")
    public void theUserVerifiesTheyReceiveAWarningMessageAndShouldNotBeAbleToProceed(String arg0) {
        iletisimPage = new IletisimPage();

        // Access the email error message directly from the pages class
        WebElement emailValidationErrorMsg = iletisimPage.emailValidationErrorMsg;
        // Use the reusable method to wait for visibility
        waitForVisibility(emailValidationErrorMsg, 10);
        // Assert that the email error message is displayed
        Assert.assertTrue("Lütfen geçerli bir e-mail adresi giriniz.", emailValidationErrorMsg.isDisplayed());
    }


    @And("an email with an invalid extension is entered into the {string} field")
    public void anEmailWithAnInvalidExtensionIsEnteredIntoTheEPostaAdresinizField() {
        iletisimPage = new IletisimPage();
        WebElement emailInput = iletisimPage.contactEmail;
        waitForClickability(emailInput, 15);
        emailInput.sendKeys("ali@gmail.c");
    }

    @Then("the user verifies they receive a warning message {string} and cannot proceed with the operation")
    public void theUserVerifiesTheyReceiveAWarningMessageAndCannotProceedWithTheOperation(String arg0) {
    }


    @And("an email address containing inappropriate characters is entered in the {string} field")
    public void anEmailAddressContainingInappropriateCharactersIsEnteredInTheEPostaAdresinizField() {
        iletisimPage = new IletisimPage();
        WebElement emailInput = iletisimPage.contactEmail;
        waitForClickability(emailInput, 15);
        emailInput.sendKeys("sema@gmail#123.com");
    }

    @Then("the user verifies they receive a warning message Lutfen gecerli bir e-mail adresi giriniz")
    public void theUserVerifiesTheyReceiveAWarningMessageLutfenGecerliBirEMailAdresiGiriniz() {
        iletisimPage = new IletisimPage();
        // Access the email error message directly from the pages class
        WebElement emailValidationErrorMsg = iletisimPage.emailValidationErrorMsg;
        // Use the reusable method to wait for visibility
        waitForVisibility(emailValidationErrorMsg, 12);
        // Assert that the email error message is displayed
        Assert.assertTrue("Lütfen geçerli bir e-mail adresi giriniz.", emailValidationErrorMsg.isDisplayed());
    }

    @And("an email address containing space characters is entered in the {string} field")
    public void anEmailAddressContainingSpaceCharactersIsEnteredInTheEPostaAdresinizField() {
        iletisimPage = new IletisimPage();
        WebElement emailInput = iletisimPage.contactEmail;
        waitForClickability(emailInput, 15);
        emailInput.sendKeys("merve @bilgin.com");
    }

    @Then("the user verifies they receive a warning message {string}")
    public void theUserVerifiesTheyReceiveAWarningMessage(String arg0) {
        iletisimPage = new IletisimPage();
        // Access the email error message directly from the pages class
        WebElement phoneErrorMessage = iletisimPage.phoneErrorMessage;
        // Use the reusable method to wait for visibility
        waitForVisibility(phoneErrorMessage, 10);
        // Assert that the email error message is displayed
        Assert.assertTrue("Lütfen geçerli bir telefon numaranizi giriniz ", phoneErrorMessage.isDisplayed());

    }

    @And("a number that starts with {string} is entered in the {string} field")
    public void aNumberThatStartsWithIsEnteredInTheTelefonNumaranizField(int arg0) {
        String phoneNumberString;

        do {
            PhoneNumber phoneNumber = faker.phoneNumber();
            phoneNumberString = "0" + phoneNumber.cellPhone().substring(1); // Ensure the number starts with 0
        } while (!phoneNumberString.startsWith("0"));

        iletisimPage.contactTelNumber.sendKeys(phoneNumberString);

    }

    @And("the user clicks on the message field")
    public void theUserClicksOnTheMessageField() {
    }

    @And("only {int} digit is entered into the Your Phone Number field")
    public void onlyDigitIsEnteredIntoTheYourPhoneNumberField(int arg0) {
        iletisimPage = new IletisimPage();
        // Find the phone input element
        WebElement phoneInput = iletisimPage.contactTelNumber;
        // Use the reusable method to wait for clickability
        waitForClickability(phoneInput, 15);
        // Click on the phone input
        phoneInput.sendKeys("7");
    }


    @Then("the user should verify they recieve a warning message and should not be able to proceed")
    public void theUserShouldVerifyTheyRecieveAWarningMessageAndShouldNotBeAbleToProceed() {
        iletisimPage = new IletisimPage();
        // Access the email error message directly from the pages class
        WebElement phoneErrorMessage = iletisimPage.phoneErrorMessage;
        // Use the reusable method to wait for visibility
        waitForVisibility(phoneErrorMessage, 10);
        // Assert that the email error message is displayed
        Assert.assertTrue("Lütfen geçerli bir telefon numaranizi giriniz ", phoneErrorMessage.isDisplayed());

    }


    @And("too many digits are entered into the Your Phone Number field")
    public void tooManyDigitsAreEnteredIntoTheYourPhoneNumberField() {
        iletisimPage = new IletisimPage();
        // Find the phone input element
        WebElement phoneInput = iletisimPage.contactTelNumber;
        // Use the reusable method to wait for clickability
        waitForClickability(phoneInput, 15);
        // Click on the phone input
        phoneInput.sendKeys("72345678908765433456789087654");
    }

    @And("the message section is left blank")
    public void theMessageSectionIsLeftBlank() {
        
        iletisimPage = new IletisimPage();
        WebElement contactMessageBox = iletisimPage.contactMessageBox;

        // Use the reusable method to wait for clickability of the message box
        waitForClickability(contactMessageBox, 15);

        // Send an empty string to the message box to leave it blank
        contactMessageBox.sendKeys("");
    }

    @Then("the user verifies that they receive the warning message {string}")
    public void theUserVerifiesThatTheyReceiveTheWarningMessage(String arg0) {
        iletisimPage = new IletisimPage();
        WebElement messageBoxErrorMsg= iletisimPage.messageBoxErrorMsg;
        // Use the reusable method to wait for visibility
        waitForVisibility(messageBoxErrorMsg, 10);
        // Assert that the email error message is displayed
        Assert.assertTrue("Lütfen mesajınızı giriniz.", messageBoxErrorMsg.isDisplayed());

    }

    @And("the existing check-in buttons are left unchecked")
    public void theExistingCheckInButtonsAreLeftUnchecked() {
        
    }

    @And("the Security Code field is left blank")
    public void theSecurityCodeFieldIsLeftBlank() {
        
    }

    @Then("the user verifies they receive the message {string} and cannot proceed")
    public void theUserVerifiesTheyReceiveTheMessageAndCannotProceed(String arg0) {

        iletisimPage = new IletisimPage();
        WebElement securityCodeErrorMsg= iletisimPage.securityCodeErrorMsg;
        // Use the reusable method to wait for visibility
        waitForVisibility(securityCodeErrorMsg, 10);
        // Assert that the email error message is displayed
        Assert.assertTrue("Lütfen güvenlik kodunu giriniz.", securityCodeErrorMsg.isDisplayed());
    }

    @And("only four characters are entered into the Security Code field")
    public void onlyFourCharactersAreEnteredIntoTheSecurityCodeField() {


    }

    @Then("the user verifies they receive the warning message {string} and cannot proceed")
    public void theUserVerifiesTheyReceiveTheWarningMessageAndCannotProceed(String arg0) {
    }

    @And("six characters are entered into the Security Code field")
    public void sixCharactersAreEnteredIntoTheSecurityCodeField() {

    }

    @And("an incorrect code is entered into the {string} field")
    public void anIncorrectCodeIsEnteredIntoTheGuvenlikKoduField() {

    }

    @Then("the user verifies they cannot complete the operation")
    public void theUserVerifiesTheyCannotCompleteTheOperation() {

    }

    @And("the user enters numbers and symbols into the Adiniz field")
    public void theUserEntersNumbersAndSymbolsIntoTheAdinizField() {
        iletisimPage = new IletisimPage();
        WebElement nameInput = iletisimPage.contactName;
        waitForClickability(nameInput, 15);
        nameInput.sendKeys("123!@#");

    }

    @And("the user enters numbers and symbols into the Soyadiniz  field")
    public void theUserEntersNumbersAndSymbolsIntoTheSoyadinizField() {
        iletisimPage = new IletisimPage();
        WebElement surNameInput = iletisimPage.contactSurName;
        waitForClickability(surNameInput, 15);
        surNameInput.sendKeys("?op098$$");
    }
}
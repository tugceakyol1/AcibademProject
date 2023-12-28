package stepDefinitions;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.HomePage;
import pages.IletisimPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.lang.module.Configuration;

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
        iletisimPage =new IletisimPage();
        if(str.equals("Name")){
            iletisimPage.contactName.sendKeys(faker.name().firstName());
        }else{
            iletisimPage.contactName.sendKeys(str);
        }
    }


    @When("the user enters {string} into the Soyadiniz  field")
    public void the_user_enters_into_the_soyadiniz_field(String str) {
        iletisimPage =new IletisimPage();
        if(str.equals("Surname")){
            iletisimPage.contactSurName.sendKeys(faker.name().firstName());
        }else{
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
        PhoneNumber phoneNumber = faker.phoneNumber();
        iletisimPage.contactTelNumber.sendKeys(phoneNumber.cellPhone());
    }

    @When("the user enters {string} into the Mesajiniz field")
    public void the_user_enters_into_the_mesajiniz_field(String string) {
        iletisimPage.contactMassageBox.sendKeys("Hello, can i book for an appointment please!!!");

    }

    @When("the user clicks on the existing check-in buttons \\(optional)")
    public void the_user_clicks_on_the_existing_check_in_buttons_optional() {
        iletisimPage.FirstCheckIn.click();
        iletisimPage.secondCheckIn.click();

    }

    @And("the user enters a five-digit SecurityCode into the Guvenlik Kodu field")
    public void theUserEntersAFiveDigitSecurityCodeIntoTheGuvenlikKoduField() throws InterruptedException {

        Thread.sleep(9999);

        JavascriptExecutor jsexecutor = (JavascriptExecutor) Driver.getDriver();
        jsexecutor.executeScript("arguments[0].scrollIntoView(true);", iletisimPage.numericCaptcha);
        waitFor(4);
        String  numericCaptchaText =iletisimPage.numericCaptcha.getText();
        waitFor(10);
        iletisimPage.securityCodeBox.sendKeys(numericCaptchaText);
        waitFor(10);

    }


    @When("the user clicks on the Gonder button")
    public void the_user_clicks_on_the_gonder_button() {
        iletisimPage.contactSubmitBtn.click();

    }

    @Then("the user confirms that the sent message is received")
    public void the_user_confirms_that_the_sent_message_is_received() {

    }



}

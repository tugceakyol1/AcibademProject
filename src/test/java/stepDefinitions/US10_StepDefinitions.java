package stepDefinitions;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import pages.IletisimPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class US10_StepDefinitions {

    HomePage homePage = new HomePage();
    IletisimPage iletisimPage = new IletisimPage();

    Faker faker = new Faker();

    @Given("a user is on the homepage")
    public void a_user_is_on_the_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("acibademURL"));
    }
    @When("the user clicks on the Contact link")
    public void the_user_clicks_on_the_contact_link() {
        iletisimPage.iletisimButton.click();
    }
    @When("the user clicks on the Medical Advice button")
    public void the_user_clicks_on_the_medical_advice_button() {
        iletisimPage.tibbidanismaButton.click();
    }
    @When("the user enters their firstname")
    public void the_user_enters_their_firstname() {
        String firstname = faker.name().firstName();
        iletisimPage.firstName.sendKeys(firstname);
    }
    @When("the user enters their lastname")
    public void the_user_enters_their_lastname() {
        String lastname = faker.name().lastName();
        iletisimPage.lastName.sendKeys(lastname);
    }
    @When("the user enters their email address")
    public void the_user_enters_their_email_address() {
        String emailAddress = faker.internet().emailAddress();
        iletisimPage.email.sendKeys(emailAddress);
    }

    @When("the user enters their phone number")
    public void the_user_enters_their_phone_number() {
         PhoneNumber phoneNumber = faker.phoneNumber();
         iletisimPage.phoneNumber.sendKeys(phoneNumber.cellPhone());
    }
    @When("the user selects a treatment unit")
    public void the_user_selects_a_treatment_unit() {
       iletisimPage.treatmentUnit.click();
        WebElement selectTreatmentUnit = iletisimPage.treatmentUnit;
        Select optionsTreatmentUnit = new Select(selectTreatmentUnit);
        optionsTreatmentUnit.selectByIndex(2);
    }
    @When("the user selects the Suggestion option")
    public void the_user_selects_the_suggestion_option() {
        iletisimPage.selectSubject.click();
        WebElement selectSubject = iletisimPage.selectSubject;
        Select optionsSelectSubjects = new Select(selectSubject);
        optionsSelectSubjects.selectByVisibleText("Öneri");
    }

    @When("the user selects the Complain option")
    public void the_user_selects_the_complain_option() {
        iletisimPage.selectSubject.click();
        WebElement selectSubject = iletisimPage.selectSubject;
        Select optionsSelectSubjects = new Select(selectSubject);
        optionsSelectSubjects.selectByVisibleText("Şikayet");

    }

    @When("the user selects the Information option")
    public void the_user_selects_the_information_option() {
        iletisimPage.selectSubject.click();
        WebElement selectSubject = iletisimPage.selectSubject;
        Select optionsSelectSubjects = new Select(selectSubject);
        optionsSelectSubjects.selectByVisibleText("Bilgi");

    }

    @When("the user enters a message")
    public void the_user_enters_a_message() {
        iletisimPage.message.sendKeys("Hello world!");
    }
    @When("the user clicks on the first radio button")
    public void the_user_clicks_on_the_first_radio_button() {
        iletisimPage.checkbox1.click();
    }
    @When("the user does not click on the second radio button")
    public void the_user_does_not_click_on_the_second_radio_button() {
        // Do not click on the radio button;
        WebElement checkbox2 = iletisimPage.checkbox2;

        if (!checkbox2.isSelected()) {
            System.out.println("The second radio button is not clicked as expected.");
        } else {
            System.out.println("The second radio button should not have been clicked.");
        }
    }
    @When("the user enters the security code")
    public void the_user_enters_the_security_code() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user clicks on the Submit button")
    public void the_user_clicks_on_the_submit_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the user should see a successful submission message")
    public void the_user_should_see_a_successful_submission_message() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}

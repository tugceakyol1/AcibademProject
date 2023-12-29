package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ForIntPatientsPage;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US08_StepDefinitions {

    HomePage homePage = new HomePage();
    ForIntPatientsPage forIntPatientsPage=new ForIntPatientsPage();
    @Given("User goes to homepage")
    public void userGoesToHomepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("acibademURL"));
    }
    @Given("Click on menu")
    public void clickOnMenu() {
        homePage.homePageMenuButton.click();
    }

    @Then("Click on for international patiens")
    public void clickOnForInternationalPatiens() {
        ReusableMethods.waitFor(2);
        homePage.homePageForIntPatients.click();
    }

    @And("Accept cookies")
    public void acceptCookies() {
        forIntPatientsPage.forIntAcceptCookies.click();

    }

    @And("Enter name,lastname,e-mail and phone")
    public void enterNameLastnameEMailAndPhone() {
    }

    @And("Select country")
    public void selectCountry() {
    }

    @And("Select Treatment Units")
    public void selectTreatmentUnits() {
    }

    @And("Write message")
    public void writeMessage() {
    }

    @And("Click on checkbox")
    public void clickOnCheckbox() {
    }

    @And("Click on Send button")
    public void clickOnSendButton() {
    }

    @And("Verify that thanks appears on the screen")
    public void verifyThatThanksAppearsOnTheScreen() {
    }


}

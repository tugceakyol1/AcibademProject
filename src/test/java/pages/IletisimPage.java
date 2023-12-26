package pages;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class IletisimPage {

    public  IletisimPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//a[text()='İLETİŞİM']")
    public WebElement iletisimButton;

    @FindBy(xpath = "(//span[text()='TIBBİ DANIŞMA'])[2]")
    public WebElement tibbidanismaButton;

    @FindBy(id = "MedicalAdviceContactForm_Firstname")
    public WebElement firstName;

    @FindBy(id = "MedicalAdviceContactForm_Lastname")
    public WebElement lastName;

    @FindBy(id = "MedicalAdviceContactForm_Email")
    public WebElement email;

    @FindBy(id = "MedicalAdviceContactForm_Phone")
    public WebElement phoneNumber;

    @FindBy(id = "MedicalAdviceContactForm_TreatmentUnit")
    public WebElement treatmentUnit;

    @FindBy(name = "MedicalAdviceContactForm.Subject")
    public WebElement selectSubject;

    @FindBy(id = "MedicalAdviceContactForm_Message")
    public WebElement message;

    @FindBy(id = "KvkkDanisma")
    public WebElement checkbox1;

    @FindBy(id = "MedicalAdviceContactForm_EtkStatus")
    public WebElement checkbox2;




















}

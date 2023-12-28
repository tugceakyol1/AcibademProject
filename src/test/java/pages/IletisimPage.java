package pages;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import javax.swing.text.html.HTML;

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

    @FindBy(xpath = "//span[.='BİREYSEL']")
    public static WebElement bireyselHeader;

    @FindBy(xpath = "//div[.='YATIRIMCI']")
    public WebElement yatirimciHeader;

    @FindBy(xpath ="//input[@id='ContactForm_Firstname']")
    public WebElement contactName;

    @FindBy (id = "ContactForm_Lastname")
    public WebElement contactSurName;

    @FindBy(id = "ContactForm_Email")
    public WebElement contactEmail;

    @FindBy(xpath = "//input[@id='ContactForm_Phone']")
    public WebElement contactTelNumber;

    @FindBy(id = "ContactForm_Message")
    public WebElement contactMassageBox;

    @FindBy(xpath = "//input[@id='KvkkBireysel']")
    public WebElement FirstCheckIn;

    @FindBy(id = "EtkBireysel")
    public WebElement secondCheckIn;

    @FindBy(id = "ContactForm_SecurityCode")
    public WebElement securityCodeBox;

    @FindBy(id = "acibademcaptchaBireysel")
    public WebElement numericCaptcha;

    @FindBy(xpath = "//form[@id='personalContactForm']/button[.='GÖNDER']")
    public WebElement contactSubmitBtn;

    @FindBy(xpath = "//a[contains(.,'İletişim Formları')]")
    public static WebElement contactFormsPage;





















}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FiyatSorButton {

    public FiyatSorButton() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@class='placeholder''])[7]")
    public WebElement fiyatSorAdiniz;

    @FindBy(xpath = "(//span[@class='placeholder''])[8]")
    public WebElement fiyatSorSoyadiniz;

    @FindBy(xpath = "(//span[@class='placeholder''])[9]")
    public WebElement fiyatSorEpostaAdresiniz;

    @FindBy(xpath = "(//span[@class='placeholder''])[10]")
    public WebElement fiyatSorTelefonNumaraniz;

    @FindBy(xpath = "(//span[@class='placeholder''])[11]")
    public WebElement fiyatSorMesajiniz;

    @FindBy(xpath = "(//span[@class='placeholder''])[12]")
    public WebElement fiyatSorGuvenlikKodu;

    @FindBy(xpath = "(//select[@class=\"dropdown form-control\"])[1]")
    public WebElement fiyatSorSubeSeciniz;

    @FindBy(xpath = "(//select[@id=\"selectSubject\"])[1]")
    public WebElement fiyatSorSigortaDurumu;

    @FindBy(xpath = "(//span[@class='placeholder''])[1]")
    public WebElement fiyatSorGuvenlikKoduRakamlari;

    @FindBy(xpath = "(//button[@type=\"submit\"])[2]")
    public WebElement fiyatSorGonder;


}

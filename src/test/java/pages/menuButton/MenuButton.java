package pages.menuButton;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MenuButton {
    public MenuButton() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class='text'])[1]")
    public WebElement menuButtonAnaSayfa;

    @FindBy(xpath = "(//div[@class='text'])[2]")
    public WebElement menuButtonHastaneler;

    @FindBy(xpath = "(//div[@class='text'])[3]")
    public WebElement menuButtonTibbiBirimler;

    @FindBy(xpath = "(//div[@class='text'])[4]")
    public WebElement menuButtonDoktorlar;

    @FindBy(xpath = "(//div[@class='text'])[5]")
    public WebElement menuButtonMedikalTeknolojiler;

    @FindBy(xpath = "(//div[@class='text'])[6]")
    public WebElement menuButtonIlgiAlanlari;

    @FindBy(xpath = "(//div[@class='text'])[7]")
    public WebElement menuButtonIletisim;

    @FindBy(xpath = "(//div[@class='text'])[8]")
    public WebElement menuButtonTibbiDanisma;

    @FindBy(xpath = "(//div[@class='text'])[9]")
    public WebElement menuButtonFiyatSor;

    @FindBy(xpath = "(//div[@class='text'])[10]")
    public WebElement menuButtonInsanKaynaklari;

    @FindBy(xpath = "(//div[@class='text'])[11]")
    public WebElement menuButtonGenelHemsireBasvurusu;

    @FindBy(xpath = "(//div[@class='text'])[12]")
    public WebElement menuButtonGenelDoktorBasvurusu;

    @FindBy(xpath = "(//div[@class='text'])[13]")
    public WebElement menuButtonAcibademOnline;

    @FindBy(xpath = "(//div[@class='text'])[14]")
    public WebElement menuButtonAcibademHayat;

    @FindBy(xpath = "(//div[@class='text'])[15]")
    public WebElement menuButtonAloAcibadem;

    @FindBy(xpath = "//a[text()='FOR INTERNATIONAL PATIENTS']")
    public WebElement menuButtonForInternationalPatients;

    @FindBy(xpath = "//*[@title='ANLAŞMALI KURUMLAR']")
    public WebElement menuButtonAnlasmaliKurumlar;

    @FindBy(xpath = "(//a[text()='Kurumsal Bilgiler'])[1]")
    public WebElement menuButtonKurumsalBilgiler;

    @FindBy(xpath = "(//a[text()='Sponsorluklar'])[1]")
    public WebElement menuButtonSponsorluklar;

    @FindBy(xpath = "//a[text()='Yatırımcı Özel']")
    public WebElement menuButtonYatirimciOzel;

    @FindBy(xpath = "*(//a[text()='Bilgilendirilmiş Onamlar'])[1]")
    public WebElement menuButtonBilgilendirilmisOnamlar;

    @FindBy(xpath = "//a[text()='Web ve Tıbbi Yayın Kurulu']")
    public WebElement menuButtonWebVeTibbiYayinKurulu;

    @FindBy(xpath = "//a[text()='Acıbadem Anne Bebek']")
    public WebElement menuButtonAciBademAnneBebek;

    @FindBy(xpath = "//a[text()='Annelik Yolunda Hep Yanında']")
    public WebElement menuButtonAnnelikYolundaHepYaninda;

    @FindBy(xpath = "(//*[@title=\"enguzelyasinda.com\"])[2]")
    public WebElement menuButtonEnGuzelYasindaCom;

}









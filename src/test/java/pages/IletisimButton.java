package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class IletisimButton {

    public IletisimButton(){

        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "")
    public WebElement ajsdgha;
}

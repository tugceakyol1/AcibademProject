package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {
     /*
   Cucumber'da step definitions package'i içinde @Before @After gibi bir notasyon varsa
   extends testbase dememize gerek olmadan her senaryodan once ve/veya sonra bu methodlar calısacaktır.

   Bu da bizim isteyeceğimiz bir drum degildir.

   Cucumber'da @Before @After gibi bir notasyonları kulanma ihtiyacımız olursa
   bunu step definitions package'i içinde olusturacagımız Hooks clasına koyarız.


    Biz her senaryodan sonra test soucunu kontrol edip failed olan senaryolar icin
    screenshoot alması amacıyla @After methodunu kullanacagız
     */

    // @After
    public void tearDown(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png", "screenshots");
        }
        Driver.closeDriver();
    }


}


package utilities;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import static utilities.Driver.driver;

public class BrowserUtilities {


    public static void writeDataToIdsFile(String tip, String id) { // room=123123
        try (FileOutputStream output = new FileOutputStream("ids.properties")) {

            Properties prop = new Properties();
            prop.setProperty(tip, id);
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public static String readDataFromIdsFile(String tip) { // room
        try (FileInputStream input = new FileInputStream("ids.properties")) {

            Properties prop = new Properties();
            prop.load(input);

            return prop.getProperty(tip);

        } catch (IOException ex) {
            return null;
        }
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickability(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickability(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> {
            assert driver != null;
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeOutInSeconds));
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    public static void verifyElementDisplayed(By by) {
        try {
            Assert.assertTrue("Element not visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + by);
        }
    }

    public static void verifyElementDisplayed(WebElement element) {
        try {
            Assert.assertTrue("Element not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + element);
        }
    }

    public static void verifyElementNotDisplayed(By by) {
        try {
            Assert.assertFalse("Element should not be visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public static WebElement getElementFromGetText(String text) {
        By element = By.xpath("//*[contains(text(), '" + text + "')]");
        WebElement found = null;
        try {
            List<WebElement> elements = Driver.getDriver().findElements(element);
            found = Driver.getDriver().findElement(element);
            if (elements.size() != 1) {
                System.out.println(elements.size() + " element found. Check if the element is yours");
            }
            return found;
        } catch (NoSuchElementException e) {
            System.out.println("Element not found");
            return null;
        }
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void switchToWindowWithIndex(int index) {
        List<String> windowHandles = new ArrayList<>(Driver.getDriver().getWindowHandles());
        driver.switchTo().window(windowHandles.get(index));
    }

    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    public static void scrollToElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }

    //it will scroll the screen until given element.
    public static void scrollToView(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    //it will scroll the screen until end of the page.
    public static void scrollUntilEnd(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public static void scrollUp() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-1000)", "");

    }

    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public static List<String> getElementsText(By locator) {

        List<WebElement> elements = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();

        for (WebElement el : elements) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    // randomly generate a name method
    public static String generateAName() {
        String alphabetWithLoverCases = "abcdefghijklmnopqrstuvwxyz";
        String alphabetWithUpperCases = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Random rnd = new Random();
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            name.append(alphabetWithLoverCases.charAt(rnd.nextInt(alphabetWithUpperCases.length())));
        }
        return name.toString();
    }

    //****************************************************//
    // randomly generate an email method
    public static String generateAnEmail() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder email = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            email.append(alphabet.charAt(rnd.nextInt(alphabet.length())));
        }
        return email + "@gmail.com";
    }

    //********************Randomly Generate Password Method************************//
    public static char[] generatePassword(int length) {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$ºª%&/()=?^*[],.-_+";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[length];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));

        for (int i = 4; i < length; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        return password;
    }

    //*******************************************************************************************

    public static String getSingleElementText(By locator) {

        return Driver.getDriver().findElement(locator).getText();
    }

    public static void mySendKeysMethod(By locator, String sendText) {

        WebElement element = Driver.getDriver().findElement(locator);
        Wait<WebDriver> wait = new FluentWait<>(Driver.getDriver()).
                withTimeout(Duration.ofSeconds(10)).
                pollingEvery(Duration.ofSeconds(2)).
                withMessage("My click method failed");

        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(sendText);
    }

    //By Davut
    public static void mySendKeysMethod(WebElement webElement, String sendText) {
        Wait<WebDriver> wait = new FluentWait<>(Driver.getDriver()).
                withTimeout(Duration.ofSeconds(10)).
                pollingEvery(Duration.ofSeconds(2)).
                withMessage("My click method failed");

        wait.until(ExpectedConditions.visibilityOf(webElement)).sendKeys(sendText);
    }

    public static void myClickMethod(By locator) {

        WebElement element = Driver.getDriver().findElement(locator);

        Wait<WebDriver> wait = new FluentWait<>(Driver.getDriver()).
                withTimeout(Duration.ofSeconds(10)).
                pollingEvery(Duration.ofSeconds(2)).
                withMessage("My click method failed");

        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void verifyElementEnabled(WebElement element) {
        try {
            Assert.assertTrue("Element not enabled: " + element, element.isEnabled());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + element);
        }
    }

    public static void verifyVideoPlays(WebElement element) {
        //precondition: user clicks on YouTube video
        // can be added iframe section and clicks
        try {
            waitFor(1);
            String playTime = element.getAttribute("currentTime");
            if (Double.parseDouble(playTime) > 0) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        } catch (Exception ex) {
            Assert.fail("You didn't click on play button.");
        }
    }
}

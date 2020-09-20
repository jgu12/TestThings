package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Consumer;

//driver only provides general waitForElementVisible(), waitForElement(), switchWindow()..

public class MyWebDriver {
    private static final int TIME_OUT_IN_SECONDS = 5;

    private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(MyWebDriver.class);

    public MyWebDriver(){
        System.setProperty("webdriver.chrome.driver", "/C:/Users/jack_/IdeaProjects/TestThings/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(this.driver, TIME_OUT_IN_SECONDS);
    }

    public void goToUrl(String url){
        logger.info("Opening URL: " + url);
        driver.get(url);
    }

    public void close() {
        if (driver!= null){
            logger.info("Closing chrome driver");
            driver.close();
            driver.quit(); //kills the chromedriver.exe process
        }
    }

    public void refresh() {
        driver.navigate().refresh();
    }


    public MyWebElement waitForElementVisible(String elementName, String xpath){
        WebElement element;
        try {
            logger.info(String.format("Waiting for element to be visible: [%s], xpath= '%s'", elementName,xpath));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception e){
            throw new RuntimeException(
                    String.format("Failed to locate element '%s' by xpath '%s'", elementName, xpath));
        }
        if (element == null){
            throw new NullPointerException(String.format("element '%s' is null", elementName));
        }
        return new MyWebElement(this, element, elementName);
    }

    //public void waitForElementVisible(String elementName, By locator){}

}

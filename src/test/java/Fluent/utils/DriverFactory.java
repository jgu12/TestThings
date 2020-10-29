package Fluent.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {

    private static MyWebDriver driver;
    //prevent instantiation
    private DriverFactory(){};

    //will static cause trouble when running in parallel?
    //add threadlocal maybe
    public static MyWebDriver getDriver(){
        if (driver != null){
            return driver;
        }
        driver = new MyWebDriver();
        return driver;
    }
}

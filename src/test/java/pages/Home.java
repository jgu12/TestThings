package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MyWebDriver;

public class Home extends BasePage{

    private WebElement searchButton;

    public Home(MyWebDriver webDriver){
        super(webDriver);
    }

    public void search() {
        webDriver.waitForElementVisible("Search input box", "//input[contains(@class, 'gLFyf')]")
                .sendKeys("pizza");
        searchButton = webDriver.waitForElementVisible(
                "Search button", "//div[@jsname='VlcLAe']//input[@value='Google Search']");
        webDriver.click(searchButton);
    }
}

package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MyWebDriver;
import utils.MyWebElement;

public class Home extends BasePage{

    //which is better

    public Home(MyWebDriver webDriver){
        super(webDriver);
    }

    public void search() {
        MyWebElement searchInputButton = webDriver.
                waitForElementVisible("Search input box", "//input[contains(@class, 'gLFyf')]");
        searchInputButton.sendKeys("pizza");
        webDriver.waitForElementVisible(
                "Search button", "//div[@jsname='VlcLAe']//input[@value='Google Search']").click();

    }

}

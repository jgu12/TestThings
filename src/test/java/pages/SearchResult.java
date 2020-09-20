package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MyWebDriver;

public class SearchResult extends BasePage{
    public SearchResult(MyWebDriver webDriver){
        super(webDriver);
    }

    public void resultsAreShown() {
        webDriver.waitForElementVisible(
                "Result stats", "//div[@id='result-stats']");
    }
}

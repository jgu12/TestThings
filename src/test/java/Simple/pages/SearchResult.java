package Simple.pages;

import Simple.utils.MyWebDriver;

public class SearchResult extends BasePage{
    public SearchResult(MyWebDriver webDriver){
        super(webDriver);
    }

    public void resultsAreShown() {
        webDriver.waitForElementVisible(
                "Result stats", "//div[@id='result-stats']");
    }
}

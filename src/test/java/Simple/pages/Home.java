package Simple.pages;


import Simple.utils.MyWebDriver;
import Simple.utils.MyWebElement;

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

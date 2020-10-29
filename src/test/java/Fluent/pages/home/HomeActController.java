package Fluent.pages.home;


import Fluent.utils.MyWebDriver;
import Fluent.utils.MyWebElement;
import static Fluent.utils.DriverFactory.getDriver;
import static Fluent.pages.home.Home.*;

public class HomeActController {

    private final MyWebDriver webDriver = getDriver();

    public void searchForPizza() {
        MyWebElement searchInputButton = webDriver.waitForElementVisible("Search input box", SeachInput());
        searchInputButton.sendKeys("pizza");
        webDriver.waitForElementVisible(
                "Search button", "//div[@jsname='VlcLAe']//input[@value='Google Search']").click();
    }

    public HomeActController typeWordsInSearchBox(String words){
        MyWebElement searchInputButton = webDriver.waitForElementVisible("Search input box", SeachInput());
        searchInputButton.sendKeys(words);
        return this;
    }

    public HomeActController doSomthing(){
        return this;
    }

    public HomeActController doSomthingElse() {
        return this;
    }
}

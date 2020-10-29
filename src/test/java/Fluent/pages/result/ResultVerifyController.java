package Fluent.pages.result;

import Fluent.utils.MyWebDriver;
import org.junit.jupiter.api.Assertions;

import static Fluent.utils.DriverFactory.getDriver;

public class ResultVerifyController {
    private final MyWebDriver webDriver = getDriver();

    public void resultsAreShown() {
        Assertions.assertTrue(
                webDriver.waitForElementVisible("Result stats", "//div[@id='result-stats']")
                        .isDisplayed(), "Search result stats is not found!");

    }
}

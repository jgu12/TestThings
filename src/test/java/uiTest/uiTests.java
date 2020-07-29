package uiTest;

import org.junit.jupiter.api.*;
import pages.Home;
import pages.SearchResult;
import utils.MyWebDriver;

public class uiTests {

    private MyWebDriver webDriver;
    private Home home;
    private SearchResult searchResult;

    private void setUpDriver(){
        webDriver = new MyWebDriver();
        webDriver.goToUrl("https://www.google.com");
    }

    private void setUpPages(){
        home = new Home(webDriver);
        searchResult = new SearchResult(webDriver);
    }

    @BeforeEach
    public void init(){
        setUpDriver();
        setUpPages();
    }

    @Test
    @DisplayName("TEST_1")
    public void test1(){
        home.search();
        Assertions.assertTrue(searchResult.resultsAreShown());
    }

    @AfterEach
    public void tearDown(){
        webDriver.close();
    }

}

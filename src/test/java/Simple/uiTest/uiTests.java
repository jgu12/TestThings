package Simple.uiTest;

import Simple.utils.MyWebDriver;
import org.junit.jupiter.api.*;
import Simple.pages.Home;
import Simple.pages.SearchResult;

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
        searchResult.resultsAreShown();
    }

    @AfterEach
    public void tearDown(){
        webDriver.close();
    }

}

package Fluent.tests;

import Fluent.utils.DriverFactory;
import Fluent.utils.MyWebDriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

public abstract class TestBase {
    protected MyWebDriver webDriver;


    private void setUpDriver(){
        webDriver = DriverFactory.getDriver();
        webDriver.goToUrl("https://www.google.com");
    }

    protected abstract void setUpPages();

    @BeforeEach
    public void init(){
        setUpDriver();
        setUpPages();
    }

    @AfterEach
    public void tearDown(){
        webDriver.close();
    }
}

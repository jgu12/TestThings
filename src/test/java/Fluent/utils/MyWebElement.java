package Fluent.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.util.function.Consumer;

public class MyWebElement {
    private WebElement element;

    private final MyWebDriver driver;
    private final String name;
    private static final Logger logger = LogManager.getLogger(MyWebDriver.class);

    public MyWebElement(MyWebDriver d, WebElement e, String name){
        this.driver = d;
        this.element = e;
        this.name = name;
    }

    private Consumer<String> errorHandlingDecorator(Consumer<String> f) {
        Consumer<String> fun = (args) -> {
            System.out.println(">>>before $method on element: "+ this.name);
            try{
                f.accept(args);
            } catch (Exception e){
                //take screenshot, DOM snapshot, etc.
                throw new RuntimeException("Exception happened during $method on element: "+this.name);
            }
            System.out.println(">>>after $method on element: "+ this.name);
        };
        return fun;
    }

    private final Consumer<String> doSendKeys = args -> {
        this.element.sendKeys(args);
    };

    public void sendKeys(String input){
        Consumer<String> decorator = errorHandlingDecorator(doSendKeys);
        decorator.accept(input);
    }

    public void click(){
        logger.info("Clicking on element: " + this.name);
//        new RandomFailure().generate();
        this.element.click();
    }

    public boolean isDisplayed() {
        return this.element.isDisplayed();
    }
}

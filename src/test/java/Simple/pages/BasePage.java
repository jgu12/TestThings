package Simple.pages;

import Simple.utils.MyWebDriver;

public class BasePage {
    final MyWebDriver webDriver;

    public BasePage(MyWebDriver webDriver){
        this.webDriver = webDriver;
    }
}

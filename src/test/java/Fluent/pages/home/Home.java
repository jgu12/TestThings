package Fluent.pages.home;

import Fluent.pages.BasePage;
import Fluent.utils.MyWebDriver;
import org.openqa.selenium.By;

public class Home extends BasePage {

    private HomeActController act;
    private HomeVerifyController verify;

    public HomeActController act(){
        return act;
    }

    public HomeVerifyController verify(){
        return verify;
    }

    public Home(MyWebDriver webDriver){
        super(webDriver);
        this.act = new HomeActController();
        this.verify = new HomeVerifyController();
    }

    //a way to group all locators in one place, and delegate all other actions & verifications to controllers
    public static By SearchButton(){
        return By.xpath("//div[@jsname='VlcLAe']//input[@value='Google Search']");
    }

    public static By SeachInput(){
        return By.xpath("//input[contains(@class, 'gLFyf')]");
    }
}

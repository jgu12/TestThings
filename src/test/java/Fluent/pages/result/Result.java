package Fluent.pages.result;

import Fluent.pages.BasePage;
import Fluent.utils.MyWebDriver;

public class Result extends BasePage {

    private ResultVerifyController verify;

    public ResultVerifyController verify(){
        return verify;
    }

    public Result(MyWebDriver webDriver){
        super(webDriver);
        this.verify = new ResultVerifyController();
    }
}

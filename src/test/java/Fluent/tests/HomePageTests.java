package Fluent.tests;

import Fluent.pages.home.Home;
import Fluent.pages.result.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HomePageTests extends TestBase{
    protected Home home;
    protected Result result;

    protected void setUpPages(){
        home = new Home(webDriver);
        result = new Result(webDriver);
    }

    @Test
    @DisplayName("TEST_1")
    public void searchTest(){

        /*Fluent implementation, feels like syntax sugar
        * pros: easier to read?
        * cons: had to introduce bunch of statics, impact parallel runs?
        *       make it hard to debug?
        *       can cause messed up class & method chaining, need to be caution
        * */

        home.verify()
                .somethingExists()
                .somethingElseExists();

        home.act()
                .typeWordsInSearchBox("abc")
                .typeWordsInSearchBox("efg")
                .doSomthing()
                .doSomthingElse()
                .searchForPizza();

        result.verify().resultsAreShown();
    }
}

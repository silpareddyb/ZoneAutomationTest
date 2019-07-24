package com.zone.automationpractice.website.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by silpaketireddy on 24/07/2019.
 */

public class SignOffPage extends CommonPage {

    @FindBy(id = "header")
    private WebElementFacade headerTab;

    public void signOff(){
        headerTab.findElement(By.cssSelector("*[title='Log me out']")).click();
    }

}

package com.zone.automationpractice.website.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by silpaketireddy on 24/07/2019.
 */

public class CommonPage extends PageObject {


    protected void clickButton(String btnName){
        WebElement formBtn = getButton(btnName);
        new WebDriverWait(getDriver(), 60).until(
                ExpectedConditions.visibilityOf(formBtn));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", formBtn);
        formBtn.click();

    }

    protected WebElement getButton(String name){
        net.serenitybdd.core.annotations.findby.By button = net.serenitybdd.core.annotations.findby.By.buttonText(name);
        withTimeoutOf(180, TimeUnit.SECONDS).waitFor(ExpectedConditions.presenceOfElementLocated(button));
        return getDriver().findElement(button);

    }

    protected String genText() {
        String randomText = "abcdefghijklmnopqrstuvwxyz";
        int length = 4;
        String temp = RandomStringUtils.random(length, randomText);
        return temp;
    }
}

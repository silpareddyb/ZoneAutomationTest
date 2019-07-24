package com.zone.automationpractice.website.pages;

import com.zone.automationpractice.website.utilities.PropertyMap;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByTagName;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by silpaketireddy on 24/07/2019.
 */

public class HomePage extends CommonPage{

    final String loginWebsite = PropertyMap.getProperty("application.website");
    @FindBy(id = "block_top_menu")
    private WebElementFacade itemMenu;

    @FindBy(xpath = "//*[@id='center_column']/ul/li[2]/div/div[1]/div/a[1]/img")
    private WebElementFacade productImage;

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
    private WebElementFacade dressTab;

    @FindBy(className = "button-container")
    private WebElementFacade proceedToCheckout;


    public void logInToApplication() {
        getDriver().navigate().to(loginWebsite);
        getDriver().manage().window().maximize();
    }

    public void selectOneItemfromItemType(String itemTab) {
        if(dressTab.getText().equalsIgnoreCase(itemTab))
            dressTab.click();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(productImage));
        productImage.click();
        WebElement productDetails = getDriver().findElement(By.tagName("iframe"));
        getDriver().switchTo().frame(productDetails);
        clickButton("Add to cart");
        System.out.println(proceedToCheckout.findElement(By.tagName("a")).getText());
        proceedToCheckout.findElement(By.tagName("a")).click();
    }

    public void selectItemType(String itemTab){
        if(dressTab.getText().equalsIgnoreCase(itemTab))
            dressTab.click();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(productImage));
        productImage.click();
        WebElement productDetails = getDriver().findElement(By.tagName("iframe"));
        getDriver().switchTo().frame(productDetails);
    }
}


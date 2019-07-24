package com.zone.automationpractice.website.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by silpaketireddy on 24/07/2019.
 */

public class QuickVeiwPage extends CommonPage{


    @FindBy(id = "group_1")
    private WebElementFacade itemSize;

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
    private WebElementFacade dressTab;

    @FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img")
    private WebElementFacade productImage;

    public void changeSize(String itemsize){
        userSetsDDOption(itemsize);
    }

    public void changeitemColour(String itemcolour){
        getDriver().findElement(By.id("color_24")).click();
        clickButton("Add to cart");
    }

    public void userSetsDDOption(final String dropdownOption) {
        Select dropdown = new Select(getDriver().findElement(By.name("group_1")));
        dropdown.selectByVisibleText(dropdownOption);
        clickButton("Add to cart");
    }

    public void verifyProductAttributes(String expectedParameter){
        WebElement productAttribute = getDriver().findElement(By.id("layer_cart_product_attributes"));
        assert productAttribute.getText().contains(expectedParameter);

    }

    public void quickViewOnSelectedItem(){
        if(dressTab.getText().equalsIgnoreCase("DRESSES"))
            dressTab.click();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(productImage));
        productImage.click();
    }

    public void verifytheitemIsviewed(){
        assert getDriver().findElement(By.tagName("iframe")).isDisplayed();
    }
}

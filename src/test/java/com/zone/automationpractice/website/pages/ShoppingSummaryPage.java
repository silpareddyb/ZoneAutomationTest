package com.zone.automationpractice.website.pages;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

/**
 * Created by silpaketireddy on 24/07/2019.
 */

public class ShoppingSummaryPage extends CommonPage {

    private static final String FIRST_NAME = "First Name";
    private static final String LAST_NAME = "Last Name";
    private static final String PASSWORD = "Password";
    private static final String ADDRESS = "Address";
    private static final String CITY = "City";
    private static final String STATE = "State";
    private static final String POSTAL_CODE = "PostalCode";
    private static final String COUNTRY = "Country";
    private static final String MOBILENUMBER = "Mobile phone";

    @FindBy(xpath = "//*[@id='center_column']/p[2]/a[1]/span")
    private WebElementFacade proceedToCheckout;

    @FindBy(id = "SubmitCreate")
    private WebElementFacade accountButton;

    @FindBy(id = "email_create")
    private WebElementFacade emailId;

    @FindBy(id = "customer_firstname")
    private WebElementFacade firstname;

    @FindBy(id = "customer_lastname")
    private WebElementFacade lastname;

    @FindBy(id = "firstname")
    private WebElementFacade address_firstname;

    @FindBy(id = "lastname")
    private WebElementFacade address_lastname;

    @FindBy(id = "address1")
    private WebElementFacade address1;

    @FindBy(id = "passwd")
    private WebElementFacade password;

    @FindBy(id = "city")
    private WebElementFacade city;

    @FindBy(id = "postcode")
    private WebElementFacade postcode;

    @FindBy(id = "phone_mobile")
    private WebElementFacade phonemobile;

    @FindBy(id = "uniform-cgv")
    private WebElementFacade acceptCheckbox;

    @FindBy(name = "processAddress")
    private WebElementFacade processAddress;

    @FindBy(id = "HOOK_PAYMENT")
    private WebElementFacade paymentmethod;

    String randomEmailId = genText()+"@gmail.com";

    public void clickCheckoutButton(){
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(proceedToCheckout));
        proceedToCheckout.click();
    }

    public void createAccount() {
        emailId.clear();
        Random name = new Random();
        emailId.sendKeys(randomEmailId);
        accountButton.click();
        List<WebElement> genders = getDriver().findElements(By.name("id_gender"));
        for (WebElement gender : genders) {
            if (gender.getText().equalsIgnoreCase("Mrs.")) ;
            gender.isSelected();
        }
                    firstname.sendKeys("automationtester");
                    lastname.sendKeys("testing");
                    password.sendKeys("Sahiti@143");
                    address_firstname.sendKeys("automationtester");
                    address_lastname.sendKeys("testing");
                    address1.sendKeys("flat20");
                    city.sendKeys("swindon");
                    Select statesDropDown = new Select(getDriver().findElement(By.id("id_state")));
                    statesDropDown.selectByVisibleText("New York");
                    postcode.sendKeys("10001");
                    Select countries = new Select(getDriver().findElement(By.id("id_country")));
                    statesDropDown.selectByValue("21");
                    phonemobile.sendKeys("01234567812");
                    clickButton("Register");
                    processAddress.click();
            }

            public void acceptTermsandConditioins () {
                new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(acceptCheckbox));
                acceptCheckbox.click();
                getDriver().findElement(By.xpath("//*[@id='form']/p/button/span")).click();
            }

            public void paymentMethod () {
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(false);", paymentmethod);
                paymentmethod.findElement(By.cssSelector("*[title='Pay by bank wire']")).click();
                clickButton("I confirm my order");
            }

            public void verifyOrder () {
                new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOf(getDriver().findElement(org.openqa.selenium.By.className("box"))));
                assert getDriver().findElement(org.openqa.selenium.By.className("box")).getText().contains("Your order on My Store is complete.");
            }
        }


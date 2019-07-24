package com.zone.automationpractice.website.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import net.serenitybdd.core.Serenity;
import com.zone.automationpractice.website.steps.serenity.EndUserSteps;

import cucumber.api.java8.En;

import java.util.Map;

/**
 * Created by silpaketireddy on 24/07/2019.
 */

public class DefinitionSteps implements En {

    @Steps
    EndUserSteps user;

    @Given("I am on AutomationPractice Application")
    public void logInToApplicationHomePage() {
            user.userLogsIn();
    }

    @When("I Select an item in '(.*)' and click Add to Cart")
    public void selectAnItemFromGivenItemType(String itemType) {
        user.selectAnItem(itemType);
    }

    @And("Click Proceed to checkout button")
    public void clickCheckoutButton() {
        user.clickCheckoutButton();
    }

    @And("Create an account during checkout")
    public void createAccount() {
        user.createAccount();
    }

    @And("Accept Terms and Condition for payment")
    public void acceptTermsAndConditions() {
        user.acceptTermsandConditioins();
    }

    @And("Select Payment method via Wire and confirm the order")
    public void paymentMethod() {
        user.paymentMethod();
    }

    @And("I verify the selected order is done")
    public void verifyOrder() {
        user.verifyOrder();
    }

    @And("Sign off the application")
    public void signOff() {
        user.signOff();
    }

    @Then("I should see quick view of the selected items")
    public void verifyQuickVeiwOfItem() {
        user.viewTheItem();
    }

    @When("I Select an item and click for quick view")
    public void clickOnQuickView() {
        user.quickView();
    }

    @When("I Select an item in '(.*)' tab")
    public void selectItemType(String itemTab) {
        user.selectItemType(itemTab);
    }

    @Then("change the size of the selected item to '(.*)'")
    public void changeitemSize(String itemsize) {
        user.changeTheSize(itemsize);
    }
    @Then("change the color of the selected item to '(.*)'")
    public void changeitemColour(String itemcolour) {
        user.changeitemColour(itemcolour);
    }

    @And("I should see dropdown Option for product attribute as '(.*)'")
    public void verifyProductAttributes(String expectedparameter) {
        user.verifyProductAttributes(expectedparameter);
    }


}

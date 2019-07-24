package com.zone.automationpractice.website.steps.serenity;

import com.zone.automationpractice.website.pages.HomePage;
import com.zone.automationpractice.website.pages.QuickVeiwPage;
import com.zone.automationpractice.website.pages.ShoppingSummaryPage;
import com.zone.automationpractice.website.pages.SignOffPage;
import net.thucydides.core.annotations.Step;

import java.util.Map;

/**
 * Created by silpaketireddy on 24/07/2019.
 */

public class EndUserSteps {

    HomePage homePage;
    ShoppingSummaryPage summaryPage;
    SignOffPage logOffPage;
    QuickVeiwPage quickLookPage;

    @Step
    public void userLogsIn() {
        homePage.logInToApplication();
    }

    @Step
    public void selectAnItem(String ItemType) {
        homePage.selectOneItemfromItemType(ItemType);
    }

    @Step
    public void clickCheckoutButton() {
        summaryPage.clickCheckoutButton();
    }

    @Step
    public void createAccount() {
        summaryPage.createAccount();
    }

    @Step
    public void acceptTermsandConditioins() {
        summaryPage.acceptTermsandConditioins();
    }

    @Step
    public void paymentMethod() {
        summaryPage.paymentMethod();
    }

    @Step
    public void verifyOrder() {
        summaryPage.verifyOrder();
    }

    @Step
    public void signOff() {
        logOffPage.signOff();
    }

    @Step
    public void viewTheItem() {
        quickLookPage.verifytheitemIsviewed();
    }

    @Step
    public void quickView() {
        quickLookPage.quickViewOnSelectedItem();
    }

    @Step
    public void selectItemType(String itemType) {
        homePage.selectItemType(itemType);
    }

    @Step
    public void changeTheSize(String itemsize) {
        quickLookPage.changeSize(itemsize);
    }
    @Step
    public void changeitemColour(String itemcolour) {
        quickLookPage.changeitemColour(itemcolour);
    }

    @Step
    public void verifyProductAttributes(String expectedParameter) {
        quickLookPage.verifyProductAttributes(expectedParameter);
    }

}
package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class DemoWebShopShoppingCartPage {

    private Page page;

    private String shoppingCartText = ".page-title h1";
    private String termsAndService = "//input[@id='termsofservice']";
    private String checkoutCheckBox = "//button[@id='checkout']";
    private String cross_button = "//button[@title='close']";

    public DemoWebShopShoppingCartPage(Page page) {
        this.page = page;
    }

    public String verifyPageTitle() {
        return page.locator(shoppingCartText).innerText().trim();
    }

    public void clickOnTermAndService() throws InterruptedException {
        page.locator(termsAndService).click();
        Thread.sleep(1000);
    }

    public DemoWebShopCheckOutPage clickOnCheckOutCheckBox() throws InterruptedException {
        page.locator(checkoutCheckBox).click();
        Thread.sleep(1000);
        return new DemoWebShopCheckOutPage(page);
    }

    public DemoWebShopCheckOutPage verifyPrompt() throws InterruptedException {
        //page.locator(termsAndService).click();
        page.locator(checkoutCheckBox).click();
        Thread.sleep(1000);
        if (page.locator(cross_button).isVisible()) {
            page.locator(cross_button).click();
            Thread.sleep(1000);
            page.locator(termsAndService).click();
            Thread.sleep(1000);
            page.locator(checkoutCheckBox).click();
            Thread.sleep(1000);
        }
        return new DemoWebShopCheckOutPage(page);
    }
}

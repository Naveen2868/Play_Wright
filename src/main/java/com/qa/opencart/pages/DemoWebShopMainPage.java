package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class DemoWebShopMainPage {

    private Page page;

    private String loginTop = ".ico-login";
    private String registerTop = ".ico-register";
    private String shoppingCartTop = ".ico-cart";
    private String wishListTop = ".ico-wishlist";

    public DemoWebShopMainPage(Page page) {
        this.page = page;
    }

    public DemoWebShopLoginPage clickOnLoginButton(){
        if (page.locator(loginTop).isVisible()) {
            System.out.println("user is able to see logged in successfully....");
            page.locator(loginTop).click();
        } else {
            System.out.println("user is not able to see logged in successfully....");
        }
        return new DemoWebShopLoginPage(page);
    }
}

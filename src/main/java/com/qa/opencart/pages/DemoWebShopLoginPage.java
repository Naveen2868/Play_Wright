package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class DemoWebShopLoginPage {
    private Page page;

    private String email = "#Email";
    private String password = "#Password";
    private String forgotPwdLink = "//a[@href='/passwordrecovery']";
    private String loginButton = ".button-1.login-button";

    private String logoutTop = ".ico-logout";


    public DemoWebShopLoginPage(Page page) {
        this.page = page;
    }

    public DemoWebShopHomePage loginDetails() {
        page.fill(email, "naveen1987@gmail.com");
        page.fill(password, "naveen123");
        page.click(loginButton);
        page.locator(logoutTop).waitFor();
        return new DemoWebShopHomePage(page);
    }

    public String getTitle(){
        System.out.println("Title of the Login page is - "+page.title());
        return page.title().trim();
    }

}

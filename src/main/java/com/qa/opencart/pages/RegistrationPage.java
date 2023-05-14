package com.qa.opencart.pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitUntilState;

import static com.qa.opencart.factory.PlaywrightFactory.getPlaywright;

public class RegistrationPage {

    private Page page;

    // 1. String Locators - OR
    private String firstName = "#input-firstname";
    private String lastName = "#input-lastname";
    private String email = "#input-email";
    private String telephone = "#input-telephone";
    private String password = "#input-password";
    private String confirmPassword = "#input-confirm";
    private String terms = "input[name='agree']";
    private String continueButton = ".btn.btn-primary";


    // 2. page constructor:
    public RegistrationPage(Page page) {
        this.page = page;
    }

    public String getRegisterHomePageTitle() {
        String title =  page.title();
        System.out.println("getRegisterHomePageTitle: " + title);
        return title;
    }

    public void registrationUser(){
        page.fill(firstName,"naveen");
        page.fill(lastName,"reddya");
        page.fill(email,"naveenseleniumwebdriver@gmail.com");
        page.fill(telephone,"9908099680");
        page.fill(password,"qwert@123!");
        page.fill(confirmPassword,"qwert@123!");
        page.click(terms);
        page.click(continueButton);
    }

    public void getUser(){
        Locator locator = page.locator("");

        Download download = page.waitForDownload(()->{
            page.locator("()->window").click();
        });
        /*page.navigate("https://example.com", new Page.NavigateOptions()
                .setWaitUntil(WaitUntilState.NETWORKIDLE));*/

        JSHandle jsHandle = page.evaluateHandle("()->window");
       ElementHandle elementHandle = page.querySelector("");

       /*getPlaywright().chromium().launch(
                new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));*/

    }











}

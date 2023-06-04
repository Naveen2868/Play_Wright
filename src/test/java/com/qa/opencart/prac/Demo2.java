package com.qa.opencart.prac;

import com.microsoft.playwright.*;

public class Demo2 {

    public static void main(String[] args) throws InterruptedException {


        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext1 = browser.newContext();
        Page page1 = browserContext1.newPage();
        page1.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //page1.locator("//*[contains(text(),'Careers')]").scrollIntoViewIfNeeded();
        Thread.sleep(2000);
        Page windowPopup = page1.waitForPopup(() -> {
            //page1.click(".orangehrm-login-footer a:nth-child(3)");
            page1.click("a[target='_blank']");
        });
        windowPopup.waitForLoadState();
        windowPopup.navigate("https://selectorshub.com/xpath-practice-page/");
        Thread.sleep(2000);
        System.out.println("child window title is :" + windowPopup.title());
        System.out.println("child window url is :" + windowPopup.url());

        //windowPopup.locator("//a[@href='/settings']").click();
        //Thread.sleep(4000);
        windowPopup.close();

        System.out.println("parent window title is :" + page1.title());
        page1.context().browser().close();


    }

}

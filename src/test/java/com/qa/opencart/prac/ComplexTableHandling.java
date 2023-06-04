package com.qa.opencart.prac;

import com.microsoft.playwright.*;

public class ComplexTableHandling {

    public static void main(String[] args) throws InterruptedException {


        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext1 = browser.newContext();
        Page page = browserContext1.newPage();
        page.navigate("https://selectorshub.com/xpath-practice-page/");

        /*selectCheckBox(page,"Garry.White");
        selectCheckBox(page,"Jasmine.Morgan");
        selectCheckBox(page,"Joe.Root");
        selectCheckBox(page,"John.Smith");
        selectCheckBox(page,"Jordan.Mathews");
        selectCheckBox(page,"Kevin.Mathews");*/

        String s1 = page.locator("h4:has-text('UserName')").first().textContent();
        String s2 = page.locator("text=UserName").first().textContent();
        String s3 = page.locator("'UserName'").first().textContent();
        System.out.println(s1+"-"+s2+"-"+s3);



    }

    public static void selectCheckBox(Page page,String text){
        Locator rows = page.locator("#resultTable tr");
        rows.locator(":scope",new Locator.LocatorOptions()
                        .setHasText(text))
                .locator("//input[@type='checkbox']")
                .click();
       // rows.locator(":scope").allInnerTexts().forEach( e -> System.out.println(e) );
    }
}

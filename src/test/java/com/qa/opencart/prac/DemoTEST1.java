package com.qa.opencart.prac;


import com.microsoft.playwright.*;

public class DemoTEST1 {

    public static void main(String[] args){
      /*  String s = "Order Number: 1433134";
        s = s.replaceAll("\\D+","");
        System.out.println(s);*/

        Playwright playwright = Playwright.create();
        Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext1 = browser.newContext();
        BrowserContext browserContext2 = browser.newContext();

        Page page1 = browserContext1.newPage();
        Page page2 = browserContext2.newPage();

        page1.navigate("https://selectorshub.com/xpath-practice-page/");
        page2.navigate("https://playwright.dev/java/docs/input#keys-and-shortcuts");


    }
}

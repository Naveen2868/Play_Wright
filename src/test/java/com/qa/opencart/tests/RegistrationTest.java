package com.qa.opencart.tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RegistrationTest extends BaseTest {

    private RegistrationPage registrationPage;

    @Test
    public void registerUserTest() {
        registrationPage = homePage.registerPage();
        String title = registrationPage.getRegisterHomePageTitle();
        System.out.println(title);
        registrationPage.registrationUser();
    }

    @Test
    void statusBecomesSubmitted() {

        try (Playwright playwright = Playwright.create()) {
           /* page.navigate("https://example.com", new Page.NavigateOptions()
                    .setWaitUntil(WaitUntilState.NETWORKIDLE));*/

            BrowserType browserType = playwright.firefox();
            Browser browser = browserType.launch();
            BrowserContext browserContext = browser.newContext();

            Page page = browserContext.newPage();
            page.navigate("https://example.com");
            browser.close();

        }
        /*//page.getByRole(AriaRole.BUTTON).click();
        assertThat(page.locator(".status")).hasText("Submitted");
        assertThat(page.locator(".status")).not().containsText("Submitted");*/
    }
}

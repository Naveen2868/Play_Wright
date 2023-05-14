package com.qa.opencart.base;

import java.util.Properties;

import com.qa.opencart.pages.DemoWebShopMainPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {

	PlaywrightFactory pf;
	protected Page page;
	protected Properties prop;
	protected HomePage homePage;
	protected LoginPage loginPage;
	protected DemoWebShopMainPage demoWebShopMainPage;

	@Parameters({ "browser" })
	@BeforeTest
	public void setup(String browserName) {
		pf = new PlaywrightFactory();
		prop = pf.init_prop();
		if (browserName != null) {
			prop.setProperty("browser", browserName);
		}
		page = pf.initBrowser(prop);
		demoWebShopMainPage = new DemoWebShopMainPage(page);
		homePage = new HomePage(page);
	}

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

	public void minWait() throws InterruptedException {
		Thread.sleep(2*1000);
	}

	public void maxWait() throws InterruptedException {
		Thread.sleep(10*1000);
	}

	public void mediumWait() throws InterruptedException {
		Thread.sleep(5*1000);
	}

}

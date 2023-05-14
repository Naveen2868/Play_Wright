package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

	private Page page;

	// 1. String Locators - OR
	private String search = "input[name='search']";
	private String searchIcon = "div#search button";
	private String searchPageHeader = "div#content h1";
	private String loginLink = "a:text('Login')";
	private String myAccountLink = "a[title='My Account']";
	private String register = "a:text('Register')";
	

	// 2. page constructor:
	public HomePage(Page page) {
		this.page = page;
	}

	// 3. page actions/methods:
	public String getHomePageTitle() {
		String title =  page.title();
		System.out.println("page title: " + title);
		return title;
	}

	public String getHomePageURL() {
		String url =  page.url();
		System.out.println("page url : " + url);
		return url;
	}

	public String doSearch(String productName) {
		page.fill(search, productName);
		page.click(searchIcon);
		String header =  page.textContent(searchPageHeader);
		System.out.println("search header: " + header);
		return header;
	}
	
	public LoginPage navigateToLoginPage() {
		page.click(myAccountLink);
		page.click(loginLink);
		return new LoginPage(page);
	}

	public RegistrationPage registerPage() {
		page.click(myAccountLink);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		page.click(register);
		return new RegistrationPage(page);
	}

}

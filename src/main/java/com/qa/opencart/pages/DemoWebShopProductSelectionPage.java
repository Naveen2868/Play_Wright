package com.qa.opencart.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DemoWebShopProductSelectionPage {

    private Page page;

    private String electronics = "//ul[@class='top-menu']/li[3]/a";
    private String product_cellPhones = "//ul[@class='top-menu']/li[3]/ul/li/a[@href='/cell-phones']";
    private String addToCartButtons = "(//input[@value='Add to cart'])[1]";

    private String shoppingCart = "#topcartlink .ico-cart";
    private String goToCart = "//input[@value='Go to cart']";
    private String shoppingCartText = ".page-title h1";

    public DemoWebShopProductSelectionPage(Page page) {
        this.page = page;
    }


    public String verifyPageTitle(){
        return page.locator(shoppingCartText).innerText().trim();
    }

    public void addProducts() throws InterruptedException {
        //Locator locator = page.locator(addToCartButtons);
        //System.out.println("Elements count is:"+locator.count());

        for (int i=0;i<5;i++){
            //locator.nth(i).click();
            page.locator(addToCartButtons).click();
            Thread.sleep(1000);
        }

    }

    public DemoWebShopShoppingCartPage mouseOverOnShoppingCart() throws InterruptedException {
        page.locator(shoppingCart).hover();
       // Thread.sleep(1000);
        page.locator(goToCart).click();
        Thread.sleep(1000);
        return new DemoWebShopShoppingCartPage(page);
    }


}

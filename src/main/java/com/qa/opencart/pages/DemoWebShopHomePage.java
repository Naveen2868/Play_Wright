package com.qa.opencart.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DemoWebShopHomePage {

    private Page page;

    private String logoutTop = ".ico-logout";
    private String myAccountTop = "(//a[@class='account'])[1]";
    private String wishListTop = ".ico-cart";
    private String shoppingCartTop = ".ico-wishlist";

    private String electronics = "//ul[@class='top-menu']/li[3]/a";
    private String product_cellPhones = "//ul[@class='top-menu']/li[3]/ul/li/a[@href='/cell-phones']";
    private String title = ".page-title h1";

    public DemoWebShopHomePage(Page page) {
        this.page = page;
    }

    public DemoWebShopProductSelectionPage mouseOverOnElectronicsTab() throws InterruptedException {
        page.locator(electronics).hover();
        Thread.sleep(1000);
        page.locator(product_cellPhones).click();
        Thread.sleep(1000);
        return new DemoWebShopProductSelectionPage(page);
    }

    public String  verifyText(){
       return page.locator(title).innerText().trim();
    }

    public String verifyMyAccount(){
        String email = page.locator(myAccountTop).innerText();
        return email;
    }

    public boolean verifyLogout(){
        if(page.locator(logoutTop).isVisible()){
            return true;
        }
      return false;
    }

}

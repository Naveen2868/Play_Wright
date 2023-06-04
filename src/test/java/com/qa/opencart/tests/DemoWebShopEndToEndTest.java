package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoWebShopEndToEndTest extends BaseTest {

    private DemoWebShopLoginPage loginPage;
    private DemoWebShopHomePage homePage;
    private DemoWebShopProductSelectionPage productSelectionPage;
    private DemoWebShopShoppingCartPage shoppingCartPage;
    private DemoWebShopCheckOutPage checkOutPage;

    @Test
    public void loginPageNavigationTest() throws InterruptedException {
        loginPage = demoWebShopMainPage.clickOnLoginButton();
        loginPage.getTitle();
        minWait();
        homePage = loginPage.loginDetails();
        minWait();
        Assert.assertEquals(homePage.verifyMyAccount(), "naveen1987@gmail.com");
        Assert.assertTrue(homePage.verifyLogout());

        productSelectionPage = homePage.mouseOverOnElectronicsTab();
        Assert.assertEquals("Cell phones", productSelectionPage.verifyPageTitle());
        productSelectionPage.addProducts();
        minWait();

        shoppingCartPage = productSelectionPage.mouseOverOnShoppingCart();
        minWait();
        Assert.assertEquals("Shopping cart", shoppingCartPage.verifyPageTitle());

        checkOutPage = shoppingCartPage.verifyPrompt();
        minWait();
        Assert.assertEquals("Checkout", checkOutPage.verifyPageTitle());

        //Billing
        checkOutPage.enterTheBillingAddressDetails();
        checkOutPage.continueButtonForBilling();
        mediumWait();

        //Shipping address
        checkOutPage.continueButtonForShipping();
        mediumWait();

        //Shipping method
        checkOutPage.continueButtonForShippingMethod();
        mediumWait();

        //Payment method
        checkOutPage.selectPaymentMethod(2);
        checkOutPage.continueButtonForPaymentMethod();
        mediumWait();

        //Payment information
        checkOutPage.enterPaymentInfoDetails();
        checkOutPage.continueButtonForPaymentInfo();
        mediumWait();

        //confirm
        checkOutPage.continueButtonForConfirm();
        mediumWait();

        String message = checkOutPage.getSuccessOrderMessage();
        String orderNumberFromCheckOutPage = checkOutPage.getOrderNumber();
        Assert.assertEquals(message, "Your order has been successfully processed!");

        checkOutPage.continueButton_orderConfirmed();
        System.out.println(message + "<<<<<>>>>" + orderNumberFromCheckOutPage);

        //From order list verifying order
        checkOutPage.clickOnAccount();
        String orderFromOrderList = checkOutPage.getOrderFromOrderList();
        Assert.assertEquals(orderFromOrderList, orderNumberFromCheckOutPage);
    }

}

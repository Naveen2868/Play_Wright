package com.qa.opencart.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class DemoWebShopCheckOutPage {

    private Page page;

    private String checkoutText = ".page-title h1";

    public DemoWebShopCheckOutPage(Page page) {
        this.page = page;
    }

    public String verifyPageTitle() {
        return page.locator(checkoutText).innerText().trim();
    }

    //Billing address
    private String companyName = "//label[@for='BillingNewAddress_Company']/following-sibling::input";
    private String city = "//label[@for='BillingNewAddress_City']/following-sibling::input";
    private String address1 = "//label[@for='BillingNewAddress_Address1']/following-sibling::input";
    private String address2 = "//label[@for='BillingNewAddress_Address2']/following-sibling::input";
    private String zipcode = "//label[@for='BillingNewAddress_ZipPostalCode']/following-sibling::input";
    private String phoneNumber = "//label[@for='BillingNewAddress_PhoneNumber']/following-sibling::input";
    private String faxNumber = "//label[@for='BillingNewAddress_FaxNumber']/following-sibling::input";

    private String dropdownList = "//*[@id='BillingNewAddress_CountryId']";
    private String continueButtonForBilling = "//div[@id='billing-buttons-container']/input";
    private String continueButtonForShipping = "//div[@id='shipping-buttons-container']/input";
    private String continueButtonForShippingMethod = "//div[@id='shipping-method-buttons-container']/input";
    private String continueButtonForPaymentMethod = "//div[@id='payment-method-buttons-container']/input";
    private String continueButtonForPaymentInfo = "//div[@id='payment-info-buttons-container']/input";
    private String continueButtonForConfirm = "//div[@id='confirm-order-buttons-container']/input";
    private String paymentMethods = "//div[@class='section payment-method']//input";

    private void enterCompanyName() {
        page.locator(companyName).fill("Altimetrik india pvt ltd.");
    }

    private void enterCity() {
        page.locator(city).fill("Hyderabad");
    }

    private void enterAddress1() {
        page.locator(address1).fill("H NO: 3-200");
    }

    private void enterAddress2() {
        page.locator(address2).fill("KRCR COLONY NEAR BY ABHAYAAS JUNIOR COLLEGE.");
    }

    private void enterZipcode() {
        page.locator(zipcode).fill("500082");
    }

    private void enterPhoneNumber() {
        page.locator(phoneNumber).fill("9908099680");
    }

    private void enterFaxNumber() {
        page.locator(faxNumber).fill("19871234");
    }

    private void selectCountry() {
        //page.locator(dropdownList).selectOption("India");
        page.locator(dropdownList).selectOption(new SelectOption().setLabel("India"));
       /* page.locator(dropdownList).selectOption(new SelectOption().setLabel("India"));
        page.locator(dropdownList).selectOption(new SelectOption().setValue("41"));
        page.locator(dropdownList).selectOption(new SelectOption().setIndex(1));*/
    }

    private String newAddress = "//*[@id='billing-address-select']";
    private void selectNewAddress(){
        page.locator(newAddress).selectOption(new SelectOption().setLabel("New Address"));
    }

    public void enterTheBillingAddressDetails() {
        selectNewAddress();

        enterCompanyName();
        selectCountry();
        enterCity();
        enterAddress1();
        enterAddress2();
        enterZipcode();
        enterPhoneNumber();
        enterFaxNumber();
    }

    //Billing
    public void continueButtonForBilling() {
        page.locator(continueButtonForBilling).click();
    }

    //Shipping address
    public void continueButtonForShipping() {
        page.locator(continueButtonForShipping).click();
    }

    //Shipping method
    public void continueButtonForShippingMethod() {
        page.locator(continueButtonForShippingMethod).click();
    }

    //Payment method
    public void continueButtonForPaymentMethod() {
        page.locator(continueButtonForPaymentMethod).click();
    }

    public void selectPaymentMethod(int index) {
        Locator payment_methods = page.locator(paymentMethods);
        for (int i = 0; i < payment_methods.count(); i++) {
            if (payment_methods.nth(i).getAttribute("id").contains(String.valueOf(index))) {
                payment_methods.nth(i).click();
                break;
            }
        }
    }

    //Payment information
    private String ccType = "//*[@id='CreditCardType']";
    private String expiryMonth = "//*[@id='ExpireMonth']";
    private String expiryYear = "//*[@id='ExpireYear']";
    private String cardHolderName = "//*[@id='CardholderName']";
    private String cardNumber = "//*[@id='CardNumber']";
    private String CVV = "//*[@id='CardCode']";

    private void enterCardHolderName() {
        page.locator(cardHolderName).fill("Aleti Naveen Reddy");
    }

    private void enterCardNumber() {
        page.locator(cardNumber).fill("4573570907288188");
    }

    private void enterCVVNumber() {
        page.locator(CVV).fill("123");
    }

    public void continueButtonForPaymentInfo() {
        page.locator(continueButtonForPaymentInfo).click();
    }

    private void selectCreditCardType() {
       // page.locator(ccType).selectOption("Visa");
        page.locator(ccType).selectOption(new SelectOption().setValue("Visa"));
    }

    private void selectMonth() {
        //page.locator(expiryMonth).selectOption("09");
        page.locator(expiryMonth).selectOption(new SelectOption().setValue("9"));
    }

    private void selectYear() {
       // page.locator(expiryYear).selectOption("2028");
        page.locator(expiryYear).selectOption(new SelectOption().setValue("2028"));
    }

    public void enterPaymentInfoDetails() {
        selectCreditCardType();
        enterCardHolderName();
        enterCardNumber();
        selectMonth();
        selectYear();
        enterCVVNumber();
    }

    //Confirm order

    private String message = ".title > strong";
    private String orderNumber_text = "//ul[@class='details']/li[1]";
    private String continueButton_orderConfirmed = ".buttons>input";
    private String thankYouText = ".page-title h1";

    public void continueButtonForConfirm() {
        page.locator(continueButtonForConfirm).click();
    }

    public String getSuccessOrderMessage() {
        String text = page.locator(message).innerText().trim();
        System.out.println("Order message:"+text);
        return text;
    }

    public String getOrderNumber() {
        String text = page.locator(orderNumber_text).innerText();
        text = text.replaceAll("\\D+","");
        return text;
    }

    public void continueButton_orderConfirmed() {
        page.locator(continueButton_orderConfirmed).click();
    }

    //--------------------------------------------

    private String orderNumber_in_orders = "(//div[@class='order-list']//strong)[1]";
    private String account = ".header-links .account";
    private String orders_in_listBox = ".listbox li:nth-child(3) a";
    public void clickOnAccount() throws InterruptedException {
        page.locator(account).click();
        page.locator(orders_in_listBox).click();
        Thread.sleep(1000);
    }

    public String getOrderFromOrderList(){
        String orderNumber = page.locator(orderNumber_in_orders).innerText();
        orderNumber = orderNumber.replaceAll("\\D+","");
        return orderNumber;
    }
}

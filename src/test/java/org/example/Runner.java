package org.example;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Runner {

    PreRequisites pre = new PreRequisites();
    Register re = new Register();
    Login lo = new Login();
    ChangeCurrency cc = new ChangeCurrency();
    CompareList cl = new CompareList();
    AddItemsToCart addItemsToCart = new AddItemsToCart();
    SendAGift sendAGift = new SendAGift();
    SearchProducts searchProducts = new SearchProducts();
    ShoppingCart shoppingCart = new ShoppingCart();
    CheckOut co = new CheckOut();


    @BeforeTest
    public void openBrowser() {

        pre.openBrowser();
    }

    @Test(priority = 1)
    public void register() {
        re.registeration();
    }

    @Test(priority = 2)
    public void login() {

        lo.loginToTheWebSite();

    }

    @Test(priority = 3)
    public void changeCurrency() {
        cc.changeWebSiteCurrency();
    }

    @Test(priority = 4)
    public void compareList() throws InterruptedException {
        cl.comparison();
    }

    @Test(priority = 5)
    public void addItemToCart() throws InterruptedException {
        addItemsToCart.addMultipleItemsToCart();

    }

    @Test(priority = 6)
    public void sendAGift() {

        sendAGift.sendGifts();
    }

    @Test(priority = 7)
    public void searchProducts() throws InterruptedException {
        searchProducts.searchForProducts();
    }

    @Test(priority = 8)
    public void shoppingCart() throws InterruptedException {
        shoppingCart.cart();
    }

    @Test(priority = 9)
    public void checkOut() throws InterruptedException {
        co.checkOutAndPay();
    }

    @AfterTest
    public void closeBrowser() {
        pre.closeBrowser();
    }
}

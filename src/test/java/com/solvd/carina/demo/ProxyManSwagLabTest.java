package com.solvd.carina.demo;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.solvd.carina.demo.dao.models.Orders;
import com.solvd.carina.demo.dao.models.Users;
import com.solvd.carina.demo.gui.pages.*;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProxyManSwagLabTest extends AbstractSwagLabTest {
    @Test
    public void testProxy() {
        LogInPage logInPage = new LogInPage(getDriver());
        logInPage.open();
        logInPage.addCookie(new Cookie("session-username", "standard_user"));
        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage.open();
        Assert.assertTrue(productsPage.isPageOpened(), "Product page is not opened");
        Users user = dbUserService.getUserByName(R.TESTDATA.get("problem_user"));
        List<Orders> orders = dbOrderService.getByUser(user);
        for (Orders order : orders) {
            productsPage.clickAddToCartButton(order.getProduct());
        }
        YourCartPage yourCartPage = productsPage.getTopBarMenu().clickCartIconButton();
        Assert.assertTrue(yourCartPage.isPageOpened(), "'Your Cart' page is not opened");
        for (Orders order : orders) {
            Assert.assertTrue(yourCartPage.isProductPresentInCart(order.getProduct()), "Product is not present in cart");
        }
        CheckoutYourInformationPage checkoutYourInformationPage = yourCartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutYourInformationPage.isPageOpened(), "'Checkout: Your information' page is not opened");
        checkoutYourInformationPage.typeFirstName(randomUtil.getRandomString(4));
        checkoutYourInformationPage.typeLastName(randomUtil.getRandomString(6));
        checkoutYourInformationPage.typePostalCode(randomUtil.getRandomNumber(3));
        CheckoutOverViewPage checkoutOverViewPage = checkoutYourInformationPage.clickContinueButton();
        Assert.assertTrue(checkoutOverViewPage.isPageOpened(), "'Checkout: Overview' page is not opened");
        CheckoutCompletePage checkoutCompletePage = checkoutOverViewPage.clickFinishButton();
        Assert.assertTrue(checkoutCompletePage.isPageOpened(), "'Checkout: Complete' page is not opened");
        Assert.assertTrue(checkoutCompletePage.isCompleteTextPresent(), "Complete text is not present");
    }
}

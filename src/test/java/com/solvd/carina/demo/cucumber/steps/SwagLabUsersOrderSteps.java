package com.solvd.carina.demo.cucumber.steps;

import com.solvd.carina.demo.dao.models.Orders;
import com.solvd.carina.demo.dao.models.Users;
import com.solvd.carina.demo.gui.pages.*;
import io.cucumber.java.en.*;
import org.testng.Assert;

import java.util.List;

public class SwagLabUsersOrderSteps extends AbstractSwagLabSteps {

    LogInPage logInPage = null;

    ProductsPage productsPage = null;

    YourCartPage yourCartPage = null;

    CheckoutYourInformationPage checkoutYourInformationPage = null;

    CheckoutOverViewPage checkoutOverViewPage = null;

    CheckoutCompletePage checkoutCompletePage = null;


    @Given("^I am on log in page$")
    public boolean iAmOnLogInPage() {
        logInPage = new LogInPage(getDriver());
        logInPage.open();
        return logInPage.isPageOpened();
    }

    @Then("^I type standard user name$")
    public void iTypeStandardUserName() {
        Users user = dbUserService.getUserByName("standard_user");
        logInPage.typeUserName(user.getUserName());
    }

    @And("^I type standard user password$")
    public void iTypeStandardPassword() {
        Users user = dbUserService.getUserByName("standard_user");
        logInPage.typePassword(user.getPassword());
    }

    @Then("^I click to log in button$")
    public void iClickToLogInButton() {
        productsPage = logInPage.clickLogInButton();
    }

    @When("^Page 'Product' should be open$")
    public void pageProductShouldBeOpen() {
        Assert.assertTrue(productsPage.isPageOpened(), "'Product' page is not opened");
    }

    @Then("^I click 'Add to cart' standard user's products according date base$")
    public void iClickAddToCartStandardUserProducts() {
        Users user = dbUserService.getUserByName("standard_user");
        List<Orders> orders = dbOrderService.getByUser(user);
        for (Orders order : orders) {
            productsPage.clickAddToCartButton(order.getProduct());
        }
    }

    @And("^I click to cart icon button on top bar menu$")
    public void iClickAddToCartButton() {
        yourCartPage = productsPage.getTopBarMenu().clickCartIconButton();
    }

    @When("^Page 'Your cart' should be open$")
    public void pageYourCartShouldBeOpen() {
        Assert.assertTrue(yourCartPage.isPageOpened(), "'Your Cart' page is not opened");
    }

    @And("^In cart should be standard user's products$")
    public void inCartShouldBeStandardUsersProducts() {
        Users user = dbUserService.getUserByName("standard_user");
        List<Orders> orders = dbOrderService.getByUser(user);
        for (Orders order : orders) {
            Assert.assertTrue(yourCartPage.isProductPresentInCart(order.getProduct()), "Product is not present in cart");
        }
    }

    @Then("^I click to 'Checkout' button$")
    public void iClickCheckoutButton() {
        checkoutYourInformationPage = yourCartPage.clickCheckoutButton();
    }

    @When("^Page 'Checkout: Your Information' should be open$")
    public void pageCheckoutYourInformationShouldBeOpen() {
        Assert.assertTrue(checkoutYourInformationPage.isPageOpened(), "'Checkout: Your information' page is not opened");
    }

    @Then("^I fill all necessary information to continue order$")
    public void iFillAllNecessaryInformation() {
        checkoutYourInformationPage.typeFirstName(randomUtil.getRandomString(4));
        checkoutYourInformationPage.typeLastName(randomUtil.getRandomString(6));
        checkoutYourInformationPage.typePostalCode(randomUtil.getRandomNumber(3));
    }

    @And("^I click to 'Continue' button$")
    public void iClickContinueButton() {
        checkoutOverViewPage = checkoutYourInformationPage.clickContinueButton();
    }

    @When("^Page 'Checkout: Overview' should be open$")
    public void pageCheckoutOverviewShouldBeOpen() {
        Assert.assertTrue(checkoutOverViewPage.isPageOpened(), "'Checkout: Overview' page is not opened");
    }

    @Then("^I click to 'Finish' button$")
    public void iClickFinishButton() {
        checkoutCompletePage = checkoutOverViewPage.clickFinishButton();
    }

    @When("^Page 'Checkout: Complete!' should be open$")
    public void pageCheckoutCompleteShouldBeOpen() {
        Assert.assertTrue(checkoutCompletePage.isPageOpened(), "'Checkout: Complete' page is not opened");
    }

    @Then("^I see complete text about order$")
    public void iSeeCompleteTextAboutOrder() {
        Assert.assertTrue(checkoutCompletePage.isCompleteTextPresent(), "Complete text is not present");
    }

    //---------- Locked out user

    @Then("^I type locked out user name$")
    public void iTypeLockedOutUserName() {
        Users user = dbUserService.getUserByName("locked_out_user");
        logInPage.typeUserName(user.getUserName());
    }

    @And("^I type locked out user password$")
    public void iTypeLockedOutUserPassword() {
        Users user = dbUserService.getUserByName("locked_out_user");
        logInPage.typePassword(user.getPassword());
    }

    @But("^Page 'Product' should not be open$")
    public void pageProductShouldNotBeOpened() {
        Assert.assertFalse(productsPage.isPageOpened(3), "Product page is opened");
    }

    @And("^I see text that user is locked out$")
    public void iSeeTextUserIsLockedOut() {
        Assert.assertTrue(logInPage.isLockedOutUserTextPresent(), "Locked out text is not present");
    }

    //--------- Problem user

    @Then("^I type problem user name$")
    public void iTypeProblemUserName() {
        Users user = dbUserService.getUserByName("problem_user");
        logInPage.typeUserName(user.getUserName());
    }

    @Then("^I type problem user password$")
    public void iTypeProblemUserPassword() {
        Users user = dbUserService.getUserByName("problem_user");
        logInPage.typePassword(user.getPassword());
    }

    @Then("^I click 'Add to cart' problem user's products according date base$")
    public void iClickAddToCartProblemUserProducts() {
        Users user = dbUserService.getUserByName("problem_user");
        List<Orders> orders = dbOrderService.getByUser(user);
        for (Orders order : orders) {
            productsPage.clickAddToCartButton(order.getProduct());
        }
    }

    @But("^In cart should not be problem user's all products$")
    public void inCartShouldNotBeProblemUsersAllProducts() {
        Users user = dbUserService.getUserByName("problem_user");
        List<Orders> orders = dbOrderService.getByUser(user);
        boolean allProductsNotPresentInCart = true; // assume all products are not present in cart
        for (Orders order : orders) {
            if (yourCartPage.isProductPresentInCart(order.getProduct())) {
                allProductsNotPresentInCart = false;
                break;
            }
        }
        Assert.assertFalse(allProductsNotPresentInCart, "all products are present in cart");
    }

    @Then("^I can fill in all necessary information besides 'Last Name'$")
    public void iCanFillAllNecessaryInfoBesideLastName() {
        checkoutYourInformationPage.typeFirstName(randomUtil.getRandomString(4));
        checkoutYourInformationPage.typeLastName(randomUtil.getRandomString(6));
        checkoutYourInformationPage.typePostalCode(randomUtil.getRandomNumber(3));
        Assert.assertEquals(checkoutYourInformationPage.getLastNameText(), "", "Last name is filled");
    }
}

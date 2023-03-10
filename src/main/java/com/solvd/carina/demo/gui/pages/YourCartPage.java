package com.solvd.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YourCartPage extends AbstractSwagLabPage {

    @FindBy(xpath = "//*[@class = 'title'][text() = 'Your Cart']")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//*[@class = 'inventory_item_name']")
    private ExtendedWebElement productInCart;

    @FindBy(xpath = "//*[@id = 'checkout']")
    private ExtendedWebElement checkoutBtn;

    public YourCartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageTitle);
    }

    public boolean isProductPresentInCart(String product) {
        return productInCart.format(product).isElementPresent();
    }

    public CheckoutYourInformationPage clickCheckoutButton() {
        checkoutBtn.click();
        return new CheckoutYourInformationPage(getDriver());
    }
}

package com.solvd.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends AbstractSwagLabPage {

    @FindBy(xpath = "//*[@class = 'title'][text() = 'Products']")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//*[text() = '%s']//ancestor::div[@class = 'inventory_item_description']//button[contains(@id, 'add-to-cart')]")
    private ExtendedWebElement productAddToCartBtn;

    public ProductsPage(WebDriver driver) {
        super(driver);
        setPageURL("https://www.saucedemo.com/inventory.html");
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageTitle);
    }

    public void clickAddToCartButton(String product) {
        productAddToCartBtn.format(product).click();
    }
}

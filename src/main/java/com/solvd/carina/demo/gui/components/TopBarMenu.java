package com.solvd.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.carina.demo.gui.pages.YourCartPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TopBarMenu extends AbstractUIObject {

    @FindBy(xpath = "//*[@id = 'shopping_cart_container']")
    private ExtendedWebElement cartIconButton;

    public TopBarMenu(WebDriver driver) {
        super(driver);
    }

    public TopBarMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public YourCartPage clickCartIconButton() {
        cartIconButton.click();
        return new YourCartPage(getDriver());
    }
}

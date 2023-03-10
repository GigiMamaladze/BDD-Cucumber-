package com.solvd.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends AbstractSwagLabPage {

    @FindBy(xpath = "//*[@class = 'title'][text() = 'Checkout: Complete!']")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//*[@class = 'complete-text']")
    private ExtendedWebElement completeText;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageTitle);
    }

    public boolean isCompleteTextPresent() {
        return completeText.isElementPresent();
    }
}

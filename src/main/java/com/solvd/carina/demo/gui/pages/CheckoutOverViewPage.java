package com.solvd.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverViewPage extends AbstractSwagLabPage {

    @FindBy(xpath = "//*[@class = 'title'][text() = 'Checkout: Overview']")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//*[@id = 'finish']")
    private ExtendedWebElement finishBtn;

    public CheckoutOverViewPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageTitle);
    }

    public CheckoutCompletePage clickFinishButton() {
        finishBtn.click();
        return new CheckoutCompletePage(getDriver());
    }
}

package com.solvd.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutYourInformationPage extends AbstractSwagLabPage {

    @FindBy(xpath = "//*[@class = 'title'][text() = 'Checkout: Your Information']")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//*[@id = 'first-name']")
    private ExtendedWebElement firstNameTextField;

    @FindBy(xpath = "//*[@id = 'last-name']")
    private ExtendedWebElement lastNameTextField;

    @FindBy(xpath = "//*[@id = 'postal-code']")
    private ExtendedWebElement postalCodeTextField;

    @FindBy(xpath = "//*[@id = 'continue']")
    private ExtendedWebElement continueBtn;

    public CheckoutYourInformationPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageTitle);
    }

    public void typeFirstName(String firstName) {
        firstNameTextField.type(firstName);
    }

    public void typeLastName(String lastName) {
        lastNameTextField.type(lastName);
    }

    public void typePostalCode(String postalCode) {
        postalCodeTextField.type(postalCode);
    }

    public CheckoutOverViewPage clickContinueButton() {
        continueBtn.click();
        return new CheckoutOverViewPage(getDriver());
    }

    public String getLastNameText() {
        return lastNameTextField.getText();
    }
}

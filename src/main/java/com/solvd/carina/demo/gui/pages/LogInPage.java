package com.solvd.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends AbstractSwagLabPage {

    @FindBy(xpath = "//*[@id = 'user-name']")
    private ExtendedWebElement userNameTextField;

    @FindBy(xpath = "//*[@id = 'password']")
    private ExtendedWebElement passwordTextField;

    @FindBy(xpath = "//*[@id = 'login-button']")
    private ExtendedWebElement logInBtn;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void typeUserName(String userName) {
        userNameTextField.type(userName);
    }

    public void typePassword(String password) {
        passwordTextField.type(password);
    }

    public ProductsPage clickLogInButton() {
        logInBtn.click();
        return new ProductsPage(getDriver());
    }
}

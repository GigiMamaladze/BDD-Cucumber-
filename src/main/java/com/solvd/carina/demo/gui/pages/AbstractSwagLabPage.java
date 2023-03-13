package com.solvd.carina.demo.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.components.TopBarMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractSwagLabPage extends AbstractPage {

    @FindBy(xpath = "//*[@class = 'header_label']")
    protected TopBarMenu topBarMenu;

    public AbstractSwagLabPage(WebDriver driver) {
        super(driver);
    }

    public TopBarMenu getTopBarMenu() {
        return topBarMenu;
    }
}

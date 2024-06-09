package org.example.appline.framework.pages.task1;

import org.example.appline.framework.managers.DriverManager;
import org.example.appline.framework.managers.TestPropertiesManager;
import org.example.appline.framework.utils.PropsConst;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    private TestPropertiesManager testPropertiesManager = TestPropertiesManager.getInstance();

    public BasePage() {
        driver = DriverManager.getInstance().getDriver();
        driver.get(testPropertiesManager.getProperty(PropsConst.LAMDA_URL));
        PageFactory.initElements(driver, this);
    }
}

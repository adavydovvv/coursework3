package org.example.appline.framework.pages.task3;

import org.example.appline.framework.managers.DriverManager;
import org.example.appline.framework.managers.PageManager;
import org.example.appline.framework.managers.TestPropertiesManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage{
    private WebDriver driver;
    TestPropertiesManager testPropertiesManager = TestPropertiesManager.getInstance();
    protected PageManager pageManager = PageManager.getInstance();
    protected DriverManager driverManager = DriverManager.getInstance();
    public BasePage() {
        driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

}

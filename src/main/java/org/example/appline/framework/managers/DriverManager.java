package org.example.appline.framework.managers;

import org.example.appline.framework.utils.PropsConst;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class DriverManager {
    private static DriverManager INSTANCE = null;
    private WebDriver driver;
    private TestPropertiesManager testPropertiesManager = TestPropertiesManager.getInstance();



    private DriverManager() {
        // Приватный конструктор, чтобы предотвратить создание экземпляров класса извне
    }

    public static DriverManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", testPropertiesManager.getProperty(PropsConst.PATH_CHROME_DRIVER_WINDOWS));
            driver = new ChromeDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    public void switchWindow() {
        Set<String> allTabs = driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(driver.getWindowHandle())) {
                driver.switchTo().window(tab);
                break;
            }
        }
    }
    public int seeAllPages(){
        return driver.getWindowHandles().size();
    }
}

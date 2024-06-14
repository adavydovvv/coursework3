package org.example.appline.framework.pages.task4;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccessoriesStartPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(), 'Аксессуары для автомобиля')]")
    private WebElement accessoriesForCarsButton;

    @FindBy(xpath = "//a[@href = 'catalogue/accessories/m_performance']")
    private WebElement mperformanceAccessoriesButton;


    public AccessoriesStartPage clickAccessoriesForCarsButton() throws InterruptedException {
        driverManager.switchWindow();
        Thread.sleep(8000);
        accessoriesForCarsButton.click();
        return pageManager.getAccessoriesStartPage();
    }
    public AccessoriesPage clickMPerformanceAccessoriesButton() throws InterruptedException {
        Thread.sleep(1000);
        mperformanceAccessoriesButton.click();
        return pageManager.getAccessoriesPage();
    }
}

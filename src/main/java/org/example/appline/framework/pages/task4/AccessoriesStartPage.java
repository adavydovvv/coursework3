package org.example.appline.framework.pages.task4;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccessoriesStartPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(), 'Аксессуары для автомобиля')]")
    private WebElement accessoriesForCarsButton;

    @FindBy(xpath = "//a[@href = 'catalogue/accessories/m_performance']")
    private WebElement mperformanceAccessoriesButton;

    @Step("Нажатие на кнопку Акксесуары для автомобилей")
    public AccessoriesStartPage clickAccessoriesForCarsButton() throws InterruptedException {
        driverManager.switchWindow();
        Thread.sleep(8000);
        accessoriesForCarsButton.click();
        return pageManager.getAccessoriesStartPage();
    }

    @Step("Нажатие на кнопку //M PERFORMANCE")
    public AccessoriesPage clickMPerformanceAccessoriesButton() throws InterruptedException {
        Thread.sleep(1000);
        mperformanceAccessoriesButton.click();
        return pageManager.getAccessoriesPage();
    }
}

package org.example.appline.framework.pages.task4;


import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarsPage extends BasePage {

    @FindBy(xpath = "//button[contains(text(), ' M ')]")
    private WebElement MButton;

    @FindBy(xpath = "//button[@title = 'BMW M5 Competition']")
    private WebElement f90Button;

    @FindBy(xpath = "//div[@data-tracking-regionid='all-models-detailview:F90:B:bmwm5competition']//a[contains(@class, 'cmp-modelselection__cta-show-more cmp-modelselection__detail-view--link')]")
    private WebElement configuratorButton;

    @Step("Нажатие на кнопку //M")
    public CarsPage clickMButton() throws InterruptedException {
        MButton.click();
        Thread.sleep(2500);
        return pageManager.getCarsPage();
    }

    @Step("Нажатие на Автомобиль BMW M5 Competition")
    public ConfigurationPage clickF90ConfigurationButton() throws InterruptedException {
        f90Button.click();
        Thread.sleep(500);
        configuratorButton.click();
        Thread.sleep(1000);
        return pageManager.getConfigurationPage();
    }


}

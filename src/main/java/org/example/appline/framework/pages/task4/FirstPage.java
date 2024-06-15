package org.example.appline.framework.pages.task4;

import io.qameta.allure.Step;
import org.example.appline.framework.utils.PropsConst;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstPage extends BasePage{

    @FindBy(xpath = "//h2[contains(text(), 'ВСЕ МЕНЯЕТСЯ. ЦЕННОСТИ ОСТАЮТСЯ.')]")
    private WebElement startH2;

    @FindBy(xpath = "//span[contains(text(), 'Автомобили')]")
    private WebElement carButton;

    @FindBy(xpath = "//span[contains(text(), 'Покупка онлайн')]")
    private WebElement searchNowButton;

    @FindBy(xpath = "//a[@href='https://cars.bmw.ru/used/']")
    private WebElement autoWMButton;

    @FindBy(xpath = "//a[@href='https://shop.bmw.ru/']")
    private WebElement accessoriesButton;

    public void loadHomePage() {
        driverManager.getDriver().get(testPropertiesManager.getProperty(PropsConst.BMW_URL));
    }

    @Step("Проверка заголовка")
    public FirstPage checkStartH2() throws InterruptedException {
        Assert.assertEquals("На странице отсутствует требуемая надпись", "ВСЕ МЕНЯЕТСЯ. ЦЕННОСТИ ОСТАЮТСЯ.", startH2.getText());
        return pageManager.getFirstPage();
    }

    @Step("Нажатие на кнопку Автомобили")
    public CarsPage clickCarButton(){
        carButton.click();
        return pageManager.getCarsPage();
    }

    @Step("Нажатие на кнопку Автомобили с пробегом")
    public AutoWithMileagePage clickAutoWMButton() throws InterruptedException {
        searchNowButton.click();
        Thread.sleep(2000);
        autoWMButton.click();
        return pageManager.getAutoWithMileagePage();
    }

    @Step("Нажатие на кнопку Аксессуары")
    public AccessoriesStartPage clickAccessoriesButton() throws InterruptedException {
        searchNowButton.click();
        Thread.sleep(2000);
        accessoriesButton.click();
        return pageManager.getAccessoriesStartPage();
    }

}

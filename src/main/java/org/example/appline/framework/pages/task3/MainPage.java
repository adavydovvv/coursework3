package org.example.appline.framework.pages.task3;

import io.qameta.allure.Step;
import org.example.appline.framework.utils.PropsConst;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    Actions actions = new Actions(driverManager.getDriver());

    @FindBy(xpath = "//button[@class = '_30-fz button-focus-ring Hkr1q _1pHod _2rdh3 _3rbM-']")
    private WebElement catalogButton;

    @FindBy(xpath = "//span[contains(text(), 'Все для гейминга')]")
    private WebElement allForGamingButton;

    @FindBy(xpath = "//a[contains(text(), 'Игровые телефоны')]")
    private WebElement gamingMobileButton;

    @FindBy(xpath = "//h1[@class = '_3lpeU _6tyDq _1ea6I _2Imo_']")
    private WebElement gamingTitle;

    public void loadHomePage() {
        driverManager.getDriver().get(testPropertiesManager.getProperty(PropsConst.YANDEX_URL));
    }

    @Step("Нажатие на кнопку Игровые телефоны")
    public GamingPhonePage clickOnGamingMobileButton() throws InterruptedException {
        catalogButton.click();
        Thread.sleep(2000);
        actions.moveToElement(allForGamingButton).perform();
        gamingMobileButton.click();
        Thread.sleep(1000);
        Assert.assertEquals("Страница 'Игровые телефоны' не открылась ", "Игровые телефоны", gamingTitle.getText());
        return pageManager.getGamingPhonePage();
    }

}

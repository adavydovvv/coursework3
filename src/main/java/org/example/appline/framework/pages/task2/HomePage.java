package org.example.appline.framework.pages.task2;


import io.qameta.allure.Step;
import org.example.appline.framework.utils.PropsConst;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@title='Расписание']")
    private WebElement schedulesButton;

    public void loadHomePage() {
        driver.get(testPropertiesManager.getProperty(PropsConst.MOSPOLYTECH_URL));
    }

    @Step("Нажатие на кнопку Расписание")
    public SchedulesPage clickSchedulesButton() {
        schedulesButton.click();
        Assert.assertEquals("Вы не находитесь на странице расписания", "Расписания", pageManager.getSchedulesPage().geth1());
        return pageManager.getSchedulesPage();
    }

}

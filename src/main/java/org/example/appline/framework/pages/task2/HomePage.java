package org.example.appline.framework.pages.task2;


import org.example.appline.framework.utils.PropsConst;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@title='Расписание']")
    private WebElement schedulesButton;

    public void loadHomePage() {
        driver.get(testPropertiesManager.getProperty(PropsConst.MOSPOLYTECH_URL));
    }

    public SchedulesPage clickSchedulesButton() {
        schedulesButton.click();
        return pageManager.getSchedulesPage();
    }

}

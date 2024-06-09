package org.example.appline.framework.pages.task2;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SchedulesPage extends BasePage {

    @FindBy(xpath = "//a[@href = 'https://rasp.dmami.ru/']")
    private WebElement seeonsiteButton;

    @FindBy(xpath = "//h1[contains(text(), 'Расписания')]")
    private WebElement h1;

    public DMamiPage clickseeonsiteButton() {
        seeonsiteButton.click();
        return pageManager.getdMamiPage();
    }

    public String geth1(){
        return h1.getText();
    }

}
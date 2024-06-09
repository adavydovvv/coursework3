package org.example.appline.framework.pages.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class DMamiPage extends BasePage{

    private String numofgroup;

    @FindBy(xpath = "//input[@placeholder='группа ...']")
    private WebElement inputField;

    @FindBy(xpath = "//div[@class='found-groups row not-print']")
    private WebElement divrow;

    private WebElement clickGroup;

    public DMamiPage enterGroup(String text) {
        inputField.sendKeys(text);
        return pageManager.getdMamiPage();
    }

    public DMamiPage clickGroup(String numofgroup) {
        this.numofgroup = numofgroup;
        clickGroup = driver.findElement(By.xpath("//div[contains(text(), '" + numofgroup + "')]"));
        clickGroup.click();
        return pageManager.getdMamiPage();
    }

    public int getdivrowsize(){
        List<WebElement> innerTags = divrow.findElements(By.xpath(".//*"));
        int numberOfInnerTags = innerTags.size();
        return numberOfInnerTags;
    }

    public String getCurrentDayOfWeek() {
        LocalDate currentDate = LocalDate.now();
        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();

        Locale russianLocale = new Locale("ru", "RU");
        String dayOfWeekInRussian = dayOfWeek.getDisplayName(TextStyle.FULL, russianLocale);

        dayOfWeekInRussian = dayOfWeekInRussian.substring(0, 1).toUpperCase() + dayOfWeekInRussian.substring(1);

        return dayOfWeekInRussian;
    }


}

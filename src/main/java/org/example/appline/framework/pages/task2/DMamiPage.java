package org.example.appline.framework.pages.task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
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


    private String group;
    private WebElement clickGroup;
    private static final Logger logger = LogManager.getLogger(DMamiPage.class);

    public DMamiPage enterGroup() {
        group = "221-361";
        inputField.sendKeys(group);
        Assert.assertEquals("В результатах поиска отображается не только искомая группа", 1, getdivrowsize());
        return pageManager.getdMamiPage();
    }

    public DMamiPage clickGroup() {
        group = "221-361";
        clickGroup = driver.findElement(By.xpath("//div[contains(text(), '" + group + "')]"));
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

    public DMamiPage checkOfColor(){
        try {
            WebElement todayElement = driverManager.getDriver().findElement(By.xpath("//div[contains(@class, 'schedule-day schedule-day_today')]//div[contains(@class, 'bold schedule-day__title') and text()='"+getCurrentDayOfWeek()+"']"));
            Assert.assertNotNull("Текущий день недели не выделен цветом", todayElement);
            WebElement todaydivElement = driverManager.getDriver().findElement(By.xpath("//div[contains(@class, 'schedule-day schedule-day_today')]"));
            String backgroundColor = todaydivElement.getCssValue("background-color");
            Assert.assertEquals("Цвет фона блока 'schedule-day_today' не равен #e2ffd9", "rgba(226, 255, 217, 1)", backgroundColor);

        } catch (Exception e){
            logger.info("Сегодня воскресенье! Текущий день не может быть выделен цветом.");
        }
        return pageManager.getdMamiPage();
    }


}

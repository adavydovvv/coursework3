package task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Tests2 extends BaseTests {
    private static final Logger logger = LogManager.getLogger(Tests2.class);
    private String group;
    @Rule
    public TestName testName = new TestName();

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            takeScreenshot(testName.getMethodName());
        }
    };
    @Test
    public void test() {
        logger.info("Выполняется шаг 2");
        pageManager.getStartPageM().clickSchedulesButton();
        Assert.assertEquals("Вы не находитесь на странице расписания", "Расписания", pageManager.getSchedulesPage().geth1());

        logger.info("Выполняется шаг 3");
        pageManager.getSchedulesPage().clickseeonsiteButton();
        Assert.assertEquals("Новая вкладка не была открыта", 2, driverManager.seeAllPages());
        driverManager.switchWindow();

        logger.info("Выполняется шаг 4");
        group = "221-361";
        pageManager.getdMamiPage().enterGroup(group);
        Assert.assertEquals("В результатах поиска отображается не только искомая группа", 1, pageManager.getdMamiPage().getdivrowsize());

        logger.info("Выполняется шаг 5");
        pageManager.getdMamiPage().clickGroup(group);


        WebElement todayElement = driverManager.getDriver().findElement(By.xpath("//div[contains(@class, 'schedule-day schedule-day_today')]//div[contains(@class, 'bold schedule-day__title') and text()='"+pageManager.getdMamiPage().getCurrentDayOfWeek()+"']"));

        Assert.assertNotNull("Текущий день недели не выделен цветом", todayElement);

        WebElement todaydivElement = driverManager.getDriver().findElement(By.xpath("//div[contains(@class, 'schedule-day schedule-day_today')]"));

        String backgroundColor = todaydivElement.getCssValue("background-color");

        Assert.assertEquals("Цвет фона блока 'schedule-day_today' не равен #e2ffd9", "rgba(226, 255, 217, 1)", backgroundColor);

    }
}

package task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class Tests1 extends BaseTests {
    private static final Logger logger = LogManager.getLogger(Tests1.class);
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
        //Шаг 2
        logger.info("Выполняется шаг 2");
        String remainingText = pageManager.getStartPageL().getRemainingText();
        Assert.assertEquals("Текст отсутствует!", "5 of 5 remaining", remainingText);

        //Шаг 3
        logger.info("Выполняется шаг 3");
        String classAttributeValue = pageManager.getStartPageL().getFirstItemClass();
        Assert.assertEquals("Ошибка! Не применён соответствующий класс", "done-false", classAttributeValue);

        //Шаг 4
        logger.info("Выполняется шаг 4");
        Assert.assertFalse("Чекбокс уже выбран!", pageManager.getStartPageL().isFirstCheckboxSelected());
        int itemCountBefore = pageManager.getStartPageL().getRemainingCount();
        pageManager.getStartPageL().clickFirstCheckbox();
        int itemCountAfter = pageManager.getStartPageL().getRemainingCount();
        Assert.assertEquals("Отображаемое число оставшихся элементов не уменьшилось на 1!", itemCountBefore - 1, itemCountAfter);

        //Шаг 5
        logger.info("Выполняется шаг 5");
        pageManager.getStartPageL().clickAllCheckboxes();
        int itemCountAfter1 = pageManager.getStartPageL().getRemainingCount();
        Assert.assertEquals("Отображаемое число оставшихся элементов не уменьшилось до 0!", 0, itemCountAfter1);

        //Шаг 6
        logger.info("Выполняется шаг 6");
        pageManager.getStartPageL().clickAllCheckboxes();
        pageManager.getStartPageL().uncheckAllCheckboxes();
        int itemCountAfter2 = pageManager.getStartPageL().getRemainingCount();
        Assert.assertEquals("Отображаемое число оставшихся элементов не увеличилось до 5!", 5, itemCountAfter2);

        //Шаг 7
        logger.info("Выполняется шаг 7");
        String newItemText = "Sixth item";
        pageManager.getStartPageL().addItem(newItemText);
        int itemCountBefore1 = pageManager.getStartPageL().getRemainingCount();
        pageManager.getStartPageL().clickLastCheckbox();
        String classAttributeValue1 = pageManager.getStartPageL().getLastItemClass();
        Assert.assertEquals("Ошибка! Новый элемент списка не зачеркнут", "done-true", classAttributeValue1);
        int itemCountAfter3 = pageManager.getStartPageL().getRemainingCount();
        Assert.assertEquals("Отображаемое число оставшихся элементов не уменьшилось на 1!", itemCountBefore1 - 1, itemCountAfter3);
    }
}

package task1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseTests {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://lambdatest.github.io/sample-todo-app/");
    }

    @Test
    public void step1() {
        driver.get("https://lambdatest.github.io/sample-todo-app/");
    }

    @Test
    public void step2() {
        WebElement text = driver.findElement(By.xpath("//span[contains(text(),'5 of 5 remaining')]"));
        Assert.assertEquals("Текст отсутствует!", "5 of 5 remaining", text.getText());
    }

    @Test
    public void step3() {
        WebElement firstItem = driver.findElement(By.xpath("//ul[@class='list-unstyled']/li[1]/span"));
        String classAttributeValue = firstItem.getAttribute("class");

        Assert.assertEquals("Ошибка! Не применён соответствующий класс", "done-false", classAttributeValue);
    }

    @Test
    public void step4() throws InterruptedException {
        driver.get("https://lambdatest.github.io/sample-todo-app/");

        // Находим все чекбоксы
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        // Проверяем, что первый чекбокс не выбран до выполнения действий
        WebElement checkbox = checkboxes.get(0);
        Assert.assertFalse("Чекбокс уже выбран!", checkbox.isSelected());

        // Получаем количество оставшихся элементов до выполнения действий
        WebElement remainingCountElement = driver.findElement(By.xpath("//span[contains(text(), 'remaining')]"));
        String remainingCountText = remainingCountElement.getText().split(" ")[0];
        int itemCountBefore = Integer.parseInt(remainingCountText);

        // Выбираем чекбокс
        checkbox.click();

        // Проверяем, что чекбокс теперь выбран
        Assert.assertTrue("Чекбокс не выбран!", checkbox.isSelected());

        // Проверяем, что элемент списка стал зачеркнутым
        WebElement listItem = driver.findElement(By.xpath("//ul/li[1]/span"));

        String classAttributeValue = listItem.getAttribute("class");

        Assert.assertEquals("Ошибка! Не применён соответствующий класс", "done-true", classAttributeValue);

        // Получаем количество оставшихся элементов после выполнения действий
        remainingCountText = remainingCountElement.getText().split(" ")[0];
        int itemCountAfter = Integer.parseInt(remainingCountText);

        // Проверяем, что отображаемое число оставшихся элементов уменьшилось на 1
        Assert.assertEquals("Отображаемое число оставшихся элементов не уменьшилось на 1!", itemCountBefore - 1, itemCountAfter);
    }

    @Test
    public void step5() {
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        WebElement remainingCountElement = driver.findElement(By.xpath("//span[contains(text(), 'remaining')]"));

        int itemCountBefore = Integer.parseInt(remainingCountElement.getText().split(" ")[0]);

        for (int i = 0; i < checkboxes.size(); i++) {
            WebElement checkbox = checkboxes.get(i);
            WebElement listItem = driver.findElement(By.xpath("//ul[@class='list-unstyled']/li[" + (i + 1) + "]/span"));

            checkbox.click();

            Assert.assertTrue("Чекбокс не выбран!", checkbox.isSelected());

            String classAttributeValue = listItem.getAttribute("class");
            Assert.assertEquals("Ошибка! Не применён соответствующий класс", "done-true", classAttributeValue);
        }

        int itemCountAfter = Integer.parseInt(remainingCountElement.getText().split(" ")[0]);
        Assert.assertEquals("Отображаемое число оставшихся элементов не уменьшилось на 1!", itemCountBefore - checkboxes.size(), itemCountAfter);
    }

    @Test
    public void step6() throws InterruptedException {
        // Находим поле ввода для нового элемента
        WebElement inputField = driver.findElement(By.id("sampletodotext"));

        // Вводим текст для нового элемента
        String newItemText = "Sixth item";
        inputField.sendKeys(newItemText);

        // Нажимаем Enter для добавления нового элемента
        inputField.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        // Проверяем, что новый элемент списка не зачеркнут
        WebElement newItem = driver.findElement(By.xpath("//ul[@class='list-unstyled']/li[last()]/span"));
        String classAttributeValue = newItem.getAttribute("class");
        Assert.assertEquals("Ошибка! Новый элемент списка зачеркнут", "done-false", classAttributeValue);

        // Получаем количество оставшихся элементов до и после добавления нового элемента
        WebElement remainingCountElement = driver.findElement(By.xpath("//span[contains(text(), 'remaining')]"));
        String remainingCountText = remainingCountElement.getText().split(" ")[0];
        int itemCountBefore = Integer.parseInt(remainingCountText);

        // Проверяем, что отображаемое общее число и число оставшихся элементов увеличиваются на 1
        int itemCountAfter = itemCountBefore + 1;
        Assert.assertEquals("Отображаемое общее число элементов не увеличилось на 1!", itemCountBefore + 1, itemCountAfter);
    }
    @Test
    public void step7() {
        // Находим поле ввода для нового элемента
        WebElement inputField = driver.findElement(By.id("sampletodotext"));

        // Вводим текст для нового элемента
        String newItemText = "Sixth item";
        inputField.sendKeys(newItemText);

        // Нажимаем Enter для добавления нового элемента
        inputField.sendKeys(Keys.ENTER);

        // Находим чекбокс нового элемента списка
        WebElement newCheckbox = driver.findElement(By.xpath("//ul[@class='list-unstyled']/li[last()]//input[@type='checkbox']"));

        // Нажимаем на чекбокс нового элемента списка
        newCheckbox.click();

        // Проверяем, что элемент стал зачеркнутым
        WebElement newItem = driver.findElement(By.xpath("//ul[@class='list-unstyled']/li[last()]/span"));
        String classAttributeValue = newItem.getAttribute("class");
        Assert.assertEquals("Ошибка! Новый элемент списка не зачеркнут", "done-true", classAttributeValue);

        // Получаем количество оставшихся элементов до и после нажатия на чекбокс нового элемента
        WebElement remainingCountElement = driver.findElement(By.xpath("//span[contains(text(), 'remaining')]"));
        String remainingCountText = remainingCountElement.getText().split(" ")[0];
        int itemCountBefore = Integer.parseInt(remainingCountText);

        // Проверяем, что отображаемое число оставшихся элементов уменьшилось на 1
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

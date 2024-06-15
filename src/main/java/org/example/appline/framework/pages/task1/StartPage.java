package org.example.appline.framework.pages.task1;


import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StartPage extends BasePage {
    @FindBy(xpath = "//h2")
    private WebElement title;

    @FindBy(xpath = "//span[contains(text(),'remaining')]")
    private WebElement remainingCountElement;

    @FindBy(xpath = "//span[contains(text(),'5 of 5 remaining')]")
    private WebElement remainingText;

    @FindBy(xpath = "//ul[@class='list-unstyled']/li[1]/span")
    private WebElement firstItem;

    @FindBy(xpath = "//ul[@class='list-unstyled']/li[last()]/span")
    private WebElement lastItem;

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkboxes;
    @FindBy(xpath = "//span[@class='done-true']")
    private List<WebElement> itemsTrue;

    @FindBy(id = "sampletodotext")
    private WebElement inputField;

    @Step("Проверка заголовка")
    public StartPage checkTitle(){
        Assert.assertEquals("На странице отсутствует требуемый заголовок", "LambdaTest Sample App", title.getText());
        return pageManager.getStartPageL();
    }

    @Step("Проверка наличия текста")
    public StartPage getRemainingText() {
        Assert.assertEquals("Текст отсутствует!", "5 of 5 remaining", remainingText.getText());
        return pageManager.getStartPageL();
    }

    @Step("Проверка применения класса")
    public StartPage getFirstItemClass() {
        Assert.assertEquals("Ошибка! Не применён соответствующий класс", "done-false", firstItem.getAttribute("class"));
        return pageManager.getStartPageL();
    }

    @Step("Проверка на выбранный чекбокс")
    public StartPage isFirstCheckboxSelected() {
        Assert.assertFalse("Чекбокс уже выбран!", checkboxes.get(0).isSelected());
        return pageManager.getStartPageL();
    }

    @Step("Нажатие на первый чекбокс")
    public StartPage clickFirstCheckbox() {
        int itemCountBefore = getRemainingCount();
        checkboxes.get(0).click();
        Assert.assertEquals("Ошибка! Не применён соответствующий класс", "done-true", firstItem.getAttribute("class"));
        int itemCountAfter = getRemainingCount();
        Assert.assertEquals("Отображаемое число оставшихся элементов не уменьшилось на 1!", itemCountBefore - 1, itemCountAfter);
        return pageManager.getStartPageL();
    }

    public void addItem(String text) {
        inputField.sendKeys(text);
        inputField.sendKeys(Keys.ENTER);
    }

    public void clickLastCheckbox() {
        WebElement newCheckbox = checkboxes.get(checkboxes.size() - 1);
        newCheckbox.click();
    }

    @Step("Получение класса последнего элемента")
    public String getLastItemClass() {
        return lastItem.getAttribute("class");
    }
    public int getRemainingCount() {
        String remainingCountText = remainingCountElement.getText().split(" ")[0];
        return Integer.parseInt(remainingCountText);
    }

    @Step("Нажать на все чекбоксы")
    public StartPage clickAllCheckboxes() {
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
        Assert.assertEquals("К некоторым элементам не применился класс done-true", 5, itemsTrue.size());
        int itemCountAfter = pageManager.getStartPageL().getRemainingCount();
        Assert.assertEquals("Отображаемое число оставшихся элементов не уменьшилось до 0!", 0, itemCountAfter);
        return pageManager.getStartPageL();
    }

    public void uncheckAllCheckboxes() {
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    @Step("Добавить новый элемент")
    public StartPage addNewElement(){
        String newItemText = "Sixth item";
        addItem(newItemText);
        int itemCountBefore = getRemainingCount();
        clickLastCheckbox();
        String classAttributeValue = getLastItemClass();
        Assert.assertEquals("Ошибка! Новый элемент списка не зачеркнут", "done-true", classAttributeValue);
        int itemCountAfter = getRemainingCount();
        Assert.assertEquals("Отображаемое число оставшихся элементов не уменьшилось на 1!", itemCountBefore - 1, itemCountAfter);
        return pageManager.getStartPageL();
    }

}


package org.example.appline.framework.pages.task4;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccessoriesPage extends BasePage{

    @FindBy(xpath = "//div[@class = 'page__title']")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[contains(text(), 'Комплекты увеличения мощности')]")
    private WebElement complectButton;

    @FindBy(xpath = "//div[@class='catalog-sort__total']/span")
    private WebElement totalCount;

    public AccessoriesPage checkPageTitle() {
        Assert.assertEquals("Открыта неверная страница", "M PERFORMANCE", pageTitle.getText());
        return pageManager.getAccessoriesPage();
    }

    public AccessoriesPage clickComplectButton() throws InterruptedException {
        complectButton.click();
        Thread.sleep(2000);
        Assert.assertEquals("Количество товаров не соответствует ожидаемому", "2 товара", totalCount.getText());
        return pageManager.getAccessoriesPage();
    }
}

package org.example.appline.framework.pages.task4;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccessoriesPage extends BasePage{

    @FindBy(xpath = "//div[@class = 'page__title']")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[contains(text(), 'Комплекты увеличения мощности')]")
    private WebElement complectButton;

    @FindBy(xpath = "//div[contains(text(), 'Комплекты увеличения мощности')]/following-sibling::div[1]")
    private WebElement complectCount;

    @FindBy(xpath = "//div[@class='catalog-sort__total']/span")
    private WebElement totalCount;

    @FindBy(xpath = "//div[@class = 'v-text product-card__title v-text_small']")
    private List<WebElement> productCount;

    public AccessoriesPage checkPageTitle() {
        Assert.assertEquals("Открыта неверная страница", "M PERFORMANCE", pageTitle.getText());
        return pageManager.getAccessoriesPage();
    }

    public AccessoriesPage clickComplectButton() throws InterruptedException {
        complectButton.click();
        Thread.sleep(3000);
        Assert.assertEquals("Количество товаров не соответствует ожидаемому", totalCount.getText(), complectCount.getText() + " товара");
        Assert.assertEquals("Количество товаров не соответствует ожидаемому", complectCount.getText(), Integer.toString(productCount.size()));
        return pageManager.getAccessoriesPage();
    }
}

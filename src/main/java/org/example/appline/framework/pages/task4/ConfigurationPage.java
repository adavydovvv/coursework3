package org.example.appline.framework.pages.task4;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfigurationPage extends BasePage{

    @FindBy(xpath = "//td[@class = 'quick-facts-data--item-value ds2-font-l']")
    private WebElement price;

    @FindBy(xpath = "//a[@href=\"#stock-locator\" and @data-loader=\"amdLoader\" and @data-component-path=\"ds2-anchor-reference\" and @data-tracking-event and @data-tracking-options and @class=\"ds2-font-clickable-xs ds2-tracking-js--event\" and @data-component-initialized=\"true\" and contains(text(), \"BMW с пробегом в наличии\")]")
    private WebElement bmwWithMileageButton;

    @FindBy(xpath = "//a[@href='https://cars.bmw.ru/used/?brand=5ce7dad4d999da000129d87d&model=5d8dd5f1c486d30001d063fe']")
    private WebElement moreDetailButton;


    public ConfigurationPage checkPrice(){
        Assert.assertEquals("Открыта страница автомобиля с другой ценой!", "11 450 000 ₽", price.getText());
        return pageManager.getConfigurationPage();
    }

    public ConfigurationPage clickBmwWithMileageButton() throws InterruptedException {
        ((JavascriptExecutor) driverManager.getDriver()).executeScript("window.scrollBy(0,1000)");
        Thread.sleep(4000);
        bmwWithMileageButton.click();
        Thread.sleep(4000);
        return pageManager.getConfigurationPage();
    }

    public AutoWithMileagePage clickMoreDetailButton(){
        moreDetailButton.click();
        return pageManager.getAutoWithMileagePage();
    }


}

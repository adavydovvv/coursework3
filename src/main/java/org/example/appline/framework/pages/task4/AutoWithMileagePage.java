package org.example.appline.framework.pages.task4;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AutoWithMileagePage extends BasePage{

    protected static final Logger logger = LogManager.getLogger(AutoWithMileagePage.class);

    @FindBy(xpath = "//h3[@class = 'sc-1bmbblv-0 sc-1bmbblv-3 gBKsGW jpxytw']")
    private List<WebElement> names;

    @FindBy(xpath = "//p[contains(text(), 'Модель')]")
    private WebElement modelButton;

    @FindBy(xpath = "//div[contains(text(), '1 серии')]/ancestor::label")
    private WebElement modelFilter;

    @FindBy(xpath = "//p[contains(text(), 'Год')]")
    private WebElement yearButton;

    @FindBy(xpath = "//input[@label = 'От' and @name = 'year']")
    private WebElement yearInput;

    @FindBy(xpath = "//div[contains(text(), 'до 100 000')]/ancestor::label")
    private WebElement mileageFilter;

    @FindBy(xpath = "//p[contains(text(), 'Пробег')]")
    private WebElement mileageButton;

    @FindBy(xpath = "//input[@label = 'Сортировать по']")
    private WebElement sortButton;

    @FindBy(xpath = "//span[contains(text(), 'возрастанию цены')]")
    private WebElement sortPriceUpButton;

    @FindBy(xpath = "//div[@class = 'sc-1t797kj-4 dZQuRx']")
    private List<WebElement> prices;


    @Step("Проверка на наличие других автомобилей на странице автомобиля M5 F90")
    public AutoWithMileagePage checkCarsM5(){
         for (int i = 0; i < 5 && i < names.size(); i++) {

             String name = names.get(i).getText();
             Assert.assertEquals("В списке товаров есть другие автомобили помимо BMW M5", true, name.contains("BMW M5"));

             logger.info("Автомобиль " + (i + 1) + ": - " + name);

         }
         return pageManager.getAutoWithMileagePage();
     }

    @Step("Выбор фильтров")
     public AutoWithMileagePage enterFiltres() throws InterruptedException {
         driverManager.switchWindow();

         ((JavascriptExecutor) driverManager.getDriver()).executeScript("window.scrollBy(0,1000)");
         modelButton.click();
         Thread.sleep(3000);
         driverManager.getDriver().switchTo().parentFrame();
         //((JavascriptExecutor) driverManager.getDriver()).executeScript("arguments[0].checked = true;", modelFilter);
         modelFilter.click();
         Thread.sleep(3000);


         yearButton.click();
         yearInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
         yearInput.sendKeys(Keys.DELETE);
         Thread.sleep(3000);
         yearInput.sendKeys("2018");
         Thread.sleep(3000);


         mileageButton.click();
         Thread.sleep(3000);
         mileageFilter.click();

         Thread.sleep(5000);

         for (int i = 0; i < 5 && i < names.size(); i++) {

             String name = names.get(i).getText();
             Assert.assertTrue("В списке товаров есть другие автомобили помимо BMW 118i", name.contains("BMW 118i"));

             logger.info("Автомобиль " + (i + 1) + ": - " + name);

         }

         return pageManager.getAutoWithMileagePage();
     }

    @Step("Сортировка по возрастанию")
     public AutoWithMileagePage enterSort() throws InterruptedException {
         ((JavascriptExecutor) driverManager.getDriver()).executeScript("window.scrollBy(2000,0)");
         sortButton.click();
         sortPriceUpButton.click();

         Thread.sleep(3000);

         for (int i = 0; i < 5 && i < prices.size() - 1; i++) {

             int compare = prices.get(i).getText().compareToIgnoreCase(prices.get(i + 1).getText());

             Assert.assertEquals("Сортировка работает некорректно", true, compare < 0);
         }
         return pageManager.getAutoWithMileagePage();
     }

}

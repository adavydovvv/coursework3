package org.example.appline.framework.pages.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class GamingPhonePage extends BasePage{

    private static final Logger logger = LogManager.getLogger(GamingPhonePage.class);


    public GamingPhonePage infoToLogs3(){
        logger.info("----------------------------------ШАГ 3 ТЕСТ КЕЙСА----------------------------------------------");
        List<WebElement> names = driverManager.getDriver().findElements(By.xpath("//h3[@class = 'G_TNq _2SUA6 _33utW _13aK2 h29Q2 _1A5yJ']"));
        List<WebElement> prices = driverManager.getDriver().findElements(By.xpath("//span[@class = '_1ArMm']"));

        for (int i = 0; i < 5 && i < names.size() && i < prices.size(); i++) {

            String name = names.get(i).getText();
            String price = prices.get(i).getText();

            logger.info("Телефон " + (i + 1) + ": Название - " + name + ", Цена - " + price);
        }

        return pageManager.getGamingPhonePage();
    }

    public GamingPhonePage clickFilterSamsung() throws InterruptedException {
        logger.info("----------------------------------ШАГ 4 ТЕСТ КЕЙСА----------------------------------------------");
        List<WebElement> checkboxes = driverManager.getDriver().findElements(By.xpath("//span[@class = '_3nYr7']"));
        List<WebElement> names = driverManager.getDriver().findElements(By.xpath("//span[@class = '_1-LFf']"));

        for (int i = 0; i < 5 && i < names.size() && i < checkboxes.size(); i++) {

            String name = names.get(i).getText();
            WebElement checkbox = checkboxes.get(i);

            if (Objects.equals(name, "Samsung")){
                checkbox.click();
            }
        }

        Thread.sleep(7000);

        List<WebElement> namesOfPhones = driverManager.getDriver().findElements(By.xpath("//h3[@class = 'G_TNq _2SUA6 _33utW _13aK2 h29Q2 _1A5yJ']"));
        List<WebElement> prices = driverManager.getDriver().findElements(By.xpath("//span[@class = '_1ArMm']"));

        for (int i = 0; i < 5 && i < namesOfPhones.size(); i++) {

            String name = namesOfPhones.get(i).getText();
            String price = prices.get(i).getText();
            Assert.assertEquals("В списке товаров есть другие бренды помимо Samsung", true, name.contains("Samsung"));

            logger.info("Телефон " + (i + 1) + ": Название - " + name + ", Цена - " + price);

        }
        return pageManager.getGamingPhonePage();
    }

}

package task4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.appline.framework.managers.DriverManager;
import org.example.appline.framework.managers.InitManager;
import org.example.appline.framework.managers.PageManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTests {
    protected static DriverManager driverManager = DriverManager.getInstance();
    protected static PageManager pageManager = PageManager.getInstance();
    protected static final Logger logger = LogManager.getLogger(BaseTests.class);

    @Before
    public void before() {
        InitManager.initFramework();
        driverManager.getDriver();
        logger.info("Driver initialized");
        pageManager.getFirstPage().loadHomePage();
        logger.info("Тест начат");
    }

    @AfterClass
    public static void tearDown() {
        InitManager.quitFramework();
        logger.info("Framework quit");
    }
    protected void takeScreenshot(String testName) {
        File scrFile = ((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        try {
            FileHandler.copy(scrFile, new File("src/test/screenshots/" + testName + "_" + timestamp + ".png"));
            logger.info("Скриншот сохранён: " + testName + "_" + timestamp + ".png");
        } catch (IOException e) {
            logger.error("Ошибка при сохранении скриншота: " + e.getMessage());
        }
    }

}

package org.example.appline.framework.managers;

import org.example.appline.framework.utils.PropsConst;

import java.util.concurrent.TimeUnit;

import static org.example.appline.framework.utils.PropsConst.PAGE_LOAD_TIMEOUT;


public class InitManager {
    private static final TestPropertiesManager props = TestPropertiesManager.getInstance();
    private static final DriverManager driverManager = DriverManager.getInstance();
    public static void initFramework() {
        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(props.getProperty(PropsConst.IMPLICITLY_WAIT)), TimeUnit.SECONDS);
        driverManager.getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(props.getProperty(PAGE_LOAD_TIMEOUT)), TimeUnit.SECONDS);
    }
    public static void quitFramework() {
        driverManager.quitDriver();
    }
}

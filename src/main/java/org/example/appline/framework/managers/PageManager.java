package org.example.appline.framework.managers;

import org.example.appline.framework.pages.task1.StartPage;
import org.example.appline.framework.pages.task2.DMamiPage;
import org.example.appline.framework.pages.task2.HomePage;
import org.example.appline.framework.pages.task2.SchedulesPage;
import org.example.appline.framework.pages.task3.GamingPhonePage;
import org.example.appline.framework.pages.task3.MainPage;
import org.example.appline.framework.pages.task4.*;

public class PageManager {

    private static PageManager instance;
    private StartPage startPage;
    private HomePage startPage2;
    private SchedulesPage schedulesPage;
    private DMamiPage dmamiPage;
    private MainPage mainPage;
    private GamingPhonePage gamingPhonePage;
    private FirstPage firstPage;
    private CarsPage carsPage;
    private ConfigurationPage configurationPage;
    private AutoWithMileagePage autoWithMileagePage;
    private AccessoriesStartPage accessoriesStartPage;
    private AccessoriesPage accessoriesPage;

    private PageManager() {
        // Приватный конструктор, чтобы предотвратить создание экземпляров класса извне
    }

    public static PageManager getInstance() {
        if (instance == null) {
            instance = new PageManager();
        }
        return instance;
    }

    public StartPage getStartPageL() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public HomePage getStartPageM() {
        if (startPage2 == null) {
            startPage2 = new HomePage();
        }
        return startPage2;
    }
    public SchedulesPage getSchedulesPage() {
        if (schedulesPage == null) {
           schedulesPage = new SchedulesPage();
        }
        return schedulesPage;
    }
    public DMamiPage getdMamiPage() {
        if (dmamiPage == null) {
            dmamiPage = new DMamiPage();
        }
        return dmamiPage;
    }
    public MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }
    public GamingPhonePage getGamingPhonePage() {
        if (gamingPhonePage == null) {
            gamingPhonePage = new GamingPhonePage();
        }
        return gamingPhonePage;
    }
    public FirstPage getFirstPage() {
        if (firstPage == null) {
            firstPage = new FirstPage();
        }
        return firstPage;
    }
    public CarsPage getCarsPage() {
        if (carsPage == null) {
            carsPage = new CarsPage();
        }
        return carsPage;
    }
    public ConfigurationPage getConfigurationPage() {
        if (configurationPage == null) {
            configurationPage = new ConfigurationPage();
        }
        return configurationPage;
    }
    public AutoWithMileagePage getAutoWithMileagePage() {
        if (autoWithMileagePage == null) {
            autoWithMileagePage = new AutoWithMileagePage();
        }
        return autoWithMileagePage;
    }
    public AccessoriesStartPage getAccessoriesStartPage() {
        if (accessoriesStartPage == null) {
            accessoriesStartPage = new AccessoriesStartPage();
        }
        return accessoriesStartPage;
    }
    public AccessoriesPage getAccessoriesPage() {
        if (accessoriesPage == null) {
            accessoriesPage = new AccessoriesPage();
        }
        return accessoriesPage;
    }
}

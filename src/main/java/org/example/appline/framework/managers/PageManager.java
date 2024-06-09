package org.example.appline.framework.managers;
import org.example.appline.framework.pages.task1.StartPage;
import org.example.appline.framework.pages.task2.DMamiPage;
import org.example.appline.framework.pages.task2.HomePage;
import org.example.appline.framework.pages.task2.SchedulesPage;

public class PageManager {

    private static PageManager instance;
    private StartPage startPage;
    private HomePage startPage2;
    private SchedulesPage schedulesPage;
    private DMamiPage dmamiPage;

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
}

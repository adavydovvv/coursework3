package task4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class Tests4 extends BaseTests {

    @Rule
    public TestName testName = new TestName();

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            takeScreenshot(testName.getMethodName());
        }
    };
    @Test
    public void test1() throws InterruptedException {
        pageManager.getFirstPage().checkStartH2()
                .clickCarButton()
                .clickMButton()
                .clickF90ConfigurationButton()
                .checkPrice()
                .clickBmwWithMileageButton()
                .clickMoreDetailButton()
                .checkCarsM5();
    }
    @Test
    public void test2() throws InterruptedException {
        pageManager.getFirstPage().checkStartH2()
                .clickAutoWMButton()
                .enterFiltres()
                .enterSort();
    }

    @Test
    public void test3() throws InterruptedException {
        pageManager.getFirstPage().checkStartH2()
                .clickAccessoriesButton()
                .clickAccessoriesForCarsButton()
                .clickMPerformanceAccessoriesButton()
                .checkPageTitle()
                .clickComplectButton();
    }
}

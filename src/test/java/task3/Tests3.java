package task3;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class Tests3 extends BaseTests {

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
    public void test() throws InterruptedException {

        pageManager.getMainPage().clickOnGamingMobileButton()
                                .infoToLogs3()
                                .clickFilterSamsung();

    }
}

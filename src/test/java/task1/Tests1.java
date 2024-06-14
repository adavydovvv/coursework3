package task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class Tests1 extends BaseTests {
    private static final Logger logger = LogManager.getLogger(Tests1.class);
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
    public void test() {
        pageManager.getStartPageL().checkTitle()
                .getRemainingText()
                .isFirstCheckboxSelected()
                .getFirstItemClass()
                .clickFirstCheckbox()
                .clickAllCheckboxes()
                .addNewElement();
    }
}

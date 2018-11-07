package esm.cases.audit.platform.overview;

import esm.page.audit.platform.overview.OverviewPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import esm.util.TestngRetry;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RebootTest extends SeleniumTestCase {

    OverviewPage overviewPage;
    String count;

    @Test(description = "终端需要重启验证为否",retryAnalyzer = TestngRetry.class)
    public void rebootNo(){

        overviewPage = new OverviewPage(driver);
        count = overviewPage.getCount().getText();
        overviewPage.getNoReboot().click();
        TestUtil.waitForChanges(By.id("assignPage_totalCount"),count);
        count = overviewPage.getCount().getText();
        Assert.assertEquals(overviewPage.getTr().findElement(By.xpath("./td[2]")).
                getText(),expect.getString("expect1"),"终端需要重启否验证错误");
    }

    @Test(dependsOnMethods = "rebootNo",description = "终端需要重启验证为是",retryAnalyzer = TestngRetry.class)
    public void rebootYes(){

        overviewPage.getYesReboot().click();
        TestUtil.waitForChanges(By.id("assignPage_totalCount"),count);
        Assert.assertEquals(overviewPage.getTr().findElement(By.xpath("./td[2]")).
                getText(),expect.getString("expect2"),"终端需要重启是验证错误");
    }
}

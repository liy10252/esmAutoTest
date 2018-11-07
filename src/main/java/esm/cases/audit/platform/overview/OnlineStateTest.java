package esm.cases.audit.platform.overview;

import esm.page.audit.platform.overview.OverviewPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import esm.util.TestngRetry;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnlineStateTest extends SeleniumTestCase {

    OverviewPage overviewPage;
    String count;

    @Test(description = "终端在线状态验证为在线",retryAnalyzer = TestngRetry.class)
    public void onlineStateY() {

        overviewPage = new OverviewPage(driver);
        count = overviewPage.getCount().getText();
        overviewPage.getAlreadyLoginStatus().click();
        TestUtil.waitForChanges(By.id("assignPage_totalCount"), count);
        count = overviewPage.getCount().getText();

        Assert.assertEquals(overviewPage.getTr().findElement(By.xpath("./td[1]//img"))
                .getAttribute("src").contains(param.getString("onlineY")), expect.getBooleanValue("expect1"), "终端在线验证错误");
    }

    @Test(dependsOnMethods = "onlineStateY", description = "终端在线状态验证为离线",retryAnalyzer = TestngRetry.class)
    public void onlineStateN() {

        overviewPage.getNotLoginStatus().click();
        TestUtil.waitForChanges(By.id("assignPage_totalCount"), count);
        Assert.assertEquals(overviewPage.getTr().findElement(By.xpath("./td[1]//img"))
                .getAttribute("src").contains(param.getString("onlineN")), expect.getBooleanValue("expect2"), "终端未在线验证错误");
    }
}

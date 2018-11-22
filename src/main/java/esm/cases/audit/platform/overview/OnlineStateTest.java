package esm.cases.audit.platform.overview;

import esm.page.audit.platform.overview.OverviewPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnlineStateTest extends SeleniumTestCase {

    OverviewPage overviewPage;
    String count;

    @Test(description = "终端在线状态验证为在线")
    public void onlineStateY() {

        overviewPage = new OverviewPage(driver);
        mothodUtil(overviewPage.getAlreadyLoginStatus(),param.getString("onlineY"),expect.getBooleanValue("expect1"));
    }

    @Test(dependsOnMethods = "onlineStateY", description = "终端在线状态验证为离线")
    public void onlineStateN() {
        mothodUtil(overviewPage.getNotLoginStatus(),param.getString("onlineN"),expect.getBooleanValue("expect2"));
    }

    public void mothodUtil(WebElement element,String text,boolean expect){

        overviewPage.getUnlimitedStatus().click();
        count = overviewPage.getCount().getText();
        element.click();
        TestUtil.waitForChanges(By.id("assignPage_totalCount"), count);
        Assert.assertEquals(overviewPage.getTr().findElement(By.xpath("./td[1]//img"))
                .getAttribute("src").contains(text), expect, "终端未在线验证错误");

    }
}

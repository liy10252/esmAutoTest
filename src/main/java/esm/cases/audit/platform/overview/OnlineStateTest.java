package esm.cases.audit.platform.overview;

import esm.page.audit.platform.overview.OverviewPage;
import esm.util.SeleniumTestCase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnlineStateTest extends SeleniumTestCase {

    OverviewPage overviewPage;

    @Test(description = "终端在线状态验证为在线")
    public void onlineStateY() {

        overviewPage = new OverviewPage(driver);
        overviewPage.singleClickTool(overviewPage.getUnlimitedStatus(),overviewPage.getAlreadyLoginStatus());
        Assert.assertTrue(overviewPage.getTr().findElement(By.xpath("./td[1]//img"))
                .getAttribute("src").contains(param.getString("onlineY")), "终端未在线验证错误");

    }

    @Test(dependsOnMethods = "onlineStateY", description = "终端在线状态验证为离线")
    public void onlineStateN() {
        overviewPage.singleClickTool(overviewPage.getUnlimitedStatus(),overviewPage.getNotLoginStatus());
        Assert.assertTrue(overviewPage.getTr().findElement(By.xpath("./td[1]//img"))
                .getAttribute("src").contains(param.getString("onlineN")), "终端未在线验证错误");

    }

}

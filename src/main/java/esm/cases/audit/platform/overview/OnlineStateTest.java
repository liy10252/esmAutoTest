package esm.cases.audit.platform.overview;

import esm.page.audit.platform.overview.OverviewPage;
import esm.util.Assertion;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class OnlineStateTest extends SeleniumTestCase {

    OverviewPage overviewPage;

    @Test(description = "终端在线状态验证为在线")
    public void onlineStateY(){

        overviewPage = new OverviewPage(driver);
        overviewPage.getAlreadyLoginStatus().click();
        TestUtil.waitFortextToElement(By.id("assignPage_totalCount"),"2");
        Assertion.verifyEquals(overviewPage.getTr().findElement(By.xpath("./td[1]//img"))
        .getAttribute("src").contains("online.gif"),true,"终端在线验证错误");



    }

    @Test(dependsOnMethods = "onlineStateY",description = "终端在线状态验证为离线")
    public void onlineStateN(){

        overviewPage.getNotLoginStatus().click();
        TestUtil.waitFortextToElement(By.id("assignPage_totalCount"),"1");
        Assertion.verifyEquals(overviewPage.getTr().findElement(By.xpath("./td[1]//img"))
                .getAttribute("src").contains("unonline.gif"),true,"终端未在线验证错误");
    }
}

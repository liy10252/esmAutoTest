package esm.cases.audit.platform.overview;

import esm.page.audit.platform.overview.OverviewPage;
import esm.util.SeleniumTestCase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RebootTest extends SeleniumTestCase {

    OverviewPage overviewPage;

    @Test(description = "终端需要重启验证为否")
    public void rebootNo(){

        overviewPage = new OverviewPage(driver);
        overviewPage.singleClickTool(overviewPage.getUnlimitedReboot(),overviewPage.getNoReboot());
        Assert.assertEquals(overviewPage.getTr().findElement(By.xpath("./td[2]")).
                getText(),expect.getString("rebootNo"),"终端需要重启否验证错误");
    }

    @Test(dependsOnMethods = "rebootNo",description = "终端需要重启验证为是")
    public void rebootYes(){

        overviewPage.singleClickTool(overviewPage.getUnlimitedReboot(),overviewPage.getYesReboot());
        Assert.assertEquals(overviewPage.getTr().findElement(By.xpath("./td[2]")).
                getText(),expect.getString("rebootYes"),"终端需要重启否验证错误");

    }
}

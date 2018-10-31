package esm.cases.audit.platform.overview;

import esm.page.audit.platform.overview.OverviewPage;
import esm.util.Assertion;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RebootTest extends SeleniumTestCase {

    OverviewPage overviewPage;

    @Test(description = "终端需要重启验证为否")
    public void rebootNo(){

        overviewPage = new OverviewPage(driver);
        overviewPage.getNoReboot().click();
        TestUtil.waitFortextToElement(By.id("assignPage_totalCount"),"2");
        Assertion.verifyEquals(overviewPage.getTr().findElement(By.xpath("./td[2]")).
                getText(),"否","终端需要重启否验证错误");

    }

    @Test(dependsOnMethods = "rebootNo",description = "终端需要重启验证为是")
    public void rebootYes(){
        overviewPage.getYesReboot().click();
        TestUtil.waitFortextToElement(By.id("assignPage_totalCount"),"1");
        Assertion.verifyEquals(overviewPage.getTr().findElement(By.xpath("./td[2]")).
                getText(),"是","终端需要重启是验证错误");
    }
}

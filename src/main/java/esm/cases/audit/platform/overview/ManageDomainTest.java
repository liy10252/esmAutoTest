package esm.cases.audit.platform.overview;

import esm.page.audit.platform.overview.OverviewPage;
import esm.util.Assertion;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ManageDomainTest extends SeleniumTestCase {

    @Test(description = "终端管理范围验证")
    public void ManageDomain(){

        OverviewPage overviewPage = new OverviewPage(driver);
        Actions action = new Actions(driver);
        action.moveToElement(overviewPage.getGroupPath()).perform();
        overviewPage.getGroupPathSpan().click();
        action.moveToElement(overviewPage.getTbody()).perform();
        TestUtil.waitFortextToElement(By.id("assignPage_totalCount"),"0");
        Assertion.verifyEquals(overviewPage.getTbody().getText().trim().equals(""),true,"终端管理范围验证错误");

    }
}

package esm.cases.audit.antivirus.networkkill;

import esm.page.audit.antivirus.networkkill.NetWorkKillPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import esm.util.TestngRetry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnlineStateTest extends SeleniumTestCase {

	NetWorkKillPage netWorkKillPage;
	String count;

	@Test(description = "在线状态验证",retryAnalyzer = TestngRetry.class)
	public void onLine(){

		netWorkKillPage = new NetWorkKillPage(driver);
		methodUtil(netWorkKillPage.getOnLine(),expect.getBooleanValue("expect1"));
	}

	@Test(dependsOnMethods = "onLine",description = "在线状态验证",retryAnalyzer = TestngRetry.class)
	public void offLine(){

		netWorkKillPage = new NetWorkKillPage(driver);
		methodUtil(netWorkKillPage.getOffLine(),expect.getBooleanValue("expect2"));
	}

	public void methodUtil(WebElement element,boolean expect){

		netWorkKillPage.getOnlineUnlimited().click();
		count = netWorkKillPage.getCount().getText();
		element.click();
		TestUtil.waitForChanges(By.id("assignPage_totalCount"), count);
		Assert.assertEquals(TestUtil.waitForVisbility(netWorkKillPage.getOnLineStatus())
				.getAttribute("src").contains("unonline.gif"), expect, "未执行扫描验证错误");
	}
}

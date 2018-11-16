package esm.cases.audit.antivirus.networkkill;

import esm.page.audit.antivirus.networkkill.NetWorkKillPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import esm.util.TestngRetry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MailMonitorTest extends SeleniumTestCase {

	NetWorkKillPage netWorkKillPage;
	String count;

	@Test(description = "邮件监控开启验证",retryAnalyzer = TestngRetry.class)
	public void mailMonitorOn(){

		netWorkKillPage = new NetWorkKillPage(driver);
		mothodUtil(netWorkKillPage.getMailOpen(),expect.getString("expect1"));
	}

	@Test(dependsOnMethods = "mailMonitorOn",description = "邮件监控关闭验证",retryAnalyzer = TestngRetry.class)
	public void mailMonitorOff(){

		mothodUtil(netWorkKillPage.getMailClose(),expect.getString("expect2"));

	}

	public void mothodUtil(WebElement element, String expect){

		netWorkKillPage.getMailUnlimited().click();
		count = netWorkKillPage.getCount().getText();
		element.click();
		TestUtil.waitForChanges(By.id("assignPage_totalCount"), count);
		Assert.assertEquals(TestUtil.waitForVisbility(netWorkKillPage.getMailStatus())
				.getAttribute("class"), expect, "邮件监控验证错误");
	}
}

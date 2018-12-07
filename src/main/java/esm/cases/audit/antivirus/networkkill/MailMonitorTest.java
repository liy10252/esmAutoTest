package esm.cases.audit.antivirus.networkkill;

import esm.page.audit.antivirus.networkkill.NetWorkKillPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MailMonitorTest extends SeleniumTestCase {

	NetWorkKillPage netWorkKillPage;

	@Test(description = "邮件监控开启验证")
	public void mailMonitorOn(){

		netWorkKillPage = new NetWorkKillPage(driver);
		netWorkKillPage.singleClickTool(netWorkKillPage.getMailUnlimited(),netWorkKillPage.getMailOpen());
		Assert.assertEquals(TestUtil.waitForVisbility(netWorkKillPage.getMailStatus())
				.getAttribute("class"), expect.getString("on"), "邮件监控验证错误");
	}

	@Test(dependsOnMethods = "mailMonitorOn",description = "邮件监控关闭验证")
	public void mailMonitorOff(){

		netWorkKillPage.singleClickTool(netWorkKillPage.getMailUnlimited(),netWorkKillPage.getMailClose());
		Assert.assertEquals(TestUtil.waitForVisbility(netWorkKillPage.getMailStatus())
				.getAttribute("class"), expect.getString("off"), "邮件监控验证错误");

	}

}

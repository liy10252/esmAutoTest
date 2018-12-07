package esm.cases.audit.antivirus.networkkill;

import esm.page.audit.antivirus.networkkill.NetWorkKillPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnlineStateTest extends SeleniumTestCase {

	NetWorkKillPage netWorkKillPage;

	@Test(description = "在线状态验证")
	public void onLine(){

		netWorkKillPage = new NetWorkKillPage(driver);
		netWorkKillPage.singleClickTool(netWorkKillPage.getOnlineUnlimited(),netWorkKillPage.getOnLine());
		Assert.assertEquals(TestUtil.waitForVisbility(netWorkKillPage.getOnLineStatus())
				.getAttribute("src").contains("unonline.gif"), expect.getBooleanValue("onLine"), "未执行扫描验证错误");
	}

	@Test(dependsOnMethods = "onLine",description = "在线状态验证")
	public void offLine(){

		netWorkKillPage.singleClickTool(netWorkKillPage.getOnlineUnlimited(),netWorkKillPage.getOffLine());
		Assert.assertEquals(TestUtil.waitForVisbility(netWorkKillPage.getOnLineStatus())
				.getAttribute("src").contains("unonline.gif"), expect.getBooleanValue("offLine"), "未执行扫描验证错误");
	}

}

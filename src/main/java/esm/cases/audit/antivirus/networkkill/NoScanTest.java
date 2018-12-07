package esm.cases.audit.antivirus.networkkill;

import esm.page.audit.antivirus.networkkill.NetWorkKillPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoScanTest extends SeleniumTestCase {

	NetWorkKillPage netWorkKillPage;

	@Test(description = "未执行扫描验证")
	public void lastWeek(){

		netWorkKillPage = new NetWorkKillPage(driver);
		netWorkKillPage.singleClickTool(netWorkKillPage.getScanUnlimited(),netWorkKillPage.getLastWeek());
		Assert.assertEquals(TestUtil.waitForVisbility(netWorkKillPage.getScanStatus())
				.getText(), expect.getString("lastWeek"), "未执行扫描验证错误");

	}

	@Test(dependsOnMethods = "lastWeek",description = "未执行扫描验证")
	public void lastMonth(){

		netWorkKillPage.singleClickTool(netWorkKillPage.getScanUnlimited(),netWorkKillPage.getLastMonth());
		Assert.assertEquals(TestUtil.waitForVisbility(netWorkKillPage.getScanStatus())
				.getText(), expect.getString("lastMonth"), "未执行扫描验证错误");

	}

	@Test(dependsOnMethods = "lastWeek",description = "未执行扫描验证")
	public void noScan(){

		netWorkKillPage.singleClickTool(netWorkKillPage.getScanUnlimited(),netWorkKillPage.getNoScan());
		Assert.assertEquals(TestUtil.waitForVisbility(netWorkKillPage.getScanStatus())
				.getText(), expect.getString("noScan"), "未执行扫描验证错误");

	}

	@Test(dependsOnMethods = "lastWeek",description = "未执行扫描验证")
	public void scanning(){

		netWorkKillPage.singleClickTool(netWorkKillPage.getScanUnlimited(),netWorkKillPage.getScanning());
		Assert.assertEquals(TestUtil.waitForVisbility(netWorkKillPage.getScanStatus())
				.getText(), expect.getString("scanning"), "未执行扫描验证错误");

	}

}

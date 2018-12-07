package esm.cases.audit.antivirus.networkkill;

import esm.page.audit.antivirus.networkkill.NetWorkKillPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileMonitorTest extends SeleniumTestCase {

	NetWorkKillPage netWorkKillPage;

	@Test(description = "文件监控开启验证")
	public void fileMonitorOn(){

		netWorkKillPage = new NetWorkKillPage(driver);
		netWorkKillPage.singleClickTool(netWorkKillPage.getFileUnlimited(),netWorkKillPage.getFileOpen());
		Assert.assertEquals(TestUtil.waitForVisbility(netWorkKillPage.getFileStatus())
				.getAttribute("class"), expect.getString("open"), "文件监控验证错误");

	}

	@Test(dependsOnMethods = "fileMonitorOn",description = "文件监控关闭验证")
	public void fileMonitorOff(){

		netWorkKillPage.singleClickTool(netWorkKillPage.getFileUnlimited(),netWorkKillPage.getFileClose());
		Assert.assertEquals(TestUtil.waitForVisbility(netWorkKillPage.getFileStatus())
				.getAttribute("class"),expect.getString("close"), "文件监控验证错误");

	}

}

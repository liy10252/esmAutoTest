package esm.cases.audit.antivirus.networkkill;

import esm.page.audit.antivirus.networkkill.NetWorkKillPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import esm.util.TestngRetry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileMonitorTest extends SeleniumTestCase {

	NetWorkKillPage netWorkKillPage;
	String count;

	@Test(description = "文件监控开启验证",retryAnalyzer = TestngRetry.class)
	public void fileMonitorOn(){

		netWorkKillPage = new NetWorkKillPage(driver);
		mothodUtil(netWorkKillPage.getFileOpen(),expect.getString("expect1"));

	}

	@Test(dependsOnMethods = "fileMonitorOn",description = "文件监控关闭验证",retryAnalyzer = TestngRetry.class)
	public void fileMonitorOff(){

		mothodUtil(netWorkKillPage.getFileClose(),expect.getString("expect2"));

	}


	public void mothodUtil(WebElement element,String expect){

		netWorkKillPage.getFileUnlimited().click();
		count = netWorkKillPage.getCount().getText();
		element.click();
		TestUtil.waitForChanges(By.id("assignPage_totalCount"), count);
		Assert.assertEquals(TestUtil.waitForVisbility(netWorkKillPage.getFileStatus())
				.getAttribute("class"), expect, "文件监控验证错误");
	}
}

package esm.cases.audit.antivirus.networkkill;

import esm.page.audit.antivirus.networkkill.NetWorkKillPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoScanTest extends SeleniumTestCase {

	NetWorkKillPage netWorkKillPage;
	String count;

	@Test(description = "未执行扫描验证")
	public void lastWeek(){

		netWorkKillPage = new NetWorkKillPage(driver);
		methodUtil(netWorkKillPage.getLastWeek(),expect.getString("expect1"));

	}

	@Test(dependsOnMethods = "lastWeek",description = "未执行扫描验证")
	public void lastMonth(){

		methodUtil(netWorkKillPage.getLastMonth(),expect.getString("expect2"));

	}

	@Test(dependsOnMethods = "lastWeek",description = "未执行扫描验证")
	public void noScan(){

		methodUtil(netWorkKillPage.getNoScan(),expect.getString("expect3"));

	}

	@Test(dependsOnMethods = "lastWeek",description = "未执行扫描验证")
	public void scanning(){

		methodUtil(netWorkKillPage.getScanning(),expect.getString("expect4"));

	}


	public void methodUtil(WebElement element,String expect){

		netWorkKillPage.getScanUnlimited().click();
		count = netWorkKillPage.getCount().getText();
		element.click();
		TestUtil.waitForChanges(By.id("assignPage_totalCount"), count);
		Assert.assertEquals(TestUtil.waitForVisbility(netWorkKillPage.getScanStatus())
				.getText(), expect, "未执行扫描验证错误");
	}
}

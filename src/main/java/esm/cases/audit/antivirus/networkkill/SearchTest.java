package esm.cases.audit.antivirus.networkkill;

import esm.page.audit.antivirus.networkkill.NetWorkKillPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends SeleniumTestCase {

	NetWorkKillPage netWorkKillPage;
	String text;

	@Test(description = "全网查杀搜索条验证计算机名")
	public void searchComputer(){

		netWorkKillPage = new NetWorkKillPage(driver);
		text = param.getString("computerName");
		netWorkKillPage.searchUtil(netWorkKillPage.getComputerName(),text);
		Assert.assertEquals(TestUtil.waitForVisbility(netWorkKillPage.getTr()).findElement(By.xpath("./td[2]//span[2]"))
				.getText(),text,"全网查杀搜索条验证"+text+"错误");
	}

	@Test(dependsOnMethods = "searchComputer",description = "全网查杀搜索条验证ip")
	public void searchIp(){

		text = param.getString("ip");
		netWorkKillPage.searchUtil(netWorkKillPage.getIp(),text);
		Assert.assertEquals(TestUtil.waitForVisbility(netWorkKillPage.getTr()).findElement(By.xpath("./td[3]/div"))
				.getText(),text,"全网查杀搜索条验证"+text+"错误");
	}

	@Test(dependsOnMethods = "searchComputer",description = "全网查杀搜索条验证病毒库版本")
	public void searchvlibVer(){

		text = param.getString("vlibVer");
		netWorkKillPage.searchUtil(netWorkKillPage.getVlibVer(),text);
		Assert.assertEquals(TestUtil.waitForVisbility(netWorkKillPage.getTr()).findElement(By.xpath("./td[7]"))
				.getText(),text,"全网查杀搜索条验证"+text+"错误");
	}

}

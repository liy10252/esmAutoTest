package esm.cases.audit.antivirus.networkkill;

import esm.page.audit.antivirus.networkkill.NetWorkKillPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import esm.util.TestngRetry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends SeleniumTestCase {

	NetWorkKillPage netWorkKillPage;
	String count;

	@Test(description = "全网查杀搜索条验证计算机名",retryAnalyzer = TestngRetry.class)
	public void searchComputer(){

		netWorkKillPage = new NetWorkKillPage(driver);
		methodUtil(param.getString("computerName"),
				netWorkKillPage.getComputerName(),By.xpath("./td[2]//span[2]"));
	}

	@Test(dependsOnMethods = "searchComputer",description = "全网查杀搜索条验证ip",retryAnalyzer = TestngRetry.class)
	public void searchIp(){

		methodUtil(param.getString("ip"),
				netWorkKillPage.getIp(),By.xpath("./td[3]/div"));
	}

	@Test(dependsOnMethods = "searchComputer",description = "全网查杀搜索条验证病毒库版本",retryAnalyzer = TestngRetry.class)
	public void searchvlibVer(){

		methodUtil(param.getString("vlibVer"),
				netWorkKillPage.getVlibVer(),By.xpath("./td[7]"));
	}


	public void methodUtil(String text, WebElement element, By locator){

		netWorkKillPage.getSearchBar().clear();
		netWorkKillPage.getSearchButton().click();
		TestUtil.seleniumWait();
		count = netWorkKillPage.getCount().getText();

		netWorkKillPage.getSearchBar().sendKeys(text);
		TestUtil.waitForClick(element);
		element.click();
		netWorkKillPage.getSearchButton().click();
		TestUtil.waitForChanges(By.id("assignPage_totalCount"), count);

		Assert.assertEquals(TestUtil.waitForVisbility(netWorkKillPage.getTr()).findElement(locator)
				.getText(),text,"全网查杀搜索条验证"+text+"错误");
	}
}

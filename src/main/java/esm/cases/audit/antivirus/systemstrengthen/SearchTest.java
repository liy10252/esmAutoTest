package esm.cases.audit.antivirus.systemstrengthen;

import esm.page.audit.antivirus.systemstrengthen.SystemStrengThenPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends SeleniumTestCase {

	SystemStrengThenPage strengThenPage;

	@Test(description = "计算机名称搜索验证")
	public void searchComputer(){

		strengThenPage = new SystemStrengThenPage(driver);
		strengThenPage.getTimeUnlimited().click();
		strengThenPage.searchUtil(strengThenPage.getSearchBar(),
				strengThenPage.getSearchButton(),strengThenPage.getComputerName(),
				expect.getString("computer"));
		Assert.assertEquals(TestUtil.waitForVisbility(strengThenPage.getValue())
				.getText(),expect.getString("computer"),"系统加固搜索条验证错误");
	}

	@Test(dependsOnMethods = "searchComputer",description = "ip地址搜索验证")
	public void searchIp(){

		strengThenPage.searchUtil(strengThenPage.getSearchBar(),
				strengThenPage.getSearchButton(),strengThenPage.getIp(),expect.getString("ip"));
		Assert.assertEquals(strengThenPage.getValue().findElement(By.xpath("./following-sibling::td[1]"))
				.getText(),expect.getString("ip"),"系统加固搜索条验证错误");
	}

}

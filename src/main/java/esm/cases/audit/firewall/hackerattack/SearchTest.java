package esm.cases.audit.firewall.hackerattack;

import esm.page.audit.firewall.hackerattack.HackerAttackPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends SeleniumTestCase {

	HackerAttackPage hackerAttackPage;

	@Test(description = "计算机名称搜索验证")
	public void searchComputer(){

		hackerAttackPage = new HackerAttackPage(driver);
		hackerAttackPage.getTimeUnlimited().click();
		hackerAttackPage.searchUtil(hackerAttackPage.getComputerName(),expect.getString("computer"));
		Assert.assertEquals(TestUtil.waitForVisbility(hackerAttackPage.getValue())
				.getText(),expect.getString("computer"),"黑客攻击搜索条验证错误");
	}

	@Test(dependsOnMethods = "searchComputer",description = "ip地址搜索验证")
	public void searchIp(){

		hackerAttackPage.searchUtil(hackerAttackPage.getIp(),expect.getString("ip"));
		Assert.assertEquals(hackerAttackPage.getValue().findElement(By.xpath("./following-sibling::td[1]"))
				.getText(),expect.getString("ip"),"黑客攻击搜索条验证错误");
	}

}

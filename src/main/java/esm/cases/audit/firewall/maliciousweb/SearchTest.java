package esm.cases.audit.firewall.maliciousweb;

import esm.page.audit.firewall.maliciousweb.MaliciousWebPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends SeleniumTestCase {

	MaliciousWebPage maliciousWebPage;

	@Test(description = "网址搜索验证")
	public void webSite(){

		maliciousWebPage = new MaliciousWebPage(driver);
		maliciousWebPage.getTimeUnlimited().click();
		maliciousWebPage.searchUtil(maliciousWebPage.getSearchBar(),
				maliciousWebPage.getSearchButton(),maliciousWebPage.getWebSite(),expect.getString("webSite"));
		Assert.assertEquals(TestUtil.waitForVisbility(maliciousWebPage.getValue()).findElement(By.xpath("./following-sibling::td[5]"))
				.getText(),expect.getString("webSite"),"网址搜索条验证错误");
	}

	@Test(dependsOnMethods = "webSite",description = "域名搜索验证")
	public void domain(){

		maliciousWebPage.searchUtil(maliciousWebPage.getSearchBar(),
				maliciousWebPage.getSearchButton(),maliciousWebPage.getDomain(),expect.getString("domain"));
		Assert.assertEquals(TestUtil.waitForVisbility(maliciousWebPage.getValue()).findElement(By.xpath("./following-sibling::td[4]"))
				.getText(),expect.getString("domain"),"域名搜索条验证错误");
	}

}


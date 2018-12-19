package esm.cases.audit.firewall.adfilter;

import esm.page.audit.firewall.adfilter.AdFilterPage;
import esm.util.SeleniumTestCase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends SeleniumTestCase {

	AdFilterPage adFilterPage;

	@Test(description = "网址搜索验证")
	public void searchUrl(){

		adFilterPage = new AdFilterPage(driver);
		adFilterPage.getTimeUnlimited().click();
		adFilterPage.searchUtil(adFilterPage.getSearchBar(),
				adFilterPage.getSearchButton(),adFilterPage.getUrl(),expect.getString("url"));
		Assert.assertEquals(adFilterPage.getValue().findElement(By.xpath("./following-sibling::td[3]"))
				.getText(),expect.getString("url"),"搜索条验证错误");
	}

	@Test(dependsOnMethods = "searchUrl",description = "域名搜索验证")
	public void searchWebSite(){

		adFilterPage.searchUtil(adFilterPage.getSearchBar(),
				adFilterPage.getSearchButton(),adFilterPage.getWebSite(),expect.getString("webSite"));
		Assert.assertEquals(adFilterPage.getValue().findElement(By.xpath("./following-sibling::td[4]"))
				.getText(),expect.getString("webSite"),"搜索条验证错误");
	}
}

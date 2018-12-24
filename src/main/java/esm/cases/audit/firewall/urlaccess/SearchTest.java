package esm.cases.audit.firewall.urlaccess;

import esm.page.audit.firewall.forbidurl.ForbidUrlPage;
import esm.util.SeleniumTestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends SeleniumTestCase {

	ForbidUrlPage forbidUrlPage;

	@Test(description = "网站搜索验证")
	public void searchWebSite(){

		forbidUrlPage = new ForbidUrlPage(driver);
		forbidUrlPage.getTimeUnlimited().click();
		forbidUrlPage.searchUtil(forbidUrlPage.getSearchBar(),
				forbidUrlPage.getSearchButton(),forbidUrlPage.getWebSite(),expect.getString("webSite"));
		Assert.assertEquals(forbidUrlPage.getValue().getText(),
				expect.getString("webSite"),"搜索条验证错误");
	}


}

package esm.cases.audit.firewall.urlaccess;

import esm.page.audit.firewall.forbidurl.ForbidUrlPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebSiteListTest extends SeleniumTestCase {

	ForbidUrlPage forbidUrlPage;

	@Test(description = "网站显示列表验证")
	public void showWebSite(){

		forbidUrlPage = new ForbidUrlPage(driver);
		forbidUrlPage.getTimeUnlimited().click();
		TestUtil.waitForVisbilitys(forbidUrlPage.getValues());
		Assert.assertTrue(TestUtil.getValueList(forbidUrlPage.getValues()).containsAll(TestUtil.JsonToList(expect.getJSONArray("webSite"),"name")),"按网站显示验证错误");
	}

	@Test(dependsOnMethods = "showWebSite",description = "客户端显示列表验证")
	public void showClient(){

		forbidUrlPage.getShowClient().click();
		Assert.assertTrue(TestUtil.getValueList(forbidUrlPage.getClients()).containsAll(TestUtil.JsonToList(expect.getJSONArray("client"),"name")),"按客户端显示验证错误");

	}

}

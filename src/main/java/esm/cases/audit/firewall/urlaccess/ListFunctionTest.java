package esm.cases.audit.firewall.urlaccess;

import esm.page.audit.firewall.forbidurl.ForbidUrlPage;
import esm.util.Assertion;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListFunctionTest extends SeleniumTestCase {

	ForbidUrlPage forbidUrlPage;
	String webValue;

	@Test(description = "数据列表详细功能验证")
	public void detail(){

		forbidUrlPage = new ForbidUrlPage(driver);
		forbidUrlPage.getTimeUnlimited().click();
		TestUtil.waitForVisbility(forbidUrlPage.getDetail()).click();
		webValue = forbidUrlPage.getDetailValue().getText().trim().replaceAll("\r|\n*","");
		Assertion.verifyEquals(webValue.contains(expect.getString("detail")),true,"详细功能验证错误");
		forbidUrlPage.getExit().click();
	}

	@Test(dependsOnMethods = "detail",description = "数据列表访问客户端功能验证")
	public void accessClient(){

		TestUtil.waitForVisbility(forbidUrlPage.getAClient()).click();
		webValue = forbidUrlPage.getAClientValue().getText().trim().replaceAll("\r|\n*","");
		Assertion.verifyEquals(webValue.contains(expect.getString("aClient")),true,"数据列表访问客户端功能验证错误");
		forbidUrlPage.getExit().click();
	}

	@Test(dependsOnMethods = "detail",description = "数据列表忽略功能验证")
	public void ignore(){

		TestUtil.waitForVisbility(forbidUrlPage.getIgnore()).click();
		TestUtil.waitForVisbility(forbidUrlPage.getIgnoreConfirm()).click();
		Assert.assertTrue(!forbidUrlPage.getValues().contains(expect.getString("ignore")),"数据列表忽略功能验证错误");
	}

	@Test(dependsOnMethods = "detail",description = "数据列表访问网站功能验证")
	public void visitWebsite(){

		forbidUrlPage.getShowClient().click();
		TestUtil.waitForVisbility(forbidUrlPage.getWebSiteButton()).click();
		Assert.assertTrue(TestUtil.waitForVisbility(forbidUrlPage.getWebSiteValue()).getText().equals(expect.getString("visitWebsite")),"数据列表访问网站功能验证错误");

	}

}

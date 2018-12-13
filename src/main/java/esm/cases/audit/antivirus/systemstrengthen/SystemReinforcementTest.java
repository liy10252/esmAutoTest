package esm.cases.audit.antivirus.systemstrengthen;

import esm.page.audit.antivirus.systemstrengthen.SystemStrengThenPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SystemReinforcementTest extends SeleniumTestCase {

	SystemStrengThenPage strengThenPage;

	@Test(description = "按客户端显示验证")
	public void showClient(){

		strengThenPage = new SystemStrengThenPage(driver);
		strengThenPage.getTimeUnlimited().click();
		TestUtil.seleniumWait();
		Assert.assertTrue(TestUtil.getValueList(strengThenPage.getClientValues()).containsAll(TestUtil.JsonToList((expect.getJSONArray("client")),"name")),"系统加固验证错误");

	}

	@Test(dependsOnMethods = "showClient",description = "按风险显示验证")
	public void showRisk(){

		strengThenPage.getShowRisk().click();
		Assert.assertTrue(TestUtil.getValueList(strengThenPage.getRiskValues()).containsAll(TestUtil.JsonToList((expect.getJSONArray("risk")),"name")),"系统加固验证错误");
	}
}

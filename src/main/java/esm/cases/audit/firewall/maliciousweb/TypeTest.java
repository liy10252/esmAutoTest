package esm.cases.audit.firewall.maliciousweb;

import esm.page.audit.firewall.maliciousweb.MaliciousWebPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TypeTest extends SeleniumTestCase {

	MaliciousWebPage maliciousWebPage;

	@Test(description = "分类日志验证")
	public void trojan(){

		maliciousWebPage = new MaliciousWebPage(driver);
		maliciousWebPage.getTimeUnlimited().click();
		maliciousWebPage.singleClickTool(maliciousWebPage.getAll(),maliciousWebPage.getTrojan());
		Assert.assertTrue(TestUtil.waitForVisbility(maliciousWebPage.getValue()).getText().equals(expect.getString("trojan")),"木马网址验证错误");
	}

	@Test(dependsOnMethods = "trojan",description = "钓鱼网址日志验证")
	public void phishingWeb(){

		maliciousWebPage.singleClickTool(maliciousWebPage.getAll(),maliciousWebPage.getPhishingWeb());
		Assert.assertTrue(TestUtil.waitForVisbility(maliciousWebPage.getValue()).getText().equals(expect.getString("phishingWeb")),"钓鱼网址验证错误");
	}

	@Test(dependsOnMethods = "trojan",description = "恶意下载日志验证")
	public void downLoad(){

		maliciousWebPage.singleClickTool(maliciousWebPage.getAll(),maliciousWebPage.getDownLoad());
		Assert.assertTrue(TestUtil.waitForVisbility(maliciousWebPage.getValue()).getText().equals(expect.getString("downLoad")),"恶意下载验证错误");
	}

	@Test(dependsOnMethods = "trojan",description = "跨站攻击日志验证")
	public void attack(){

		maliciousWebPage.singleClickTool(maliciousWebPage.getAll(),maliciousWebPage.getAttack());
		Assert.assertTrue(TestUtil.waitForVisbility(maliciousWebPage.getValue()).getText().equals(expect.getString("attack")),"跨站攻击验证错误");
	}

	@Test(dependsOnMethods = "trojan",description = "搜索引擎日志验证")
	public void engine(){

		maliciousWebPage.singleClickTool(maliciousWebPage.getAll(),maliciousWebPage.getEngine());
		Assert.assertTrue(TestUtil.waitForVisbility(maliciousWebPage.getValue()).getText().equals(expect.getString("engine")),"搜索引擎验证错误");
	}


}

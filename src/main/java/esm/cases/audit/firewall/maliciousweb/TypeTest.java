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
		Assert.assertEquals(TestUtil.waitForVisbility(maliciousWebPage.getValue()).getText().equals(expect.getString("trojan")),true,"木马网址验证错误");
	}

	@Test(dependsOnMethods = "trojan",description = "钓鱼网址日志验证")
	public void phishingWeb(){

		maliciousWebPage.singleClickTool(maliciousWebPage.getAll(),maliciousWebPage.getPhishingWeb());
		Assert.assertEquals(TestUtil.waitForVisbility(maliciousWebPage.getValue()).getText().equals(expect.getString("phishingWeb")),true,"钓鱼网址验证错误");
	}

	@Test(dependsOnMethods = "trojan",description = "恶意下载日志验证")
	public void downLoad(){

		maliciousWebPage.singleClickTool(maliciousWebPage.getAll(),maliciousWebPage.getDownLoad());
		Assert.assertEquals(TestUtil.waitForVisbility(maliciousWebPage.getValue()).getText().equals(expect.getString("downLoad")),true,"恶意下载验证错误");
	}

	@Test(dependsOnMethods = "trojan",description = "跨站攻击日志验证")
	public void attack(){

		maliciousWebPage.singleClickTool(maliciousWebPage.getAll(),maliciousWebPage.getAttack());
		Assert.assertEquals(TestUtil.waitForVisbility(maliciousWebPage.getValue()).getText().equals(expect.getString("attack")),true,"跨站攻击验证错误");
	}

	@Test(dependsOnMethods = "trojan",description = "搜索引擎日志验证")
	public void engine(){

		maliciousWebPage.singleClickTool(maliciousWebPage.getAll(),maliciousWebPage.getEngine());
		Assert.assertEquals(TestUtil.waitForVisbility(maliciousWebPage.getValue()).getText().equals(expect.getString("engine")),true,"搜索引擎验证错误");
	}


}

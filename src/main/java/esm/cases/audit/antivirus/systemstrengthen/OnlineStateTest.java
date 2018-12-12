package esm.cases.audit.antivirus.systemstrengthen;

import esm.page.audit.antivirus.systemstrengthen.SystemStrengThenPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnlineStateTest extends SeleniumTestCase {

	SystemStrengThenPage strengThenPage;

	@Test(description = "已登录日志验证")
	public void onLine(){

		strengThenPage = new SystemStrengThenPage(driver);
		strengThenPage.getTimeUnlimited().click();
		strengThenPage.singleClickTool(strengThenPage.getOnlineUnlimited(),strengThenPage.getOnline());
		Assert.assertEquals(TestUtil.waitForVisbility(strengThenPage.getValue()).getText().equals(expect.getString("online")),true,"在线状态验证错误");
	}

	@Test(dependsOnMethods = "onLine",description = "未登录日志验证")
	public void offLine(){

		strengThenPage.singleClickTool(strengThenPage.getOnlineUnlimited(),strengThenPage.getOffline());
		Assert.assertEquals(TestUtil.getValueList(strengThenPage.getClientValues()).containsAll(TestUtil.JsonToList((expect.getJSONArray("offline")),"name")),true,"离线状态验证错误");
	}
}

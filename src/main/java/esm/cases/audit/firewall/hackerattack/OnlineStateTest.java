package esm.cases.audit.firewall.hackerattack;

import esm.page.audit.firewall.hackerattack.HackerAttackPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnlineStateTest extends SeleniumTestCase {

	HackerAttackPage hackerAttackPage;

	@Test(description = "已登录日志验证")
	public void onLine(){

		hackerAttackPage = new HackerAttackPage(driver);
		hackerAttackPage.getTimeUnlimited().click();
		hackerAttackPage.singleClickTool(hackerAttackPage.getOnlineUnlimited(),hackerAttackPage.getOnline());
		Assert.assertEquals(TestUtil.waitForVisbility(hackerAttackPage.getValue()).getText().equals(expect.getString("online")),true,"在线状态验证错误");
	}

	@Test(dependsOnMethods = "onLine",description = "未登录日志验证")
	public void offLine(){

		hackerAttackPage.singleClickTool(hackerAttackPage.getOnlineUnlimited(),hackerAttackPage.getOffline());
		Assert.assertEquals(TestUtil.getValueList(hackerAttackPage.getValues()).containsAll(TestUtil.JsonToList((expect.getJSONArray("offline")),"name")),true,"离线状态验证错误");
	}
}



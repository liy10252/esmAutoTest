package esm.cases.audit.firewall.hackerattack;

import esm.page.audit.firewall.hackerattack.HackerAttackPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimeFrameTest extends SeleniumTestCase {

	HackerAttackPage hackerAttackPage;

	@Test(description = "时间范围本周验证")
	public void thisWeek(){

		hackerAttackPage = new HackerAttackPage(driver);
		hackerAttackPage.timeFrameTool(hackerAttackPage.getThisWeek());
		Assert.assertEquals(hackerAttackPage.getValue().getText().equals(expect.getString("thisWeek")),true,"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围上周验证")
	public void lastWeek(){
		hackerAttackPage.timeFrameTool(hackerAttackPage.getLastWeek());
		Assert.assertEquals(TestUtil.getValueList(hackerAttackPage.getValues()).contains(expect.getString("lastWeek")),true,"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围本月验证")
	public void thisMonth(){
		hackerAttackPage.timeFrameTool(hackerAttackPage.getThisMonth());
		Assert.assertEquals(TestUtil.getValueList(hackerAttackPage.getValues()).contains(expect.getString("thisMonth")),true,"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围上月验证")
	public void lastMonth(){
		hackerAttackPage.timeFrameTool(hackerAttackPage.getLastMonth());
		Assert.assertEquals(TestUtil.getValueList(hackerAttackPage.getValues()).contains(expect.getString("lastMonth")),true,"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围指定验证")
	public void special(){

		hackerAttackPage.specialTool();
		Assert.assertEquals(TestUtil.getValueList(hackerAttackPage.getValues()).containsAll(TestUtil.JsonToList((expect.getJSONArray("special")),"name")),true,"时间范围验证错误");

	}


}


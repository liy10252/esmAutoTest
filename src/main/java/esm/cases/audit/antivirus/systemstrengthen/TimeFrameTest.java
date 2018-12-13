package esm.cases.audit.antivirus.systemstrengthen;

import esm.page.audit.antivirus.systemstrengthen.SystemStrengThenPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimeFrameTest extends SeleniumTestCase {

	SystemStrengThenPage strengThenPage;

	@Test(description = "时间范围本周验证")
	public void thisWeek(){

		strengThenPage = new SystemStrengThenPage(driver);
		strengThenPage.timeFrameTool(strengThenPage.getThisWeek());
		Assert.assertTrue(strengThenPage.getValue().getText().equals(expect.getString("thisWeek")),"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围上周验证")
	public void lastWeek(){
		strengThenPage.timeFrameTool(strengThenPage.getLastWeek());
		Assert.assertTrue(TestUtil.getValueList(strengThenPage.getClientValues()).contains(expect.getString("lastWeek")),"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围本月验证")
	public void thisMonth(){
		strengThenPage.timeFrameTool(strengThenPage.getThisMonth());
		Assert.assertTrue(TestUtil.getValueList(strengThenPage.getClientValues()).contains(expect.getString("thisMonth")),"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围上月验证")
	public void lastMonth(){
		strengThenPage.timeFrameTool(strengThenPage.getLastMonth());
		Assert.assertTrue(TestUtil.getValueList(strengThenPage.getClientValues()).contains(expect.getString("lastMonth")),"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围指定验证")
	public void special(){

		strengThenPage.specialTool();
		Assert.assertTrue(TestUtil.getValueList(strengThenPage.getClientValues()).containsAll(TestUtil.JsonToList((expect.getJSONArray("special")),"name")),"时间范围验证错误");

	}



}

package esm.cases.audit.firewall.urlaccess;

import esm.page.audit.firewall.forbidurl.ForbidUrlPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimeFrameTest extends SeleniumTestCase {

	ForbidUrlPage forbidUrlPage;

	@Test(description = "时间范围本周验证")
	public void thisWeek(){

		forbidUrlPage = new ForbidUrlPage(driver);
		forbidUrlPage.timeFrameTool(forbidUrlPage.getThisWeek());
		Assert.assertTrue(forbidUrlPage.getValue().getText().equals(expect.getString("thisWeek")),"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围上周验证")
	public void lastWeek(){
		forbidUrlPage.timeFrameTool(forbidUrlPage.getLastWeek());
		Assert.assertTrue(TestUtil.getValueList(forbidUrlPage.getValues()).contains(expect.getString("lastWeek")),"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围本月验证")
	public void thisMonth(){
		forbidUrlPage.timeFrameTool(forbidUrlPage.getThisMonth());
		Assert.assertTrue(TestUtil.getValueList(forbidUrlPage.getValues()).contains(expect.getString("thisMonth")),"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围上月验证")
	public void lastMonth(){
		forbidUrlPage.timeFrameTool(forbidUrlPage.getLastMonth());
		Assert.assertTrue(TestUtil.getValueList(forbidUrlPage.getValues()).contains(expect.getString("lastMonth")),"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围指定验证")
	public void special(){

		forbidUrlPage.specialTool();
		Assert.assertTrue(TestUtil.getValueList(forbidUrlPage.getValues()).containsAll(TestUtil.JsonToList((expect.getJSONArray("special")),"name")),"时间范围验证错误");

	}


}



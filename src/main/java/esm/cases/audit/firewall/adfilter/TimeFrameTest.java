package esm.cases.audit.firewall.adfilter;

import esm.page.audit.firewall.adfilter.AdFilterPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimeFrameTest extends SeleniumTestCase {

	AdFilterPage adFilterPage;

	@Test(description = "时间范围本周验证")
	public void thisWeek(){

		adFilterPage = new AdFilterPage(driver);
		adFilterPage.timeFrameTool(adFilterPage.getThisWeek());
		Assert.assertTrue(adFilterPage.getValue().getText().equals(expect.getString("thisWeek")),"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围上周验证")
	public void lastWeek(){
		adFilterPage.timeFrameTool(adFilterPage.getLastWeek());
		Assert.assertTrue(TestUtil.getValueList(adFilterPage.getValues()).contains(expect.getString("lastWeek")),"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围本月验证")
	public void thisMonth(){
		adFilterPage.timeFrameTool(adFilterPage.getThisMonth());
		Assert.assertTrue(TestUtil.getValueList(adFilterPage.getValues()).contains(expect.getString("thisMonth")),"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围上月验证")
	public void lastMonth(){
		adFilterPage.timeFrameTool(adFilterPage.getLastMonth());
		Assert.assertTrue(TestUtil.getValueList(adFilterPage.getValues()).contains(expect.getString("lastMonth")),"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围指定验证")
	public void special(){

		adFilterPage.specialTool();
		Assert.assertTrue(TestUtil.getValueList(adFilterPage.getValues()).containsAll(TestUtil.JsonToList((expect.getJSONArray("special")),"name")),"时间范围验证错误");

	}


}


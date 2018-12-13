package esm.cases.audit.antivirus.virusdetails;

import esm.page.audit.antivirus.virusdetails.VirusDetailsPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimeFrameTest extends SeleniumTestCase{

	VirusDetailsPage virusDetailsPage;

	@Test(description = "时间范围本周验证")
	public void thisWeek(){

		virusDetailsPage = new VirusDetailsPage(driver);
		virusDetailsPage.timeFrameTool(virusDetailsPage.getThisWeek());
		Assert.assertTrue(virusDetailsPage.getValue().getText().equals(expect.getString("thisWeek")),"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围上周验证")
	public void lastWeek(){
		virusDetailsPage.timeFrameTool(virusDetailsPage.getLastWeek());
		Assert.assertTrue(TestUtil.getValueList(virusDetailsPage.getValues()).contains(expect.getString("lastWeek")),"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围本月验证")
	public void thisMonth(){
		virusDetailsPage.timeFrameTool(virusDetailsPage.getThisMonth());
		Assert.assertTrue(TestUtil.getValueList(virusDetailsPage.getValues()).contains(expect.getString("thisMonth")),"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围上月验证")
	public void lastMonth(){
		virusDetailsPage.timeFrameTool(virusDetailsPage.getLastMonth());
		Assert.assertTrue(TestUtil.getValueList(virusDetailsPage.getValues()).contains(expect.getString("lastMonth")),"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围指定验证")
	public void special(){

		virusDetailsPage.specialTool();
		Assert.assertTrue(TestUtil.getValueList(virusDetailsPage.getValues()).containsAll(TestUtil.JsonToList((expect.getJSONArray("special")),"vName")),"时间范围验证错误");

	}


}

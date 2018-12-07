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
		Assert.assertEquals(virusDetailsPage.getValue().getText().equals(expect.getString("thisWeek")),true,"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围上周验证")
	public void lastWeek(){
		virusDetailsPage.timeFrameTool(virusDetailsPage.getLastWeek());
		Assert.assertEquals(TestUtil.getValueList(virusDetailsPage.getValues()).contains(expect.getString("lastWeek")),true,"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围本月验证")
	public void thisMonth(){
		virusDetailsPage.timeFrameTool(virusDetailsPage.getThisMonth());
		Assert.assertEquals(virusDetailsPage.getValue().getText().equals(expect.getString("thisMonth")),true,"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围上月验证")
	public void lastMonth(){
		virusDetailsPage.timeFrameTool(virusDetailsPage.getLastMonth());
		Assert.assertEquals(TestUtil.getValueList(virusDetailsPage.getValues()).contains(expect.getString("lastMonth")),true,"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围指定验证")
	public void special(){

		virusDetailsPage.specialTool();
		Assert.assertEquals(TestUtil.getValueList(virusDetailsPage.getValues()).containsAll(TestUtil.JsonToList((expect.getJSONArray("special")),"vName")),true,"时间范围验证错误");

	}


}

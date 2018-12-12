package esm.cases.audit.firewall.maliciousweb;

import esm.page.audit.firewall.maliciousweb.MaliciousWebPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimeFrameTest extends SeleniumTestCase {

	MaliciousWebPage maliciousWebPage;

	@Test(description = "时间范围本周验证")
	public void thisWeek(){

		maliciousWebPage = new MaliciousWebPage(driver);
		maliciousWebPage.timeFrameTool(maliciousWebPage.getThisWeek());
		Assert.assertEquals(maliciousWebPage.getValue().getText().equals(expect.getString("thisWeek")),true,"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围上周验证")
	public void lastWeek(){
		maliciousWebPage.timeFrameTool(maliciousWebPage.getLastWeek());
		Assert.assertEquals(TestUtil.getValueList(maliciousWebPage.getValues()).contains(expect.getString("lastWeek")),true,"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围本月验证")
	public void thisMonth(){
		maliciousWebPage.timeFrameTool(maliciousWebPage.getThisMonth());
		Assert.assertEquals(TestUtil.getValueList(maliciousWebPage.getValues()).contains(expect.getString("thisMonth")),true,"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围上月验证")
	public void lastMonth(){
		maliciousWebPage.timeFrameTool(maliciousWebPage.getLastMonth());
		Assert.assertEquals(TestUtil.getValueList(maliciousWebPage.getValues()).contains(expect.getString("lastMonth")),true,"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围指定验证")
	public void special(){

		maliciousWebPage.specialTool();
		Assert.assertEquals(TestUtil.getValueList(maliciousWebPage.getValues()).containsAll(TestUtil.JsonToList((expect.getJSONArray("special")),"name")),true,"时间范围验证错误");

	}


}



package esm.cases.audit.antivirus.virusdetails;

import esm.page.audit.antivirus.virusdetails.VirusDetailsPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimeFrameTest extends SeleniumTestCase{

	VirusDetailsPage virusDetailsPage;
	String count;

	@Test(description = "时间范围本周验证")
	public void thisWeek(){

		virusDetailsPage = new VirusDetailsPage(driver);
		methodUtil(virusDetailsPage.getThisWeek());
		Assert.assertEquals(virusDetailsPage.getValue().getText().equals(expect.getString("thisWeek")),true,"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围上周验证")
	public void lastWeek(){
		methodUtil(virusDetailsPage.getLastWeek());
		Assert.assertEquals(virusDetailsPage.getValue().getText().equals(expect.getString("lastWeek")),true,"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围本月验证")
	public void thisMonth(){
		methodUtil(virusDetailsPage.getThisMonth());
		Assert.assertEquals(virusDetailsPage.getValue().getText().equals(expect.getString("thisMonth")),true,"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围上月验证")
	public void lastMonth(){
		methodUtil(virusDetailsPage.getLastMonth());
		Assert.assertEquals(virusDetailsPage.getValueList(virusDetailsPage.getValues()).contains(expect.getString("lastMonth")),true,"时间范围验证错误");
	}

	@Test(dependsOnMethods = "thisWeek",description = "时间范围指定验证")
	public void special(){

		virusDetailsPage.getTimeUnlimited().click();
		virusDetailsPage.getSpecial().click();
		count = virusDetailsPage.getCount().getText();
		virusDetailsPage.getFromDateCalendar().click();
		virusDetailsPage.getPrevMonth().click();

		TestUtil.waitForVisbility(By.className("goToday"));
		virusDetailsPage.getDateItem().click();

		TestUtil.waitForChanges(By.id("assignPage_totalCount"),count);
		TestUtil.seleniumWait();
		Assert.assertEquals(virusDetailsPage.getValueList(virusDetailsPage.getValues()).containsAll(TestUtil.JsonToList((expect.getJSONArray("special")),"vName")),true,"时间范围验证错误");

	}

	public void methodUtil(WebElement element){

		virusDetailsPage.getTimeUnlimited().click();
		count = virusDetailsPage.getCount().getText();
		element.click();
		TestUtil.waitForChanges(By.id("assignPage_totalCount"),count);
		TestUtil.seleniumWait();
	}

}

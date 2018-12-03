package esm.cases.audit.antivirus.virusdetails;

import esm.page.audit.antivirus.virusdetails.VirusDetailsPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StateTest extends SeleniumTestCase {

	VirusDetailsPage virusDetailsPage;

	@Test(description = "未处理验证")
	public void unTreated(){
		virusDetailsPage = new VirusDetailsPage(driver);
		virusDetailsPage.getTimeUnlimited().click();
		virusDetailsPage.stateUtil(virusDetailsPage.getUntreated());
		Assert.assertEquals(TestUtil.waitForVisbility(virusDetailsPage.getValue()).getText().equals(expect.getString("unTreated")),true,"病毒状态验证错误");
	}

	@Test(dependsOnMethods = "unTreated",description = "成功验证")
	public void success(){
		virusDetailsPage.stateUtil(virusDetailsPage.getSuccess());
		Assert.assertEquals(TestUtil.waitForVisbility(virusDetailsPage.getValue()).getText().equals(expect.getString("success")),true,"病毒状态验证错误");
	}

	@Test(dependsOnMethods = "unTreated",description = "处理失败验证")
	public void fail(){
		virusDetailsPage.stateUtil(virusDetailsPage.getFail());
		Assert.assertEquals(TestUtil.waitForVisbility(virusDetailsPage.getValue()).getText().equals(expect.getString("fail")),true,"病毒状态验证错误");
	}

	@Test(dependsOnMethods = "unTreated",description = "备份失败验证")
	public void backups(){
		virusDetailsPage.stateUtil(virusDetailsPage.getBackups());
		Assert.assertEquals(TestUtil.waitForVisbility(virusDetailsPage.getValue()).getText().equals(expect.getString("backups")),true,"病毒状态验证错误");
	}

	@Test(dependsOnMethods = "unTreated",description = "处理中验证")
	public void process(){
		virusDetailsPage.stateUtil(virusDetailsPage.getProcess());
		Assert.assertEquals(TestUtil.waitForVisbility(virusDetailsPage.getValue()).getText().equals(expect.getString("process")),true,"病毒状态验证错误");
	}
}

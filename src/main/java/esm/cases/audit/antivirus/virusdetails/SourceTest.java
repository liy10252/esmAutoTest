package esm.cases.audit.antivirus.virusdetails;

import esm.page.audit.antivirus.virusdetails.VirusDetailsPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SourceTest extends SeleniumTestCase {

	VirusDetailsPage virusDetailsPage;

	@Test(description = "全盘查杀验证")
	public void allScan(){
		virusDetailsPage = new VirusDetailsPage(driver);
		virusDetailsPage.getTimeUnlimited().click();
		virusDetailsPage.sourceUtil(virusDetailsPage.getAllScan());
		Assert.assertEquals(TestUtil.waitForVisbility(virusDetailsPage.getValue()).getText().equals(expect.getString("allScan")),true,"病毒来源验证错误");
	}

	@Test(dependsOnMethods = "allScan",description = "快速查杀验证")
	public void quickScan(){
		virusDetailsPage.sourceUtil(virusDetailsPage.getQuickScan());
		Assert.assertEquals(TestUtil.waitForVisbility(virusDetailsPage.getValue()).getText().equals(expect.getString("quickScan")),true,"病毒来源验证错误");
	}

	@Test(dependsOnMethods = "allScan",description = "自定义查杀验证")
	public void customScan(){
		virusDetailsPage.sourceUtil(virusDetailsPage.getCustomScan());
		Assert.assertEquals(TestUtil.waitForVisbility(virusDetailsPage.getValue()).getText().equals(expect.getString("customScan")),true,"病毒来源验证错误");
	}

	@Test(dependsOnMethods = "allScan",description = "文件监控验证")
	public void fileMon(){
		virusDetailsPage.sourceUtil(virusDetailsPage.getFilemon());
		Assert.assertEquals(TestUtil.waitForVisbility(virusDetailsPage.getValue()).getText().equals(expect.getString("fileMon")),true,"病毒来源验证错误");
	}

	@Test(dependsOnMethods = "allScan",description = "邮件监控验证")
	public void mailMon(){
		virusDetailsPage.sourceUtil(virusDetailsPage.getMailmon());
		Assert.assertEquals(TestUtil.waitForVisbility(virusDetailsPage.getValue()).getText().equals(expect.getString("mailMon")),true,"病毒来源验证错误");
	}
}

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
		virusDetailsPage.singleClickTool(virusDetailsPage.getSourceUnlimited(),virusDetailsPage.getAllScan());
		Assert.assertTrue(TestUtil.waitForVisbility(virusDetailsPage.getValue()).getText().equals(expect.getString("allScan")),"病毒来源验证错误");
	}

	@Test(dependsOnMethods = "allScan",description = "快速查杀验证")
	public void quickScan(){
		virusDetailsPage.singleClickTool(virusDetailsPage.getSourceUnlimited(),virusDetailsPage.getQuickScan());
		Assert.assertTrue(TestUtil.waitForVisbility(virusDetailsPage.getValue()).getText().equals(expect.getString("quickScan")),"病毒来源验证错误");
	}

	@Test(dependsOnMethods = "allScan",description = "自定义查杀验证")
	public void customScan(){
		virusDetailsPage.singleClickTool(virusDetailsPage.getSourceUnlimited(),virusDetailsPage.getCustomScan());
		Assert.assertTrue(TestUtil.waitForVisbility(virusDetailsPage.getValue()).getText().equals(expect.getString("customScan")),"病毒来源验证错误");
	}

	@Test(dependsOnMethods = "allScan",description = "文件监控验证")
	public void fileMon(){
		virusDetailsPage.singleClickTool(virusDetailsPage.getSourceUnlimited(),virusDetailsPage.getFilemon());
		Assert.assertTrue(TestUtil.waitForVisbility(virusDetailsPage.getValue()).getText().equals(expect.getString("fileMon")),"病毒来源验证错误");
	}

	@Test(dependsOnMethods = "allScan",description = "邮件监控验证")
	public void mailMon(){
		virusDetailsPage.singleClickTool(virusDetailsPage.getSourceUnlimited(),virusDetailsPage.getMailmon());
		Assert.assertTrue(TestUtil.waitForVisbility(virusDetailsPage.getValue()).getText().equals(expect.getString("mailMon")),"病毒来源验证错误");
	}
}

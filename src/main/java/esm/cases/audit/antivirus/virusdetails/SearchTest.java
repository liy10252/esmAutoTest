package esm.cases.audit.antivirus.virusdetails;

import esm.page.audit.antivirus.virusdetails.VirusDetailsPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends SeleniumTestCase {

	VirusDetailsPage virusDetailsPage;

	@Test(description = "病毒名称验证")
	public void virusName(){
		virusDetailsPage = new VirusDetailsPage(driver);
		virusDetailsPage.getTimeUnlimited().click();
		virusDetailsPage.searchUtil(virusDetailsPage.getVirusName(),param.getString("virusName"));
		Assert.assertEquals(TestUtil.waitForVisbility(virusDetailsPage.getValue()).getText().equals(expect.getString("virusName")),true,"搜索条验证");
	}

	@Test(dependsOnMethods = "virusName",description = "染毒文件名验证")
	public void filePath(){
		virusDetailsPage.searchUtil(virusDetailsPage.getFilePath(),param.getString("filePath"));
		Assert.assertEquals(TestUtil.waitForVisbility(virusDetailsPage.getValue()).getText().equals(expect.getString("filePath")),true,"搜索条验证");
	}

}

package esm.cases.audit.antivirus.virusdetails;

import esm.page.audit.antivirus.virusdetails.VirusDetailsPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VirusKillTest extends SeleniumTestCase {

	VirusDetailsPage virusDetailsPage;

	@Test(description = "按病毒显示验证")
	public void showVirus(){
		virusDetailsPage = new VirusDetailsPage(driver);
		virusDetailsPage.getTimeUnlimited().click();
		Assert.assertEquals(virusDetailsPage.getValueList(virusDetailsPage.getValues()).containsAll(TestUtil.JsonToList((expect.getJSONArray("virusName")),"name")),true,"病毒查杀验证错误");
	}

	@Test(dependsOnMethods = "showVirus",description = "按客户端显示验证")
	public void showClient(){
		virusDetailsPage.getShowClient().click();
		Assert.assertEquals(virusDetailsPage.getValueList(virusDetailsPage.getClientvalues()).containsAll(TestUtil.JsonToList((expect.getJSONArray("clientName")),"name")),true,"病毒查杀验证错误");
	}
}

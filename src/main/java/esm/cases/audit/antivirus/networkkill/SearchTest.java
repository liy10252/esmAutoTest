package esm.cases.audit.antivirus.networkkill;

import esm.page.audit.antivirus.networkkill.NetWorkKillPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import esm.util.TestngRetry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends SeleniumTestCase {

	NetWorkKillPage netWorkKillPage;

	@Test(description = "全网查杀搜索条验证计算机名",retryAnalyzer = TestngRetry.class)
	public void searchComputer(){

		netWorkKillPage = new NetWorkKillPage(driver);
	}


//	public void methodUtil(String text, WebElement element, By locator){
//
//		netWorkKillPage.getSearchBar().clear();
//		netWorkKillPage.getSearchButton().click();
//		netWorkKillPage.getSearchBar().sendKeys(text);
//		element.click();
//		netWorkKillPage.getSearchButton().click();
//		TestUtil.waitForAttr(By.xpath("//tbody/tr[2]/td[7]"),"title","");
//
//		Assert.assertEquals(netWorkKillPage.getTr().findElement(locator)
//				.getText(),text,"终端搜索条验证"+text+"错误");
//	}
}

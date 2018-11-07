package esm.cases.audit.platform.overview;

import esm.page.audit.platform.overview.OverviewPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import esm.util.TestngRetry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends SeleniumTestCase {

    OverviewPage overviewPage;

    @Test(description = "终端搜索条验证计算机名",retryAnalyzer = TestngRetry.class)
    public void searchComputer(){

        overviewPage = new OverviewPage(driver);

        methodUtil(param.getString("computer"),overviewPage.getComputerName(),By.xpath("./td[1]//span[@class='memoColor']"));
    }

    @Test(dependsOnMethods = "searchComputer",description = "终端搜索条验证ip",retryAnalyzer = TestngRetry.class)
    public void searchIp(){

        methodUtil(param.getString("ip"),overviewPage.getIp(),By.xpath("./td[3]"));

    }

    @Test(dependsOnMethods = "searchComputer",description = "终端搜索条验证mac",retryAnalyzer = TestngRetry.class)
    public void searchMac(){

        methodUtil(param.getString("mac"),overviewPage.getMac(),By.xpath("./td[4]"));
    }

    @Test(dependsOnMethods = "searchComputer",description = "终端搜索条验证version",retryAnalyzer = TestngRetry.class)
    public void searchVersion(){

        methodUtil(param.getString("version"),overviewPage.getVersion(),By.xpath("./td[5]"));
    }


    public void methodUtil(String text, WebElement element,By locator){

        overviewPage.getSearchBar().clear();
        overviewPage.getSearchButton().click();
        overviewPage.getSearchBar().sendKeys(text);
        element.click();
        overviewPage.getSearchButton().click();
        TestUtil.waitForAttr(By.xpath("//tbody/tr[2]/td[7]"),"title","");

        Assert.assertEquals(overviewPage.getTr().findElement(locator)
                .getText(),text,"终端搜索条验证"+text+"错误");
    }
}

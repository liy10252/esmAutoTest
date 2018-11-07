package esm.cases.audit.platform.unknown;

import esm.page.audit.platform.unknown.UnknownPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import esm.util.TestngRetry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends SeleniumTestCase {

    UnknownPage unknownPage;
    String count;

    @Test(description = "未知终端搜索条验证",retryAnalyzer = TestngRetry.class)
    public void searchComputer(){

        unknownPage = new UnknownPage(driver);
        methodUtil(param.getString("computer"),unknownPage.getComputerName(),By.xpath("./td[1]//span[@class='memoColor']"));

    }

    @Test(dependsOnMethods = "searchComputer",description = "未知终端搜索条验证ip",retryAnalyzer = TestngRetry.class)
    public void searchIp(){

        methodUtil(param.getString("ip"),unknownPage.getIp(),By.xpath("./td[2]/div"));

    }

    @Test(dependsOnMethods = "searchComputer",description = "未知终端搜索条验证mac",retryAnalyzer = TestngRetry.class)
    public void searchMac(){

        methodUtil(param.getString("mac"),unknownPage.getMac(),By.xpath("./td[3]/div"));
    }


    public void methodUtil(String text, WebElement element,By locator){

        unknownPage.getSearchBar().clear();
        unknownPage.getSearchButton().click();
        count = unknownPage.getCount().getText();

        unknownPage.getSearchBar().sendKeys(text);
        element.click();
        unknownPage.getSearchButton().click();

        TestUtil.waitForChanges(By.id("assignPage_totalCount"),count);

        Assert.assertEquals(unknownPage.getTr().findElement(locator)
                .getText(),text,"未知终端搜索条验证"+text+"错误");
    }
}

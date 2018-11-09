package esm.cases.audit.platform.unknown;

import esm.page.audit.platform.unknown.UnknownPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import esm.util.TestngRetry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimeRetrievalTest extends SeleniumTestCase {

    UnknownPage unknownPage;
    String count;

    @Test(description = "未知终端时间检索验证本周",retryAnalyzer = TestngRetry.class)
    public void thisWeek(){

        unknownPage = new UnknownPage(driver);

        methodUtil(unknownPage.getThisWeek(),expect.getString("thisWeek"));

    }

    @Test(dependsOnMethods = "thisWeek",description = "未知终端时间检索验证上周",retryAnalyzer = TestngRetry.class)
    public void lastWeek(){

        methodUtil(unknownPage.getLastWeek(),expect.getString("lastWeek"));

    }

    @Test(dependsOnMethods = "thisWeek",description = "未知终端时间检索验证本月",retryAnalyzer = TestngRetry.class)
    public void thisMonth(){

        methodUtil(unknownPage.getThisMonth(),expect.getString("thisMonth"));
    }

    @Test(dependsOnMethods = "thisWeek",description = "未知终端时间检索验证上月",retryAnalyzer = TestngRetry.class)
    public void lastMonth(){

        unknownPage.getNoLimit().click();
        count = unknownPage.getCount().getText();
        unknownPage.getLastMonth().click();
        TestUtil.waitForAttrContains(By.xpath("//tbody/tr[3]/td[1]"),"style","height");
        String value = unknownPage.getTr().findElement(By.xpath("./td[1]//span[@class='memoColor']"))
                .getText();

        Assert.assertEquals(value.equals(expect.getString("lastMonth1")) || value.equals(expect.getString("lastMonth2")),
                true,"未知终端时间检索验证错误");
    }

    @Test(dependsOnMethods = "thisWeek",description = "未知终端时间检索验证指定日期",retryAnalyzer = TestngRetry.class)
    public void special(){

        unknownPage.getNoLimit().click();
        count = unknownPage.getCount().getText();
        unknownPage.getSpecial().click();
        unknownPage.getFromDateCalendar().click();
        unknownPage.getPrevMonth().click();

        TestUtil.waitForVisbility(By.className("goToday"));
        unknownPage.getDateItem().click();

        TestUtil.waitForChanges(By.id("assignPage_totalCount"),count);

        Assert.assertEquals(unknownPage.getTr().findElement(By.xpath("./td[1]//span[@class='memoColor']"))
                .getText(),expect.getString("special1"),"未知终端时间检索验证错误");
        Assert.assertEquals(unknownPage.getTr().findElement(By.xpath("./following-sibling::tr[1]/td[1]//span[@class='memoColor']"))
                .getText(),expect.getString("special2"),"未知终端时间检索验证错误");

    }

    public void methodUtil(WebElement element,String text){

        unknownPage.getNoLimit().click();
        count = unknownPage.getCount().getText();
        element.click();
        TestUtil.waitForChanges(By.id("assignPage_totalCount"),count);

        Assert.assertEquals(unknownPage.getTr().findElement(By.xpath("./td[1]//span[@class='memoColor']"))
                .getText(),text,"未知终端时间检索验证错误");
    }


}

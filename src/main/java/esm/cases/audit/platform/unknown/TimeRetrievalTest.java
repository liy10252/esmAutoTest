package esm.cases.audit.platform.unknown;

import esm.page.audit.platform.unknown.UnknownPage;
import esm.util.SeleniumTestCase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimeRetrievalTest extends SeleniumTestCase {

    UnknownPage unknownPage;

    @Test(description = "未知终端时间检索验证本周")
    public void thisWeek(){

        unknownPage = new UnknownPage(driver);
        unknownPage.timeFrameTool(unknownPage.getThisWeek());
        Assert.assertEquals(unknownPage.getTr().findElement(By.xpath("./td[1]//span[@class='memoColor']"))
                .getText(),expect.getString("thisWeek"),"未知终端时间检索验证错误");

    }

    @Test(dependsOnMethods = "thisWeek",description = "未知终端时间检索验证上周")
    public void lastWeek(){

        unknownPage.timeFrameTool(unknownPage.getLastWeek());
        Assert.assertEquals(unknownPage.getTr().findElement(By.xpath("./td[1]//span[@class='memoColor']"))
                .getText(),expect.getString("lastWeek"),"未知终端时间检索验证错误");

    }

    @Test(dependsOnMethods = "thisWeek",description = "未知终端时间检索验证本月")
    public void thisMonth(){

        unknownPage.timeFrameTool(unknownPage.getThisMonth());
        Assert.assertEquals(unknownPage.getTr().findElement(By.xpath("./td[1]//span[@class='memoColor']"))
                .getText(),expect.getString("thisMonth"),"未知终端时间检索验证错误");
    }

    @Test(dependsOnMethods = "thisWeek",description = "未知终端时间检索验证上月")
    public void lastMonth(){

        unknownPage.timeFrameTool(unknownPage.getLastMonth());

        Assert.assertEquals(unknownPage.getTr().findElement(By.xpath("./td[1]//span[@class='memoColor']"))
                        .getText().equals(expect.getString("lastMonth1")) || unknownPage.getTr().findElement(By.xpath("./td[1]//span[@class='memoColor']"))
                        .getText().equals(expect.getString("lastMonth2")),
                true,"未知终端时间检索验证错误");
    }

    @Test(dependsOnMethods = "thisWeek",description = "未知终端时间检索验证指定日期")
    public void special(){

        unknownPage.specialTool();

        Assert.assertEquals(unknownPage.getTr().findElement(By.xpath("./td[1]//span[@class='memoColor']"))
                .getText(),expect.getString("special1"),"未知终端时间检索验证错误");
        Assert.assertEquals(unknownPage.getTr().findElement(By.xpath("./following-sibling::tr[1]/td[1]//span[@class='memoColor']"))
                .getText(),expect.getString("special2"),"未知终端时间检索验证错误");

    }

}

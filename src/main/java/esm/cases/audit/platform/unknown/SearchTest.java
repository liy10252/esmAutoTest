package esm.cases.audit.platform.unknown;

import esm.page.audit.platform.unknown.UnknownPage;
import esm.util.SeleniumTestCase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends SeleniumTestCase {

    UnknownPage unknownPage;
    String text;

    @Test(description = "未知终端搜索条验证")
    public void searchComputer(){

        unknownPage = new UnknownPage(driver);
        text = param.getString("computer");
        unknownPage.searchUtil(unknownPage.getSearchBar(),
                unknownPage.getSearchButton(),unknownPage.getComputerName(),text);
        Assert.assertEquals(unknownPage.getTr().findElement(By.xpath("./td[1]//span[@class='memoColor']"))
                .getText(),text,"未知终端搜索条验证"+text+"错误");

    }

    @Test(dependsOnMethods = "searchComputer",description = "未知终端搜索条验证ip")
    public void searchIp(){

        text = param.getString("ip");
        unknownPage.searchUtil(unknownPage.getSearchBar(),
                unknownPage.getSearchButton(),unknownPage.getIp(),text);
        Assert.assertEquals(unknownPage.getTr().findElement(By.xpath("./td[2]/div"))
                .getText(),text,"未知终端搜索条验证"+text+"错误");

    }

    @Test(dependsOnMethods = "searchComputer",description = "未知终端搜索条验证mac")
    public void searchMac(){

        text = param.getString("mac");
        unknownPage.searchUtil(unknownPage.getSearchBar(),
                unknownPage.getSearchButton(),unknownPage.getMac(),text);
        Assert.assertEquals(unknownPage.getTr().findElement(By.xpath("./td[3]/div"))
                .getText(),text,"未知终端搜索条验证"+text+"错误");
    }

}

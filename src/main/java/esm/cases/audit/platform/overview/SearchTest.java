package esm.cases.audit.platform.overview;

import esm.page.audit.platform.overview.OverviewPage;
import esm.util.SeleniumTestCase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends SeleniumTestCase {

    OverviewPage overviewPage;

    @Test(description = "终端搜索条验证计算机名")
    public void searchComputer(){

        overviewPage = new OverviewPage(driver);
        String text = param.getString("computer");
        overviewPage.searchUtil(overviewPage.getComputerName(),text);
        Assert.assertEquals(overviewPage.getTr().findElement(By.xpath("./td[1]//span[@class='memoColor']"))
                .getText(),text,"终端搜索条验证"+text+"错误");

    }

    @Test(dependsOnMethods = "searchComputer",description = "终端搜索条验证ip")
    public void searchIp(){

        String text = param.getString("ip");
        overviewPage.searchUtil(overviewPage.getIp(),text);
        Assert.assertEquals(overviewPage.getTr().findElement(By.xpath("./td[3]"))
                .getText(),text,"终端搜索条验证"+text+"错误");

    }

    @Test(dependsOnMethods = "searchComputer",description = "终端搜索条验证mac")
    public void searchMac(){

        String text = param.getString("mac");
        overviewPage.searchUtil(overviewPage.getMac(),text);
        Assert.assertEquals(overviewPage.getTr().findElement(By.xpath("./td[4]"))
                .getText(),text,"终端搜索条验证"+text+"错误");

    }

    @Test(dependsOnMethods = "searchComputer",description = "终端搜索条验证version")
    public void searchVersion(){

        String text = param.getString("version");
        overviewPage.searchUtil(overviewPage.getVersion(),text);
        Assert.assertEquals(overviewPage.getTr().findElement(By.xpath("./td[5]"))
                .getText(),text,"终端搜索条验证"+text+"错误");

    }

}

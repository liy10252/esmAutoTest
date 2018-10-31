package esm.cases.audit.platform.unknown;

import esm.page.audit.platform.unknown.UnknownPage;
import esm.util.Assertion;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SearchTest extends SeleniumTestCase {

    UnknownPage unknownPage;

    @Test(description = "未知终端搜索条验证")
    public void searchComputer(){

        unknownPage = new UnknownPage(driver);
        methodUtil("WIN-2AL1RFMO551",unknownPage.getComputerName(),By.xpath("./td[1]//span[@class='memoColor']"));

    }

    @Test(dependsOnMethods = "searchComputer",description = "未知终端搜索条验证ip")
    public void searchIp(){

        methodUtil("192.168.2.9",unknownPage.getIp(),By.xpath("./td[2]/div"));

    }

    @Test(dependsOnMethods = "searchComputer",description = "未知终端搜索条验证mac")
    public void searchMac(){

        methodUtil("01-0B-30-C8-A0-20",unknownPage.getMac(),By.xpath("./td[3]/div"));
    }


    public void methodUtil(String text, WebElement element,By locator){

        unknownPage.getSearchBar().clear();
        unknownPage.getSearchButton().click();
        unknownPage.getSearchBar().sendKeys(text);
        element.click();
        unknownPage.getSearchButton().click();
        TestUtil.waitFortextToElement(By.id("assignPage_totalCount"),"1");
        Assertion.verifyEquals(unknownPage.getTr().findElement(locator)
                .getText(),text,"未知终端搜索条验证"+text+"错误");
    }
}

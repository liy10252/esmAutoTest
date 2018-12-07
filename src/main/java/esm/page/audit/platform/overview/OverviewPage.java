package esm.page.audit.platform.overview;

import esm.page.BasePage;
import esm.util.TestUtil;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

@Data
public class OverviewPage extends BasePage {

    @FindBy(id = "groupPath")
    private WebElement groupPath;

    @FindBy(xpath = "//a[@title='根管理组']/preceding-sibling::span[1]")
    private WebElement groupPathSpan;

    @FindBy(tagName = "tbody")
    private WebElement tbody;

    @FindBy(xpath = "//tbody/tr[1]")
    private WebElement tr;

    @FindBy(xpath = "//dd[@id='status']//a[text()='不限']")
    private WebElement unlimitedStatus;

    @FindBy(xpath = "//dd[@id='status']//a[text()='已登录']")
    private WebElement alreadyLoginStatus;

    @FindBy(xpath = "//dd[@id='status']//a[text()='未登录']")
    private WebElement notLoginStatus;

    @FindBy(xpath = "//dd[@id='reboot']//a[text()='不限']")
    private WebElement unlimitedReboot;

    @FindBy(xpath = "//dd[@id='reboot']//a[text()='否']")
    private WebElement  noReboot;

    @FindBy(xpath = "//dd[@id='reboot']//a[text()='是']")
    private WebElement yesReboot;

    @FindBy(xpath = "//dd[@id='searchBox']//input")
    private WebElement searchBar;

    @FindBy(xpath = "//dd[@id='searchBox']//span[@val='ComputerName']")
    private WebElement computerName;

    @FindBy(xpath = "//dd[@id='searchBox']//span[@val='IP']")
    private WebElement ip;

    @FindBy(xpath = "//dd[@id='searchBox']//span[@val='MAC']")
    private WebElement mac;

    @FindBy(xpath = "//dd[@id='searchBox']//span[@val='Version']")
    private WebElement version;

    @FindBy(xpath = "//dd[@id='searchBox']//a")
    private WebElement searchButton;

    String webCount;

    public OverviewPage(EventFiringWebDriver driver) {
        super(driver);
    }

    public void searchUtil(WebElement element,String text){

        searchBar.clear();
        searchButton.click();
        webCount = count.getText();
        searchBar.sendKeys(text);
        element.click();
        searchButton.click();
        TestUtil.waitForAttr(By.xpath("//tbody/tr[2]/td[7]"),"title","");
    }
}

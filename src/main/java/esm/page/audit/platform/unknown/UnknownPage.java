package esm.page.audit.platform.unknown;

import esm.page.BasePage;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

@Data
public class UnknownPage extends BasePage {

    @FindBy(xpath = "//dd[@id='dateBox']//a[@val='noLimit']")
    private WebElement noLimit;

    @FindBy(xpath = "//dd[@id='dateBox']//a[@val='thisWeek']")
    private WebElement thisWeek;

    @FindBy(xpath = "//dd[@id='dateBox']//a[@val='lastWeek']")
    private WebElement lastWeek;

    @FindBy(xpath = "//dd[@id='dateBox']//a[@val='thisMonth']")
    private WebElement thisMonth;

    @FindBy(xpath = "//dd[@id='dateBox']//a[@val='lastMonth']")
    private WebElement lastMonth;

    @FindBy(xpath = "//dd[@id='dateBox']//a[@val='special']")
    private WebElement special;

    @FindBy(xpath = "//div[@id='tableBox1']//tbody/tr[1]")
    private WebElement tr;

    @FindBy(xpath = "//dd[@id='dateBox']/div/span[1]/a")
    private WebElement fromDateCalendar;

    @FindBy(xpath = "//div[@id='MCalendar']/div[1]/a[@title='上个月']")
    private WebElement prevMonth;

    @FindBy(xpath = "//div[@id='MCalendar']/div[@class='calendarBody']//span[text()='20']")
    private WebElement dateItem;

    @FindBy(xpath = "//dd[@id='searchBox']//input")
    private WebElement searchBar;

    @FindBy(xpath = "//dd[@id='searchBox']//a")
    private WebElement searchButton;

    @FindBy(xpath = "//dd[@id='searchBox']//span[@val='ComputerName']")
    private WebElement computerName;

    @FindBy(xpath = "//dd[@id='searchBox']//span[@val='IP']")
    private WebElement ip;

    @FindBy(xpath = "//dd[@id='searchBox']//span[@val='MAC']")
    private WebElement mac;

    @FindBy(id = "assignPage_totalCount")
    private WebElement count;

    public UnknownPage(EventFiringWebDriver driver) {
        super(driver);
    }

}

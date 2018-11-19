package esm.page.audit.antivirus.networkkill;

import esm.page.BasePage;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import javax.xml.xpath.XPath;

@Data
public class NetWorkKillPage extends BasePage {

	@FindBy(xpath = "//dd[@id='searchFileMon']//a[text()='不限']")
	private WebElement fileUnlimited;

	@FindBy(xpath = "//dd[@id='searchFileMon']//a[text()='已开启']")
	private WebElement fileOpen;

	@FindBy(xpath = "//dd[@id='searchFileMon']//a[text()='关闭']")
	private WebElement fileClose;

	@FindBy(id = "assignPage_totalCount")
	private WebElement count;

	@FindBy(xpath = "//div[@id='tableBox1']//tbody/tr[1]/td[4]/span")
	private WebElement fileStatus;

	@FindBy(xpath = "//dd[@id='searchMailMon']//a[text()='不限']")
	private WebElement mailUnlimited;

	@FindBy(xpath = "//dd[@id='searchMailMon']//a[text()='已开启']")
	private WebElement mailOpen;

	@FindBy(xpath = "//dd[@id='searchMailMon']//a[text()='关闭']")
	private WebElement mailClose;

	@FindBy(xpath = "//div[@id='tableBox1']//tbody/tr[1]/td[5]/span")
	private WebElement mailStatus;

	@FindBy(xpath = "//dd[@id='searchBox']//input")
	private WebElement searchBar;

	@FindBy(xpath = "//dd[@id='searchBox']//a")
	private WebElement searchButton;

	@FindBy(xpath = "//dd[@id='searchBox']//span[@val='ComputerName']")
	private WebElement computerName;

	@FindBy(xpath = "//dd[@id='searchBox']//span[@val='IP']")
	private WebElement ip;

	@FindBy(xpath = "//dd[@id='searchBox']//span[@val='VlibVer']")
	private WebElement vlibVer;

	@FindBy(xpath = "//div[@id='tableBox1']//tbody/tr[1]")
	private WebElement tr;

	@FindBy(xpath = "//dd[@id='searchScanTime']//a[text()='不限']")
	private WebElement scanUnlimited;

	@FindBy(xpath = "//dd[@id='searchScanTime']//a[text()='超过1周']")
	private WebElement lastWeek;

	@FindBy(xpath = "//dd[@id='searchScanTime']//a[text()='超过1个月']")
	private WebElement lastMonth;

	@FindBy(xpath = "//dd[@id='searchScanTime']//a[text()='从未扫描']")
	private WebElement noScan;

	@FindBy(xpath = "//dd[@id='searchScanTime']//a[text()='扫描中']")
	private WebElement scanning;

	@FindBy(xpath = "//div[@id='tableBox1']//tbody/tr[1]/td[2]//span[2]")
	private WebElement scanStatus;

	@FindBy(xpath = "//dd[@id='searchOnline']//a[text()='不限']")
	private WebElement onlineUnlimited;

	@FindBy(xpath = "//dd[@id='searchOnline']//a[text()='已登录']")
	private WebElement onLine;

	@FindBy(xpath = "//dd[@id='searchOnline']//a[text()='未登录']")
	private WebElement offLine;

	@FindBy(xpath = "//div[@id='tableBox1']//tbody/tr[1]/td[2]//img")
	private WebElement onLineStatus;

	public NetWorkKillPage(EventFiringWebDriver driver) {
		super(driver);
	}
}

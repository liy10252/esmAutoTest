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


	public NetWorkKillPage(EventFiringWebDriver driver) {
		super(driver);
	}
}

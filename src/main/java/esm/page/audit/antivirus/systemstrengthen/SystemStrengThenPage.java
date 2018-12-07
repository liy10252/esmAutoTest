package esm.page.audit.antivirus.systemstrengthen;

import esm.page.BasePage;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.util.List;

@Data
public class SystemStrengThenPage extends BasePage {

	@FindBy(xpath = "//dd[@id='defType']//a[text()='不限']")
	private WebElement defUnlimited;

	@FindBy(xpath = "//dd[@id='defType']//a[text()='文件防护']")
	private WebElement file;

	@FindBy(xpath = "//dd[@id='defType']//a[text()='注册表防护']")
	private WebElement registry;

	@FindBy(xpath = "//dd[@id='defType']//a[text()='进程防护']")
	private WebElement process;

	@FindBy(xpath = "//dd[@id='defType']//a[text()='系统防护']")
	private WebElement system;

	@FindBy(xpath = "//dd[@id='status']//a[text()='不限']")
	private WebElement onlineUnlimited;

	@FindBy(xpath = "//dd[@id='status']//a[text()='已登录']")
	private WebElement online;

	@FindBy(xpath = "//dd[@id='status']//a[text()='未登录']")
	private WebElement offline;

	@FindBy(xpath = "//div[@controlname='search']//input")
	private WebElement searchBar;

	@FindBy(xpath = "//div[@controlname='search']//a")
	private WebElement searchButton;

	@FindBy(xpath = "//div[@controlname='search']//span[@val='ComputerName']")
	private WebElement computerName;

	@FindBy(xpath = "//div[@controlname='search']//span[@val='IP']")
	private WebElement ip;

	@FindBy(xpath = "//div[@id='tabBox']//dd[text()='按风险显示']")
	private WebElement showRisk;

	@FindBy(xpath = "//div[@id='tableBox2']//tbody/tr[1]/td[1]")
	private WebElement value;

	@FindBy(xpath = "//div[@class='overflowBox']")
	private List<WebElement> clientValues;

	@FindBy(xpath = "//div[@id='tableBox1']//tr/td[not(1 and @*)]")
	private List<WebElement> riskValues;

	@FindBy(xpath = "//div[@id='tableBox1']//tbody/tr[1]/td[2]/a")
	private WebElement riskNumber;

	@FindBy(xpath = "//table[@id='dialogTableContent1']//tr[1]")
	private WebElement riskTr;

	@FindBy(xpath = "//div[@class='iDialogBody']//a[@class='OpSource']")
	private WebElement source;

	@FindBy(xpath = "//div[@class='iDialogBody']//a[@class='OpObj']")
	private WebElement target;

	@FindBy(xpath = "//div[@class='iDialogBody']//a[@class='Action']")
	private WebElement action;

	@FindBy(xpath = "//div[@class='iDialogHead']/following-sibling::a")
	private WebElement riskClose;

	@FindBy(xpath = "//div[@id='tableBox1']//tbody/tr[1]/td[3]/a")
	private WebElement clientNumber;

	@FindBy(xpath = "//table[@id='dialogTableContent2']//tr[1]/td[1]/a")
	private WebElement clientName;

	@FindBy(xpath = "//table[@id='dialogTableContent2']//tr[1]/td[2]")
	private WebElement ipStr;

	public SystemStrengThenPage(EventFiringWebDriver driver){
		super(driver);
	}
}

package esm.page.audit.antivirus.systemstrengthen;

import esm.page.BasePage;
import esm.util.TestUtil;
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

	String webCount;

	public SystemStrengThenPage(EventFiringWebDriver driver){
		super(driver);
	}

	public void searchUtil(WebElement element,String text){

		searchBar.clear();
		searchButton.click();
		webCount = count.getText();
		searchBar.sendKeys(text);
		element.click();
		searchButton.click();
		TestUtil.waitForChanges(count,webCount);
	}
}

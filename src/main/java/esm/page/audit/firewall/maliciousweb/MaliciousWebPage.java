package esm.page.audit.firewall.maliciousweb;

import esm.page.BasePage;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;

@Data
public class MaliciousWebPage extends BasePage {

	@FindBy(xpath = "//dd[@id='labelBox']//a[text()='全部']")
	private WebElement all;

	@FindBy(xpath = "//dd[@id='labelBox']//a[text()='木马网址']")
	private WebElement trojan;

	@FindBy(xpath = "//dd[@id='labelBox']//a[text()='钓鱼网址']")
	private WebElement phishingWeb;

	@FindBy(xpath = "//dd[@id='labelBox']//a[text()='恶意下载']")
	private WebElement downLoad;

	@FindBy(xpath = "//dd[@id='labelBox']//a[text()='跨站攻击']")
	private WebElement attack;

	@FindBy(xpath = "//dd[@id='labelBox']//a[text()='搜索引擎']")
	private WebElement engine;

	@FindBy(xpath = "//dd[@id='searchBox']//input")
	private WebElement searchBar;

	@FindBy(xpath = "//dd[@id='searchBox']//a")
	private WebElement searchButton;

	@FindBy(xpath = "//dd[@id='searchBox']//span[@val='Url']")
	private WebElement webSite;

	@FindBy(xpath = "//dd[@id='searchBox']//span[@val='webSite']")
	private WebElement domain;

	@FindBy(xpath = "//div[@id='tableBox1']//tbody/tr[1]/td[1]")
	private WebElement value;

	@FindBy(xpath = "//div[@id='tableBox1']//tr/td[not(1 and @*)]")
	private List<WebElement> values;

	public MaliciousWebPage(EventFiringWebDriver driver){
		super(driver);
	}

}

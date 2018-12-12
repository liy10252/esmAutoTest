package esm.page.audit.firewall.hackerattack;

import esm.page.BasePage;
import esm.util.TestUtil;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.util.List;

@Data
public class HackerAttackPage extends BasePage {

	@FindBy(xpath = "//dd[@id='status']//a[text()='不限']")
	private WebElement onlineUnlimited;

	@FindBy(xpath = "//dd[@id='status']//a[text()='已登录']")
	private WebElement online;

	@FindBy(xpath = "//dd[@id='status']//a[text()='未登录']")
	private WebElement offline;

	@FindBy(xpath = "//dd[@id='searchBox']//input")
	private WebElement searchBar;

	@FindBy(xpath = "//dd[@id='searchBox']//a")
	private WebElement searchButton;

	@FindBy(xpath = "//dd[@id='searchBox']//span[@val='ComputerName']")
	private WebElement computerName;

	@FindBy(xpath = "//dd[@id='searchBox']//span[@val='IP']")
	private WebElement ip;

	@FindBy(xpath = "//div[@id='tableBox1']//tbody/tr[1]/td[1]")
	private WebElement value;

	@FindBy(xpath = "//div[@id='tableBox1']//tr/td[not(1 and @*)]")
	private List<WebElement> values;

	String webCount;

	public HackerAttackPage(EventFiringWebDriver driver){
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

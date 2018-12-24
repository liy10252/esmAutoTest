package esm.page.audit.firewall.forbidurl;

import esm.page.BasePage;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.util.List;

@Data
public class ForbidUrlPage extends BasePage {

	@FindBy(xpath = "//dd[@id='searchBox1']//input")
	private WebElement searchBar;

	@FindBy(xpath = "//dd[@id='searchBox1']//a")
	private WebElement searchButton;

	@FindBy(xpath = "//dd[@id='searchBox1']//span[@val='Url']")
	private WebElement webSite;

	@FindBy(xpath = "//div[@id='tabBox']//dd")
	private WebElement showClient;

	@FindBy(xpath = "//div[@id='tableBox1']//tbody//tbody//tr[1]/td[1]")
	private WebElement value;

	@FindBy(xpath = "//div[@id='tableBox1']/table/tbody/tr[1]/td[1]//a")
	private WebElement detail;

	@FindBy(xpath = "//table[@id='dialogTableContent3']//tr[1]")
	private WebElement detailValue;

	@FindBy(xpath = "//a[@class='iDialogClose']")
	private WebElement exit;

	@FindBy(xpath = "//div[@id='tableBox1']/table/tbody/tr[1]/td[2]//a")
	private WebElement aClient;

	@FindBy(xpath = "//table[@id='dialogTableContent']//tr[1]")
	private WebElement aClientValue;

	@FindBy(xpath = "//div[@id='tableBox1']/table/tbody/tr[1]/td[3]/a")
	private WebElement ignore;

	@FindBy(xpath = "//div[@class='iDialogMain']/../following-sibling::div/button[1]")
	private WebElement ignoreConfirm;

	@FindBy(xpath = "//div[@id='tableBox2']/table/tbody/tr[1]/td[3]/a")
	private WebElement webSiteButton;

	@FindBy(xpath = "//table[@id='dialogTableContent2']/tbody/tr[1]/td[2]/div")
	private WebElement webSiteValue;

	@FindBy(xpath = "//a[text()='详细']/../preceding-sibling::td")
	private List<WebElement> values;

	@FindBy(xpath = "//div[@id='tableBox2']//tr/td[1]//a")
	private List<WebElement> clients;

	public ForbidUrlPage(EventFiringWebDriver driver){
		super(driver);
	}
}

package esm.page.audit.antivirus.virusdetails;

import esm.page.BasePage;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.util.List;

@Data
public class VirusDetailsPage extends BasePage{

	@FindBy(xpath = "//dd[@id='searchSource']//a[@val='all']")
	private WebElement sourceUnlimited;

	@FindBy(xpath = "//dd[@id='searchSource']//a[@val='allscan']")
	private WebElement allScan;

	@FindBy(xpath = "//dd[@id='searchSource']//a[@val='quickscan']")
	private WebElement quickScan;

	@FindBy(xpath = "//dd[@id='searchSource']//a[@val='customscan']")
	private WebElement customScan;

	@FindBy(xpath = "//dd[@id='searchSource']//a[@val='filemon']")
	private WebElement filemon;

	@FindBy(xpath = "//dd[@id='searchSource']//a[@val='mailmon']")
	private WebElement mailmon;

	@FindBy(xpath = "//dd[@id='searchStatus']//a[text()='不限']")
	private WebElement stateUnlimited;

	@FindBy(xpath = "//dd[@id='searchStatus']//a[text()='未处理']")
	private WebElement untreated;

	@FindBy(xpath = "//dd[@id='searchStatus']//a[text()='成功']")
	private WebElement success;

	@FindBy(xpath = "//dd[@id='searchStatus']//a[text()='处理失败']")
	private WebElement fail;

	@FindBy(xpath = "//dd[@id='searchStatus']//a[text()='备份失败']")
	private WebElement backups;

	@FindBy(xpath = "//dd[@id='searchStatus']//a[text()='处理中']")
	private WebElement process;

	@FindBy(xpath = "//dd[@id='searchBox1']//input")
	private WebElement searchBar;

	@FindBy(xpath = "//dd[@id='searchBox1']//a")
	private WebElement searchButton;

	@FindBy(xpath = "//dd[@id='searchBox1']//span[@val='virusName']")
	private WebElement virusName;

	@FindBy(xpath = "//dd[@id='searchBox1']//span[@val='filepath']")
	private WebElement filePath;

	@FindBy(xpath = "//div[@id='tabBox']//dd")
	private WebElement showClient;

	@FindBy(xpath = "//div[@id='tableBox1']//tr[1]/td[1]")
	private WebElement value;

	@FindBy(xpath = "//div[@id='tableBox1']//td[1 and not(@*)]/div")
	private List<WebElement> values;

	@FindBy(xpath = "//div[@id='tableBox2']//td[1]//a//span[@class]")
	private List<WebElement> clientvalues;


	public VirusDetailsPage(EventFiringWebDriver driver) {
		super(driver);
	}

}

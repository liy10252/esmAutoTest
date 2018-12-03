package esm.page.audit.antivirus.virusdetails;

import esm.page.BasePage;
import esm.util.TestUtil;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.util.ArrayList;
import java.util.List;

@Data
public class VirusDetailsPage extends BasePage{

	@FindBy(xpath = "//dd[@id='dateBox']//a[@val='noLimit']")
	private WebElement timeUnlimited;

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

	@FindBy(xpath = "//dd[@id='dateBox']/div/span[1]/a")
	private WebElement fromDateCalendar;

	@FindBy(xpath = "//div[@id='MCalendar']/div[1]/a[@title='上个月']")
	private WebElement prevMonth;

	@FindBy(xpath = "//div[@id='MCalendar']/div[@class='calendarBody']//span[text()='20']")
	private WebElement dateItem;

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

	@FindBy(id = "assignPage_totalCount")
	private WebElement count;

	private String webCount;

	public VirusDetailsPage(EventFiringWebDriver driver) {
		super(driver);
	}


	public List<String> getValueList(List<WebElement> values){

		List<String> list = new ArrayList<String>();

		for(WebElement element : values){
			list.add(element.getText());
		}
		return list;
	}

	public void sourceUtil(WebElement element){

		sourceUnlimited.click();
		singleUtil(element);
	}

	public void stateUtil(WebElement element){

		stateUnlimited.click();
		singleUtil(element);

	}

	public void singleUtil(WebElement element){

		webCount = count.getText();
		element.click();
		TestUtil.waitForChanges(count,webCount);

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

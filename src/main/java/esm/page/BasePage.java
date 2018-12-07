package esm.page;

import esm.util.TestUtil;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

@Data
public class BasePage {

	@FindBy(xpath = "//dd[@id='dateBox']//a[@val='noLimit']")
	public WebElement timeUnlimited;

	@FindBy(xpath = "//dd[@id='dateBox']//a[@val='thisWeek']")
	public WebElement thisWeek;

	@FindBy(xpath = "//dd[@id='dateBox']//a[@val='lastWeek']")
	public WebElement lastWeek;

	@FindBy(xpath = "//dd[@id='dateBox']//a[@val='thisMonth']")
	public WebElement thisMonth;

	@FindBy(xpath = "//dd[@id='dateBox']//a[@val='lastMonth']")
	public WebElement lastMonth;

	@FindBy(xpath = "//dd[@id='dateBox']//a[@val='special']")
	public WebElement special;

	@FindBy(xpath = "//dd[@id='dateBox']/div/span[1]/a")
	public WebElement fromDateCalendar;

	@FindBy(xpath = "//div[@id='MCalendar']/div[1]/a[@title='上个月']")
	public WebElement prevMonth;

	@FindBy(xpath = "//div[@id='MCalendar']/div[@class='calendarBody']//span[text()='20']")
	public WebElement dateItem;

	@FindBy(id = "assignPage_totalCount")
	public WebElement count;

	public String counts;

	EventFiringWebDriver driver;
	private final int TIMEOUT = 10;

	public BasePage(EventFiringWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
//		PageFactory.initElements(driver,this);
	}

	//时间范围验证通用工具方法
	public void timeFrameTool(WebElement element){

		timeUnlimited.click();
		counts = count.getText();
		element.click();
		TestUtil.waitForChanges(count,counts);
		TestUtil.seleniumWait();
	}

	//时间范围指定时间工具
	public void specialTool(){

		timeUnlimited.click();
		special.click();
		counts = count.getText();
		fromDateCalendar.click();
		prevMonth.click();

		TestUtil.waitForVisbility(By.className("goToday"));
		dateItem.click();

		TestUtil.waitForChanges(count,counts);
		TestUtil.seleniumWait();

	}


	//单选功能第一个参数是不限，第二个是要操作的对象
	public void singleClickTool(WebElement unlimited,WebElement element){

		unlimited.click();
		counts = count.getText();
		element.click();
		TestUtil.waitForChanges(count,counts);
	}

}

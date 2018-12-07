package esm.page.audit.antivirus;

import esm.page.BasePage;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

@Log4j
public class AntivirusPage extends BasePage {

	@FindBy(id = "__xavState")
	private WebElement networkkill;

	@FindBy(id = "__virusStat")
	private WebElement virusDetails;

	@FindBy(id = "__systemStrengthened")
	private WebElement systemStrengthen;

	public AntivirusPage(EventFiringWebDriver driver) {
		super(driver);
	}

	//进入病毒详情模块
	public void gotovirusDetails(){
		virusDetails.click();
		log.info("进入病毒详情模块------");
	}

	//进入系统加固模块
	public void gotoSystemStrengthen(){
		systemStrengthen.click();
		log.info("进入系统加固模块------");
	}

}

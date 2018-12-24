package esm.page.audit.firewall;

import esm.page.BasePage;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

@Log4j
public class FireWallPage extends BasePage {

	@FindBy(id = "__flowWeb")
	private WebElement maliciousWeb;

	@FindBy(id = "__flowHack")
	private WebElement hackerAttack;

	@FindBy(id = "__flowAd")
	private WebElement adFilter;

	@FindBy(id="__forbidUrl")
	private WebElement forbidUrl;

	public FireWallPage(EventFiringWebDriver driver) {
		super(driver);
	}

	//进入恶意网址模块
	public void gotoMaliciousWeb(){
		maliciousWeb.click();
		log.info("进入恶意网址模块------");
	}

	//进入黑客攻击模块
	public void gotoHackerAttack(){
		hackerAttack.click();
		log.info("进入黑客攻击模块------");
	}

	//进入广告过滤模块
	public void gotoAdFilter(){
		adFilter.click();
		log.info("进入广告过滤模块------");
	}

	//进入网址访问模块
	public void gotoForbidUrl(){
		forbidUrl.click();
		log.info("进入网址访问模块------");
	}
}

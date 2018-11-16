package esm.page.audit.antivirus;

import esm.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class AntivirusPage extends BasePage {

	@FindBy(id = "__xavState")
	private WebElement networkkill;

	public AntivirusPage(EventFiringWebDriver driver) {
		super(driver);
	}

}

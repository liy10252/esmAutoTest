package esm.page.audit;

import esm.page.BasePage;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

@Log4j
public class AuditPlatformPage extends BasePage {

    @FindBy(xpath = "//ul[@id='topMenu']//span[text()='平台']")
    private WebElement platformLink;

    @FindBy(xpath = "//ul[@id='topMenu']//span[text()='防病毒']")
    private WebElement antivirusLink;

    public AuditPlatformPage(EventFiringWebDriver driver) {
        super(driver);
    }

    public void gotoPlatform(){
        platformLink.click();
        log.info("进入平台模块------");
    }

    public void gotoAntivirus(){
        antivirusLink.click();
        log.info("进入防病毒模块------");
    }
}

package esm.page;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

@Log4j
public class ManageconsolePage extends BasePage{


    @FindBy(xpath = "//div[@id='header_user_audit']/a")
    private WebElement sjptLink;

    public ManageconsolePage(EventFiringWebDriver driver) {
        super(driver);
    }

    public void gotoAudit(){
        sjptLink.click();
        log.info("进入审计平台------");
    }
}

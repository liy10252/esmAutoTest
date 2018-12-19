package esm.page.audit.platform;

import esm.page.BasePage;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

@Data
@Log4j
public class PlatformPage extends BasePage {

    @FindBy(id = "__client")
    private WebElement clientSurvey;

    @FindBy(id = "__unknownClient")
    private WebElement unknownClient;

    public PlatformPage(EventFiringWebDriver driver) {
        super(driver);
    }

    public void gotoUnknownClient(){
        unknownClient.click();
        log.info("进入未知终端模块------");
    }
}

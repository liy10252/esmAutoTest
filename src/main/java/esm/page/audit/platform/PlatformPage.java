package esm.page.audit.platform;

import esm.page.BasePage;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import javax.xml.xpath.XPath;

@Data
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
    }
}

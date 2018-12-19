package esm.page.audit.platform.unknown;

import esm.page.BasePage;
import esm.util.TestUtil;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

@Data
public class UnknownPage extends BasePage {

    @FindBy(xpath = "//div[@id='tableBox1']//tbody/tr[1]")
    private WebElement tr;

    @FindBy(xpath = "//dd[@id='searchBox']//input")
    private WebElement searchBar;

    @FindBy(xpath = "//dd[@id='searchBox']//a")
    private WebElement searchButton;

    @FindBy(xpath = "//dd[@id='searchBox']//span[@val='ComputerName']")
    private WebElement computerName;

    @FindBy(xpath = "//dd[@id='searchBox']//span[@val='IP']")
    private WebElement ip;

    @FindBy(xpath = "//dd[@id='searchBox']//span[@val='MAC']")
    private WebElement mac;

    public UnknownPage(EventFiringWebDriver driver) {
        super(driver);
    }

}

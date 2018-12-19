package esm.page.audit.firewall.adfilter;

import esm.page.BasePage;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.util.List;

@Data
public class AdFilterPage extends BasePage {

	@FindBy(xpath = "//dd[@id='searchBox']//input")
	private WebElement searchBar;

	@FindBy(xpath = "//dd[@id='searchBox']//a")
	private WebElement searchButton;

	@FindBy(xpath = "//dd[@id='searchBox']//span[@val='Url']")
	private WebElement url;

	@FindBy(xpath = "//dd[@id='searchBox']//span[@val='webSite']")
	private WebElement webSite;

	@FindBy(xpath = "//div[@id='tableBox1']//tr[1]/td[1]")
	private WebElement value;

	@FindBy(xpath = "//div[@id='tableBox1']//tr/td[not(1 and @*)]")
	private List<WebElement> values;

	public AdFilterPage(EventFiringWebDriver driver){
		super(driver);
	}
}

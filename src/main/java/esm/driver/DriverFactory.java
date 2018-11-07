package esm.driver;

import java.util.Locale;
import java.util.ResourceBundle;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import esm.listener.MyEventListener;

@Log4j
public class DriverFactory {
	
    protected static WebDriver webDriver = null;
	protected static ResourceBundle bundle = ResourceBundle.getBundle("test-config", Locale.CHINA);
	protected static EventFiringWebDriver driver = null;
	protected static MyEventListener myEventListener = new MyEventListener();
    
    public synchronized static EventFiringWebDriver start() {
    	
    	String iePath = bundle.getString("browser.path.ie");
		String firefoxPath = bundle.getString("browser.path.firefox");
		String chromePath = bundle.getString("browser.path.chrome");
		String browserName = bundle.getString("browser.type");
		
		
		if (browserName.equalsIgnoreCase("ie")) { 
			System.setProperty("webdriver.ie.driver", iePath);
			webDriver = new InternetExplorerDriver();
            
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", firefoxPath);
			webDriver = new FirefoxDriver();
			 
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromePath);
			webDriver = new ChromeDriver();
			
		}
		webDriver.manage().window().maximize();
		log.info("启动浏览器："+browserName);
		driver = new EventFiringWebDriver(webDriver);
		driver.register(myEventListener);
		return driver;
    }
    
}

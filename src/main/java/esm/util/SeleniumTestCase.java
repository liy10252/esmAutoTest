package esm.util;

import java.util.Locale;
import esm.driver.DriverFactory;
import esm.page.LoginPage;
import esm.page.ManageconsolePage;
import esm.page.audit.AuditPlatformPage;
import esm.page.audit.platform.PlatformPage;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;
import java.util.ResourceBundle;

@Listeners({ esm.listener.AssertionListener.class })
@Log4j
public class SeleniumTestCase {

	protected ResourceBundle bundle = ResourceBundle.getBundle("test-config", Locale.CHINA);
	protected static EventFiringWebDriver driver;

	@BeforeClass
	public void setUp() {

		String packageName = this.getClass().getPackage().getName();
		driver = DriverFactory.start();
		TestUtil.driver = driver;
		ScreenShot.driver = driver;
		log.info("开始测试case:" + this.getClass().getSimpleName()
				+ "----------");
		driver.navigate().to(bundle.getString("url"));
		moduleLogin(packageName);

	}

	@AfterClass
	public void tearDown() {

		log.info("结束测试case:" + this.getClass().getSimpleName()
				+ "----------");
		driver.quit();
		log.info("关闭浏览器");
	}


	public void moduleLogin(String packageName){
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login();

		try{
			TestUtil.waitForTitle("安全中心 - 瑞星企业终端安全管理系统软件");
		}catch(TimeoutException e){
			loginPage.clear();
			loginPage.login();
		}

		ManageconsolePage p = new ManageconsolePage(driver);
		if(packageName.contains("audit")){
			p.gotoAudit();
			TestUtil.switchWindow();
			TestUtil.waitForUrlContainsText("/Audit/Client/Client.aspx");
			if(packageName.contains("platform")){
				AuditPlatformPage auditPlatformPage = new AuditPlatformPage(driver);
				auditPlatformPage.gotoPlatform();
				if(packageName.contains("unknown")){
					PlatformPage plPage = new PlatformPage(driver);
					plPage.gotoUnknownClient();
				}
			}
		}

	}
}

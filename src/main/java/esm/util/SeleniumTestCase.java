package esm.util;

import java.util.List;
import java.util.Locale;
import com.alibaba.fastjson.JSONObject;
import esm.datacontroller.DataController;
import esm.driver.DriverFactory;
import esm.listener.TestngListener;
import esm.model.testcase.Cases;
import esm.page.LoginPage;
import esm.page.ManageconsolePage;
import esm.page.audit.AuditPlatformPage;
import esm.page.audit.antivirus.AntivirusPage;
import esm.page.audit.platform.PlatformPage;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;
import java.util.ResourceBundle;

@Listeners({ TestngListener.class })
@Log4j
public class SeleniumTestCase {

	protected ResourceBundle bundle = ResourceBundle.getBundle("test-config", Locale.CHINA);
	protected static EventFiringWebDriver driver;
	protected static List<Cases> caseList = DataController.caseList;
	protected static JSONObject param;
	protected static JSONObject expect;


	@BeforeClass
	public void setUp() {

		String caseName = this.getClass().getCanonicalName();
		driver = DriverFactory.start();
		TestUtil.driver = driver;
		ScreenShot.driver = driver;
		ScreenShot.caseName = caseName;
		log.info("开始测试case:" + this.getClass().getSimpleName()
				+ "----------");
		String url = caseName.contains("audit")?
				bundle.getString("auditurl"):bundle.getString("url");
		driver.navigate().to(url);
		moduleLogin(caseName,url);

		param = TestCaseUtil.getParam(caseList,caseName);

		expect = TestCaseUtil.getExpect(caseList,caseName);
	}

	@AfterClass
	public void tearDown() {

		log.info("结束测试case:" + this.getClass().getSimpleName()
				+ "----------");
		driver.quit();
		log.info("关闭浏览器");
	}


	public void moduleLogin(String caseName,String url){
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login();

		try {
			if (url.contains("Audit")) {
				TestUtil.waitForUrlContainsText("/Audit/Client/Client.aspx");
			} else {
				TestUtil.waitForTitle("安全中心 - 瑞星企业终端安全管理系统软件");
			}
		}catch(TimeoutException e){
				loginPage.clear();
				loginPage.login();
			}

		if(caseName.contains("audit")){

			AuditPlatformPage auditPlatformPage = new AuditPlatformPage(driver);
			if(caseName.contains("platform")){
				auditPlatformPage.gotoPlatform();
				if(caseName.contains("unknown")){
					PlatformPage plPage = new PlatformPage(driver);
					plPage.gotoUnknownClient();
				}
			}

			if(caseName.contains("antivirus")){
				auditPlatformPage.gotoAntivirus();
				if(caseName.contains("virusdetails")){
					AntivirusPage antivirusPage = new AntivirusPage(driver);
					antivirusPage.gotovirusDetails();
				}
			}
		}else{
			ManageconsolePage manageconsolePage = new ManageconsolePage(driver);
		}

	}
}

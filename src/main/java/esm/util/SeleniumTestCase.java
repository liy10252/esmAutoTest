package esm.util;

import java.util.List;
import java.util.Locale;

import com.alibaba.fastjson.JSONObject;
import esm.datacontroller.DataController;
import esm.driver.DriverFactory;
import esm.model.testcase.Cases;
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
	protected static List<Cases> caseList = DataController.caseList;
	protected static JSONObject param;
	protected static JSONObject expect;


	@BeforeClass
	public void setUp() {

		String caseName = this.getClass().getCanonicalName();
		driver = DriverFactory.start();
		TestUtil.driver = driver;
		ScreenShot.driver = driver;
		log.info("开始测试case:" + this.getClass().getSimpleName()
				+ "----------");
		driver.navigate().to(bundle.getString("url"));
		moduleLogin(caseName);

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


	public void moduleLogin(String caseName){
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login();

		try{
			TestUtil.waitForTitle("安全中心 - 瑞星企业终端安全管理系统软件");
		}catch(TimeoutException e){
			loginPage.clear();
			loginPage.login();
		}

		ManageconsolePage p = new ManageconsolePage(driver);
		if(caseName.contains("audit")){
			p.gotoAudit();
			TestUtil.switchWindow();
			TestUtil.waitForUrlContainsText("/Audit/Client/Client.aspx");
			if(caseName.contains("platform")){
				AuditPlatformPage auditPlatformPage = new AuditPlatformPage(driver);
				auditPlatformPage.gotoPlatform();
				if(caseName.contains("unknown")){
					PlatformPage plPage = new PlatformPage(driver);
					plPage.gotoUnknownClient();
				}
			}
		}

	}
}

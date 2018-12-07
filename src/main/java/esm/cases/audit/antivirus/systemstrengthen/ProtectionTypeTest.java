package esm.cases.audit.antivirus.systemstrengthen;

import esm.page.audit.antivirus.systemstrengthen.SystemStrengThenPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProtectionTypeTest extends SeleniumTestCase {

	SystemStrengThenPage strengThenPage;

	@Test(description = "文件防护日志验证")
	public void fileProtection(){

		strengThenPage = new SystemStrengThenPage(driver);
		strengThenPage.getTimeUnlimited().click();
		strengThenPage.singleClickTool(strengThenPage.getDefUnlimited(),strengThenPage.getFile());
		Assert.assertEquals(TestUtil.waitForVisbility(strengThenPage.getValue()).getText().equals(expect.getString("file")),true,"防护类型验证错误");
	}

	@Test(dependsOnMethods = "fileProtection",description = "注册表防护日志验证")
	public void registryProtection(){

		strengThenPage.singleClickTool(strengThenPage.getDefUnlimited(),strengThenPage.getRegistry());
		Assert.assertEquals(TestUtil.waitForVisbility(strengThenPage.getValue()).getText().equals(expect.getString("registry")),true,"防护类型验证错误");
	}

	@Test(dependsOnMethods = "fileProtection",description = "进程防护日志验证")
	public void processProtection(){

		strengThenPage.singleClickTool(strengThenPage.getDefUnlimited(),strengThenPage.getProcess());
		Assert.assertEquals(TestUtil.waitForVisbility(strengThenPage.getValue()).getText().equals(expect.getString("process")),true,"防护类型验证错误");
	}

	@Test(dependsOnMethods = "fileProtection",description = "系统防护日志验证")
	public void systemProtection(){

		strengThenPage.singleClickTool(strengThenPage.getDefUnlimited(),strengThenPage.getSystem());
		Assert.assertEquals(TestUtil.waitForVisbility(strengThenPage.getValue()).getText().equals(expect.getString("system")),true,"防护类型验证错误");
	}


}

package esm.demo;

import esm.page.ManageconsolePage;
import esm.page.audit.AuditPlatformPage;
import esm.page.audit.platform.PlatformPage;
import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.testng.annotations.Test;

public class Demo1 extends SeleniumTestCase {

    @Test
    public void testDemo1() throws InterruptedException {

//        LoginPage l = new LoginPage(driver);
//        l.login();
        System.out.println(driver.getTitle());

        Thread.sleep(3000);

        ManageconsolePage p = new ManageconsolePage(driver);
        p.gotoAudit();

        Thread.sleep(3000);

        TestUtil.switchWindow();
        AuditPlatformPage a = new AuditPlatformPage(driver);
        a.gotoPlatform();

        Thread.sleep(3000);

        PlatformPage pl = new PlatformPage(driver);
        pl.gotoUnknownClient();



        Thread.sleep(3000);

    }
}

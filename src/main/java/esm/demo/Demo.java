package esm.demo;

import esm.util.SeleniumTestCase;
import esm.util.TestUtil;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo extends SeleniumTestCase {

    @Test
    public void testDemo(){
        TestUtil.seleniumWait(3000);
        Assert.assertEquals(1,2);
        System.out.println("1aaaa");
    }

    @Test
    public void testDemo2(){
        TestUtil.seleniumWait(3000);
        Assert.assertEquals(3,4);
//        Reporter.log("这是我记录的信息");
        System.out.println("2aaaa");
    }


}

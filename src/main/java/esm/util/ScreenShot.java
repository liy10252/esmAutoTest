package esm.util;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ScreenShot {
 
	public static EventFiringWebDriver driver;
	public static String caseName;
	
    public static void takeScreenshot(String fileName){

        String screenPath = getScreenshot(fileName);

        File screenFile = new File(screenPath);
        if(screenFile.exists()){
            screenFile.delete();
        }

        try {

            //获取截图file
            File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //将图片移动到指定位置
            FileUtils.moveFile(scrFile, new File(screenPath));
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getScreenshot(String fileName){

        File dir = new File("test-output/snapshot");
        if (!dir.exists()){
            dir.mkdirs();
        }

        String screenPath= dir.getAbsolutePath()+"\\"+fileName+".png";
        return screenPath;
    }

}


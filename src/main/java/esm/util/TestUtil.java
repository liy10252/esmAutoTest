package esm.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.*;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {

	public static EventFiringWebDriver driver;
	protected static ResourceBundle bundle = ResourceBundle.getBundle("test-config", Locale.CHINA);

	// 获取配置文件对象
//	public static Properties getProperties(String fileName) {
//		Properties properties = new Properties();
//		try {
//			    String filePath = TestUtil.class.getClassLoader().getResource("").toURI().getPath()+"conf/"+fileName+".properties";
//				FileInputStream fileStream = new FileInputStream(convertFilepath(filePath));
//				properties.load(fileStream);
//				fileStream.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return properties;
//	}

	public static String convertFilepath(String filepath) throws Exception {

		if (filepath.contains("bin")) {
			filepath = filepath.replace("bin/", "").substring(1);
		}
		return filepath;
	}



	public static String getProjectPath(){

    		try {
				return convertFilepath(TestUtil.class.getClassLoader().getResource("").toURI().getPath());
			} catch (Exception e) {
				e.printStackTrace();
			}

    		return "";
    }

	// 判断页面有无指定字串
	public static boolean isTextPresent(String pattern) {
		String xpath = "//*[contains(.,\'" + pattern + "\')]";
		try {
			driver.findElement(By.xpath(xpath));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 判断页面所有span有无指定字串
	public static boolean isTextPresentSpan(String pattern) {
		String xpath = "//span[text()='" + pattern + "']";
		try {
			driver.findElement(By.xpath(xpath));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 判断页面所有div有无指定字串
	public static boolean isTextPresentDiv(String pattern) {
		String xpath = "//div[text()='" + pattern + "']";
		try {
			driver.findElement(By.xpath(xpath));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 判断页面所有div有无指定xpath
	public static boolean isXpathPresent(String xpath) {
		try {
			driver.findElement(By.xpath(xpath));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 判断页面元素是否存在
	public static boolean isElementExsit(By locator) {
		try {
			driver.findElement(locator);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public static void testTakesScreenshot(String name) {

		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DATE);
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		String data = day + "_" + hour + "_" + minute;
		try {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("c:/" + data + name + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 线程等待方法
	public static void seleniumWait() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 线程等待方法
	public static void seleniumWait(int t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 智能等待元素文本改变，等待15秒，到时间没找到抛出异常.
//	public static void waitForChange(WebElement element) {
//
//		String oldStr = element.getText();
//		Wait<WebDriver> wait = new WebDriverWait(driver, 15);
//		wait.until(new ExpectedCondition<Boolean>() {
//			@Override
//			public Boolean apply(WebDriver driver) {
//				String newStr = element.getText();
//				return !oldStr.equals(newStr);
//			}
//		});
//	}

	// 智能等待元素文本改变，等待15秒，到时间没找到抛出异常，catch变动异常
	public static void waitForChanges(By locator,String oldStr) {

		Wait<WebDriver> wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.refreshed(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				String newStr = driver.findElement(locator).getText();
				return !oldStr.equals(newStr);
			}
		}));
	}

	// 智能等待元素文本改变，等待15秒，到时间没找到抛出异常，catch变动异常
	public static void waitForChanges(WebElement element,String oldStr) {

		Wait<WebDriver> wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.refreshed(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				String newStr = element.getText();
				return !oldStr.equals(newStr);
			}
		}));
	}

	public static void waitFortextToElement(By locator, String text)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.refreshed(
				ExpectedConditions.textToBePresentInElementLocated(locator,text)));
	}



//	public static void waitForUnDis(WebElement element,int time) {
//		new WebDriverWait(driver, time).until(ExpectedConditions.invisibilityOf(element));
//	}

	public static void waitForUrlContainsText(String text){
		new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains(text));
	}

	public void waitForElementClick(By locator)
	{
		final WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.refreshed(
				ExpectedConditions.elementToBeClickable(locator)));
		driver.findElement(locator).click();
	}

	public static void waitForElementOut(WebElement element)
	{
		final WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.refreshed(
				ExpectedConditions.stalenessOf(element)));
	}

	public static void waitForElementArrChange(WebElement element,String arrName,String text)
	{
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.refreshed(
				ExpectedConditions.attributeContains(element,arrName,text)));
	}



	public static void waitForElementArrNotNull(WebElement element,String arrName)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.refreshed(
				ExpectedConditions.attributeToBeNotEmpty(element,arrName)));
	}



	public static void waitForElementArrisNull(WebElement element,String arrName)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.refreshed(
				ExpectedConditions.not(ExpectedConditions.attributeToBeNotEmpty(element,arrName))));
	}


	public static void waitForElementOn(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.refreshed(
				ExpectedConditions.visibilityOf(element)));
	}

	public static void waitForAttr(By locator,String attrName,String text) {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.refreshed(
				ExpectedConditions.attributeToBe(locator,attrName,text)));
	}


	public static void waitForAttrContains(By locator,String attrName,String text) {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.refreshed(
				ExpectedConditions.attributeContains(locator,attrName,text)));
	}

	public static void waitForUrlContains(String text){

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.refreshed(
				ExpectedConditions.urlContains(text)));
	}

	public static void waitForElementOut(By locator) {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.refreshed(
				ExpectedConditions.invisibilityOfElementLocated(locator)));
	}

	public static void waitForLocated(By locator) {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.refreshed(
				ExpectedConditions.visibilityOfElementLocated(locator)));
	}


	public static void waitForUnDis(By locator) {
		new WebDriverWait(driver, 6).until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

//	public static void waitForSonElement(By parentLocator,By childLocator){
//		new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfNestedElementLocatedBy(parentLocator, childLocator));
//	}

	// pageObject注解查找元素会一直轮询,所以传递BY过来用driver查找
	public static void waitForOutDom(By locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.stalenessOf(driver.findElement(locator)));
	}

	public static void waitForOutDom(WebElement element) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.stalenessOf(element));
	}

	// 智能等待元素不显示，等待12秒，到时间没找到抛出异常.
	public static void waitForDisappear(final By locator) {

		new WebDriverWait(driver, 15).until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	// 等待元素集合加载
	public static void waitForElements(By locator) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}


	// 智能等待元素加载，等待12秒，到时间没找到抛出异常.
	public static void waitForVisbility(By locator) {

		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static WebElement waitForVisbility(WebElement element) {

		return new WebDriverWait(driver, 6).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
	}

	public static void waitForVisbilitys(List<WebElement> list){
		ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(list));
	}

	public static boolean waitForinvisibility(WebElement element) {

		return new WebDriverWait(driver, 6).until(ExpectedConditions.invisibilityOf(element));
	}



	public static void waitForLoad(By locator) {

		new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(locator));
	}




	//等待元素的文本是指定字符
	public static void waitForTextInElement(By locator,String text) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.refreshed(
				ExpectedConditions.textToBePresentInElementLocated(locator,text)));

	}



	// 等待元素可点击
	public static void waitForClick(By locator) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(locator));

	}


	public static WebElement waitForClick(WebElement element) {
		return new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
	}

	// 切换到iframe的方法根据id
	public static void switchToframe(String frameID) {

		new WebDriverWait(driver, 6).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameID));
	}


	public static void waitForTitle(String title) {

		 new WebDriverWait(driver, 3).until(ExpectedConditions.titleIs(title));
	}


	// 切换到iframe的方法根据WebElement元素
	public static void switchToframe(By locator) {
		waitForLoad(locator);
		driver.switchTo().frame(driver.findElement(locator));
	}

	public static void waitForTextOut(By locator,String text){
		new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOfElementWithText(locator,text));
	}

	// 调用autoit脚本
	public void runAu3(String au3Name) {

		String au3Str = null;
		try {
			au3Str = TestUtil.class.getResource("/au3/" + au3Name + "").toURI().toString().split("file:/")[1];
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Runtime.getRuntime().exec(au3Str).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 去除字符串中的[]
	public static String replaceStr(ArrayList<String> data) {
		return data.toString().replace("[", "").replace("]", "");
	}

	// 切换driver对象到另外一个窗口
	public static void switchWindow() {
		String currentWindow = driver.getWindowHandle();
		// 得到所有窗口的句柄
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String handle = it.next();
			if (currentWindow.equals(handle))
				continue;
			driver.switchTo().window(handle);
		}

	}

	// 判断文件是否存在
	public static boolean checkFile(String fileName) {
		boolean flag = false;
		String dirPath = bundle.getString("download.path");
		File file = new File(dirPath + fileName);
		if (file.exists()) {
			flag = true;
		}

		file.deleteOnExit();
		return flag;
	}

	// 清空元素的某一属性
	public static void deleteAttribute(By locator, String attrName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(locator);
		js.executeScript("arguments[0].setAttribute('" + attrName + "',arguments[1])", element, "");
	}

	public static void deleteAttribute(WebElement element, String attrName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('" + attrName + "',arguments[1])", element, "");
	}

	public static void setHidden(String name,String value,int type){
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("document.getElementsByName('"+name+"')[0].style='text';");
		if(type == 0){
			js.executeScript("document.getElementsByName('"+name+"')[0].value='"+value+"';");
		}else{
			js.executeScript("document.getElementsByName('"+name+"')[1].value='"+value+"';");
		}

	}


	// 修改元素属性值
	public static void setAttribute(By locator, String attrName, String attrValue) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(locator);
		js.executeScript("arguments[0].setAttribute('" + attrName + "',arguments[1])", element, attrValue);

	}



	public static void updateAttribute(WebElement element, String value) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute(\"readonly\") ", element);
		element.clear();
		element.sendKeys(value);
	}

	// 上传文件
	// public static void updateFile(String fileName) {
	// String filePath = "";
	// try {
	// filePath = TestUtil.class.getResource("/file").toURI().toString();
	// } catch (URISyntaxException e1) {
	// e1.printStackTrace();
	// }
	//
	// seleniumWait(1000);
	// Screen s = new Screen();
	// try {
	// if (s.exists("imgs/fileupdate/filepath.png") != null) {
	// s.type("imgs/fileupdate/filepath.png",
	// filePath.split("file:/")[1]);
	// s.type(Key.ENTER);
	// s.click("imgs/fileupdate/" + fileName + ".png");
	// s.click("imgs/fileupdate/openfile.png");
	// }
	//
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	// 下载文件
	public static void downLoadFile() {

		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ALT);
			r.keyPress(KeyEvent.VK_S);
			r.keyRelease(KeyEvent.VK_S);
			r.keyRelease(KeyEvent.VK_ALT);
			r.delay(1000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			r.delay(1000);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 元素集合遍历取值返回一个拼接的字符串
	public static String getListStr(List<WebElement> elementList) {
		StringBuffer bf = new StringBuffer();
		for (WebElement element : elementList) {
			bf.append(element.getText());
		}
		return bf.toString();
	}

	/**
	 * 结束任意进程
	 *
	 * @param processName
	 * @return
	 * @throws Exception
	 */
	public static void killProcess(String processName) throws Exception {

		try {
			while (isProcessRunning(processName)) {
				// log.info("强行结束***进程-------");
				Runtime.getRuntime()
						.exec("taskkill /IM " + processName + " /F");
				Thread.sleep(500);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// --判断进程是否存在，供killProcess调用
	private static boolean isProcessRunning(String processName) {
		Process p = null;
		try {
			p = Runtime.getRuntime().exec("tasklist");
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				p.getInputStream()));
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				if (line.toLowerCase().contains(processName)) {
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	//jsonarray转List
	public static List<String> JsonToList(JSONArray jsonArray, String key){

		List<String> list = new ArrayList<String>();

		if(!jsonArray.isEmpty()){
			for(int i=0;i<jsonArray.size();i++){
				list.add(jsonArray.getJSONObject(i).getString(key));
			}
		}

		return list;
	}

	//元素集合转字符串集合
	public static List<String> getValueList(List<WebElement> values){

		List<String> list = new ArrayList<String>();

		for(WebElement element : values){
			list.add(element.getText());
		}
		return list;
	}

//	public static String ipTypeChange(long ip){
//
//		byte[] result = new byte[4];
//        result[0] = (byte)((ip >> 24) & 0xFF);
//        result[1] = (byte)((ip >> 16) & 0xFF);
//        result[2] = (byte)((ip >> 8) & 0xFF);
//        result[3] = (byte)(ip & 0xFF);
//        StringBuffer sb = new StringBuffer();
//        for (int i=0; i<result.length; i++) {
//       	 if(i!=result.length-1){
//       		 sb.append(Byte.toUnsignedInt(result[i]) + ".");
//       	 }else{
//       		 sb.append(Byte.toUnsignedInt(result[i]));
//       	 }
//
//         }
//
//		return sb.toString();
//	}

}

package esm.page;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BasePage {

	EventFiringWebDriver driver;
	private final int TIMEOUT = 15;

	public BasePage(EventFiringWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
		
	}
   
//	//返回元素
//    public static WebElement getElement(WebElement element){
//    	return	TestUtil.waitForVisbility(element);
//    }
//
//    //点击指定元素
//    public static void click(WebElement element){
//    	TestUtil.waitForClick(element).click();
//	}
//
//    //对指定元素输入字符串
//    public static void sendKeys(WebElement element,String pattern){
//    	getElement(element).sendKeys(pattern);
//    }
//
//    //下拉菜单根据内容位置选择
//    public static void selectByIndex(WebElement element,int index){
//		Select select = new Select(getElement(element));
//		select.selectByIndex(index);
//    }
//
//    //下拉菜单根据字符串选择
//    public static void selectByText(WebElement element,String text){
//		Select select = new Select(getElement(element));
//		if(!text.equals("")){
//			select.selectByVisibleText(text);
//		}
//    }
//
//
//    //获取指定元素指定属性的值
//    public static String getAttribute(WebElement element,String text){
//		return getElement(element).getAttribute(text);
//    }
//
//    //获取指定元素的标签名
//    public static String getTagName(WebElement element){
//		return getElement(element).getTagName();
//    }
//
//
//    //清理指定元素的字符串
//    public static void clear(WebElement element){
//	   getElement(element).clear();
//    }
//
//
//    //获取指定元素的字符串
//    public static String getText(WebElement element){
//		return getElement(element).getText();
//    }
}

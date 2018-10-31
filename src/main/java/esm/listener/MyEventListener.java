package esm.listener;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

@Log4j
public class MyEventListener extends AbstractWebDriverEventListener{
	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver){
		log.info("查找元素："+by.toString());
	}
	
	@Override
	public void beforeClickOn(WebElement element, WebDriver driver){
		log.info("点击元素："+element.getText());
	}

}

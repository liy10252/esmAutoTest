package esm.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class LoginPage extends BasePage{

    private static Logger logger = Logger.getLogger(LoginPage.class);

    @FindBy(id = "txtUserName")
    private WebElement userName;

    @FindBy(id = "txtPassword")
    private WebElement passWord;

    @FindBy(id = "btnLogin")
    private WebElement loginBtn;

    public LoginPage(EventFiringWebDriver driver) {
        super(driver);
    }

    public void login(){

        userName.sendKeys("admin");
        passWord.sendKeys("rising123");
        loginBtn.click();
        logger.info("用户已登陆------");
    }

    public void clear(){
        userName.clear();
        passWord.clear();
    }
}

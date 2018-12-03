package esm.page;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

@Log4j
public class LoginPage extends BasePage{


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
        log.info("用户已登陆------");
    }

    public void clear(){
        userName.clear();
        passWord.clear();
    }
}

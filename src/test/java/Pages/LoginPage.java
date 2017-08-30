package Pages;

import Base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

import static com.sun.xml.internal.ws.encoding.policy.FastInfosetFeatureConfigurator.enabled;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this); //static initelements method of pagefactory class for initializing webe-element
    }

    //---Inputs---

    @FindBy(how = How.ID, using = "email") //web-element are indentify by FindBy annotation
    public WebElement txtUserName;

    @FindBy(how = How.ID, using = "pass")
    public WebElement txtPassword;

    //---Buttons---

    @FindBy(how = How.ID, using = "send2")
    public WebElement btnLogin;

    @FindBy(how = How.XPATH, using = "//a[@href='https://www.cropp.com/pl/en/customer/account/create/']")
    public WebElement btnRegister;

    @FindBy(how = How.CLASS_NAME, using = "btn btn-fb")
    public WebElement btnFacebookLogin;

    @FindBy(how = How.ID, using = "goToPasswordReminderFormButton")
    public WebElement btnForgetPass;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Invalid login or password.')]")
    public WebElement errorInvalidLogin;

    @FindBy(how = How.XPATH, using = "//*[@data-remodal-id='message']//*[@class='btn fancy-btn']")
    public WebElement btnOk;

    //---Other---

    @FindBy(how=How.XPATH, using = "//input[@aria-describedby='email-error']")
    public WebElement emailRed;

    @FindBy(how = How.XPATH, using = "//input[@aria-describedby='pass-error']")
    public WebElement passRed;

    @FindBy(how = How.XPATH, using = "//*[@id='email-error']")
    public  WebElement emailError;

    @FindBy(how = How.XPATH, using = "//*[@id='pass-error']")
    public WebElement passError;

    //---Actions---




    public void enterRegEmail() {
        txtUserName.sendKeys("0temporarymail0@gmail.com");
    }

    public void enterRegPassword() {
        txtPassword.sendKeys("kokoko");
    }

    public void enterUnregEmail(){
        txtUserName.sendKeys("unregisteredmail@gmail.com");
    }

    public  void  enterUnregPass(){
        txtPassword.sendKeys("lplplplp");

    }
    public void ClickLogin() {
        btnLogin.click();
    }

    public void ClickRegister() {
        btnRegister.click();
    }


}

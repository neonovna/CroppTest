package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage  {

    public RegisterPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //---Inputs---

    @FindBy(how = How.ID, using = "firstname")
    public WebElement txtFirstname;

    @FindBy(how = How.ID, using = "lastname")
    public WebElement txtLastname;

    @FindBy(how = How.ID, using = "email_address")
    public  WebElement txtEmail;

    @FindBy(how = How.ID, using = "telephone")
    public  WebElement txtTelephone;

    @FindBy(how = How.CLASS_NAME, using = "phone-number-prefix")
    public  WebElement txtTelPrefix;



    //---Buttons---

    @FindBy(how = How.ID, using = "registerButton")
    public WebElement btnRegister;

}

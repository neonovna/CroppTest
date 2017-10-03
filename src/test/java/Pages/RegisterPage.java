package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage  {
    public WebDriver driver;

    public RegisterPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }



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

    @FindBy(how = How.XPATH, using = "//input[@value='431']")
    public WebElement radioBtnFemale;

    @FindBy(how = How.XPATH, using = "//input[@value='429']")
    public WebElement radioBtnMale;

    @FindBy(how = How.ID, using = "password")
    public WebElement txtPass;

    @FindBy(how = How.ID, using = "confirmation")
    public WebElement txtConfirmPass;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'terms of use')]/following-sibling::div[@class='control-indicator']")
    public WebElement checkboxTerms;


    //---Buttons---

    @FindBy(how = How.ID, using = "registerButton")
    public WebElement btnRegister;


    //---Actions----

    public void openRegisterForm() {
        driver.get("https://www.cropp.com/pl/en/customer/account/create/");

    }

    public void selectFemale (){
        radioBtnFemale.click();
    }

    public void selectMale (){
        radioBtnMale.click();
    }

    public void acceptTerms(){
        checkboxTerms.click();
    }
}

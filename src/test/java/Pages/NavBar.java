package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NavBar {

    public NavBar(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //---Inputs---


    //---Buttons---

    @FindBy(how = How.CLASS_NAME, using = "my-account")
    public WebElement btnProfile;


    //---Actions---


    public void ClickProfile(){
        btnProfile.click();
    }

}

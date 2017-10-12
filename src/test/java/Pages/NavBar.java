package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NavBar {

    public WebDriver driver;

    public NavBar(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //---Inputs---

    //---Buttons---

    @FindBy(how = How.ID, using = "myAccountButton")
    public WebElement btnProfile;

    @FindBy(how = How.CLASS_NAME, using = "logout-title")
    public WebElement btnLogout;

    @FindBy(how = How.ID, using = "showSearchForm")
    public WebElement btnSearch;


    //---Actions---


    public void clickProfile() {
        btnProfile.click();
    }

    public void hoverProfile() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(btnProfile).click().build().perform();

    }

    public void openSearch(){
        btnSearch.click();
    }

    public void logout() {
        Actions actions = new Actions(driver);
        actions.moveToElement(btnProfile).moveToElement(btnLogout).click().build().perform();
    }

}

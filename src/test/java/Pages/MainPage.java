package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(how = How.CLASS_NAME, using = "cookie-close")
    public WebElement closeCookiesIcon;


    public void closeCookies()

    {
        closeCookiesIcon.click();
    }

    public void openMainPage() {
        driver.get("https://www.cropp.com/pl/en/");
    }
}

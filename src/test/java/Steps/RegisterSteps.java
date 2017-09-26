package Steps;

import Base.BaseUtil;
import Pages.LoginPage;
import Pages.NavBar;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class RegisterSteps extends BaseUtil {

    private BaseUtil base;
    public LoginPage loginpage;

    public RegisterSteps(BaseUtil base) {
        this.base = base;
        this.loginpage = new LoginPage(base.Driver);
    }

    @Given("^I am on main page$")
    public void i_am_on_main_page() {
        base.Driver.get("https://www.cropp.com/pl/en/");
        String actualTitle = base.Driver.getTitle();
        String expectedTitle = "Cropp NEW COLLECTION 2017";
        assertEquals(expectedTitle, actualTitle);
    }

    @Then("^click on profile icon$")
    public void click_on_profile_icon() {
        NavBar navbar = new NavBar(base.Driver);
        navbar.ClickProfile();
    }

    @Then("^click on Register button$")
    public void click_on_Register_button() {
        loginpage.ClickRegister();

    }

    @Then("^I can see register form$")
    public void i_can_see_register_form() {
        WebElement registration_modal = base.Driver.findElement(By.xpath("//*[@id='customerRegisterForm']"));
        registration_modal.isDisplayed();
    }

}
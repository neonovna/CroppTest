package Steps;

import Base.BaseUtil;
import Pages.LoginPage;
import Pages.NavBar;
import Pages.RegisterPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class RegisterSteps extends BaseUtil {

    private BaseUtil base;
    public LoginPage loginpage;
    public RegisterPage registerpage;

    public RegisterSteps(BaseUtil base) {
        this.base = base;
        this.loginpage = new LoginPage(base.Driver);
        this.registerpage = new RegisterPage(base.Driver);
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
        navbar.clickProfile();
    }

    @Then("^click on Register button$")
    public void click_on_Register_button() {
        loginpage.clickRegister();

    }

    @Then("^I can see register form$")
    public void i_can_see_register_form() {
        WebElement registration_modal = base.Driver.findElement(By.xpath("//*[@id='customerRegisterForm']"));
        registration_modal.isDisplayed();
    }

    @Given("^I am on Registration form$")
    public void iAmOnRegistrationForm(){
        registerpage.openRegisterForm();
    }


    @Then("^Select Gender$")
    public void selectGender() {
        registerpage.selectFemale();
    }

    @And("^Enter valid First Name$")
    public void enterValidFirstName() {
        registerpage.txtFirstname.sendKeys("Firstname");
    }

    @And("^Enter valid Last Name$")
    public void enterValidLastName()  {
        registerpage.txtLastname.sendKeys("Lastname");
    }

    @And("^Enter valid Email$")
    public void enterValidEmail() {
        registerpage.txtEmail.sendKeys("lala@la.com");
    }

    @And("^Enter  valid phone number$")
    public void enterValidPhoneNumber(){
        registerpage.txtTelephone.sendKeys("32314123421");
    }

    @And("^Enter valid password$")
    public void enterValidPassword()  {
        registerpage.txtPass.sendKeys("lolololo");
    }

    @And("^Enter password confirmation$")
    public void enterPasswordConfirmation() {
        registerpage.txtConfirmPass.sendKeys("lolololo");
    }


    @And("^Accept Terms$")
    public void acceptTerms()  {
        registerpage.acceptTerms();

    }
}

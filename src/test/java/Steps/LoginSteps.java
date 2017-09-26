package Steps;
import Base.BaseUtil;
import Pages.LoginPage;
import Pages.NavBar;
import Pages.RegisterPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.interactions.Actions;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LoginSteps extends BaseUtil {

    private BaseUtil base;
    public LoginPage loginpage;
    public NavBar navbar;
    public RegisterPage registerpage;

    public LoginSteps(BaseUtil base) {
        this.base = base;
        this.loginpage = new LoginPage(base.Driver);
        this.navbar = new NavBar(base.Driver);
        this.registerpage = new RegisterPage(base.Driver);
    }

    @Given("^I am on Login form$")
    public void iAmOnLoginForm() {
        base.Driver.get("https://www.cropp.com/pl/en/customer/account/login/");
        assertTrue(base.Driver.getTitle().contains("Login"));
    }

    @And("^I enter registered email and password$")
    public void iEnterRegisteredEmailAndPassword() {
        loginpage.enterRegEmail();
        loginpage.enterRegPassword();
    }

    @And("^click on login button$")
    public void clickOnLoginButton() {
        loginpage.clickLogin();

    }

    @Then("^I should see Account page$")
    public void iShouldSeeAccountPage() throws Throwable {
        assertTrue(base.Driver.getTitle().contains("Account Information"));
    }

    @And("^I enter unregistered email address and any password$")
    public void iEnterUnregisteredEmailAdressAndAnyPassword() throws Throwable {
        loginpage.enterUnregEmail();
        loginpage.enterUnregPass();
    }

    @When("^Modal error is displayed$")
    public void modalErrorIsDisplayed() throws Throwable {
        loginpage.errorInvalidLogin.isDisplayed();
    }

    @Then("^click on Ok button$")
    public void clickOnOkButton() throws Throwable {
        loginpage.btnOk.click();
    }

    @And("^I should see the login form again$")
    public void iShouldSeeTheLoginFormAgain() throws Throwable {
        assertTrue(loginpage.btnLogin.isDisplayed());
    }

    @Then("^username and password fields are highlighted$")
    public void usernameAndPasswordFieldsAreHighlighted() throws Throwable {
        assertTrue(loginpage.emailRed.isDisplayed());
        assertTrue(loginpage.passRed.isDisplayed());
    }

    @And("^username and password fields contain error message$")
    public void usernameAndPasswordFieldsContainErrorMessage() throws Throwable {
        assertTrue(loginpage.emailError.isDisplayed());
        assertTrue(loginpage.passError.isDisplayed());
    }

    @And("^I enter registered email address$")
    public void iEnterRegisteredEmailAddress() throws Throwable {
        loginpage.enterRegEmail();
    }

    @And("^I enter incorrect password$")
    public void iEnterIncorrectPassword() throws Throwable {
       loginpage.enterUnregPass();
    }

    @When("^hover over profile icon$")
    public void hoverOverProfileIcon() throws Throwable {
        navbar.hoverProfile();
    }

    @And("^click on Logout button$")
    public void clickOnLogoutButton() throws Throwable {
        navbar.logout();
    }

    @Then("^I should see logout page$")
    public void iShouldSeeLogoutPage() throws Throwable {
        loginpage.logoutPage.isDisplayed();
    }

    @When("^five second pass$")
    public void fiveSecondPass() throws Throwable {
        Thread.sleep(5000);
    }


    @Then("^I should see the main page$")
    public void iShouldSeeTheMainPage() throws Throwable {
        String actualTitle = base.Driver.getTitle();
        String expectedTitle = "Cropp NEW COLLECTION 2017";
        assertEquals(expectedTitle, actualTitle);
    }
}
package Steps;
import Base.BaseUtil;
import Pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class LoginSteps extends BaseUtil {

    private BaseUtil base;
    public LoginPage loginpage;

    public LoginSteps(BaseUtil base) {
        this.base = base;
        this.loginpage = new LoginPage(base.Driver);
    }


    @Given("^I am on Login form$")
    public void iAmOnLoginForm() {
        base.Driver.get("https://www.cropp.com/pl/en/customer/account/login/");
       // assertTrue(base.Driver.getTitle().contains("Login"));
    }

    @And("^I enter the following for login$")
    public void iEnterTheFollowingForLogin() {
        loginpage.enterRegEmail();
        loginpage.enterRegPassword();

    }

    @And("^click on login button$")
    public void clickOnLoginButton() {
        base.Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginpage.ClickLogin();


    }

    @Then("^I should see the main page$")
    public void iShouldSeeTheMainPage() throws Throwable {
        base.Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        assertTrue(base.Driver.getTitle().contains("Account Information"));
    }


    @And("^I enter unregistered email address and any password$")
    public void iEnterUnregisteredEmailAdressAndAnyPassword() throws Throwable {
        base.Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        loginpage.enterUnregEmail();
        loginpage.enterUnregPass();
    }

    @When("^Modal error is displayed$")
    public void modalErrorIsDisplayed() throws Throwable {
        base.Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        loginpage.errorInvalidLogin.isDisplayed();
    }

    @Then("^click on Ok button$")
    public void clickOnOkButton() throws Throwable {
        base.Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        loginpage.btnOk.click();
    }

    @And("^I should see the login form again$")
    public void iShouldSeeTheLoginFormAgain() throws Throwable {
        base.Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        assertTrue(loginpage.btnLogin.isDisplayed());

    }

    @Then("^username and password fields are highlighted$")
    public void usernameAndPasswordFieldsAreHighlighted() throws Throwable {
        base.Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        assertTrue(loginpage.emailRed.isDisplayed());
        assertTrue(loginpage.passRed.isDisplayed());
    }

    @And("^username and password fields contain error message$")
    public void usernameAndPasswordFieldsContainErrorMessage() throws Throwable {
        base.Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        assertTrue(loginpage.emailError.isDisplayed());
        assertTrue(loginpage.passError.isDisplayed());

    }
}
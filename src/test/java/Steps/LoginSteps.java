package Steps;

import Base.BaseUtil;
import Pages.LoginPage;
import Pages.NavBar;
import Pages.RegisterPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LoginSteps extends BaseUtil {

    private BaseUtil base;
    private LoginPage loginpage;
    private NavBar navbar;
    private RegisterPage registerpage;

    public LoginSteps(BaseUtil base) {
        this.base = base;
        this.loginpage = new LoginPage(base.Driver);
        this.navbar = new NavBar(base.Driver);
        this.registerpage = new RegisterPage(base.Driver);
    }

    @Given("^I am on Login form$")
    public void iAmOnLoginForm() {
        loginpage.openLoginForm();
        assertTrue(base.Driver.getTitle().contains("Login"));
    }

    @And("^click on login button$")
    public void clickOnLoginButton() {
        loginpage.clickLogin();
    }

    @Then("^I should see Account page$")
    public void iShouldSeeAccountPage() {
        assertTrue(base.Driver.getTitle().contains("Account Information"));
    }

    @When("^Modal error is displayed$")
    public void modalErrorIsDisplayed() {
        loginpage.errorInvalidLogin.isDisplayed();
    }

    @Then("^click on Ok button$")
    public void clickOnOkButton() {
        loginpage.btnOk.click();
    }

    @And("^I should see the login form again$")
    public void iShouldSeeTheLoginFormAgain() {
        assertTrue(loginpage.btnLogin.isDisplayed());
    }

    @Then("^username and password fields are highlighted$")
    public void usernameAndPasswordFieldsAreHighlighted() {
        assertTrue(loginpage.emailRed.isDisplayed());
        assertTrue(loginpage.passRed.isDisplayed());
    }

    @And("^username and password fields contain error message$")
    public void usernameAndPasswordFieldsContainErrorMessage() {
        assertTrue(loginpage.emailError.isDisplayed());
        assertTrue(loginpage.passError.isDisplayed());
    }

    @And("^I enter registered credentials$")
    public void iEnterRegisteredCredentials(DataTable credentials) {
        List<List<String>> data = credentials.raw();
        loginpage.txtUserName.sendKeys(data.get(0).get(0));
        loginpage.txtPassword.sendKeys(data.get(0).get(1));
    }

    @And("^I enter invalid (.*) or (.*)$")
    public void iEnterInvalidUsernameOrPassword(String name, String pass) {
        loginpage.txtUserName.sendKeys(name);
        loginpage.txtPassword.sendKeys(pass);
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



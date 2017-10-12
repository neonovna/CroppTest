package Steps;

import Base.BaseUtil;
import Pages.LoginPage;
import Pages.NavBar;
import Pages.RegisterPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class RegisterSteps extends BaseUtil {

    private BaseUtil base;
    private LoginPage loginpage;
    private RegisterPage registerpage;

    public RegisterSteps(BaseUtil base) {
        this.base = base;
        this.loginpage = new LoginPage(base.Driver);
        this.registerpage = new RegisterPage(base.Driver);
    }

    @Given("^I am on Registration form$")
    public void iAmOnRegistrationForm() {
        registerpage.openRegisterForm();
    }


    @Then("^Select Gender$")
    public void selectGender() {
        registerpage.selectFemale();
    }


    @And("^Accept Terms$")
    public void acceptTerms() {
        registerpage.acceptTerms();
    }

    @When("^I enter valid data$")
    public void iEnterValidData(DataTable table) {
        List<List<String>> data = table.raw();
        registerpage.txtFirstname.sendKeys(data.get(0).get(1));
        registerpage.txtLastname.sendKeys(data.get(1).get(1));
        registerpage.txtEmail.sendKeys(data.get(2).get(1));
        registerpage.txtTelephone.sendKeys(data.get(3).get(1));
        registerpage.txtPass.sendKeys(data.get(4).get(1));
        registerpage.txtConfirmPass.sendKeys(data.get(5).get(1));
    }

    @And("^Click on Register button$")
    public void clickOnRegisterButton() {
        registerpage.clickRegisterBtn();
    }

    @Then("^Thanks Popup is displayed$")
    public void thanksPopupIsDisplayed() {
        assertTrue(registerpage.thanksPopup.isDisplayed());
    }

}
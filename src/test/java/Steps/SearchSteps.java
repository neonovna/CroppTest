package Steps;

import Base.BaseUtil;
import Pages.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class SearchSteps extends BaseUtil {
    private BaseUtil base;
    private LoginPage loginpage;
    private NavBar navbar;
    private RegisterPage registerpage;
    private MainPage mainpage;
    private SearchPage searchpage;

    public SearchSteps(BaseUtil base) {
        this.base = base;
        this.loginpage = new LoginPage(base.Driver);
        this.navbar = new NavBar(base.Driver);
        this.registerpage = new RegisterPage(base.Driver);
        this.mainpage = new MainPage(base.Driver);
        this.searchpage = new SearchPage(base.Driver);
    }

    @Given("^I am on Main page$")
    public void iAmOnMainPage() {
        mainpage.openMainPage();
    }

    @When("^I click on Search icon$")
    public void iClickOnSearchIcon() {
        navbar.clickSearch();
    }

    @Then("^Search input is opened$")
    public void searchInputIsOpened() {
        assertTrue(searchpage.inputSearch.isDisplayed());
    }

    @And("^I submit search$")
    public void iSubmitSearch() {
        searchpage.submitSearch();
    }

    @And("^enter (.*) in search box$")
    public void enterValueInSearchBox(String value)  {
        searchpage.inputSearch.click();
        searchpage.inputSearch.sendKeys(value);
    }

    @Then("^search result is displayed$")
    public void searchResultIsDisplayed()  {
        assertTrue(searchpage.searchResultSection.isDisplayed());
    }
}

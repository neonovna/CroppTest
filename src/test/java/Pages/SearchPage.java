package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    public WebDriver driver;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = " //input[@name='q']")
    public WebElement inputSearch;

    @FindBy(how = How.XPATH, using = "//button[@type='submit' and @title='Search']")
    public WebElement btnSubmitSearch;

    @FindBy(how = How.XPATH, using = "//a[@class='product-link']")
    public WebElement searchResultSection;

    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Your search returns no results.')]")
    public WebElement searchNoResults;


    public void submitSearch(){
        btnSubmitSearch.click();
    }

}

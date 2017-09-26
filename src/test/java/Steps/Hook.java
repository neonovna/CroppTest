package Steps;

import Base.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Hook extends BaseUtil {

    private BaseUtil base;                //dependency injection

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void beforeScenario() {
        System.out.println("Opening a browser: Firtefox");
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
        base.Driver = new FirefoxDriver();
        //this.base.Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void afterScenario() {

        System.out.println("Closing a Firefox browser");
        base.Driver.quit();
    }

}

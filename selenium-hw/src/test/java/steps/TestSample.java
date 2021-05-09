package steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import pages.RegionPage;
import pages.MainPage;
import pages.SearchPage;

import java.util.concurrent.TimeUnit;


public class TestSample {

    protected WebDriver driver;
    protected MainPage mainPage;
    protected RegionPage regionPage;
    protected SearchPage searchPage;

    @BeforeClass
    public void beginSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainPage = PageFactory.initElements(driver, MainPage.class);
        searchPage = PageFactory.initElements(driver, SearchPage.class);
        regionPage = PageFactory.initElements(driver, RegionPage.class);

    }

    @AfterEach
    public void endSession(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.quit();
    }
}

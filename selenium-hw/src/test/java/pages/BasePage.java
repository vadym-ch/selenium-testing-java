package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    protected String url = "https://www.epam.com/";

    @FindBy(xpath = "//*[contains(@class,'button-ui bg-color-light-blue cookie-disclaimer__button')]")
    protected WebElement cookiesButton;

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver,20);
    }

    public void redirectPage(String link) throws InterruptedException {
        sleep(2000);
        assertEquals(link, driver.getCurrentUrl());
    }

    public void closeCookies(){
        cookiesButton.click();
    }
}

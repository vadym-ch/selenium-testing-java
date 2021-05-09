package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MainPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Services')]")
    private WebElement servicesButton;

    @FindBy(xpath = "//a[contains(text(),'How We Do It')]")
    private WebElement howWeDoItButton;

    @FindBy(xpath = "//a[contains(text(),'Our Work')]")
    private WebElement ourWorkButton;

    @FindBy(xpath = "//a[contains(text(),'Insights')]")
    private WebElement insightsButton;

    @FindBy(xpath = "//a[contains(text(),'About')][contains(@href, '/about')]")
    private WebElement aboutButton;

    @FindBy(xpath = "//a[contains(text(), 'Careers')][contains(@href, '/careers')]")
    private WebElement careersButton;

    @FindBy(xpath = "//span[contains(text(),'CONTACT US')]")
    private WebElement contactUsButton;

    @FindBy(xpath = "//button[contains(@class, 'header-search__button header__icon')]")
    private WebElement searchButton;

    @FindBy(id = "new_form_search")
    private WebElement searchField;

    @FindBy(xpath = "//a[contains(@href, 'https://careers.epam-poland.pl')]")
    private WebElement polandButton;

    @FindBy(xpath = "//button[contains(@class,'location-selector__button')][ contains(text(),'Global (EN)')]")
    private WebElement languageButton;

    @FindBy(xpath = "//a[contains(@href, '/about/investors/faq')]")
    private WebElement faqButton;

    @FindBy(xpath = "//a[contains(@href,'https://www.infongen.com/')]")
    private WebElement infongenButton;

    @FindBy(xpath = "//a[contains(@href, '/our-work/insurance')]")
    private WebElement insuranceButton;

    @FindBy(xpath = "//span[contains(@class,'button__content--desktop')][contains(text(),'Explore our latest work')]")
    private WebElement latestWorkButton;

    @FindBy(xpath = "//a[contains(@href, '/our-work/media-entertainment-and-telecom')]")
    private WebElement mediaEntertaimentButton;

    @FindBy(xpath = "//div[contains(@class, 'rollover-blocks__text')]/p[ contains(text(),'Collaborated with Epic Games to provide the flexibility, reliability and scalability needed to push the boundaries of online gaming')]")
    private WebElement customerHover;

    @FindBy(xpath = "//img[contains(@class, 'rollover-blocks__image')][contains(@src, '/content/dam/epam/our_work/media-entertainment-telecom/epic_logo.png')]")
    private WebElement customerButton;


    private Actions actions = new Actions(driver);

    public MainPage(WebDriver driver){
        super(driver);
    }

    public void goTo(){
        driver.get(url);
    }

    public void enterSearchText(String searchText){
        searchField.sendKeys(searchText);
        searchField.submit();
    }

    public void pointOnButton(String button){
        actions.moveToElement(findButton(button)).build().perform();
    }

    private WebElement findButton(String name){
        switch (name){
            case "SERVICES":
                return servicesButton;
            case "HOW WE DO IT":
                return howWeDoItButton;
            case "OUR WORK":
                return ourWorkButton;
            case "INSIGHTS":
                return insightsButton;
            case "ABOUT":
                return aboutButton;
            case "CAREERS":
                return careersButton;
            case "Contact Us":
                return contactUsButton;
            case "search":
                return searchButton;
            case "language":
                return languageButton;
            case "FAQ":
                return faqButton;
            case "INFONGEN":
                return infongenButton;
            case "INSURANCE":
                return insuranceButton;
            case "EXPLORE OUR LATEST WORK":
                return latestWorkButton;
            case "MEDIA ENTERTAINMENT TELECOM":
                return mediaEntertaimentButton;
            case "CUSTOMER":
                return customerButton;
            default:
                return polandButton;
        }
    }

    public void clickButton(String button){
        WebElement but = findButton(button);
        wait.until(ExpectedConditions.elementToBeClickable(but));
        but.click();
    }

    public void viewButton(String button){
        WebElement but = findButton(button);
        but.isDisplayed();
    }

    public void redirection(String page) throws InterruptedException {
        redirectPage(url + page);
    }

    public void openInNewPage(String link){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertEquals(driver.getCurrentUrl(), link);
    }

    public void imageHover(){
        customerHover.isDisplayed();
    }
}

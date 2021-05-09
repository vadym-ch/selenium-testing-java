package pages;

import org.openqa.selenium.WebDriver;

public class RegionPage extends BasePage {

    public RegionPage(WebDriver driver){
        super(driver);
        url = "https://careers.epam-poland.pl/";
    }

    public void seeRegionPage() throws InterruptedException {
        redirectPage(url);
    }
}

package pages;

import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
        url += "search";
    }

    public void seeKubeSearch() throws InterruptedException{
        redirectPage(url + "?q=kubernetes");
    }
}

package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinition extends TestSample {

    @Before
    public void startTest(){
        beginSession();
    }


    @Given("I visit website epam.com")
    public void openMain(){
        mainPage.goTo();
        mainPage.closeCookies();
    }

    @When("I click {string} button")
    public void clickButton(String button) {
        mainPage.clickButton(button);
    }

    @Then("I should be redirected to appropriate service {string} page")
    public void redirectToPage(String str) throws InterruptedException {
        mainPage.redirection(str);
    }

    @And("I write 'kubernetes' in special form")
    public void writeKube() {
        mainPage.enterSearchText("kubernetes");
    }

    @Then("I should be redirected to the page of search result")
    public void changedToSearchKube() throws InterruptedException {
        searchPage.seeKubeSearch();
    }

    @Then("I should see the page in correct translated Polish language")
    public void changeLanguageRegion() throws InterruptedException {
        regionPage.seeRegionPage();
    }

    @When("I point cursor on {string}")
    public void pointCursorOnButton(String str) {
        mainPage.pointOnButton(str);
    }

    @Then("I should be redirected to the page with opened FAQ")
    public void toFAQPage() throws InterruptedException {
        mainPage.redirectPage("https://investors.epam.com/investors/faq");
    }

    @Then("I should see the {string} button")
    public void viewLatestWork(String button) {
        mainPage.viewButton(button);
    }

    @Then("I should be redirected to the new page {string}")
    public void goToNewPage(String str) {
        mainPage.openInNewPage(str);
    }


    @Then("I should see image hovered by text")
    public void checkIsHovered() {
        mainPage.imageHover();
    }











    @After
    public void finishTest(){
        endSession();
    }
}

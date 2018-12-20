package stepdefs;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.asserts.SoftAssert;
import pageobjects.HomePage;
import utils.DriverManager;

import java.util.ArrayList;

public class SearchTicket_steps {

  private TestContext testContext;
  private DriverManager driverManager;
  private HomePage homePage;
  private String currentUrl;
  private int numOfTabs;

  public SearchTicket_steps(TestContext testContext) {
    this.testContext = testContext;
    driverManager = testContext.getWebDriverManager();
    homePage = testContext.getPageObjectManager().getHomePage();
  }

  @Given("^user is on the home page \"([^\"]*)\"$")
  public void user_is_on_the_home_page(String url) {
    homePage.navigateTo_HomePage(url);
  }

  @When("^user sets depart point$")
  public void user_sets_depart_point() throws InterruptedException {
    homePage.setDepartPoint();
  }

  @When("^user sets destination point$")
  public void user_sets_destination_point() {
    homePage.setDestinationPoint();
  }

  @When("^user sets depart date$")
  public void user_sets_depart_date() {
    homePage.setDepartDate();
  }

  @When("^user sets destination date$")
  public void user_sets_destination_date() {
    homePage.setDestinationDate();
  }

  @When("^user sets number of passengers$")
  public void user_sets_number_of_passengers() {
    homePage.setNumberOfPassengers();
  }

  @When("^user sets class$")
  public void user_sets_class() {
    homePage.setClass();
  }

  @When("^user start the search$")
  public void userStartTheSearch() {
    currentUrl = driverManager.getDriver().getCurrentUrl();
    numOfTabs = driverManager.getDriver().getWindowHandles().size();
    homePage.searchTicket();
  }

  @Then("^user should be redirected to avia tickets page$")
  public void user_should_be_redirected_to_avia_tickets_page() {
    ArrayList<String> tabs2 = new ArrayList<String>(driverManager.getDriver().getWindowHandles());
    driverManager.getDriver().switchTo().window(tabs2.get(1));
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertNotEquals(currentUrl, driverManager.getDriver().getCurrentUrl());
    softAssert.assertNotEquals(numOfTabs, driverManager.getDriver().getWindowHandles().size());
    softAssert.assertAll();
  }

}

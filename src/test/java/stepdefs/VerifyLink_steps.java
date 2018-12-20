package stepdefs;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pageobjects.HomePage;

public class VerifyLink_steps {
  TestContext testContext;
  HomePage homePage;

  public VerifyLink_steps(TestContext testContext) {
    this.testContext = testContext;
    homePage = testContext.getPageObjectManager().getHomePage();
  }

  @When("^user clicks on the services button$")
  public void user_clicks_on_the_services_button() {
    homePage.clickOnServices();
  }

  @Then("^user should see services dropdown$")
  public void user_should_see_services_dropdown() {
    Assert.assertTrue(homePage.verifyThat_ServicesDropDownDisplayed());
  }

}

package stepdefs;

import cucumber.TestContext;
import cucumber.api.java.After;
import utils.DriverManager;

public class Hooks {

  TestContext testContext;
  DriverManager driverManager;

  public Hooks(TestContext context) {
    testContext = context;
    driverManager = testContext.getWebDriverManager();
  }

  @After
  public void tearDown() {
    driverManager.closeDriver();
  }
}

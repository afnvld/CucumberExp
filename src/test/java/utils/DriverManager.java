package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
  private WebDriver driver;

  public WebDriver getDriver() {
    if (driver == null)
      driver = configureDriver();
    return driver;
  }

  private WebDriver configureDriver() {
    String browserName = ConfigFile.getBrowserName();
    switch (browserName) {
      case "chrome":
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        break;
      case "firefox":
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        break;
    }
    return driver;
  }

  public void closeDriver() {
    driver.close();
    driver.quit();
  }
}

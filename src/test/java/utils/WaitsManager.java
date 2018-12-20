package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WaitsManager {
  WebDriver driver;
  WebDriverWait wait;

  public WaitsManager(WebDriver driver, int time) {
    this.driver = driver;
    wait = new WebDriverWait(driver, time);
  }

  public List<WebElement> until_VisibilityOfElements(List<WebElement> elementsList) {
    return wait.until(ExpectedConditions.visibilityOfAllElements(elementsList));
  }

  public WebElement until_ElementToBeClickable(WebElement element) {
    return wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  public WebElement until_VisibilityOfElement(WebElement element) {
    return wait.until(ExpectedConditions.visibilityOf(element));
  }
}

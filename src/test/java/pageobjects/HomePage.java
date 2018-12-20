package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitsManager;

import java.util.List;
import java.util.Random;

public class HomePage {
  private WebDriver driver;
  private WaitsManager wait;

  @FindBy(xpath = "//input[@id='origin']")
  private WebElement originInput;

  @FindBy(xpath = "//input[@id='destination']")
  private WebElement destinationInput;

  @FindBy(xpath = "//div[@class='autocomplete --origin']//div[@class='autocomplete__dropdown']")
  private List<WebElement> originAutocompleteDropdownList;

  @FindBy(xpath = "//div[@class='autocomplete --destination']//div[@class='autocomplete__dropdown']")
  private List<WebElement> destinationAutocompleteDropdownList;

  @FindBy(id = "departDate")
  private WebElement departDateInput;

  @FindBy(xpath = "//div[@class='daypicker__day-cell --today']")
  private WebElement todaysDate;

  @FindBy(xpath = "//div[contains(@class, 'daypicker__day-cell') and not(contains(@class, '--is-disabled'))]")
  private List<WebElement> returnDateList;

  @FindBy(xpath = "//div[@class='additional-fields__label']")
  private WebElement additionalFields;

  @FindBy(xpath = "//div[@class='additional-fields__passenger-row']//a[@class='additional-fields__passenger-control --increment']")
  private List<WebElement> incrementPassengersBtnsList;

  @FindBy(css = ".additional-fields__trip-class-button")
  private List<WebElement> ticketClassList;

  @FindBy(xpath = "(//button[text()= 'Найти билеты'])[2]")
  private WebElement searchBtn;

  @FindBy(xpath = "//div[@class='dropdown__inner-wrap navbar-item__inner header-menu__dropdown dropdown-enter-done']")
  private WebElement servicesDropdown;

  @FindBy(xpath = "//div[@class='navbar-item__label']")
  private WebElement servicesBtn;

  public HomePage(WebDriver driver) {
    this.driver = driver;
    wait = new WaitsManager(driver, 10);
    PageFactory.initElements(driver, this);
  }

  public void navigateTo_HomePage(String url) {
    driver.get(url);
  }

  public void setDepartPoint() {
    originInput.click();
    originInput.sendKeys("Chicago");
    wait.until_VisibilityOfElements(originAutocompleteDropdownList);
    originInput.sendKeys(Keys.DOWN);
    originInput.sendKeys(Keys.DOWN);
    originInput.sendKeys(Keys.ENTER);
  }

  public void setDestinationPoint() {
    Actions action = new Actions(driver);
    destinationInput.click();
    action.moveToElement(destinationAutocompleteDropdownList.get(0)).build().perform();
    destinationInput.sendKeys("New York");
    destinationInput.sendKeys(Keys.DOWN);
    while (!destinationInput.getAttribute("aria-activedescendant").contains("2")) {
      destinationInput.sendKeys(Keys.DOWN);
    }
    destinationInput.sendKeys(Keys.ENTER);
  }

  public void setDepartDate() {
    wait.until_ElementToBeClickable(todaysDate).click();
  }

  public void setDestinationDate() {
    Random rand = new Random();
    List<WebElement> returnDays = wait.until_VisibilityOfElements(returnDateList);
    returnDays.get(rand.nextInt(returnDateList.size() - 1)).click();
  }

  public void setNumberOfPassengers() {
    additionalFields.click();
    for (WebElement passenger : incrementPassengersBtnsList) {
      wait.until_ElementToBeClickable(passenger).click();
    }
    additionalFields.click();
  }

  public void setClass() {
    for (WebElement ticketClass : ticketClassList)
      if (ticketClass.getText().equals("Бизнес"))
        ticketClass.click();
  }

  public void searchTicket() {
    searchBtn.click();
  }

  public void clickOnServices() {
    servicesBtn.click();
  }

  public boolean verifyThat_ServicesDropDownDisplayed() {
    return wait.until_VisibilityOfElement(servicesDropdown).isDisplayed();
  }
}

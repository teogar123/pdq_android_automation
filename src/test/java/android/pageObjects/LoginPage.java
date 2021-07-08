package android.pageObjects;
import java.util.Random;
import bases.Base;
import com.utils.Data;
import com.utils.Locators;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import java.time.Duration;
import java.util.Random;

public class LoginPage {


  public LoginPage(WebDriver driver) {

    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
  }

  @FindBy(id = Locators.PERMISSION_OK_BUTTON)
  public AndroidElement storagePermissionOkButton;

  @FindBy(id = Locators.LOGIN_BUTTON)
  public AndroidElement loginLink;

  @FindBy(id = Locators.EMAIL_FIELD)
  public AndroidElement emailField;

  @FindBy(id = Locators.PASSWORD_FIELD)
  public AndroidElement passwordField;

  @FindBy(id = Locators.CONTINUE_BUTTON)
  public AndroidElement continueButton;

  @FindBy(id = Locators.MASTER_ACCOUNT_OPTION)
  public AndroidElement masterAccountOption;

  @FindBy(id = Locators.SELECT_ACCOUNT_BUTTON)
  public AndroidElement selectAccountButton;

  @FindBy(xpath = Locators.TEDDY_BOLO_OPTION)
  public AndroidElement teddyBoloOption;

  @FindBy(id = Locators.ADD_USER_BUTTON)
  public AndroidElement addUserButton;

  @FindBy(id = Locators.NAME_INPUT_FIELD)
  public AndroidElement nameInputField;

  @FindBy(id = Locators.LAST_NAME_INPUT_FIELD)
  public AndroidElement lastNameInputField;

  @FindBy(id = Locators.ADD_USER_DEVICE_NAME)
  public AndroidElement addUserDeviceName;

  @FindBy(id = Locators.CONTINUE_BUTTON_FINAL )
  public AndroidElement continueButtonFinal;


  /**
   *
   * @description Function to perform the "Login" and "Add a new user" in order to setup the lock unlock function
   *
   */
  public void loginFlow() throws InterruptedException {

    System.out.println("Tap on Storage Permission Button ");

    if (this.storagePermissionOkButton.isEnabled()) {
      this.storagePermissionOkButton.click();
    } else {
      System.out.println("The Element is not present");
    }

    System.out.println("Tap on Login Link");
    this.loginLink.click();
    System.out.println("Enter Email Id");

    if(this.emailField.isDisplayed() || this.passwordField.isDisplayed()) {
      System.out.println("Ready to Proceed ?  : YES ");
    } else {
      System.out.println("Ready to Proceed ?  : NO ");
    }

    this.emailField.clear();
    this.emailField.sendKeys(Data.email);
    this.passwordField.clear();
    this.passwordField.sendKeys(Data.pwd);
    this.continueButton.click();
    //Thread.sleep(5000);
    //this.masterAccountOption.click();
    //Thread.sleep(5000);
    //this.selectAccountButton.click();
    Thread.sleep(4000);
    this.teddyBoloOption.click();
    Thread.sleep(4000);
    this.addUserButton.click();
    this.nameInputField.clear();
    this.nameInputField.sendKeys(Data.name);
    this.lastNameInputField.clear();
    this.lastNameInputField.sendKeys(Data.lastName);
    this.addUserDeviceName.clear();
    this.addUserDeviceName.sendKeys(Data.addedDeviceName);
    this.continueButtonFinal.click();
    Thread.sleep(10000);
    }
}

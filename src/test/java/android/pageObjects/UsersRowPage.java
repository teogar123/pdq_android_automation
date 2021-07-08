package android.pageObjects;

import com.utils.Locators;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UsersRowPage {
    private WebDriverWait wait;

    public UsersRowPage(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
        wait = new WebDriverWait(driver, 15, 50);
    }

    @FindBy(xpath = Locators.USER_DELETE_BUTTON)
    public AndroidElement deleteUserButton;

    @FindBy(id = Locators.ACCEPT_DELETE_USER )
    public AndroidElement acceptDeleteUserButton;

    @FindBy(xpath = Locators.USER_DELETE_SUCCESS_MESSAGE)
    public AndroidElement userDeletedSuccessfullyMessage;

    public void deleteUserFLow() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(this.deleteUserButton)).click();
        wait.until(ExpectedConditions.visibilityOf(this.acceptDeleteUserButton)).click();
        System.out.println("User Deleted: >>> Successfully");
    }
}

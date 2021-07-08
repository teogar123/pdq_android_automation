package android.pageObjects;


import com.utils.Locators;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LockPage {
    private WebDriverWait wait;



    public LockPage(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
        wait = new WebDriverWait(driver, 15, 50);
    }

    @FindBy(id = Locators.TEO_LOCK)
    public AndroidElement teoLock;

    @FindBy(id = Locators.UNLOCK_BUTTON)
    public AndroidElement unlockButton;

    @FindBy(id = Locators.LOCK_BUTTON)
    public AndroidElement lockButton;

    @FindBy(id = Locators.ACCEPT_ALERT)
    public AndroidElement acceptAlert;

    @FindBy(id = Locators.ACCEPT_ALERT)
    public AndroidElement remoteModeOkButton;

    @FindBy(id = Locators.USER_ROW_BUTTON)
    public AndroidElement usersRowButton;

    @FindBy(id = Locators.USER_TITTLE)
    public AndroidElement userTitle;

    /**
     *
     *
     * @description Function to perform the Lock - Unlock Activities
     *
     */
    public void lockUnlockFlow() throws InterruptedException {
        this.teoLock.click();
        Thread.sleep(4000);
        //this.lockButton.click();
        System.out.println("Waiting for the lock button to be Clickable");
        wait.until(ExpectedConditions.visibilityOf(this.lockButton)).click();
        System.out.println("Lock Button : >>> Clicked and is Locked");
        Thread.sleep(10000);
        //this.remoteModeOkButton.click();
        this.unlockButton.click();
        System.out.println("Unlock Button : >>> CLicked and Unlocked");
        Thread.sleep(10000);
    }

    public void navigatingToUsersRowPage() {
        this.usersRowButton.click();
        System.out.println("Navigating to the Users Row Page");
        wait.until(ExpectedConditions.visibilityOf(this.userTitle)).isDisplayed();
        System.out.println("Users Row Page is: >>> Displayed");
    }
}






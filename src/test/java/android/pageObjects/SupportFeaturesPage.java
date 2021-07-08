package android.pageObjects;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SupportFeaturesPage {
    private WebDriverWait wait;

    public SupportFeaturesPage(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
        wait = new WebDriverWait(driver, 15, 50);
    }

    @FindBy(xpath = "com.belwith.pdqsmart:id/home_bottom_row_help_center")
    public AndroidElement helpCenterButton;



}

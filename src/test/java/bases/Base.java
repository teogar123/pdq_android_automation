package bases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base {

    protected AppiumDriver<WebElement> driver;

    @BeforeClass
    public void setUp () {

        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            System.out.println("Automation PDQ Smart : START...!");

            //cap.setCapability("automationName","UIAutomator2");
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UIAutomator2");
            cap.setCapability("platformName", "TeddyRedmi");
            cap.setCapability("deviceName", "sdk_gphone_x86");
            cap.setCapability("udid", "128618f0");
            cap.setCapability("platformName", "Android");
            cap.setCapability("platformVersion", "9");
            cap.setCapability("autoGrantPermissions","true");
            cap.setCapability("autoAcceptAlerts", "true");
            //cap.setCapability(MobileCapabilityType.NO_RESET,"true");
            cap.setCapability("appPackage", "com.belwith.pdqsmart");
            cap.setCapability("appActivity", "com.belwith.securemotesmartapp.main.SplashScreen");
            //cap.setCapability("appWaitDuration","10000");
            //cap.setCapability("appWaitActivity", "*");
            //cap.setCapability("appWaitActivity", "*");

            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            this.driver = new AndroidDriver<>(url, cap);

        } catch (Exception exp) {
            System.out.println("the Cause is : " + exp.getCause());
            System.out.println("the message is :" + exp.getLocalizedMessage());
            exp.printStackTrace();
        }
    }

    //@Test
    //public void logTest() {
        //System.out.println("PDQ Core Test :... Start");
        //this.driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        //MobileElement accessRequestButton = (MobileElement) this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button"));
        //accessRequestButton.click();
    //}

    @AfterMethod
    public void tearDown () {
        System.out.println("Killing Appium Instance");
        this.driver.quit();
    }
}

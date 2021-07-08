package android.testCases;

import android.pageObjects.LockPage;
import android.pageObjects.LoginPage;
import android.pageObjects.UsersRowPage;
import bases.Base;
import com.utils.Data;
import com.utils.Locators;
import com.utils.Properties;

import org.testng.annotations.*;

public class VerifyLogin extends Base {
    private LoginPage loginPage;
    private LockPage lockPage;
    private UsersRowPage usersRowPage;

    @BeforeClass(alwaysRun = true)
    public void testLoginStart()  {
        this.loginPage = new LoginPage(this.driver);
        this.lockPage = new LockPage(this.driver);
        this.usersRowPage = new UsersRowPage(this.driver);

    }

    @Test
    public void tc_LoginApp() throws InterruptedException {
            loginPage.loginFlow();
            lockPage.lockUnlockFlow();
            lockPage.navigatingToUsersRowPage();
            usersRowPage.deleteUserFLow();
    }

   //@AfterMethod
    public void testFinish() {
        this.tearDown();
    }
}

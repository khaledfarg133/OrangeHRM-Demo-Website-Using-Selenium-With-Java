package testCases;

import Base.BaseTest;
import Pages.DashboardPage;
import Pages.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginPageTests extends BaseTest {


    @Test

    public void testsuccesslogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAccount("Admin", "admin123");
        //To Be Sure that the Dashboard page was opened successfully
        //assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com");
        DashboardPage dashboardPage = loginPage.clickLoginButton();
        assertTrue(dashboardPage.checkDashboardIcon());
    }


    @Test

    public void testInvalidUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAccount("Adn", "admin123");
        DashboardPage dashboardPage = loginPage.clickLoginButton();
        assertTrue(loginPage.invalidErrorMessageVisible());
    }

    @Test

    public void testInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAccount("Admin", "123");
        DashboardPage dashboardPage = loginPage.clickLoginButton();
        assertTrue(loginPage.invalidErrorMessageVisible());
    }

    @Test

    public void testEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAccount("Admin", "");
        DashboardPage dashboardPage = loginPage.clickLoginButton();
        assertTrue(loginPage.isRequiredErrorMessageVisible());
    }

    @Test

    public void testEmptyUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAccount("", "admin123");
        DashboardPage dashboardPage = loginPage.clickLoginButton();
        assertTrue(loginPage.isRequiredErrorMessageVisible());

    }

    @Test

    public void testEmptyUsernameAndPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAccount("", "");
        DashboardPage dashboardPage = loginPage.clickLoginButton();
        assertTrue(loginPage.isRequiredErrorMessageVisible());
    }

}




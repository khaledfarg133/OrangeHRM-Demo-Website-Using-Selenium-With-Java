package testCases;

import Base.BaseTest;
import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.Recruitment;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DashboardTests extends BaseTest{

    @Test

    public void testSuccessRecruitment() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAccount("Admin", "admin123");
        DashboardPage dashboardPage = loginPage.clickLoginButton();
        DashboardPage dashboardPage0 = new DashboardPage(driver);
        Recruitment recruitmentpage = dashboardPage0.clickRecruitment();
        assertTrue(recruitmentpage.checkRecruitmentIcon());
    }
}

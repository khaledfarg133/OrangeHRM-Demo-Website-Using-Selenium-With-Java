package testCases;

import Base.BaseTest;
import Pages.AddCandidateFromRecruitmentPage;
import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.Recruitment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class RecruitmentTests extends BaseTest {


@BeforeMethod
public void testsuccesslogin() {
    LoginPage loginPage0 = new LoginPage(driver);
    loginPage0.loginAccount("Admin", "admin123");
    LoginPage loginPage1 = new LoginPage(driver);
    DashboardPage dashboardPage = loginPage1.clickLoginButton();
    assertTrue(dashboardPage.checkDashboardIcon());
}

    @Test
    public void TransferToTheRecruitmentPage() {

        DashboardPage dashboardPage0 = new DashboardPage(driver);
        Recruitment recruitmentpage = dashboardPage0.clickRecruitment();

    }

    @Test

    public void ClickingOnAddingButton () {
        DashboardPage dashboardPage0 = new DashboardPage(driver);
        Recruitment recruitmentpage = dashboardPage0.clickRecruitment();
        Recruitment recruitmentpage0 = new Recruitment(driver);
        AddCandidateFromRecruitmentPage addCandidateFromRecruitmentPage = recruitmentpage0.clickAddFromRecruitment();
        assertTrue(addCandidateFromRecruitmentPage.checkAddCandidateIcon());

    }
    @Test

    public void FillAddingDataAndClickSave() {
        DashboardPage dashboardPage0 = new DashboardPage(driver);
        Recruitment recruitmentpage = dashboardPage0.clickRecruitment();
        Recruitment recruitmentpage0 = new Recruitment(driver);
        AddCandidateFromRecruitmentPage addCandidateFromRecruitmentPage = recruitmentpage0.clickAddFromRecruitment();
        AddCandidateFromRecruitmentPage addCandidateFromRecruitmentPage0 = new AddCandidateFromRecruitmentPage(driver);
        addCandidateFromRecruitmentPage0.addCandidateData("khaled13","Ahmed13","admin@example.com");
        AddCandidateFromRecruitmentPage addCandidateFromRecruitmentPage1 = new AddCandidateFromRecruitmentPage(driver);
        Recruitment recruitment = addCandidateFromRecruitmentPage1.clickSaveFromRecruitment() ;
        AddCandidateFromRecruitmentPage addCandidateFromRecruitmentPage2 = new AddCandidateFromRecruitmentPage(driver);
        assertTrue(addCandidateFromRecruitmentPage2.checkAddingDataSuccessfully());

    }
    @Test
    public void BackToTheRecruitmentPage() {
        DashboardPage dashboardPage0 = new DashboardPage(driver);
        Recruitment recruitmentpage = dashboardPage0.clickRecruitment();
        Recruitment recruitmentpage0 = new Recruitment(driver);
        AddCandidateFromRecruitmentPage addCandidateFromRecruitmentPage = recruitmentpage0.clickAddFromRecruitment();
        AddCandidateFromRecruitmentPage addCandidateFromRecruitmentPage0 = new AddCandidateFromRecruitmentPage(driver);
        addCandidateFromRecruitmentPage0.addCandidateData("khaled3","Ahmed3","admin@example.com");
        AddCandidateFromRecruitmentPage addCandidateFromRecruitmentPage1 = new AddCandidateFromRecruitmentPage(driver);
        Recruitment recruitment = addCandidateFromRecruitmentPage1.clickSaveFromRecruitment() ;
        Recruitment recruitment0 = new Recruitment(driver);
        recruitment0.clickCandidatesFromRecruitment();
        Recruitment recruitment1 = new Recruitment(driver);
        assertTrue(recruitment1.checkResetButtonFoundIcon());
    }

    @Test
    public void SearchingValidData() {
        DashboardPage dashboardPage0 = new DashboardPage(driver);
        Recruitment recruitmentpage = dashboardPage0.clickRecruitment();
        Recruitment recruitmentpage0 = new Recruitment(driver);
        Recruitment recruitment1 = new Recruitment(driver);
        recruitment1.addKeywords("khaled3Ahmed3");
        Recruitment recruitment2 = new Recruitment(driver);
        recruitment2.clickSearchFromRecruitment();
        Recruitment recruitment3 = new Recruitment(driver);
        assertTrue(recruitment3.checkResetButtonFoundIcon());
    }
    @Test
    public void SearchingInvalidData() {
        DashboardPage dashboardPage0 = new DashboardPage(driver);
        Recruitment recruitmentpage = dashboardPage0.clickRecruitment();
        Recruitment recruitmentpage0 = new Recruitment(driver);
        Recruitment recruitment1 = new Recruitment(driver);
        recruitment1.addKeywords("dd");
        Recruitment recruitment2 = new Recruitment(driver);
        recruitment2.clickSearchFromRecruitment();
        Recruitment recruitment3 = new Recruitment(driver);
        assertTrue(recruitment3.checkTableIcon());
    }

    @AfterMethod
    public void logOutAccount(){
        driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();

    }

}

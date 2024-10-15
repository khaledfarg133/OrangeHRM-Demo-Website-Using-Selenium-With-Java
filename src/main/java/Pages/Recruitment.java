package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Recruitment {

     WebDriver driver ;

    public Recruitment(WebDriver driver){
        this.driver = driver ;

    }


    //Web Elements
    By ADDButton = By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary']");

    //Methods

    private By recruitmentIcon = By.xpath("//h6[text()='Recruitment']");

    public boolean checkRecruitmentIcon() {
        return driver.findElement(recruitmentIcon).isDisplayed();
    }

    public AddCandidateFromRecruitmentPage clickAddFromRecruitment(){
        driver.findElement(ADDButton).click();
        return new AddCandidateFromRecruitmentPage(driver);
    }

    //Web Elements

    By Candidates = By.cssSelector(".oxd-topbar-body-nav-tab.--visited");

    //Methods

    public Recruitment clickCandidatesFromRecruitment(){
        driver.findElement(Candidates).click();
        return new Recruitment(driver);
    }

    //Web Elements

    By KeywordsName = By.cssSelector("input[placeholder='Enter comma seperated words...']");
    By SearchButton = By.cssSelector("button[type='submit']");

    //Methods

    public void addKeywords(String candidatename){
        driver.findElement(KeywordsName).sendKeys(candidatename);
    }

    public void clickSearchFromRecruitment(){
        driver.findElement(SearchButton).click();
        //return new AddCandidateFromRecruitmentPage(driver);
    }


    private By ResetButton = By.xpath("//button[normalize-space()='Reset']");
    public boolean checkResetButtonFoundIcon() {
        return driver.findElement(ResetButton).isDisplayed();
    }

    private By Notfound = By.xpath("//span[normalize-space()='No Records Found']");
    public boolean checkTableIcon() {
        return driver.findElement(Notfound).isDisplayed();
    }

}

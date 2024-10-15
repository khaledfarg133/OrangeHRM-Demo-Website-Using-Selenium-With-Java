package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCandidateFromRecruitmentPage {

    WebDriver driver ;

    public AddCandidateFromRecruitmentPage(WebDriver driver){
        this.driver = driver ;

    }




    //Web Elements
    private By addcandidateIcon = By.xpath("//h6[text()='Add Candidate']");
    //Methods
    public boolean checkAddCandidateIcon() {
        return driver.findElement(addcandidateIcon).isDisplayed();
    }
    //Web Elements
    By SaveButton = By.cssSelector("button[type='submit']");
    //Methods
    public Recruitment clickSaveFromRecruitment(){
        driver.findElement(SaveButton).click();
        return new Recruitment(driver);
    }
    //Web Elements
    By SuccessAdding = By.cssSelector("form[class='oxd-form'] h6[class='oxd-text oxd-text--h6 orangehrm-main-title']");
    //Methods
    public boolean checkAddingDataSuccessfully() {
        return driver.findElement(SuccessAdding).isDisplayed();
    }
    //Web Elements

    By FirstNameFiled = By.cssSelector("input[placeholder='First Name']");
    By LastNameFiled = By.cssSelector("input[placeholder='Last Name']");
    By Email = By.xpath("(//input[@placeholder='Type here'])[1]");
    By Keywords = By.cssSelector("input[placeholder='Enter comma seperated words...']");
//    By requiredErrorMessage = By.cssSelector("span.oxd-input-field-error-message");





    //Methods


    public void addCandidateData(String firstname,String lastname,String email){
        // wait.until(ExpectedConditions.visibilityOfElementLocated(userNameFiled));
        driver.findElement(FirstNameFiled).sendKeys(firstname);
        driver.findElement(LastNameFiled).sendKeys(lastname);
        driver.findElement(Email).sendKeys(email);
        driver.findElement(Keywords).sendKeys(firstname+lastname);

        // driver.findElement(loginButton).click();
    }
}

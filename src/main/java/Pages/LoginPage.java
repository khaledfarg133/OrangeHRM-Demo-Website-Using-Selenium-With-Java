package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage {

     WebDriver driver ;
     WebDriverWait wait ;

    public LoginPage(WebDriver driver){

        this.driver = driver ;

    }
    //Web Elements

     By userNameFiled = By.cssSelector("input[name='username']");
     By passwordFiled = By.cssSelector("input[type='password']");
     By loginButton = By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button");
     By invalidErrorMessage = By.xpath("//p[contains(.,'credentials')]");
     By requiredErrorMessage = By.cssSelector("span.oxd-input-field-error-message");





    //Methods


    public void loginAccount(String username,String Password){
       // wait.until(ExpectedConditions.visibilityOfElementLocated(userNameFiled));
        driver.findElement(userNameFiled).sendKeys(username);
        driver.findElement(passwordFiled).sendKeys(Password);
       // driver.findElement(loginButton).click();
    }
    public void logOutAccount(){
       // driver.findElement(By.xpath("//a[@href='/auth/logout']"));
        List<WebElement> ProfilList = driver.findElements(By.cssSelector("ul[class='oxd-dropdown-menu']"));
        WebElement SignOut =ProfilList.get(4);

    }



    public DashboardPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }

    public boolean invalidErrorMessageVisible(){
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(invalidErrorMessage));
        return driver.findElement(invalidErrorMessage).isDisplayed();
    }

    public boolean isRequiredErrorMessageVisible(){
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(requiredErrorMessage));
        return driver.findElement(requiredErrorMessage).isDisplayed();
    }

    public boolean isDuplicatedRequiredErrorMessageVisible(){
        //wait.until(ExpectedConditions.visibilityOfElementLocated(requiredErrorMessage));
        List<WebElement> requiredErrorList = driver.findElements(requiredErrorMessage);
        for (int i = 0 ; i<requiredErrorList.size() ; i++){
            if(!requiredErrorList.get(i).isDisplayed()){
                return false;
                }
        }
        return true;
    }

    /*
    public void addUserName(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameFiled));
        driver.findElement(userNameFiled).sendKeys(username);
    }

    public void addPassword(String Password){
        driver.findElement(passwordFiled).sendKeys(Password);

    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
    */

 }

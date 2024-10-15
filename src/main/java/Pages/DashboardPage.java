package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
      WebDriver driver ;

    public DashboardPage(WebDriver driver){

        this.driver = driver ;
    }

    //Web Elements
    By recruitment = By.xpath("//span[text()='Recruitment']");
    //By recruitment = By.cssSelector(".oxd-main-menu-item.active");




    //Methods

    private By dashboardIcon = By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
   // private By dashboardIcon = By.cssSelector("oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module");



    public boolean checkDashboardIcon(){
        return driver.findElement(dashboardIcon).isDisplayed();
    }

    public Recruitment clickRecruitment(){
        driver.findElement(recruitment).click();
        return new Recruitment(driver);
    }


}

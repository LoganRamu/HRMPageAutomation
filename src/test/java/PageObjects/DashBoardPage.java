package PageObjects;

import WebDriverManagerPackage.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage
{
    private static DashBoardPage dashboardInstance;

    private DashBoardPage()
    {

    }
    public static DashBoardPage getInstance()
    {
        if(dashboardInstance==null)
        {
            dashboardInstance=new DashBoardPage();
        }
        return dashboardInstance;
    }

    @FindBy(linkText="Directory")
    private WebElement DIRECTORY_TAB;

    @FindBy(xpath="//a//span[text()='Timesheets']")
    private WebElement TIME_SHEET_OPTION;


    public WebElement getDIRECTORY_TAB() {
        return DIRECTORY_TAB;
    }

    public WebElement getTIME_SHEET_OPTION()
    {
        return TIME_SHEET_OPTION;
    }
}

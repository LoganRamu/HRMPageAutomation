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

    public WebElement getDIRECTORY_TAB() {
        return DIRECTORY_TAB;
    }
}

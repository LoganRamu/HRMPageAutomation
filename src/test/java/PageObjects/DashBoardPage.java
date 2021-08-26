package PageObjects;

import WebDriverManagerPackage.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage
{
    @FindBy(linkText="Directory")
public static WebElement DIRECTORY_TAB;
}

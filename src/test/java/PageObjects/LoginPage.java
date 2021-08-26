package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage
{
    @FindBy(id = "txtUsername")
    public static WebElement Username;

    @FindBy(id = "txtPassword")
    public static WebElement Password;

    @FindBy(xpath = "//input[@class='button']")
    public static WebElement Login_Button;
}

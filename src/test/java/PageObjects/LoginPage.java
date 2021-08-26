package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage
{
    /*Singleton design pattern: Lazy initialization*/
    private static LoginPage loginInstance;

    private LoginPage() {
    }

    public static LoginPage getInstance()
    {
        if(loginInstance==null)
        {
            loginInstance=new LoginPage();
        }
        return loginInstance;
    }
    @FindBy(id = "txtUsername")
    private WebElement Username;

    @FindBy(id = "txtPassword")
    private WebElement Password;

    @FindBy(xpath = "//input[@class='button']")
    private WebElement Login_Button;

    public WebElement getUsername() {
        return Username;
    }

    public WebElement getPassword() {
        return Password;
    }

    public WebElement getLogin_Button() {
        return Login_Button;
    }
}

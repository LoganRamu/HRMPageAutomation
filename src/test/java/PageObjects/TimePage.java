package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TimePage
{
    private static TimePage timePageInstance;

    private TimePage()
    {

    }

    public static TimePage getInstance()
    {
        if(timePageInstance==null)
        {
            timePageInstance=new TimePage();
        }
        return timePageInstance;

    }

    @FindBy(css="li input.ac_input")
    private WebElement ENTER_EMPLOYER_NAME;

    @FindBy(css="[id='btnView']")
    private  WebElement CLICK_VIEW_BUTTON;

    @FindBy(xpath="//div[@class='message warning']")
    private WebElement TIMESHEET_MESSAGE;

    public WebElement getENTER_EMPLOYER_NAME()
    {
        return ENTER_EMPLOYER_NAME;
    }

    public WebElement getCLICK_VIEW_BUTTON()
    {
        return CLICK_VIEW_BUTTON;
    }

    public WebElement getTIMESHEET_MESSAGE() {
        return TIMESHEET_MESSAGE;
    }
}

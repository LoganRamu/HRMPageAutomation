package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DirectoryPage
{
    private static DirectoryPage directoryPageInstance;

    private DirectoryPage()
    {

    }
    public static DirectoryPage getInstance()
    {
        if(directoryPageInstance==null)
        {
            directoryPageInstance=new DirectoryPage();
        }
        return directoryPageInstance;
    }

    @FindBy(xpath = "//label[contains(text(),'Job')]//following-sibling::*")
    private WebElement JOB_TITLE;

    @FindBy(xpath = "//p//following-sibling::input[@type='submit']")
    private WebElement SEARCH_BUTTON;

    @FindBy(xpath = "//li/b")
    private WebElement CEO_NAME;

    public WebElement getJOB_TITLE() {
        return JOB_TITLE;
    }

    public WebElement getSEARCH_BUTTON() {
        return SEARCH_BUTTON;
    }

    public WebElement getCEO_NAME() {
        return CEO_NAME;
    }
}

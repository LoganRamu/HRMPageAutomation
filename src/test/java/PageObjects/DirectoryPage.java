package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DirectoryPage
{
    @FindBy(xpath = "//label[contains(text(),'Job')]//following-sibling::*")
    public static WebElement JOB_TITLE;

    @FindBy(xpath = "//p//following-sibling::input[@type='submit']")
    public static WebElement SEARCH_BUTTON;

    @FindBy(xpath = "//li/b")
    public static WebElement CEO_NAME;
}

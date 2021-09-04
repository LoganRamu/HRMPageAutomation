package Step_Def;

import PageObjects.DashBoardPage;
import PageObjects.DirectoryPage;
import PageObjects.TimePage;
import WebDriverManagerPackage.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bouncycastle.asn1.x509.Time;
import org.junit.Assert;

public class Verify_Pending_Timesheets_Step_def {

    private static final Logger LOGGER= LogManager.getLogger(Verify_Pending_Timesheets_Step_def.class);
    @Given("user is on home page")
    public void user_is_on_home_page() {

        try {
            String url = DriverManager.getDriver().getCurrentUrl();
            if(url.contains("dashboard"))
            {
                LOGGER.info("User is on Home page");
            }
            else {
                DirectoryPage.getInstance().getDASHBOARD_TAB().click();
                LOGGER.info("User navigated to Home page");
            }
        }
        catch(Exception e)
        {
            LOGGER.error(e);
            Assert.fail(e.getMessage());
        }

    }

    @Given("the user clicks on the timesheet option from menu")
    public void the_user_clicks_on_the_timesheet_option_from_menu() {
        try
        {
            DashBoardPage.getInstance().getTIME_SHEET_OPTION().click();
            LOGGER.info("User is on Time page");
        }
        catch(Exception e)
        {
            LOGGER.error(e);
            Assert.fail(e.getMessage());
        }
    }

    @Given("user enters the name as {string}")
    public void user_enters_the_name_as(String EmployerName) {
       try
       {
           TimePage.getInstance().getENTER_EMPLOYER_NAME().sendKeys(EmployerName);
           LOGGER.info("User Enters employee name");

       }
       catch (Exception e)
       {
           LOGGER.error(e);
           Assert.fail(e.getMessage());
       }
    }

    @Given("user clicks on view button")
    public void user_clicks_on_view_button() {
        try
        {
            TimePage.getInstance().getCLICK_VIEW_BUTTON().click();
            LOGGER.info("user clicks on view button");
        }catch (Exception e)
        {
            LOGGER.error(e);
            Assert.fail(e.getMessage());
        }
    }

    @Then("user should see the message as {string}")
    public void user_should_see_the_message_as(String expectedMessage) {
        try
        {
            String actualMessage=TimePage.getInstance().getTIMESHEET_MESSAGE().getText();
            Assert.assertEquals(expectedMessage,actualMessage);
           LOGGER.info("TimeSheet details viewed successfully");
        }
        catch (Exception e)
        {
            LOGGER.error(e);
            Assert.fail(e.getMessage());
        }
    }
}

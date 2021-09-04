package Step_Def;

import ConstantsPackage.Constants;
import PageObjects.DashBoardPage;
import PageObjects.DirectoryPage;
import PageObjects.LoginPage;
import WebDriverManagerPackage.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Verify_CEOname_Step_Def {

    public static final Logger LOGGER = LogManager.getLogger(Verify_CEOname_Step_Def.class);

    @Given("User Logged in successfully on app")
    public void user_logged_in_successfully_on_app() {

        try {


            DriverManager.getDriver().get(Constants.APP_URL);
            LoginPage.getInstance().getUsername().sendKeys(Constants.USERNAME);
            LoginPage.getInstance().getPassword().sendKeys(Constants.PASSWORD);
            LoginPage.getInstance().getLogin_Button().click();

            String currentURL = DriverManager.getDriver().getCurrentUrl();
            if (currentURL.contains("dashboard")) {
                LOGGER.info("Successfully Login");
            }
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @When("User click director option from Menu bar")
    public void user_click_director_option_from_menu_bar() {

        try {
            DashBoardPage.getInstance().getDIRECTORY_TAB().click();
            LOGGER.info("User click director option from Menu bar");
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @When("the user select {string} from the dropdown")
    public void the_user_select_from_the_dropdown(String jobTitle) {

        try {
            Select select = new Select(DirectoryPage.getInstance().getJOB_TITLE());
            select.selectByVisibleText(jobTitle);
            LOGGER.info(select.getFirstSelectedOption() + "Job Title Selected from the dropdown");
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
    @When("click the search button")
    public void click_the_search_button() {

        try {
            DirectoryPage.getInstance().getSEARCH_BUTTON().click();
            LOGGER.info("User clicked the search button");

        } catch (Exception e) {
            LOGGER.error(e);
            Assert.fail(e.getMessage());
        }
    }

    @Then("user should see the CEO name {string}")
    public void user_should_see_the_ceo_name(String expectedName) {

        String actualName = DirectoryPage.getInstance().getCEO_NAME().getText();
        Assert.assertEquals(expectedName, actualName);
        /*try {
            String actualName = DirectoryPage.getInstance().getCEO_NAME().getText();
            Assert.assertEquals(expectedName, actualName);
            LOGGER.info("CEO Name fetched correctly");
        } catch (Exception e) {
            LOGGER.error(e);
            Assert.fail(e.getMessage());
        }*/
    }
}

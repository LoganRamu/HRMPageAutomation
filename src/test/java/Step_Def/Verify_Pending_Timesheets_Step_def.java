package Step_Def;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Verify_Pending_Timesheets_Step_def {
    @Given("user is on home page")
    public void user_is_on_home_page() {
        System.out.println("user is on home page");
    }

    @Given("the user clicks on the timesheet option from menu")
    public void the_user_clicks_on_the_timesheet_option_from_menu() {
        System.out.println("the user clicks on the timesheet option from menu");
    }

    @Given("user enters the name as {string}")
    public void user_enters_the_name_as(String string) {
        System.out.println("user enters the name as {string}");
    }

    @Given("user clicks on view button")
    public void user_clicks_on_view_button() {
        System.out.println("user clicks on view button");
    }

    @Then("user should see the message as {string}")
    public void user_should_see_the_message_as(String string) {
        System.out.println("user should see the message as {string}");
    }
}

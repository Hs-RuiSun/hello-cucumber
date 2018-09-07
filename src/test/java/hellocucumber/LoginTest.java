package hellocucumber;

import com.cgi.action.LoginAction;
import com.cgi.action.UserType;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    @Given("^I am on the login page$")
    public void i_am_on_the_login_page() throws Exception {
        LoginAction.setup();
    }
    
    @When("^I login using \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_login_using_and(String username, String password) throws Exception {
        LoginAction.attempLogin(username, password);
    }

    @Then("^I should be on the \"([^\"]*)\" home page$")
    public void i_should_be_on_the_home_page(UserType userType) throws Exception {
        assertEquals(true, LoginAction.verifyLogin(userType));
    }
}

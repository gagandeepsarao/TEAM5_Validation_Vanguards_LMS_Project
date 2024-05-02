package step_definitions;

import app_hooks.AppHooks;
import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.LoginValidation_Page;

import org.testng.asserts.*;
import static org.testng.AssertJUnit.assertEquals;
import com.aventstack.extentreports.util.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class LoginValidation_Step {

	private final static Logger LOG= LogManager.getLogger(LoginValidation_Step.class);
//	@Given("Admin is in Home Page")
//	public void admin_is_in_home_page() {
//		AppHooks.getInstance().getDriver().get(Constants.URL);
//	}
	@When("Admin clicks login button with invalid credentials username and password")
	public void admin_clicks_login_button_with_invalid_credentials_username_and_password() {
		LoginValidation_Page.getInstance().clickafterGivingInvalidCredentials();
		LoginValidation_Page.getInstance().clickLoginButton();
	}
	  @Then("An Error message is displayed {string}") public void
	  an_error_message_is_displayed(String string) {
	  String actualErrorMessage = LoginValidation_Page.getInstance().geterrorMessage();
	  assertEquals(actualErrorMessage,string);
	  }
	  @When("Admin clicks login button after entering username and password field empty"
	  ) public void
	  admin_clicks_login_button_after_entering_username_and_password_field_empty()
	  {
		  LoginValidation_Page.getInstance().clickWithoutGivingUserNameAndPassword();
		  LoginValidation_Page.getInstance().clickLoginButton();
	  }
	  @Then("Admin should get an Error message {string}") public void
	  admin_should_get_an_error_message(String string) {
	  String actualErrorMessage =LoginValidation_Page.getInstance().usernameGetAttribute(); String
	  expectedErrorMessage = "Please fill out this field.";
	  assertEquals("Error message does not match", expectedErrorMessage,
	  actualErrorMessage);
	  LOG.info("Expected error message: '{}', Actual error message: '{}'",
	  expectedErrorMessage, actualErrorMessage);
	  }
	  @When("Admin clicks login button by entering only the password and username blank"
	  ) public void
	  admin_clicks_login_button_by_entering_only_the_password_and_username_blank()
	  {
		  LoginValidation_Page.getInstance().clickWithoutGivingUsername();
		  LoginValidation_Page.getInstance().clickLoginButton(); }
	  @Given("The admin is on Home page") public void the_admin_is_on_home_page() {
	  AppHooks.getInstance().getDriver().get(Constants.URL);
	  }
	  @When("The admin enters {string}, and {string}") public void
	  the_admin_enters_and(String string, String string2) {
		  LoginValidation_Page.getInstance().clickafterGivingInvalidCredentials(string, string2);
		  LoginValidation_Page.getInstance().clickLoginButton();
	  }
	  @When("The admin clicks on the login button") public void
	  the_admin_clicks_on_the_login_button() {
		  LoginValidation_Page.getInstance().clickLoginButton(); }
	  @Then("the user should see the error message indicating \"\"Invalid username and password Please try again\"\"")
	  public void the_user_should_see_the_error_message_indicating_Invalid_username_and_password_please_try_again() {
		 
	//  Login.getInstance().clickafterGivingInvalidCredentials();
	//  String actualErrorMessage =Login.getInstance().usernameGetAttribute();
	//  assertEquals(actualErrorMessage, string);
	//  LOG.info("Error is printed");
		  LoginValidation_Page.getInstance().clickafterGivingInvalidCredentials();
	  String actualErrorMessage =LoginValidation_Page.getInstance().geterrorMessage();
	  String expectedErrorMessage = "Invalid username and password Please try again";
	  assertEquals("Error message does not match", expectedErrorMessage,
	  actualErrorMessage);
	  LOG.info("Expected error message: '{}', Actual error message: '{}'",
	  expectedErrorMessage, actualErrorMessage);
	  }
	  @Then("the user should see the error message indicating \"\"Please enter username and password in correct format\"\"")
	  public void the_user_should_see_the_error_message_indicating_please_enter_username_and_password_in_correct_format() {
	  String actualErrorMessage = LoginValidation_Page.getInstance().geterrorMessage();
	  String expectedErrorMessage="Please enter valid username and password";
	  assertEquals("Error message does not match", expectedErrorMessage,
	  actualErrorMessage);
	  LOG.info("Expected error message: '{}', Actual error message: '{}'",
	  expectedErrorMessage, actualErrorMessage); }
	  @Then("the user should see the error message indicating \"\"Invalid password Please try again\"\"")
	  public void the_user_should_see_the_error_message_indicating_Invalid_password_please_try_again() {
	  String actualErrorMessage =LoginValidation_Page.getInstance().usernameGetAttribute(); String
	  expectedErrorMessage = "Invalid username and password. Please try again.";
	  assertEquals("Error message does not match", expectedErrorMessage,
	  actualErrorMessage);
	  LOG.info("Expected error message: '{}', Actual error message: '{}'",
	  expectedErrorMessage, actualErrorMessage);
	  }
	  @Then("the user should see the error message indicating \"\"Please enter the username in correct format\"\"")
	  public void the_user_should_see_the_error_message_indicating_please_enter_the_username_in_correct_format() {
	  String actualErrorMessage =LoginValidation_Page.getInstance().usernameGetAttribute(); String
	  expectedErrorMessage = "Please enter the username in correct format";
	  assertEquals("Error message does not match", expectedErrorMessage,
	  actualErrorMessage);
	  LOG.info("Expected error message: '{}', Actual error message: '{}'",
	  expectedErrorMessage, actualErrorMessage);
	  }
	  @Then("the user should see the error message indicating \"\"The password is incorrect Please try again\"\"")
	  public void the_user_should_see_the_error_message_indicating_the_password_is_incorrect_please_try_again() {
		  LoginValidation_Page.getInstance().pswdGetAttribute();
		  LoginValidation_Page.getInstance().clickLoginButton(); }
	  @Then("the user should see the error message indicating \"\"Please fill out this field.{string}")
	  public void the_user_should_see_the_error_message_indicating_please_fill_out_this_field(String string) {
	  String actualErrorMessage =LoginValidation_Page.getInstance().usernameGetAttribute();
	  String expectedErrorMessage="Please enter your username and password";
	  assertEquals("Error message does not match", expectedErrorMessage,
	  actualErrorMessage);
	  LOG.info("Expected error message: '{}', Actual error message: '{}'",
	  expectedErrorMessage, actualErrorMessage);
	  }
	  @When("Admin clicks login button after giving correct {string} and {string}")
	  public void admin_clicks_login_button_after_giving_correct_and(String string,
	  String string2) {
		  LoginValidation_Page.getInstance().CorrectCredentials();
		  LoginValidation_Page.getInstance().clickLoginButton(); }
//	  @Then("Admin should land on dashboard page") public void
//	  admin_should_land_on_dashboard_page() {
//		  LoginValidation_Page.getInstance().checkTitleOfPage("LMS"); }
	  @When("Admin enter valid credentials  and clicks login button through keyboard"
	  ) public void
	  admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() {
		  LoginValidation_Page.getInstance().LoginByKeyBoard();
	  }
	  @When("Admin enter valid credentials  and clicks login button through mouse")
	  public void
	  admin_enter_valid_credentials_and_clicks_login_button_through_mouse() {
		  LoginValidation_Page.getInstance().clickafterGivingValidCredentials();
		  LoginValidation_Page.getInstance().clickLoginButtonByMouse();
	  } 
}
 
 
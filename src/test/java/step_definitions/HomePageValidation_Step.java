
package step_definitions;
import app_hooks.AppHooks;
import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.testng.AssertJUnit.assertEquals;
import com.aventstack.extentreports.util.Assert;
import pages.LoginValidation_Page;
import org.testng.asserts.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import utilities.Logger_Load;
import pages.HomePageValidation_Page;


public class HomePageValidation_Step {
	
	HomePageValidation_Page homepg = new HomePageValidation_Page();
	
	@Given("Admin Launch the Browser")
	public void admin_launch_the_browser() {
	    
		AppHooks.getInstance().getDriver().get(Constants.URL);
		// Logger_Load.info("Admin Launch the Browser");
	}

	@When("Admin gives the LMS portal URL")
	public void admin_gives_the_lms_portal_url() {
	    
		homepg.url();
	}

	@Then("Admin should be able to land on the LMS homepage")
	public void admin_should_be_able_to_land_on_the_lms_homepage() {
		
		 Logger_Load.info("Admin is on LMS Home Page");
	}

	@When("Admin gives the incorrect LMS portal URL")
	public void admin_gives_the_incorrect_lms_portal_url() {
	   
		homepg.invalid_url();
	}

	@Then("The admin lands on home page with invalid URL")
	public void the_admin_lands_on_home_page_with_invalid_url() {
		
		homepg.invalidURLstatus();
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
		
		homepg.url();
	}

	@Then("The admin to verify that if  the link is broken")
	public void the_admin_to_verify_that_if_the_link_is_broken() {


		homepg.broken_links();
	}

	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {

		homepg.spellCheckForElements();
	}

	@When("Admin launched the browser")
	public void admin_launched_the_browser() {

homepg.url();
	}

	  
	

	@Then("Admin should verify the logo is on the left  side")
	public void admin_should_verify_the_logo_is_on_the_left_side() {
		homepg.verifylogoAlignmentAndPosition();
}

	@Then("Admin should be to able to verify application name")
	public void admin_should_be_to_able_to_verify_application_name() {
		
		homepg.isCompanyLogoDisplayed();
	}

	@Then("Admin should be able to verify the company name below the app name")
	public void admin_should_be_able_to_verify_the_company_name_below_the_app_name() {
	    
		homepg.isCompanyLogoDisplayed();
	}

	@Then("Admin should validate the sign in content")
	public void admin_should_validate_the_sign_in_content() {


		homepg. isSignInContentDisplayed();
	}

	@Then("Admin should verify that text field is present")
	public void admin_should_verify_that_text_field_is_present() {
		
		homepg.textCheck(2);
	}

	@Then("Admin should verify that the word {string} in the first text field")
	public void admin_should_verify_that_the_word_in_the_first_text_field(String string) {
	   
		homepg.WordCheckUser("username");
		
	}

	@Then("Admin should verify that the symbol asterik is next to user text")
	public void admin_should_verify_that_the_symbol_asterik_is_next_to_user_text() {
	   
		homepg.verifyAsteriskNextToUser("*");
	}

	@Then("Admin should verify in the second text field the word {string}")
	public void admin_should_verify_in_the_second_text_field_the_word(String string) {

		homepg.textCheckPswd("password");
		
	}

	@Then("Admin should to verify asterik next to password text")
	public void admin_should_to_verify_asterik_next_to_password_text() {

		homepg.verifyAsteriskNextToUser("*");
	
	}

	@Then("Admin should be able to verify the alignment input field for the login")
	public void admin_should_be_able_to_verify_the_alignment_input_field_for_the_login() {

		homepg.centrepage();
		
	}

	@Then("Admin should be able to verify that Login button is present")
	public void admin_should_be_able_to_verify_that_login_button_is_present() {

			homepg.centreloginbtn();
	}

	@Then("Admin should be able to verify the alignment of the login button")
	public void admin_should_be_able_to_verify_the_alignment_of_the_login_button() {


		homepg.centreloginbtn();
	}

	@Then("Admin is able to verify the input descriptive test in user field")
	public void admin_is_able_to_verify_the_input_descriptive_test_in_user_field() {

		homepg.centrepage();
	}

	@Then("Admin should be able to verify input descriptive test in password field")
	public void admin_should_be_able_to_verify_input_descriptive_test_in_password_field() {


		
		homepg.centrepage();
	}



}
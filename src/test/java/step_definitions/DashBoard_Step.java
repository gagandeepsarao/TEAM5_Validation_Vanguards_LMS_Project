package step_definitions;

import app_hooks.AppHooks;
import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginValidation_Page;
import pages.Dashboard_Page;
import pages.HomePageValidation_Page;
import pages.LoginPage;
import pages.Common;


public class DashBoard_Step {

 
	
//	@Given("Admin is in Home page")
//	public void admin_is_in_home_page() {
//		AppHooks.getInstance().getDriver().get(Constants.URL);
//	}

//	@When("Admin enter valid credentials to login")
//	public void admin_enter_valid_credentials_to_login() {
//		
//	 LoginValidation_Page.getInstance().clickafterGivingValidCredentials();
//	 LoginValidation_Page.getInstance().clickLoginButton();
//	}

	
	@When("The admin is on dashboard page")
	public void the_admin_is_on_dashboard_page() {
	  
		
		Dashboard_Page.getInstance().DashboardPageVerification();
	}

	@Then("The admin should be able to see the heading Manage Program on the Dashboard Page")
	public void the_admin_should_be_able_to_see_the_heading_manage_program_on_the_dashboard_page() {
	  	
		//commonPage.CheckPageHeading("Manage Program");
		Dashboard_Page.getInstance().Header();
	}

	@Then("The admin is able to verify the response time")
	public void the_admin_is_able_to_verify_the_response_time() {

		Dashboard_Page.getInstance().MillisecBtnChk_Login();

	}

	@Then("Admin should verify the LMS- Learning Management System is on the left  side")
	public void admin_should_verify_the_lms_learning_m_anagement_system_is_on_the_left_side() {

		Dashboard_Page.getInstance().LMS_titleLocationLeft();
	}

	@Then("Admin should be to able to verify LMS as title")
	public void admin_should_be_to_able_to_verify_lms_as_title() {

	
	}

	@Then("Validate navigation bar text")
	public void validate_navigation_bar_text() {

		Dashboard_Page.getInstance().validateButtonAlignment();
	}

	@Then("Admin should see correct spelling in navigation bar text {string}")
	public void admin_should_see_correct_spelling_in_navigation_bar_text(String string) {

		//Dashboard_Page.getInstance().LMS_title("LMS");
		Dashboard_Page.getInstance().spellcheck();
	}

	@Then("Admin should see correct spelling and space in LMS title {string}")
	public void admin_should_see_correct_spelling_and_space_in_lms_title(String string) {

		//Dashboard_Page.getInstance().spellcheck();
		Dashboard_Page.getInstance().LMS_title("LMS - Learning Management System");

	}

	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {

		Dashboard_Page.getInstance().validateButtonAlignment();
	}

	@Then("Admin should see program in the 1st place")
	public void admin_should_see_program_in_the_1st_place() {

		Dashboard_Page.getInstance().validateButtonOrder(1);

	}

	@Then("Admin should see batch in the 2nd place")
	public void admin_should_see_batch_in_the_2nd_place() {

		Dashboard_Page.getInstance().validateButtonOrder(2);
		
	}

	@Then("Admin should see student in the 3rd user")
	public void admin_should_see_student_in_the_3rd_user() {

		Dashboard_Page.getInstance().validateButtonOrder(3);
	}

	@Then("Admin should see student in the 4th logout")
	public void admin_should_see_student_in_the_4th_logout() {

		Dashboard_Page.getInstance().validateButtonOrder(4);
		

	}



}

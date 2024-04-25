package step_definitions;

import app_hooks.AppHooks;
import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class Login {
	
	@Given("Admin is in Home Page")
	public void admin_is_in_home_page() {
		 AppHooks.getInstance().getDriver().get(Constants.URL);
		
	}

	@When("Admin enter valid credentials and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() {
		LoginPage.getInstance().enterusername();
		LoginPage.getInstance().enterpassword();
		LoginPage.getInstance().clickLoginBtn();
	}

	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {
		
		LoginPage.getInstance().checkTitleOfPage("LMS");
	   
	}

}

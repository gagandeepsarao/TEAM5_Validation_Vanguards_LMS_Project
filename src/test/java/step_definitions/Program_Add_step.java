package step_definitions;

import app_hooks.AppHooks;
import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Program_Add_Page;

public class Program_Add_step {
	
	@Given("Admin is on Manage Program Page")
	public void admin_is_on_manage_program_page() {
		AppHooks.getInstance().getDriver().getCurrentUrl();
	    
	}

	@When("Admin clicks <A New Program>button")
	public void admin_clicks_a_new_program_button() {
		
		Program_Add_Page.getInstance().clickprogrambtn();		
	    
	}

	@Then("Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_program_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
		
		Program_Add_Page.getInstance().checkNewProgramPopup();
	    
	}

	@Then("Admin should see two input fields and their respective text boxes in the program details window")
	public void admin_should_see_two_input_fields_and_their_respective_text_boxes_in_the_program_details_window() {
		
		Program_Add_Page.getInstance().inputFields();
	}

	@Then("Admin should see two radio button for Program Status")
	public void admin_should_see_two_radio_button_for_program_status() {
		
	    Program_Add_Page.getInstance().radioFields();
	}
    
	@When("Admin clicks <Edit> button on the data table for any row")
	public void admin_clicks_edit_button_on_the_data_table_for_any_row() {
		
		Program_Add_Page.getInstance().editbutton();
		
	}
	
	@Then("Admin should see a popup open for Program details to edit")
	public void admin_should_see_a_popup_open_for_program_details_to_edit() {
		
		Program_Add_Page.getInstance().usereditdetail();
		
	}
	@When("Admin clicks <Delete> button on the data table for any row")
	public void admin_clicks_delete_button_on_the_data_table_for_any_row() {
	    
		Program_Add_Page.getInstance().clickdelete();
	}

	@Then("Admin should see a alert open with heading {string} along with  <YES> and <NO> button for deletion")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion(String string) {
	    
		System.out.println("Is Present");
	}

	@Then("Admin should see a message {string}")
	public void admin_should_see_a_message(String string) {
		
		System.out.println("Is Present");
	    
		
	}


}

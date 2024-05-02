package step_definitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Program_AddDetail_Page;
import pages.Program_Add_Page;
import utilities.ExcelReader;

public class Program_AddDetail_Step {

	@Then("Admin clicks a new program button in the manage program page")
	public void admin_clicks_a_new_program_button_in_the_manage_program_page() {

		Program_AddDetail_Page.getInstance().clickprogrambtn();
	}

	@Given("Admin is on {string} Popup window")
	public void admin_is_on_popup_window(String string) {

		Program_AddDetail_Page.getInstance().checkProgramdetailPopup();

	}

	@When("Admin clicks <Save>button without entering any data")
	public void admin_clicks_save_button_without_entering_any_data() {

		Program_AddDetail_Page.getInstance().savedetail();

	}
		

	@Then("Admin gets a Error message alert")
	public void admin_gets_a_error_message_alert() throws InterruptedException {

		Program_AddDetail_Page.getInstance().errorpopup();

	}
	
	
	

	@When("Admin enters only <Program Name> in text box and clicks Save button")
	public void admin_enters_only_program_name_in_text_box_and_clicks_save_button() {
		
		Program_AddDetail_Page.getInstance().protextbox();
		Program_AddDetail_Page.getInstance().savedetail();
	   
	}

	@Then("Admin gets a message alert {string}")
	public void admin_gets_a_message_alert(String string) {
		
		Program_AddDetail_Page.getInstance().alertpopup();

	}

	@When("Admin enters only<Program description> in text box and clicks Save button")
	public void admin_enters_only_program_description_in_text_box_and_clicks_save_button() {
		
		Program_AddDetail_Page.getInstance().destextbox();
		Program_AddDetail_Page.getInstance().savedetail();

	}

	@When("Admin selects only Status and clicks Save button")
	public void admin_selects_only_status_and_clicks_save_button() {
		
		Program_AddDetail_Page.getInstance().clickactivebtn();
		Program_AddDetail_Page.getInstance().savedetail();

	}

	@When("Admin enters only numbers in name and desc column and clicks Save button")
	public void admin_enters_only_numbers_in_name_and_desc_column_and_clicks_save_button() throws IllegalArgumentException {
    	
    	Program_AddDetail_Page.getInstance().nametbox();
    	Program_AddDetail_Page.getInstance().savedetail();
    	
    }

	@When("Admin click Cancel Icon on Program Detail form")
	public void admin_click_cancel_close_x_icon_on_program_detail_form() {

		Program_AddDetail_Page.getInstance().cancel();
	}

	@Then("Program Details popup window should be closed without saving")
	public void program_details_popup_window_should_be_closed_without_saving() {

		System.out.println("Window Closed");
	}

	@When("Enter all the required fields with valid values and click Save button")
	public void enter_all_the_required_fields_with_valid_values_and_click_save_button() {
		
		Program_AddDetail_Page.getInstance().protextbox();
		Program_AddDetail_Page.getInstance().destextbox();
		Program_AddDetail_Page.getInstance().clickactivebtn();
		Program_AddDetail_Page.getInstance().savedetail();

	}

	@Then("Admin gets a message {string} alert and able to see the new program added in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_the_new_program_added_in_the_data_table(String string) {
		
		System.out.println("SDET150");
		System.out.println("software testing");
		System.out.println("Active");
		

	}

	@When("Admin clicks <Cancel>button")
	public void admin_clicks_cancel_button() {
		
		Program_AddDetail_Page.getInstance().cancelbtn();

	}

	@Then("Admin can see the Program details popup disappears without creating any program")
	public void admin_can_see_the_program_details_popup_disappears_without_creating_any_program() {

		System.out.println("Program Disappears");

	}

}
package step_definitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import app_hooks.AppHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Batch_Add_Page;


public class Batch_Add_Step {

	//By namefield=By.xpath("//input[@id='batchName']");//nametextbox
	@Given("Admin checks a new pop up with Batchdetails appears")
	public void admin_checks_a_new_pop_up_with_batchdetails_appears() {
		 Batch_Add_Page.getInstance().displaypopup();
			
	
	}

	@Then("Admin should check  the pop up should include the Name and Description as text box,Program Name as drop down Status and status as radio button Number of classes as text box")
	public void admin_should_check_the_pop_up_should_include_the_name_and_description_as_text_box_program_name_as_drop_down_status_and_status_as_radio_button_number_of_classes_as_text_box() {
	
	
		 Batch_Add_Page.getInstance().popupfields();
			
	
	
	}

	@Given("Admin checks a new pop up with Batch details appears")
	public void admin_checks_a_new_pop_up_with_batch_details_appears() {
		 Batch_Add_Page.getInstance().displaypopup();
	
	}

	@When("Admin is able to Fill in all the fields except description with valid values and click save")
	public void admin_is_able_to_fill_in_all_the_fields_except_description_with_valid_values_and_click_save() {
	   
		Batch_Add_Page.getInstance().fillthefields();
	
	
	}

	@Then("The newly added batch should not be present in the data table in Manage Batch page")
	public void the_newly_added_batch_should_not_be_present_in_the_data_table_in_manage_batch_page() {
	    
	
		Batch_Add_Page.getInstance().errorfield();
	
	
	}


//scenario3
	@When("Admin is Fill in all the fields with valid values and click save")
	public void admin_is_fill_in_all_the_fields_with_valid_values_names_and_click_save() throws InterruptedException {
		//AppHooks.getInstance().getDriver().findElement(namefield).sendKeys(name);
		Batch_Add_Page.getInstance().validbatch();
	
	}

	@Then("The newly added batch should be present in the data table in Manage Batch page")
	public void the_newly_added_batch_should_be_present_in_the_data_table_in_manage_batch_page() throws InterruptedException {
	    
	
		Batch_Add_Page.getInstance().batchpresent();
	
	}

//scenario4
	@When("Check if any of the fields have invalid values")
	public void check_if_any_of_the_fields_have_invalid_values() throws InterruptedException {
	  
	
		Batch_Add_Page.getInstance().invalidfiels();
	
	
	}

	
	
	@Then("Error message should appear")
	public void error_message_should_appear() throws InterruptedException {
	
	

		Batch_Add_Page.getInstance().erromessage();
	
	
	}


	


//Scenario5

	@When ("Check any of the mandatory fields are blank")
	public void check_any_of_the_mandatory_fields_are_blank() throws InterruptedException {
		
		Batch_Add_Page.getInstance().madatoryfields();
		
		
	}

	@Then("Error message should display")
	public void error_message_should_display() {
	    
		Batch_Add_Page.getInstance().errorclass();
	
	
	}


}

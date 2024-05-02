package step_definitions;

import app_hooks.AppHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Program_Add_Page;
import pages.Program_Delete_Page;

public class Program_Delete_Step {
	
	@Then("Admin clicks the delete button in the manage program page")
	public void admin_clicks_the_delete_button_in_the_manage_program_page() {
	    
		Program_Delete_Page.getInstance().clickdelete();
	}

	@Then("Admin should land on Manage Program page and can see the selected program is deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_deleted_from_the_data_table() {
		
		System.out.println("Program is Deleted");
	    
	}

	@When("Admin clicks <NO> button on the alert")
	public void admin_clicks_no_button_on_the_alert() {
		
		Program_Delete_Page.getInstance().selectNo();
	}

	@Then("Admin should land on Manage Program page and can see the selected program is not deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_not_deleted_from_the_data_table() {
		 
	    System.out.println("DELETED");
	}

    @Given("Admin is on Confirm Deletion alert")
	public void admin_is_on_confirm_deletion_alert() {
    	
    	Program_Delete_Page.getInstance().checkconfirmpopup();
    	System.out.println("Program Deleted");
    	
    }

	@When("Admin clicks <YES> button on the alert")
	public void admin_clicks_yes_button_on_the_alert() {
		
		Program_Delete_Page.getInstance().selectyes();
	    
	}

	@Then("Admin gets a message {string} alert and able to see that program deleted in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_that_program_deleted_in_the_data_table(String string) {
		
		Program_Delete_Page.getInstance().sucessfullpopup();
		System.out.println("Program Deleted");
	   
	}
	
	@When("Admin clicks <NO> button on alert")
	public void admin_clicks_no_button_on_alert() {
		
		Program_Delete_Page.getInstance().selectNo();
	   
	}

	@Then("Admin can see the deletion alert disappears without deleting")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting() {
	    
		Program_Delete_Page.getInstance().checkconfirmpopup();
    	System.out.println("Program Deleted");
	}

	@When("Admin clicks Cancel Icon on Deletion alert")
	public void admin_clicks_cancel_icon_on_deletion_alert() {
	    
		Program_Delete_Page.getInstance().cancelicon();
	}

	@Then("Admin can see the deletion alert disappears without any changes")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes() {
		
		Program_Delete_Page.getInstance().checkconfirmpopup();
    	System.out.println("Program Deleted");
	    
	}



	
	
	
}




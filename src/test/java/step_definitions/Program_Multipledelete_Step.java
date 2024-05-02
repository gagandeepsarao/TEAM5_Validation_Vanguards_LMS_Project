package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Program_Multipledelete_Page;

public class Program_Multipledelete_Step {
	
	
	@When("Admin clicks the header check box near the Program Name title")
	public void admin_clicks_the_header_check_box_near_the_program_name_title() {
		
		Program_Multipledelete_Page.getInstance().checkbox();
	    
	}

	@Then("Admin should see all the other text box are selected for deletion")
	public void admin_should_see_all_the_other_text_box_are_selected_for_deletion() {
		
		Program_Multipledelete_Page.getInstance().allcheckbox();
		System.out.println("All Selected");
	}

	

	@When("Admin click the check box near the program name created")
	public void admin_click_the_check_box_near_the_program_name_created() {
		
		Program_Multipledelete_Page.getInstance().namecheckbox();
	    
	}

	@Then("Admin should see only the check box selected for deletion")
	public void admin_should_see_only_the_check_box_selected_for_deletion() {
		
		Program_Multipledelete_Page.getInstance().checkboxnamecreated();
		System.out.println("Only one Selected");
	    
	}




}

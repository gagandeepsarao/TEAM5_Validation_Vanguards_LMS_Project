package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Batch_Page;
import pages.Batch_DeleteAll_Page;
import utilities.Logger_Load;

public class Batch_DeleteAll_Step {


//sec1
	@Given("No checkboxes in the datatable are selected")
	public void no_checkboxes_in_the_datatable_are_selected() {
	   
	

		Batch_DeleteAll_Page.getInstance().checkboxdis();
	
	
	}

	@Then("The delete icon under the {string} header should be disabled")
	public void the_delete_icon_under_the_header_should_be_disabled(String string) {

		Batch_DeleteAll_Page.getInstance().trashiconbutton();
		
	
	
	}

//sec2
	@Given("select one of the checkbox\\/row")
	public void select_one_of_the_checkbox_row()  {
	    

		Batch_DeleteAll_Page.getInstance().siglerowdelete1();
	
	}

	@When("Click the delete icon below {string} header")
	public void click_the_delete_icon_below_header(String string) throws InterruptedException {
	   
	
		Batch_DeleteAll_Page.getInstance().singlerow2();
		
	
	}

	@Then("The respective row in the data table is deleted")
	public void the_respective_row_in_the_data_table_is_deleted() throws InterruptedException {
	   
	
	
		

		Batch_DeleteAll_Page.getInstance().singlerow3();
		}


//sce3
	@Given("Two or more checkboxes\\/row is selected")
	public void two_or_more_checkboxes_row_is_selected() {
	  
	
		Batch_DeleteAll_Page.getInstance().multipleclick();
	
	}

	@When("Click delete icon below {string} header")
	public void click_delete_icon_below_header(String string) {
	   
		
		Batch_DeleteAll_Page.getInstance().multipleclick();
		
	
	
	}

















}

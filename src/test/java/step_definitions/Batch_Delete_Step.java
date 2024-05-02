package step_definitions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import app_hooks.AppHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Batch_Page;
import pages.Batch_Delete_Page;

public class Batch_Delete_Step {






//1
	@Given("The delete icon on row level in data table is enabled")
	public void the_delete_icon_on_row_level_in_data_table_is_enabled() {
	   
		
	
	
	
	
	
	
	
		Batch_Delete_Page.getInstance().tabletrash();
	
	
	
	
	}

	@When("Admin clicks the delete icon")
	public void admin_clicks_the_delete_icon() throws InterruptedException {
		Batch_Delete_Page.getInstance().clickcheckbox();
	
	
	}

	@Then("Alert appears with yes and No option")
	public void alert_appears_with_yes_and_no_option() throws InterruptedException {
		Batch_Delete_Page.getInstance().checkalertbox();
	
	}

	
//2
	
	
	@When("You click yes option")
	public void you_click_yes_option() throws InterruptedException {
		Batch_Delete_Page.getInstance().alertyes();
	
	
	}

	@Then("Batch deleted alert pops and batch is no more available in data table")
	public void batch_deleted_alert_pops_and_batch_is_no_more_available_in_data_table() throws InterruptedException {
	    
		Batch_Delete_Page.getInstance().pop2();
	
	
	}
//scenario3
	@When("You click No option")
	public void you_click_no_option() throws InterruptedException {
	   
	
		 Batch_Delete_Page.getInstance().alertNo();
		
	
	
	
	}

	@Then("Batch is still listed in the data table")
	public void batch_is_still_listed_in_the_data_table() throws InterruptedException {
	    
	
	
		 Batch_Delete_Page.getInstance().batchpresent();
	
	
	
	}























}

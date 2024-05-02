package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProgramPage;
import pages.Common;
import pages.DataDrivenPage;
import pages.LoginPage;

public class DataDriven {

@When("Admin clicks on the button {string} in Manage Program Page")
public void admin_clicks_on_the_button_in_manage_program_page(String string) {
	DataDrivenPage.getInstance().clickaddProgramBtn();
}

@Then("Admin enters all the values and creates a program")
public void admin_enters_all_the_values_and_creates_a_program() throws Throwable {
	DataDrivenPage.getInstance().createNewProgram();
}


@When("Admin clicks {string} button and enters all the values and creates a batch")
public void admin_clicks_button_and_enters_all_the_values_and_creates_a_batch(String string) throws Throwable {

	DataDrivenPage.getInstance().createNewBatch();

}

}

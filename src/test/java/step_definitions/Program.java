package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProgramPage;
import pages.Common;

public class Program {


@Given("Admin is on dashboard page after Login")
public void admin_is_on_dashboard_page_after_login() {
	ProgramPage.getInstance().DashboardPageVerification();
	}

@When("Admin clicks {string} on the navigation bar")
public void admin_clicks_on_the_navigation_bar(String string) {
    ProgramPage.getInstance().clickProgramLink();
    

}

@Then("Admin should see URL with {string}")
public void admin_should_see_url_with(String string) {
	ProgramPage.getInstance().verifyProgramURL();
}

@Then("Admin should see a heading with text {string} on the page")
public void admin_should_see_a_heading_with_text_on_the_page(String PageHeading) {
 ProgramPage.getInstance().ManageProgram_HeadingVerification(PageHeading);   
}
@Then("Admin should see the text as {string} along with Pagination icon below the table.")
public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table(String string) {
	 ProgramPage.getInstance().paginationMessageVerification();   

}
@Then("Admin should see the footer as {string} z- Total number of records")
public void admin_should_see_the_footer_as_z_total_number_of_records(String string)  {
   ProgramPage.getInstance().ProgramFooter_MessageVerification();
   
}
@Then("Admin should see a Delete button on the top left hand side as Disabled")
public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() throws InterruptedException {
	
	   ProgramPage.getInstance().Program_CheckDeleteBtn();

}
@Then("Admin should see a {string} button on the program page above the data table")
public void admin_should_see_a_button_on_the_program_page_above_the_data_table(String string) {
	ProgramPage.getInstance().Program_CheckAddProgramBtn();
}
@Then("Admin should see the number of records \\(rows of data in the table) displayed on the page are {int}")
public void admin_should_see_the_number_of_records_rows_of_data_in_the_table_displayed_on_the_page_are(Integer int1) {
	ProgramPage.getInstance().Validate_ProgramTableRows();
}
@Then("Admin should see data table on the Manage Program Page with following column headers \\(Program Name, Program Description, Program Status, Edit,Delete)")
public void admin_should_see_data_table_on_the_manage_program_page_with_following_column_headers_program_name_program_description_program_status_edit_delete() {
	ProgramPage.getInstance().Validate_ProgramTableHeaders();
}


@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
	ProgramPage.getInstance().Validate_ProgramTable_SortIcon();
}


@Then("Admin should see check box on the left side in all rows of the data table")
public void admin_should_see_check_box_on_the_left_side_in_all_rows_of_the_data_table() {
	ProgramPage.getInstance().ValidateCheckbox_ProgramTable();
}


@Then("Admin should see the Edit and Delete buttons on each row of the data table")
public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
	ProgramPage.getInstance().ValidateEditDeleteButton_ProgramTable();
}

@Then("Admin should see Search bar with text as {string}")
public void admin_should_see_search_bar_with_text_as(String string) {
	ProgramPage.getInstance().ValidateSearchBar();
}


////	### Navigation Validation from Manage Program to other Pages ######

@Given("Admin is on Manage Program page after clicking on {string} button on navigation bar")
public void admin_is_on_manage_program_page_after_clicking_on_button_on_navigation_bar(String string) {
    ProgramPage.getInstance().clickProgramLink();
    ProgramPage.getInstance().ManageProgram_HeadingVerification("Manage Program");   


}

@When("Admin clicks on Batch link on Manage Program page")
public void admin_clicks_on_batch_link_on_manage_program_page() {
	ProgramPage.getInstance().clickBatchLink();
}

@Then("Admin is re-directed to Batch page")
public void admin_is_re_directed_to_batch_page() {
	ProgramPage.getInstance().ManageBatch_HeadingVerification("Manage Batch");
}

@When("Admin clicks on User link on Manage Program page")
public void admin_clicks_on_user_link_on_manage_program_page() {
	ProgramPage.getInstance().clickUserLink();

}

@Then("Admin is re-directed to User page")
public void admin_is_re_directed_to_user_page() {
	ProgramPage.getInstance().ManageUser_HeadingVerification("Manage User");
}

@When("Admin clicks on Logout link on Manage Program page")
public void admin_clicks_on_logout_link_on_manage_program_page() {
	ProgramPage.getInstance().clickLogoutLink();
}

@Then("Admin is re-directed to Login page")
public void admin_is_re_directed_to_login_page() {
	ProgramPage.getInstance().ValidateLogout();
}

//   ############Pagination##################################

@Given("Admin is on Manage Program Page after logged in")
public void admin_is_on_manage_program_page_after_logged_in() {
	ProgramPage.getInstance().ManageBatch_HeadingVerification("Manage Program");

}

@When("Admin clicks Next page link on the program table")
public void admin_clicks_next_page_link_on_the_program_table() {
	ProgramPage.getInstance().ClickNextPagination();
}

@Then("Admin should see the Pagination has {string} active link")
public void admin_should_see_the_pagination_has_active_link(String string) {
    ProgramPage.getInstance().ValidateNextPagination();
}
@When("Admin clicks Last page link")
public void admin_clicks_last_page_link() {
	ProgramPage.getInstance().ClickLastPagination();
}

@Then("Admin should see the last page record on the table with Next page link are disabled")
public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
    ProgramPage.getInstance().ValidateLastPagination();
}


@Given("Admin is on last page of Program table")
public void admin_is_on_last_page_of_program_table() {
	ProgramPage.getInstance().ManageBatch_HeadingVerification("Manage Program");
	ProgramPage.getInstance().ClickLastPagination();
}

@When("Admin clicks Prev page link")
public void admin_clicks_prev_page_link() {
	ProgramPage.getInstance().ClickPrevPagination();
}

@Then("Admin should see the previous page record on the table with pagination has previous page link")
public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() {
	ProgramPage.getInstance().ValidatePrevPagination();
}

@Given("Admin is on Previous Program page")
public void admin_is_on_previous_program_page() {
	ProgramPage.getInstance().ManageBatch_HeadingVerification("Manage Program");
	ProgramPage.getInstance().ClickLastPagination();
	ProgramPage.getInstance().ClickPrevPagination();

}

@When("Admin clicks Start page link")
public void admin_clicks_start_page_link() {
	ProgramPage.getInstance().ClickFirstPagination();
}

@Then("Admin should see the very first page record on the table with Previous page link are disabled")
public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
	ProgramPage.getInstance().ValidateFirstPagination();
}


//#####     Validates Sorting(data ordering) on the Program Data table


@When("Admin clicks the sort icon of program name column")
public void admin_clicks_the_sort_icon_of_program_name_column() {
	ProgramPage.getInstance().ValidateSortIcon_ProgramName();
	
}

@Then("The data get sorted on the table based on the program name column values in ascending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_ascending_order() {
	ProgramPage.getInstance().ValidateSortIcon_ProgramName_Ascending();
}

@Given("The data is in the ascending order on the table based on Program Name column")
public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_name_column() {
	ProgramPage.getInstance().ValidateSortIcon_ProgramName();
	ProgramPage.getInstance().ValidateSortIcon_ProgramName_Ascending();

	
}

@Then("The data get sorted on the table based on the program name column values in descending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_descending_order() {
	ProgramPage.getInstance().ValidateSortIcon_ProgramName_Descending();

}

@When("Admin clicks the sort icon of program description column")
public void admin_clicks_the_sort_icon_of_program_description_column() {
    ProgramPage.getInstance().ValidateSortIcon_ProgramDescription();
}

@Then("The data get sorted on the table based on the program description column values in ascending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_ascending_order() {
	ProgramPage.getInstance().ValidateSortIcon_ProgramDescription_Ascending();
}

@Given("The data is in the ascending order on the table based on Program Description column")
public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_description_column() {
	ProgramPage.getInstance().ValidateSortIcon_ProgramDescription();
	ProgramPage.getInstance().ValidateSortIcon_ProgramDescription_Ascending();

}

@Then("The data get sorted on the table based on the program description column values in descending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_descending_order() {
	ProgramPage.getInstance().ValidateSortIcon_ProgramDescription_Descending();

}


@When("Admin clicks the sort icon of program status column")
public void admin_clicks_the_sort_icon_of_program_status_column() {
    ProgramPage.getInstance().ValidateSortIcon_ProgramStatus();
}

@Then("The data get sorted on the table based on the program status column values in ascending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_ascending_order() {
	ProgramPage.getInstance().ValidateSortIcon_ProgramStatus_Ascending();

}

@Given("The data is in the ascending order on the table based on Program status column")
public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_status_column() {
	ProgramPage.getInstance().ValidateSortIcon_ProgramStatus();
	ProgramPage.getInstance().ValidateSortIcon_ProgramStatus_Ascending();
}

@Then("The data get sorted on the table based on the program status column values in descending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_descending_order() {
	ProgramPage.getInstance().ValidateSortIcon_ProgramStatus_Descending();

}






}

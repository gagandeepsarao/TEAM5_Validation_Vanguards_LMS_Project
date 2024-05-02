package step_definitions;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import app_hooks.AppHooks;
import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.User_DeleteAssignPage;

public class User_DeleteAssign_Step {

	public String strLoginPage = "";
	public String strDashboardPage = "";
	public User_DeleteAssignPage objUserPage;
	public Login objLogin;
	String id;

	List<String> rowId = new ArrayList<>();


	public User_DeleteAssign_Step() {
		AppHooks.getInstance().getDriver().get(Constants.URL);

		objLogin = new Login();
		objLogin.admin_enter_valid_credentials_and_clicks_login_button();
		objLogin.admin_should_land_on_dashboard_page();
		strLoginPage = AppHooks.getInstance().getDriver().getCurrentUrl();
	}

	// UserPage.feature -> Scenario One starts here.
//	@Given("Admin is on dashboard page after Login")
//	public void admin_is_on_dashboard_page_after_login() throws InterruptedException {
//
//		Thread.sleep(2000);
//
//		String strDashboardPage = AppHooks.getInstance().getDriver().getCurrentUrl();
//		// System.out.println("Login :" + strLoginPage );
//		// System.out.println("Dashboard :" + strDashboardPage );
//		// System.out.println("Constants: " + Constants.URL);
//
//		if (strDashboardPage.equalsIgnoreCase(Constants.URL)) {
//			System.out.println("landed in Dashboard page");
//		} else {
//			System.out.println("failed landing Dashboard page");
//		}
//	}
//
//	@When("Admin clicks User from navigation bar")
//	public void admin_clicks_User_from_navigation_bar() throws InterruptedException {
//		objUserPage.getInstance().clickUserLink();
//		System.out.println("clicked the USER menu in the navigation bar");
//	}

//	@Then("Admin should see the User in the URL")
//	public void admin_should_see_the_User_in_the_url() {
//		String strGetCurrUrl = AppHooks.getInstance().getDriver().getCurrentUrl();
//		System.out.println("Curr URL: " + strGetCurrUrl);
//
//		if (strGetCurrUrl.contains("user")) {
//			System.out.println("Expected String **USER** found");
//		} else {
//			System.out.println("Expected String **USER** NOT found");
//		}
//	}
	// UserPage.feature -> Scenario One ends here

	// UserPage.feature -> Scenario Two starts here
//	@Then("Admin should see a heading with text Manage user on the page")
//	public void admin_should_see_a_heading_with_text_Manage_user_in_the_page() {
//		String strExpectedString = "Manage User";
//		String strGetElementText = "";
//
//		By elePageTitleCard = By.xpath("//div[1][@class='box']");
//		strGetElementText = AppHooks.getInstance().getDriver().findElement(elePageTitleCard).getText();
//
//		if (strExpectedString.contains(strGetElementText.trim())) {
//			System.out.println("Expected String **MANAGE USER** found");
//		} else {
//			System.out.println("Expected String **MANAGE USER** NOT found");
//		}
//	}
	// UserPage.feature -> Scenario Two ends here

	// UserPage.feature -> Scenario Three starts here
	//@Then("Admin should see the text as Showing x to y of z entries along with Pagination icon below the table")
//	public void Admin_should_see_the_text_as_Showing_x_to_y_of_z_entries_along_with_Pagination_icon_below_the_table() throws InterruptedException
//	{
//		String strGetElementText = "";
//		boolean bIsPaginationTextAvl = false;
//		boolean bIsShowingTextAvl = false;
//		boolean bIsStartIntAvl = false;
//		boolean bIsToTextAvl = false;
//		boolean bIsEndIntAvl = false;
//		boolean bIsOfTextAvl = false;
//		boolean bIsTotalCountIntAvl = false;
//		boolean bIsEntriesTextAvl = false;
//
//		boolean bIsPaginatorIconVisible = false;
//
//		By elePaginationCountText = By.xpath("//span[@class='p-paginator-current ng-star-inserted']");
//		Thread.sleep(1000);
//		strGetElementText = AppHooks.getInstance().getDriver().findElement(elePaginationCountText).getText();
//
//		// Check if the text "Showing" is visible in the pagination card.
//		if(strGetElementText.contains("Showing"))
//			bIsShowingTextAvl = true;	// "Showing" text visible
//		else
//			bIsShowingTextAvl = false;	// "Showing" text NOT visible
//
//		System.out.println("Showing text visible : " + bIsShowingTextAvl);
//
//		// Check if the starting page value is visible in the pagination card.
//		if(strGetElementText.substring(8, 9).isBlank())
//			bIsStartIntAvl = false;	// Starting Page value NOT visible
//		else
//			bIsStartIntAvl = true;	// Starting Page value visible
//
//		System.out.println("Start Page number :" + strGetElementText.substring(8, 9));
//		System.out.println("Start Page number visible : " + bIsStartIntAvl);
//
//		// Check if the text "to" is visible in the pagination card.
//		if(strGetElementText.contains("to"))
//			bIsToTextAvl = true;	// "To" text visible
//		else
//			bIsToTextAvl = false;	// "To" text NOT visible
//
//		System.out.println("To text visible : " + bIsToTextAvl);
//
//		// Check if the ending page value is visible in the pagination card.
//		int iIndexofEndPageValue;
//
//		iIndexofEndPageValue = strGetElementText.indexOf("t");
//
//		// System.out.println("Index value of TO starts at:" + iIndexofEndPageValue);
//		// System.out.println("String after TO:" + strGetElementText.substring(iIndexofEndPageValue+3, iIndexofEndPageValue+4));
//
//		if(strGetElementText.substring(iIndexofEndPageValue + 3, iIndexofEndPageValue + 4).isBlank())
//			bIsEndIntAvl = false;	// Ending Page value not visible
//		else
//			bIsEndIntAvl = true;	// Ending Page value visible
//
//		System.out.println("Ending Page number :" + strGetElementText.substring(iIndexofEndPageValue + 3, iIndexofEndPageValue + 4));
//		System.out.println("Ending Page Number visible : " + bIsEndIntAvl);
//
//		// Check if the text "of" is visible in the pagination card.
//		if(strGetElementText.contains("of"))
//			bIsOfTextAvl = true;	// "Of" text visible
//		else
//			bIsOfTextAvl = false;	// "Of" text NOT visible
//
//		System.out.println("OF text visible : " + bIsOfTextAvl);
//
//		// Check if the total pages value is visible in the pagination card.
//		int iIndexofTotalPageValue;
//		iIndexofTotalPageValue = strGetElementText.indexOf("of");
//
//		System.out.println("Index value of OF starts at:" + iIndexofEndPageValue);
//		System.out.println("String after OF:" + strGetElementText.substring(iIndexofEndPageValue+3, iIndexofEndPageValue+4));
//
//		if(strGetElementText.substring(iIndexofTotalPageValue + 3, iIndexofTotalPageValue + 4).isBlank())
//			bIsTotalCountIntAvl = false;	// Total Page Count not visible
//		else
//			bIsTotalCountIntAvl = true;		// Total Page Count visible
//
//		System.out.println("Total Page number :" + strGetElementText.substring(iIndexofTotalPageValue + 3, iIndexofTotalPageValue + 5));
//		System.out.println("Total Page Count visible : " + bIsTotalCountIntAvl);
//
//		// Check if the text "entries" is visible in the pagination card.
//		if(strGetElementText.contains("entries"))
//			bIsEntriesTextAvl = true;	// "Entries" text visible
//		else
//			bIsEntriesTextAvl = false;	// "Entries" text NOT visible
//
//		System.out.println("Entries text visible : " + bIsEntriesTextAvl);
//
//	}
	// UserPage.feature -> Scenario Three ends here

	// UserPage.feature -> Scenario Four starts here
	//@Then("Admin Should see the data table with column names Id, Name, location, Phone Number, EditOrDelete")
//	public void Admin_Should_see_the_data_table_with_column_names_Id_Name_location_PhoneNumber_EditOrDelete() throws InterruptedException 
//	{
//		Thread.sleep(1000);
//		
//		boolean bIDHeaderAvl = false;
//		boolean bNameHeaderAvl = false;
//		boolean bLocationHeaderAvl = false;
//		boolean bPhoneNumHeaderAvl = false;
//		boolean bEditDelHeaderAvl = false;

//		int intColumnSize = objUserPage.getInstance().getTableHeaderCount();

//		for(int iLoop = 0; iLoop < intColumnSize; iLoop++)
//		{
//			String strHeaderName = objUserPage.getInstance().getTableColumnHeaderNames(iLoop);

//			switch(iLoop)
//			{
//				case 0:					
//					if(strHeaderName.equalsIgnoreCase(Constants.TableHeaderColumn1.trim()))
//						bIDHeaderAvl = true;
//					break;
//				case 1:
//					if(strHeaderName.equalsIgnoreCase(Constants.TableHeaderColumn2.trim()))
//						bNameHeaderAvl = true;
//					break;
//				case 2:
//					if(strHeaderName.equalsIgnoreCase(Constants.TableHeaderColumn3.trim()))
//						bLocationHeaderAvl = true;
//					break;
//				case 3:
//					if(strHeaderName.equalsIgnoreCase(Constants.TableHeaderColumn4.trim()))
//						bPhoneNumHeaderAvl = true;
//					break;
//				default:
//						System.out.println("Default String -> User Page Table Header!!" );
//			}
//		}
//		
//		if(Constants.TableHeaderColumn5.equalsIgnoreCase(objUserPage.getInstance().getTableColumnEditDelete().trim()))
//		{
//			bEditDelHeaderAvl = true;
//		}

	//if(bIDHeaderAvl && bNameHeaderAvl && bLocationHeaderAvl && bPhoneNumHeaderAvl && bEditDelHeaderAvl)
//		if(bIDHeaderAvl)
//			if(bNameHeaderAvl)
//				if(bLocationHeaderAvl)
//					if(bPhoneNumHeaderAvl)
//						if(bEditDelHeaderAvl)
//							System.out.println("User Page Table Header Columns test successful !!");
//						else
//							System.out.println("User Page Table Header **EDIT/DELETE** Column missing !!");
//					else
//						System.out.println("User Page Table Header **PHONE NUMBER** Column missing !!");
//				else
//					System.out.println("User Page Table Header **LOCATION** Column missing !!");
//			else
//				System.out.println("User Page Table Header **NAME** Column missing !!");
//		else
//			System.out.println("User Page Table Header **ID** Column missing !!");
//	}
	// UserPage.feature -> Scenario Four ends here

	// UserPage.feature -> Scenario Five starts here
//	@Then("Admin should see a Delete button on the top left hand side as Disabled")
//	public void Admin_should_see_a_Delete_button_on_the_top_left_hand_side_as_Disabled() {
//		boolean bIsDelAllBtnEnabled;
//
//		bIsDelAllBtnEnabled = objUserPage.getInstance().IsUserPageDeleteAllButtonEnabled();
//
//		if (!bIsDelAllBtnEnabled)
//			System.out.println("User Page Delete All Button is disabled !!");
//		else
//			System.out.println("User Page Delete All Button is NOT disabled !!");
//	}
	// UserPage.feature -> Scenario Five ends here

	// UserPage.feature -> Scenario Six starts here
//	@Then("Admin should be able to see the Add New User button above the data table")
//	public void Admin_should_be_able_to_see_the_Add_New_User_button_above_the_data_table() throws InterruptedException {
//		boolean bIsAddNewUserBtnVisible;
//
//		Thread.sleep(1000);
//		bIsAddNewUserBtnVisible = objUserPage.getInstance().IsAddNewUserButtonVisible();
//
//		if (bIsAddNewUserBtnVisible)
//			System.out.println("User Page Add New User Button is Visible !!");
//		else
//			System.out.println("User Page Add New User Button is NOT Visible !!");
//	}
	// UserPage.feature -> Scenario Six ends here


	@Given("Admin is on the Manage User Page")
	public void admin_is_on_the_manage_user_page() throws InterruptedException {
		System.out.println("Redirected to user page");
		objUserPage.getInstance().clickUserLink();
	}

//	@When("Admin clicks the delete icon")
//	public void admin_clicks_the_delete_icon() {
//		objUserPage.getInstance().clickDeleteBtn();
//	}

	@Then("Admin should see a alert open with heading {string} with  <YES> and <NO> button for deletion")
	public void admin_should_see_a_alert_open_with_heading_with_yes_and_no_button_for_deletion(String string) throws InterruptedException {
		objUserPage.getInstance().clickUserLink();
		objUserPage.getInstance().clickDeleteBtn();
		objUserPage.getInstance().switchToAlert();
		assertTrue(objUserPage.getInstance().checkHeading().contains("Confirm"), "Confirm text not found");
		assertTrue(objUserPage.getInstance().checkYesButtonPresent(), "Yes button is not present on alert");
		assertTrue(objUserPage.getInstance().checkNoButtonPresent(), "No button is not present on alert");
	}

	@When("Admin clicks yes option")
	public void admin_clicks_yes_option() {
		objUserPage.getInstance().clickYesButton();
	}

	@Then("Admin gets a message {string} alert and do not see that user in the data table")
	public void admin_gets_a_message_alert_and_do_not_see_that_user_in_the_data_table(String string) {
		String message = objUserPage.getInstance().getAlertMessage();
		assertTrue(message.equals(string), "User Deleted");
	}

	@When("Admin clicks  No option")
	public void admin_clicks_no_option() {
		objUserPage.getInstance().clickNoButton();
		System.out.println("no button clicked");
	}

	@Then("Admin can see deletion alert disappears without deleting")
	public void admin_can_see_deletion_alert_disappears_without_deleting() {
		boolean present = objUserPage.getInstance().alertBoxNotPresent();
		assertTrue(present);
	}

	@When("Admin clicks on close button")
	public void admin_clicks_on_close_button() {
		System.out.println("User is on pop up");
		objUserPage.getInstance().clickCloseButton();
		System.out.println("close button clicked");
	}

	@Then("Admin can see deletion alert disappears without any changes")
	public void admin_can_see_deletion_alert_disappears_without_any_changes() {
		boolean present = objUserPage.getInstance().alertBoxNotPresent();
		assertTrue(present);
	}

	@When("Admin clicks any checkbox in the data table")
	public void admin_clicks_any_checkbox_in_the_data_table() {
		System.out.println("User clicks any checkbox");
		objUserPage.getInstance().clickCheckBox();
	}
	@Then("Admin should see common delete option enabled under header Manage Program")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_program() {
		boolean enabled = objUserPage.getInstance().checkCommonDeleteButton();
		System.out.println("Value of enabled is "+enabled);
		assertTrue(enabled,"Delete button is enabled");
	}

	@Given("Admin is on the Confirm Deletion alert")
	public void admin_is_on_the_confirm_deletion_alert() throws InterruptedException {
		objUserPage.getInstance().clickUserLink();
		System.out.println("User link is clicked");
		objUserPage.getInstance().clickCheckBox();
		System.out.println("Checkbox is clicked");
		id = objUserPage.getInstance().getFirstRowData();
		System.out.println("ID IS " +id);
		objUserPage.getInstance().clickCommonDeleteButton();
		System.out.println("Delete Common button is clicked");
		objUserPage.getInstance().switchToAlert();

	}

	@Then("Admin should land on Manage User page and can see the selected user is deleted from the data table")
	public void admin_should_land_on_manage_user_page_and_can_see_the_selected_user_is_deleted_from_the_data_table() {
		String newId = objUserPage.getInstance().getFirstRowData();
		System.out.println("iD is " +id);
		System.out.println("New iD is " +newId);
		assertTrue(!newId.equals(id),"User with" + id+ "has been deleted successfully");
	}

	@Then("Admin should land on Manage User page and can see the selected user is not deleted from the data table")
	public void admin_should_land_on_manage_user_page_and_can_see_the_selected_user_is_not_deleted_from_the_data_table() {
		String newId = objUserPage.getInstance().getFirstRowData();
		System.out.println("iD is " +id);
		System.out.println("New iD is " +newId);
		assertTrue(newId.equals(id),"User with" + id+ "has not been deleted");
	}

//	@Given("Admin is on Confirm Deletion alert after selecting multiple checkboxes")
//	public void admin_is_on_confirm_deletion_alert_after_selecting_multiple_checkboxes() throws InterruptedException {
//		objUserPage.getInstance().clickUserLink();
//		System.out.println("User link is clicked");
//		objUserPage.getInstance().clickMultipleCheckBox();
//		System.out.println("Checkboxes is clicked");
//		rowId = objUserPage.getInstance().getAllSelectedIds();
//		System.out.println("ID IS " +rowId);
//
//	}
	@Given("Admin is on Confirm Deletion alert after selecting multiple checkboxes")
	public void admin_is_on_confirm_deletion_alert_after_selecting_multiple_checkboxes() throws InterruptedException {
		objUserPage.getInstance().clickUserLink();
		System.out.println("User link is clicked");
		rowId = objUserPage.getInstance().getAllSelectedIds();
		System.out.println("ID IS " +rowId);
		String[] filteredId = objUserPage.getInstance().removeRestrictedId(rowId.toArray(new String[0]));
		for (String element : filteredId) {
			System.out.println(element);
		}
		objUserPage.getInstance().clickMultipleCheckBox(filteredId);

		System.out.println("Checkboxes is clicked");
		Thread.sleep(2000);
		objUserPage.getInstance().clickCommonDeleteButton();
		System.out.println("Delete Common button is clicked");
		objUserPage.getInstance().switchToAlert();


	}
	@Then("Admin should land on Manage User page and can see the selected users are deleted from the data table")
	public void admin_should_land_on_manage_user_page_and_can_see_the_selected_users_are_deleted_from_the_data_table() {
		List<String> newRowId = objUserPage.getInstance().getAllSelectedIds();
		System.out.println("new rowid" +newRowId);
		assertFalse(newRowId.equals(rowId));
	}

	@Then("Admin should land on Manage User page and can see the selected users are not deleted from the data table")
	public void admin_should_land_on_manage_user_page_and_can_see_the_selected_users_are_not_deleted_from_the_data_table() {
		List<String> newRowId = objUserPage.getInstance().getAllSelectedIds();
		System.out.println("new rowid" +newRowId);
		assertTrue(newRowId.equals(rowId));
	}
	@When("Admin clicks the {string} button")
	public void admin_clicks_the_button(String string) {
		objUserPage.getInstance().clickAssignStudent();
		System.out.println("Assign student button is clicked");
	}
	@Then("Admin should see a pop up open for assign student details with empty form along with Save and Cancel button and close \\(X) icon on the top right corner of the window")
	public void admin_should_see_a_pop_up_open_for_assign_student_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
		assertTrue(objUserPage.getInstance().studentAssignPopupPresent());
		assertTrue(objUserPage.getInstance().saveAssignButtonPresent());
		assertTrue(objUserPage.getInstance().cancelAssignButtonPresent());
		assertTrue(objUserPage.getInstance().closeAssignButtonPresent());
	}

	@Then("Admin should see User Role as R03,and other fields Student Email id,Program Name,Batch Name and Status with respective input boxes.")
	public void admin_should_see_user_role_as_r03_and_other_fields_student_email_id_program_name_batch_name_and_status_with_respective_input_boxes() {
		assertTrue(objUserPage.getInstance().studentRolePresent());
		assertTrue(objUserPage.getInstance().studentEmailPresent());
		assertTrue(objUserPage.getInstance().studentProgramPresent());
		assertTrue(objUserPage.getInstance().studentBatchPresent());
	}

	@Then("Admin should see two radio button for Status")
	public void admin_should_see_two_radio_button_for_status() {
		assertTrue(objUserPage.getInstance().statusButton());
	}

	@Given("Admin is in Assign Student details pop up page")
	public void admin_is_in_assign_student_details_pop_up_page() throws InterruptedException {
		objUserPage.getInstance().clickUserLink();
		objUserPage.getInstance().clickAssignStudent();
	}
	@When("Admin clicks {string} button with entering any data")
	public void admin_clicks_button_with_entering_any_data(String string) throws InterruptedException {
		objUserPage.getInstance().clicksaveAssignStudentButton();
	}
	@Then("Admin gets a Error message alert on page")
	public void admin_gets_a_error_message_alert_on_page() {
		String error = objUserPage.getInstance().getEmailError();
		assertTrue(error.contains("required"));
	}

	@When("Admin clicks {string} button without entering Student Email id")
	public void admin_clicks_button_without_entering_student_email_id(String string) throws InterruptedException {
		objUserPage.getInstance().enterProgramName();
		objUserPage.getInstance().enterBatchName();
		objUserPage.getInstance().clicksaveAssignStudentButton();
	}
	@Then("Admin gets a Error message alert as {string}")
	public void admin_gets_a_error_message_alert_as(String error) {
		String errorMessage = "";
		if(error.contains("Email")) {
			errorMessage = objUserPage.getInstance().getEmailError();
		} else if (error.contains("Program Name")) {
			errorMessage = objUserPage.getInstance().getProgramError();
		}else if(error.contains("Batch Name")){
			errorMessage = objUserPage.getInstance().getBatchError();
		}else if(error.contains("Status")){
			errorMessage = objUserPage.getInstance().getStatusError();
		}
		assertTrue(errorMessage.trim().equals(error.trim()));
	}

	@When("Admin clicks {string} button without selecting program")
	public void admin_clicks_button_without_selecting_program(String string) throws InterruptedException {
		objUserPage.getInstance().enterStudentEmail();
		objUserPage.getInstance().enterBatchName();
		objUserPage.getInstance().checkStatus();
		objUserPage.getInstance().clicksaveAssignStudentButton();
	}

	@When("Admin clicks {string} button without selecting batch")
	public void admin_clicks_button_without_selecting_batch(String string)throws InterruptedException {
		objUserPage.getInstance().enterStudentEmail();
		objUserPage.getInstance().enterProgramName();
		objUserPage.getInstance().checkStatus();
		objUserPage.getInstance().clicksaveAssignStudentButton();
	}

	@When("Admin clicks {string} button without giving status")
	public void admin_clicks_button_without_giving_status(String string) throws InterruptedException  {
		objUserPage.getInstance().enterStudentEmail();
		objUserPage.getInstance().enterProgramName();
		objUserPage.getInstance().enterBatchName();
		objUserPage.getInstance().clicksaveAssignStudentButton();
	}
	@When("Admin clicks Cancel or Close Icon on Assign Student form")
	public void admin_clicks_cancel_close_x_icon_on_assign_student_form() {
		objUserPage.getInstance().clickCloseAssignButton();
		System.out.println("Close button clicked");
	}
	@Then("Assign Student popup window should be closed without saving")
	public void assign_student_popup_window_should_be_closed_without_saving() {
		boolean result = objUserPage.getInstance().studentAssignPopupPresent();
		assertTrue(!result);

	}

	@When("Enter all required fields with valid values and click Save button")
	public void enter_all_required_fields_with_valid_values_and_click_save_button() throws InterruptedException{
		objUserPage.getInstance().enterStudentEmail();
		objUserPage.getInstance().enterProgramName();
		objUserPage.getInstance().enterBatchName();
		objUserPage.getInstance().checkStatus();
		objUserPage.getInstance().clicksaveAssignStudentButton();
	}
	@Then("Admin gets a message {string} alert")
	public void admin_gets_a_message_alert(String string) {
		String msg = objUserPage.getInstance().assignStudentSuccess();
		assertTrue(msg.toLowerCase().contains(string.toLowerCase()));
	}

	@When("Admin clicks {string} button on Page")
	public void admin_clicks_button_on_page(String string) {
		objUserPage.getInstance().assignStaffButton();
	}
	@Then("Admin should see a pop up open for assign staff details with empty form along with Save and Cancel button and close icon on the top right corner of the window")
	public void admin_should_see_a_pop_up_open_for_assign_staff_details_with_empty_form_along_with_save_and_cancel_button_and_close_icon_on_the_top_right_corner_of_the_window() {
		assertTrue(objUserPage.getInstance().staffAssignPopupPresent());
		assertTrue(objUserPage.getInstance().closeAssignStaff());
		assertTrue(objUserPage.getInstance().saveAssignStaff());
		assertTrue(objUserPage.getInstance().cancelAssignStaff());
	}

	@Then("Admin should see User Role as R02,and other fields Student Email id,Skill,Program Name,Batch Name and Status with respective input boxes.")
	public void admin_should_see_user_role_as_r02_and_other_fields_student_email_id_skill_program_name_batch_name_and_status_with_respective_input_boxes() {
		assertTrue(objUserPage.getInstance().userRolePresent());
	}

	@Then("Admin should see two radio button for User Status")
	public void admin_should_see_two_radio_button_for_user_status() {
		assertTrue(objUserPage.getInstance().radioButtons());
	}

	@Given("Admin is in Assign Staff details pop up page")
	public void admin_is_in_assign_staff_details_pop_up_page()  throws InterruptedException {
		objUserPage.getInstance().clickUserLink();
		objUserPage.getInstance().assignStaffButton();
	}

	@When("Admin clicks {string} button without entering any data on Assign User")
	public void admin_clicks_button_without_entering_any_data_on_assign_user(String string) {
		objUserPage.getInstance().clickSaveAssignStaff();
	}
	@Then("Admin gets an Error message alert")
	public void admin_gets_an_error_message_alert() {
		String error = objUserPage.getInstance().getUserAssignError();
		assertFalse(error.isEmpty());
	}

	@When("Admin clicks {string} button without entering staff Email id")
	public void admin_clicks_button_without_entering_staff_email_id(String string) {
		objUserPage.getInstance().clickSaveAssignStaff();
	}


	@Then("Admin gets a Staff Error message alert as {string}")
	public void admin_gets_a_staff_error_message_alert_as(String error) {
				String errorMessage = "";
		if(error.contains("Email")) {
			errorMessage = objUserPage.getInstance().getUserAssignError();
		} else if (error.contains("Program Name")) {
			errorMessage = objUserPage.getInstance().getUserProgramError();
		}else if(error.contains("Batch")){
			errorMessage = objUserPage.getInstance().getUserBatchError();
		}else if(error.contains("Status")){
			errorMessage = objUserPage.getInstance().getUserStatusError();
		}else if(error.contains("Skill")){
		errorMessage = objUserPage.getInstance().getUserSkillError();

	}
		assertTrue(errorMessage.trim().equals(error.trim()));
	}

	@When("Admin clicks {string} button without entering Skill")
	public void admin_clicks_button_without_entering_skill(String string) {
		objUserPage.getInstance().clickSaveAssignStaff();
	}

	@When("Admin clicks {string} button without selecting program for Assign")
	public void admin_clicks_button_without_selecting_program_for_assign(String string) {
		objUserPage.getInstance().clickSaveAssignStaff();
	}

	@When("Admin clicks {string} button without selecting batch for Assign")
	public void admin_clicks_button_without_selecting_batch_for_assign(String string) {
		objUserPage.getInstance().clickSaveAssignStaff();
	}

	@When("Admin clicks Cancel or Close Icon on Assign Staff  form")
	public void admin_clicks_cancel_or_close_icon_on_assign_staff_form() {
		objUserPage.getInstance().clickCloseAssignStaff();
	}
	@Then("Assign Staff popup window should be closed without saving")
	public void assign_staff_popup_window_should_be_closed_without_saving() {
		assertFalse(objUserPage.getInstance().staffAssignPopupPresent());
	}

	@When("Admin clicks the Cancel button")
	public void admin_clicks_the_cancel_button() {
		objUserPage.getInstance().clickCancelAssignStaff();
	}
	@Then("Admin can see the Assign Staff popup disappears without assigning")
	public void admin_can_see_the_assign_staff_popup_disappears_without_assigning() {
		assertFalse(objUserPage.getInstance().staffAssignPopupPresent());

	}

	@When("Enter all the required fields with valid values and click Save button on Assign Staff")
	public void enter_all_the_required_fields_with_valid_values_and_click_save_button_on_assign_staff() throws InterruptedException {
		objUserPage.getInstance().selectUserEmail();
		Thread.sleep(2000);
		objUserPage.getInstance().selectUserProgram();
		Thread.sleep(2000);
		objUserPage.getInstance().selectUserBatch();
		objUserPage.getInstance().checkStatus();

		objUserPage.getInstance().clickSaveAssignStaff();

	}
	@Then("Admin gets a message {string} alert on the page")
	public void admin_gets_a_message_alert_on_the_page(String string) {
		String msg = objUserPage.getInstance().assignStaffSuccess();
		System.out.println("msg is " +msg);
		System.out.println("string is "+string);
		System.out.println("User has been successfully assinged");
		assertTrue(msg.toLowerCase().contains(string.toLowerCase()));


	}



}

package step_definitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.dockerjava.api.model.Driver;

import app_hooks.AppHooks;
import constants.Constants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.User_Page;

public class User_Step
{
	
	public String strLoginPage = "";
	public String strDashboardPage = "";
	public User_Page objUserPage;
	
	public Login objLogin;
	
	public WebDriver localDriver;
	
	public int iDataTableMinRowCount;
  
	public User_Step() 
	{
		AppHooks.getInstance().getDriver().get(Constants.URL);
		
		objLogin = new Login();
		objLogin.admin_enter_valid_credentials_and_clicks_login_button();
		objLogin.admin_should_land_on_dashboard_page();
		strLoginPage = AppHooks.getInstance().getDriver().getCurrentUrl();
		
		localDriver = AppHooks.getInstance().getDriver();
		
// 		objUserPage = new UserPage().getInstance();
	}

	// UserPageValidation.feature -> Scenario One starts here.
	@Given("Admin is on dashboard page after LMS Login")
	public void admin_is_on_dashboard_page_after_lms_login() throws InterruptedException 
	{

		Thread.sleep(1000);		
		
		String strDashboardPage = localDriver.getCurrentUrl();
		// System.out.println("Login :" + strLoginPage );
		// System.out.println("Dashboard :" + strDashboardPage );
		// System.out.println("Constants: " + Constants.URL);
		
		if(strDashboardPage.equalsIgnoreCase(Constants.DashboardPage))
		{
			System.out.println("landed in Dashboard page");
		}
		else
		{
			System.out.println("failed landing Dashboard page");
		}		
	}

	@When("Admin clicks User from navigation bar")
	public void admin_clicks_User_from_navigation_bar() 
	{
		objUserPage.getInstance().clickUserLink();
		System.out.println("clicked the USER menu in the navigation bar");
	}

	@Then("Admin should see the User in the URL")
	public void admin_should_see_the_User_in_the_url() 
	{
		String strGetCurrUrl = localDriver.getCurrentUrl();
		// System.out.println("Curr URL: " + strGetCurrUrl);
		
		if(strGetCurrUrl.contains("user"))
		{
			System.out.println("Expected String **USER** found");
		}
		else
		{
			System.out.println("Expected String **USER** NOT found");
		}
	}
	// UserPageValidation.feature -> Scenario One ends here

	// UserPageValidation.feature -> Scenario Two starts here
	@Then("Admin should see a heading with text Manage user on the page")
	public void admin_should_see_a_heading_with_text_Manage_user_in_the_page() 
	{
		String strExpectedString = "Manage User";
		String strGetElementText = ""; 
		
		By elePageTitleCard = By.xpath("//div[1][@class='box']");		
		strGetElementText = localDriver.findElement(elePageTitleCard).getText();
		
		if(strExpectedString.contains(strGetElementText.trim()))
		{
			System.out.println("Expected String **MANAGE USER** found");
		}
		else
		{
			System.out.println("Expected String **MANAGE USER** NOT found");
		}
	}
	// UserPageValidation.feature -> Scenario Two ends here
	
	// UserPageValidation.feature -> Scenario Three starts here
	@Then("Admin should see the text as Showing x to y of z entries along with Pagination icon below the table")
	public void Admin_should_see_the_text_as_Showing_x_to_y_of_z_entries_along_with_Pagination_icon_below_the_table() throws InterruptedException 
	{
		String strGetElementText = ""; 
		boolean bIsPaginationTextAvl = false;
		boolean bIsShowingTextAvl = false;
		boolean bIsStartIntAvl = false;
		boolean bIsToTextAvl = false;
		boolean bIsEndIntAvl = false;
		boolean bIsOfTextAvl = false;
		boolean bIsTotalCountIntAvl = false;
		boolean bIsEntriesTextAvl = false;
		
		boolean bIsPaginatorIconVisible = false;
		
		By elePaginationCountText = By.xpath("//span[@class='p-paginator-current ng-star-inserted']");
		Thread.sleep(1000);
		strGetElementText = localDriver.findElement(elePaginationCountText).getText();
		
		// Check if the text "Showing" is visible in the pagination card.
		if(strGetElementText.contains("Showing"))
			bIsShowingTextAvl = true;	// "Showing" text visible
		else
			bIsShowingTextAvl = false;	// "Showing" text NOT visible
		
		// System.out.println("Showing text visible : " + bIsShowingTextAvl);
		
		// Check if the starting page value is visible in the pagination card.		
		if(strGetElementText.substring(8, 9).isBlank())
			bIsStartIntAvl = false;	// Starting Page value NOT visible
		else
			bIsStartIntAvl = true;	// Starting Page value visible
		
		// System.out.println("Start Page number :" + strGetElementText.substring(8, 9));
		// System.out.println("Start Page number visible : " + bIsStartIntAvl);
		
		// Check if the text "to" is visible in the pagination card.
		if(strGetElementText.contains("to"))
			bIsToTextAvl = true;	// "To" text visible
		else
			bIsToTextAvl = false;	// "To" text NOT visible
		
		// System.out.println("To text visible : " + bIsToTextAvl);
		
		// Check if the ending page value is visible in the pagination card.
		int iIndexofEndPageValue;
		
		iIndexofEndPageValue = strGetElementText.indexOf("t");
		
		// System.out.println("Index value of TO starts at:" + iIndexofEndPageValue);
		// System.out.println("String after TO:" + strGetElementText.substring(iIndexofEndPageValue+3, iIndexofEndPageValue+4));
		
		if(strGetElementText.substring(iIndexofEndPageValue + 3, iIndexofEndPageValue + 4).isBlank())
			bIsEndIntAvl = false;	// Ending Page value not visible
		else
			bIsEndIntAvl = true;	// Ending Page value visible
		
		// System.out.println("Ending Page number :" + strGetElementText.substring(iIndexofEndPageValue + 3, iIndexofEndPageValue + 4));
		// System.out.println("Ending Page Number visible : " + bIsEndIntAvl);
		
		// Check if the text "of" is visible in the pagination card.
		if(strGetElementText.contains("of"))
			bIsOfTextAvl = true;	// "Of" text visible
		else
			bIsOfTextAvl = false;	// "Of" text NOT visible

		// System.out.println("OF text visible : " + bIsOfTextAvl);
		
		// Check if the total pages value is visible in the pagination card.
		int iIndexofTotalPageValue;
		iIndexofTotalPageValue = strGetElementText.indexOf("of");
		
		// System.out.println("Index value of OF starts at:" + iIndexofEndPageValue);
		// System.out.println("String after OF:" + strGetElementText.substring(iIndexofEndPageValue+3, iIndexofEndPageValue+4));
		
		if(strGetElementText.substring(iIndexofTotalPageValue + 3, iIndexofTotalPageValue + 4).isBlank())
			bIsTotalCountIntAvl = false;	// Total Page Count not visible
		else
			bIsTotalCountIntAvl = true;		// Total Page Count visible
		
		// System.out.println("Total Page number :" + strGetElementText.substring(iIndexofTotalPageValue + 3, iIndexofTotalPageValue + 5));
		// System.out.println("Total Page Count visible : " + bIsTotalCountIntAvl);
		
		// Check if the text "entries" is visible in the pagination card.
		if(strGetElementText.contains("entries"))
			bIsEntriesTextAvl = true;	// "Entries" text visible
		else
			bIsEntriesTextAvl = false;	// "Entries" text NOT visible
		
		// System.out.println("Entries text visible : " + bIsEntriesTextAvl);
		
	}	
	// UserPageValidation.feature -> Scenario Three ends here
	
	// UserPageValidation.feature -> Scenario Four starts here
	@Then("Admin Should see the data table with column names Id, Name, location, Phone Number, EditOrDelete")
	public void Admin_Should_see_the_data_table_with_column_names_Id_Name_location_PhoneNumber_EditOrDelete() throws InterruptedException 
	{
		Thread.sleep(1000);
		
		boolean bIDHeaderAvl = false;
		boolean bNameHeaderAvl = false;
		boolean bLocationHeaderAvl = false;
		boolean bPhoneNumHeaderAvl = false;
		boolean bEditDelHeaderAvl = false;
		
		int intColumnSize = objUserPage.getInstance().getTableHeaderCount();
		
		for(int iLoop = 0; iLoop < intColumnSize; iLoop++)
		{
			String strHeaderName = objUserPage.getInstance().getTableColumnHeaderNames(iLoop);
			
			switch(iLoop)
			{
				case 0:					
					if(strHeaderName.equalsIgnoreCase(Constants.TableHeaderColumn1.trim()))
						bIDHeaderAvl = true;
					break;
				case 1:
					if(strHeaderName.equalsIgnoreCase(Constants.TableHeaderColumn2.trim()))
						bNameHeaderAvl = true;
					break;
				case 2:
					if(strHeaderName.equalsIgnoreCase(Constants.TableHeaderColumn3.trim()))
						bLocationHeaderAvl = true;
					break;
				case 3:
					if(strHeaderName.equalsIgnoreCase(Constants.TableHeaderColumn4.trim()))
						bPhoneNumHeaderAvl = true;
					break;
				default:
						System.out.println("Default String -> User Page Table Header!!" );
			}
		}
		
		if(Constants.TableHeaderColumn5.equalsIgnoreCase(objUserPage.getInstance().getTableColumnEditDelete().trim()))
		{
			bEditDelHeaderAvl = true;
		}
		
		//if(bIDHeaderAvl && bNameHeaderAvl && bLocationHeaderAvl && bPhoneNumHeaderAvl && bEditDelHeaderAvl)
		if(bIDHeaderAvl)
			if(bNameHeaderAvl)
				if(bLocationHeaderAvl)
					if(bPhoneNumHeaderAvl)
						if(bEditDelHeaderAvl)
							System.out.println("User Page Table Header Columns test successful !!");
						else
							System.out.println("User Page Table Header **EDIT/DELETE** Column missing !!");
					else
						System.out.println("User Page Table Header **PHONE NUMBER** Column missing !!");
				else
					System.out.println("User Page Table Header **LOCATION** Column missing !!");
			else
				System.out.println("User Page Table Header **NAME** Column missing !!");
		else
			System.out.println("User Page Table Header **ID** Column missing !!");
	}
	// UserPageValidation.feature -> Scenario Four ends here
	
	// UserPageValidation.feature -> Scenario Five starts here
	@Then("Admin should see a Delete button on the user page on top left hand side as Disabled")
	public void Admin_should_see_a_Delete_button_on_the_user_page_on_top_left_hand_side_as_Disabled()
	{
		boolean bIsDelAllBtnEnabled;
		
		bIsDelAllBtnEnabled = objUserPage.getInstance().IsUserPageDeleteAllButtonEnabled();
		
		if(!bIsDelAllBtnEnabled)
			System.out.println("User Page Delete All Button is disabled !!");
		else
			System.out.println("User Page Delete All Button is NOT disabled !!");
	}
	// UserPageValidation.feature -> Scenario Five ends here
		
	// UserPageValidation.feature -> Scenario Six starts here
	@Then("Admin should be able to see the Add New User button above the data table")
	public void Admin_should_be_able_to_see_the_Add_New_User_button_above_the_data_table() throws InterruptedException
	{
		boolean bIsAddNewUserBtnVisible;
		
		Thread.sleep(1000);
		bIsAddNewUserBtnVisible = objUserPage.getInstance().IsAddNewUserButtonVisible();
		
		if(bIsAddNewUserBtnVisible)
			System.out.println("User Page Add New User Button is Visible !!");
		else
			System.out.println("User Page Add New User Button is NOT Visible !!");
	}
	// UserPageValidation.feature -> Scenario Six ends here
		
	// UserPageValidation.feature -> Scenario Seven starts here
	@Then("Admin should be able to see the Assign staff button above the data table")
	public void Admin_should_be_able_to_see_the_Assign_staff_button_above_the_data_table() throws InterruptedException
	{
		boolean bIsAssignStaffBtnVisible;
		
		Thread.sleep(1000);
		bIsAssignStaffBtnVisible = objUserPage.getInstance().IsAssignStaffButtonVisible();
		
		if(bIsAssignStaffBtnVisible)
			System.out.println("User Page Assign Staff Button is Visible !!");
		else
			System.out.println("User Page Assign Staff Button is NOT Visible !!");
	}
	// UserPageValidation.feature -> Scenario Seven ends here
			
	// UserPageValidation.feature -> Scenario Eight starts here
	@Then("Admin should be able to see the Assign Student button above the data table")
	public void Admin_should_be_able_to_see_the_Assign_Student_button_above_the_data_table() throws InterruptedException
	{
		boolean bIsAssignStudentBtnVisible;
		
		Thread.sleep(1000);
		bIsAssignStudentBtnVisible = objUserPage.getInstance().IsAssignStudentButtonVisible();
		
		if(bIsAssignStudentBtnVisible)
			System.out.println("User Page Assign Student Button is Visible !!");
		else
			System.out.println("User Page Assign Student Button is NOT Visible !!");
	}
	// UserPageValidation.feature -> Scenario Eight ends here
	
	// UserPageValidation.feature -> Scenario Nine starts here
	@Then("Admin should be able to see the search text box above the data table")
	public void Admin_should_be_able_to_see_the_search_text_box_above_the_data_table() throws InterruptedException
	{
		boolean bIsSearchBtnVisible;
		
		Thread.sleep(1000);
		bIsSearchBtnVisible = objUserPage.getInstance().IsSearchButtonVisible();
		
		if(bIsSearchBtnVisible)
			System.out.println("User Page Search Button is Visible !!");
		else
			System.out.println("User Page Search Button is NOT Visible !!");
	}
	// UserPageValidation.feature -> Scenario Nine ends here
	
	// UserPageValidation.feature -> Scenario Ten starts here
	@Then("Admin should see two records displayed on the data table")
	public void Admin_should_see_two_records_displayed_on_the_data_table() throws InterruptedException
	{
		boolean bIsDataRowsVisible;
		
		Thread.sleep(1000);
		
		iDataTableMinRowCount = objUserPage.getInstance().getMinDataRowCount();
		
		// System.out.println("Min Data Row Expected: " + objUserPage.getInstance().intMinDataRowCountReqd);
		// System.out.println("Min Data Row Displayed: " + iDataTableMinRowCount);
		
		if(iDataTableMinRowCount >= objUserPage.getInstance().intMinDataRowCountReqd)
		{
			bIsDataRowsVisible = true;
			System.out.println("Atleast 2 rows of data are Visible !!");
		}	
		else
		{
			bIsDataRowsVisible = false;
			System.out.println("Atleast 2 rows of data are NOT Visible !!");
		}	
	}
	// UserPageValidation.feature -> Scenario Ten ends here

	// UserPageValidation.feature -> Scenario Eleven starts here
	@Then("Each row in the data table should have a checkbox")
	public void Each_row_in_the_data_table_should_have_a_checkbox() throws InterruptedException
	{
		boolean bDoesDTGotCheckbox = false;
		
		Thread.sleep(1000);
		
		iDataTableMinRowCount = objUserPage.getInstance().getMinDataRowCount();
		
		// System.out.println("DT Rows: " + iDataTableMinRowCount);
		
		for(int iLoop = 0; iLoop <= iDataTableMinRowCount; iLoop++ )
		{			
			bDoesDTGotCheckbox = objUserPage.getInstance().CheckIfDataTableGotCheckBox(iLoop);
		}
		
		if(bDoesDTGotCheckbox)
			System.out.println("User Page Data Table checkbox is Visible !!");
		else
			System.out.println("User Page Data Table checkbox is NOT Visible !!");
	}
	// UserPageValidation.feature -> Scenario Eleven ends here
	
	// UserPageValidation.feature -> Scenario Twelve starts here
	@Then("Each row in the data table should have a edit icon that is enabled")
	public void Each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled() throws InterruptedException
	{
		boolean bDoesDTGotEditIcon = false;
		
		Thread.sleep(1000);
		
		iDataTableMinRowCount = objUserPage.getInstance().getMinDataRowCount();
		
		// System.out.println("DT Rows: " + iDataTableMinRowCount);
		
		for(int iLoop = 0; iLoop <= iDataTableMinRowCount; iLoop++ )
		{			
			bDoesDTGotEditIcon = objUserPage.getInstance().CheckIfDataTableGotEditIconEnabled(iLoop);
		}
		
		if(bDoesDTGotEditIcon)
			System.out.println("User Page Data Table Edit Icon is enabled !!");
		else
			System.out.println("User Page Data Table Edit Icon is NOT enabled !!");
	}
		// UserPageValidation.feature -> Scenario Twelve ends here
	
	// UserPageValidation.feature -> Scenario Twelve starts here
	@Then("Each row in the data table should have a delete icon that is enabled")
	public void Each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled() throws InterruptedException
	{
		boolean bDoesDTGotDelIcon = false;
		
		Thread.sleep(1000);
		
		iDataTableMinRowCount = objUserPage.getInstance().getMinDataRowCount();
		
		// System.out.println("Data Table Rows: " + iDataTableMinRowCount);
		
		for(int iLoop = 0; iLoop <= iDataTableMinRowCount; iLoop++ )
		{			
			// System.out.println("Loop : " + iLoop);
			bDoesDTGotDelIcon = objUserPage.getInstance().CheckIfDataTableGotDelIconEnabled(iLoop);
		}
		
		if(bDoesDTGotDelIcon)
			System.out.println("User Page Data Table Delete Icon is enabled !!");
		else
			System.out.println("User Page Data Table Delete Icon is NOT enabled !!");
	}
	// UserPageValidation.feature -> Scenario Thirteen ends here

	// UserPageValidation_Two.feature Background starts here.
	@Given("Admin is on the login screen")
	public void admin_is_on_the_login_screen() 
	{
		AppHooks.getInstance().getDriver().get(Constants.URL);
		System.out.println("Curr URL Login: " + localDriver.getCurrentUrl());
		System.out.println("admin logged in");
	}

	@When("Admin enters valid username and password")
	public void admin_enters_valid_username_and_password() 
	{		
		objLogin.admin_enter_valid_credentials_and_clicks_login_button();
	}

	@Then("Admin should see the dashboard page")
	public void admin_should_see_the_dashboard_page() throws InterruptedException 
	{
		Thread.sleep(2000);
		// System.out.println("Curr URL: "  + AppHooks.getInstance().getDriver().getCurrentUrl());
		// System.out.println("DashboardURL : " + Constants.DashboardPage);		
		
		if(Constants.DashboardPage.equalsIgnoreCase(AppHooks.getInstance().getDriver().getCurrentUrl()))
			System.out.println("Dashboard page reached !");
		else
			System.out.println("Dashboard page not reached !");
	}

	@Then("clicks User on the navigation bar")
	public void clicks_user_on_the_navigation_bar() 
	{
		admin_clicks_User_from_navigation_bar();
	}
	// UserPageValidation_Two.feature Background ends here.

	// UserPageValidation_Two.feature -> Scenario One starts here.
	@Given("Admin is on Manage User Page")
	public void admin_is_on_manage_user_page() 
	{
		if(AppHooks.getInstance().getDriver().getCurrentUrl().equalsIgnoreCase(Constants.userPageURL))
			System.out.println("Admin is in Manage USER Page");
		
		objUserPage.getInstance().getMinDataRowCount();
	}

	@When("Admin enters username into search box.")
	//public void admin_enters_username_into_search_box(io.cucumber.datatable.DataTable dataTable) 
	public void admin_enters_username_into_search_box(DataTable userDetail) throws InterruptedException
	{
		List<String> Data = userDetail.row(0);
		
		objUserPage.getInstance().strUserFirstName = Data.get(0);
		
		// System.out.println(objUserPage.getInstance().strUserFirstName);
		
		if(objUserPage.getInstance().IsSearchedUserDisplayedInDataTable(Data.get(0)))
			System.out.println("Searched user found ");
		else
			System.out.println("Searched user not found ");
	}

	@Then("Admin should see user displayed with the entered name")
	public void admin_should_see_user_displayed_with_the_entered_name() 
	{
	    if(objUserPage.getInstance().bIsUserDataDisplayed)
	    	System.out.println("Search user found !");
	    else
	    	System.out.println("Unable to search for the user entered");
	}
	// UserPageValidation_Two.feature -> Scenario One ends here.
	
	// UserPageValidation_Two.feature -> Scenario Two starts here.
	@When("Admin enters the keywords not present in the data table on the Search box")
	public void admin_enters_the_keywords_not_present_in_the_data_table_on_the_search_box(io.cucumber.datatable.DataTable userInvalidDetail) throws InterruptedException 
	{
		List<String> InvalidData = userInvalidDetail.row(0);
		
		objUserPage.getInstance().strUserFirstName = InvalidData.get(0);
		
		if(objUserPage.getInstance().IsSearchedUserDisplayedInDataTable(InvalidData.get(0)))
			System.out.println("Searched user found ");
		else
			System.out.println("Searched user not found ");

	}

	@Then("Admin should see zero entries on the data table")
	public void admin_should_see_zero_entries_on_the_data_table() 
	{
		if(objUserPage.getInstance().bIsUserDataDisplayed)
	    	System.out.println("Search user found !");
	    else
	    	System.out.println("Unable to search for the user entered");
	}
	// UserPageValidation_Two.feature -> Scenario Two ends here.
	
	@When("Admin clicks Add New User button")
	public void Admin_clicks_Add_New_User_button() throws InterruptedException 
	{
		if(objUserPage.getInstance().IsAddNewUserButtonVisible())
		{
			System.out.println("Add user button visible");
			objUserPage.getInstance().clickAddNewUserLink();
			Thread.sleep(2000);
		}
	}
	
	@Then("Admin should see pop up open for user details columns")
	public void Admin_should_see_pop_up_open_for_user_details_columns() throws InterruptedException 
	{
		if(objUserPage.getInstance().CheckAddNewUserScreenVisible())
		{
			if(objUserPage.getInstance().CheckUserPageFNameLabelVisible())
				System.out.println("Add user First name Label is visible");
			else
				System.out.println("Add user First name Label is NOT visible");
			
			if(objUserPage.getInstance().CheckUserPageMidNameLabelVisible())
				System.out.println("Add user middle name Label is visible");
			else
				System.out.println("Add user middle name Label is NOT visible");
			
			if(objUserPage.getInstance().CheckUserPageLastNameLabelVisible())
				System.out.println("Add user last name Label is visible");
			else
				System.out.println("Add user last name Label is NOT visible");
			
			if(objUserPage.getInstance().CheckUserPageLocationLabelVisible())
				System.out.println("Add user location Label is visible");
			else
				System.out.println("Add user location Label is NOT visible");
			
			if(objUserPage.getInstance().CheckUserPagePhNoLabelVisible())
				System.out.println("Add user PhNo Label is visible");
			else
				System.out.println("Add user PhNo Label is NOT visible");
			
			if(objUserPage.getInstance().CheckUserPageLinkedinURLLabelVisible())
				System.out.println("Add user LinkedIn URL Label is visible");
			else
				System.out.println("Add user LinkedIn URL Label is NOT visible");
			
			if(objUserPage.getInstance().CheckUserPageUserRoleLabelVisible())
				System.out.println("Add user User Role Label is visible");
			else
				System.out.println("Add user User Role Label is NOT visible");
			
			if(objUserPage.getInstance().CheckUserPageUserRoleStatusLabelVisible())
				System.out.println("Add user User Role Status Label is visible");
			else
				System.out.println("Add user User Role Status Label is NOT visible");
			
			if(objUserPage.getInstance().CheckUserPageVisaStatusLabelVisible())
				System.out.println("Add user User Visa Status Label is visible");
			else
				System.out.println("Add user User Visa Status Label is NOT visible");
			
			if(objUserPage.getInstance().CheckUserPageUGLabelVisible())
				System.out.println("Add user UG Label is visible");
			else
				System.out.println("Add user UG Label is NOT visible");
			
			if(objUserPage.getInstance().CheckUserPagePGLabelVisible())
				System.out.println("Add user PG Label is visible");
			else
				System.out.println("Add user PG Label is NOT visible");
			
			if(objUserPage.getInstance().CheckUserPageTimezoneLabelVisible())
				System.out.println("Add user Timezone Label is visible");
			else
				System.out.println("Add user Timezone Label is NOT visible");
			
			if(objUserPage.getInstance().CheckUserPageCommentsLabelVisible())
				System.out.println("Add user Comments Label is visible");
			else
				System.out.println("Add user Comments Label is NOT visible");
			
			if(objUserPage.getInstance().CheckAddNewCancelButtonVisible())
				System.out.println("Add user form cancel button visible");
			else
				System.out.println("Add user form cancel button not visible");
			
			if(objUserPage.getInstance().CheckAddNewUserSubmitBtnVisible())
				System.out.println("Add user form submit button visible");
			else
				System.out.println("Add user form submit button not visible");
			
			if(objUserPage.getInstance().CheckAddNewUserFormCloseButtonVisible())
				System.out.println("Add user form close button visible");
			else
				System.out.println("Add user form close button not visible");
			
			
		}
	}
	
	@Then("Admin should see pop up open with textboxes for user details columns")
	public void Admin_should_see_pop_up_open_with_textboxes_for_user_details_columns() throws InterruptedException 
	{
		boolean bIsSubmitButtonClicked = false;
		
		if(objUserPage.getInstance().CheckAddNewUserScreenVisible())
		{
			objUserPage.getInstance().CheckAddNewUserFNameVisible();
			objUserPage.getInstance().CheckAddNewUserMidNameVisible();
			objUserPage.getInstance().CheckAddNewUserLastNameVisible();
	
			objUserPage.getInstance().CheckAddNewUserLocationVisible();
			objUserPage.getInstance().CheckAddNewUserPhNoVisible();
			objUserPage.getInstance().CheckAddNewUserLinkedInURLVisible();
					
			objUserPage.getInstance().CheckAddNewUserEmailVisible();
			
			objUserPage.getInstance().CheckAddNewUserEduUGVisible();
			objUserPage.getInstance().CheckAddNewUserEduPGVisible();
			objUserPage.getInstance().CheckAddNewUserTimezoneVisible();
			
			objUserPage.getInstance().CheckAddNewUserCommentsVisible();
			
			objUserPage.getInstance().CheckAddNewCancelButtonVisible();
			objUserPage.getInstance().CheckAddNewUserSubmitBtnVisible();
			objUserPage.getInstance().CheckAddNewUserFormCloseButtonVisible();
			
			// objUserPage.getInstance().AddNewUserFormSubmitBtnClick();
			bIsSubmitButtonClicked = true;
		}
		else
		{
			System.out.println("Add new user screen not visible");
			objUserPage.getInstance().AddNewUserFormCancelBtnClick();		
		}
		
		if(!bIsSubmitButtonClicked)
			objUserPage.getInstance().AddNewUserFormCancelBtnClick();
		
	}	
	
	@Then("Admin should see dropdowns for userRole RoleStatus VisaStatus")
	public void Admin_should_see_dropdowns_for_userRole_RoleStatus_VisaStatus() throws InterruptedException 
	{
		objUserPage.getInstance().CheckAddNewUserRoleVisible();
		objUserPage.getInstance().CheckAddNewUserRoleStatusVisible();
		objUserPage.getInstance().CheckAddNewUserVisaStatusVisible();
	}
	
	@Given("Admin is on User Details Popup")
	public void Admin_is_on_User_Details_Popup() throws InterruptedException 
	{
		Admin_clicks_Add_New_User_button();
		if(objUserPage.getInstance().CheckAddNewUserScreenVisible())
			Admin_should_see_pop_up_open_with_textboxes_for_user_details_columns();
			System.out.println("Add new user form is visible");
	}

	@When("Admin enters mandatory fields in the form and clicks on submit button")
	public void Admin_enters_mandatory_fields_in_the_form_and_clicks_on_submit_button() throws InterruptedException 
	{
		objUserPage.getInstance().SetAddNewUserFormWithValues();
		Thread.sleep(3000);
		
		objUserPage.getInstance().AddNewUserFormSubmitBtnClick();
		
		Thread.sleep(3000);
	}

	@Then("Admin gets message User added Successfully")
	public void Admin_gets_message_User_added_Successfully()  
	{
		if(objUserPage.getInstance().bSaveSuccess)
			System.out.println("New User saved !");
		else
			System.out.println("User not saved !");
	}
	
	@When("Admin enters invalid data in all of the  {string} with {string} in the form and clicks on submit button")
	public void admin_enters_invalid_data_in_all_of_the_with_in_the_form_and_clicks_on_submit_button(String strColName, String strColValue, DataTable dtInvalidData) throws InterruptedException 
	{
		for(int iRow = 0; iRow <= dtInvalidData.entries().size(); iRow ++ )
		{
			if(dtInvalidData.cell(iRow, 0)!="UserRole" || dtInvalidData.cell(iRow, 0)!="UserRoleStatus" || dtInvalidData.cell(iRow, 0)!="VisaStatus")
				objUserPage.getInstance().SetAddNewUserFormWithValues(dtInvalidData.cell(iRow, 0), dtInvalidData.cell(iRow, 1), false, true);
		}
		
		objUserPage.getInstance().AddNewUserFormSubmitBtnClick();
	
		// System.out.println("Firstname DataDriven : " + objUserPage.getInstance().strUserFirstName);
		Thread.sleep(2000);
	}

	@Then("Admin gets error message and user is not created")
	public void admin_gets_error_message_and_user_is_not_created() 
	{
	    if(objUserPage.getInstance().bSaveSuccess)
	    	System.out.println("Record saved successfully !");
	    else
	    {
	    	System.out.println("Incorrect data ! Save failed !");
	    	if(!objUserPage.getInstance().strAlertMsg.contains("Success"))
	    		System.out.println("System Alert Error: " + objUserPage.getInstance().strAlertMsg);
	    }	    
	}

	@When("Admin clicks on submit button without entering data")
	public void Admin_clicks_on_submit_button_without_entering_data() throws InterruptedException  
	{
		objUserPage.getInstance().AddNewUserFormSubmitBtnClick();
	}
	
	@Then("user wont be created and Admin gets error message")
	public void user_wont_be_created_and_Admin_gets_error_message() throws InterruptedException  
	{
		if(!objUserPage.getInstance().bNewUserFormFilledWithValidData)
			System.out.println("Empty add new user form save click failed !");
		
		Thread.sleep(2000);
	}

	@When("Admin clicks CancelClose(X) Icon on User Details form")
	public void Admin_clicks_CancelCloseX_Icon_on_User_Details_form() 
	{
		objUserPage.getInstance().CheckAddNewUserFormCloseButtonClick();
	}
	
	@Then("User Details popup window should be closed without saving")
	public void User_Details_popup_window_should_be_closed_without_saving()  
	{
		if(objUserPage.getInstance().bIsAddNewUserFormVisible)
			System.out.println("Add new user closed with close button failed !");
		else
			System.out.println("Add new user closed with close button passed !");
	}
	
	@When("Admin clicks Cancel button")
	public void Admin_clicks_Cancel_button() throws InterruptedException 
	{
		objUserPage.getInstance().AddNewUserFormCancelBtnClick();;
	}
	
	@Then("Admin can see the User details popup disappears without adding any user")
	public void Admin_can_see_the_User_details_popup_disappears_without_adding_any_user()  
	{
		if(objUserPage.getInstance().bIsAddNewUserFormVisible)
			System.out.println("Add new user closed with cancel button failed !");
		else
			System.out.println("Add new user closed with cancel button passed !");
	}
	
	@When("Fill in all the fields with valid values and click submit")
	public void Fill_in_all_the_fields_with_valid_values_and_click_submit() throws InterruptedException 
	{
		Admin_clicks_Add_New_User_button();
		if(objUserPage.getInstance().CheckAddNewUserScreenVisible())
		{
			objUserPage.getInstance().SetAddNewUserFormWithValues();
			objUserPage.getInstance().AddNewUserFormSubmitBtnClick();
		}
	}

	
	@Then("Fill in all the {string} with valid {string} and click submit")
	// public void fill_in_all_the_with_valid_and_click_submit(String string1, String string2, io.cucumber.datatable.DataTable dataTable) {
	public void fill_in_all_the_with_valid_and_click_submit(String strEleName, String strEleValue, DataTable dtUserDetails) throws InterruptedException
	{			
		for(int iRow = 0; iRow <= dtUserDetails.entries().size(); iRow ++ )
		{
			if(dtUserDetails.cell(iRow, 0)!="UserRole" || dtUserDetails.cell(iRow, 0)!="UserRoleStatus" || dtUserDetails.cell(iRow, 0)!="VisaStatus")
				objUserPage.getInstance().SetAddNewUserFormWithValues(dtUserDetails.cell(iRow, 0), dtUserDetails.cell(iRow, 1), false, false);
		}
		
		// objUserPage.getInstance().AddNewUserFormSubmitBtnClick();
		
		// System.out.println("Firstname DataDriven : " + objUserPage.getInstance().strUserFirstName);
		Thread.sleep(2000);
	}
	
	@Then("The newly added user should be present in the data table in Manage User page")
	public void The_newly_added_user_should_be_present_in_the_data_table_in_Manage_User_page() throws InterruptedException  
	{
		// write code to check if the newly added user is visible in the data table.
		String strSearchString;		
		
		System.out.println("Alert: " + objUserPage.getInstance().strAlertMsg);
		
		if(objUserPage.getInstance().strAlertMsg.contains("Success"))
			if(!objUserPage.getInstance().strUserFirstName.equalsIgnoreCase(""))
				strSearchString= objUserPage.getInstance().getUserFirstNameToSearch();
			else
				System.out.println("Search string not set");
		else
			System.out.println("Failed to save record.. Cannot search the first name !");
	}
	
	// EDIT SCREEN FEATURE FILE FUNCTIONS START HERE.
	@When("Admin clicks on the edit icon")
	public void admin_clicks_on_the_edit_icon() throws InterruptedException 
	{
	    objUserPage.getInstance().RowEditIconClick();
	}

	@Then("A new pop up with User details appears")
	public void a_new_pop_up_with_user_details_appears() 
	{
		if(objUserPage.getInstance().bEditScreenDisplayed)
			System.out.println("User Details form is visible !");
		else
			System.out.println("User Details form not visible");
	}
	
	@Given("Admin is on Edit User details pop up")
	public void admin_is_on_Edit_User_details_pop_up() throws InterruptedException 
	{
		admin_clicks_on_the_edit_icon();
		
		Thread.sleep(2000);
	}

	@When("Update the {string} with valid data and click submit")
	public void update_the_with_valid_data_and_click_submit(String string, io.cucumber.datatable.DataTable dtEditUserData) throws InterruptedException 
	{
		Admin_should_see_pop_up_open_with_textboxes_for_user_details_columns();
		
		for(int iRow = 0; iRow <= dtEditUserData.entries().size(); iRow ++ )
		{			
			//System.out.println("Column read : " + dtEditUserData.cell(iRow, 0));
			
			if(dtEditUserData.cell(iRow, 0).trim().equalsIgnoreCase("Phone"))
			{
				objUserPage.getInstance().AppendEditPhNo(dtEditUserData.cell(iRow, 0));
			}
			else if(dtEditUserData.cell(iRow, 0).trim().equalsIgnoreCase("LinkedinURL"))
			{
				objUserPage.getInstance().AppendEditLinkedinURL(dtEditUserData.cell(iRow, 0));
			}
			else if(dtEditUserData.cell(iRow, 0).trim().equalsIgnoreCase("UserRole"))
			{
				objUserPage.getInstance().AppendEditUserRole(dtEditUserData.cell(iRow, 0));
			}
			else if(dtEditUserData.cell(iRow, 0).trim().equalsIgnoreCase("UserStatus"))
			{
				objUserPage.getInstance().AppendEditUserStatus(dtEditUserData.cell(iRow, 0));
			}
			else if(dtEditUserData.cell(iRow, 0).trim().equalsIgnoreCase("VisaStatus"))
			{
				objUserPage.getInstance().AppendEditVisaStatus(dtEditUserData.cell(iRow, 0));
			}
			else if(dtEditUserData.cell(iRow, 0).trim().equalsIgnoreCase("eMail"))
			{
				objUserPage.getInstance().AppendEditEmailString(dtEditUserData.cell(iRow, 0));
			}
			else if(dtEditUserData.cell(iRow, 0).trim().equalsIgnoreCase("Timezone"))
			{
				objUserPage.getInstance().AppendEditTimezoneString(dtEditUserData.cell(iRow, 0));
			}
			else
			{
				objUserPage.getInstance().AppendEditString(dtEditUserData.cell(iRow, 0), "EDIT");
			}
		}
		
		Thread.sleep(5000);
	}

	@Then("Admin gets {string} and see the updated values in data table")
	public void admin_gets_and_see_the_updated_values_in_data_table(String string, io.cucumber.datatable.DataTable dataTable) 
	{
	    
	}

	// EDIT SCREEN FEATURE FILE FUNCTIONS END HERE.
	//ADDED BY ASWINI FOR SORT

	@When("Admin clicks on ID sort icon")
	public void admin_clicks_on_id_sort_icon() {
	  
	}

	@Then("Admin should see User details are sorted by id in ascending order")
	public void admin_should_see_user_details_are_sorted_by_id_in_ascending_order() {
	  
	}

	@Then("Admin should see User details are sorted by id in descending order")
	public void admin_should_see_user_details_are_sorted_by_id_in_descending_order() {
	   
	}

	


}


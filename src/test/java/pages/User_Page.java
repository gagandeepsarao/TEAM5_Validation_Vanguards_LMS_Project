package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import app_hooks.AppHooks;
import constants.Constants;

public class User_Page 
{
	public static User_Page UserPageObjects;
	public WebDriver myDriver;
	
	public User_Page() 
	{		
//		myDriver = AppHooks.getInstance().getDriver();
	}
	Common commonFunctions = new Common(); //Added by Aswini

	public static User_Page getInstance() 
	{
		if(UserPageObjects == null) 
		{
			UserPageObjects = new User_Page();
		}
		return UserPageObjects;		
	}
	
	public int intUserPageTableHeaderColumnSize = 0;
	
	public String strTableColumnHeaderNames = "";
	public String strTableColumnHeaderEditDel = "";

	public String strUserFirstName = "";
	public String strUserMidName = "";
	public String strUserLastName = "";
	
	public String strUserLocation = "";
	public String strUserPhNo = "";
	public String strLinkedIn = "";
	
	public String strUserRole = "";
	public String strUserRoleStatus = "";
	public String strUserVisaStatus = "";
	
	public String strUserEmail = "";
	public String strUserUG = "";
	public String strUserPG = "";
	public String strUserTimezone = "";
	
	public String strUserComments = "";
	
	public String strFirstNameSearchString = "";
	public String strAlertMsg = "";
	
	public int intTotalUserPages;
	
	public boolean bIsUserPageDelAllBtnEnabled = false;
	
	public boolean bIsAddNewUserPlusBtnVisible = false;
	public boolean bIsAddNewUserBtnVisible = false;
	
	public boolean bIsAssignStaffBtnVisible = false;
	
	public boolean bIsAssignStudentBtnVisible = false;
	
	public boolean bIsSearchBtnVisible = false;
	
	public boolean bIsMinDataRowsVisible = false;
	
	public boolean bIsSavedUserNameVisible = false;
	
	public int intMinDataRowCountReqd = 2;
	public int intMinDataRowCountVisible;
	
	public boolean bDataTableGotCheckbox = false;
	
	public boolean bIsAddNewUserFormVisible = false;
	public boolean bNewUserFormFilledWithValidData = false;
	
	public boolean bIsUserDataDisplayed = false;
	public boolean bNewUserFormFilledWithValidDTData = false;
	
	public boolean bEditScreenDisplayed = false;
	
	public boolean bSaveSuccess = false;
	
	By lnkUser = By.xpath("//button[@id = 'user']");	
	By eleTableHeader = By.xpath("//thead[@class='p-datatable-thead']/tr//th[@class='p-sortable-column']");
	By eleTableHeaderEditDel = By.xpath("//thead[@class='p-datatable-thead']/tr//th[text()=' Edit / Delete']");
	By eleBtnDeleteAll = By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
	
	By eleAddNewUserPlusButton = By.xpath("//button[@id='new']/span[@class='p-button-icon p-button-icon-left pi pi-plus']");
	By eleAddNewUserButton = By.xpath("//button[@id='new']/span[@class='p-button-label']");
	
	By eleAssignStaffButton = By.xpath("//button[@id='Assign' and @label='Assign Staff']");
	
	By eleAssignStudentButton = By.xpath("//button[@id='Assign' and @label='Assign Student']");
	
	By eleSearchButton = By.xpath("//input[@id='filterGlobal']");

	By eleMinDataRowsCount = By.xpath("//tbody[@class='p-datatable-tbody']/tr");
	
	// Total no.of pages displayed
	By eleTotalUserPagesCount = By.xpath("//span[@class='p-paginator-pages ng-star-inserted']/button");
	
	By eleUserFirstNameDataTable = By.xpath("//tbody[@class='p-datatable-tbody']/tr/td[3]");
	By eleUserLastNameDataTable = By.xpath("//tbody[@class='p-datatable-tbody']/tr/td[4]");
	By eleUserPhoneNumberDataTable = By.xpath("//tbody[@class='p-datatable-tbody']/tr/td[5]");
	
	// User Page Data Row Checkbox Elements	
	By eleHeaderRowCheckBox = By.xpath("//thead[@class='p-datatable-thead']/tr[@class='ng-star-inserted']/th/p-tableheadercheckbox/div"); // 1 header row

	// First row checkbox is located using the below xpath.
	// By eleDataRowwiseCheckBox = By.xpath("//tbody[@class='p-datatable-tbody']/tr[1]/td/p-tablecheckbox/div[@class='p-checkbox p-component']/div/input[@type='checkbox']");

	// Commented Line #76 for element eleDataTableGotCheckbox as its the same as eleMinDataRowsCount
	// By eleDataTableGotCheckbox = By.xpath("//tbody[@class='p-datatable-tbody']/tr");	// 5 rows
	
	// Append strDataRowCheckBox at the end of eleMinDataRowsCount to fetch the checkbox of each row. 
	// (REPLACED eleDataTableGotCheckbox WITH eleMinDataRowsCount.
	// Prefix it with [1] to fetch the first row and change the integer to fetch corresponding row.
	String strDataRowCheckBox = "/td/p-tablecheckbox/div[@class='p-checkbox p-component']"; // /div/input[@type='checkbox']"; 
	
	// Checkbox elements end here.
	
	// User Page Data Row Edit Icon Elements
	// First row edit icon is located using the below xpath.
	By eleDataRowwiseEditIcon = By.xpath("//tbody[@class='p-datatable-tbody']/tr[1]/td[6]/div/span/button[1]"); // -> Addnl Tag to locate precisely: /span[@class='p-button-icon pi pi-pencil']");
	
	// Prefix and suffix it with [1] to get the corresponding row's Edit Icon.
	// #6 adjacent to /td denotes its the 6th element / column in the data row. Its constant.
	String strDataRowEditIcon = "/td[6]/div/span/button"; // 
	
	By eleAddNewUserForm = By.xpath("//div[@role='dialog']");
	
	By eleAddUserFirstNameLabel = By.xpath("//label[@id='mat-form-field-label-5']");
	By eleAddUserFirstName = By.xpath("//div/input[@formcontrolname='userFirstName']");
	
	By eleAddUserMiddleNameLabel = By.xpath("//label[@id='mat-form-field-label-7']");
	By eleAddUserMiddleName = By.xpath("//div/input[@formcontrolname='userMiddleName']");
	
	By eleAddUserLastNameLabel = By.xpath("//label[@id='mat-form-field-label-9']");
	By eleAddUserLastName = By.xpath("//div/input[@formcontrolname='userLastName']");
	
	By eleAddUserLocationLabel = By.xpath("//label[@id='mat-form-field-label-11']");
	By eleAddUserLocation = By.xpath("//div/input[@formcontrolname='userLocation']");

	By eleAddUserPhoneLabel = By.xpath("//label[@id='mat-form-field-label-13']");
	By eleAddUserPhone = By.xpath("//div/input[@formcontrolname='userPhoneNumber']");
	
	By eleAddUserLinkedInURLLabel = By.xpath("//label[@id='mat-form-field-label-15']");
	By eleAddUserLinkedInURL = By.xpath("//div/input[@formcontrolname='userLinkedinUrl']");
	
	By eleAddUserEmail = By.xpath("//div/input[@formcontrolname='userLoginEmail']");
	
	By eleAddUserEduUGLabel = By.xpath("//mat-card-content[@class='mat-card-content']/div[5]/div[1]/mat-form-field/div/div/div/span/label");
	By eleAddUserEduUG = By.xpath("//div/input[@formcontrolname='userEduUg']");
	
	By eleAddUserEduPGLabel = By.xpath("//mat-card-content[@class='mat-card-content']/div[5]/div[2]/mat-form-field/div/div/div/span/label");
	By eleAddUserEduPG = By.xpath("//div/input[@formcontrolname='userEduPg']");
	
	By eleAddUserTimezoneLabel = By.xpath("//mat-card-content[@class='mat-card-content']/div[5]/div[3]/mat-form-field/div/div/div/span/label");
	By eleAddUserTimezone = By.xpath("//div/input[@formcontrolname='userTimeZone']");
	
	By eleAddUserCommentsLabel = By.xpath("//mat-card-content[@class='mat-card-content']/div[6]/mat-form-field/div/div/div/span/label");
	By eleAddUserComments = By.xpath("//div/input[@formcontrolname='userComments']");
	
	By eleAddUserCancelButton = By.xpath("//mat-card-actions/button[1]");
	By eleAddUserSubmitButton = By.xpath("//mat-card-actions/button[2]");	
	
	By eleAddUserRoleLabel = By.xpath("//label[@for='userRole']");
	By eleAddUserRole = By.xpath("//div[@class='ng-tns-c101-16 p-dropdown p-component']");
	
	By eleAddUserRoleStatusLabel = By.xpath("//label[@for='userRoleStatus']");
	By eleAddUserRoleStatus = By.xpath("//div[@class='ng-tns-c101-17 p-dropdown p-component']/div[@role='button']");
	
	By eleAddUserVisaStatusLabel = By.xpath("//label[@for='userVisaStatus']");
	By eleAddUserVisaStatus = By.xpath("//div[@class='ng-tns-c101-18 p-dropdown p-component']/div[@role='button']");	
	
	By eleAddUserFormCloseButton = By.xpath("//span[@class='p-dialog-header-close-icon ng-tns-c132-6 pi pi-times']");
	//Added by Aswini
	//By sortIconTable_ID = By.xpath("//p-sorticon[@field='userId']");
	By sortIconTable_ID = By.xpath("//th[@psortablecolumn='userId']");
	By sortIconTable_name = By.xpath("//th[@psortablecolumn='userFirstName']");

	
	


	public WebElement eleAddNewUserFName;
	public WebElement eleAddNewUserMidName;
	public WebElement eleAddNewUserLastName;
	
	public WebElement eleAddNewUserLocation;
	public WebElement eleAddNewUserPhNo;
	public WebElement eleAddNewUserLinkedInURL;

	public WebElement eleAddNewUserRole;
	public WebElement eleUserRoleListVisible;
	
	public WebElement eleAddNewUserRoleStatus;
	public WebElement eleUserRoleStatusListVisible;
	
	public WebElement eleAddNewUserVisaStatus;
	public WebElement eleUserVisaStatusListVisible;
	
	public WebElement eleAddNewUserEmail;
	
	public WebElement eleAddNewUserEduUG;
	public WebElement eleAddNewUserEduPG;
	public WebElement eleAddNewUserTimezone;
	
	public WebElement eleAddNewUserComments;	
	
	public WebElement eleRowEditIcon;
	
	public void clickUserLink() 
	{
		AppHooks.getInstance().getDriver().findElement(lnkUser).click();

		
		List<WebElement> eleTotatlPages = AppHooks.getInstance().getDriver().findElements(eleTotalUserPagesCount);
		intTotalUserPages = eleTotatlPages.size();
		
		// System.out.println("Total User Pages Listed: " + intTotalUserPages);
	}
	
	public int getTableHeaderCount()
	{
		List<WebElement> eleTableHeaderList = AppHooks.getInstance().getDriver().findElements(eleTableHeader);
		
		int intUserPageTableHeaderColumnSize = eleTableHeaderList.size();
		
		return intUserPageTableHeaderColumnSize;
	}

	public String getTableColumnHeaderNames(int intIndexOf)
	{
		List<WebElement> eleTableHeaderList = AppHooks.getInstance().getDriver().findElements(eleTableHeader);
		
		strTableColumnHeaderNames = eleTableHeaderList.get(intIndexOf).getText();
		
		return strTableColumnHeaderNames;		
	}
	
	public String getTableColumnEditDelete()
	{
		strTableColumnHeaderEditDel = AppHooks.getInstance().getDriver().findElement(eleTableHeaderEditDel).getText();
		return strTableColumnHeaderEditDel;
	}
	
	public boolean IsUserPageDeleteAllButtonEnabled()
	{
		bIsUserPageDelAllBtnEnabled = AppHooks.getInstance().getDriver().findElement(eleBtnDeleteAll).isEnabled();
		return bIsUserPageDelAllBtnEnabled;
	}
	
	public boolean IsAddNewUserButtonVisible()
	{
		boolean bIsNewUserAddPlusBtnVisible;
		boolean bIsNewUserAddBtnVisible;
		
		bIsNewUserAddPlusBtnVisible = AppHooks.getInstance().getDriver().findElement(eleAddNewUserPlusButton).isDisplayed();
		bIsNewUserAddBtnVisible = AppHooks.getInstance().getDriver().findElement(eleAddNewUserButton).isDisplayed();
		
		if(bIsNewUserAddPlusBtnVisible && bIsNewUserAddBtnVisible)
			bIsAddNewUserBtnVisible = true;
		else
			bIsAddNewUserBtnVisible = false;
		
		return bIsAddNewUserBtnVisible;
	}
	
	public boolean IsAssignStaffButtonVisible()
	{		
		bIsAssignStaffBtnVisible = AppHooks.getInstance().getDriver().findElement(eleAssignStaffButton).isDisplayed();
		
		return bIsAssignStaffBtnVisible;
	}
	
	public boolean IsAssignStudentButtonVisible()
	{	
		bIsAssignStudentBtnVisible = AppHooks.getInstance().getDriver().findElement(eleAssignStudentButton).isDisplayed();
		
		return bIsAssignStudentBtnVisible;
	}
	
	public boolean IsSearchButtonVisible()
	{	
		bIsSearchBtnVisible = AppHooks.getInstance().getDriver().findElement(eleSearchButton).isDisplayed();
		
		return bIsSearchBtnVisible;
	}
	
	public int getMinDataRowCount()
	{
		List<WebElement> eleMinDataRowCount = AppHooks.getInstance().getDriver().findElements(eleMinDataRowsCount);
		
		intMinDataRowCountVisible = eleMinDataRowCount.size();
		
		return intMinDataRowCountVisible;
	}
	
	
	public boolean CheckIfDataTableGotCheckBox(Integer intRowNum) throws InterruptedException
	{
		boolean bIsHeaderRowCheckboxAvl;
		boolean bIsDataRowCheckboxAvl = false;
		
		int intDataTableRowCount;
		
		String strDRCheckBox;
		
		WebElement eleIsHeaderRowCheckboxAvl = AppHooks.getInstance().getDriver().findElement(eleHeaderRowCheckBox);
		List<WebElement> eleIsDataRowCheckboxAvl = AppHooks.getInstance().getDriver().findElements(eleMinDataRowsCount);
		
		bIsHeaderRowCheckboxAvl = eleIsHeaderRowCheckboxAvl.isDisplayed();
		intDataTableRowCount = eleIsDataRowCheckboxAvl.size();
		
		if(intRowNum <= 0)
			intRowNum = 1;
		else
		{			
			// System.out.println("Child  " + intRowNum.toString() + " : " +  eleIsDataRowCheckboxAvl.get(intRowNum));
			strDRCheckBox = (eleMinDataRowsCount.toString() + "["+ intRowNum.toString() + "]" + strDataRowCheckBox);
			strDRCheckBox = strDRCheckBox.substring(10);
			
			// System.out.println(strDRCheckBox);

			By eleDRCheckBoxString = By.xpath(strDRCheckBox);
			
			WebElement eleDRCheckBox =  AppHooks.getInstance().getDriver().findElement(eleDRCheckBoxString);
			
			Thread.sleep(1000);
			
			if(eleDRCheckBox.isDisplayed())
				bIsDataRowCheckboxAvl = true;	// "Checkbox" + intRowNum.toString() + " found"
			else
				bIsDataRowCheckboxAvl = false;	// "Checkbox" + intRowNum.toString() + " not found"
		}
		
		return bIsDataRowCheckboxAvl;
	}
	
	public boolean CheckIfDataTableGotEditIconEnabled(Integer intRowNum) throws InterruptedException
	{
		boolean bIsDataRowEditIconAvl = false;
		
		int intDataTableRowCount;
		
		String strDREditIcon;
		
		List<WebElement> eleIsDataRowCheckboxAvl = AppHooks.getInstance().getDriver().findElements(eleMinDataRowsCount);
		
		intDataTableRowCount = eleIsDataRowCheckboxAvl.size();
		
		if(intRowNum <= 0)
			intRowNum = 1;
		else
		{			
			strDREditIcon = (eleMinDataRowsCount.toString() + "["+ intRowNum.toString() + "]" + strDataRowEditIcon + "[1]");
			strDREditIcon = strDREditIcon.substring(10);

			By eleDREditIconString = By.xpath(strDREditIcon);
			
			WebElement eleDREditIcon =  AppHooks.getInstance().getDriver().findElement(eleDREditIconString);
			
			Thread.sleep(1000);
			
			if(eleDREditIcon.isEnabled())
				bIsDataRowEditIconAvl = true;	// "Edit Icon" + intRowNum.toString() + " found"
			else
				bIsDataRowEditIconAvl = false;	// "Edit Icon" + intRowNum.toString() + " not found"
		}
		
		return bIsDataRowEditIconAvl;
	}
	
	public boolean CheckIfDataTableGotDelIconEnabled(Integer intRowNum) throws InterruptedException 
	{
		boolean bIsDataRowDelIconAvl = false;
		
		int intDataTableRowCount;
		
		String strDRDelIcon = "";
		
		List<WebElement> eleIsDataRowDelIconAvl = AppHooks.getInstance().getDriver().findElements(eleMinDataRowsCount);
		
		intDataTableRowCount = eleIsDataRowDelIconAvl.size();
		
		System.out.println(strDRDelIcon);
		
		if(intRowNum <= 0)
			intRowNum = 1;
		else
		{			
			strDRDelIcon = (eleMinDataRowsCount.toString() + "["+ intRowNum.toString() + "]" + strDataRowEditIcon + "[2]");
			strDRDelIcon = strDRDelIcon.substring(10);

			// System.out.println("Web Element: " + strDRDelIcon);
			
			By eleDREditIconString = By.xpath(strDRDelIcon);
			
			WebElement eleDREditIcon =  AppHooks.getInstance().getDriver().findElement(eleDREditIconString);
			
			Thread.sleep(1000);
			
			if(eleDREditIcon.isEnabled())
				bIsDataRowDelIconAvl = true;	// "Edit Icon" + intRowNum.toString() + " found"
			else
				bIsDataRowDelIconAvl = false;	// "Edit Icon" + intRowNum.toString() + " not found"
		}
		
		return bIsDataRowDelIconAvl;
	}
	
	public void clickAddNewUserLink() throws InterruptedException 
	{
		AppHooks.getInstance().getDriver().findElement(eleAddNewUserButton);
		Thread.sleep(1000);
		AppHooks.getInstance().getDriver().findElement(eleAddNewUserButton).click();
	}
	
	public boolean CheckAddNewUserScreenVisible()
	{
		WebElement eleAddNewUserFormSeen = AppHooks.getInstance().getDriver().findElement(eleAddNewUserForm);
		
		if(eleAddNewUserFormSeen.isDisplayed())
			bIsAddNewUserFormVisible = true;
		else
			bIsAddNewUserFormVisible = false;

		return bIsAddNewUserFormVisible;
	}

	public boolean CheckUserPageFNameLabelVisible()
	{
		boolean bUserPageFNameLabelVisible = false;
		
		WebElement eleAddNewUserFNameLabel = AppHooks.getInstance().getDriver().findElement(eleAddUserFirstNameLabel);
		
		if(eleAddNewUserFNameLabel.isDisplayed())
			bUserPageFNameLabelVisible = true;
		else
			bUserPageFNameLabelVisible = false;
		
		return bUserPageFNameLabelVisible;	
	}
	
	public boolean CheckUserPageMidNameLabelVisible()
	{
		boolean bUserPageMidNameLabelVisible = false;
		
		WebElement eleAddNewUserMidNameLabel = AppHooks.getInstance().getDriver().findElement(eleAddUserMiddleNameLabel);
		
		if(eleAddNewUserMidNameLabel.isDisplayed())
			bUserPageMidNameLabelVisible = true;
		else
			bUserPageMidNameLabelVisible = false;
		
		return bUserPageMidNameLabelVisible;	
	}
	
	public boolean CheckUserPageLastNameLabelVisible()
	{
		boolean bUserPageLastNameLabelVisible = false;
		
		WebElement eleAddNewUserLastNameLabel = AppHooks.getInstance().getDriver().findElement(eleAddUserLastNameLabel);
		
		if(eleAddNewUserLastNameLabel.isDisplayed())
			bUserPageLastNameLabelVisible = true;
		else
			bUserPageLastNameLabelVisible = false;
		
		return bUserPageLastNameLabelVisible;	
	}
	
	public boolean CheckUserPageLocationLabelVisible()
	{
		boolean bUserPageLocationLabelVisible = false;
		
		WebElement eleAddNewUserLocationLabel = AppHooks.getInstance().getDriver().findElement(eleAddUserLocationLabel);
		
		if(eleAddNewUserLocationLabel.isDisplayed())
			bUserPageLocationLabelVisible = true;
		else
			bUserPageLocationLabelVisible = false;
		
		return bUserPageLocationLabelVisible;	
	}
	
	public boolean CheckUserPagePhNoLabelVisible()
	{
		boolean bUserPagePhNoLabelVisible = false;
		
		WebElement eleAddNewUserPhNoLabel = AppHooks.getInstance().getDriver().findElement(eleAddUserPhoneLabel);
		
		if(eleAddNewUserPhNoLabel.isDisplayed())
			bUserPagePhNoLabelVisible = true;
		else
			bUserPagePhNoLabelVisible = false;
		
		return bUserPagePhNoLabelVisible;	
	}
	
	public boolean CheckUserPageLinkedinURLLabelVisible()
	{
		boolean bUserPageLinkedinURLVisible = false;
		
		WebElement eleAddNewUserLinkedinURLLabel = AppHooks.getInstance().getDriver().findElement(eleAddUserLinkedInURLLabel);
		
		if(eleAddNewUserLinkedinURLLabel.isDisplayed())
			bUserPageLinkedinURLVisible = true;
		else
			bUserPageLinkedinURLVisible = false;
		
		return bUserPageLinkedinURLVisible;	
	}
	
	public boolean CheckUserPageUserRoleLabelVisible()
	{
		boolean bUserPageUserRoleLabelVisible = false;
		
		WebElement eleAddNewUserRoleLabel = AppHooks.getInstance().getDriver().findElement(eleAddUserRoleLabel);
		
		if(eleAddNewUserRoleLabel.isDisplayed())
			bUserPageUserRoleLabelVisible = true;
		else
			bUserPageUserRoleLabelVisible = false;
		
		return bUserPageUserRoleLabelVisible;	
	}
	
	public boolean CheckUserPageUserRoleStatusLabelVisible()
	{
		boolean bUserPageRoleStatusLabelVisible = false;
		
		WebElement eleAddNewRoleStatusLabel = AppHooks.getInstance().getDriver().findElement(eleAddUserRoleStatusLabel);
		
		if(eleAddNewRoleStatusLabel.isDisplayed())
			bUserPageRoleStatusLabelVisible = true;
		else
			bUserPageRoleStatusLabelVisible = false;
		
		return bUserPageRoleStatusLabelVisible;	
	}
	
	public boolean CheckUserPageVisaStatusLabelVisible()
	{
		boolean bUserPageVisaStatusLabelVisible = false;
		
		WebElement eleAddNewUserVisaStatusLabel = AppHooks.getInstance().getDriver().findElement(eleAddUserVisaStatusLabel);
		
		if(eleAddNewUserVisaStatusLabel.isDisplayed())
			bUserPageVisaStatusLabelVisible = true;
		else
			bUserPageVisaStatusLabelVisible = false;
		
		return bUserPageVisaStatusLabelVisible;	
	}
	
	public boolean CheckUserPageUGLabelVisible()
	{
		boolean bUserPageUGLabelVisible = false;
		
		WebElement eleAddNewUserUGLabel = AppHooks.getInstance().getDriver().findElement(eleAddUserEduUGLabel);
		
		if(eleAddNewUserUGLabel.isDisplayed())
			bUserPageUGLabelVisible = true;
		else
			bUserPageUGLabelVisible = false;
		
		return bUserPageUGLabelVisible;	
	}
	
	public boolean CheckUserPagePGLabelVisible()
	{
		boolean bUserPagePGLabelVisible = false;
		
		WebElement eleAddNewUserPGLabel = AppHooks.getInstance().getDriver().findElement(eleAddUserEduPGLabel);
		
		if(eleAddNewUserPGLabel.isDisplayed())
			bUserPagePGLabelVisible = true;
		else
			bUserPagePGLabelVisible = false;
		
		return bUserPagePGLabelVisible;	
	}

	public boolean CheckUserPageTimezoneLabelVisible()
	{
		boolean bUserPageTimezoneLabelVisible = false;
		
		WebElement eleAddNewUserTimezoneLabel = AppHooks.getInstance().getDriver().findElement(eleAddUserTimezoneLabel);
		
		if(eleAddNewUserTimezoneLabel.isDisplayed())
			bUserPageTimezoneLabelVisible = true;
		else
			bUserPageTimezoneLabelVisible = false;
		
		return bUserPageTimezoneLabelVisible;	
	}
	
	public boolean CheckUserPageCommentsLabelVisible()
	{
		boolean bUserPageCommentsLabelVisible = false;
		
		WebElement eleAddNewUserCommentsLabel = AppHooks.getInstance().getDriver().findElement(eleAddUserCommentsLabel);
		
		if(eleAddNewUserCommentsLabel.isDisplayed())
			bUserPageCommentsLabelVisible = true;
		else
			bUserPageCommentsLabelVisible = false;
		
		return bUserPageCommentsLabelVisible;	
	}
	
	public boolean CheckAddNewUserFNameVisible()
	{
		boolean bAddNewUserFNameVisible = false;
		
		eleAddNewUserFName = AppHooks.getInstance().getDriver().findElement(eleAddUserFirstName);
		
		if(eleAddNewUserFName.isDisplayed())
		{
			bAddNewUserFNameVisible = true;
			
			//System.out.println("Add user First name is visible");
		}
		else
			bAddNewUserFNameVisible = false;
		
		return bAddNewUserFNameVisible;	
	}
	
	public boolean CheckAddNewUserMidNameVisible()
	{
		boolean bAddNewUserMidNameVisible = false;
		
		eleAddNewUserMidName = AppHooks.getInstance().getDriver().findElement(eleAddUserMiddleName);
		
		if(eleAddNewUserMidName.isDisplayed())
		{
			bAddNewUserMidNameVisible = true;
			// System.out.println("Add user Middle name is visible");
		}
		else
			bAddNewUserMidNameVisible = false;
		
		return bAddNewUserMidNameVisible;	
	}
	
	public boolean CheckAddNewUserLastNameVisible()
	{
		boolean bAddNewUserLastNameVisible = false;
		
		eleAddNewUserLastName = AppHooks.getInstance().getDriver().findElement(eleAddUserLastName);
		
		if(eleAddNewUserLastName.isDisplayed())
		{
			bAddNewUserLastNameVisible = true;			
			// System.out.println("Add user Last name is visible");
		}
		else
			bAddNewUserLastNameVisible = false;
		
		return bAddNewUserLastNameVisible;	
	}
	
	public boolean CheckAddNewUserLocationVisible()
	{
		boolean bAddNewUserLocationVisible = false;
		
		eleAddNewUserLocation = AppHooks.getInstance().getDriver().findElement(eleAddUserLocation);
		
		if(eleAddNewUserLocation.isDisplayed())
		{
			bAddNewUserLocationVisible = true;
			// System.out.println("Add user Location is visible");
		}
		else
			bAddNewUserLocationVisible = false;
		
		return bAddNewUserLocationVisible;	
	}
	
	public boolean CheckAddNewUserPhNoVisible()
	{
		boolean bAddNewUserPhNoVisible = false;
		
		eleAddNewUserPhNo = AppHooks.getInstance().getDriver().findElement(eleAddUserPhone);
		
		if(eleAddNewUserPhNo.isDisplayed())
		{
			bAddNewUserPhNoVisible = true;			
			// System.out.println("Add user PhNo is visible");
		}
		else
			bAddNewUserPhNoVisible = false;
		
		return bAddNewUserPhNoVisible;	
	}
	
	public boolean CheckAddNewUserLinkedInURLVisible()
	{
		boolean bAddNewUserLinkedInURLVisible = false;
		
		eleAddNewUserLinkedInURL = AppHooks.getInstance().getDriver().findElement(eleAddUserLinkedInURL);
		
		if(eleAddNewUserLinkedInURL.isDisplayed())
		{
			bAddNewUserLinkedInURLVisible = true;			
			// System.out.println("Add user LinkedIn URL is visible");
		}
		else
			bAddNewUserLinkedInURLVisible = false;
		
		return bAddNewUserLinkedInURLVisible;	
	}

	public boolean CheckAddNewUserRoleVisible() throws InterruptedException
	{
		boolean bAddNewUserRoleVisible = false;
		
		eleAddNewUserRole = AppHooks.getInstance().getDriver().findElement(eleAddUserRole);
		
		if(eleAddNewUserRole.isDisplayed())
		{
			bAddNewUserRoleVisible = true;
			eleAddNewUserRole.click();
			
			Thread.sleep(1000);

			// List Container xpath
			By eleUserRoleList = By.xpath("//div[@class='p-dropdown-items-wrapper ng-tns-c101-16']/ul");
			
			// Use SELECT if the element is a combo box.
			// Select eleUserRoleListVisible = new Select(AppHooks.getInstance().getDriver().findElement(eleUserRoleList));
			
			// Locating the list container element.
			eleUserRoleListVisible = AppHooks.getInstance().getDriver().findElement(eleUserRoleList);
			
			// Use LIST<E> when the element is a List box.
			// Obtaining the listitems listed in the list container.
			List<WebElement> lstUserRole = eleUserRoleListVisible.findElements(By.xpath("//div[@class='p-dropdown-items-wrapper ng-tns-c101-16']/ul/p-dropdownitem"));
			
			// Setting the desired value as selected value in the list container.
			lstUserRole.get(0).click();
		
			//System.out.println("Add user Role is visible");
			
		}
		else
			bAddNewUserRoleVisible = false;
		
		return bAddNewUserRoleVisible;	
	}

	public boolean CheckAddNewUserRoleStatusVisible() throws InterruptedException
	{
		boolean bAddNewUserRoleStatusVisible = false;
		
		eleAddNewUserRoleStatus = AppHooks.getInstance().getDriver().findElement(eleAddUserRoleStatus);
		
		if(eleAddNewUserRoleStatus.isDisplayed())
		{
			bAddNewUserRoleStatusVisible = true;
			eleAddNewUserRoleStatus.click();
			
			Thread.sleep(1000);

			// List Container xpath
			By eleUserRoleStatusList = By.xpath("//div[@class='p-dropdown-items-wrapper ng-tns-c101-17']/ul");
			
			// Use SELECT if the element is a combo box.
			// Select eleUserRoleListVisible = new Select(AppHooks.getInstance().getDriver().findElement(eleUserRoleList));
			
			// Locating the list container element.
			eleUserRoleStatusListVisible = AppHooks.getInstance().getDriver().findElement(eleUserRoleStatusList);
			
			// Use LIST<E> when the element is a List box.
			// Obtaining the listitems listed in the list container.
			List<WebElement> lstUserRoleStatus = eleUserRoleStatusListVisible.findElements(By.xpath("//div[@class='p-dropdown-items-wrapper ng-tns-c101-17']/ul/p-dropdownitem"));
			
			// Setting the desired value as selected value in the list container.
			lstUserRoleStatus.get(0).click();
		
			//System.out.println("Add user Role Status is visible");
			
		}
		else
			bAddNewUserRoleStatusVisible = false;
		
		return bAddNewUserRoleStatusVisible;
	}

	public boolean CheckAddNewUserVisaStatusVisible() throws InterruptedException
	{
		boolean bAddNewUserVisaStatusVisible = false;
		
		eleAddNewUserVisaStatus = AppHooks.getInstance().getDriver().findElement(eleAddUserVisaStatus);
		
		if(eleAddNewUserVisaStatus.isDisplayed())
		{
			bAddNewUserVisaStatusVisible = true;
			eleAddNewUserVisaStatus.click();
			
			Thread.sleep(1000);

			// List Container xpath
			By eleUserVisaStatusList = By.xpath("//div[@class='p-dropdown-items-wrapper ng-tns-c101-18']/ul");
			
			// Use SELECT if the element is a combo box.
			// Select eleUserRoleListVisible = new Select(AppHooks.getInstance().getDriver().findElement(eleUserRoleList));
			
			// Locating the list container element.
			eleUserVisaStatusListVisible = AppHooks.getInstance().getDriver().findElement(eleUserVisaStatusList);
			
			// Use LIST<E> when the element is a List box.
			// Obtaining the listitems listed in the list container.
			List<WebElement> lstUserVisaStatus = eleUserVisaStatusListVisible.findElements(By.xpath("//div[@class='p-dropdown-items-wrapper ng-tns-c101-18']/ul/p-dropdownitem"));
			
			// Setting the desired value as selected value in the list container.
			lstUserVisaStatus.get(4).click();
		
			//System.out.println("Add user Visa Status is visible");
			
		}
		else
			bAddNewUserVisaStatusVisible = false;
		
		return bAddNewUserVisaStatusVisible;
	}

	
	public boolean CheckAddNewUserEmailVisible()
	{
		boolean bAddNewUserEmailVisible = false;
		
		eleAddNewUserEmail = AppHooks.getInstance().getDriver().findElement(eleAddUserEmail);
		
		if(eleAddNewUserEmail.isDisplayed())
		{
			bAddNewUserEmailVisible = true;			
			//System.out.println("Add user Email is visible");
		}
		else
			bAddNewUserEmailVisible = false;
		
		return bAddNewUserEmailVisible;	
	}
	
	public boolean CheckAddNewUserEduUGVisible()
	{
		boolean bAddNewUserEduUGVisible = false;
		
		eleAddNewUserEduUG = AppHooks.getInstance().getDriver().findElement(eleAddUserEduUG);
		
		if(eleAddNewUserEduUG.isDisplayed())
		{
			bAddNewUserEduUGVisible = true;
			//System.out.println("Add user EduUG is visible");
		}
		else
			bAddNewUserEduUGVisible = false;
		
		return bAddNewUserEduUGVisible;	
	}
	
	public boolean CheckAddNewUserEduPGVisible()
	{
		boolean bAddNewUserEduPGVisible = false;
		
		eleAddNewUserEduPG = AppHooks.getInstance().getDriver().findElement(eleAddUserEduPG);
		
		if(eleAddNewUserEduPG.isDisplayed())
		{
			bAddNewUserEduPGVisible = true;
			//System.out.println("Add user EduPG is visible");
		}
		else
			bAddNewUserEduPGVisible = false;
		
		return bAddNewUserEduPGVisible;	
	}
	
	public boolean CheckAddNewUserTimezoneVisible()
	{
		boolean bAddNewUserTimezoneVisible = false;
		
		eleAddNewUserTimezone = AppHooks.getInstance().getDriver().findElement(eleAddUserTimezone);
		
		if(eleAddNewUserTimezone.isDisplayed())
		{
			bAddNewUserTimezoneVisible = true;			
			//System.out.println("Add user Timezone is visible");
		}
		else
			bAddNewUserTimezoneVisible = false;
		
		return bAddNewUserTimezoneVisible;	
	}
	
	public boolean CheckAddNewUserCommentsVisible()
	{
		boolean bAddNewUserCommentsVisible = false;
		
		eleAddNewUserComments = AppHooks.getInstance().getDriver().findElement(eleAddUserComments);
		
		if(eleAddNewUserComments.isDisplayed())
		{
			bAddNewUserCommentsVisible = true;
			//System.out.println("Add user Comments is visible");
		}
		else
			bAddNewUserCommentsVisible = false;
		
		return bAddNewUserCommentsVisible;	
	}
	
	public boolean CheckAddNewCancelButtonVisible()
	{
		boolean bAddNewUserCancelButtonVisible = false;
		
		WebElement eleAddNewUserCancelBtn = AppHooks.getInstance().getDriver().findElement(eleAddUserCancelButton);
		
		if(eleAddNewUserCancelBtn.isDisplayed())
		{
			bAddNewUserCancelButtonVisible = true;
		}
		else
			bAddNewUserCancelButtonVisible = false;
		
		return bAddNewUserCancelButtonVisible;	
	}
	
	public boolean CheckAddNewUserSubmitBtnVisible()
	{
		boolean bAddNewUserSubmitBtnVisible = false;
		
		WebElement eleAddNewUserSubmitBtn = AppHooks.getInstance().getDriver().findElement(eleAddUserSubmitButton);
		
		if(eleAddNewUserSubmitBtn.isDisplayed())
		{
			bAddNewUserSubmitBtnVisible = true;
		}
		else
			bAddNewUserSubmitBtnVisible = false;
		
		return bAddNewUserSubmitBtnVisible;	
	}
	
	public void AddNewUserFormSubmitBtnClick() throws InterruptedException
	{
		//Thread.sleep(3000);
		bSaveSuccess = false;
		
		AppHooks.getInstance().getDriver().findElement(eleAddUserSubmitButton).click();
		
		if(bNewUserFormFilledWithValidData)
		{
			WebElement alertSaveSuccess = AppHooks.getInstance().getDriver().findElement(By.xpath("//div[@role='alert']/div/div[2]"));
			
			strAlertMsg = alertSaveSuccess.getText();
		
			if(alertSaveSuccess.isDisplayed())
				if(strAlertMsg.contains("Success"))
				{
					bSaveSuccess = true;
					System.out.println("Alert msg: " + strAlertMsg + " User saved");
				}
				else
				{
					bSaveSuccess = false;
					System.out.println("Alert msg: " + strAlertMsg);
				}
			bNewUserFormFilledWithValidData = false;
		}
		else if(bNewUserFormFilledWithValidDTData)
		{
			WebElement alertSaveSuccess = AppHooks.getInstance().getDriver().findElement(By.xpath("//div[@role='alert']/div/div[2]"));
			
			strAlertMsg = alertSaveSuccess.getText();
		
			if(alertSaveSuccess.isDisplayed())
				if(strAlertMsg.contains("Success"))
				{
					bSaveSuccess = true;
					System.out.println("Alert msg: " + strAlertMsg + " User saved");
				}
				else
				{
					bSaveSuccess = false;
					System.out.println("Alert msg: " + strAlertMsg);
				}
			bNewUserFormFilledWithValidDTData = false;
		}
		else
			System.out.println("Form is empty or invalid data entered !");
	}
	
	public void AddNewUserFormCancelBtnClick() throws InterruptedException 
	{
		AppHooks.getInstance().getDriver().findElement(eleAddUserCancelButton).click();
		bIsAddNewUserFormVisible = false;
		System.out.println("Cancel clicked");
		Thread.sleep(3000);
	} 
	
	public boolean CheckAddNewUserFormCloseButtonVisible()
	{
		boolean bAddNewUserFormCloseBtnVisible = false;
		
		WebElement eleAddNewUserFormCloseBtn = AppHooks.getInstance().getDriver().findElement(eleAddUserFormCloseButton);
		
		if(eleAddNewUserFormCloseBtn.isDisplayed())
		{
			bAddNewUserFormCloseBtnVisible = true;
		}
		else
			bAddNewUserFormCloseBtnVisible = false;
		
		return bAddNewUserFormCloseBtnVisible;
	}
	
	public void CheckAddNewUserFormCloseButtonClick()
	{		
		WebElement eleAddNewUserFormCloseBtn = AppHooks.getInstance().getDriver().findElement(eleAddUserFormCloseButton);
		
		if(eleAddNewUserFormCloseBtn.isDisplayed())
		{
			eleAddNewUserFormCloseBtn.click();
			System.out.println("Form Close button clicked");
			bIsAddNewUserFormVisible = false;
		}
	}
	
	public void SetAddNewUserFormWithValues()
	{
		strUserFirstName = "VanguardsFName";
		eleAddNewUserFName.sendKeys(strUserFirstName);
		
		eleAddNewUserMidName.sendKeys("VanguardsMidName");

		strUserLastName = "VanguardsLastName";
		eleAddNewUserLastName.sendKeys(strUserLastName);
		
		eleAddNewUserLocation.sendKeys("VanguardsLocation");
		
		strUserPhNo = "9516235801";
		eleAddNewUserPhNo.sendKeys(strUserPhNo);
		
		eleAddNewUserLinkedInURL.sendKeys("www.linkedin.com");		
		
		eleAddNewUserRole = AppHooks.getInstance().getDriver().findElement(eleAddUserRole);
		eleAddNewUserRole.click();
		By eleUserRoleList = By.xpath("//div[@class='p-dropdown-items-wrapper ng-tns-c101-16']/ul");
		eleUserRoleListVisible = AppHooks.getInstance().getDriver().findElement(eleUserRoleList);
		List<WebElement> lstUserRole = eleUserRoleListVisible.findElements(By.xpath("//div[@class='p-dropdown-items-wrapper ng-tns-c101-16']/ul/p-dropdownitem"));
		lstUserRole.get(0).click();
		
		eleAddNewUserRoleStatus = AppHooks.getInstance().getDriver().findElement(eleAddUserRoleStatus);
		eleAddNewUserRoleStatus.click();
		By eleUserRoleStatusList = By.xpath("//div[@class='p-dropdown-items-wrapper ng-tns-c101-17']/ul");
		eleUserRoleStatusListVisible = AppHooks.getInstance().getDriver().findElement(eleUserRoleStatusList);
		List<WebElement> lstUserRoleStatus = eleUserRoleStatusListVisible.findElements(By.xpath("//div[@class='p-dropdown-items-wrapper ng-tns-c101-17']/ul/p-dropdownitem"));
		lstUserRoleStatus.get(0).click();
		
		eleAddNewUserVisaStatus = AppHooks.getInstance().getDriver().findElement(eleAddUserVisaStatus);
		eleAddNewUserVisaStatus.click();
		By eleUserVisaStatusList = By.xpath("//div[@class='p-dropdown-items-wrapper ng-tns-c101-18']/ul");
		eleUserVisaStatusListVisible = AppHooks.getInstance().getDriver().findElement(eleUserVisaStatusList);
		List<WebElement> lstUserVisaStatus = eleUserVisaStatusListVisible.findElements(By.xpath("//div[@class='p-dropdown-items-wrapper ng-tns-c101-18']/ul/p-dropdownitem"));
		lstUserVisaStatus.get(4).click();		
		
		eleAddNewUserEmail.sendKeys("VanguardsEmailT801@gmail.com");
		eleAddNewUserEduUG.sendKeys("UserUGT5");
		eleAddNewUserEduPG.sendKeys("UserPGT5");
		eleAddNewUserTimezone.sendKeys("EST");
		eleAddNewUserComments.sendKeys("VanguardsComments");
		
		bNewUserFormFilledWithValidData = true;
	}
	
	public void SetAddNewUserFormWithValues(String strColName, String strColData, boolean bEditUserDataYN, boolean bInvalidDataEntryYN ) throws InterruptedException
	{
		bNewUserFormFilledWithValidDTData = false;
		
		if(strColName.equalsIgnoreCase("FirstName"))
		{
			if(bEditUserDataYN)
			{
				eleAddNewUserFName.sendKeys(eleAddNewUserFName.getText() + strColData);	
				strUserFirstName = eleAddNewUserFName.getText();
			}
			else
			{
				strUserFirstName = strColData;			
				eleAddNewUserFName.sendKeys(strUserFirstName);
			}
		}
		
		if(strColName.equalsIgnoreCase("MidName"))
		{
			if(bEditUserDataYN)
				eleAddNewUserMidName.sendKeys(eleAddNewUserMidName.getText() + strColData);
			else
			{
				strUserMidName = strColData;
				eleAddNewUserMidName.sendKeys(strColData);
			}
		}
		
		if(strColName.equalsIgnoreCase("LastName"))
		{
			if(bEditUserDataYN)
				eleAddNewUserLastName.sendKeys(eleAddNewUserLastName.getText() + strColData);
			else
			{
				strUserLastName = strColData;
				eleAddNewUserLastName.sendKeys(strUserLastName);
			}
		}
		
		if(strColName.equalsIgnoreCase("Location"))
		{
			if(bEditUserDataYN)
				eleAddNewUserLocation.sendKeys(eleAddNewUserLocation.getText() + strColData);
			else
			{
				strUserLocation = strColData;
				eleAddNewUserLocation.sendKeys(strUserLastName);
			}
		}
		
		if(strColName.equalsIgnoreCase("Phone"))
		{
			if(bEditUserDataYN)
				eleAddNewUserPhNo.sendKeys(eleAddNewUserPhNo.getText() + strColData);
			else
			{
				strUserPhNo = strColData;
				eleAddNewUserPhNo.sendKeys(strUserPhNo);
			}
//			eleAddNewUserLocation.sendKeys(strColData);
//			strUserPhNo = strColData;
//			eleAddNewUserPhNo.sendKeys(strUserPhNo);
		}
		
		if(strColName.equalsIgnoreCase("LinkedinURL"))
			if(bEditUserDataYN)
				eleAddNewUserLinkedInURL.sendKeys(eleAddNewUserLinkedInURL.getText() + strColData);
			else
			{
				strLinkedIn = strColData;
				eleAddNewUserLinkedInURL.sendKeys(strLinkedIn);
			}		
		
		if(strColName.equalsIgnoreCase("UserRole"))
		{
			if(bEditUserDataYN)
			{
				// eleAddNewUserLinkedInURL.sendKeys(eleAddNewUserLinkedInURL.getText() + strColData);
				// Do something here.
			}
			else
			{
				eleAddNewUserRole = AppHooks.getInstance().getDriver().findElement(eleAddUserRole);
				eleAddNewUserRole.click();
				By eleUserRoleList = By.xpath("//div[@class='p-dropdown-items-wrapper ng-tns-c101-16']/ul");
				eleUserRoleListVisible = AppHooks.getInstance().getDriver().findElement(eleUserRoleList);
				List<WebElement> lstUserRole = eleUserRoleListVisible.findElements(By.xpath("//div[@class='p-dropdown-items-wrapper ng-tns-c101-16']/ul/p-dropdownitem"));
				lstUserRole.get(0).click();
			}
		}
		
		if(strColName.equalsIgnoreCase("UserStatus"))
		{
			eleAddNewUserRoleStatus = AppHooks.getInstance().getDriver().findElement(eleAddUserRoleStatus);
			eleAddNewUserRoleStatus.click();
			By eleUserRoleStatusList = By.xpath("//div[@class='p-dropdown-items-wrapper ng-tns-c101-17']/ul");
			eleUserRoleStatusListVisible = AppHooks.getInstance().getDriver().findElement(eleUserRoleStatusList);
			List<WebElement> lstUserRoleStatus = eleUserRoleStatusListVisible.findElements(By.xpath("//div[@class='p-dropdown-items-wrapper ng-tns-c101-17']/ul/p-dropdownitem"));
			lstUserRoleStatus.get(0).click();
		}
		
		if(strColName.equalsIgnoreCase("VisaStatus"))
		{
			eleAddNewUserVisaStatus = AppHooks.getInstance().getDriver().findElement(eleAddUserVisaStatus);
			eleAddNewUserVisaStatus.click();
			
			By eleUserVisaStatusList = By.xpath("//div[@class='p-dropdown-items-wrapper ng-tns-c101-18']/ul");
			eleUserVisaStatusListVisible = AppHooks.getInstance().getDriver().findElement(eleUserVisaStatusList);
			List<WebElement> lstUserVisaStatus = eleUserVisaStatusListVisible.findElements(By.xpath("//div[@class='p-dropdown-items-wrapper ng-tns-c101-18']/ul/p-dropdownitem"));
			lstUserVisaStatus.get(4).click();	
		}
		
		if(strColName.equalsIgnoreCase("eMail"))
			eleAddNewUserEmail.sendKeys(strColData);
		
		if(strColName.equalsIgnoreCase("UGDegree"))
			eleAddNewUserEduUG.sendKeys(strColData);
		
		if(strColName.equalsIgnoreCase("PGDegree"))
			eleAddNewUserEduPG.sendKeys(strColData);
		
		if(strColName.equalsIgnoreCase("Timezone"))
			eleAddNewUserTimezone.sendKeys(strColData);

		if(strColName.equalsIgnoreCase("Comments"))
			eleAddNewUserComments.sendKeys(strColData);
		
		if(!bInvalidDataEntryYN)
			bNewUserFormFilledWithValidDTData = true;
		else
			bNewUserFormFilledWithValidDTData = false;
	}
	
	public String getUserFirstNameToSearch() throws InterruptedException
	{
		strFirstNameSearchString = strUserFirstName;
		
		WebElement eleBtnSearch = AppHooks.getInstance().getDriver().findElement(eleSearchButton);
		Thread.sleep(1000);
		
		if(eleBtnSearch.getText().equalsIgnoreCase(""))
		{	
			if(strFirstNameSearchString.equalsIgnoreCase(""))
			{
				strFirstNameSearchString = "Five";
				eleBtnSearch.sendKeys(strFirstNameSearchString);
			}
			else
				eleBtnSearch.sendKeys(strFirstNameSearchString);
			
			Thread.sleep(2000);
			System.out.println("Searched user : " + strFirstNameSearchString);
		}
		else
		{
			strFirstNameSearchString = "Five";
			System.out.println("Assigned Search String :" + strFirstNameSearchString) ;
			strFirstNameSearchString = strUserFirstName;
			
			Thread.sleep(2000);
		}		
		return strFirstNameSearchString;
	}
	
	public boolean IsSearchedUserDisplayedInDataTable(String strUserFirstName) throws InterruptedException
	{
		if(IsSearchButtonVisible())
			// getUserFirstNameToSearch();
		{
			WebElement eleBtnSearch = AppHooks.getInstance().getDriver().findElement(eleSearchButton);
			eleBtnSearch.sendKeys(strUserFirstName);	// Do not comment this line. The "sendKeys" work as search text
														// for the UserPageValidation_Two.feature file implementing
														// search for valid and invalid saved user names
			
			System.out.println("Search Button visible");
			
			List<WebElement> eleRowsVisible = AppHooks.getInstance().getDriver().findElements(eleMinDataRowsCount);
			
			if(eleRowsVisible.size()>0)
				bIsUserDataDisplayed = true;
			else
				bIsUserDataDisplayed = false;			
		}
		Thread.sleep(1000);
		
		return bIsUserDataDisplayed;
	}
	// ADD NEW USER (VALIDATION_TWO) FEATURE FILE FUNCTIONS END HERE
	
	
	// EDIT SCREEN FEATURE FILE FUNCTIONS START HERE.	
	public boolean IsRowEditIconVisible() throws InterruptedException
	{
		boolean bIsRowEditIconVisisble = false;
		String strNameToSearch = getUserFirstNameToSearch();
		
		if(IsSearchedUserDisplayedInDataTable(strNameToSearch))
		{
			eleRowEditIcon = AppHooks.getInstance().getDriver().findElement(eleDataRowwiseEditIcon);
			
			Thread.sleep(1000);
			
			if(eleRowEditIcon.isDisplayed())
				bIsRowEditIconVisisble = true;
		}
		else
			System.out.println("Row Edit Icon not visible");
		
		return bIsRowEditIconVisisble;
	}
	
	public void RowEditIconClick() throws InterruptedException
	{
		strUserFirstName = AppHooks.getInstance().getDriver().findElement(eleUserFirstNameDataTable).getText();
		Thread.sleep(2000);
		System.out.println("First Name: " + strUserFirstName);
		
		eleRowEditIcon = AppHooks.getInstance().getDriver().findElement(eleDataRowwiseEditIcon);
		eleRowEditIcon.click();
		
		WebElement eleUserDtlsForm = AppHooks.getInstance().getDriver().findElement(eleAddNewUserForm);
		
		if(eleUserDtlsForm.isDisplayed())
		{
			bEditScreenDisplayed = true;

			System.out.println("First Name: " + strUserFirstName);
		}
		else
			bEditScreenDisplayed = false;
		
		Thread.sleep(2000);
	}
	

	public void AppendEditString(String strColName, String strEditString) throws InterruptedException
	{
		SetAddNewUserFormWithValues(strColName, strEditString, true, true);
	}	
	
	public void AppendEditPhNo(String strColName) throws InterruptedException
	{			
		SetAddNewUserFormWithValues(strColName, "00", true, true);
	}	
	
	public void AppendEditLinkedinURL(String strColName) throws InterruptedException
	{		
		SetAddNewUserFormWithValues(strColName, ("/EDIT") , true, true);
	}	
	
	public void AppendEditUserRole(String strColName) throws InterruptedException
	{
		String strEditString="";
		
		SetAddNewUserFormWithValues(strColName, strEditString, true, true);
	}	
	
	public void AppendEditUserStatus(String strColName) throws InterruptedException
	{
		String strEditString="";
		
		SetAddNewUserFormWithValues(strColName, strEditString, true, true);
	}	
	
	public void AppendEditVisaStatus(String strColName) throws InterruptedException
	{
		String strEditString="";
		
		SetAddNewUserFormWithValues(strColName, strEditString, true, true);
	}	
	
	public void AppendEditEmailString(String strColName) throws InterruptedException
	{
		String strEditString="";
		
		SetAddNewUserFormWithValues(strColName, strEditString, true, true);
	}	
	
	public void AppendEditTimezoneString(String strColName) throws InterruptedException
	{
		String strEditString="";
		
		SetAddNewUserFormWithValues(strColName, strEditString, true, true);
	}	
	// EDIT SCREEN FEATURE FILE FUNCTIONS END HERE
// ADDED BY ASWINI
	public void ValidateSortIcon_userID()
	{
		commonFunctions.Click_SortIcon(sortIconTable_ID, "USER ID");
	}
	public void ValidateSortIcon_userID_Ascending()
	{
		commonFunctions.ValidateAscending_SortIcon(sortIconTable_ID, "USER ID");
	}
	public void ValidateSortIcon_userID_Descending()
	{
		commonFunctions.ValidateDescending_SortIcon(sortIconTable_ID, "USER ID");
	}


}

package pages;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.cucumber.java.eo.Se;
import io.cucumber.java.sl.In;
import org.openqa.selenium.*;

import app_hooks.AppHooks;
import constants.Constants;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class User_DeleteAssignPage 
{
	public static User_DeleteAssignPage UserPageObjects;
	
	public User_DeleteAssignPage() {};

	public static User_DeleteAssignPage getInstance() 
	{
		if(UserPageObjects == null) 
		{
			UserPageObjects = new User_DeleteAssignPage();
		}
		return UserPageObjects;
	}
	
	public int intUserPageTableHeaderColumnSize = 0;
	
	public String strTableColumnHeaderNames = "";
	public String strTableColumnHeaderEditDel = "";
	
	public boolean bIsUserPageDelAllBtnEnabled = true;
	
	public boolean bIsAddNewUserPlusBtnVisible = true;
	public boolean bIsAddNewUserBtnVisible = true;
	By lnkUser = By.xpath("//button[@id = 'user']");
	By eleTableHeader = By.xpath("//thead[@class='p-datatable-thead']/tr//th[@class='p-sortable-column']");
	By eleTableHeaderEditDel = By.xpath("//thead[@class='p-datatable-thead']/tr//th[text()=' Edit / Delete']");
	By eleBtnDeleteAll = By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
	By eleAddNewUserPlusButton = By.xpath("//button[@id='new']/span[@class='p-button-icon p-button-icon-left pi pi-plus']");
	By eleAddNewUserButton = By.xpath("//button[@id='new']/span[@class='p-button-label']");
	By deleteMessage =  By.xpath("//div[contains(@class,'p-toast-detail')]");
	By deletButton =  By.xpath("//span/button[contains(@class,'p-button-danger')]");
	By alertBox = By.xpath("//div[@class='ng-trigger ng-trigger-animation ng-tns-c133-9 p-dialog p-confirm-dialog p-component ng-star-inserted']");
	By confirmHeader = By.xpath("//span[text()='Confirm']");
	By yesButton = By.xpath("//span[text()='Yes']");
	By noButton = By.xpath("//span[text()='No']");
	By closeButton =  By.xpath("//div[@class='p-dialog-header-icons ng-tns-c133-9']");
	By checkBox = By.xpath("//tbody/tr[1]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
	By checkMultipleBoxes = By.xpath("//tbody/tr/td/p-tablecheckbox");
	By commonDeleteButton = By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
	By firstRowData = By.xpath("//tbody/tr[1]/td[2]");
	By multipleIds = By.xpath("//tbody/tr/td[2]");
	By assignButton = By.xpath("//span[normalize-space()='Assign Student']");
	By assignStudentPopUp = By.xpath("//div[@class='ng-trigger ng-trigger-animation ng-tns-c132-8 p-fluid p-dialog p-component p-dialog-draggable p-dialog-resizable ng-star-inserted']");
	By cancelAssignStudent = By.xpath("//span[normalize-space()='Cancel']");
	By saveAssignStudent = By.xpath("//span[normalize-space()='Save']");
	By closeAssignStudent = By.xpath("//div[@class='p-dialog-header-icons ng-tns-c132-8']");
	By studentRole  = By.xpath("//input[@name='roleId']");
	By studentEmail = By.xpath("//span[text()='Select Email ID']");
//	By programName = By.xpath("//input[@name='programName']");
	By programName = By.xpath("//span[text()='Select a Program name ']");
	By batchName = By.xpath("//span[text()='Select Batch']");
	By studentStatus = By.xpath("//label[@for='online']");
	By activeStatus = By.xpath("//div[@class=\"ng-star-inserted\"]");
	By activeCheckBox = By.xpath("//div[@class='p-radiobutton p-component']");
	By emailError = By.xpath("//div[text()=\" User Email Id is required. \"]");
	By programError = By.xpath("//div[text()=' Program Name is required. ']");
	By batchError = By.xpath("//div[text()=' Batch Name is required. ']");
	By statusError = By.xpath("//div[text()=' Status is required. ']");
	By firstEmail = By.xpath("//span[text()='qram@gmail.com']");
	By emailSearch = By.xpath("//input[@class='p-dropdown-filter p-inputtext p-component ng-tns-c101-10']");
	By assignProgramName = By.xpath("//span[text()='Team5VV']");
	By assignBatchName = By.xpath("//span[text()='Team05']");
	By assignStudentSuccess = By.xpath("//div[text()='User  has been successfully assigned/Updated to Program/Batch(es)']");
	By assignStaffButton = By.xpath("//span[text()='Assign Staff']");

	By staffAssignPopupPresent = By.xpath("//div[@class='ng-trigger ng-trigger-animation ng-tns-c132-7 p-fluid p-dialog p-component p-dialog-draggable p-dialog-resizable ng-star-inserted']");
	By saveAssignStaff = By.xpath("//span[text()='Save']");

	By cancelAssignStaff = By.xpath("//span[text()='Cancel']");
	By closeAssignStaff = By.xpath("//button[@class='ng-tns-c132-7 p-dialog-header-icon p-dialog-header-close p-link p-ripple ng-star-inserted']");

	By userRole = By.xpath("//input[@id='roleId']");

	By radioButtons = By.xpath("//p-radiobutton[@id='userStatus']");

	By userEmailError = By.xpath("//div[text()=' Email Id is required. ']");
	By getUserProgramError = By.xpath("//div[text()=\" Program Name is required. \"]");
	By getUserBatchError = By.xpath("//div[text()=\" Batch Name is required. \"]");
	By getUserStatusError = By.xpath("//div[text()=\" Status is required. \"]");

	By getUserSkillError = By.xpath("//div[text()=\" Skill is required. \"]");

	By staffEmail = By.xpath("//span[text()=\"Select Email Id\"]");

	By staffEmails = By.xpath("//ul[@role=\"listbox\"]//li");
	By firstStaffEmail =  By.xpath("//span[text()='rRam@gmail.com']");
	By staffBatchName = By.xpath("//div[text()=\"Select Batch Name\"]");

	By firstBatchName = By.xpath("//ul[@role='listbox']//li");

	By assignStaffSuccess = By.xpath("//div[text()='User  has been successfully assigned/Updated to Program/Batch(es)']");

	public void clickDeleteBtn() {
		AppHooks.getInstance().getDriver().findElement(deletButton).click();
	}
	
	public void switchToAlert() {
		WebElement element = AppHooks.getInstance().getDriver().findElement(alertBox);
	    ((JavascriptExecutor) AppHooks.getInstance().getDriver()).executeScript("arguments[0].click()", element);
		System.out.print("Switched to Alert successfulyy..............");
		}
	
	public String checkHeading() {
		String heading = AppHooks.getInstance().getDriver().findElement(confirmHeader).getText();
		return heading;
	}
	
	public boolean checkYesButtonPresent() {
		return AppHooks.getInstance().getDriver().findElement(yesButton).isDisplayed();
	}
	
	public boolean checkNoButtonPresent() {
		return AppHooks.getInstance().getDriver().findElement(noButton).isDisplayed();
	}
	
	public void clickYesButton() {
		AppHooks.getInstance().getDriver().findElement(yesButton).click();
	}
	
	public void clickNoButton() {
		AppHooks.getInstance().getDriver().findElement(noButton).click();
	}

	public boolean alertBoxNotPresent(){
		WebDriverWait wait = new WebDriverWait(AppHooks.getInstance().getDriver(), Duration.ofSeconds(2));
		boolean present = wait.until(ExpectedConditions.invisibilityOfElementLocated(alertBox));
		System.out.println("alert is present ++++++++++" +present);
		return present;
	}

	public void clickCloseButton(){
		switchToAlert();
		AppHooks.getInstance().getDriver().findElement(closeButton).click();
	}

	public void clickCheckBox(){
		AppHooks.getInstance().getDriver().findElement(checkBox).click();
	}



//	public void clickMultipleCheckBox(){
//		List<WebElement> checkBoxes = AppHooks.getInstance().getDriver().findElements(checkMultipleBoxes);
//		for (WebElement checkbox: checkBoxes)
//			  {
//				  checkbox.click();
//			  }
//		System.out.println("Clicked multiple checkboxes");
//
//	}
	public void clickMultipleCheckBox(String[] filteredId){
	    List<WebElement> rows = AppHooks.getInstance().getDriver().findElements(checkMultipleBoxes);
	    for (WebElement row: rows)
	         {
	            String id = row.findElement(By.xpath("td[2]")).getText();
	            if(Arrays.asList(filteredId).contains(id)){
	               System.out.println("Clicking id: " + id);
	               row.findElement(By.xpath("td[1]")).click();
	            }

	            //checkbox.click();
	         }
	    System.out.println("Clicked checkboxes");

	}

	public boolean checkCommonDeleteButton(){
		boolean enabled = AppHooks.getInstance().getDriver().findElement(commonDeleteButton).isEnabled();
		return enabled;
	}

	public void clickCommonDeleteButton(){
		AppHooks.getInstance().getDriver().findElement(commonDeleteButton).click();
	}

	public String getFirstRowData(){
		String id = AppHooks.getInstance().getDriver().findElement(firstRowData).getText();
		System.out.println("Value of id " +id);
		return id;
	}

	public List getAllSelectedIds(){
		List <WebElement> rowIds  =  AppHooks.getInstance().getDriver().findElements(multipleIds);
		List <String> allIds = new ArrayList<>();
		for (WebElement id: rowIds) {
			allIds.add(id.getText());
		}
		System.out.println(allIds);
		return allIds;
	}
	public void clickUserLink() throws InterruptedException {
		AppHooks.getInstance().getDriver().findElement(lnkUser).click();
		Thread.sleep(5000);
	}

	public void clickAssignStudent(){
		AppHooks.getInstance().getDriver().findElement(assignButton).click();
	}

	public boolean studentAssignPopupPresent(){
		try {
			AppHooks.getInstance().getDriver().findElement(assignStudentPopUp).isDisplayed();
		}catch (NoSuchElementException e){
			return false;
		}
		return true;
	}


	public boolean cancelAssignButtonPresent(){
		boolean present = AppHooks.getInstance().getDriver().findElement(cancelAssignStudent).isDisplayed();
		return present;
	}

	public boolean saveAssignButtonPresent(){
		boolean present = AppHooks.getInstance().getDriver().findElement(saveAssignStudent).isDisplayed();
		return present;
	}

	public boolean closeAssignButtonPresent(){
		boolean present = AppHooks.getInstance().getDriver().findElement(closeAssignStudent).isDisplayed();
		return present;
	}

	public boolean studentRolePresent(){
		boolean present = AppHooks.getInstance().getDriver().findElement(studentRole).isDisplayed();
		return present;
	}

	public boolean studentEmailPresent(){
		boolean present = AppHooks.getInstance().getDriver().findElement(studentEmail).isDisplayed();
		return present;
	}

	public boolean studentProgramPresent(){
		boolean present = AppHooks.getInstance().getDriver().findElement(programName).isDisplayed();
		return present;
	}

	public boolean studentBatchPresent(){
		boolean present = AppHooks.getInstance().getDriver().findElement(batchName).isDisplayed();
		return present;
	}

	public boolean studentStatusPresent(){
		boolean present = AppHooks.getInstance().getDriver().findElement(studentStatus).isDisplayed();
		return present;
	}

	public boolean statusButton(){
		int count = AppHooks.getInstance().getDriver().findElements(activeStatus).size();
		return count==2;
	}

	public void clicksaveAssignStudentButton() throws InterruptedException {
		AppHooks.getInstance().getDriver().findElement(saveAssignStudent).click();
		Thread.sleep(2000);
	}
	public String getEmailError(){
		String error =  AppHooks.getInstance().getDriver().findElement(emailError).getText();
		return error;
	}
	public String getProgramError(){
		String error =  AppHooks.getInstance().getDriver().findElement(programError).getText();
		return error;
	}
	public String getBatchError(){
		String error =  AppHooks.getInstance().getDriver().findElement(batchError).getText();
		System.out.println(error);
		return error;
	}
	public String getStatusError(){
		String error =  AppHooks.getInstance().getDriver().findElement(statusError).getText();
		return error;
	}

	public void enterProgramName(){
		System.out.println("Selecting program ");
		WebElement programDropDown = AppHooks.getInstance().getDriver().findElement(programName);
		programDropDown.click();
		WebDriverWait wait = new WebDriverWait(AppHooks.getInstance().getDriver(), Duration.ofSeconds(10)); // 10 seconds timeout
		WebElement firstOption = wait.until(ExpectedConditions.visibilityOfElementLocated(assignProgramName));
		firstOption.click();
		System.out.println("program selected");
		//AppHooks.getInstance().getDriver().findElement(programName).sendKeys("test");
	}

	public  void enterBatchName() throws InterruptedException {
		System.out.println("Selecting batch ");
		WebElement batchDropDown = AppHooks.getInstance().getDriver().findElement(batchName);
		batchDropDown.click();
		WebDriverWait wait = new WebDriverWait(AppHooks.getInstance().getDriver(), Duration.ofSeconds(10)); // 10 seconds timeout
		WebElement firstOption = wait.until(ExpectedConditions.visibilityOfElementLocated(assignBatchName));
		firstOption.click();
		System.out.println("batch selected");

	}

	public void checkStatus(){
		System.out.println("Status is selected");
		AppHooks.getInstance().getDriver().findElement(activeCheckBox).click();
	}

	public void enterStudentEmail() throws InterruptedException {
		WebElement emailDropDown = AppHooks.getInstance().getDriver().findElement(studentEmail);
		emailDropDown.click();
	//	WebDriverWait wait = new WebDriverWait(AppHooks.getInstance().getDriver(), Duration.ofSeconds(10)); // 10 seconds timeout
	//	WebElement firstOption = wait.until(ExpectedConditions.visibilityOfElementLocated(firstEmail));
		AppHooks.getInstance().getDriver().findElement(emailSearch).sendKeys("qram@gmail.com");
		WebElement email = AppHooks.getInstance().getDriver().findElement(firstEmail);
		email.click();
		System.out.println("email selected");
	}

	public void clickCloseAssignButton(){
		AppHooks.getInstance().getDriver().findElement(closeAssignStudent).click();
	}

	public String assignStudentSuccess(){
		String message=AppHooks.getInstance().getDriver().findElement(assignStudentSuccess).getText();
		return message;
	}

	public void assignStaffButton(){
		AppHooks.getInstance().getDriver().findElement(assignStaffButton).click();
		System.out.println("AssignStaffButton is clicked");
	}

	public boolean staffAssignPopupPresent(){
		try {
			AppHooks.getInstance().getDriver().findElement(staffAssignPopupPresent).isDisplayed();
		}catch (NoSuchElementException e){
			return false;
		}
		return true;
	}

	public void clickSaveAssignStaff(){
		AppHooks.getInstance().getDriver().findElement(saveAssignStaff).click();
		System.out.println("Save Assign Staff clicked");
	}
	public boolean saveAssignStaff(){
		boolean present = AppHooks.getInstance().getDriver().findElement(saveAssignStaff).isDisplayed();
		return present;
	}

	public void clickCancelAssignStaff(){
		AppHooks.getInstance().getDriver().findElement(cancelAssignStaff).click();
	}
	public boolean cancelAssignStaff(){
		boolean present=AppHooks.getInstance().getDriver().findElement(cancelAssignStaff).isDisplayed();
		return present;
	}

	public void clickCloseAssignStaff(){
		AppHooks.getInstance().getDriver().findElement(closeAssignStaff).click();
	}
	public boolean closeAssignStaff(){
		boolean present = AppHooks.getInstance().getDriver().findElement(closeAssignStaff).isDisplayed();
		return present;
	}

	public boolean userRolePresent(){
		boolean present = AppHooks.getInstance().getDriver().findElement(userRole).isDisplayed();
		return present;
	}

	public boolean radioButtons(){
		int count = AppHooks.getInstance().getDriver().findElements(radioButtons).size();
		return count==2 ;
	}

	public String getUserAssignError(){
		String error = AppHooks.getInstance().getDriver().findElement(userEmailError).getText();
		return error;
	}

	public String getUserBatchError(){
		String error = AppHooks.getInstance().getDriver().findElement(getUserBatchError).getText();
		System.out.println("Error is:" +error );
		return error;
	}
	public String getUserStatusError(){
		String error = AppHooks.getInstance().getDriver().findElement(getUserStatusError).getText();
		return error;
	}

	public String getUserSkillError(){
		String error;
		try {
			 error = AppHooks.getInstance().getDriver().findElement(getUserSkillError).getText();
		}catch (NoSuchElementException e) {
            return "";
        }
		return error;
	}

	public String getUserProgramError(){
		String error = AppHooks.getInstance().getDriver().findElement(getUserProgramError).getText();
		return error;
	}

	public void selectUserEmail() throws InterruptedException {
		WebElement emailDropDown = AppHooks.getInstance().getDriver().findElement(staffEmail);
		emailDropDown.click();
		Thread.sleep(2000);
		List <WebElement> emailList = AppHooks.getInstance().getDriver().findElements(staffEmails);
		WebElement userEmail = AppHooks.getInstance().getDriver().findElement(firstStaffEmail);
		for (WebElement email:emailList) {
			System.out.println("email is" +email.getText());

			if(email.getText().equals(userEmail.getText())){
				System.out.println("email is" +email.getText());
				email.click();

				break;
			}
		}
		System.out.println("email selected");
	}

	public void selectUserProgram() throws InterruptedException {
		System.out.println("Selecting program ");
		WebElement programDropDown = AppHooks.getInstance().getDriver().findElement(programName);
		programDropDown.click();
		WebDriverWait wait = new WebDriverWait(AppHooks.getInstance().getDriver(), Duration.ofSeconds(10)); // 10 seconds timeout
		WebElement firstOption = wait.until(ExpectedConditions.visibilityOfElementLocated(assignProgramName));
		firstOption.click();
		System.out.println("program selected");
	}

	public void selectUserBatch() throws InterruptedException {
		System.out.println("Selecting program ");
		WebElement bacthDropDown = AppHooks.getInstance().getDriver().findElement(staffBatchName);
		bacthDropDown.click();
		WebDriverWait wait = new WebDriverWait(AppHooks.getInstance().getDriver(), Duration.ofSeconds(10)); // 10 seconds timeout
		WebElement firstOption = wait.until(ExpectedConditions.visibilityOfElementLocated(firstBatchName));
		firstOption.click();
		System.out.println("batch selected");
	}

	public String assignStaffSuccess(){
		String message=AppHooks.getInstance().getDriver().findElement(assignStaffSuccess).getText();
		return message;
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
	
	public String getAlertMessage() {
		WebDriverWait wait = new WebDriverWait(AppHooks.getInstance().getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(deleteMessage));
		String message =  AppHooks.getInstance().getDriver().findElement(deleteMessage).getText();
		return message;
	}
	public String[] removeRestrictedId(String[] ids){
		String[] restrictedIds = {
				"U1", "U2", "U3", "U4", "U5", "U6", "U7", "U8", "U9", "U10",
				"U11", "U12", "U13", "U14", "U15", "U16", "U17", "U18", "U19", "U20",
				"U21", "U22", "U23", "U24", "U25", "U26", "U27", "U28", "U29", "U30",
				"U31", "U32", "U33", "U34", "U35", "U36", "U37", "U38", "U39", "U40",
				"U41", "U42", "U43", "U44", "U45", "U46", "U47", "U48", "U49", "U50",
				"U51", "U52", "U53", "U54", "U55", "U56", "U57", "U58", "U59", "U60",
				"U61", "U62", "U63"
		};

		List<String> filteredIdsList = new ArrayList<>();

		for (String id : ids) {
			boolean isRestricted = false;
			for (String restrictedId : restrictedIds) {
				if (id.equals(restrictedId)) {
					isRestricted = true;
					break;
				}
			}
			if (!isRestricted) {
				filteredIdsList.add(id);
			}
		}

		return filteredIdsList.toArray(new String[0]);
	}
}

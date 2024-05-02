package pages;

import pages.Common; //Added by Aswini
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import app_hooks.AppHooks;
import constants.Constants;
import utilities.Logger_Load;

public class ProgramPage {
	private static ProgramPage programPageObjects;

	
	private ProgramPage() {};

	Common commonFunctions = new Common(); //Added by Aswini

	public static ProgramPage getInstance() {

		if(programPageObjects==null) {
			programPageObjects= new ProgramPage();
		}
		return programPageObjects;

	}

	
	By programBtn = By.xpath("//button[@id='program']");
	By batchBtn = By.xpath("//button[@id='batch']");
	By userBtn = By.xpath("//button[@id='user']");
	By logoutBtn = By.xpath("//button[@id='logout']");

	
	
	By deleteBtn = By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
	By addProgramBtn=By.xpath("//span[normalize-space()='A New Program']");
	By manageProgramHeading = By.xpath("//div[normalize-space()='Manage Program']");
	
	By paginatorMessage = By.xpath("//span[@class='p-paginator-current ng-star-inserted']");
	By footerMessage = By.xpath("//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']");

	By newProgramBtn = By.xpath("//button[@id='new']");
	By searchBtn = By.xpath("//input[@id='filterGlobal']");
	//By LMSDashboardTitle = By.xpath("//span[normalize-space()='LMS - Learning Management System']");
	By headerTable = By.xpath("//table//thead[@class='p-datatable-thead']//th");
	
	By contentTable = By.xpath("//table//tbody[@class='p-datatable-tbody']//tr");

	By sortIconTable_programName = By.xpath("//p-sorticon[@field='programName']");
	By sortIconTable_description = By.xpath("//p-sorticon[@field='description']");
	By sortIconTable_status = By.xpath("//p-sorticon[@field='status']");

	By prevPaginatorBtn = By.xpath("//button[contains(@class,'p-paginator-prev')]");
	By firstPaginatorBtn = By.xpath("//button[contains(@class,'p-paginator-first')]");
	By nextPaginatorBtn = By.xpath("//button[contains(@class,'p-paginator-next')]");
	By lastPaginatorBtn = By.xpath("//button[contains(@class,'p-paginator-last')]");
	  
	//By progNameSortIcon = By.xpath("//p-sorticon[@field='programName']");
	//By progDescSortIcon = By.xpath("//p-sorticon[@field='description']");
	//By statusSortIcon = By.xpath("//p-sorticon[@field='status']");
	
	
	By progNameSortIcon = By.xpath("//th[@psortablecolumn='programName']");
	By progDescSortIcon = By.xpath("//th[@psortablecolumn='programDescription']");
	By progstatusSortIcon = By.xpath("//th[@psortablecolumn='programStatus']");

	public void clickProgramLink() {
		AppHooks.getInstance().getDriver().findElement(programBtn).click();
		Logger_Load.info("Clicked on Program Button on navigation bar....");

	}
	public void clickBatchLink() {
		AppHooks.getInstance().getDriver().findElement(batchBtn).click();
		Logger_Load.info("Clicked on Batch Button on navigation bar....");


	}
	public void clickUserLink() {
		AppHooks.getInstance().getDriver().findElement(userBtn).click();
		Logger_Load.info("Clicked on User Button on navigation bar....");

	}
	public void clickLogoutLink() {
		AppHooks.getInstance().getDriver().findElement(logoutBtn).click();
		Logger_Load.info("Clicked on Logout Button on navigation bar....");

	}

	public void DashboardPageVerification()
	{
		commonFunctions.verifyDashboardPage();
	}
	
	public void verifyProgramURL()
	{
		String programURL = AppHooks.getInstance().getDriver().getCurrentUrl();
		//Assert.assertEquals(programURL, "https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/");
		Assert.assertEquals(programURL, Constants.PROGRAMPAGEURL);
		if(programURL.equals("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/"))
			Logger_Load.info("Admin is able to see URL in Manage Program" );
		else
			Logger_Load.error("Admin is not able to see URL in Manage Program" );

	}
	
	public void ManageProgram_HeadingVerification(String PageHeading)
	{
		commonFunctions.CheckPageHeading(PageHeading);
	}
	public void ManageBatch_HeadingVerification(String PageHeading)
	{
		commonFunctions.CheckPageHeading(PageHeading);
	}
	public void ManageUser_HeadingVerification(String PageHeading)
	{
		commonFunctions.CheckPageHeading(PageHeading);
	}
	public void paginationMessageVerification()
	{
		commonFunctions.checkPaginationMessage(paginatorMessage);
	}
	
	public void ProgramFooter_MessageVerification() 
	{
		commonFunctions.checkFooterMessage(footerMessage, "programs");
		
	}
	public void Program_CheckDeleteBtn() 
	{
		commonFunctions.CheckButton_DisableStatus(deleteBtn,"Delete Button");
	}
	
	public void Program_CheckAddProgramBtn()
	{
		commonFunctions.CheckButton_IsDisplayed(addProgramBtn,"Add Program Button");
	}
	public void Program_CheckTableHeader()
	{
		commonFunctions.CheckTable_NoOfRows(addProgramBtn, 0);
	}
	
	public void CheckTable_ProgramTableHeaders(By TableElement)
	{

		int totRowsHead = AppHooks.getInstance().getDriver().findElements(TableElement).size();
		if(totRowsHead==5)
		{	
			Logger_Load.info("Program Table Headers are....");
			Logger_Load.info(AppHooks.getInstance().getDriver().findElements(TableElement).get(1).getText());
			Logger_Load.info(AppHooks.getInstance().getDriver().findElements(TableElement).get(2).getText());
			Logger_Load.info(AppHooks.getInstance().getDriver().findElements(TableElement).get(3).getText());
			Logger_Load.info(AppHooks.getInstance().getDriver().findElements(TableElement).get(4).getText());
		}
		else
			Logger_Load.error("Program Table Header is not as expected");
		
		Assert.assertEquals(AppHooks.getInstance().getDriver().findElements(TableElement).get(1).getText(), "Program Name");
		Assert.assertEquals(AppHooks.getInstance().getDriver().findElements(TableElement).get(2).getText(), "Program Description");
		Assert.assertEquals(AppHooks.getInstance().getDriver().findElements(TableElement).get(3).getText(), "Program Status");
		Assert.assertEquals(AppHooks.getInstance().getDriver().findElements(TableElement).get(4).getText(), "Edit / Delete");



	}
	
	public void Validate_ProgramTableRows()
	{
		commonFunctions.CheckTable_NoOfRows(contentTable, 5);
	}
	
	public void Validate_ProgramTableHeaders()
	{
		CheckTable_ProgramTableHeaders(headerTable);
	}
	
	public void Validate_ProgramTable_SortIcon()
	{
		boolean status_sortIconTable_programName = AppHooks.getInstance().getDriver().findElement(sortIconTable_programName).isDisplayed();
		boolean status_sortIconTable_description = AppHooks.getInstance().getDriver().findElement(sortIconTable_description).isDisplayed();
		boolean status_sortIconTable_status = AppHooks.getInstance().getDriver().findElement(sortIconTable_status).isDisplayed();
		if(status_sortIconTable_programName)
			Logger_Load.info("Sort arrow icon is present in Program Name Header ");
		else
			Logger_Load.warn("Sort arrow icon is not present in Program Name Header ");
		if(status_sortIconTable_description)
			Logger_Load.info("Sort arrow icon is present in Program Description Header ");
		else
			Logger_Load.warn("Sort arrow icon is not present in Program Description Header ");
		if(status_sortIconTable_status)
			Logger_Load.info("Sort arrow icon is present in Program Status Header ");
		else
			Logger_Load.warn("Sort arrow icon is not present in Program status Header ");
		Assert.assertTrue(status_sortIconTable_programName);
		Assert.assertTrue(status_sortIconTable_description);
		Assert.assertTrue(status_sortIconTable_status);

	}
public void ValidateCheckbox_ProgramTable()
{
	
	commonFunctions.CheckTable_CheckBox(contentTable);

}
public void ValidateEditDeleteButton_ProgramTable()
{
	commonFunctions.CheckTable_EditBtn(contentTable);
	
	commonFunctions.CheckTable_DeleteBtn(contentTable);

}

public void ValidateSearchBar()
{
	commonFunctions.checkSearchBar_WithSearch(searchBtn);
}

public void ValidateLogout()

{
	commonFunctions.verifyLogout();
}
public void ClickNextPagination()
{
	commonFunctions.clickPaginatorNext(nextPaginatorBtn);
}

public void ValidateNextPagination()
{
	commonFunctions.checkNextPagination(paginatorMessage);
}
public void ClickLastPagination()
{
	commonFunctions.clickPaginatorLast(lastPaginatorBtn);
}

public void ValidateLastPagination()
{
	commonFunctions.checkLastPagination(paginatorMessage);
}
public void ClickPrevPagination()
{
	commonFunctions.clickPaginatorPrev(prevPaginatorBtn);
}
public void ValidatePrevPagination()
{
	commonFunctions.checkPrevPagination(paginatorMessage);
}

public void ClickFirstPagination()
{
	commonFunctions.clickPaginatorFirst(firstPaginatorBtn);
}
public void ValidateFirstPagination()
{
	commonFunctions.checkFirstPagination(paginatorMessage);
}
//#####     Validates Sorting(data ordering) on the Program Data table

public void ValidateSortIcon_ProgramName()
{
	commonFunctions.Click_SortIcon(progNameSortIcon, "Program Name");
}
public void ValidateSortIcon_ProgramDescription()
{
	commonFunctions.Click_SortIcon(progDescSortIcon, "Program Description");
}
public void ValidateSortIcon_ProgramStatus()
{
	commonFunctions.Click_SortIcon(progstatusSortIcon, "Program Status");
}
// --------------------------------------
public void ValidateSortIcon_ProgramName_Ascending()
{
	commonFunctions.ValidateAscending_SortIcon(progNameSortIcon, "Program Name");
}
public void ValidateSortIcon_ProgramName_Descending()
{
	commonFunctions.ValidateDescending_SortIcon(progNameSortIcon, "Program Name");
}

public void ValidateSortIcon_ProgramDescription_Ascending()
{
	commonFunctions.ValidateAscending_SortIcon(progDescSortIcon, "Program Description");
}
public void ValidateSortIcon_ProgramDescription_Descending()
{
	commonFunctions.ValidateDescending_SortIcon(progDescSortIcon, "Program Description");
}

public void ValidateSortIcon_ProgramStatus_Ascending()
{
	commonFunctions.ValidateAscending_SortIcon(progstatusSortIcon, "Program Status");
}
public void ValidateSortIcon_ProgramStatus_Descending()
{
	commonFunctions.ValidateDescending_SortIcon(progstatusSortIcon, "Program Status");
}

//


}

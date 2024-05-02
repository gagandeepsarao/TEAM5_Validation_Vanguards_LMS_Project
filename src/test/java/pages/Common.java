package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import app_hooks.AppHooks;
import utilities.Logger_Load;

public class Common {
	
	By programBtn = By.xpath("//button[@id='program']");
	By batchBtn = By.xpath("//button[@id='batch']");
	By LMSDashboardTitle = By.xpath("//span[normalize-space()='LMS - Learning Management System']");
	
	
	
	public void verifyDashboardPage()
	{
		boolean verifyDashboard =AppHooks.getInstance().getDriver().findElement(LMSDashboardTitle).isDisplayed();
		if(verifyDashboard)
			Logger_Load.info("Admin is on dashboard page after Login...");
		else
			Logger_Load.error("Admin is not on dashboard page after Login...");

		Assert.assertTrue(verifyDashboard);

	}

	public void verifyLogout()
	{
		String loginMsg = AppHooks.getInstance().getDriver().findElement(By.xpath("//div//p")).getText();
		
		System.out.println(loginMsg);
		if(loginMsg.equals("Please login to LMS application"))
			Logger_Load.info("Logout is done successfully");
		else
			Logger_Load.error("Logout is not successfully");
	}
	/**To check Heading of the Page (Eg.Manage Program/Manage Batch/Manage User)
	 * 
	 * @param PageHeading (Pass Parameter eg.Manage Program)
	 */
	public void CheckPageHeading(String PageHeading)
	{
		boolean headingPresent =AppHooks.getInstance().getDriver().findElement(By.xpath("//div[normalize-space()='"+PageHeading+"']")).isDisplayed();
		Assert.assertTrue(headingPresent);

		if(headingPresent)
			Logger_Load.info(PageHeading +" is present as expected...");

		
		else
			Logger_Load.error(PageHeading +" is not present as expected...");

			
	}

	/**To check Pagination Message (Eg.Showing 1 to 5 of 54 entries)
	 * 
	 * @param PaginationElement (Pass the pagination web element  eg.PaginatorMessage)
	 * 	By paginatorMessage = By.xpath("//span[@class='p-paginator-current ng-star-inserted']");

	 */
	
	public void checkPaginationMessage(By PaginationElement)
	{
		boolean PaginationMessageMatch=false;
		String PaginationMessage = AppHooks.getInstance().getDriver().findElement(PaginationElement).getText();
				
		String[] splitArr =PaginationMessage.split("of");
		String totEnt = (splitArr[1]);
	
		String[] splitArr2 = totEnt.split(" ");
		String TotalEntries = splitArr2[1];

		int intTotalEntries = Integer.parseInt(TotalEntries);

		
		if(intTotalEntries<10)
		{	
			PaginationMessageMatch = PaginationMessage.matches("Showing [0-9] to [0-9] of [0-9] entries");
		
		}
		else if (intTotalEntries>=10 && intTotalEntries<100)
		{
			PaginationMessageMatch = PaginationMessage.matches("Showing [0-9] to [0-9] of [0-9][0-9] entries");
		}
		else if (intTotalEntries>=100 && intTotalEntries<1000)
		{
			PaginationMessageMatch = PaginationMessage.matches("Showing [0-9] to [0-9] of [0-9][0-9][0-9] entries");
		}
		if(PaginationMessageMatch)
			Logger_Load.info("Pagination text is present as expected... "+PaginationMessage );
		else
			Logger_Load.error("Pagination text is not present as expected... "+PaginationMessage );

		Assert.assertTrue(PaginationMessageMatch);
		
	}
	
	// Module should be either programs/batches/users
	public void checkFooterMessage(By FooterElement,String Module)
	{
		boolean FooterMessageMatch=false;
		String FooterMessage = AppHooks.getInstance().getDriver().findElement(FooterElement).getText();
		System.out.println(FooterMessage);		
		String[] splitArr =FooterMessage.split("are");
		String totEnt = (splitArr[1]);
	
		String[] splitArr2 = totEnt.split(" ");
		String TotalEntries = splitArr2[1];

		int intTotalEntries = Integer.parseInt(TotalEntries);

		
		if(intTotalEntries<10)
		{	
			FooterMessageMatch = FooterMessage.matches("In total there are [0-9] "+Module+".");
		
		}
		else if (intTotalEntries>=10 && intTotalEntries<100)
		{
			FooterMessageMatch = FooterMessage.matches("In total there are [0-9][0-9] "+Module+".");
		}
		else if (intTotalEntries>=100 && intTotalEntries<1000)
		{
			FooterMessageMatch = FooterMessage.matches("In total there are [0-9][0-9][0-9] "+Module+".");
		}
		if(FooterMessageMatch)
			Logger_Load.info("Footer text is present as expected... "+FooterMessage );
		else
			Logger_Load.error("Footer text is not present as expected... "+FooterMessage );

		Assert.assertTrue(FooterMessageMatch);
		
	}
	//Status is disabled
	public void CheckButton_DisableStatus(By ButtonElement,String ButtonName) 
	{
		boolean buttonStatus = AppHooks.getInstance().getDriver().findElement(ButtonElement).isEnabled();
		if(!buttonStatus)
			Logger_Load.info("The button "+ButtonName+" is disabled as expected....");
		else
			Logger_Load.error("The button "+ButtonName+" is enabled - Not as expected");
		Assert.assertFalse(buttonStatus);;
	}
	
	public void CheckButton_IsDisplayed(By ButtonElement,String ButtonName)
	{
		boolean buttonStatus = AppHooks.getInstance().getDriver().findElement(ButtonElement).isDisplayed();
		if(buttonStatus)
			Logger_Load.info("The button "+ButtonName+" is displayed as expected....");
		else
			Logger_Load.error("The button "+ButtonName+" is not displayed - Not as expected");
		Assert.assertTrue(buttonStatus);;
	}
	
	public void CheckTable_NoOfRows(By TableElement,int NoOfRows)
	{
		
		int totRows = AppHooks.getInstance().getDriver().findElements(TableElement).size();
		System.out.println(totRows);
		if (totRows==5)
			Logger_Load.info("Total Number of records displayed is "+totRows+" - As expected");
		else
			Logger_Load.error("Total Number of records displayed is "+totRows+" - Not As expected");
		Assert.assertEquals(totRows, 5);
		
	}
	//Using xpath as locator
	public void CheckTable_CheckBox(By TableElement)
	{
		int totRows = AppHooks.getInstance().getDriver().findElements(TableElement).size();
		//By.xpath: //table//tbody[@class='p-datatable-tbody']//tr
			//table//tbody[@class='p-datatable-tbody']//tr[2]//div[@role='checkbox']

		System.out.println((TableElement));
		String[] TblEle = TableElement.toString().split("By.xpath: ");
		for (int row=1;row<=totRows;row++)
			
		{
			boolean checkBoxStatus = AppHooks.getInstance().getDriver().findElement(By.xpath(TblEle[1]+"["+row+"]//div[@role='checkbox']")).isDisplayed();
			if (checkBoxStatus)
				Logger_Load.info("Check Box is present in Row Number:"+row+" - As expected");
			else
				Logger_Load.error("Check Box is not present in Row Number:"+row+" - Not As expected");
			Assert.assertTrue(checkBoxStatus);
		}
	}
	public void CheckTable_EditBtn(By TableElement)
	{
		int totRows = AppHooks.getInstance().getDriver().findElements(TableElement).size();
		//table//tbody[@class='p-datatable-tbody']//tr[2]//button[@id='editProgram']
		//table//tbody[@class='p-datatable-tbody']//tr[2]//button[@id='deleteProgram']
		String[] TblEle = TableElement.toString().split("By.xpath: ");
		for (int row=1;row<=totRows;row++)
			
		{
			boolean editBtnStatus = AppHooks.getInstance().getDriver().findElement(By.xpath(TblEle[1]+"["+row+"]//button[@id='editProgram']")).isDisplayed();
			 boolean editBtnEnabled = AppHooks.getInstance().getDriver().findElement(By.xpath(TblEle[1]+"["+row+"]//button[@id='editProgram']")).isEnabled();
			if (editBtnStatus)
				Logger_Load.info("Edit Button is present in Row Number:"+row+" - As expected");
			else
				Logger_Load.error("Edit Button is not present in Row Number:"+row+" - Not As expected");
			if (editBtnEnabled)
				Logger_Load.info("Edit Button is enabled in Row Number:"+row+" - As expected");
			else
				Logger_Load.error("Edit Button is not enabled in Row Number:"+row+" - Not As expected");
			Assert.assertTrue(editBtnStatus);
			Assert.assertTrue(editBtnEnabled);
			
		}
		
	}
	public void CheckTable_DeleteBtn(By TableElement)
	{
		int totRows = AppHooks.getInstance().getDriver().findElements(TableElement).size();
		//table//tbody[@class='p-datatable-tbody']//tr[2]//button[@id='deleteProgram']
		String[] TblEle = TableElement.toString().split("By.xpath: ");
		for (int row=1;row<=totRows;row++)
			
		{
			boolean deleteBtnStatus = AppHooks.getInstance().getDriver().findElement(By.xpath(TblEle[1]+"["+row+"]//button[@id='deleteProgram']")).isDisplayed();
			boolean deleteBtnEnabled = AppHooks.getInstance().getDriver().findElement(By.xpath(TblEle[1]+"["+row+"]//button[@id='deleteProgram']")).isEnabled();

			if (deleteBtnStatus)
				Logger_Load.info("Delete Button is present in Row Number:"+row+" - As expected");
			else
				Logger_Load.error("Delete Button is not present in Row Number:"+row+" - Not As expected");
			if (deleteBtnEnabled)
				Logger_Load.info("Delete Button is enabled in Row Number:"+row+" - As expected");
			else
				Logger_Load.error("Delete Button is not enabled in Row Number:"+row+" - Not As expected");
			Assert.assertTrue(deleteBtnStatus);
			Assert.assertTrue(deleteBtnEnabled);
		}
		
	}
	
	public void checkSearchBar_WithSearch(By SearchElement)
	{
		boolean searchBarDisplayed = AppHooks.getInstance().getDriver().findElement(SearchElement).isDisplayed();
		if (searchBarDisplayed)
			Logger_Load.info("Search Bar is displayed - As expected");
		else
			Logger_Load.error("Search Bar is not displayed - Not As expected");
		String searchText =AppHooks.getInstance().getDriver().findElement(SearchElement).getAttribute("placeholder");
		if(searchText.equals("Search..."))
			Logger_Load.info("Search Text Search... is displayed - As expected");
		else
			Logger_Load.error("Search Text Search... is not displayed - As expected");


	}
	
	public void clickPaginatorNext(By PaginatorButtonElement)
	{
		boolean PaginatorNext = AppHooks.getInstance().getDriver().findElement(PaginatorButtonElement).isEnabled();
		if(PaginatorNext)
			Logger_Load.info("Pagination - Next button is displayed - As expected");
		else
			Logger_Load.error("Pagination - Next button is not displayed - As expected");
		AppHooks.getInstance().getDriver().findElement(PaginatorButtonElement).click();
		Logger_Load.info("Pagination - Next button is clicked successfully");

	}
	public void clickPaginatorLast(By PaginatorButtonElement)
	{
		boolean PaginatorLast = AppHooks.getInstance().getDriver().findElement(PaginatorButtonElement).isEnabled();
		if(PaginatorLast)
			Logger_Load.info("Pagination - Last button is displayed - As expected");
		else
			Logger_Load.error("Pagination - Last button is not displayed - As expected");
		AppHooks.getInstance().getDriver().findElement(PaginatorButtonElement).click();
		Logger_Load.info("Pagination - Last button is clicked successfully");

	}
	public void clickPaginatorPrev(By PaginatorButtonElement)
	{
		boolean PaginatorPrev = AppHooks.getInstance().getDriver().findElement(PaginatorButtonElement).isEnabled();
		if(PaginatorPrev)
			Logger_Load.info("Pagination - Previous button is displayed - As expected");
		else
			Logger_Load.error("Pagination - Previous button is not displayed - As expected");
		AppHooks.getInstance().getDriver().findElement(PaginatorButtonElement).click();
		Logger_Load.info("Pagination - Previous button is clicked successfully");

	}
	public void clickPaginatorFirst(By PaginatorButtonElement)
	{
		boolean PaginatorFirst = AppHooks.getInstance().getDriver().findElement(PaginatorButtonElement).isEnabled();
		if(PaginatorFirst)
			Logger_Load.info("Pagination - First button is displayed - As expected");
		else
			Logger_Load.error("Pagination - First button is not displayed - As expected");
		AppHooks.getInstance().getDriver().findElement(PaginatorButtonElement).click();
		Logger_Load.info("Pagination - First button is clicked successfully");

	}
	
	public void checkNextPagination(By PaginationElement)
	{
		String PaginationMessage = AppHooks.getInstance().getDriver().findElement(PaginationElement).getText();
		if (PaginationMessage.startsWith("Showing 6 to"))
			Logger_Load.info("Pagination - Admin is able to navigate to Next Page - As expected");
		else
			Logger_Load.error("Pagination - Admin is not able to navigate to Next Page - As expected");


	}
	public void checkLastPagination(By PaginationElement)
	{
		String PaginationMessage = AppHooks.getInstance().getDriver().findElement(PaginationElement).getText();
		String[] arr = PaginationMessage.split("of ");
		String[] TotalEntries = arr[1].split(" ");
		String Total = TotalEntries[0];
		String toCompare = " "+Total+" of "+Total+" entries";
		
		System.out.println(PaginationMessage.endsWith(toCompare));


		if (PaginationMessage.endsWith(toCompare))
			Logger_Load.info("Pagination - Admin is able to navigate to Last Page - As expected");
		else
			Logger_Load.error("Pagination - Admin is not able to navigate to Last Page - As expected");


	}
	public void checkPrevPagination(By PaginationElement)
	{
		String PaginationMessage = AppHooks.getInstance().getDriver().findElement(PaginationElement).getText();
		String[] arr = PaginationMessage.split("of ");
		String[] TotalEntries = arr[1].split(" ");
		String Total = TotalEntries[0];
		String toCompare = " "+Total+" entries";
		if (PaginationMessage.endsWith(toCompare))
			Logger_Load.info("Pagination - Admin is able to navigate to Previous Page - As expected");
		else
			Logger_Load.error("Pagination - Admin is not able to navigate to Previous Page - As expected");


	}
	public void checkFirstPagination(By PaginationElement)
	{
		String PaginationMessage = AppHooks.getInstance().getDriver().findElement(PaginationElement).getText();
		if (PaginationMessage.startsWith("Showing 1 to"))
			Logger_Load.info("Pagination - Admin is able to navigate to First Page - As expected");
		else
			Logger_Load.error("Pagination - Admin is not able to navigate to First Page - As expected");


	}
	
	// ### Functions for sort icon -- Program
	//Column can be Program Name, Program Description , Program Status for Program Module
	public void Click_SortIcon(By SortIconElement,String Column)
	{
		//System.out.println(Column);
		boolean progNameSortIcon = AppHooks.getInstance().getDriver().findElement(SortIconElement).isEnabled();
		if(progNameSortIcon)
			Logger_Load.info("SortIcon - "+Column+" is displayed - As expected");
		else
			Logger_Load.error("SortIcon - "+Column+" is not displayed - As expected");
		AppHooks.getInstance().getDriver().findElement(SortIconElement).click();
		Logger_Load.info("Sort Icon - "+Column+" is clicked successfully");

	}
	
	public void ValidateAscending_SortIcon(By SortIconElement, String Column) {
		
		String attribute = AppHooks.getInstance().getDriver().findElement(SortIconElement).getAttribute("aria-sort");
		
		//System.out.println(attribute);
		boolean AscendingSortIcon  = attribute.contains("ascending");
		if(AscendingSortIcon)
			Logger_Load.info("Ascending SortIcon - "+Column+" is displayed - As expected");
		else
			Logger_Load.error("Ascending SortIcon - "+Column+" is not displayed - As expected");
		

		
	}
	public void ValidateDescending_SortIcon(By SortIconElement, String Column) {
		String attribute = AppHooks.getInstance().getDriver().findElement(SortIconElement).getAttribute("aria-sort");
		
		//System.out.println(attribute);
		boolean DescendingSortIcon = attribute.contains("descending");
		if(DescendingSortIcon)
			Logger_Load.info("Descending SortIcon - "+Column+" is displayed - As expected");
		else
			Logger_Load.error("Descending SortIcon - "+Column+" is not displayed - As expected");
		

		
	}

	}

package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import app_hooks.AppHooks;
import utilities.Logger_Load;

public class Batch_Page {


	private static Batch_Page BatchPageObjects;

	private Batch_Page() {};
	Common commonFunctions = new Common();
	public static Batch_Page getInstance() {

		if(BatchPageObjects==null) {
			BatchPageObjects= new Batch_Page ();
		}
		return BatchPageObjects;

	}
	public boolean batchDelAllBtnEnabled = true;
	public boolean bIsAddNewBatchPlusBtnVisible = true;
	public boolean bIsAddNewBatchBtnVisible = true;
	
  By batchbutton=By.xpath("//button[@id='batch']");
  
  By ManagebatchHeading=By.xpath("//div[normalize-space()='Manage Batch']");
  
  By PaginatorMessage = By.xpath("//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']");
  By headerTable = By.xpath("//table//thead[@class='p-datatable-thead']//th");
 // By contentTable = By.xpath("//table//tbody[@class='p-datatable-tbody']//tr");

	By trashicon2=By.xpath("(//span[@class='p-button-icon pi pi-trash'])[1]");
  By datatableele= By.xpath("//thead[@class='p-datatable-thead']/tr//th[@class='p-sortable-column']");
  By eleTableHeaderEditDel= By.xpath("//th[text()=' Edit / Delete ']");
  
  By eleBtnDeleteAll = By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
  By eleAddNewBatchPlusButton = By.xpath("//button[@id='new']/span[@class='p-button-label']");
  By eleAddNewBatchButton = By.xpath("//button[@id='new']/span[@class='p-button-label']");
  By eletableChkbox = By.xpath("//div[@role='checkbox']");  
   By tableele=By.xpath("//table[@role='grid']");
   By eleeditIcon=By.xpath("//button[@icon='pi pi-pencil']");
 By TrashIcon=By.xpath("//button[@icon='pi pi-trash']");
 
   
 By getpopup=By.xpath("//div[@role='dialog']");
   
  
  public void clickbatch()
  
  
  {
	  
	  
	  AppHooks.getInstance().getDriver().findElement(batchbutton).click();
	  
	  
  }
  public void DashboardPageVerification()
	{
		commonFunctions.verifyDashboardPage();
	}
	
	  
  public void verifyBatchURL()
	{
		String batchURL = AppHooks.getInstance().getDriver().getCurrentUrl();
		Assert.assertEquals(batchURL, "https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/batch");
		if(batchURL.equals("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/batch"))
			Logger_Load.info("Admin is able to see URL in Manage Batch" );
		else
			Logger_Load.error("Admin is not able to see URL in Manage Batch" );

	}
	  
  

	public void Managebatch_HeadingVerification(String pageHeading) {
		
		commonFunctions.CheckPageHeading(pageHeading);
	
	
	
	
	
	
	
	}
	
	

	/*public void paginationMessageVerification()
	{
		commonFunctions.checkPaginationMessage(PaginatorMessage);
	}*/
	
	

	public void CheckTable_BatchTableHeaders(By TableElement)
	{

		int totRowsHead = AppHooks.getInstance().getDriver().findElements(TableElement).size();
		if(totRowsHead==6)
		{	
			Logger_Load.info("Batch Table Headers are....");
			Logger_Load.info(AppHooks.getInstance().getDriver().findElements(TableElement).get(1).getText());
			Logger_Load.info(AppHooks.getInstance().getDriver().findElements(TableElement).get(2).getText());
			Logger_Load.info(AppHooks.getInstance().getDriver().findElements(TableElement).get(3).getText());
			Logger_Load.info(AppHooks.getInstance().getDriver().findElements(TableElement).get(4).getText());
			Logger_Load.info(AppHooks.getInstance().getDriver().findElements(TableElement).get(5).getText());
			Logger_Load.info(AppHooks.getInstance().getDriver().findElements(TableElement).get(6).getText());
		}
		else
			Logger_Load.error("Batch Table Header is not as expected");
		
		Assert.assertEquals(AppHooks.getInstance().getDriver().findElements(TableElement).get(1).getText(), "Batch Name");
		Assert.assertEquals(AppHooks.getInstance().getDriver().findElements(TableElement).get(2).getText(), "Batch Description");
		Assert.assertEquals(AppHooks.getInstance().getDriver().findElements(TableElement).get(3).getText(), "Batch Status");
		Assert.assertEquals(AppHooks.getInstance().getDriver().findElements(TableElement).get(4).getText(), "No Of Classes");
		Assert.assertEquals(AppHooks.getInstance().getDriver().findElements(TableElement).get(5).getText(), "Program Name");
		Assert.assertEquals(AppHooks.getInstance().getDriver().findElements(TableElement).get(6).getText(), "Edit / Delete");

	}
	public void Validate_BatchTableHeaders()
	{

		CheckTable_BatchTableHeaders(headerTable);
	}
	

	public void checkadminPagination() {
		
		
		
		
		//String expMsg = "Showing 1 to 5 of 29 entries";
		boolean actMsg= AppHooks.getInstance().getDriver().findElement(PaginatorMessage).isDisplayed();
		System.out.println(actMsg);
		//Assert.assertEquals(actMsg, expMsg);
		if(actMsg)
		
			Logger_Load.info("admin see the pagintion");
		
			else
				Logger_Load.info("admin not able to see the pagintion");
		
	
	}


	public void BatchPageDeleteAllButtonEnabled()
	{
		// batchDelAllBtnEnabled  = AppHooks.getInstance().getDriver().findElement(eleBtnDeleteAll).isEnabled();
		//return  batchDelAllBtnEnabled ;
	
		 WebElement disap = AppHooks.getInstance().getDriver().findElement(trashicon2);
			
		 boolean tras= disap.isSelected();
		 
		
		
	if(!tras)
		
			Logger_Load.info("trash icon disabled");
			
			else
				Logger_Load.info("trash icon enabled");
		
	
	
	
	
	
	
	
	}



	public boolean IsAddNewBatchButtonVisible()
	{
		boolean bIsNewBatchPlusBtnVisible;
		boolean bIsNewBatchBtnVisible;
		
		
		
		bIsNewBatchPlusBtnVisible = AppHooks.getInstance().getDriver().findElement(eleAddNewBatchPlusButton).isDisplayed();
		bIsNewBatchBtnVisible = AppHooks.getInstance().getDriver().findElement(eleAddNewBatchButton).isDisplayed();
		
		if(	bIsNewBatchPlusBtnVisible && bIsNewBatchBtnVisible)
			bIsNewBatchBtnVisible = true;
		else
			bIsNewBatchBtnVisible = false;
		
		return 	bIsNewBatchBtnVisible;
	
	
	
	}


     public void datarows() {
	
	
    		WebElement elecheckbox=AppHooks.getInstance().getDriver().findElement(tableele);
    		List<WebElement> totalRow = elecheckbox.findElements(By.tagName("tr"));
    		
    		System.out.println(totalRow.toString());
//	String data = totalRow.get(0).toString();
//    		System.out.println(data); 
    		
    		ArrayList<WebElement> cells = (ArrayList<WebElement>) elecheckbox.findElements(By.tagName("tr")); // Find all cells in the first row
            int count = 0;
            
            
        			
            	
            	
            
            
    		for (WebElement cell : cells) {
    		Boolean chkboxPresence = AppHooks.getInstance().getDriver().findElement(eletableChkbox).isDisplayed();
    		Boolean pencilIcon = AppHooks.getInstance().getDriver().findElement(eleeditIcon).isEnabled();
    		Boolean trashicon = AppHooks.getInstance().getDriver().findElement(TrashIcon).isEnabled();
    	
    		if(!chkboxPresence) {
    			
    			Logger_Load.info("row dont" +count+ "have checkbox");
    			
    		}
    		else
    		{
    			Logger_Load.info("row"  +count+" have checkbox");
    		}
//                String cellText = cell.getText(); // Get the text of each cell
//                System.out.println("Cell Value: " + cellText);
    		
           if(!pencilIcon) {
    			
        	   Logger_Load.info("row pencil" +count+" is disabled");
    			
    		}
    		else
    		{
    			Logger_Load.info("row pencil icon is enabled");
    		}
           if(!trashicon) {
   			
        	   Logger_Load.info("row Trash icon is enabled");
   			
   		}
   		else
   		{
   			Logger_Load.info("row Trash icon"+count+ "is disabled");
   		}
   		
           count ++;
   		}
   		count++;
   		}
         
   	/*	for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            List<WebElement> cells = row.findElements(By.tagName("td"));
            // Check the presence of checkbox, pencil icon, and trash icon in each cell
            for (WebElement cell : cells) {
                WebElement checkbox = cell.findElement(By.xpath(".//input[@type='checkbox']"));
                WebElement pencilIcon = cell.findElement(By.xpath(".//i[contains(@class, 'pencil-icon')]"));
                WebElement trashIcon = cell.findElement(By.xpath(".//i[contains(@class, 'trash-icon')]"));
                // Check if the elements are present
                System.out.println("Cell " + i + " has checkbox: " + checkbox.isDisplayed());
                System.out.println("Cell " + i + " has pencil icon: " + pencilIcon.isDisplayed());
                System.out.println("Cell " + i + " has trash icon: " + trashIcon.isDisplayed());
            }	
     }*/


public void clickbatchbutton()
{
	
  AppHooks.getInstance().getDriver().findElement(eleAddNewBatchButton).click();
	
	
}

public boolean popupdisplay() {
	
 boolean popup = AppHooks.getInstance().getDriver().findElement(getpopup).isDisplayed();
 if (popup)
 {
	 Logger_Load.info("Popup is displayed");
 }
 
	 else
	 {
		 Logger_Load.info("Popup is not displayed");
 }
return popup;
	 
	 
	 
 }



}









  
  
  



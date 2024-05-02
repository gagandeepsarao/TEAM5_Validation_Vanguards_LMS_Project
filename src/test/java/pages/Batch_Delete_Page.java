package pages;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import app_hooks.AppHooks;
import utilities.Logger_Load;

public class Batch_Delete_Page {


	
	private static Batch_Delete_Page  DeletePageObjects;

	private  Batch_Delete_Page () {};
	Common commonFunctions = new Common();
	public static Batch_Delete_Page getInstance() {

		if( DeletePageObjects==null) {
			 DeletePageObjects= new   Batch_Delete_Page ();
		}
		return  DeletePageObjects;

	}

	 By TrashIcon=By.xpath("//button[@icon='pi pi-trash']");
	 By tableele=By.xpath("//table[@role='grid']");
	By  checkbox=By.xpath("(//span[@class=\"p-button-icon pi pi-trash\"])[2]");

	By  yesalert=By.xpath("//span[text()='Yes']");
	By  Noalert=By.xpath("//span[text()='No']");
	By  alertbox=By.xpath("//span[contains(text(),'Are you sure')]");
	By searchbox=By.xpath("//input[@id='filterGlobal']");
	By po2=By.xpath("//div[text()='batch Deleted']");
	 By rowbatchcreated=By.xpath( "(//table[@role='grid']//tr)[2]//td[2]");
	public void tabletrash()
	{
		
		WebElement elecheckbox=AppHooks.getInstance().getDriver().findElement(tableele);
		List<WebElement> totalRow = elecheckbox.findElements(By.tagName("tr"));
		
		System.out.println(totalRow.toString());
//String data = totalRow.get(0).toString();
//		System.out.println(data); 
		
		ArrayList<WebElement> cells = (ArrayList<WebElement>) elecheckbox.findElements(By.tagName("tr")); // Find all cells in the first row
        int count = 0;
        
        
        
		for (WebElement cell : cells) {
		
		
		Boolean trashicon = AppHooks.getInstance().getDriver().findElement(TrashIcon).isEnabled();
    	
	
		
       if(!trashicon) {
			
    	   Logger_Load.info("row Trash icon is enabled");
			
		}
		else
		{
			Logger_Load.info("row Trash icon"+count+ "is disabled");
		}
		
       count ++;
		}
	}
	
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	

public void clickcheckbox() throws InterruptedException
{

	//Calendar calendar = Calendar. getInstance(); 
 //Date currentDate = calendar.getTime(); 
	//String currentDateTime = currentDate.toString();
	
// AppHooks.getInstance().getDriver().findElement(searchbox).sendKeys(currentDateTime);
	AppHooks.getInstance().getDriver().findElement(checkbox).click();
	
	

}

public void checkalertbox() throws InterruptedException
{
	
	

	Thread.sleep(6000);
	//AppHooks.getInstance().getDriver().switchTo().alert();
String actualmsg=AppHooks.getInstance().getDriver().findElement(alertbox).getText();
	//String actualmsg=alret.getText();
//if( actualmsg.contains("Are you want to delete"))
Logger_Load.info("Alert msg with"+ actualmsg + "found");

//else
	
	//Logger_Load.info("No Alert msg found");
	

//WebElement albox = AppHooks.getInstance().getDriver().findElement(alertbox);
   //  String al=  albox.getText();
  //  Logger_Load.info(al);
	
}






public void alertyes() throws InterruptedException




{
Thread.sleep(2000);
	AppHooks.getInstance().getDriver().findElement(yesalert).click();
	



}


public void pop2() throws InterruptedException

{
	
	//Thread.sleep(3000);
	WebElement popmsg=AppHooks.getInstance().getDriver().findElement(po2);
	
	String p=popmsg.getText();
	//Assert.assertEquals(p, "batch Deleted");
	//System.out.println(p);
if(p.equals("batch Deleted"))

	Logger_Load.info("Successfully batch Deleted");
	
	else
		
		Logger_Load.info(" batch not Deleted");



}

public void alertNo() throws InterruptedException {

	Thread.sleep(2000);
	AppHooks.getInstance().getDriver().findElement(Noalert).click();

	
}

public void batchpresent() throws InterruptedException {
	
	Thread.sleep(2000);
	WebElement elecheckbox=AppHooks.getInstance().getDriver().findElement(rowbatchcreated);
	String data = elecheckbox.getText();
	Logger_Load.info("Batch still present"   + data);
	
	
}




}



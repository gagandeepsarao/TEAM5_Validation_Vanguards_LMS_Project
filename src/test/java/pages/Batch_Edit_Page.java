package pages;






	import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;

	import app_hooks.AppHooks;
	import utilities.Logger_Load;

	public class Batch_Edit_Page {




		//static String currentDateTime;

		static String currentDateTime;

		private static Batch_Edit_Page  EditPageObjects;

		private  Batch_Edit_Page () {};
		Common commonFunctions = new Common();
		public static Batch_Edit_Page getInstance() {

			if(EditPageObjects==null) {
				EditPageObjects= new  Batch_Edit_Page ();
			}
			return EditPageObjects;

		}

		 By tableele=By.xpath("//table[@role='grid']");
		  By eleeditIcon=By.xpath("(//button[@icon='pi pi-pencil'])[1]");
		 
		 //
		  By clicediticon=By.xpath("(//span[@class='p-button-icon pi pi-pencil'])[1]");
		By dialogbox=By.xpath("//div[@role='dialog']");
		
		By batchdetailmessage=By.xpath("//span[text()='Batch Details']");
		 //
		
		
		By namefield=By.xpath("//input[@id='batchName']");
		
		
		By descriptionfield=By.xpath("//input[@id='batchDescription']");
		
		By noofclassfield=By.xpath("//input[@id='batchNoOfClasses']");
		By droparrow=By.xpath("//div[@role='button']");//arrowdropele
		By myoption=By.xpath("(//li[@role='option'])[1]");
		By activeradiobutton=By.xpath("//div[@class='p-radiobutton-box'][1]");
		//By noofclassfield=By.xpath("//input[@id='batchNoOfClasses']");
		By savebutton=By.xpath("//span[text()='Save']");
		By rowbatchcreated=By.xpath( "(//table[@role='grid']//tr)[2]//td[2]");
		//
		By errormsg=By.xpath("//small[text()='This field should start with an alphabet and min 2 character.']");
	
		By mantoryerror=By.xpath("//small[text()='Number of classes is required.']");
		By updatemsgpopup=By.xpath("//div[text()='batch Updated']");
		
		public void rowleveledit()



	{
		
		WebElement elecheckbox=AppHooks.getInstance().getDriver().findElement(tableele);
		List<WebElement> totalRow = elecheckbox.findElements(By.tagName("tr"));
		
		System.out.println(totalRow.toString());
	//String data = totalRow.get(0).toString();
//		System.out.println(data); 
		
		ArrayList<WebElement> cells = (ArrayList<WebElement>) elecheckbox.findElements(By.tagName("tr")); // Find all cells in the first row
	    int count = 0;
	    
	    
	    
		for (WebElement cell : cells) {
		
		
		Boolean trashicon = AppHooks.getInstance().getDriver().findElement(eleeditIcon).isSelected();
		

		
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
		
		public void clickeditpencil()
		{
			
			
			
			
			AppHooks.getInstance().getDriver().findElement(clicediticon).click();
			
			
			
		}
		
	
		
		public void deatilsappers()
		{
			
			
			
		WebElement dialog = AppHooks.getInstance().getDriver().findElement(batchdetailmessage);
		String text=dialog.getText();
			

		Logger_Load.info(text+"pop up appers");
		
		
		
		
		}
		
//sec2
	public void updatefields() throws InterruptedException
	{
		
		

		Calendar calendar = Calendar. getInstance(); 
		Date currentDate = calendar.getTime(); 
		String currentDateTime = currentDate.toString();
		
		currentDateTime = currentDateTime.substring(9, 20);
		currentDateTime = "Test" + currentDateTime;
	
		
		
		Thread.sleep(2000);
		//AppHooks.getInstance().getDriver().findElement(namefield).sendKeys(tes);
		AppHooks.getInstance().getDriver().findElement(descriptionfield).clear();
		AppHooks.getInstance().getDriver().findElement(descriptionfield).sendKeys(currentDateTime);
		
		
		Thread.sleep(2000);
		AppHooks.getInstance().getDriver().findElement( noofclassfield).clear();
		
		AppHooks.getInstance().getDriver().findElement( noofclassfield).sendKeys("4");
		Thread.sleep(2000);

	    AppHooks.getInstance().getDriver().findElement(savebutton).click();
	    
		
	}




	//se3invalid


	public void m1() throws InterruptedException {

		AppHooks.getInstance().getDriver().findElement(descriptionfield).clear();
		Thread.sleep(3000);
		AppHooks.getInstance().getDriver().findElement(descriptionfield).sendKeys("1eleauto2123");
		
		//AppHooks.getInstance().getDriver().findElement(activeradiobutton).click();

		//Thread.sleep(2000);
		AppHooks.getInstance().getDriver().findElement(noofclassfield).clear();

		AppHooks.getInstance().getDriver().findElement(noofclassfield).sendKeys("3");

		Thread.sleep(2000);

	    AppHooks.getInstance().getDriver().findElement(savebutton).click();
	    
		
		
	}


	public void m2() throws InterruptedException
	{
		
		
		Thread.sleep(2000);
		WebElement err= AppHooks.getInstance().getDriver().findElement(errormsg);
		
		String ERRRR = err.getText();
		
		 Logger_Load.info(ERRRR);



	}



//sec4
  public void mantatoryfield() throws InterruptedException
{
	
	
   // AppHooks.getInstance().getDriver().findElement(descriptionfield).clear();
	  Thread.sleep(6000);
    AppHooks.getInstance().getDriver().findElement(noofclassfield).clear();
    
	
	AppHooks.getInstance().getDriver().findElement(savebutton).click();





}


public void mantatoryerrormsg()
{
	
	
	
	WebElement error = AppHooks.getInstance().getDriver().findElement(mantoryerror);
	
	String gettheerrormsg=error.getText();
	 Logger_Load.info(gettheerrormsg);
	
}

//5




public void erasedescrip() throws InterruptedException
{
	

	Thread.sleep(3000);
	AppHooks.getInstance().getDriver().findElement(descriptionfield).clear();
    
	AppHooks.getInstance().getDriver().findElement(savebutton).click();

	
	
}


public void updatemsg() 
{
	
	
	
	
 WebElement update=	AppHooks.getInstance().getDriver().findElement(updatemsgpopup);

	String msg=update.getText();
	
	
	if(msg.equals("batch Updated"))
	 Logger_Load.info(msg +"display");


	else

		 Logger_Load.info(msg+ "not display");


}






	}



































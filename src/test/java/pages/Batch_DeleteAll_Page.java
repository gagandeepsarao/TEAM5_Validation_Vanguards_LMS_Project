package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import app_hooks.AppHooks;
import utilities.Logger_Load;

public class Batch_DeleteAll_Page {






	private static Batch_DeleteAll_Page DeleteAllPageObjects;

	private Batch_DeleteAll_Page() {};
	Common commonFunctions = new Common();
	public static Batch_DeleteAll_Page getInstance() {

		if(DeleteAllPageObjects==null) {
			DeleteAllPageObjects= new Batch_DeleteAll_Page ();
		}
		return DeleteAllPageObjects;

	}




	By tableele=By.xpath("//table[@role='grid']");
	By tableeleallcheckbox=By.xpath("//div[@role='checkbox']");
	By trashicon=By.xpath("(//span[@class='p-button-icon pi pi-trash'])[1]");

	
	//
	
	By selectcheckbox1=By.xpath("(//div[@role='checkbox'])[2]");
	By selectcheckbox2=By.xpath("(//div[@role='checkbox'])[3]");
	
	
	
	By trashicon2=By.xpath("(//span[@class='p-button-icon pi pi-trash'])[1]");

	By  yesalert2=By.xpath("//span[text()='Yes']");
	
	By pop2=By.xpath("//div[text()='Batches Deleted']");
public void checkboxdis()
{
	
	 AppHooks.getInstance().getDriver().findElement(tableele);
	
	WebElement allcheck= AppHooks.getInstance().getDriver().findElement(tableeleallcheckbox);
	boolean dd = allcheck.isDisplayed();
	if(dd)
	
		Logger_Load.info("no check box selected");
		
		else
			Logger_Load.info("checkbox selected");
	
	}
	
//System.out.println(si);


public void trashiconbutton()


{
	
	
	 WebElement disap = AppHooks.getInstance().getDriver().findElement(trashicon);
	
	 boolean tras= disap.isSelected();
	 
	
	
if(!tras)
	
		Logger_Load.info("trash icon disabled");
		
		else
			Logger_Load.info("trash icon enabled");
	


}


//second


public void siglerowdelete1()
{
	
	
	
	AppHooks.getInstance().getDriver().findElement(selectcheckbox1).click();
	
	
}

public void singlerow2() 
{
	
	AppHooks.getInstance().getDriver().findElement(trashicon2).click();

	
}


public void singlerow3() throws InterruptedException 
{
	
	
	
	
	AppHooks.getInstance().getDriver().findElement(yesalert2).click();
	Thread.sleep(2000);
	WebElement popmsg=AppHooks.getInstance().getDriver().findElement(pop2);
	
	String p=popmsg.getText();

	if(p.equals("Batches Deleted"))

		Logger_Load.info("Successfully Batches Deleted");
		
		else
			
			Logger_Load.info(" Batches not Deleted");





}

//threee



public void multipleclick()
{
	
	
	
	AppHooks.getInstance().getDriver().findElement(selectcheckbox1).click();
	AppHooks.getInstance().getDriver().findElement(selectcheckbox2).click();
	AppHooks.getInstance().getDriver().findElement(trashicon2).click();

	AppHooks.getInstance().getDriver().findElement(yesalert2).click();
}












}
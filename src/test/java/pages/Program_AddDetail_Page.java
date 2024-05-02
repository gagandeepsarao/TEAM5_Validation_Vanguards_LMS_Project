package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.interactions.Actions;

import constants.Constants;
import utilities.Logger_Load;
import app_hooks.AppHooks;

public class Program_AddDetail_Page {

	private static Program_AddDetail_Page AddprogramdetailPageObjects;

	private Program_AddDetail_Page() {};

	public static  Program_AddDetail_Page getInstance() {

		if(AddprogramdetailPageObjects==null) {
			AddprogramdetailPageObjects= new Program_AddDetail_Page ();
		}
		return AddprogramdetailPageObjects;

	}



	By newprogramBtn = By.xpath("//span[text()= 'A New Program']");
	By programDetail = By.xpath("//span[text() = 'Program Details']");
	By savebtn = By.xpath("//button[@id ='saveProgram']");
	By error = By.xpath("//small[@class = 'p-invalid ng-star-inserted']");
	By programname = By.xpath("//input[@id = 'programName']");
	By DesAlert = By.xpath("//small[@class = 'p-invalid ng-star-inserted']");
	By destextbox = By.xpath("//input[@id='programDescription']");
	By pronamealert = By.xpath("//small[text() ='Program name is required.']");
	By statusbtn = By.xpath("//p-radiobutton[@id = 'category']");
	By cancelicon =By.xpath("//button[@tabindex='-1']");
	By sucesspopup = By.xpath("//div[text() = 'Program Created Successfully']");
	By cancelbtn = By.xpath("//button[@icon = 'pi pi-times']");

	public void clickprogrambtn() {

		AppHooks.getInstance().getDriver().findElement(newprogramBtn).click();
	}

	
	public boolean checkProgramdetailPopup() {

		boolean popup = AppHooks.getInstance().getDriver().findElement(programDetail).isDisplayed();
		if (popup)
		{
			Logger_Load.info("ProgramDetail is displayed");
		}

		else
		{
			Logger_Load.info("ProgramDetail is not displayed");
		}
		return popup;
	}
	
	
	public void savedetail() {

		AppHooks.getInstance().getDriver().findElement(savebtn).click();
		
	}



    
	public boolean errorpopup() throws InterruptedException {
        Thread.sleep(10000);
		boolean popup = AppHooks.getInstance().getDriver().findElement(error).isDisplayed();
		if (popup)
		{
			Logger_Load.info("ProgramDetail is displayed");
		}

		else
		{
			Logger_Load.info("ProgramDetail is not displayed");
		}
		return popup;
	
	}
   
	public void protextbox() {
    	
    	AppHooks.getInstance().getDriver().findElement(programname).sendKeys("SDET150");
    	
     }
    
    
    public boolean alertpopup() {
    	boolean errorvisible;
    	
    	errorvisible = AppHooks.getInstance().getDriver().findElement(DesAlert).isDisplayed();
    	
    	if(errorvisible)
    		errorvisible = true;
    		
    		else
    			errorvisible = false;
    	return errorvisible;
    }

     public void destextbox() {
    	
    	AppHooks.getInstance().getDriver().findElement(destextbox).sendKeys("Software Testing");
    	
     }
    

     public void clickactivebtn() {

 		AppHooks.getInstance().getDriver().findElement(statusbtn).click();
 	}

     public void nametbox() {
     	
     	AppHooks.getInstance().getDriver().findElement(programname).sendKeys("1234");
     	AppHooks.getInstance().getDriver().findElement(destextbox).sendKeys("1234");
     	
     	
     }
     public void cancel() {

 		AppHooks.getInstance().getDriver().findElement(cancelicon).click();
 	}
     
     public void fields() {
    	 
    	 AppHooks.getInstance().getDriver().findElement(programname).sendKeys("SDET150");
    	 AppHooks.getInstance().getDriver().findElement(destextbox).sendKeys("Software Testing");
    	 AppHooks.getInstance().getDriver().findElement(statusbtn).click();
    	 AppHooks.getInstance().getDriver().findElement(savebtn).click();
    	 
    	 
     }
     
     
     public boolean sucessPopup() {

 		boolean popup = AppHooks.getInstance().getDriver().findElement(sucesspopup).isDisplayed();
 		if (popup)
 		{
 			Logger_Load.info("ProgramDetail is displayed");
 		}

 		else
 		{
 			Logger_Load.info("ProgramDetail is not displayed");
 		}
 		return popup;
     }
     
     

     public void cancelbtn() {

 		AppHooks.getInstance().getDriver().findElement(cancelbtn).click();
 	}
     
     
}

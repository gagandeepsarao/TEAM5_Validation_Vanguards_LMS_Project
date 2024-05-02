package pages;

import org.openqa.selenium.By;

import app_hooks.AppHooks;
import utilities.Logger_Load;

public class Program_Multipledelete_Page {
	
	
	
	private static Program_Multipledelete_Page MultipledeletePageObjects;

	private Program_Multipledelete_Page () {};

	public static  Program_Multipledelete_Page getInstance() {

		if(MultipledeletePageObjects==null) {
			MultipledeletePageObjects= new Program_Multipledelete_Page();
		}
		return MultipledeletePageObjects;

	}

    By titlecheckbox =  By.xpath("//thead[@class='p-datatable-thead']/tr[@class='ng-star-inserted']/th/p-tableheadercheckbox/div"); 
    By deleted = By.xpath("//div[text()='Successful']");
    By checkbox = By.xpath("//div[@class='p-checkbox-box']");
    
    
    
    
    public void checkbox() {

		AppHooks.getInstance().getDriver().findElement(titlecheckbox).click();
	}

    public boolean allcheckbox () {

		boolean popup = AppHooks.getInstance().getDriver().findElement(titlecheckbox).isDisplayed();
		if (popup)
		{
			Logger_Load.info("All Checkbox selected");
		}

		else
		{
			Logger_Load.info("All Checkbox selected");
		}
		return popup;
	}
    
    public void namecheckbox() {

		AppHooks.getInstance().getDriver().findElement(checkbox).click();
	}
    
    
    public boolean checkboxnamecreated () {

		boolean popup = AppHooks.getInstance().getDriver().findElement(titlecheckbox).isDisplayed();
		if (popup)
		{
			Logger_Load.info("All Checkbox selected");
		}

		else
		{
			Logger_Load.info("All Checkbox selected");
		}
		return popup;
	}
    
    
    
    
    
    
    
    
    
}
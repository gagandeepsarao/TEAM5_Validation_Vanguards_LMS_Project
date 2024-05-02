package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import app_hooks.AppHooks;
import constants.Constants;
import utilities.Logger_Load;

public class Program_Edit_Page {

	private static Program_Edit_Page EditprogramPageObjects;

	private Program_Edit_Page() {};

	public static Program_Edit_Page getInstance() {

		if(EditprogramPageObjects==null) {
			EditprogramPageObjects= new Program_Edit_Page ();
		}
		return EditprogramPageObjects;

	}

	By editbutton = By.xpath("//button[@id ='editProgram']");
	By editprogramDetail = By.xpath("//span[text() = 'Program Details']");
	By savebtn = By.xpath("//button[@id ='saveProgram']");
	By programname = By.xpath("//input[@id = 'programName']");
	By sucessmsg = By.xpath("//div[text() = 'Program Created Successfully']");
	By destext = By.xpath("//input[@id='programDescription']");
	By inactive = By.xpath("//div[@class = 'p-radiobutton-box']");
	By cancelbutton = By.xpath("//button[@icon = 'pi pi-times']");
	By programtextbox = By.xpath("//input[@id = 'programName']");
	By desfieldbox = By.xpath("//input[@id='programDescription']");
	By errormsg = By.xpath("//small[@class = 'p-invalid ng-star-inserted']");




	public void editbutton() {

		AppHooks.getInstance().getDriver().findElement(editbutton).click();
	}

	public boolean checkeditdetailPopup() {

		boolean programDetailpopupvisible;

		programDetailpopupvisible = AppHooks.getInstance().getDriver().findElement(editprogramDetail).isDisplayed();

		if(programDetailpopupvisible)
			programDetailpopupvisible = true;

		else
			programDetailpopupvisible = false;
		return programDetailpopupvisible ;


	}

	public void Edit() {

		AppHooks.getInstance().getDriver().findElement(programname).sendKeys("numpy");
		AppHooks.getInstance().getDriver().findElement(savebtn).click();
	}


	public boolean sucessmsg() {

		boolean sucessvisible;

		sucessvisible = AppHooks.getInstance().getDriver().findElement(sucessmsg).isDisplayed();

		if(sucessvisible)
			sucessvisible = true;

		else
			sucessvisible = false;
		return sucessvisible ;
	}


	public void descEdit() {

		AppHooks.getInstance().getDriver().findElement(destext).sendKeys("150");
		AppHooks.getInstance().getDriver().findElement(savebtn).click();
	}



	public boolean descsucessmsg () {

		boolean popup = AppHooks.getInstance().getDriver().findElement(sucessmsg).isDisplayed();
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


	public void changestatus() {

		AppHooks.getInstance().getDriver().findElement(inactive).click();

	}

	public void cancelwithoutchange() {

		AppHooks.getInstance().getDriver().findElement(cancelbutton).click();

	}


	public void detailsave() {


		AppHooks.getInstance().getDriver().findElement(savebtn).click();

	}
	
	public void invalidfiels() {

		AppHooks.getInstance().getDriver().findElement(programtextbox).sendKeys("12345");
		AppHooks.getInstance().getDriver().findElement(desfieldbox).sendKeys("=[-=");
		AppHooks.getInstance().getDriver().findElement(savebtn).click();
		AppHooks.getInstance().getDriver().findElement(errormsg).isDisplayed();
		
	}


}



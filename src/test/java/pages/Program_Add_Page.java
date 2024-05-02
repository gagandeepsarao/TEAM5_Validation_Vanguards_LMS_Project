package pages;

import org.openqa.selenium.By;

import app_hooks.AppHooks;
import utilities.Logger_Load;

public class Program_Add_Page {

	private static Program_Add_Page AddprogramPageObjects;

	private Program_Add_Page() {};

	public static  Program_Add_Page getInstance() {

		if(AddprogramPageObjects==null) {
			AddprogramPageObjects= new Program_Add_Page ();
		}
		return AddprogramPageObjects;

	}

	By newprogramBtn = By.xpath("//span[text()= 'A New Program']");
	By programDetail = By.xpath("//span[text() = 'Program Details']");
	By programName = By.xpath("//input[@id='programName']");
	By programDes = By.xpath("//input[@id='programDescription']");
	By programradiobtn = By.xpath("//div[@class = 'radio ng-star-inserted']");
	By editbtn = By.xpath("//button[@id ='editProgram']");
	By editprogram = By.xpath("//span[text() ='Program Details']");
	By deletebtn = By.xpath("//button[@id = 'deleteProgram']");

	public void clickprogrambtn() {

		AppHooks.getInstance().getDriver().findElement(newprogramBtn).click();
	}


	public boolean checkNewProgramPopup() {

		boolean popup = AppHooks.getInstance().getDriver().findElement(programDetail).isDisplayed();
		if (popup)
		{
			Logger_Load.info("NewPopup is displayed");
		}

		else
		{
			Logger_Load.info("NewPopup is not displayed");
		}
		return popup;
	}


	public boolean inputFields() {

		boolean popup = AppHooks.getInstance().getDriver().findElement(programName).isDisplayed();
		if (popup)
		{
			Logger_Load.info("NewPopup is displayed");
		}

		else
		{
			Logger_Load.info("NewPopup is not displayed");
		}
		return popup;
	}

	public boolean radioFields() {

		boolean popup = AppHooks.getInstance().getDriver().findElement(programradiobtn).isDisplayed();
		if (popup)
		{
			Logger_Load.info("NewPopup is displayed");
		}

		else
		{
			Logger_Load.info("NewPopup is not displayed");
		}
		return popup;
	}


	public void editbutton() {

		AppHooks.getInstance().getDriver().findElement(editbtn).click();

	}


	public boolean usereditdetail() {

		boolean popup = AppHooks.getInstance().getDriver().findElement(editprogram).isDisplayed();
		if (popup)
		{
			Logger_Load.info("NewPopup is displayed");
		}

		else
		{
			Logger_Load.info("NewPopup is not displayed");
		}
		return popup;
	}



	public void clickdelete(){


		AppHooks.getInstance().getDriver().findElement(deletebtn).click();

	}

}



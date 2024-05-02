package pages;

import org.openqa.selenium.By;

import app_hooks.AppHooks;
import utilities.Logger_Load;

public class Program_Delete_Page {
	
	private static Program_Delete_Page  MultipledeletepageObjects;

		private Program_Delete_Page() {};

		public static  Program_Delete_Page getInstance() {

			if(MultipledeletepageObjects==null) {
				MultipledeletepageObjects= new Program_Delete_Page();
			}
			return MultipledeletepageObjects;

		}

		By delete = By.xpath("//button[@id = 'deleteProgram']");
		By clickno = By.xpath("//span[text()='No']");
		By Confirmalert = By.xpath("//span[text()='Confirm']");
		By clickyes = By.xpath("//span[text()='Yes']");
		By deletedalert = By.xpath("//div[text()='Successful']");
		By cancel = By.xpath("//button[@class='ng-tns-c132-45 p-dialog-header-icon p-dialog-header-close p-link p-ripple ng-star-inserted']");
		


		public void clickdelete(){

        AppHooks.getInstance().getDriver().findElement(delete).click();

		}
		
		public void selectNo() {
			
			AppHooks.getInstance().getDriver().findElement(clickno).click();	
		}
		
		public boolean checkconfirmpopup() {

			boolean popup = AppHooks.getInstance().getDriver().findElement(Confirmalert).isDisplayed();
			if (popup)
			{
				Logger_Load.info("AlertPopup is displayed");
			}

			else
			{
				Logger_Load.info("AlertPopup is not displayed");
			}
			return popup;
		}
		
          public void selectyes() {
			
			AppHooks.getInstance().getDriver().findElement(clickyes).click();	
		}
		
          public boolean sucessfullpopup() {

  			boolean popup = AppHooks.getInstance().getDriver().findElement(deletedalert).isDisplayed();
  			if (popup)
  			{
  				Logger_Load.info("AlertPopup is displayed");
  			}

  			else
  			{
  				Logger_Load.info("AlertPopup is not displayed");
  			}
  			return popup;
  		}
          
          public void cancelicon() {
        	  
        	  AppHooks.getInstance().getDriver().findElement(cancel).click();
          }
}


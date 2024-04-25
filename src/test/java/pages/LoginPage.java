package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import app_hooks.AppHooks;
import app_hooks.DriverManager;
import constants.Constants;
import utilities.ConfigReader;
import utilities.Logger_Load;

public class LoginPage {
	private static LoginPage loginPageObjects;

	private LoginPage() {};

	public static LoginPage getInstance() {

		if(loginPageObjects==null) {
			loginPageObjects= new LoginPage();
		}
		return loginPageObjects;

	}

	By usernameTxt = By.xpath("//input[@id = 'username']");
	By passwordTxt = By.xpath("//input[@id = 'password']");
	By loginBtn = By.xpath("//button[@id = 'login']");
	
	public void enterusername() {
		AppHooks.getInstance().getDriver().findElement(usernameTxt).sendKeys(Constants.USER);
	}
		public void enterpassword() {
			AppHooks.getInstance().getDriver().findElement(passwordTxt).sendKeys(Constants.PASSWORD);
		
	}
		public void clickLoginBtn() {
			AppHooks.getInstance().getDriver().findElement(loginBtn).click();
		
		
	}
		public void checkTitleOfPage(String title)
		{
			String actTitle = AppHooks.getInstance().getDriver().getTitle();
			Logger_Load.info(actTitle);
			if(title.contains( actTitle))
				Logger_Load.info("Title is "+actTitle+" as expected");
			else
				Logger_Load.error("Title is "+actTitle+" - Not as expected");
			
		}
	
			}

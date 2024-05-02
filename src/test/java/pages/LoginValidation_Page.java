package pages;

import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import app_hooks.AppHooks;
import app_hooks.DriverManager;
import constants.Constants;
import utilities.ConfigReader;
import utilities.Logger_Load;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;


public class LoginValidation_Page {
	

	private static LoginValidation_Page loginPgObjects;

	private LoginValidation_Page() {};

 public static LoginValidation_Page getInstance() {

if(loginPgObjects==null) {
		loginPgObjects= new LoginValidation_Page();
	}
		return loginPgObjects;

	}
	
	
//	String successMessage="";
	String errorMessage ="";
	String validationMsg="";
	
	By Username = By.xpath("//input[@id = 'username']");
	By password = By.xpath("//input[@id = 'password']");
	By usernameTxt = By.xpath("//input[@id='username' and @formcontrolname='userLoginEmailId']");
	By passwordTxt = By.xpath("//input[@id='password' and @formcontrolname='password']");
	By loginBtn = By.xpath("//button[@id = 'login']");
	By Message = By.xpath("//mat-error[contains(text(), 'Invalid username and password Please try again')]");
	By ErrorMsgPswd =By.xpath("//mat-error[text()='Please enter your password']");
	By ErrorMsgUser= By.xpath("//mat-error[text()='Please enter your user name']");
	//*[@id="errormessage"]
	
	
	
	//By Message= By.xpath("//mat-error[contains(@class, 'mat-error')]");
	
    ////mat-error[@id='mat-error-3']
	
	public void clickWithoutGivingUserNameAndPassword()
	{
	
	 AppHooks.getInstance().getDriver().findElement(loginBtn).click();
		
	}
	
	public void clickWithoutGivingPasswords()
	{
		AppHooks.getInstance().getDriver().findElement(Username).sendKeys("sdetorganizers@gmail.com");
		AppHooks.getInstance().getDriver().findElement(loginBtn).click();
	}

	public void clickafterGivingValidCredentials()
	{
		
		//	AppHooks.getInstance().getDriver().findElement(Username).sendKeys(Constants.USER);
		//	AppHooks.getInstance().getDriver().findElement(password).sendKeys(Constants.PASSWORD);
			
			if (Constants.USER != null && !Constants.USER.isEmpty() && Constants.PASSWORD != null && !Constants.PASSWORD.isEmpty()) {
			    AppHooks.getInstance().getDriver().findElement(Username).sendKeys(Constants.USER);
			    AppHooks.getInstance().getDriver().findElement(password).sendKeys(Constants.PASSWORD);
			} else {
			    if (Constants.USER == null || Constants.USER.isEmpty()) {
			        System.err.println("Username is null or empty");
			    }
			    if (Constants.PASSWORD == null || Constants.PASSWORD.isEmpty()) {
			        System.err.println("Password is null or empty");
			    }
			}
		}
	
	public void CorrectCredentials()
	{
		
			AppHooks.getInstance().getDriver().findElement(Username);
			AppHooks.getInstance().getDriver().findElement(password);
			

		}
	
	
	public void clickWithoutGivingUsername()
	{
		AppHooks.getInstance().getDriver().findElement(password).sendKeys("sdetorganizers@gmail.com");
		AppHooks.getInstance().getDriver().findElement(loginBtn).click();
	}

	public void clickafterGivingInvalidCredentials()
	{
		
			AppHooks.getInstance().getDriver().findElement(Username).sendKeys(Constants.INCORRECTUSERNAME);
			AppHooks.getInstance().getDriver().findElement(password).sendKeys(Constants.INCORRECTPASSWORD);
			
		}
	
	public void clickafterGivingInvalidCredentials(String username,String Pswd)
	{
		AppHooks.getInstance().getDriver().findElement(Username).sendKeys(username);
		AppHooks.getInstance().getDriver().findElement(password).sendKeys(Pswd);
		
	}
		
	public void clickLoginButton()
	{
		AppHooks.getInstance().getDriver().findElement(loginBtn).click();
		
	
	}
	
	
	public void clickLoginButtonByMouse()
	{
		WebElement loginButton= AppHooks.getInstance().getDriver().findElement(loginBtn);
		Actions actions = new Actions(AppHooks.getInstance().getDriver());
		actions.moveToElement(loginButton).click().perform();
	
	}
	
	public void LoginByKeyBoard() {
		
		if (Constants.USER != null && !Constants.USER.isEmpty() && Constants.PASSWORD != null && !Constants.PASSWORD.isEmpty()) {
			WebElement usernameField = AppHooks.getInstance().getDriver().findElement(Username);
			usernameField.sendKeys(Constants.USER);
			WebElement passwordField = AppHooks.getInstance().getDriver().findElement(password);
			passwordField.sendKeys(Constants.PASSWORD);
			WebElement loginButton = AppHooks.getInstance().getDriver().findElement(loginBtn);
			loginButton.click();
		} else {
		    if (Constants.USER == null || Constants.USER.isEmpty()) {
		        System.err.println("Username is null or empty");
		    }
		    if (Constants.PASSWORD == null || Constants.PASSWORD.isEmpty()) {
		        System.err.println("Password is null or empty");
		    }
		}
	}
		
		
		
		
		
	//WebElement usernameField = AppHooks.getInstance().getDriver().findElement(Username);
	//usernameField.sendKeys(Constants.USER);

//	WebElement passwordField = AppHooks.getInstance().getDriver().findElement(password);
//	passwordField.sendKeys(Constants.PASSWORD);

//	WebElement loginButton = AppHooks.getInstance().getDriver().findElement(loginBtn);
//	loginButton.click();
	
//	}
	
	
	public String usernameGetAttribute()
    {
    	validationMsg=AppHooks.getInstance().getDriver().findElement(usernameTxt).getAttribute("validationMessage");
    	return validationMsg;
    	
    }
    public String pswdGetAttribute()
    {
    	validationMsg=AppHooks.getInstance().getDriver().findElement(passwordTxt).getAttribute("validationMessage");
	    return validationMsg;
    }
  
    public String geterrorMessageUser()
	{
	    errorMessage = AppHooks.getInstance().getDriver().findElement(ErrorMsgUser).getText();
    	return errorMessage;
	}
    
    
    public String geterrorMessage()
  	{
  	    errorMessage = AppHooks.getInstance().getDriver().findElement(Message).getText();
      	return errorMessage;
  	}
    
    
    public String geterrorMessagePswd()
  	{
  	    errorMessage = AppHooks.getInstance().getDriver().findElement(ErrorMsgPswd).getText();
      	return errorMessage;
  	}
    
    
  //  public String getSuccessMessage()
  //  {
  //  	successMessage = AppHooks.getInstance().getDriver().findElement(Message).getText();
    //	return successMessage;
 //   }
    
    public void pressEnterKeyInPasswordField() {
        
    	
    	AppHooks.getInstance().getDriver().findElement(password).sendKeys(Keys.ENTER);
    	
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
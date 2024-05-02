package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import app_hooks.AppHooks;
import utilities.Logger_Load;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import constants.Constants;
import pages.Common;


public class Dashboard_Page {
	
	
	Common commonFunctions = new Common();
	private static Dashboard_Page DBPgObjects;

	private Dashboard_Page() {};

 public static Dashboard_Page getInstance() {

if(DBPgObjects==null) {
		DBPgObjects= new Dashboard_Page();
	}
		return DBPgObjects;

	}
	 
		HttpURLConnection huc = null;
	    int respCode = 200;
	   
	 WebDriver driver = AppHooks.getInstance().getDriver();

		
	    long startRespTime; 
	  
	    By ManagePrgmTitle= By.xpath("//div[@class='box' and contains(text(), 'Manage Program')]");
	    By usernameTxt = By.xpath("//input[@id = 'username']");
		By passwordTxt = By.xpath("//input[@id = 'password']");
	    
	    By PrgBtn = By.xpath("//span[@class='mat-button-wrapper' and text()='Program']");
	
	By ProgamBtn= By.xpath("//button[@id='program']");
	By BatchBtn= By.xpath("//button[@id='batch']");
	By UserBtn= By.xpath("//button[@id='user']");
	By LogoutBtn= By.xpath("//button[@id='logout']");
	By LMSDashboardTitle = By.xpath("//span[normalize-space()='LMS - Learning Management System']");
	//By LMSDashboardTitle = By.xpath("//span[contains(text(), 'LMS - Learning Management System')]");
	By loginBtn = By.xpath("//button[@id = 'login']");
	
	//span[normalize-space()='LMS - Learning Management System']
	//button[@routerlink='/user']
	
	By SearchIcon= By.xpath("//input[@id='filterGlobal']");
	
	
	public void validateButtonOrder(Integer int1) {
	    List<By> buttonLocators = Arrays.asList(
	            By.xpath("//button[@id='program']"),
	            By.xpath("//button[@id='batch']"),
	            By.xpath("//button[@id='user']"),
	            By.xpath("//button[@id='logout']")
	    );

	    for (int i = 0; i < buttonLocators.size(); i++) {
	        WebElement button = driver.findElement(buttonLocators.get(i));
	        switch (int1) {
	            case 0:
	                if (button.getText().equals("Program")) {
	                    Logger_Load.info("Admin is able to see Program button in 1st place");
	                }
	                break;
	            case 1:
	                if (button.getText().equals("Batch")) {
	                    Logger_Load.info("Admin is able to see Batch button in 2nd place");
	                }
	                break;
	            case 2:
	                if (button.getText().equals("User")) {
	                    Logger_Load.info("Admin is able to see User button in 3rd place");
	                }
	                break;
	            case 3:
	                if (button.getText().equals("Logout")) {
	                    Logger_Load.info("Admin is able to see Logout button in 4th place");
	                }
	                break;
	            default:
	                Logger_Load.info("Button order validation failed");
	        }
	    }
	}

	public void MillisecBtnChk_Login() {
		
		//AppHooks.getInstance().getDriver().findElement(usernameTxt).sendKeys(Constants.USER);
		//AppHooks.getInstance().getDriver().findElement(passwordTxt).sendKeys(Constants.PASSWORD);
        //AppHooks.getInstance().getDriver().findElement(loginBtn).click();
        startRespTime = System.currentTimeMillis();
    }
	
	
	
	public String Header() {
	   
	    AppHooks.getInstance().getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	    WebElement element = null;
	    try {
	        element = AppHooks.getInstance().getDriver().findElement(ManagePrgmTitle);
	        if (element.isDisplayed()) {
	            return element.getText();
	        }
	    } catch (NoSuchElementException e) {
	   
	    } finally {
	     
	        AppHooks.getInstance().getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	    }

	    throw new RuntimeException("Timeout waiting for element with locator: " +ManagePrgmTitle );
	}
	

	
	public void DashboardPageVerification()
	{
		commonFunctions.verifyDashboardPage();
	}
	
	
		
//		public String Header() {
//		    long startTime = System.currentTimeMillis();
//		    long timeoutInMillis = 30000; // 30 seconds timeout
//		    WebElement element = null;
//		    
//		    while ((System.currentTimeMillis() - startTime) < timeoutInMillis) {
//		        try {
//		        	Thread.sleep(500);
//		            element = AppHooks.getInstance().getDriver().findElement(LMSDashboardTitle);
//		            if (element.isDisplayed()) {
//		                return element.getText();
//		            }
//		        } catch (Exception e) {
//		            
//		        }
//		    }
//		    
//		    throw new RuntimeException("Timeout waiting for element with locator: " + LMSDashboardTitle);
//		}
//		
		//return AppHooks.getInstance().getDriver().findElement(LMSDashboardTitle).getText();

	
	
	
	
		public void LMS_title(String expectedTitle) {
			//String actualTitle = driver.getTitle();
			
			String actualTitle = AppHooks.getInstance().getDriver().findElement(LMSDashboardTitle).getText();
			System.out.println("Actual Title: " + actualTitle);
			Assert.assertEquals(expectedTitle, actualTitle);
			System.out.println(actualTitle);        
}
	 public void ResponseTime(long thresholdMillisec) {
	        // Capture time after load
	        long end = System.currentTimeMillis();
	        // Calculate time
	        long pageLoadTime = end - startRespTime;

	        if (pageLoadTime < thresholdMillisec) {
	            Logger_Load.info("Page load time is less than " + thresholdMillisec + " milliseconds.");
	        } else {
	            Logger_Load.info("Page load time is more than " + thresholdMillisec + " milliseconds.");
	        }
	    }
//	
//	 public void validateButtonAlignment() {
//		 
//		    WebElement programBtn = driver.findElement(By.xpath("//button[@id='program']"));
//		    WebElement userBtn = driver.findElement(By.xpath("//button[@id='user']"));
//		    WebElement logoutBtn = driver.findElement(By.xpath("//button[@id='logout']"));
//
//		    int winWidth = driver.manage().window().getSize().getWidth();
//		    int winHeight = driver.manage().window().getSize().getHeight();
//		    
//		    boolean programAligned = isTopRight(programBtn, winWidth, winHeight);
//		    boolean userAligned = isTopRight(userBtn, winWidth, winHeight);
//		    boolean logoutAligned = isTopRight(logoutBtn, winWidth, winHeight);
//
//		    if (programAligned && userAligned && logoutAligned) {
//		        Logger_Load.info("Buttons are aligned on the top right side.");
//		    } else {
//		        Logger_Load.info("Buttons are not aligned on the top right side.");
//		    }
//		}

	 
	 public void validateButtonAlignment() {
		    WebElement programBtn = waitForElement(By.xpath("//button[@id='program']"));
		    WebElement userBtn = waitForElement(By.xpath("//button[@id='user']"));
		    WebElement logoutBtn = waitForElement(By.xpath("//button[@id='logout']"));

		    int winWidth = driver.manage().window().getSize().getWidth();
		    int winHeight = driver.manage().window().getSize().getHeight();

		    boolean programAligned = isTopRight(programBtn, winWidth, winHeight);
		    boolean userAligned = isTopRight(userBtn, winWidth, winHeight);
		    boolean logoutAligned = isTopRight(logoutBtn, winWidth, winHeight);

		    if (programAligned && userAligned && logoutAligned) {
		        Logger_Load.info("Buttons are aligned on the top right side.");
		    } else {
		        Logger_Load.info("Buttons are not aligned on the top right side.");
		    }
		}

		private WebElement waitForElement(By locator) {
		    int attempts = 0;
		    while(attempts < 5) {
		        try {
		            return driver.findElement(locator);
		        } catch (NoSuchElementException e) {
		            // Element not found, wait for a while and retry
		            try {
		                Thread.sleep(1000); // Adjust the delay as needed
		            } catch (InterruptedException ignored) {}
		        }
		        attempts++;
		    }
		    throw new NoSuchElementException("Element not found after multiple attempts: " + locator);
		}
		
		
		private boolean isTopRight(WebElement element, int winWidth, int winHeight) {
		    int xPos = element.getLocation().getX();
		    int yPos = element.getLocation().getY();
		    int eleWidth = element.getSize().getWidth();
		    int eleHeight = element.getSize().getHeight();

		// checking whether on right quadrant/side
		    return (xPos + eleWidth >= winWidth / 2) && (yPos <= winHeight / 2);
		}
		
		
		public void LMS_titleLocationLeft() {
		    int winHeight = driver.manage().window().getSize().getHeight();
		    int winWidth = driver.manage().window().getSize().getWidth();
		    
		    try {
		        WebElement LMS_titleElement = driver.findElement(By.xpath("//span[normalize-space()='LMS - Learning Management System']"));
		        
		        int xPos = LMS_titleElement.getLocation().getX();
		        int yPos = LMS_titleElement.getLocation().getY();
		        int eleWidth = LMS_titleElement.getSize().getWidth();
		        int eleHeight = LMS_titleElement.getSize().getHeight();
		        
		        if (xPos <= winWidth / 2 && yPos <= winHeight / 2) {
		            Logger_Load.info("Title is in the upper left corner of the page.");
		        } else {
		            Logger_Load.info("Title is NOT in the upper left corner of the page.");
		        }
		    } catch (NoSuchElementException e) {
		        Logger_Load.error("Element not found: LMS title element.");
		        // Handle NoSuchElementException as needed
		    }
		}
		
		
		public void checkBrokenLinks() {
		    List<WebElement> links = driver.findElements(By.tagName("a"));
		    Iterator<WebElement> it = links.iterator();

		    while (it.hasNext()) {
		        String linkURL = it.next().getAttribute("href");

		        if (linkURL == null || linkURL.isEmpty()) {
		            Logger_Load.info("URL is either not configured for anchor tag or it is empty");
		            continue; // Move to the next iteration
		        }

		        try {
		            URL url = new URL(linkURL);
		            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		            connection.setRequestMethod("HEAD");
		            connection.connect();
		            int responseCode = connection.getResponseCode();

		            if (responseCode >= 400) {
		                Logger_Load.info(linkURL + " is a broken link");
		            } else {
		                Logger_Load.info(linkURL + " is a valid link");
		            }
		        } catch (MalformedURLException e) {
		            Logger_Load.error("Malformed URL: " + linkURL);
		            e.printStackTrace();
		        } catch (IOException e) {
		            Logger_Load.error("Error connecting to URL: " + linkURL);
		            e.printStackTrace();
		        }
		    }
		}
		
		
		public String spellcheck() {
		    try {
		        if (isElementPresent(ProgamBtn))
		            return driver.findElement(ProgamBtn).getText();
		        if (isElementPresent(BatchBtn))
		            return driver.findElement(BatchBtn).getText();
		        if (isElementPresent(UserBtn))
		            return driver.findElement(UserBtn).getText();
		        if (isElementPresent(LogoutBtn))
		            return driver.findElement(LogoutBtn).getText();
		        if (isElementPresent(LMSDashboardTitle))
		            return driver.findElement(LMSDashboardTitle).getText();
		        if (isElementPresent(loginBtn))
		            return driver.findElement(loginBtn).getText();
		    } catch (NoSuchElementException e) {
		        // Handle NoSuchElementException if needed
		    }
		    return "String not found";
		}

		private boolean isElementPresent(By locator) {
		    try {
		        return driver.findElement(locator) != null;
		    } catch (NoSuchElementException e) {
		        return false;
		    }
		}
		
}

package pages;

import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import app_hooks.AppHooks;
import constants.Constants;
import utilities.Logger_Load;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import java.util.ArrayList;
import utilities.*;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;





public class HomePageValidation_Page {


	WebDriver driver = AppHooks.getInstance().getDriver();
	String url= AppHooks.getInstance().getDriver().getCurrentUrl();
	
 
 	String LinkURL = "";
	By LMS_Title = By.xpath("//title[text()='LMS']");
	By heading_Text= By.xpath("//p[text()='Please login to LMS application']");
	By companyLogo= By.xpath("//img[@class='images' and @src='assets/img/LMS-logo.jpg']");
	By userAsterick=  By.xpath("//label[@id='mat-form-field-label-1']//span[@aria-hidden='true' and contains(text(), '*')]");
	By passwordAsterick= By.xpath("//label[@id='mat-form-field-label-3']//span[@aria-hidden='true' and contains(text(), '*')]");
	By userName= By.xpath("//input[@id='username']");
	By password= By.xpath("//input[@id = 'password']");
	By loginBtn = By.xpath("//button[@id = 'login']");
	By userTextField= By.xpath("//label[@for='username']");
	By pswdTextField= By.xpath("//label[@for='password']");
	By labelLocator = By.xpath("//label[@for='username']");

	
	//Admin should see company name below the app name

	 public boolean isCompanyLogoDisplayed() {
	        WebElement logoElement = driver.findElement(companyLogo);

	        if (logoElement.isDisplayed()) {
	            Logger_Load.info("Company logo is displayed.");
	            return true;
	        } else {
	            Logger_Load.error("Company logo is not displayed.");
	            return false;
	        }
	    }
	
	//Admin should see "Please login to LMS application"


	 public boolean isSignInContentDisplayed() {
	       
	        boolean isUserNameDisplayed = driver.findElement(userName).isDisplayed();
	        boolean isPasswordDisplayed = driver.findElement(password).isDisplayed();
	        boolean isLoginBtnDisplayed = driver.findElement(loginBtn).isDisplayed();
	        boolean isHeadingTxtDisplayed =driver.findElement(heading_Text).isDisplayed();
	      
	        if (isUserNameDisplayed && isPasswordDisplayed && isLoginBtnDisplayed && isHeadingTxtDisplayed) {
	            Logger_Load.info("Sign-in content is displayed.");
	            return true;
	        } else {
	            Logger_Load.error("Sign-in content is not displayed.");
	            return false;
	        }
	    }
	 
	//Admin should land on the home page

 	 public void url() {
		AppHooks.getInstance().getDriver().get(Constants.URL);
				 
		}
	
	 public void invalid_url() {
			//	driver.get(invalid_url);

			}

	 //Admin should recieve 404 page not found error 

	 		public void invalidURLstatus() {
	 			
	 //	AppHooks.getInstance().getDriver().get(Constants.INVALIDURL);
	//		AssertJUnit.assertTrue(driver.getTitle().contains("404"));
	 			

	 			
	 			
	 			
	 		}
	 //HTTP response >= 400. Then the link is broken
	
	 	public List<String> broken_links() {
			
	 	       	List<String> brokenLinks = new ArrayList<>();
	 	        List<WebElement> links =  driver.findElements(By.xpath("//a[@href]"));
	 	        
	 	       for (WebElement link : links) {
	 	            String url = link.getAttribute("href");
	 	            try {
	 	                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
	 	                connection.connect();
	 	                int responseCode = connection.getResponseCode();
	 	                if (responseCode >= 400) {
	 	                    brokenLinks.add(url);
	 	                						}
	 	                connection.disconnect();
	 	            	} catch (Exception e) {
	 	                e.printStackTrace();
	 	                brokenLinks.add(url);
	 	            	}
	 	        	}
	 	        return brokenLinks;
	 			}

	
		//Admin should see correct spellings in all fields 

				public boolean spellCheckForElements() {
				 
				    WebElement title_LMS = driver.findElement(LMS_Title);
				    WebElement username = driver.findElement(userName);
				    WebElement Pswd = driver.findElement(password);
				    WebElement login = driver.findElement(loginBtn);
				    WebElement headingText = driver.findElement(heading_Text);

				  
				    boolean allCorrect = true;
				    allCorrect &= spellCheckElement(title_LMS, "LMS Title");
				    allCorrect &= spellCheckElement(username, "Username");
				    allCorrect &= spellCheckElement(Pswd, "Password");
				    allCorrect &= spellCheckElement(login, "Login Button");
				    allCorrect &= spellCheckElement(headingText, "Heading Text");

				    return allCorrect;
				}

					private boolean spellCheckElement(WebElement element, String elementName) {
				 
				    String text = element.getText();
				    
				    boolean isCorrect = text.equalsIgnoreCase(elementName);
				    if (isCorrect) {
				        System.out.println("The " + elementName + " is correct: " + text);
				    } else {
				        System.out.println("The " + elementName + " is incorrect: " + text);
				    }

				    return isCorrect;
				}
		
		
		
					public void checkTitleOfMainPage(String MainPg_title)
					{
						String actualTitle = driver.getTitle();
						Logger_Load.info(actualTitle);
						if(MainPg_title.contains( actualTitle))
							Logger_Load.info("Title is "+actualTitle+" as expected");
						else
							Logger_Load.error("Title is "+actualTitle+" - Not as expected");
				
					}
		
					
	// Admin should see logo on the left  side
					
					public void verifylogoAlignmentAndPosition() {
					    // Locate the image element
					    WebElement logoImage = driver.findElement(By.xpath("//img[@src='assets/img/LMS-logo.jpg']"));

					    // Get the location and size of the image element
					    Rectangle imageRect = logoImage.getRect();
					    int imageXCoordinate = imageRect.getX();
					    int imageYCoordinate = imageRect.getY();

					    // Define the coordinates of the reference element
					    int referenceXCoordinate = 100; // Example: x-coordinate of the reference element
					    int referenceYCoordinate = 200; // Example: y-coordinate of the reference element

					    // Define acceptable tolerance for alignment
					    int tolerance = 5; // Adjust this value as needed

					    // Check if the image is aligned with the reference element within the tolerance range
					    boolean isAligned = Math.abs(imageXCoordinate - referenceXCoordinate) <= tolerance &&
					                        Math.abs(imageYCoordinate - referenceYCoordinate) <= tolerance;

					    if (isAligned) {
					        System.out.println("The image is aligned with the reference element.");
					    } else {
					        System.out.println("The image is not aligned with the reference element.");
					    }

					    // Check if the image is on the left side
					    boolean isOnLeftSide = imageXCoordinate < referenceXCoordinate;

					    if (isOnLeftSide) {
					        System.out.println("The image is on the left side of the page.");
					    } else {
					        System.out.println("The image is not on the left side of the page.");
					    }
					}

		//			public void verifyAlignmentAndCaptureLogo() {
		//			    WebElement companyLogo = driver.findElement(By.xpath("//img[@class='images' and @src='assets/img/LMS-logo.jpg']"));

		//			    Boolean isImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
		//			        "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
		//			        companyLogo);

		//			    if (isImagePresent) {
		//			        System.out.println("Image is displayed and aligned.");
		//			        try {
		//			            Screenshot_utils.webeScreenshot(driver, companyLogo);
		//			        } catch (IOException e) {
		//			            e.printStackTrace();
		//			        }
		//			    } else {
		//			        System.out.println("Image not displayed or not aligned.");
		//			    }
		//			}

//Admin should see two text field

				
				public void textCheck(int expectedTextFieldsCount) {
				    
				    WebElement usernameLabel = driver.findElement(By.xpath("//label[@for='username']"));
				    WebElement passwordLabel = driver.findElement(By.xpath("//label[@for='password']"));

	
				    if (usernameLabel != null && passwordLabel != null) {
				        
				        if (expectedTextFieldsCount == 2) {
				            Logger_Load.info("Both username and password text fields are present");
				        } else {
				            Logger_Load.info("Both username and password labels are present, but expected " + expectedTextFieldsCount + " text fields");
				        }
				    } else {
				      
				        Logger_Load.info("One or both of the username and password labels are missing");
				    }
				}
				 
		//		public class TextFieldVerification {
				    
		//		    WebDriver driver;
				    
		//		    public TextFieldVerification() {
		//		        this.driver = driver;
		//		    }
				    
		//		    public boolean areTextFieldsPresent() {
		//		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//		        
		//		        WebElement userField = driver.findElement(userTextField);
		//		        WebElement pswdField = driver.findElement(pswdTextField);
				        
		//		        return userField != null && pswdField != null;
		//		    }
		//		}
				
				
				
				//public void textcheck(int a) {
		//		List<WebElement> textfields = driver.findElements(userName or password);
			//	int size = textfields.size();
		//		if(size==a) {
		//			Logger_Load.info("2 text fields are present");
		//		}
		//		else {
		//			Logger_Load.info("text fields are not 2");
		//		}
		//	}
		//	public void getallText() {
		//		driver.getPageSource();
		//	}
			

	//Admin should see "user" in the first text field
				
				
				
				  public void WordCheckUser(String expectedUserWord) { 
					   
			    	  WebElement userLabel = driver.findElement(userName);

	
				    if (userLabel != null) {
				        
				        if (expectedUserWord == "username") {
				            Logger_Load.info("The username is present");
				        } else {
				            Logger_Load.info("The word username is present, but expected " + expectedUserWord + " text fields");
				        }
				    } else {
				      
				        Logger_Load.info("The word password is missing");
				    }
				}
	
//				public void verifyUserTxtFieldText(String expectedMsg) {
//				    WebElement textField = driver.findElement(userName);
//				    String actualMsg = textField.getAttribute("value");
//				    System.out.println("Actual text in the text field: " + actualMsg);
//				    Assert.assertEquals(expectedMsg, actualMsg);
//				    
	//			}
				
				
				
				
				
							
						
	//Admin should see * symbol next to user text
				      
			//	      public void astrikuser(String string) {
			//	    	  String expectedmsg = string;
			//	  		String actualmsg = driver.findElement(userAsterick).getText();
			//	  		Assert.assertEquals(expectedmsg,actualmsg);
			//	  		 System.out.println(actualmsg);
			//	      } 
				      
				      
				      public void verifyAsteriskNextToUser(String expectedAsterisk) {
				    	    try {
				    	       
				    	        WebElement asteriskElement = driver.findElement(userAsterick);
				    	        String actualAsterisk = asteriskElement.getText();
				    	        Assert.assertEquals(expectedAsterisk, actualAsterisk);
				    	        System.out.println("Actual asterisk symbol: " + actualAsterisk);
				    	    } catch (NoSuchElementException e) {
				    	       
				    	        System.out.println("Asterisk element not found!");
				    	       
				    	    }
				    	}

				
		//Admin should  see "password" in the second text field
		
		      
				      public void textCheckPswd(String expectedPswdWord) { 
					   
				    	  WebElement passwordLabel = driver.findElement(password);

		
					    if (passwordLabel != null) {
					        
					        if (expectedPswdWord == "password") {
					            Logger_Load.info("The password is present");
					        } else {
					            Logger_Load.info("The word password are present, but expected " + expectedPswdWord + " text fields");
					        }
					    } else {
					      
					        Logger_Load.info("The word password is missing");
					    }
					}
//				      public void passwordtext(String string) {
//			    	  
//			    	    String expectedmsg = string;
//			    	    String actualmsg = driver.findElement(password).getText();
//			    	    System.out.println("Actual password text: " + actualmsg);
//			    	    Assert.assertEquals(expectedmsg, actualmsg);
	
						
				      
	//Admin should see * symbol next to password text
				    
				      public void astrikpassword(String string) {
				    	  String expectedmsg = string;
				  		String actualmsg = driver.findElement(userAsterick).getText();
				  		Assert.assertEquals(expectedmsg,actualmsg);
				  		 System.out.println(actualmsg);
				      }
				      
			      
	//Admin should see input field on the centre of the page
			
			     public void centrepage() {
			           
			        	Dimension dimuser =driver.findElement(userName).getSize();
			            Dimension dimpassword = driver.findElement(password).getSize();
			           int heightuser= dimuser.height;
			           int widthuser=dimuser.width;
			           int heightpassword= dimpassword.height;
			           int widthpassword=dimpassword.width;
			           
			           if (heightuser>30 & heightuser<60 & widthuser>400 & widthuser<600 & heightpassword >30 &heightpassword<60 
			          		 & widthpassword>400 & widthpassword<600 ) {
			          	Logger_Load.info("Both text boxes are in page center");
			           }  
			        }		
			
			     // Admin should see login button on the centre of the page
   
			     public void centreloginbtn() {
			          Dimension dimuser = driver.findElement(loginBtn).getSize();
			         int heightuser= dimuser.height;
			         int widthuser=dimuser.width;
			         
			         if (heightuser>30 & heightuser<60 & widthuser>400 & widthuser<600  ) {
			        	Logger_Load.info("Login button in the centre");
			         }  
			      }
			     
			     
		//Admin should see user in gray color

			     public void usercolor() {
			    	  String color = driver.findElement(userName).getCssValue("color");
			    	  String hex = Color.fromString(color).asHex();
			    	  
			    	  if (hex=="#808080" ) {
			    		  Logger_Load.info("User String is in grey color");
			    	  }
			    	  else {
			    		  Logger_Load.info("User String is not in grey color");
			    	  }
			      }
		
			     //
			     
			     public void passwordcolor() {
			    	  String color = driver.findElement(password).getCssValue("color");
			    	  String hex = Color.fromString(color).asHex();
			    	  
			    	  if (hex=="#808080" ) {
			    		  Logger_Load.info("User String is in grey color");
			    	  }
			    	  else {
			    		  Logger_Load.info("User String is not in grey color");
			    	  }
			      }
}

//String invalid_url=ConfigfileReader.getInvalidUrl();

//<p _ngcontent-evp-c85="">Please login to LMS application</p>

//<mat-error _ngcontent-evp-c85="" role="alert" id="errormessage" class="mat-error ng-star-inserted"> Invalid username and password Please try again </mat-error>
//HttpURLConnection huc = null;
//    int respCode = 200;
//Actions act = new Actions(driver);

//<img _ngcontent-rvg-c85="" src="assets/img/LMS-logo.jpg" class="images">
//<p _ngcontent-rvg-c85="">Please login to LMS application</p>

// <span aria-hidden="true" class="mat-placeholder-required mat-form-field-required-marker ng-tns-c78-0 ng-star-inserted"> *</span>

////span[contains(@class, 'mat-placeholder-required') and contains(@class, 'mat-form-field-required-marker')]

//<button _ngcontent-rvg-c85="" id="login" mat-raised-button="" color="primary" type="submit" class="mat-focus-indicator login-button mat-raised-button mat-button-base mat-primary"><span class="mat-button-wrapper">Login</span>
//<span matripple="" class="mat-ripple mat-button-ripple"></span><span class="mat-button-focus-overlay"></span></button>



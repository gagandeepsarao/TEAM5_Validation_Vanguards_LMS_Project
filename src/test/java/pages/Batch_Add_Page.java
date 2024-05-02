package pages;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.checkerframework.checker.index.qual.SubstringIndexFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import app_hooks.AppHooks;
import utilities.Logger_Load;

public class Batch_Add_Page {

	static String currentDateTime;

	private static Batch_Add_Page  AddPageObjects;

	private  Batch_Add_Page () {};
	Common commonFunctions = new Common();
	public static Batch_Add_Page getInstance() {

		if(AddPageObjects==null) {
			AddPageObjects= new  Batch_Add_Page ();
		}
		return AddPageObjects;

	}
	By getpopup=By.xpath("//div[@role='dialog']");
	
	By nameele=By.xpath("//label[text()='Name']");  //name
	
	By namefield=By.xpath("//input[@id='batchName']");//nametextbox
	
	
	By descriptionfield=By.xpath("//input[@id='batchDescription']");
	By programnamedropwn=By.xpath("//input[@placeholder='Select a Program name']");//dropdowntextbox ele
	
	By droparrow=By.xpath("//div[@role='button']");//arrowdropele
	By myoption=By.xpath("(//li[@role='option'])[1]");
	By myoption2=By.xpath("//span[text()='djfbmksndbmgf']");
	By programnametestbox=By.xpath("(//input[@aria-haspopup='listbox'])[2]");
	
	By emptydescription=By.xpath("//small");
	By activeradiobutton=By.xpath("//div[@class='p-radiobutton-box'][1]");
	By activeradiobuttonII=By.xpath("//input[@type='radio'][1]");
	
	 By tableele=By.xpath("//table[@role='grid']");
	By noofclassfield=By.xpath("//input[@id='batchNoOfClasses']");
	
	By savebutton=By.xpath("//span[text()='Save']");
	
	By batchname=By.xpath("//table//tbody//tr//td)[2]");
	
	
	By poperrormsg=By.xpath("//div[text()='Failed']");
	
	
	By searchbox=By.xpath("//input[@id='filterGlobal']");
	By gettherow=By.xpath("(//TR//TD)[2]");
	//By invalidfields=By.xpath("//small[@class='p-invalid ng-star-inserted']");
    By errorclassfield=By.xpath("//small[text()='Number of classes is required.']");
   By rowbatchcreated=By.xpath( "(//table[@role='grid']//tr)[2]//td[2]");
	//display popup
	public boolean displaypopup()
{
	
	
	boolean popup = AppHooks.getInstance().getDriver().findElement(getpopup).isDisplayed();
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
	
	
	
	

//validate popup
public void popupfields() {

 
	
	// Check if each field exists in the pop-up
    WebElement isNameFieldPresent = AppHooks.getInstance().getDriver().findElement(namefield);
    
    String namefieldtype= isNameFieldPresent.getAttribute("type");
   
    boolean istesx1=namefieldtype.equals("text");
    WebElement isDescriptionFieldPresent = AppHooks.getInstance().getDriver().findElement(descriptionfield);
    String descriptionfieldtype= isNameFieldPresent.getAttribute("type");
    
    boolean istesx2= descriptionfieldtype.equals("text");
    
    WebElement ispgmnamefieldFieldPresent = AppHooks.getInstance().getDriver().findElement(programnametestbox);
    String programnamefieldtype=ispgmnamefieldFieldPresent.getAttribute("aria-haspopup");
    //String programnamefieldtype= ispgmnamefieldFieldPresent.getTagName();
    
    boolean istesx3= programnamefieldtype.equals("listbox");
    
    
    
  
    
  
    WebElement isstatus = AppHooks.getInstance().getDriver().findElement(activeradiobuttonII);
   // String statustype=isNameFieldPresent.getAttribute("type");
    String statustype=isstatus.getAttribute("type");
    boolean istesx4=statustype.equals("radio");
    
    

    
    WebElement isnoofclass = AppHooks.getInstance().getDriver().findElement(noofclassfield);
    String classtype= isnoofclass.getAttribute("type");
    boolean istesx5=classtype.equals("number");
    
   
	Logger_Load.info("name field is a text box" +istesx1);
	Logger_Load.info("Description field is a text box" +istesx2);
	Logger_Load.info("Programname field is a drop down" +istesx3);
	
	Logger_Load.info("status field is a radio button" +istesx4);
	Logger_Load.info("no.of classes field is a text box" +istesx5);
	
	
	
	
	


}

//empty description
public void fillthefields() {
	
	
	Calendar calendar = Calendar. getInstance(); 
	Date currentDate = calendar.getTime(); 
	String currentDateTime = currentDate.toString();
	
	currentDateTime = currentDateTime.substring(9, 20);
	currentDateTime = "Test" + currentDateTime;
	System.out.println(currentDateTime);
	
//AppHooks.getInstance().getDriver().findElement(namefield).sendKeys("seleniumamaters2");
	AppHooks.getInstance().getDriver().findElement(namefield).sendKeys(currentDateTime);
//AppHooks.getInstance().getDriver().findElement(programnametestbox).sendKeys("Sdet45e");
	AppHooks.getInstance().getDriver().findElement(droparrow).click();
	AppHooks.getInstance().getDriver().findElement(myoption).click();
AppHooks.getInstance().getDriver().findElement(activeradiobutton).click();


AppHooks.getInstance().getDriver().findElement(noofclassfield).sendKeys("1");

AppHooks.getInstance().getDriver().findElement(savebutton).click();



}

public void errorfield() {
	
	
	String errordescrip=AppHooks.getInstance().getDriver().findElement(emptydescription).getText();
	
	System.out.println(errordescrip);
	
}


//valid inputs
public void validbatch() throws InterruptedException
{
	
	
	Calendar calendar = Calendar. getInstance(); 
	Date currentDate = calendar.getTime(); 
	String currentDateTime = currentDate.toString();
	
	currentDateTime = currentDateTime.substring(9, 20);
	currentDateTime = "Test" + currentDateTime;
//	String batName=(new StringBuilder()).append("Test").append("currentDateTime").toString();  
	System.out.println(currentDateTime);
	//AppHooks.getInstance().getDriver().findElement(searchbox).sendKeys(currentDateTime); 
	Thread.sleep(2000);
	AppHooks.getInstance().getDriver().findElement(namefield).sendKeys(currentDateTime);
	//AppHooks.getInstance().getDriver().findElement(namefield).sendKeys(name);
	
	AppHooks.getInstance().getDriver().findElement(descriptionfield).sendKeys("seleauto2123");
	AppHooks.getInstance().getDriver().findElement(droparrow).click();
	//WebElement drop=AppHooks.getInstance().getDriver().findElement(droparrow);
	
	//Select d=new Select(drop);

	
	//d.selectByIndex(2);
	
	AppHooks.getInstance().getDriver().findElement(myoption).click();
	//Thread.sleep(2000);
	////span[text()="SDET155"]AppHooks.getInstance().getDriver().findElement(programnametestbox).sendKeys("RubySJC");
	//AppHooks.getInstance().getDriver().findElement(droparrow).sendKeys("program5n8");

	Thread.sleep(1000);
	AppHooks.getInstance().getDriver().findElement(activeradiobutton).click();

	Thread.sleep(2000);
	
	AppHooks.getInstance().getDriver().findElement(noofclassfield).sendKeys("3");

	Thread.sleep(2000);

    AppHooks.getInstance().getDriver().findElement(savebutton).click();
    
    AppHooks.getInstance().getDriver().findElement(searchbox).sendKeys(currentDateTime);
	//WebElement newbatch=AppHooks.getInstance().getDriver().findElement(gettherow);
	//newbatch.getText();
	//System.out.println(newbatch.toString());
	



}

public void batchpresent() throws InterruptedException
{
	
//	Calendar calendar = Calendar. getInstance(); 
//	Date currentDate = calendar.getTime(); 
//	String currentDateTime = currentDate.toString();
//	
//	currentDateTime = currentDateTime.substring(9, 20);
//	currentDateTime = "Test" + currentDateTime;
//	//String batName=(new StringBuilder()).append("Test").append("currentDateTime").toString();  
//	System.out.println(currentDateTime);
	
	//AppHooks.getInstance().getDriver().findElement(searchbox).sendKeys(currentDateTime);
	//WebElement newbatch=AppHooks.getInstance().getDriver().findElement(gettherow);
	//newbatch.getText();
	//System.out.println(newbatch);
//Thread.sleep(2000);
	//String Createdbatchname = AppHooks.getInstance().getDriver().findElement(batchname).getText();
	 //Logger_Load.info("Batch Name present" +Createdbatchname);

Thread.sleep(5000);
		WebElement elecheckbox=AppHooks.getInstance().getDriver().findElement(rowbatchcreated);
		//List<WebElement> totalRow = elecheckbox.findElements(By.tagName("tr"));
		String data = elecheckbox.getText();
		//System.out.println(totalRow.toString());
		//WebElement data = totalRow.get(0);//.toString();
		
		//if(data.equals("Test9 11:15:40"))
		 Logger_Load.info(" New Batch created"); 
		
		
		

}

//invalid input
public void invalidfiels() throws InterruptedException
{
	
	AppHooks.getInstance().getDriver().findElement(namefield).sendKeys("1STER122234@");
	Thread.sleep(1000);
	AppHooks.getInstance().getDriver().findElement(descriptionfield).sendKeys("seleau");
	AppHooks.getInstance().getDriver().findElement(droparrow).click();
	Thread.sleep(1000);
	AppHooks.getInstance().getDriver().findElement(myoption).click();
	Thread.sleep(1000);
	AppHooks.getInstance().getDriver().findElement(activeradiobutton).click();

	Thread.sleep(2000);
	
	AppHooks.getInstance().getDriver().findElement(noofclassfield).sendKeys("1");

	Thread.sleep(2000);

    AppHooks.getInstance().getDriver().findElement(savebutton).click();
   
	
	
}

public void erromessage() throws InterruptedException {
	

Thread.sleep(1000);
  WebElement errormessage=AppHooks.getInstance().getDriver().findElement(poperrormsg);

 String errr=errormessage.getText();

 Logger_Load.info(errr);






}


//scenario5
public void madatoryfields() throws InterruptedException
{
	
	
	
	Calendar calendar = Calendar. getInstance(); 
	Date currentDate = calendar.getTime(); 
	String currentDateTime = currentDate.toString();
	
	currentDateTime = currentDateTime.substring(9, 20);
	currentDateTime = "Test" + currentDateTime;
//	String batName=(new StringBuilder()).append("Test").append("currentDateTime").toString();  
	System.out.println(currentDateTime);
	//AppHooks.getInstance().getDriver().findElement(searchbox).sendKeys(currentDateTime); 
	Thread.sleep(2000);
	AppHooks.getInstance().getDriver().findElement(namefield).sendKeys(currentDateTime);
	AppHooks.getInstance().getDriver().findElement(descriptionfield).sendKeys("seleauto2123");
	AppHooks.getInstance().getDriver().findElement(droparrow).click();
	//WebElement drop=AppHooks.getInstance().getDriver().findElement(droparrow);
	
	//Select d=new Select(drop);

	
	//d.selectByIndex(2);
	
	AppHooks.getInstance().getDriver().findElement(myoption).click();
	//Thread.sleep(2000);
	////span[text()="SDET155"]AppHooks.getInstance().getDriver().findElement(programnametestbox).sendKeys("RubySJC");
	//AppHooks.getInstance().getDriver().findElement(droparrow).sendKeys("program5n8");

	Thread.sleep(1000);
	AppHooks.getInstance().getDriver().findElement(activeradiobutton).click();

	Thread.sleep(2000);
	
	//AppHooks.getInstance().getDriver().findElement(noofclassfield).sendKeys("3");

	Thread.sleep(2000);

    AppHooks.getInstance().getDriver().findElement(savebutton).click();
	
	
	
}

public void errorclass()
{
	
	
	
	WebElement geterrormessage= AppHooks.getInstance().getDriver().findElement(errorclassfield);
		
	
	String get=geterrormessage.getText();
	
	Logger_Load.info(get);
	
	
	
	
	
	
	
}





 





}


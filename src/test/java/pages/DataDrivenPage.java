package pages;

import utilities.Common_utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;

import app_hooks.AppHooks;
import constants.Constants;
import utilities.Excel_Reader;
import utilities.Logger_Load;

public class DataDrivenPage{
	private static DataDrivenPage dataDrivenPageObjects;
	
	private final static String propertyWriteFilePath = "./src/test/resources/writeconfig.properties";
	
	public static void loadWriteConfig(String key, String value) throws Throwable {

		try {
			FileOutputStream fos = new FileOutputStream(propertyWriteFilePath,true);
			Properties prop = new Properties();
			
			prop.setProperty(key, value);
			prop.store(fos, null);
			fos.close();

			try {
				prop.store(fos,null);
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("config.properties not found at config file path " + propertyWriteFilePath);
		}
	}



	private DataDrivenPage() {};

	public static DataDrivenPage getInstance() {

		if(dataDrivenPageObjects==null) {
			dataDrivenPageObjects= new DataDrivenPage();
		}
		return dataDrivenPageObjects;

	}
	
	

	By batchBtn = By.xpath("//button[@id='batch']");

	By addProgramBtn =By.xpath("//button[@label='A New Program']");
	By addBatchBtn =By.xpath("//button[@label='A New Batch']");

	By programNameTxt = By.xpath("//div//input[@id='programName']");
	By programDescriptionTxt = By.xpath("//div//input[@id='programDescription']");
	By activeRadio = By.xpath("//div[contains(text(),'Active')]//div[2]");
	By inactiveRadio = By.xpath("//div[contains(text(),'Inactive')]//div[2]");
	By saveBtn = By.xpath("//span[normalize-space()='Save']");
	By cancelBtn = By.xpath("//span[normalize-space()='Cancel']");
	By popupMessage = By.xpath("//div[contains(@class,'p-toast-detail')]");
	
	By batchNameTxt = By.xpath("//input[@id='batchName']");
	By batchDescriptionTxt = By.xpath("//input[@id='batchDescription']");
	By noOfClassesTxt = By.xpath("//input[@id='batchNoOfClasses']");
	//By progNameDropDown = By.xpath("//p-dropdown[@id='programName']//div[@role='button']");
	
	//By progNameSelOption1 = By.xpath("//li[@role='option'])[1]");
	
	By droparrow=By.xpath("//div[@role='button']");//arrowdropele

	By myoption=By.xpath("(//li[@role='option'])[1]");
	By activeradiobutton=By.xpath("//div[@class='p-radiobutton-box'][1]");



	
	public void clickaddProgramBtn() {
			AppHooks.getInstance().getDriver().findElement(addProgramBtn).click();
		
		
	}
	
	public void createNewProgram() throws Throwable
		{
			//String excelPath = "D:\\LMS_UI\\TEAM5_Validation_Vanguards_LMS_Project\\src\\test\\resources\\TestData\\LMS_valid_data.xlsx";
			String sheetName = "ProgramModule";	
			System.out.println(Constants.EXCELPATH);
			int validRun=0;
			  List<Map<String, String>> getUserData=
					  (Excel_Reader.getData(Constants.EXCELPATH,sheetName));
			 //System.out.println(getUserData.toString());
			 // Iterate over each row of data 
			 for (Map<String, String> row : getUserData)
			 {
				 System.out.println(row);
			  String Scenario = row.get("Scenario");
			  String programName = row.get("programName");
			  String programDescription = row.get("programDescription");
			  String programStatus = row.get("programStatus");
			  
			  Logger_Load.info(Scenario);
			  AppHooks.getInstance().getDriver().findElement(addProgramBtn).click();
			  
			  AppHooks.getInstance().getDriver().findElement(programNameTxt).sendKeys(programName);			  
			  AppHooks.getInstance().getDriver().findElement(programDescriptionTxt).sendKeys(programDescription);

			  if (programStatus.equals("active"))
				  AppHooks.getInstance().getDriver().findElement(activeRadio).click();
			  else
				  AppHooks.getInstance().getDriver().findElement(inactiveRadio).click();
				  
			  
			  AppHooks.getInstance().getDriver().findElement(saveBtn).click();
			  String popMessage = AppHooks.getInstance().getDriver().findElement(popupMessage).getText();
			  Thread.sleep(8000);
			  //loadWriteConfig();

			  if(popMessage.contains("Program Created Successfully"))
			  {
				  validRun++;
				  Logger_Load.info("Program is created successfully");
				  String ProgramCreated = programName;
				  Logger_Load.info("Program Name Created: "+ProgramCreated );
				  loadWriteConfig("ProgramCreated"+validRun+":", ProgramCreated);

			  }	  
			  else
				  Logger_Load.error("Program is not created successfully");
			 }

		}
	public void createNewBatch() throws Throwable
	{
		//String excelPath = "D:\\LMS_UI\\TEAM5_Validation_Vanguards_LMS_Project\\src\\test\\resources\\TestData\\LMS_valid_data.xlsx";
		String sheetName = "BatchModule";	
		int validRun=0;

		  List<Map<String, String>> getUserData=
				  (Excel_Reader.getData(Constants.EXCELPATH,sheetName));
		 //System.out.println(getUserData.toString());
		 // Iterate over each row of data 
		 for (Map<String, String> row : getUserData)
		 {
		  String Scenario = row.get("Scenario");
		  String batchName = row.get("batchName");
		  String batchDescription = row.get("batchDescription");
		  
		  String batchStatus = row.get("batchStatus");
		  String noOfClasses = row.get("noOfClasses");

		  
		  Logger_Load.info(Scenario);
		  
		  
		  AppHooks.getInstance().getDriver().findElement(batchBtn).click();

		  AppHooks.getInstance().getDriver().findElement(addBatchBtn).click();

		  
		  AppHooks.getInstance().getDriver().findElement(batchNameTxt).sendKeys(batchName);			  
		  AppHooks.getInstance().getDriver().findElement(batchDescriptionTxt).sendKeys(batchDescription);
//		  AppHooks.getInstance().getDriver().findElement(progNameDropDown).click();	
//		  Thread.sleep(5000);
//		  AppHooks.getInstance().getDriver().findElement(progNameSelOption1).click();			  
			AppHooks.getInstance().getDriver().findElement(droparrow).click();
			AppHooks.getInstance().getDriver().findElement(myoption).click();
			Thread.sleep(3000);
			  AppHooks.getInstance().getDriver().findElement(noOfClassesTxt).sendKeys(noOfClasses);

		  if (batchStatus.equals("active"))
			  AppHooks.getInstance().getDriver().findElement(activeradiobutton).click();
		  else
			  AppHooks.getInstance().getDriver().findElement(inactiveRadio).click();
			  
		   
		  

		  AppHooks.getInstance().getDriver().findElement(saveBtn).click();
		  
		  String popMessage = AppHooks.getInstance().getDriver().findElement(popupMessage).getText();
		  Thread.sleep(8000);
		  if(popMessage.contains("Batch Created Successfully"))
		  {
			  validRun++;
			  Logger_Load.info("Batch is created successfully");
			  String BatchCreated = batchName;
			  Logger_Load.info("Batch Name Created: "+BatchCreated );
			  loadWriteConfig("BatchCreated"+validRun+":", BatchCreated);

		  }	  
		  else
			  Logger_Load.error("Batch is not created successfully");
		 }


		 
		
	}

	
}

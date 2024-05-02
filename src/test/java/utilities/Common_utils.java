package utilities;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;




public class Common_utils {

	private static Common_utils commonUtils;
  
	//private constructor-cannot create an object in another class
	private Common_utils() {};

	public static Common_utils getInstance() {
		if(commonUtils==null) {
			commonUtils= new Common_utils();
		}
		return commonUtils;

	}
	private static Common_utils Common_UtilsInstance= null;
	public static List<String> questionsList=new ArrayList<String>();
	//Config file loader
	public void loadProperties() {

		Properties properties=null;
		try {

			if(properties==null) {
				properties = new Properties();

				properties.load(getClass().getResourceAsStream("/config.properties"));
				
				Constants.URL=properties.getProperty("url");
				Constants.BROWSER=	properties.getProperty("browser");
				//Constants.HOMEPAGE=	properties.getProperty("HOMEPAGE_URL");
				//Constants.LOGINPAGE= properties.getProperty("LOGINPAGE_URL");
				Constants.USER= properties.getProperty("user");
			    Constants.PASSWORD= properties.getProperty("password");
			    Constants.EXCELPATH= properties.getProperty("excelpath");
			    Constants.INVALIDURL=properties.getProperty("Invalidurl");
			    Constants.INCORRECTUSERNAME=properties.getProperty("incorrectusername");
			    Constants.INCORRECTPASSWORD=properties.getProperty("incorrectpassword");
			    Constants.DASHBOARDURL=properties.getProperty("DashBoardURL");
			    Constants.DashboardPage = properties.getProperty("dashboardPage");
			    Constants.userPageURL = properties.getProperty("userPageURL");
			    Constants.TableHeaderColumn1 = properties.getProperty("TableHeaderColumn1");
			    Constants.TableHeaderColumn2 = properties.getProperty("TableHeaderColumn2");
			    Constants.TableHeaderColumn3 = properties.getProperty("TableHeaderColumn3");
			    Constants.TableHeaderColumn4 = properties.getProperty("TableHeaderColumn4");
			    Constants.TableHeaderColumn5 = properties.getProperty("TableHeaderColumn5");

				
			}

		} catch (Exception e) {
			e.printStackTrace();

		}


	}

	public static void readExcelFile(String file) throws InvalidFormatException, IOException {



		//Excel file location
		File excelFile= new File(file);
		//creating obj for the workbook		
		XSSFWorkbook workbook= new XSSFWorkbook(excelFile);

		//getting the sheet from the workbook with the index position
		XSSFSheet sheet=workbook.getSheetAt(0);
		//to iterate the rows
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				String value =cellIterator.next().getStringCellValue();
				questionsList.add(value);
			}

		}

	}

}
package stepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static WebDriver driver;
	
	public static void browseConfigChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver ();
	}
	
	public static void openUrl(String url) {
		driver.get(url);
	}
	
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public static void implicityWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public static void refresh() {
		driver.navigate().refresh();
	}
	public static void stop() {
		driver.quit();
	}
	public WebElement locateById(String id) {
		WebElement findElement = driver.findElement(By.id(id));
		return findElement;
	}
	
	public static void textInput(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	public WebElement locateByName(String name) {
		WebElement findElement = driver.findElement(By.name(name));
		return findElement;
	}

	
	public WebElement locateByXPath(String xpath) {
		WebElement findElement = driver.findElement(By.xpath(xpath));
		return findElement;
	}
	
	public static void click(WebElement element) {
		element.click();
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();

	}
	
	public void CurrentURL() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}
	
	
	public String getTheText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
		return text;
	}
	public static void scrollBy() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,600)");

	}
	
	public String getAttribute(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		System.out.println(attribute);
		return attribute;
	}
	
	public static void dndByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	public void dndByVisibleText (WebElement element, String value) {
		Select s = new Select(element);
		
		s.selectByVisibleText(value);
	}
	
	public void dndByValue (WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	public String excelRead(String path, String sheet, int row, int cell) throws IOException {
		String value = null;
		//1. File Path/Location
		File f = new File (path);		
		//2.Get into the File ---> Get the Objects
		FileInputStream fin = new FileInputStream (f);	
		//3.Get the workbook
		Workbook w = new XSSFWorkbook(fin);			
		//4. Get the Sheet
		Sheet s = w.getSheet(sheet);			
		//5. Get the Row 
		Row r = s.getRow(row);		
		//6. Get the Cell
		Cell c = r.getCell(cell);		
		System.out.println(c);
		
		//Getting Cell Type
		int cellType = c.getCellType(); 
		System.out.println(cellType); 
		
		//To check whether cell is string 
		if (cellType==1) {
			//TO get the value from the cell --- string
			value = c.getStringCellValue();
			//Print value
			System.out.println(value);
			
		}
		
		else if (cellType==0) {
			//To check cell is date format
			if (DateUtil.isCellDateFormatted(c)) {
				//to get the value from the cell as date
				Date date = c.getDateCellValue();
				//Date as required format
				SimpleDateFormat sim = new SimpleDateFormat("MM/dd/yyyy");
				//convert the date into string
				String format = sim.format(date);
				//Print date
				System.out.println(format);
				
			} else {
				double d = c.getNumericCellValue();
				//typecast ---> double ----> long
				long l =(long) d;
				// converting long ----> String
				String valueOf = String.valueOf(l);
				//Printing the value
				System.out.println(valueOf);

			}
		}
		return value;
	}
	public void excelWrite(String path, String sheet, int row, int cell, String value) throws IOException {
		        //1. File Path/Location
				File f = new File (path);
				//2.Get into the File ---> Get the Objects
				FileInputStream fin = new FileInputStream (f);
				//3.Get the workbook
				Workbook w = new XSSFWorkbook(fin);
				//creating sheet
				Sheet s = w.getSheet(sheet);
				Row r = s.getRow(row);
				Cell c = r.getCell(cell);
				//setting value for the cell
				c.setCellValue(value);
				//FOut class is important to insert value
				FileOutputStream fout = new FileOutputStream (f);
				w.write(fout);

	}
	
	
	

}

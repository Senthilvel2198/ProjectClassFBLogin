package org.base;


	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.List;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.io.FileUtils;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.opera.OperaDriver;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseCLass {
		
		public static WebDriver driver;
		
		public static void launchchromeDrive() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		public static void launchfireFoxDriver() {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		public static void launchedgeDriver() {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		public static void launchoperaDriver() {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}
		
		public static void launchIEDriver() {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		public static void launchUrl(String url) {
			driver.get(url);
		}
		
		public static void urlTitle() {
			driver.getTitle();
		}
		
		public static void currentLink() {
			driver.getCurrentUrl();
		}
		
		public static void winMax() {
			driver.manage().window().maximize();
		}
		
		public static void findElementXpath(String xpath) {
			driver.findElement(By.xpath(xpath));
		}
		
		public static void findElementId(String ID) {
			driver.findElement(By.id(ID));
		}
		
		public static void findElementTagName(String TGN) {
			driver.findElement(By.tagName(TGN));
		}
		
		public static void findElementName(String Name) {
			driver.findElement(By.name(Name));
		}
		
		public static void passValue(WebElement ele, String value) {
			ele.sendKeys(value);
		}
		
		public static void actionPassValue(WebElement ele,String value) {
			Actions a = new Actions(driver);
			a.sendKeys(ele, value).perform();
		}
		
		public static void Clicking(WebElement ele) {
			ele.click();
		}
		
		public static void waitsImp() {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		public static void rightClick() {
			Actions a = new Actions(driver);
			a.contextClick().perform();
		}
		
		public static void dragDrop(WebElement ele) {
			Actions a = new Actions(driver);
			a.dragAndDrop(ele, ele).perform();
		}
		
		public static void doubleclick(WebElement ele) {
			Actions a = new Actions(driver);
			a.doubleClick(ele).perform();
		}
		
		public static void pressEnter() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		
		public static void capsOn() {
			Actions a = new Actions(driver);
			a.keyDown(Keys.SHIFT).perform();
		}
		
		public static void capsOff() {
			Actions a = new Actions(driver);
			a.keyUp(Keys.SHIFT).perform();
		}
		
		public static void pointElement(WebElement ele) {
			Actions a = new Actions(driver);
			a.moveToElement(ele).perform();
		}
		
		public static void screenShot() throws IOException {
			TakesScreenshot tk = (TakesScreenshot) driver;
			File src = tk.getScreenshotAs(OutputType.FILE);
			File f = new File("C:\\Users\\SenthilVel\\eclipse-workspace\\FrameWorkPracticeMaven\\ScreenShots\\Snap1.jpg");
			FileUtils.copyFile(src, f);
		}
		
		public static void sleep() throws InterruptedException {
			Thread.sleep(2000);
		}
		
		public static void scrollTop(WebElement ele) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true)", ele);
		}
		
		public static void scrollBottom(WebElement ele) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(false)", ele);
		}
		
		public static void highlight(WebElement ele) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 5px solid red;')", ele);
		}
		
		public static void selectTextDD(WebElement ele, String text) {
			Select s = new Select(ele);
			s.selectByValue(text);
			}
		
		public static void selectIndexDD(WebElement ele, int index) {
			Select s = new Select(ele);
			s.selectByIndex(index);
		}
		
		public static void selectValueDD(WebElement ele, String value) {
			Select s = new Select(ele);
			s.selectByValue(value);
		}
		
		public static void deselectValueDD(WebElement ele, String value) {
			Select s = new Select(ele);
			s.deselectByValue(value);
		}
		
		public static void deselectIndexDD(WebElement ele, int index) {
			Select s = new Select(ele);
			s.deselectByIndex(index);
		}
		
		public static void deselectTextDD(WebElement ele, String text) {
			Select s = new Select(ele);
			s.deselectByVisibleText(text);
		}
		
		public static void deselectAllDD(WebElement ele) {
			Select s = new Select(ele);
			s.deselectAll();
		}
		
		public static void selectIsMultiple(WebElement ele) {
			Select s = new Select(ele);
			System.out.println(s.isMultiple());
		}
		
		public static void selectgetOptionsDD(WebElement ele) {
			Select s = new Select(ele);
			List<WebElement> li = s.getOptions();
			for (WebElement x : li) {
				System.out.println(x.getText());
				}
		}
		
		public static void selectgetFirstOptionDD(WebElement ele) {
			Select s = new Select(ele);
			s.getFirstSelectedOption();
		}
		
		public static void alertSwitch() {
			Alert a = driver.switchTo().alert();
		}
		
		public static void printAlert() {
			Alert a = driver.switchTo().alert();
			System.out.println(a.getText());
		}
		
		public static void acceptAlert() {
			Alert a = driver.switchTo().alert();
			a.accept();
		}
		
		public static void dismissAlert() {
			Alert a = driver.switchTo().alert();
			a.dismiss();
		}
		
		public static void promptAccAlert(String value) {
			Alert a = driver.switchTo().alert();
			a.sendKeys(value);
			a.accept();
		}
		
		public static void promptDisAlert(String value) {
			Alert a = driver.switchTo().alert();
			a.sendKeys(value);
			a.dismiss();
		}
		
		
		public static void parentWin() {
			driver.switchTo().defaultContent();
		}
		
		public static void switchWinPosition(int WindowNumber) {
			Set<String> allWindows = driver.getWindowHandles();
			List<String> li = new ArrayList<String>();
			li.addAll(allWindows);
			li.get(WindowNumber);
		}
		
		public static void closeTab() {
			driver.close();
		}
		
		public static void closeBrowser() {
			driver.quit();
		}
		
		public static void createExceldata(int rowNum, int cellNum, String value) throws IOException {

			File f = new File("C:\\Users\\SenthilVel\\eclipse-workspace\\FrameWorkPracticeMaven\\excel\\Soji.xlsx");
			
			
			Workbook w = new XSSFWorkbook();
			
			Sheet sheet = w.createSheet("Senthil");
			
			Row row = sheet.createRow(rowNum);
			
			Cell cell = row.createCell(cellNum);

			cell.setCellValue(value);
			
			FileOutputStream fout = new FileOutputStream(f);
			
			w.write(fout);

		}
		
		public static String getData(int rowNum, int cellNum) throws IOException {
			
			File f = new File("C:\\Users\\SenthilVel\\eclipse-workspace\\BDDFramework\\excel\\CompanyData.xlsx");
			
			FileInputStream fin = new FileInputStream(f);
					
			Workbook w = new XSSFWorkbook(fin);
			
			Sheet sheet = w.getSheet("Data");
			
			Row row = sheet.getRow(rowNum);
			
			Cell cell = row.getCell(cellNum);
			
			int cellType = cell.getCellType();
			
			String value = "";
			
			if (cellType == 1) {
				
				value = cell.getStringCellValue();
				 
			} else if (cellType == 0) {
				
				if (DateUtil.isCellDateFormatted(cell)) {
					
					Date date = cell.getDateCellValue();
					
					SimpleDateFormat sim = new SimpleDateFormat("dd/MMM/yyyy");
					
					value = sim.format(date);
					
				} else {
					
					double d = cell.getNumericCellValue();
					
					long l = (long)d;
					value = String.valueOf(l);
				}
				
			} return value;
			
			
			
		}
		
	}




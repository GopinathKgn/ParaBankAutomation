package com.baseclass;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import org.Pages.Employee;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author K.G.N
 * @see used to maintain all reusable method
 * @Date 26-01-2023
 *
 */
public class BaseClass {
	
	public static WebDriver driver;

	/**
	 * @see maintain screenshot
	 * @return b
	 */
	public byte[] screenShot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] b = screenshot.getScreenshotAs(OutputType.BYTES);
		return b;
	}

	/**
	 * @see maintain DataBaseValue
	 * @return employee
	 */

//	public Employee getDataBaseValue() {
//
//		Employee employee = null;
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String userName = "hr";
//		String password = "Gopiwin.94";
//		Connection connection = null;
//
//		try {
//			// 1.Load the driver
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			// 2.Connect to Database
//			connection = DriverManager.getConnection(url, userName, password);
//			// 3. Write a SQL query
//			String sql = "select * from AdactinHotels where TESTCASE_NO='TC5'";
//			// 4.Prepare the statement
//			PreparedStatement ps = connection.prepareStatement(sql);
//			// 5.Excute the query
//			ResultSet rs = ps.executeQuery();
//			// 6.Iterate the results
//			while (rs.next()) {
//				String testCaseNo = rs.getString("TESTCASE_NO");
//				String name = rs.getString("UserName");
//				String pass = rs.getString("Password");
//				String location = rs.getString("Location");
//				String hotel = rs.getString("Hotels");
//				String roomType = rs.getString("Room_Type");
//				String numberOfRooms = rs.getString("Number_of_Rooms");
//
//				Date checkIn = rs.getDate("Check_In_Date");
//				Date checkOut = rs.getDate("Check_Out_Date");
//				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
//
//				String checkInDate = dateFormat.format(checkIn);
//				String checkOutDate = dateFormat.format(checkOut);
//				String adultsPerRoom = rs.getString("Adults_per_Room");
//				String childrenPerRoom = rs.getString("Children_per_Room");
//				String firstName = rs.getString("First_Name");
//				String lastName = rs.getString("Last_Name");
//				String address = rs.getString("Billing_Address");
//				long creditCardNumber = rs.getLong("Credit_Card_No");
//				String creditCardType = rs.getString("Credit_Card_Type");
//				String creditCardExpiryMonth = rs.getString("Month");
//				String creditCardExpiryYear = rs.getString("Year");
//				int cvvNumber = rs.getInt("CVV_Number");
//
//				System.out.println(testCaseNo);
//				System.out.println(name);
//				System.out.println(pass);
//				System.out.println(location);
//				System.out.println(hotel);
//				System.out.println(roomType);
//				System.out.println(numberOfRooms);
//				System.out.println(checkInDate);
//				System.out.println(checkOutDate);
//				System.out.println(adultsPerRoom);
//				System.out.println(childrenPerRoom);
//				System.out.println(firstName);
//				System.out.println(lastName);
//				System.out.println(address);
//				System.out.println(creditCardNumber);
//				System.out.println(creditCardType);
//				System.out.println(creditCardExpiryMonth);
//				System.out.println(creditCardExpiryYear);
//				System.out.println(cvvNumber);
//
//				employee = new Employee(testCaseNo, name, pass);
//
//			}
//
//		}

//		catch (ClassNotFoundException e) {
//
//			e.printStackTrace();
//		}
//
//		catch (SQLException e) {
//
//			e.printStackTrace();
//		}
//
//		finally {
//
//			// 7.Close the db connection
//			try {
//				connection.close();
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//
//		}
//		return employee;
//	}

	/**
	 * 
	 * @param time
	 * @param unit
	 * @see maintain pageLoadWait
	 */
	public void pageLoadWait(long time, TimeUnit unit) {
		driver.manage().timeouts().pageLoadTimeout(time, unit);
	}

	/**
	 * @see maintain projectpath
	 * @return path
	 */
	public static String getProjctPath() {
		String path = System.getProperty("user.dir");
		return path;

	}

	/**
	 * 
	 * @param key
	 * @return res
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @see maintain propertyFileValue
	 */

	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjctPath() + "\\Config\\Config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}

	/**
	 * 
	 * @param browserType
	 *            see maintain browser
	 */
	public static void getBrowser(String browserType) {

		switch (browserType) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			break;
		}
	}

	/**
	 * 
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws IOException
	 * @see maintain getCellValue
	 */
	public String getCellValue(String sheetName, int rownum, int cellnum) throws IOException {

		String res = "";

		File file = new File("C:\\Users\\K.G.N\\eclipse-workspace\\OMRBranchAutomation\\Excel\\AdactinHotel.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType type = cell.getCellType();

		switch (type) {

		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy;");
				res = dateformat.format(dateCellValue);

			} else {
				double numericCellValue = cell.getNumericCellValue();

				// Ex---> 12.49 = 12 , 12.51=13
				long check = Math.round(numericCellValue);

				if (check == numericCellValue) {

					res = String.valueOf(numericCellValue);

				} else {
					res = String.valueOf(numericCellValue);
				}
			}

			break;

		default:
			break;
		}
		return res;
	}

	// UpdateCell

	/**
	 * 
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @param oldData
	 * @param newData
	 * @throws IOException
	 * @see maintain updateCellValue
	 */

	public void updateCellDate(String sheetName, int rownum, int cellnum, String oldData, String newData)
			throws IOException {

		File file = new File("C:\\Users\\K.G.N\\eclipse-workspace\\FrameWork\\Excel\\AdactinHotel.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();

		if (value.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream fileOutStream = new FileOutputStream(file);
		workbook.write(fileOutStream);
	}

	// WriteCell
	/**
	 * 
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @param data
	 * @throws IOException
	 * @ see maintain Write Cell Value
	 */

	public void writeCellData(String sheetName, int rownum, int cellnum, String data) throws IOException {
		File file = new File("C:\\Users\\K.G.N\\eclipse-workspace\\OMRBranchAutomation\\Excel\\AdactinHotel.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream fileOutStream = new FileOutputStream(file);
		workbook.write(fileOutStream);
	}

	// Methods
	/**
	 * @see maintain getDriver
	 */

	public static void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	/**
	 * @see maintain ApplunUrl
	 * @param url
	 */
	public static void ApplnUrl(String url) {
		driver.get(url);
	}

	/**
	 * @see maintain browserLanch
	 * @param url
	 */
	public static void browserLanch(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
	}

	/**
	 * @see maintain elementSendkeysJs
	 * @param element
	 * @param text
	 */

	public void elementSendkeysJs(WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("aruguments[0].setAttribute('vaue','" + text + "')", element);
	}

	/**
	 * @see maintain click
	 * @param element
	 */
	public void elementClick(WebElement element) {
		element.click();
	}

	/**
	 * @see maintain getApplnTitle
	 * @return title
	 */

	public String getApplnTitle() {
		String title = driver.getTitle();
		return title;
	}

	/**
	 * @see maintain findelementById
	 * @param attributevalue
	 * @return element
	 */
	public WebElement findelementById(String attributevalue) {
		WebElement element = driver.findElement(By.id(attributevalue));
		return element;
	}

	/**
	 * @see maintain findElementByname
	 * @param attributevalue
	 * @return element
	 */

	public WebElement findelementByName(String attributevalue) {

		WebElement element = driver.findElement(By.name(attributevalue));
		return element;
	}

	/**
	 * @see maintain findElemntByClassname
	 * @param attributevalue
	 * @return element
	 */

	public WebElement findelementByClassName(String attributevalue) {
		WebElement element = driver.findElement(By.className(attributevalue));
		return element;
	}

	/**
	 * @see maintain findelementByXpath
	 * @param XpathExp
	 * @return element
	 */
	public WebElement findelementByXpath(String XpathExp) {
		WebElement element = driver.findElement(By.xpath(XpathExp));
		return element;
	}

	/**
	 * @see maintain pageSource
	 * @return pageSource
	 */

	public String pageSource() {
		String pageSource = driver.getPageSource();
		return pageSource;
	}

	/**
	 * @see maintain closeWindow
	 */

	public void closeWindow() {
		driver.close();
	}

	/**
	 * @see maintain quitWindow
	 */

	public static void quitWindow() {
		driver.quit();
	}

	/**
	 * @see maintain elementGetText
	 * @param element
	 * @return text
	 */
	public String elementGetText(WebElement element) {
		String text = element.getText();
		return text;
	}

	/**
	 * @see maintain elementGetAttribute
	 */

	public String elementGetAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	/**
	 * @see maintain elementgetAttribute
	 * @param element
	 * @param Attributename
	 * @return attribute
	 */
	public String elementgetAttribute(WebElement element, String Attributename) {
		String attribute = element.getAttribute(Attributename);
		return attribute;
	}

	/**
	 * @see maintain selectOptionByText
	 * @param element
	 * @param text
	 */

	public void selectOptionByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * @see maintain SelectByAttribute
	 * @param element
	 * @param value
	 */
	public void SelectByAttribute(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * @see maintain selectOptionByindex
	 * @param element
	 * @param index
	 */
	public void selectOptionByindex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * @see maintain maximizeWindow
	 */
	public static void maximizeWindow() {
		driver.manage().window().maximize();

	}

	/**
	 * @see maintain insertValueText
	 * @param element
	 * @param text
	 */

	public void insertValueText(WebElement element, String text) {
		element.sendKeys(text);
	}

	/**
	 * @see maintain alertOk
	 */
	public void alertOk() {
		driver.switchTo().alert().accept();
	}

	/**
	 * @see maintain alertcancel
	 */
	public void alertcancel() {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * @see maintain getText
	 * @param element
	 * @return text
	 */
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	/**
	 * @see maintain getAttribute
	 * @param element
	 * @return attribute
	 */
	public String getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	/**
	 * @see maintain getCssValue
	 * @param element
	 * @param propertyName
	 * @return cssValue
	 */

	public String getCssValue(WebElement element, String propertyName) {
		String cssValue = element.getCssValue(propertyName);
		return cssValue;
	}

	/**
	 * @see maintain getTagName
	 * @param element
	 * @return tagName
	 */

	public String getTagName(WebElement element) {

		String tagName = element.getTagName();
		return tagName;

	}

	/**
	 * @see maintain submit
	 * @param element
	 */

	public void submit(WebElement element) {
		element.submit();
	}

	/**
	 * @see maintain currentUrl
	 * @return currentUrl
	 */
	public String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	/**
	 * @see maintain clickBtnJs
	 */
	public void clickBtnJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}

	/**
	 * @see maintain switchChildWindow
	 * @param name
	 */
	public void switchChildWindow(String name) {
		driver.switchTo().window(name);
	}

	/**
	 * @see maintain switchFrameByIndex
	 * @param index
	 */

	public void switchFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * @see maintain switchFrameById
	 * @param id
	 */
	public void switchFrameById(int id) {
		driver.switchTo().frame(id);
	}

	/**
	 * @see maintain switchFrameElement
	 * @param element
	 */

	public void switchFrameElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * @see maintain getAllOption
	 * @param element
	 * @return options
	 */
	public List<WebElement> getAllOption(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}

	/**
	 * @see maintain getOptionByAttribute
	 * @param element
	 * @param value
	 */
	public void getOptionByAttribute(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * @see maintain getFirstSelect
	 * @param element
	 * @return firstSelectedOption
	 */

	public WebElement getFirstSelect(WebElement element) {
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		return firstSelectedOption;

	}

	/**
	 * @see maintain isMultiple
	 * @param element
	 * @return l
	 */

	public boolean isMultiple(WebElement element) {
		Select select = new Select(element);
		boolean l = select.isMultiple();
		return l;
	}

	/**
	 * @see maintain implicitWait
	 * @param time
	 * @param unit
	 */
	public static void implicitWait(long time, TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(time, unit);
	}

	/**
	 * @see maintain explicitWait
	 * @param TimeOut
	 * @param attributevalue
	 * @return until
	 */
	public WebElement explicitWait(Duration TimeOut, String attributevalue) {
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, TimeOut);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(attributevalue)));
		return until;

	}

	/**
	 * @see maintain fluentWait
	 */

	public void fluentWait() {
		Wait wait = new FluentWait(driver);

	}

	/**
	 * @see maintain threadSleep
	 * @param time
	 * @throws InterruptedException
	 */
	public void threadSleep(int time) throws InterruptedException {
		Thread.sleep(time);
	}

	/**
	 * @see maintain disPlayed
	 * @param attributevalue
	 * @return displayed
	 */
	public boolean disPlayed(String attributevalue) {
		boolean displayed = driver.findElement(By.id(attributevalue)).isDisplayed();
		return displayed;

	}

	/**
	 * @see maintain isEnabled
	 * @param attributevalue
	 * @return enabled
	 */
	public boolean isEnabled(String attributevalue) {
		boolean enabled = driver.findElement(By.id(attributevalue)).isEnabled();
		return enabled;

	}

	/**
	 * @see maintain selectd
	 * @param attributevalue
	 * @return selected
	 */
	public boolean selectd(String attributevalue) {
		boolean selected = driver.findElement(By.id(attributevalue)).isSelected();
		return selected;

	}

	/**
	 * @see maintain deSelectedByIndex
	 * @param element
	 * @param index
	 */

	public void deSelectedByIndex(WebElement element, int index) {

		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	/**
	 * @see maintain deSelectByAttribute
	 * @param element
	 * @param value
	 */

	public void deSelectByAttribute(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);

	}

	/**
	 * @see maintain deSelectByText
	 * @param element
	 * @param text
	 */

	public void deSelectByText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	/**
	 * @see maintain deSelectedAll
	 * @param element
	 */
	public void deSelectedAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	/**
	 * @see maintain getWrappedElement
	 * @param element
	 */
	public void getWrappedElement(WebElement element) {
		Select select = new Select(element);
		select.getWrappedElement();
	}

	/**
	 * @see maintain getParentWindow
	 * @return windowHandle
	 */

	public String getParentWindow() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;

	}

	/**
	 * @see maintain getAllWindow
	 * @return windowHandles
	 */
	public Set<String> getAllWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;

	}

	/**
	 * @see maintain clearText
	 */
	public void clearText(WebElement element) {
		element.clear();

	}

	/**
	 * @see maintain takeScreenshot
	 * @return
	 */
	public File takeScreenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		return s;
	}

	/**
	 * @see maintain screenshotElement
	 * @param element
	 * @return screenshotElement
	 */

	public File screenshotElement(WebElement element) {
		File screenshotElement = element.getScreenshotAs(OutputType.FILE);
		return screenshotElement;
	}

	/**
	 * @see maintain moveOverAction
	 * @param element
	 */

	public void moveOverAction(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	/**
	 * @see maintain pause
	 * @param duration
	 * @return pause
	 */

	public Actions pause(Duration duration) {
		Actions action = new Actions(driver);
		Actions pause = action.pause(duration);
		return pause;

	}

	/**
	 * @see maintain release
	 * @return release
	 */
	public Actions release() {
		Actions action = new Actions(driver);
		Actions release = action.release();
		return release;

	}

	/**
	 * @see maintain tick
	 * @param actions
	 * @return tick
	 */
	public Actions tick(Interaction actions) {
		Actions action = new Actions(driver);
		Actions tick = action.tick(actions);
		return tick;
	}

	/**
	 * @see maintain clickAndHold
	 * @return clickAndHold
	 */
	public Actions clickAndHold() {
		Actions action = new Actions(driver);
		Actions clickAndHold = action.clickAndHold();
		return clickAndHold;

	}

	/**
	 * @see maintain build
	 * @return build
	 */
	public Action build() {
		Actions action = new Actions(driver);
		Action build = action.build();
		return build;

	}

	/**
	 * @see maintain dragAndDrop
	 * @param s
	 * @param d
	 */
	public void dragAndDrop(WebElement s, WebElement d) {
		Actions action = new Actions(driver);
		action.dragAndDrop(s, d).perform();

	}

	/**
	 * @see maintain rightClick
	 * @param element
	 */
	public void rightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * @see maintain doubleClick
	 * @param element
	 */

	public void doubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();

	}

	/**
	 * @see maintain InsertValueText
	 * @param element
	 * @param text
	 */
	public void InsertValueText(WebElement element, String text) {
		element.sendKeys("text", Keys.ENTER);
	}

	/**
	 * @see maintain refresh
	 */
	public void refresh() {
		driver.navigate().refresh();

	}

	/**
	 * @see maintain pageForword
	 */

	public void pageForword() {
		driver.navigate().forward();
	}

	/**
	 * @see maintain pageBackword
	 */

	public void pageBackword() {
		driver.navigate().back();
	}

	/**
	 * @see maintain toUrl
	 * @param url
	 */
	public void toUrl(String url) {
		driver.navigate().to(url);
	}

	/**
	 * @see maintain getClear
	 * @param element
	 */

	public void getClear(WebElement element) {
		element.clear();
	}
}

package com.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	public static JavascriptExecutor jse;
	static Actions action;
	static Select choose;
	static WebDriverWait wait;
	static Alert alert;

	public TestBase() {
		try {
			FileInputStream file = new FileInputStream(
					"C:\\Users\\moses\\eclipse-workspace-july2017\\com.practicemavenproject.qa\\src\\main\\java\\com\\qa\\config\\Environment.properties");
			prop = new Properties();
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initializeDriver() {
		String chromepath = prop.getProperty("Chromepath");
		String firefoxpath = prop.getProperty("Firepath");
		String driverType = prop.getProperty("driverType");
		if (driverType.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromepath);
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver", firefoxpath);
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static void navigateToUrl(String url) {
		driver.navigate().to(prop.getProperty(url));
	}

	public static void getToUrl(String url) {
		driver.get(prop.getProperty(url));
	}

	public static void tearDownAllBrowsers() {
		driver.quit();
	}

	public static void urlImplicitWait(long time, TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(time, unit);
	}

	public WebElement explicitWaitToBeClickable(String xpath) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		return element;
	}

	public WebElement explicitWaitVisibleElementLocated(String xpath) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		return element;
	}

	public WebElement explicitWaitPresenceOfElementLocated(String xpath) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		return element;
	}

	public void urlWindowMaximize() {
		driver.manage().window().maximize();
	}

	public void mouseHoverAction(WebElement element) throws InterruptedException {
		action.moveToElement(element).build().perform();
		Thread.sleep(3000);
	}

	public void mouseHoverClick(WebElement element) throws InterruptedException {
		action.moveToElement(element).click().perform();
		Thread.sleep(2000);
	}

	public void mouseDragAndDropMethodOne(WebElement element1, WebElement element2) {
		action.dragAndDrop(element1, element2).build().perform();

	}

	public void mouseDragAndDropMethodTwo(WebElement element1, WebElement element2) {
		action.clickAndHold(element1).release(element2).build().perform();
	}

	public void mouseDragRelease(WebElement element1, int x, int y) throws InterruptedException {
		action.dragAndDropBy(element1, x, y).perform();
		Thread.sleep(3000);
	}

	public void scrollUpDown(String horizontal, String vertical) {
		jse.executeScript("window.scrollBy('" + horizontal + "','" + vertical + "')");
	}

	public Select selectInstantiation(WebElement element) {
		choose = new Select(element);
		return choose;
	}

	public static void popupSwitch() {
		alert = driver.switchTo().alert();
	}

	public static void popupAccept() {
		popupSwitch();
		alert.accept();
	}

	public void popupDismiss() {
		popupSwitch();
		alert.dismiss();
	}

	public void chooseAndPrintAll(Select obj) {
		List<WebElement> getAllElement = obj.getOptions();
		int size = getAllElement.size();
		for (int i = 0; i < size; i++) {
			String printAllElement = getAllElement.get(i).getText();
			System.out.println(printAllElement);
		}
	}

	public void chooseByValue(String input) {
		System.out.println("Selecting dropdown menu options using value");
		choose.selectByValue(input);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void chooseByText(String textinput) {
		System.out.println("Selecting dropdown menu options using Text");
		choose.selectByVisibleText(textinput);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void chooseByIndex(int i) {
		System.out.println("Selecting dropdown meny options using index");
		choose.selectByIndex(i);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void switchToFrameByIndex(int i) {
		driver.switchTo().frame(i);
	}

	public void switchToFrameByName(String name) {
		driver.switchTo().frame(name);
	}

	public Set getAllWindowHandles() {
		Set<String> getallwindows = driver.getWindowHandles();
		return getallwindows;
	}

	public void switchToWindow(String windowname) {
		driver.switchTo().window(windowname);
	}

}

package com.practicemavenproject.qa;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pagefactory.qa.SixteenPersonalitiesWelcomePage;
import com.qa.testbase.TestBase;

public class SixTeenPersonalitiesWelcomeTest extends TestBase {

	SixteenPersonalitiesWelcomePage spw;

	public SixTeenPersonalitiesWelcomeTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		initializeDriver();
	}

	@Test
	public void gotToUrl_1() {
		driver.navigate().to("https://www.16personalities.com/");
		urlImplicitWait(3000, TimeUnit.MILLISECONDS);
	}
	
	@Test
	public void gotToUrl_2() {
		driver.navigate().to("https://www.16personalities.com/");
		urlImplicitWait(3000, TimeUnit.MILLISECONDS);
	}
	
	@AfterMethod
	public void teardown() {
		tearDownAllBrowsers();
	}
	
}

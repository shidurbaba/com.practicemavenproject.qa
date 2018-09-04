package com.qa.test.util;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.testbase.TestBase;

public class TestUtil extends TestBase {

	public TestUtil() throws IOException {
		super();
	}

	public void drawborder(WebElement element, WebDriver driver) {
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("argument[0].style.border='3px solid red'", element);
	}

}

package com.pagefactory.qa;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.testbase.TestBase;

public class SixteenPersonalitiesWelcomePage extends TestBase {
	
	//PageFactory
	
	public SixteenPersonalitiesWelcomePage() throws IOException {
		super();
	}

	@FindBy(xpath="//div[@class='row']/a[@class='logo']")
	WebElement sixPersonalityLogo;
		
	
}

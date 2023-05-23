package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.Base;

public class GooglePage extends Base{
	
	@FindBy(xpath = "//textarea[@id='APjFqb']")
	WebElement searchBoxXPath;
	
	public GooglePage() {
		
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void enterTextInSearchBox(String text)
	{
		searchBoxXPath.sendKeys(text);
	}

	public GoogleSearchResultsPage clickEnter()
	{
		searchBoxXPath.sendKeys(Keys.ENTER);
		return new GoogleSearchResultsPage();
	}
}

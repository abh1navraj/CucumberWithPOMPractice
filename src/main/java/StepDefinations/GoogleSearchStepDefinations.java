package StepDefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import BasePackage.Base;
import Pages.GooglePage;
import Pages.GoogleSearchResultsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GoogleSearchStepDefinations extends Base {
	static WebDriver driver;

	GooglePage googlePage;
	GoogleSearchResultsPage resultPage;
	
	@Before
	public void openBrowser() {
		Base.openBrowser(prop.getProperty("Browser"));
	}
	 
	@After
	public void tearDown() {
		Base.closeBrowser();
	}
	
	@Given("^User is on Google home page$")
	public void user_open_chrome_browser() {
		googlePage = Base.openUrl(prop.getProperty("Url"));
		
	}
	
	@Then("^verify user is on Google home Page$")
	public void verifyGoogleHomePage()
	{
		String googlePageExpectedTitle ="Google";
	    String googlePageActualTitle = googlePage.getPageTile();
	    Assert.assertEquals(googlePageExpectedTitle, googlePageActualTitle);
	    System.out.println("Verified google home Page");
	}

	

	
	@Then("^user entered \"(.*)\" in the search box$")
	public void user_entered_free_crm_in_the_search_box(String data) {
		googlePage.enterTextInSearchBox(data);
		System.out.println("Entered free CRM in search box");
	}

	@And("^clicked enter$")
	public void clicked_enter() {
		resultPage = googlePage.clickEnter();
		System.out.println("Clicked Enter");
	}

	@Then("^user is navigated to result page$")
	public void user_is_navigated_to_result_page() {
	    String expectedResultPageTitle ="free CRM - Google Search";
	    String actualResultPageTitle = resultPage.getPageTile();
	    Assert.assertEquals(expectedResultPageTitle, actualResultPageTitle);
	    System.out.println("Verified Result Page");
	    

	}
	
	




}

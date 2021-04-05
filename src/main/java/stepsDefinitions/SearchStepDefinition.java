package stepsDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.HomePage;
import cucumber.api.java.en.*;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SearchStepDefinition {

	HomePage homepage;
	WebDriver driver;

	@Given("^I navigate to Home page$")
	public void navigateHomePage() {
		homepage = new HomePage(driver);
		homepage.navigateTo();
	}

	@And("^I enter values \"([^\"]*)\" in search box$")
	public void searchItem(String item) {
		homepage.searchItem(item);
	}

	@When("^I select the item$")
	public void selectItem() {
		homepage.selectItem();
	}

	@Then("^I verify the result value \"([^\\\"]*)\" for item \"([^\"]*)\"$")
	public void verifySearchResult(String result, String item) {
		homepage.verifyResult(result, item);

	}

	@When("^I click on search icon$")
	public void selectSearchSteo() {
		homepage.selectSearch();
	}

	@When("^I verify that an alert is displayed$")
	public void verifySearchAlertStep() {
		homepage.verifySearchAlert();
	}
	
	@Then("^I clear the recent search$")
	public void clearSearchHistorySteps() {
		homepage.clearSearchHistory();
	}


	@Before
	public void startUp() {
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}

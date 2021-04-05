package Pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.DriverUtil;

public class HomePage extends DriverUtil {
	
	@FindBy(css = "input.search-container_term")
	private WebElement searchItem;
	
	@FindBy(css = "span.ui-menu-item_highlight")
	private List <WebElement> searchList;
	
	@FindBy(css = "span.responsive-search-title__count")
	private WebElement resultValue;
	
	@FindBy(css = "span.responsive-search-title__search-term")
	private WebElement itemName;
	
	@FindBy(css = "button.search-container_btn-submit")
	private WebElement searchIcon;
	
	@FindBy(css = "ul.search-container_history_list li")
	private List <WebElement> searchHistoryList;


	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	public HomePage(WebDriver driver) {
	    super(driver);
	    PageFactory.initElements(driver, this);
}
	public void searchItem(String item) {
		searchItem.sendKeys(item);		
		wait.until(ExpectedConditions.visibilityOfAllElements(searchList));
		assertEquals(item,searchList.get(1).getText());
		System.out.println(searchList.get(1).getText());
	}
	
	public void selectItem() {
		searchList.get(1).click();
	}
	
	public void verifyResult(String resultVal, String item) {
		wait.until(ExpectedConditions.visibilityOf(itemName));
		assertEquals(resultVal,resultValue.getText());
		assertEquals(item,itemName.getText());
	}
	
	public void selectSearch() {
		wait.until(ExpectedConditions.visibilityOf(searchIcon));
		searchIcon.click();		
	}
	
	public void verifySearchAlert() {
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();	
	}

	public void clearSearchHistory() {
		wait.until(ExpectedConditions.visibilityOf(searchItem));
		searchItem.click();		
		Boolean flag = false;
		wait.until(ExpectedConditions.visibilityOfAllElements(searchHistoryList));
		for(WebElement element : searchHistoryList) {
			if(element.getText().equalsIgnoreCase("Clear recent searches")) {
				element.click();
				flag = true;
				break;
			}		
		}
		assertTrue(flag);
	}
}
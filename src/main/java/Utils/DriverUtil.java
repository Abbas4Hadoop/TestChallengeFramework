package Utils;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import Pages.HomePage;


public class DriverUtil {
		  protected WebDriver driver;
		 
		  public DriverUtil(WebDriver driver) {
			  this.driver = driver;
		  }
		 
		  public HomePage navigateTo() {
		    driver.navigate().to("https://www.bunnings.com.au/");
		    assertEquals("Bunnings Warehouse | Australia's DIY, Garden & Hardware Store", driver.getTitle());
		    return new HomePage(driver);
		  }
		  

	
}

package classPOM;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homepage {
   static WebDriver driver;	
   static By signupLink = By.partialLinkText("Sign in");
   static By itemTitle = By.partialLinkText("Faded Short Sleeve T-shirts");
	
   public void user_clicks_on_add_to_cart_button() throws InterruptedException {
		homepage.HoverAndClickFirstItem(driver);
		cartSummaryPage.scrollDownPage(driver);
		Thread.sleep(3000);
		cartSummaryPage.addProductToCart(driver);
		Thread.sleep(3);}

	public static void ClickOnSignup(WebDriver driver){
	    driver.findElement(signupLink).click();
	}
	
	public static void HoverAndClickFirstItem(WebDriver driver) throws InterruptedException{
	   Actions actions = new Actions(driver);
	   actions.moveToElement(driver.findElement(itemTitle)).perform();	
	   Thread.sleep(3);
	   System.out.println("- item selected is: " + driver.findElement(itemTitle).getText());
	   driver.findElement(itemTitle).click();
	}

	public static void logIn(WebDriver driver, String email, String username) throws InterruptedException {
		homepage.ClickOnSignup(driver);
		myAccountPage.enterCredentials(driver,email,username); 
		Thread.sleep(4000);
		
	}

	public static void VerifyUserLoggedOff(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,5);
		try{wait.until(ExpectedConditions.elementToBeClickable(signupLink));
		System.out.println("- User is logged out and He cannot access to myaccount page");
		}
		catch(NoSuchElementException nsee){
        System.out.println(nsee.toString());
        }	
	}

	
}

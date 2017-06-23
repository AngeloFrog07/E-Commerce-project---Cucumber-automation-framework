package classPOM;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class myAccountPage {
	
	static By MyAccountLink = By.xpath("//a[@class='account']//span");
	static By emailField = By.id("email");
	static By passwordField = By.name("passwd");
	static By signInButton = By.id("SubmitLogin");
	static By alert= By.xpath("//div[@id='center_column']//li");
	static By signoutLink = By.partialLinkText("Sign out");
	
	public static void pageIdentifer(WebDriver driver){
		
        String pageTitle = driver.getTitle();	
		Assert.assertEquals("My account - My Store", pageTitle);
		
		String currentUrl=driver.getCurrentUrl();
		System.out.println("- User is navigated to:" + driver.getCurrentUrl());			
		String myaccountUrl="http://automationpractice.com/index.php?controller=my-account";
		String myAccountName="Testname Testlastname";
		String currentMyAccountName=driver.findElement(MyAccountLink).getText();
		
		if (currentUrl.equals(myaccountUrl)&& currentMyAccountName.equals(myAccountName)) {
			System.out.println("- The title of the page is:" + pageTitle);
			System.out.println("- Test passed: User is currently on my account page with account name:"+ currentMyAccountName);
		} else {
			System.out.println("Test not passed!!!");
		}
		
	}
	
	public static void enterCredentials(WebDriver driver,String email, String password) throws InterruptedException{
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		try{wait.until(ExpectedConditions.presenceOfElementLocated(emailField));
		driver.findElement(emailField).sendKeys(email);}		
		catch(NoSuchElementException nsee){
        System.out.println(nsee.toString());
        }	
		driver.findElement(passwordField).sendKeys(password);
		Thread.sleep(4000);
		driver.findElement(signInButton).click();
	}
	
	public static String getTextAlert(WebDriver driver) throws InterruptedException{
		Thread.sleep(3000);
		return driver.findElement(alert).getText();
	}
	
	public static void ClickOnSignOut(WebDriver driver) throws InterruptedException{
		driver.findElement(signoutLink).click();
		Thread.sleep(4000);
		}
}

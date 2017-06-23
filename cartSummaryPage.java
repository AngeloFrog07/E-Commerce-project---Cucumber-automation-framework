package classPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class cartSummaryPage {
	
static By AddTocartButton = By.id("add_to_cart");
static By layerCart= By.id("layer_cart");
static By messageContainer= By.xpath("//div[@id='layer_cart']//div[@class='layer_cart_product col-xs-12 col-md-6']//h2");
static By summaryPageMessage = By.xpath("//h1[@id='cart_title']/span[@class='heading-counter']");
static By removeIcon = By.xpath(".//*[@id='cart_quantity_down_1_1_0_0']/span");
static By checkoutButton=By.xpath("//div[@id='layer_cart']//a[contains(@title,'Proceed to checkout')]");
static By proceedBtn= By.xpath("//div[@id='layer_cart']//a[contains(@title,'Proceed to checkout')]");
static By emptyCartMsg = By.xpath("//div[@id='center_column']/p");
static By emptyText = By.xpath("//span[@class='ajax_cart_no_product']");
static By cartQuantity = By.xpath("//h1[@id='cart_title']/span[@class='heading-counter']");
static By checkOutBtn1=By.xpath("//div[@id='center_column']//a[contains(@title,'Proceed to checkout')]");
static By checkOutBtn2=By.xpath("//button[@name='processAddress']");
static By checkOutBtn3=By.xpath("//button[@name='processCarrier']");
static By checkTerms=By.id("cgv");
static By payBtn=By.xpath("//div[@id='HOOK_PAYMENT']//a[@class='cheque']");
static By confirmOrderBtn=By.xpath("//p[@id='cart_navigation']/button");
static By orderCompleteMessage=By.xpath("//div[@id='center_column']/p[1]");
static By currentAlert=By.xpath("//p[@class='fancybox-error']");

public static void scrollDownPage(WebDriver driver) throws InterruptedException {	
		Thread.sleep(3000);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,700)");
		Thread.sleep(3000);
	}

public static void addProductToCart(WebDriver driver) throws InterruptedException{
		driver.findElement(AddTocartButton).click();
		System.out.println("- Product added to the cart");
		Thread.sleep(3000);
	}

public static void layerCartDisplayed(WebDriver driver){
	if (driver.findElement(layerCart).isDisplayed()){
	    assertion(messageContainer,"Product successfully added to your shopping cart", driver);
	}
}

public static void verifyProductInCart(WebDriver driver) throws InterruptedException{	
	layerCartDisplayed(driver);
	Thread.sleep(3);
	clickingOnCheckout(driver);
	Thread.sleep(3);
}

public static void assertion(By ByLocator, String expected, WebDriver driver){
String actualMessage=driver.findElement(ByLocator).getText();
Assert.assertEquals(actualMessage, expected);
System.out.println("Message displayed: " + actualMessage);
}

public static void shoppingCartProductCounter(WebDriver driver) throws InterruptedException{
	assertion(summaryPageMessage,"Your shopping cart contains: 1 Product",driver);
	Thread.sleep(3000);
}

public static void removeProduct(WebDriver driver) throws InterruptedException{
    driver.findElement(removeIcon).click();
	System.out.println("- Product is being removed");
	Thread.sleep(3000);
}

public static void clickingOnCheckout(WebDriver driver){
	WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(proceedBtn));
	driver.findElement(checkoutButton).click();
}

public static void getMessageEmptyBasket(WebDriver driver) throws InterruptedException{
	assertion(emptyCartMsg,"Your shopping cart is empty.", driver);
	Thread.sleep(3000);
}

public static void emptyCartAssertion(WebDriver driver){
	assertion(emptyText,"(empty)", driver);
	System.out.println("- Cart basket is now empty");
}

public static void shoppingCartCounter(WebDriver driver){
	assertion(cartQuantity,"Your shopping cart contains: 1 Product",driver);	
}

public static void progressFromSummary(WebDriver driver) throws InterruptedException{
	driver.findElement(checkOutBtn1).click();
	System.out.println("- 01 - Checkout/summary page checked");
	Thread.sleep(3000);
	
}
public static void progressFromAddress(WebDriver driver) throws InterruptedException{
	scrollDownPage(driver);
	Thread.sleep(3000);
	driver.findElement(checkOutBtn2).click();
	System.out.println("- 02 - Checkout/address page checked");
	Thread.sleep(3000);
}

public static void checkTerms(WebDriver driver) throws InterruptedException{
	driver.findElement(checkTerms).click();
	Thread.sleep(3000);
}

public static void progressFromShipping(WebDriver driver) throws InterruptedException{
	scrollDownPage(driver);
	driver.findElement(checkOutBtn3).click();
	System.out.println("- 03 - Checkout/shipping page checked");
	Thread.sleep(3000);
}
public static void progressFromPayment(WebDriver driver) throws InterruptedException{
	scrollDownPage(driver);
	driver.findElement(payBtn).click();
	System.out.println("- 04 - payment in progress checked");
}
public static void orderConfirmation(WebDriver driver) throws InterruptedException{
	scrollDownPage(driver);
	driver.findElement(confirmOrderBtn).click();
	Thread.sleep(3000);
	assertion(orderCompleteMessage,"Your order on My Store is complete.",driver);
	System.out.println("- Transaction has gone through successfully ");
	
}
public static void proceedToCheckout(WebDriver driver) throws InterruptedException {
	cartSummaryPage.proceedToAddress(driver);
	cartSummaryPage.checkTerms(driver);
	cartSummaryPage.scrollDownPage(driver);
	cartSummaryPage.progressFromShipping(driver);	
}

public static void proceedToAddress(WebDriver driver) throws InterruptedException{
	cartSummaryPage.clickingOnCheckout(driver);
	Thread.sleep(3000);
	cartSummaryPage.scrollDownPage(driver);
	Thread.sleep(10000);
	cartSummaryPage.progressFromSummary(driver);
	cartSummaryPage.progressFromAddress(driver);
}

public static void addItemToCart(WebDriver driver) throws InterruptedException {
	homepage.HoverAndClickFirstItem(driver);
	cartSummaryPage.scrollDownPage(driver);
	cartSummaryPage.addProductToCart(driver);
	Thread.sleep(3000);
	
}

public static void termsMessageDisplayed(WebDriver driver) throws InterruptedException { 
	Thread.sleep(10000);
	assertion(currentAlert,"You must agree to the terms of service before continuing.",driver);		
}
}

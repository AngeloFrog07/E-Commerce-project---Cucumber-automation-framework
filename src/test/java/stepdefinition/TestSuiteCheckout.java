package stepdefinition;

import java.io.IOException;
import classPOM.cartSummaryPage;
import classPOM.homepage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSuiteCheckout extends  testbaseConfig{

@Given("^User is logged$")
public void user_is_logged() throws Exception{	
	homepage.logIn(driver,"testangelo@email.com","test123");	
	driver.navigate().to("http://automationpractice.com/index.php");
}

@Given("^User added an item to my shopping basket$")
public void user_added_an_item_to_my_shopping_basket() throws InterruptedException, IOException{
	cartSummaryPage.addItemToCart(driver);
}

@When("^User proceeds to checkout$")
public void user_proceeds_to_checkout() throws InterruptedException {
	cartSummaryPage.proceedToCheckout(driver);
}

@Then("^User should be able to make a payment$")
public void user_should_be_able_to_make_a_payment() throws InterruptedException {
	cartSummaryPage.progressFromPayment(driver);
}

@Then("^The transaction should be successful$")
public void the_transaction_should_be_successful() throws InterruptedException{	
	cartSummaryPage.orderConfirmation(driver);
}

@Given("^User added a product to my shopping basket$")
public void user_added_a_product_to_my_shopping_basket() throws Exception{
	user_is_logged();
	user_added_an_item_to_my_shopping_basket();
}

@When("^User proceeded with the checkout$")
public void user_proceeded_with_the_checkout() throws InterruptedException{
	cartSummaryPage.proceedToAddress(driver);	
}

@When("^User doesn't check terms$")
public void user_doesn_t_check_terms() throws InterruptedException {
	cartSummaryPage.progressFromShipping(driver);
	}

@Then("^User should receive a warning message$")
public void user_should_receive_a_warning_message() throws InterruptedException{		
	cartSummaryPage.termsMessageDisplayed(driver);
	System.out.println("- Test suite passed!!!");  
}

}

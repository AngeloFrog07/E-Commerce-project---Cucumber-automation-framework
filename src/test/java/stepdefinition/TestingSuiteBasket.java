package stepdefinition;

import classPOM.cartSummaryPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestingSuiteBasket extends  testbaseConfig {

@Given("^User is on home page$")
public void user_is_on_home_page() throws Exception{
	cartSummaryPage.scrollDownPage(driver);
}

@When("^User clicks on add to cart button$")
 public void user_clicks_on_add_to_cart_button()throws InterruptedException {			
	cartSummaryPage.addItemToCart(driver);
}

@Then("^User should see the product added to cart basket$")
public void user_should_see_the_product_added_to_cart_basket() throws InterruptedException {
	cartSummaryPage.verifyProductInCart(driver);
}

@Then("^User should see correct product details in the shopping cart summary page$")
public void user_should_see_correct_product_details_in_the_shopping_cart_summary_page() throws InterruptedException{
	cartSummaryPage.shoppingCartProductCounter(driver);
}

@Given("^User added an item to my shopping bag$")
public void user_added_an_item_to_my_shopping_bag() throws Exception {   
	user_is_on_home_page();
	user_clicks_on_add_to_cart_button();
	user_should_see_the_product_added_to_cart_basket();	
	cartSummaryPage.shoppingCartCounter(driver);
}

@When("^User clicks on remove icon on cart button$")
public void user_clicks_on_remove_icon_on_cart_button() throws InterruptedException{
	cartSummaryPage.removeProduct(driver);
}

@Then("^User should see the product removed to cart basket$")
public void user_should_see_the_product_removed_to_cart_basket() throws InterruptedException{
	cartSummaryPage.getMessageEmptyBasket(driver);
}

@Then("^the shopping cart should be empty$")
public void the_shopping_cart_should_be_empty() {
	cartSummaryPage.emptyCartAssertion(driver);
	System.out.println("- Test suite passed!!!");
}
 
}



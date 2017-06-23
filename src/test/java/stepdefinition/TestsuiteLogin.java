package stepdefinition;

import classPOM.homepage;
import classPOM.myAccountPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestsuiteLogin extends  testbaseConfig{
	//static private WebDriver driver;
	
@Given("^user is on the homepage$")
public void user_is_on_the_homepage() throws Exception{		
		System.out.println("Starting login");
	}
	
/* @When("^User enters valid email as \"([^\"]*)\" and password as \"([^\"]*)\"$")
public void user_enters_valid_and(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}*/
@When("^User enters valid email and password$")
public void User_enters_valid_email_and_password() throws InterruptedException{	
		homepage.logIn(driver,"testangelo@email.com","test123");
	}

@Then("^User can	visit the account page$")
public void User_can_visit_the_account_page(){
		myAccountPage.pageIdentifer(driver); 
		}
				
@When("User enters an invalid email$")
public void user_enters_an_invalid_email() throws InterruptedException{
		homepage.logIn(driver,"12345","test123");
		System.out.println("- Invalid email input");
	}
	
@Then("^Invalid email Message is displayed$")
public void invalid_email_Message_is_displayed() throws InterruptedException{
	System.out.println("Alert Message displayed:"+ myAccountPage.getTextAlert(driver));
	}

@When("^User enters an invalid password$")
public void user_enters_an_invalid_password() throws InterruptedException {
		homepage.logIn(driver,"testangelo@email.com","123");
		System.out.println("- Invalid password input");
	}
	
@Then("^Invalid password Message is displayed$")
public void invalid_password_Message_is_displayed() throws InterruptedException{
		System.out.println("Alert Message displayed:"+myAccountPage.getTextAlert(driver));
	}
}

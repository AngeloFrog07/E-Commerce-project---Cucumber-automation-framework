package stepdefinition;

import classPOM.homepage;
import classPOM.myAccountPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSuiteLogout extends testbaseConfig {
	
@Given("^User logged in$")
public void user_logged_in() throws Exception {		
	    homepage.logIn(driver,"testangelo@email.com","test123");
	}

@When("^User LogOut from main page$")
public void User_LogOut_from_main_page() throws InterruptedException {
		myAccountPage.ClickOnSignOut(driver);
	}

@Then("^User cannot visit myaccount page$")
public void User_cannot_visit_myaccount_page(){
		homepage.VerifyUserLoggedOff(driver);	
	}
}
	

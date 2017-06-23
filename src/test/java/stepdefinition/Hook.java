package stepdefinition;

import java.io.IOException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {	
/*
	@Before("@Chrome")
	public void launchChrome() throws IOException{
		System.out.println("Starting new scenario... ");
		testbaseConfig.Initialize("chrome");	
	}
	
	@Before("@Firefox")
	public void launchFirefox() throws IOException{
		System.out.println("Starting new scenario... ");
		testbaseConfig.Initialize("firefox");	
	}	
*/
	
	@Before
	//("@smoke")
	public void set() throws IOException{
		System.out.println("Starting new scenario... ");
		testbaseConfig.Initialize("chrome");	
	}
	
    @After
    //("@smoke")
	public void TearDown(Scenario testScenario) throws Exception{		
		testbaseConfig.testResult(testScenario);
		testbaseConfig.Close();
		}
		
}

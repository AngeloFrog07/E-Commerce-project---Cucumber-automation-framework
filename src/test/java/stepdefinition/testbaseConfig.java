package stepdefinition;


import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import classPOM.browsers;
import cucumber.api.Scenario;


public class testbaseConfig{
	static WebDriver driver;
	public static String baseURL = "http://automationpractice.com/index.php";
	
	public static void Initialize(String browserName) throws IOException{   
		driver = browsers.getInstance(browserName);
		driver.manage().window().maximize();
		driver.get(baseURL);
		System.out.println("User is on the home page");
	}	
	
	public static void testResult(Scenario scenario) throws Exception{			
	if(scenario.isFailed()){
		getscreenshot(scenario.getName());
		System.out.println("Scenario failed");}
	else
		{System.out.println(scenario.getName()+ " :completed successfully");}
	}
	
	public static void getscreenshot(String name) throws Exception {		
	    String fileName = name + ".png";
		String directory = "C:\\Users\\Angelo\\Desktop\\";
		File scrFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with name fileName.png
		FileUtils.copyFile(scrFile, new File(directory + fileName));
	}
	
	public static void Close(){
		driver.close();
	}
	
	public static void Quit(){
		driver.quit();
	}
	
}

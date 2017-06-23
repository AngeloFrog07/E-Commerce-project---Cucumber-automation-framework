package classPOM;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

public class browsers {

	public static WebDriver getInstance(String browser_name)throws IOException {
	WebDriver driver=null;
	  
    switch (browser_name) {
        case "firefox":
        	System.out.println("in firefox");
            driver = new FirefoxDriver();
            break;
        case "chrome":
        	System.out.println("in chrome");
    	    System.setProperty("webdriver.chrome.driver", new File("./src/test/resources/drivers/chromedriver.exe").getCanonicalPath());
    	    driver = new ChromeDriver();
            break;
        /*case "ie":
        	System.out.println("in IE");
    	    System.setProperty("webdriver.ie.driver", "C:\\Users\\Angelo\\Desktop\\eclipse projects\\drivers\\IEDriverServer.exe");
	        WebDriver driver= new InternetExplorerDriver();
            break;*/     
    }   
  return driver;
}
}

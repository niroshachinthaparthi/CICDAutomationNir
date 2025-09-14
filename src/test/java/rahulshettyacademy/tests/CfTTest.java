package rahulshettyacademy.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class CfTTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test cicd update --2
		
		WebDriverManager.chromedriver().setup();  // no hardcoded version
		WebDriver driver = new ChromeDriver();
		
		//WebDriverManager.chromedriver().driverVersion("114.0.5735.199").setup();

       // ChromeOptions options = new ChromeOptions();
       // options.addArguments("--remote-debugging-port=0"); // prevent WebSocket issues

        //WebDriver driver = new ChromeDriver(options);

	        driver.get("https://www.google.com");
	        System.out.println("Title: " + driver.getTitle());
	        driver.quit();

	}

}

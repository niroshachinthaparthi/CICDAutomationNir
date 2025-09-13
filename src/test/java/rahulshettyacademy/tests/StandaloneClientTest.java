package rahulshettyacademy.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.PageObjects.CartPage;
import rahulshettyacademy.PageObjects.ConfirmationPage;
import rahulshettyacademy.PageObjects.LandingPage;
import rahulshettyacademy.PageObjects.OrdersPage;
import rahulshettyacademy.PageObjects.PaymentPage;
import rahulshettyacademy.PageObjects.ProductCatlogue;
import rahulshettyacademy.TestComponents.BaseTest;



public class StandaloneClientTest extends BaseTest {
	String prodName= "ZARA COAT 3";

	
	@Test(dataProvider="getdata", groups= {"purchase"})
	public void submitOrder(HashMap<String,String> Input) throws InterruptedException, IOException {
		
		//String prodName= "ZARA COAT 3";
		//launchApp();
		ProductCatlogue pc=lp.Landingapp(Input.get("email"), Input.get("pwd"));
		//Thread.sleep(1000);
		List<WebElement> products= pc.getProdList();
		pc.prodByName(Input.get("product"));
		pc.addProdToCart(Input.get("product"));
		//pc.goToCart();

		CartPage cp=pc.goToCart();
		Boolean b=cp.verifyCartItem(Input.get("product"));
		Assert.assertTrue(b);
		//cp.checkout();
		
		PaymentPage pp = cp.checkout();
		pp.selecCountry("India");
		//pp.submitOrder();
		
		ConfirmationPage conpage= pp.submitOrder();
		String Confirmmsg = conpage.getConfirmMesg();
		System.out.println(Confirmmsg);
		Assert.assertTrue(Confirmmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
		
	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void orderHistory() {
		ProductCatlogue pc=lp.Landingapp("nishac@gmail.com", "Nisha123");
		 OrdersPage op=	pc.goToOrders();
		 Boolean match=op.verifyOrderItem(prodName);
			Assert.assertTrue(match);	
	}
	

	
	@DataProvider
	public Object[][] getdata() throws IOException {
		/*HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("email", "nishac@gmail.com");
		map1.put("pwd", "Nisha123");
		map1.put("product", "ZARA COAT 3");
		
		HashMap<String,String> map2 = new HashMap<String,String>();
		map2.put("email", "nishac@gmail.com");
		map2.put("pwd", "Nisha123");
		map2.put("product", "IPHONE 13 PRO");*/
		
		List<HashMap<String,String>> data =getJsonDataToMap("E:\\javaPractice\\SeleniumFrameworkDesign\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}

	
}

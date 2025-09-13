package rahulshettyacademy.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.PageObjects.CartPage;
import rahulshettyacademy.PageObjects.ConfirmationPage;
import rahulshettyacademy.PageObjects.LandingPage;
import rahulshettyacademy.PageObjects.PaymentPage;
import rahulshettyacademy.PageObjects.ProductCatlogue;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.RetryTest;

public class ErrorValidationsTest extends BaseTest {

	
	@Test(groups= {"ErrorHandling"}, retryAnalyzer=RetryTest.class)
	public void submitOrder() throws InterruptedException, IOException {
		
		
		lp.Landingapp("abc@gmail.com", "Nisha123");//wrong email id
		System.out.println(lp.geterrormsg());
		Assert.assertEquals("Incorrect email or password.",lp.geterrormsg() );//removed . to get error
	}
	
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{

		String prodName = "IPHONE 13 PRO";
		ProductCatlogue pc = lp.Landingapp("nishac@gmail.com", "Nisha123");
		List<WebElement> products= pc.getProdList();
		pc.prodByName(prodName);
		pc.addProdToCart(prodName);
		//pc.goToCart();

		CartPage cp=pc.goToCart();
		Boolean b=cp.verifyCartItem(prodName);
		Assert.assertTrue(b);// kept assertFalse to get error
	}
	
}

package AbstractComponents;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.PageObjects.CartPage;
import rahulshettyacademy.PageObjects.OrdersPage;

public class AbstractComp {
	WebDriver driver;
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orders;
	
	public AbstractComp(WebDriver driver) {
	this.driver=driver;
	}


	public void waitToAppear(By findBy) throws InterruptedException {
		
		//Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
 public void waitToDisappear(WebElement ele) {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
 }
 
 public CartPage goToCart() {
		cart.click();
		CartPage cp=new CartPage(driver);
		return cp;
	}
 
 public OrdersPage goToOrders() {
	 orders.click();
	 OrdersPage op = new OrdersPage(driver);
	 return op;
 }
}

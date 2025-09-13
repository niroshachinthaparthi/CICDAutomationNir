package rahulshettyacademy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComp;

public class CartPage extends AbstractComp {
	
	WebDriver driver;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartitem;
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifyCartItem(String ProdName) {
	Boolean b=cartitem.stream().anyMatch(s->s.getText().equals(ProdName));
	return b;
	}
	
	public PaymentPage checkout() {
		checkout.click();
		PaymentPage pp = new PaymentPage(driver);
		return pp;
	}

	

}

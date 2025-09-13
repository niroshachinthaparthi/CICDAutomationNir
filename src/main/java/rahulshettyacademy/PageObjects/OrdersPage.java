package rahulshettyacademy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComp;

public class OrdersPage extends AbstractComp {
	
	WebDriver driver;
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productName;
	
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifyOrderItem(String ProdName) {
	Boolean b=productName.stream().anyMatch(s->s.getText().equals(ProdName));
	return b;
	}
	
	

	

}

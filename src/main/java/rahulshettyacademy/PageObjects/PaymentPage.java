package rahulshettyacademy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractComponents.AbstractComp;

public class PaymentPage extends AbstractComp {
 WebDriver driver;
	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(css="input[placeholder='Select Country']")
WebElement country;

By results = By.className("ta-results");

@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")

WebElement selectedCountry;

@FindBy(css=".action__submit")
WebElement placeOrder;

public void selecCountry(String countryName ) throws InterruptedException {
	Actions a = new Actions(driver);
	a.sendKeys(country, countryName).build().perform();
	waitToAppear(results);
	selectedCountry.click();
	
}
public ConfirmationPage submitOrder() {
	placeOrder.click();
	
	ConfirmationPage conpage=new ConfirmationPage(driver);
	return conpage;
}
}

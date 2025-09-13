package rahulshettyacademy.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComp;

public class ConfirmationPage  extends AbstractComp {
	
	WebDriver driver;
	 public ConfirmationPage(WebDriver driver) {
		super(driver);

			this.driver=driver;
			PageFactory.initElements(driver, this);
		}

	 @FindBy(className="hero-primary")
	 WebElement Confirmmsg;
	 
	 public String getConfirmMesg() {
		 
		return Confirmmsg.getText();
		 
	 }
}

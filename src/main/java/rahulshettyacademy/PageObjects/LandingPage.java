package rahulshettyacademy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComp;

public class LandingPage extends AbstractComp {
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	
//initializing
	
	//driver.findElement(By.id("userEmail")).sendKeys("nishac@gmail.com");
	@FindBy(id="userEmail")
	WebElement email;
	//driver.findElement(By.id("userPassword")).sendKeys("Nisha123");
	@FindBy(id="userPassword")
	WebElement password;
	//driver.findElement(By.id("login")).click();
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errormsg;

//actions

public ProductCatlogue Landingapp(String mail, String pwd) {
	email.sendKeys(mail);
	password.sendKeys(pwd);
	login.click();
	ProductCatlogue pc=new ProductCatlogue(driver);
	return pc;
}
public String geterrormsg() {
	waitForWebElementToAppear(errormsg);
	 return errormsg.getText();
}
public void goTo() {
	driver.get("https://rahulshettyacademy.com/client/#/auth/login");
}
}

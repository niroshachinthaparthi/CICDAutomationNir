package rahulshettyacademy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComp;

public class ProductCatlogue extends AbstractComp {
	WebDriver driver;
	
	public ProductCatlogue(WebDriver driver) {
		super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;

	
	
	By productsby=  By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toast =By.cssSelector("#toast-container");
	
	public List<WebElement> getProdList() throws InterruptedException {
		waitToAppear(productsby);
		return products;
				
	}
	
	//WebElement prod = products.stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
	
	/*public WebElement prodByName(String prodName) throws InterruptedException {
		
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.xpath(".//div[@class='card-body']/h5/b")).getText().equals(prodName)).findFirst()
				.orElse(null);
	return prod;	
	}
	
	public void addProdToCart(String prodName) throws InterruptedException {
		WebElement prod=prodByName(prodName);
		prod.findElement(productsby).click();
		waitToAppear(toast);
		waitToDisappear(spinner);
		
		
	}
	
	

}*/

	public WebElement prodByName(String prodName) throws InterruptedException {
	    waitToDisappear(spinner);
	    return products.stream()
	        .filter(product -> {
	            String name = product
	                .findElement(By.xpath(".//div[@class='card-body']/h5/b"))
	         
	                .getText();
	            return name.equals(prodName);
	        })
	        .findFirst()
	        .orElse(null);
	}

	public void addProdToCart(String prodName) throws InterruptedException {
	    waitToAppear(productsby);
	    waitToDisappear(spinner);

	    WebElement prod = prodByName(prodName);
	    if (prod == null) {
	        throw new NoSuchElementException("Product not found: " + prodName);
	    }
	    prod.findElement(addToCart).click();

	    waitToAppear(toast);
	    waitToDisappear(spinner);
	    }
	}

package saucelab1;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemo {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		
		
		// 2.Validate whether username and password field are editable.
		
		      WebElement d=driver.findElement(By.xpath("//input[@id='user-name']"));
		  d.sendKeys("A",Keys.BACK_SPACE);
		  if(d.isDisplayed()==true) {
			  System.out.println("It is Editable");
		  }
		  else {
			  System.out.println("It is not Editable");
		  }
		  
		  
		// 3. Validate  the page title
		   String actualTitle = "Swag Labs";
		  
		   String ExpectedTitle = driver.getTitle();
		   if(actualTitle.equals(ExpectedTitle)) {
			   System.out.println("Page Title validation is true");
		   }
		   else
			   System.out.println("Page Title validation is false");
		   
		   
		 
		  
		 
		// 4. Get the UserName and Password details from the page and login.				
		
	
		
	// driver.findElement(By.xpath("//h4[text()='Accepted usernames are:']/following-sibling::text()")).getText();
		String un = driver.findElement(By.xpath("//div[@id='login_credentials']")).getText().substring(24, 38);
		 System.out.println(un);
		 
		 String pwd =  driver.findElement(By.xpath("//div[@class='login_password']")).getText().substring(23, 36);
		 System.out.println(pwd);
		 
		 driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(un, Keys.TAB, pwd, Keys.ENTER);
		
		 
		 
		// 6. Validate shot drop down is displayed.
		 
		  WebElement dropDownDisplay = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		    dropDownDisplay.click();
		     boolean verifydropDown = dropDownDisplay.isDisplayed();
		 
		 if(verifydropDown==true) {
			 System.out.println("DropDown is appering ");
		 }
		 else
			 System.out.println("DropDown is not appering ");
		 
		 
		 // Validate  whether the products are displayed according to ascending order name by default. 
		 
		  List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
		 List<String> actual_item = new  LinkedList<String>();
		  
		  for(WebElement eachProduct: products) {
			  actual_item.add(eachProduct.getText());
		  }
		  
		  Object[] ary= actual_item.toArray();
		  for(Object obj : ary) {
			  System.out.println(obj);
		  }
		  
		  List expectedItems = new LinkedList<String>();
		  expectedItems.addAll(actual_item);
		  Collections.sort(expectedItems);
		  System.out.println(expectedItems);
		  
		  Assert.assertEquals(expectedItems, actual_item);
		  System.out.println("Items are assending Orders."); 
		  
		  
		  
		 
		 
				 
		 
		 driver.close();		 
	}

}

package general_Store;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.helper_Base;
import Rajasekar_Learning.Appium.App_Launcher_And_Configurator;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.functions.ExpectedCondition;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class operations extends App_Launcher_And_Configurator{

	
	//Filling up of first page of Application Name, country and Sex
	//@Test
	public void filling_The_Form() throws InterruptedException, NoSuchElementException {
		helper_Base.id_click("com.androidsample.generalstore:id/spinnerCountry");
		//helper_Base.x_click("//android.widget.TextView[@text='Afganistan']");
		helper_Base.g_Scroll("India");
		helper_Base.x_click("//android.widget.TextView[@text='India']");
		helper_Base.id_pass_Text("com.androidsample.generalstore:id/nameField", "India");
		driver.hideKeyboard();
		helper_Base.x_click("//android.widget.Button[@class='android.widget.Button']");
	}
	
	// To validate error message in the first page
	//@Test (priority = 0)
	public void validate_Toast_Message_for_Name() throws InterruptedException, NoSuchElementException {
		helper_Base.id_click("com.androidsample.generalstore:id/spinnerCountry");
		helper_Base.g_Scroll("India");
		helper_Base.x_click("//android.widget.TextView[@text='India']");
		driver.hideKeyboard();
		helper_Base.x_click("//android.widget.Button[@class='android.widget.Button']");
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("text"), "Please enter your name");
	}
	
	//@Test (priority=1)
	public void add_to_cart() throws InterruptedException, NoSuchElementException {
		helper_Base.id_click("com.androidsample.generalstore:id/spinnerCountry");
		helper_Base.g_Scroll("Afghanistan");
		helper_Base.x_click("//android.widget.TextView[@text='Afghanistan']");
		helper_Base.id_pass_Text("com.androidsample.generalstore:id/nameField", "India");
		driver.hideKeyboard();
		helper_Base.x_click("//android.widget.Button[@class='android.widget.Button']");
	    helper_Base.g_Scroll("Jordan Lift Off");
	    
	    int sizo = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
	    for(int i=0;i<sizo;i++) {
	    //	System.out.println("*****************************");
	    	String text = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
	    	//System.out.println(text);
	    	if(text.equalsIgnoreCase("Jordan Lift Off")) {
	    		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
	    		Thread.sleep(3000);	
	    		
	    		Assert.assertEquals(driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).getText(), "ADDED TO CART");
	    		Assert.assertEquals(driver.findElement(By.id("com.androidsample.generalstore:id/counterText")).getText(), "1");
	    		//System.out.println("*****************************");
	    	}
	    	
	   
	    }
	    	
	    helper_Base.id_click("com.androidsample.generalstore:id/appbar_btn_cart");
	    WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wt.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
	    System.out.println("The product has been sucessfully added");
	    Thread.sleep(5000);
	}
	
	
	@Test (priority =1)
	public void validate_The_Items_In_Cart_Equal_To_Summation() throws InterruptedException, NoSuchElementException {
		helper_Base.id_click("com.androidsample.generalstore:id/spinnerCountry");
		helper_Base.g_Scroll("Afghanistan");
		helper_Base.x_click("//android.widget.TextView[@text='Afghanistan']");
		helper_Base.id_pass_Text("com.androidsample.generalstore:id/nameField", "India");
		driver.hideKeyboard();
		helper_Base.x_click("//android.widget.Button[@class='android.widget.Button']");
	    helper_Base.g_Scroll("Jordan Lift Off");
	    
	    int sizo = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
	    float sum=0.0f;
	    for(int i=0;i<sizo;i++) {
	    	String text = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
	    	System.out.println(text);
	    		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
	    		sum=Float.valueOf(driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText().replace("$", ""))+sum;
	    		Thread.sleep(3000);	
	    		Assert.assertEquals(driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).getText(), "ADDED TO CART");
	         
	    }
	    //	System.out.println(sum);
	    Assert.assertEquals(driver.findElement(By.id("com.androidsample.generalstore:id/counterText")).getText(), String.valueOf(sizo));
	    helper_Base.id_click("com.androidsample.generalstore:id/appbar_btn_cart");
	    WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wt.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
	    System.out.println("The product has been sucessfully added");
	    
	   Assert.assertEquals(Float.valueOf(driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().replace("$","")),sum,"The Total Sum is displayed properly");
	   Thread.sleep(5000);
	}
	    
	@Test (priority =2)
	public void validate_Terms_And_Condition() throws IOException, InterruptedException {
		helper_Base.long_Press(driver.findElement(By.xpath("//android.widget.TextView[@text='Please read our terms of conditions']")), 5000);
		Assert.assertEquals(helper_Base.property_file_Reader("cart_page_Tc"), driver.findElement(By.id("android:id/message")).getText());
		helper_Base.x_click("//android.widget.Button[@text='CLOSE']");
		helper_Base.x_click("//android.widget.CheckBox[@class='android.widget.CheckBox']");
		helper_Base.x_click("//android.widget.Button[@text='Visit to the website to complete purchase']");
		Thread.sleep(6000);
	}
	@Test (priority =3)
	public void rendering_handling() {
		
		Set<String> l1 = driver.getContextHandles();
		for(String c1:l1) {
			System.out.println(c1);
			if(c1.equalsIgnoreCase("WEBVIEW_com.androidsample.generalstore")) {
				System.out.println("************************");
				driver.context(c1);
			}
		}
		driver.findElement(By.xpath("//android.widget.EditText[@class='android.widget.EditText']")).sendKeys("How to loose Belly fat");
		driver.findElement(By.xpath("//android.widget.EditText[@class='android.widget.EditText']")).sendKeys(Keys.ENTER);
		// now to switch back to Android or Native_App
		helper_Base.back();
		driver.context("NATIVE_APP");
		
	}
	
//	@Test
	public void browser_Capabilities() {
		Set<String> l1 = driver.getContextHandles();
		for(String c1:l1) {
			System.out.println(c1);
			if(c1.equalsIgnoreCase("WEBVIEW_com.androidsample.generalstore")) {
				System.out.println("************************");
				driver.context(c1);
			}
		}
		driver.findElement(By.xpath("//android.widget.EditText[@class='android.widget.EditText']")).sendKeys("How to loose Belly fat");
		driver.findElement(By.xpath("//android.widget.EditText[@class='android.widget.EditText']")).sendKeys(Keys.ENTER);
	}
	
	

}

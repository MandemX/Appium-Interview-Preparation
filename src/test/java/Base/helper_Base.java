package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import Rajasekar_Learning.Appium.App_Launcher_And_Configurator;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class helper_Base extends App_Launcher_And_Configurator{
	
	public static void long_Press(WebElement element,int time) {
			((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
					ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"duration",time));	
	}
	
	// Used only if we know where we are exactly going to scroll and look for
	public static void g_Scroll(String value) {
		String s="new UiScrollable(new UiSelector()).scrollIntoView(text(\"#data#\"));";
		String data2 = s.replace("#data#", value);
		driver.findElement(AppiumBy.androidUIAutomator(data2));
	}
	
	public static void js_Scroll(String element) throws NoSuchElementException {
	
		boolean scroll = true;
		do { 
			boolean displayed = driver.findElement(By.xpath(element)).isDisplayed();
			if(displayed==true) {
				driver.findElement(By.xpath(element)).click();
				break;
			}
			else {
				scroll=(boolean) ((JavascriptExecutor)driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100,"top",100,
						"width",200,"height",200,"direction","down","percent",3.0));
				}
				
		}
		while(scroll);
		
		
	}
	
	public static void swipe_To(String text,String direct) {
	     WebElement ele = driver.findElement(By.xpath(text));
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"direction", direct,"percent",0.50));
	}
	
	public static void drag_drop(String ele, int i1, int i2) {
			WebElement e1 = driver.findElement(By.xpath(ele));
		((JavascriptExecutor)driver).executeScript("mobile: dragGesture",ImmutableMap.of("elementId",((RemoteWebElement)e1).getId(),"endX",i1,"endY",i2));
	}
	
	public static void id_click(String ele) {
		driver.findElement(By.id(ele)).click();
	}
	
	public static void id_pass_Text(String ele, String message) {
		driver.findElement(By.id(ele)).sendKeys(message);
	}
	
	public static void x_click(String ele) {
		driver.findElement(By.xpath(ele)).click();
	}
	
	public static void x_pass_Text(String ele, String message) {
		driver.findElement(By.xpath(ele)).sendKeys(message);
	}
	
	public static void obj_click(By ele) {
		driver.findElement(ele).click();
	}
	
	
	// Navigational commands
	public static void back() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	public static void clear() {
		driver.pressKey(new KeyEvent(AndroidKey.CLEAR));
	}
	public static void Camera() {
		driver.pressKey(new KeyEvent(AndroidKey.CAMERA));
	}
	public static void forward() {
		driver.pressKey(new KeyEvent(AndroidKey.FORWARD));
	}
	
	public static void volume_Up() {
		driver.pressKey(new KeyEvent(AndroidKey.VOLUME_UP));
	}
	
	public static void volume_Down() {
		driver.pressKey(new KeyEvent(AndroidKey.VOLUME_DOWN));
	}
	
	public static void mute() {
	driver.pressKey(new KeyEvent(AndroidKey.MUTE));
	}
	
	public static String property_file_Reader(String value) throws IOException {
		Properties p1 = new Properties();
		FileInputStream f1 = new FileInputStream("C:\\Users\\mjbal\\Desktop\\Rajasekar  interview Preparation\\Appium_Maven_Session\\Appium\\src\\test\\java\\resource\\Terms_And_Condition.properties");
	    p1.load(f1);
	    return p1.getProperty(value);
	
	}
	
		
	

}

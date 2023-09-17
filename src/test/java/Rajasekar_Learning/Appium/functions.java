package Rajasekar_Learning.Appium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.helper_Base;
import io.appium.java_client.AppiumBy;


public class functions extends App_Launcher_And_Configurator{
//@Test
public void navigate_to_Wifi() throws Throwable  {
	// locating the elements and navigating into the apps as conventional selenium does]
	driver.findElement(AppiumBy.accessibilityId("Preference")).click();
	driver.findElement(By.xpath("	\r\n"+ "//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
    //Assert.assertEquals( driver.findElement(By.className("android.widget.CheckBox")).isSelected(),false);
   driver.findElement(By.className("android.widget.CheckBox")).click();
   driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
   helper_Base.id_pass_Text("android:id/edit", "This is my life");
   helper_Base.id_click("android:id/button2");
}

//@Test
public void handle() throws InterruptedException {
	helper_Base.x_click("//android.widget.TextView[@content-desc=\"Views\"]");
	Thread.sleep(3000);
    helper_Base.x_click("//android.widget.TextView[@content-desc='Expandable Lists']");
    Thread.sleep(3000);
	helper_Base.x_click("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]");
	helper_Base.long_Press(driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']")),2000);
    String text = driver.findElement(By.id("android:id/title")).getText();
    Assert.assertEquals(text, "Sample menu");
}
//@Test
public void scroll() throws InterruptedException {
	helper_Base.x_click("//android.widget.TextView[@content-desc=\"Views\"]");
	Thread.sleep(5000);
//	helper_Base.g_Scroll("WebView");
	//helper_Base.js_Scroll();
	Thread.sleep(3000);
	helper_Base.x_click("//android.widget.TextView[@text='WebView']");
}

//@Test
public void swipe_Function() throws InterruptedException {
	helper_Base.x_click("//android.widget.TextView[@content-desc=\"Views\"]");
	Thread.sleep(3000);
	helper_Base.x_click("//android.widget.TextView[@content-desc=\"Gallery\"]");
	Thread.sleep(3000);
	helper_Base.x_click("//android.widget.TextView[@content-desc=\"1. Photos\"]");
	Thread.sleep(3000);
	Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), "true");
	Thread.sleep(2000);
	helper_Base.swipe_To("(//android.widget.ImageView)[1]", "left");
	Thread.sleep(2000);
	Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), "false");
}

//@Test
public void drag_and_drop() throws InterruptedException {
	helper_Base.x_click("//android.widget.TextView[@content-desc=\"Views\"]");
	Thread.sleep(3000);
	helper_Base.x_click("//android.widget.TextView[@content-desc=\"Drag and Drop\"]");
	Thread.sleep(3000);
	helper_Base.drag_drop("(//android.view.View)[1]", 831, 736);
	
}






}
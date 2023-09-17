package Rajasekar_Learning.Appium;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class App_Launcher_And_Configurator {
	public static AndroidDriver driver;
	AppiumDriverLocalService service;
	
@SuppressWarnings("deprecation")
@BeforeClass
	// To Trigger the appium server and get the app along with which device
	public void launch_Server() throws MalformedURLException {
//		 service = new AppiumServiceBuilder()
//		.withAppiumJS(new File("C:\\Users\\mjbal\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//		.withIPAddress("127.0.0.1").
//		usingPort(4723)
//		.build();
//      service.start();

UiAutomator2Options option = new UiAutomator2Options();
option.setDeviceName("ABC");
//option.setApp("C:\\Users\\mjbal\\Desktop\\Rajasekar  interview Preparation\\Appium_Maven_Session\\Appium\\src\\test\\java\\resource\\ApiDemos-debug.apk");
option.setApp("C:\\Users\\mjbal\\Desktop\\Rajasekar  interview Preparation\\Appium_Maven_Session\\Appium\\src\\test\\java\\resource\\General-Store.apk");
//option.setApp("C:\\Users\\mjbal\\Desktop\\Rajasekar  interview Preparation\\New folder\\chrome.apk");
//option.setChromedriverExecutable("C:\\Users\\mjbal\\Desktop\\Rajasekar  interview Preparation\\Appium_Maven_Session\\chrome");
//option.setCapability("browserName", "Chrome");
 driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), option);
 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}

	@AfterClass
	public void tear_Down() {
	//service.stop();
	 //driver.quit();
	
	}
}

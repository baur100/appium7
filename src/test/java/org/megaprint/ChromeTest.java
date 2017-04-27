package org.megaprint;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Baurz on 4/22/2017.
 */
public class ChromeTest {
    AndroidDriver<AndroidElement> driver;
    DesiredCapabilities cap=new DesiredCapabilities();
    @BeforeClass
    public void init() throws MalformedURLException {

        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Demo");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"105");
        cap.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
        driver=new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"),cap);
    }
    @Test
    public void test1() throws InterruptedException {
        String context = driver.getContext(); // = "CHROMIUM"
        driver.context("NATIVE_APP");
        driver.findElement(By.id("com.android.chrome:id/terms_accept")).click();
        driver.findElement(By.id("com.android.chrome:id/negative_button")).click();
        driver.context(context);
        driver.get("http://dw.com/ru");

        Thread.sleep(3000);
        driver.context("NATIVE_APP");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElementById("com.android.chrome:id/button_secondary").click();
        driver.context(context);
        Thread.sleep(3000);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElementByXPath("//*[@class='content']/div[@class='group'][2]").click();
        driver.context("NATIVE_APP");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElementById("com.android.chrome:id/button_secondary").click();
        driver.findElementById("com.android.chrome:id/button_secondary").click();
        driver.context(context);
        driver.close();



 //
    }
    @Test
    public void test2(){
        System.out.println("Hello, World");
//        driver.findElementById("com.android.chrome:id/send_report_checkbox").click();
//        driver.findElementById("com.android.chrome:id/terms_accept").click();

    }
}

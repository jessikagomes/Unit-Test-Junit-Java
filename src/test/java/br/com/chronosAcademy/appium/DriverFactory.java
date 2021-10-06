package br.com.chronosAcademy.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private DesiredCapabilities capabilities;
    private AppiumDriver<MobileElement> driver;

    public void setDriver() throws MalformedURLException {
        driver = new AppiumDriver<MobileElement>(
                new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }

    public AppiumDriver<MobileElement> getDriver(){
        return driver;
    }

    public void setCapabilities(String platform,String device, String automation,String appPackage, String appActivity){
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,platform);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automation);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,appPackage);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,appActivity);
    }
}

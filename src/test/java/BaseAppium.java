
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static utils.Utils.reInstallApp;

public class BaseAppium {

    private DesiredCapabilities capabilities = new DesiredCapabilities();

    public AppiumDriver getWebDriver() {
        return webDriver;
    }

    AppiumDriver webDriver = null;
    private AppiumServiceBuilder serviceBuilder; // для конфигурации Appium, Установки порта, и хаба
    private AppiumDriverLocalService appiumDriverLocalService; // для запуска и остановки Appium сервиса
    private void terminateAppium() {
        appiumDriverLocalService.stop();
    }

    @BeforeTest
    public void setUpAppium() {
        reInstallApp();
        startAppium();
    }

    @AfterTest
    public void tearDownAppium() {
        terminateAppium();
    }

    private void startAppium() {
        capabilities.setCapability("deviceName", "Nexus 5X");
        capabilities.setCapability("udid", "00bbae66eae625f0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.1.0");
        capabilities.setCapability("appPackage", "org.zwanoo.android.speedtest");
        capabilities.setCapability("appActivity", "com.ookla.mobile4.screens.main.MainActivity");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("clearSystemFiles", true);

        serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.withIPAddress("127.0.0.1");
        serviceBuilder.usingPort(4723);
        serviceBuilder.withCapabilities(capabilities);
        serviceBuilder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        serviceBuilder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        webDriver = new AndroidDriver(capabilities);
        appiumDriverLocalService = AppiumDriverLocalService.buildService(serviceBuilder);
        appiumDriverLocalService.start();
    }
}

package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumFluentWait;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class AppiumWaitUtils {

    private AppiumWaitUtils(){
    }

    public static Wait getWait(final AppiumDriver appiumDriver, int seconds){
        return new AppiumFluentWait(appiumDriver)
                .withTimeout(seconds, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);
    }
}

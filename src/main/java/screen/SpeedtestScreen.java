package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SpeedtestScreen {

    @AndroidFindBy(id = "org.zwanoo.android.speedtest:id/go_button")
    private MobileElement goButton;

    @AndroidFindBy(xpath = "//*[@resource-id='org.zwanoo.android.speedtest:id/download_result_view']" +
            "//*[@resource-id='org.zwanoo.android.speedtest:id/txt_test_result_value']")
    private MobileElement downloadSpeed;

    @AndroidFindBy(xpath = "//*[@resource-id='org.zwanoo.android.speedtest:id/upload_result_view']" +
            "//*[@resource-id='org.zwanoo.android.speedtest:id/txt_test_result_value']")
    private MobileElement uploadSpeed;

    @AndroidFindBy(xpath = "//*[@resource-id='org.zwanoo.android.speedtest:id/test_result_item_ping']" +
            "//*[@resource-id='org.zwanoo.android.speedtest:id/txt_test_result_value']")
    private MobileElement ping;

    @AndroidFindBy(xpath = "//*[@resource-id='org.zwanoo.android.speedtest:id/test_result_item_jitter']" +
            "//*[@resource-id='org.zwanoo.android.speedtest:id/txt_test_result_value']")
    private MobileElement jitter;

    @AndroidFindBy(xpath = "//*[@resource-id='org.zwanoo.android.speedtest:id/test_result_item_packet_loss']" +
            "//*[@resource-id='org.zwanoo.android.speedtest:id/txt_test_result_value']")
    private MobileElement loss;

    private AppiumDriver appiumDriver;

    public SpeedtestScreen(final AppiumDriver appiumDriver) throws InterruptedException {
        appiumDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        this.appiumDriver = appiumDriver;
        Thread.sleep(2000);
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public String getdownloadSpeed() {
        return downloadSpeed.getText();
    }

    public String getUploadSpeed() {
        return uploadSpeed.getText();
    }

    public String getPing() {
        return ping.getText();
    }

    public String getJitter() {
        return jitter.getText();
    }

    public String getLoss() {
        return loss.getText();
    }

    public void clickGoButton() {
        goButton.click();
    }
}



import screen.SpeedtestScreen;
import org.testng.annotations.Test;
import utils.AppiumWaitUtils;

public class TestClass extends BaseAppium {

    @Test
    public void speedtestPrintData() throws InterruptedException {
        final SpeedtestScreen speedtestScreen = new SpeedtestScreen(webDriver);

        speedtestScreen.clickGoButton();
        AppiumWaitUtils.getWait(webDriver, 27);
        System.out.println("Download speed = " + speedtestScreen.getdownloadSpeed() + "\n" +
                "Upload speed = " + speedtestScreen.getUploadSpeed() + "\n" +
                "Ping = " + speedtestScreen.getPing() + "\n" +
                "Jitter = " + speedtestScreen.getJitter() + "\n" +
                "Loss = " + speedtestScreen.getLoss());
    }
}

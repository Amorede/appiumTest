package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Utils {

    private Utils() {
    }

    public static void reInstallApp() {
        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "adb install -r D:\\1\\android_qa_amorede\\speedtest.apk");
            builder.redirectErrorStream(true);
            Process p = builder.start();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

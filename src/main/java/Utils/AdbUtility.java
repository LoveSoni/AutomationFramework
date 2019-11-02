package Utils;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdbUtility {
    Logger logger = Logger.getLogger(AdbUtility.class);

    public void getListOfDevices(String[] args) {
        try {
            String line;
            Process p = Runtime.getRuntime().exec("adb devices");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                logger.info(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

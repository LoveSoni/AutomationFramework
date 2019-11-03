package Utils;

import Constants.Constants;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdbUtility {
    private Logger logger = Logger.getLogger(AdbUtility.class);
    private PropertyReader propertyReader = new PropertyReader();
    private Constants constants = new Constants();
    private final String shellPropertiesPath = constants.RESOURCES_PROP_PATH + constants.slash + "shellCommand.properties";

    public void getListOfAndroidDevices() {
        String adbCommand = propertyReader.getValue("andDeviceList", shellPropertiesPath);
        System.out.println(executeShellCommand(adbCommand));
    }

    public StringBuffer executeShellCommand(String command) {
        String result = null;
        StringBuffer adbLogs = new StringBuffer();
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((result = input.readLine()) != null) {
                adbLogs.append(result + "\n");
            }
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
        return adbLogs;
    }
}

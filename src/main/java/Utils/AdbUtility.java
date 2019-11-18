package Utils;

import Constants.Constants;
import org.apache.log4j.Logger;
import org.apache.log4j.lf5.LogLevel;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AdbUtility {
    private LogUtility logger = new LogUtility(this.getClass());
    private PropertyReader propertyReader = new PropertyReader();
    private Constants constants = new Constants();


    public List getListOfAndroidDevices() {
        List<String> udidList = new ArrayList<String>();
        String adbCommand = propertyReader.getValue("andDeviceList", constants.SHELL_PROP_PATH);
        String adbLogs = new String(executeShellCommand(adbCommand));
        logger.logInfo(adbLogs);
        String lines[] = adbLogs.split("\\r?\\n");
        for (int i = 1; i < lines.length; i++) {
            udidList.add(lines[i].split("\t")[0].trim());
        }
        return udidList;
    }

    public List getListOfiOSDevices() {
        List<String> udidList = new ArrayList<>();
        String ideviceCommand = propertyReader.getValue("iosDeviceList", constants.SHELL_PROP_PATH);
        String ideviceLogs = new String(executeShellCommand(ideviceCommand));
        String lines[] = ideviceLogs.split("\\r?\\n");
        System.out.println(lines.length);
        //Get list of Simulators
        for (int i = 1; i < lines.length; i++) {
            if (lines[i].contains("Simulator")) {
                udidList.add((lines[i].substring(lines[i].indexOf('[') + 1, lines[i].indexOf(']'))));
            }
        }
        return udidList;
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
            logger.logInfo(e.getMessage());
        }
        return adbLogs;
    }
}

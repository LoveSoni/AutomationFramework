package Utils;

import Constants.Constants;

import java.util.Properties;

public class EnvironmentParameters {
    private static String platformOS = System.getProperty("platformOS");
    private static Properties defaultPropertiesPath = PropertyUtility.getPropertyFile(Constants.DEFAULT_PROP_PATH);

    public static String getPlatformOS(){
        return platformOS == null ? getDefaultPlatformOS() : platformOS;
    }

    public static String getDefaultPlatformOS(){
        return defaultPropertiesPath.getProperty("platformOS");
    }
}

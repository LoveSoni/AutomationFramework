package Constants;

import java.io.File;

public class Constants {

    public static final String slash = File.separator;

    public static final String DEALER_APP_PATH = slash + "Users" + slash + System.getProperty("user.name") + slash + "documents" + slash + "builds" + slash + "catalogv2.apk";

    public static final String APPIUM_DEFAULT_IP = "127.0.0.1";

    public static final String PROJ_PATH = System.getProperty("user.dir");

    public static final String RESOURCES_PROP_PATH = PROJ_PATH + slash + "src" + slash + "main" + slash + "resources";

    public static final String SHELL_PROP_PATH = RESOURCES_PROP_PATH + slash + "shellCommand.properties";

    public static final String CONFIG_PROP_PATH = RESOURCES_PROP_PATH + slash + "config.properties";

    public static int WAIT_TIME = 10;

}

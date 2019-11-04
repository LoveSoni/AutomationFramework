package Constants;

import java.io.File;

public class Constants {

    public final String slash = File.separator;

    public final String DEALER_APP_PATH = slash + "Users" + slash + System.getProperty("user.name") + slash + "documents" + slash + "builds" + slash + "catalogv2.apk";

    public final String APPIUM_DEFAULT_IP = "127.0.0.1";

    public final String PROJ_PATH = System.getProperty("user.dir");

    public final String RESOURCES_PROP_PATH = PROJ_PATH + slash + "src" + slash + "main" + slash + "resources";

    public final String SHELL_PROP_PATH = RESOURCES_PROP_PATH + slash + "shellCommand.properties";

    public int WAIT_TIME = 10;

}

package Constants;

import java.io.File;

public class Constants {

    public String slash = File.separator;

    public String DEALER_APP_PATH = slash + "Users" + slash + System.getProperty("user.name") + slash + "documents" + slash + "builds" + slash + "catalogv2.apk";

    public String APPIUM_DEFAULT_IP = "127.0.0.1";

    public int WAIT_TIME = 10;

}

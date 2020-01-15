package BaseClass;

import Library.AndroidSession;
import Library.IosSession;
import Library.SessionManager;
import Library.WebSession;
import Utils.EnvironmentParameters;

public class Base {
    private SessionManager sessionManager;

    public Base() {
        if (EnvironmentParameters.getPlatformOS().equalsIgnoreCase("android")) {
            sessionManager = new AndroidSession();
        } else if (EnvironmentParameters.getPlatformOS().equalsIgnoreCase("iOS")) {
            sessionManager = new IosSession();
        } else {
            sessionManager = new WebSession();
        }
    }
}

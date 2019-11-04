package Utils;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;
import org.apache.log4j.lf5.LogLevel;

public class LogUtility {
    private Class className;
    Logger logger;

    public LogUtility(Class className) {
        this.className = className;
        logger = Logger.getLogger(className);
    }

    public void logInfo(String logMsg) {
        logger.info(logMsg);
    }

//    void log(String msg, LogLevel level, StackTraceElement[] stack) {
//        StackTraceElement[] stackTraceElements = stack;
//        String callerClass = stackTraceElements[1].getClassName();
//        String callerLine = "" + stackTraceElements[1].getLineNumber();
//        msg = callerClass + ":" + callerLine + "-" + msg;
//        logger.log(msg);
//    }
}

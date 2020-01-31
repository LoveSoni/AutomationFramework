package Utils;

import Constants.Constants;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * author Love
 */

public class PropertyUtility {
    private static FileInputStream fileInputStream;
    private static FileOutputStream fileOutputStream;
    private static Logger logger = Logger.getLogger(PropertyUtility.class);

    public static Properties getPropertyFile(String filePath) {
        Properties properties = new Properties();
        try {
            fileInputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        }
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return properties;
    }

    public static Properties replaceValue(String filePath, String key, String value) {
        Properties properties = getPropertyFile(filePath);
        try {
            fileOutputStream = new FileOutputStream(filePath);
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        }
        properties.replace(key, value);
        try {
            properties.store(fileOutputStream, null);
            fileOutputStream.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return properties;
    }

}

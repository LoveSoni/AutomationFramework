package Utils;

import Constants.Constants;
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

    public static Properties getPropertyFile(String filePath) {
        Properties properties = new Properties();
        try {
            fileInputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {//log exception here
        }
        return properties;
    }

    public static Properties replaceValue(String filePath, String key, String value) {
        Properties properties = getPropertyFile(filePath);
        try {
            fileOutputStream = new FileOutputStream(filePath);
        } catch (FileNotFoundException e) {// log exception here
        }
        properties.replace(key, value);
        try {
            properties.store(fileOutputStream, null);
            fileOutputStream.close();
        } catch (IOException e) {
            //log exception here
        }
        return properties;
    }

}

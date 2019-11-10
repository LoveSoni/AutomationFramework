package Utils;

import java.io.*;
import java.util.Properties;

public class PropertyReader {
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;

    public String getValue(String key, String filePath) {
        String value = null;
        Properties properties = readProperties(filePath);
        value = properties.getProperty(key);
        return value;
    }

    public Properties readProperties(String filePath) {
        Properties properties = new Properties();
        try {
            fileInputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        }
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return properties;
    }

    public void replaceValue(String key, String value, String filePath) {
        Properties properties = readProperties(filePath);
        try {
            fileOutputStream = new FileOutputStream(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties.replace(key, value);
        try {
            properties.store(fileOutputStream, "");
            fileOutputStream.close();
        } catch (IOException iE) {
            iE.printStackTrace();
        }
    }
}

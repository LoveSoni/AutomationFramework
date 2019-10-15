package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.FileNotFoundException;

public class PropertyReader {
    public FileInputStream fileInputStream;
    public Properties properties;

    public String getValue(String key, String filePath) {
        String value = null;
        try {
            fileInputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        }
        properties = new Properties();
        try {
            properties.load(fileInputStream);
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        value = properties.getProperty(key);
        return value;
    }

    public String readConfig(String key) {
        return "";
    }
}

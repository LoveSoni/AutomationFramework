package Utils;

import Constants.Constants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
    private static FileInputStream fileInputStream;
    private static FileOutputStream fileOutputStream;

    public static Properties getPropertyFile(String filePath)
    {   Properties properties = new Properties();
        try {
            fileInputStream = new FileInputStream(filePath);
        }catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        try {
             properties.load(fileInputStream);
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        return properties;
    }
    public static void main(String args[])
    {
       System.out.println("value is:"+getPropertyFile(Constants.DEFAULT_PROP_PATH).getProperty("platformOS"));
    }
}

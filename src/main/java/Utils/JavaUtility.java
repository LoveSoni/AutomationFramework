package Utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;

import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;

/**
 * author Love
 */

public class JavaUtility {
    private static Logger logger = Logger.getLogger(JavaUtility.class);

    public static String getReferenceImageB64(String imgPath) throws IOException {
        byte[] fileContent = FileUtils.readFileToByteArray(new File(imgPath));
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        return encodedString;
    }

    public static String getCurrentDateAndTime() {
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getCurrentDateAndTime(String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime localDateTime = LocalDateTime.now();
        return dateTimeFormatter.format(localDateTime);
    }

    public static String getCurrentDate() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("YYYY-MM-DD");
        LocalDate localTime = LocalDate.now();
        return dateFormat.format(localTime);
    }

    public static void sleep(int seconds) // provide the sleep time in seconds
    {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }

}

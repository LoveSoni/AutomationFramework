package Utils;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class AdbUtility {
    Logger logger = Logger.getLogger(AdbUtility.class);

    public String getReferenceImageB64(String imgPath) throws IOException {
        byte[] fileContent = FileUtils.readFileToByteArray(new File(imgPath));
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        return encodedString;
    }
}

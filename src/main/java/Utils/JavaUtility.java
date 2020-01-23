package Utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

/**
 * author Love
 */

public class JavaUtility {
    public String getReferenceImageB64(String imgPath) throws IOException {
        byte[] fileContent = FileUtils.readFileToByteArray(new File(imgPath));
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        return encodedString;
    }


}

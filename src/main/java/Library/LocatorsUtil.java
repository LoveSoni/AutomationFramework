package Library;

import io.appium.java_client.MobileBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 *author Love
 */

public class LocatorsUtil {
    private By by;
    private Logger logger = Logger.getLogger(LocatorsUtil.class);

    public By getElement(String locator){
        String testId[] = locator.split("_");
        String suffix = testId[0];
        String prefix = testId[1];
        switch (suffix)
        {
            case "XP":
                by = MobileBy.xpath(prefix);
                break;
            case "ID":
                by = MobileBy.id(prefix);
                break;
            case "NM":
                by = MobileBy.name(prefix);
                break;
            case "CN":
                by = MobileBy.className(prefix);
                break;
            case "AS":
                by = MobileBy.AccessibilityId(prefix);
                break;
            case "CS":
                by = MobileBy.cssSelector(prefix);
                break;
            case "LT":
                by = MobileBy.linkText(prefix);
                break;
            case "PL":
                by = MobileBy.partialLinkText(prefix);
                break;
            case "TN":
                by = MobileBy.tagName(prefix);
                break;
            default:
                logger.error("locator prefix "+locator +" is incorrect please check in property file");
        }
        return by;
    }
}

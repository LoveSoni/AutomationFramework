package Library;

import io.appium.java_client.MobileBy;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;

public class LocatorsUtil {
    private By by;
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
                    // write log : Locator {prefix} is incorrect please check in the property file
        }
        return by;
    }
}

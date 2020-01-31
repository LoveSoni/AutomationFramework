package Utils;

import org.apache.log4j.Logger;
import org.codehaus.groovy.tools.shell.IO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * author Love
 */

public class JsonReader {
    public static Logger logger = Logger.getLogger(JsonReader.class);
    public JSONObject jsonObject;

    public String readJsonValue(String jsonFilePath, String key) {
        JSONObject jsonValue;
        jsonValue = getJsonObject(jsonFilePath);
        return String.valueOf(jsonValue.get(key));
    }

    public JSONObject getJsonObject(String jsonFilePath) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader fileReader = new FileReader(jsonFilePath)) {
            jsonParser = new JSONParser();
            try {
                Object object = jsonParser.parse(fileReader);
                jsonObject = (JSONObject) object;
            } catch (ParseException e) {
                logger.info(e.getMessage());
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return jsonObject;
    }

    public JSONArray getJsonArray(String jsonFilePath) {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = null;
        try (FileReader fileReader = new FileReader(jsonFilePath)) {
            jsonParser = new JSONParser();
            try {
                jsonArray = (JSONArray) jsonParser.parse(jsonFilePath);
            } catch (ParseException e) {
                logger.error(e.getMessage());
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return jsonArray;
    }

    public JSONObject updateJsonObject(String jsonFilePath, String key, String newValue) {
        JSONObject replaceJsonObject;
        replaceJsonObject = getJsonObject(jsonFilePath);
        replaceJsonObject.replace(key, newValue);
        return replaceJsonObject;
    }

}

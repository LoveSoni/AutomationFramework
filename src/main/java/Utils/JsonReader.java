package Utils;

import com.google.gson.JsonParser;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonReader {
    public Logger logger = Logger.getLogger(JsonReader.class);
    public JSONObject jsonObject;

    public String readJsonValue(String jsonFilePath, String key) {
        JSONObject jsonValue;
        jsonValue = jsonFileReader(jsonFilePath);
        return String.valueOf(jsonValue.get(key));
    }

    public JSONObject jsonFileReader(String jsonFilePath) {
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
            logger.info(e.getMessage());
        }
        return jsonObject;
    }

    public JSONObject updateJsonObject(String jsonFilePath, String key, String newValue) {
        JSONObject replaceJsonObject;
        replaceJsonObject = jsonFileReader(jsonFilePath);
        replaceJsonObject.replace(key, newValue);
        return replaceJsonObject;
    }
}

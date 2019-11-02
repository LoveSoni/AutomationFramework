package Utils;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonReader {

    public JSONParser jsonParser;
    public Logger logger = Logger.getLogger(JsonReader.class);
    public JSONObject jsonObject;

    public String readJsonValue(String jsonFilePath, String key) {
        String value = null;
        jsonParser = new JSONParser();
        try (FileReader fileReader = new FileReader(jsonFilePath)) {
            jsonParser = new JSONParser();
            try {
                Object object = jsonParser.parse(fileReader);
                jsonObject = (JSONObject) object;
                value = jsonObject.get(key).toString();
            } catch (ParseException e) {
                logger.info(e.getMessage());
            }
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
        return value;
    }
}

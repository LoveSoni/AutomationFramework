package Utils;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.IOException;
import java.util.HashMap;

/**
 * author Love
 */
public class ApiUtility {
    private Logger logger = Logger.getLogger(ApiUtility.class);

    public CloseableHttpResponse getRequest(String url) {
        CloseableHttpResponse closeableHttpResponse = null;
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            closeableHttpResponse = closeableHttpClient.execute(httpGet);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return closeableHttpResponse;
    }

    public JSONObject getResponseObject(CloseableHttpResponse closeableHttpResponse) {
        JSONObject responseObject = null;
        try {
            JSONParser jsonParser = new JSONParser();
            responseObject = (JSONObject) jsonParser.parse(EntityUtils.toString(closeableHttpResponse.getEntity()));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return responseObject;
    }

    public int getStatusLine(CloseableHttpResponse closeableHttpResponse) {
        return closeableHttpResponse.getStatusLine().getStatusCode();
    }

    public HashMap<String, String> getHeadersList(CloseableHttpResponse closeableHttpResponse) {
        HashMap<String, String> headersMap = new HashMap<>();
        Header[] headers = closeableHttpResponse.getAllHeaders();
        for (Header head : headers) {
            headersMap.put(head.getName(), head.getValue());
        }
        return headersMap;
    }

}

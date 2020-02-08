package Utils;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * author Love
 */
public class ApiUtility {
    private Logger logger = Logger.getLogger(ApiUtility.class);

    public HttpResponse getRequest(String url) {
        HttpResponse httpResponse = null;
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            httpResponse = httpClient.execute(httpGet);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return httpResponse;
    }

    public JSONObject getResponseObject(HttpResponse closeableHttpResponse) {
        JSONObject responseObject = null;
        try {
            JSONParser jsonParser = new JSONParser();
            responseObject = (JSONObject) jsonParser.parse(EntityUtils.toString(closeableHttpResponse.getEntity()));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return responseObject;
    }

    public int getStatusLine(HttpResponse httpResponse) {
        return httpResponse.getStatusLine().getStatusCode();
    }

    public HashMap<String, String> getHeadersList(HttpResponse httpResponse) {
        HashMap<String, String> headersMap = new HashMap<>();
        Header[] headers = httpResponse.getAllHeaders();
        for (Header head : headers) {
            headersMap.put(head.getName(), head.getValue());
        }
        return headersMap;
    }

    public void sendRequest(String url,String requestType,HashMap<String,String> headerList)
    {
        switch (requestType.toUpperCase()) {
            case "GET":
                getRequest(url);
                break;
            case "POST":
        }
    }

    public static void main(String args[]) throws Exception{
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost  = new HttpPost("https://reqres.in/api/register");

        httpPost.setEntity();
    }
}

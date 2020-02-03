package Utils;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApiUtility {
    private Logger logger = Logger.getLogger(ApiUtility.class);

    public void getCallWithHeaders(HashMap<String, String> newHeader) throws Exception {
        String endPointUrl = "https://reqres.in/api/users";
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(endPointUrl);
        CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);
        logger.info(closeableHttpResponse.getStatusLine().getStatusCode());
        String response = EntityUtils.toString(closeableHttpResponse.getEntity());
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(response);
        logger.info("Response json is " + jsonObject);
        Header[] headersList = closeableHttpResponse.getAllHeaders();
        HashMap<String, String> headerMap = new HashMap<String, String>();
        for (Header header : headersList) {
            headerMap.put(header.getName(), header.getValue());
        }
        for (Map.Entry<String, String> header : headerMap.entrySet()) {
            httpGet.addHeader(header.getKey(), header.getValue());
            logger.info(header.getKey() + "::" + header.getValue());
        }
    }

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

    public String getStatusCode(CloseableHttpResponse closeableHttpResponse)
    {
        String statusLine = null;
        try {
            statusLine = EntityUtils.toString(closeableHttpResponse.getEntity());
        }catch (IOException e)
        {
            logger.error(e.getMessage());
        }
        return statusLine;
    }

    public static void main(String[] args) throws Exception {
      ApiUtility apiUtility = new ApiUtility();
      apiUtility.getRequest("https://reqres.in/api/users");
    }
}

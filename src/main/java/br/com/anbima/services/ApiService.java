package br.com.anbima.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApiService {

	private static final String BASE_URL = "http://localhost:3333";
	
	private final CloseableHttpClient httpClient = HttpClients.createDefault();
	
	public List<Map<String, Object>> getJsonFromUrl(String url) {
		url = BASE_URL + "/" + url;
		
		HttpGet request = new HttpGet(url);
		
		List<Map<String, Object>> result = new ArrayList<>();
		
		JSONArray array = new JSONArray();

        try (CloseableHttpResponse response = httpClient.execute(request)) {

            HttpEntity entity = response.getEntity();

            if (entity != null) {
            	String retSrc = EntityUtils.toString(entity);
            	array = new JSONArray(retSrc);
            }

        } catch (ParseException | IOException e) {
			e.printStackTrace();
		}
         
        
    	for (int i = 0; i < array.length(); i++) {
    		JSONObject obj = array.getJSONObject(i);
    		result.add(obj.toMap());
		}		

        return result;
	}
	
}

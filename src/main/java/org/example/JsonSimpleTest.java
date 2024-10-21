package org.example;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;

public class JsonSimpleTest {
    public static void main(String[] args) throws IOException, ParseException {

        StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/15077586/v1/centers");
        urlBuilder.append("?"+ URLEncoder.encode("serviceKey", "UTF-8") + "=본인서비스키");
        urlBuilder.append("&"+ URLEncoder.encode("page", "UTF-8")+"=" + URLEncoder.encode("1", "UTF-8"));
        urlBuilder.append("&"+ URLEncoder.encode("perPage", "UTF-8")+"=" + URLEncoder.encode("10", "UTF-8"));

        URL url = new URL(urlBuilder.toString());
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());

        BufferedReader br;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        }else{
            br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
        }

        String result = br.readLine();

        br.close();
        conn.disconnect();

        JSONParser jasonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jasonParser.parse(result);
        JSONArray arr = (JSONArray) jsonObject.get("data");
        System.out.println(arr);

        for(Object one : arr){
            JSONObject ob = (JSONObject) one;

            System.out.print(ob.get("id")+"\t");
            System.out.print(ob.get("facilityName")+"\t");
            System.out.print(ob.get("address")+"\t");
            System.out.print(ob.get("org")+"\t");
            System.out.print(ob.get("createdAt")+"\t");
            System.out.println(ob.get("phoneNumber"+"\t"));

        }
    }
}

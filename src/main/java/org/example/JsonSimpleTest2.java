package org.example;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class JsonSimpleTest2 {
    public static void main(String[] args) throws IOException, ParseException {

        StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/15033308/v1/uddi:afb71101-38ca-4848-9ceb-86c40debe654");
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

            System.out.print(ob.get("순번")+"\t");
            System.out.print(ob.get("상호")+"\t");
            System.out.print(ob.get("대표자")+"\t");
            System.out.print(ob.get("소재지(도로명)")+"\t");
            System.out.print(ob.get("영업구분")+"\t");
            System.out.print(ob.get("등록신청사업")+"\t");
            System.out.print(ob.get("등록증번호")+"\t");
            System.out.print(ob.get("시군구명")+"\t");
            System.out.println(ob.get("등록일자")+"\t");

        }
    }
}

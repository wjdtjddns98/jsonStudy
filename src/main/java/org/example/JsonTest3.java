package org.example;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class JsonTest3 {
    public static void main(String[] args) throws Exception, ParseException {
        StringBuilder urlbuilder = new StringBuilder("https://api.odcloud.kr/api/15033308/v1/uddi:afb71101-38ca-4848-9ceb-86c40debe654?page=1&perPage=10&serviceKey=본인서비스키");
        //이런 방법도 있다.

        URL url = new URL(urlbuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Respond code: " + conn.getResponseCode());

        BufferedReader br;
        if(conn.getResponseCode() == 200) {
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        }else{
            br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        String result = br.readLine();

        br.close();
        conn.disconnect();

        JSONParser jsonParser = new JSONParser();
        JSONObject jasonObject = (JSONObject) jsonParser.parse(result);
        JSONArray arr = (JSONArray) jasonObject.get("data");
        System.out.println(arr);

        for(Object obj : arr) {
            JSONObject ob = (JSONObject)obj;
            System.out.print(ob.get("순번")+ "\t");
            System.out.print(ob.get("등록일자")+ "\t");
            System.out.print(ob.get("등록증번호")+ "\t");
            System.out.print(ob.get("시군구명")+ "\t");
            System.out.print(ob.get("상호")+ "\t");
            System.out.print(ob.get("대표자")+ "\t");
            System.out.print(ob.get("등록신청사업")+ "\t");
            System.out.print(ob.get("소재지")+ "\t");
            System.out.print(ob.get("소재지(도로명)")+ "\t");
            System.out.println(ob.get("영업구분"));
        }

    }
}

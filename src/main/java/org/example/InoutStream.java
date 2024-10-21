package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;


    public class InoutStream {
        public static void main(String[] args) {

            InputStream is = InoutStream.class.getResourceAsStream("/info.json");
            System.out.println(is);

            if (is == null) {
                throw new NullPointerException("파일을 찾을 수 없습니다.");
            }
            JSONTokener tokener = new JSONTokener(is);
            JSONObject obj = new JSONObject(tokener);
            JSONArray emps = obj.getJSONArray("employees");

            for (Object emp : emps) {
                JSONObject employees = (JSONObject)emp;
                System.out.println(employees.get("id")+ "\t");
                System.out.println(employees.get("name")+"\t");
                System.out.println(employees.get("email")+"\t");
            }
        }
    }

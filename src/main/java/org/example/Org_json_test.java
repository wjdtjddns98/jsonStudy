package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

public class Org_json_test {
    public static void main(String[] args) {
        //제이슨 오브젝트 개체
        JSONObject jo = new JSONObject();
        jo.put("id", 1234);
        jo.put("name", "홍박사");
        jo.put("email", "DoctorH@gmail.com");

        System.out.println(jo);


        //get set 메소드가 있어야함

        Employee employee = new Employee(1234,"홍길동", "DoctorH@gmail.com");
        JSONObject jo2 = new JSONObject(employee);
        System.out.println(jo2);

        // 제이슨 어레이 배열 //
        Employee e1 = new Employee(1234,"홍길동","DoctorH@gmail.com");
        Employee e2 = new Employee(1234,"펭수", "DoctorH@gmail.com");
        JSONObject j1 = new JSONObject(e1);
        JSONObject j2 = new JSONObject(e2);
        System.out.println(j1);
        System.out.println(j2);

        JSONArray emps = new JSONArray();
        emps.put(j1);
        emps.put(j2);

        JSONObject obj = new JSONObject(emps);
        obj.put("emplyees", emps);
        System.out.println(obj.toString(2));
        }
}

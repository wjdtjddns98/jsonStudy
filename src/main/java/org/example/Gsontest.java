package org.example;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gsontest {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Employee emp = new Employee(1234,"홍박사","doctorH@google.com");
        System.out.println(emp);
        String jsonString = gson.toJson(emp);
        System.out.println(jsonString);

//제이슨 문자열 데이터를 받아서 자바 객체로 변환//
        String inputData = "{\"id\":1234,\"name\":\"홍박사\",\"email\":\"doctorH@google.com\"}";
        Employee e = gson.fromJson(inputData, Employee.class);
        System.out.println(e);

        /* 자바 리스트를 제이슨변환 */
        Employee e1 = new Employee(1233,"홍박사","doctorH@google.com");
        Employee e2 = new Employee(1235,"홍금보","geumboH@google.com");

        List<Employee> employees = Arrays.asList(e1,e2);
        String json = gson.toJson(employees);
        System.out.println(json);
        /* 제이슨 리스트를 다시 자바 리스트로 */

        List<Employee> list = gson.fromJson(json, List.class);
        System.out.println(list);
    }
}

package com.qunar.ben.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ben on 2017/4/19.
 */
public class Test {


    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    public  static  void changeEmployee(Employee employee)
    {
        employee.age = 1000;
    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.age = 100;
        changeEmployee(employee);
        System.out.println(employee.age);

    }


}

class Employee {
    public int age;


}


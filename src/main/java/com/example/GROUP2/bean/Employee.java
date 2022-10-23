package com.example.GROUP2.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

    private int usrID;
    private String name;
    private boolean gender;
    private int age;
    private String department;
    boolean admin;

}
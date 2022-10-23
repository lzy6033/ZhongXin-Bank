package com.example.GROUP2.service;

import com.example.GROUP2.bean.Employee;
import com.example.GROUP2.mapper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Slf4j
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public Employee findEmployeeInfo(int usrID){
        return employeeMapper.findEmployeeInfo(usrID);
    }
    public boolean addEmployeeInfo(int usrID, String name, boolean gender, int age, String department, boolean admin){
        return employeeMapper.addEmployeeInfo(usrID,name,gender,age,department,admin);
    }
    public boolean deleteEmployeeInfo(int usrID){
        return employeeMapper.deleteEmployeeInfo(usrID);
    }

    public boolean addRight(int usrID){
        return employeeMapper.addRight(usrID);
    }

    public boolean deleteRight(int usrID){
        return employeeMapper.deleteRight(usrID);
    }

    public Collection<Employee> showAllEmployees(){
    return employeeMapper.showAllEmployees();
}

}


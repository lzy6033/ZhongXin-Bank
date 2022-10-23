package com.example.GROUP2.mapper;

import com.example.GROUP2.bean.Employee;
import org.apache.ibatis.annotations.Mapper;
import java.util.Collection;
@Mapper
public interface EmployeeMapper {

    public Employee findEmployeeInfo(int usrID);
    public boolean addEmployeeInfo(int usrID, String name, boolean gender, int age, String department, boolean admin);
    public boolean deleteEmployeeInfo(int usrID);
    public boolean addRight(int usrID);
    public boolean deleteRight(int usrID);
    public Collection<Employee> showAllEmployees();

//    public Collection<Record> findEmployeeRecord(int usrID);
}
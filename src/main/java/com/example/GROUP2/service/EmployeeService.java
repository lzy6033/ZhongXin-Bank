package com.example.GROUP2.service;

import com.example.GROUP2.bean.Employee;
import com.example.GROUP2.bean.Record;
import com.example.GROUP2.mapper.EmployeeMapper;
import com.example.GROUP2.mapper.RecordMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Slf4j
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public Employee findEmployeeInfo(long logID, int usrID){
        log.info("Log:"+logID+"查找usrID="+usrID+"的员工信息");
        return employeeMapper.findEmployeeInfo(usrID);
    }
    public boolean addEmployeeInfo(long logID,int usrID, String name, boolean gender, int age, String department, boolean admin){
        log.info("Log:"+logID+"增加员工信息usrID="+usrID+",name="+name+",gender="+gender+",age="+age+",department="+department+",admin="+admin);
        return employeeMapper.addEmployeeInfo(usrID,name,gender,age,department,admin);
    }
    public boolean deleteEmployeeInfo(long logID,int usrID){
        log.info("Log:"+logID+"删除usrID="+usrID+"的员工信息");
        return employeeMapper.deleteEmployeeInfo(usrID);
    }
//    public Collection<Record> findEmployeeRecord(long logID, int usrID){
//        log.info("Log:"+logID+"查找usrID="+usrID+"的员工所有违规记录");
//        return recordMapper.findEmployeeRecord(usrID);
//    }
    public Collection<Employee> showAllEmployees(long logID){
    log.info("Log:"+logID+"展示所有员工信息");
    return employeeMapper.showAllEmployees();
}

}


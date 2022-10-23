package com.example.GROUP2.controller;

import com.example.GROUP2.bean.Employee;
import com.example.GROUP2.bean.Record;
import com.example.GROUP2.service.EmployeeService;
import com.example.GROUP2.service.RecordService;
import com.google.gson.Gson;
import javafx.scene.control.DialogPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class IndexController {


    /**
     * 员工信息
     */
    @Autowired
    EmployeeService employeeService;

    @ResponseBody
    @GetMapping("/admin/find/employee/info")
    //测试路径：/admin/find/employee/info?usrID=1
    public Employee findEmployeeInfo(@RequestParam("usrID") int usrID){
        return employeeService.findEmployeeInfo(System.currentTimeMillis(),usrID);
    }
    @ResponseBody
    @GetMapping("/admin/add/employee/info")
    //测试路径：/admin/add/employee/info?usrID=12345&name=Zhangsan&gender=1&age=25&department=HR&admin=0
    public String addOneRecord(
            @RequestParam("usrID") int usrID,
            @RequestParam("name") String name,
            @RequestParam("gender") boolean gender,
            @RequestParam("age") int age,
            @RequestParam("department") String department,
            @RequestParam("admin") boolean admin
    ){
        if(employeeService.addEmployeeInfo(System.currentTimeMillis(),
                usrID, name, gender, age, department, admin
        )) return "员工信息添加成功";
        else return "员工信息添加失败";

    }
    @ResponseBody
    @GetMapping("/admin/delete/employee/info")
    //测试路径：/admin/delete/employee/info?usrID=12345
    public String deleteEmployeeInfo(
            @RequestParam("usrID") int usrID){
        if(employeeService.deleteEmployeeInfo(System.currentTimeMillis(),usrID)==true)
            return "员工信息删除成功";
        else return "员工信息删除失败";
    }
    @ResponseBody
    @GetMapping("/admin/show/all/employees")
    //测试路径：/admin/show/all/employees
    public Map<String, Object> showAllEmployees(
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize,
            @RequestParam("selectKey") int selectKey,
            @RequestParam("selectValue") int selectValue,
            HttpServletRequest request
    ){
        HttpServletResponse httpServletResponse = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        int status = httpServletResponse.getStatus();

        String token = request.getHeader("token");
        Map<String,Object> map = new HashMap<String,Object>();
        if (token != null) {
            Collection<Employee> employees= employeeService.showAllEmployees(System.currentTimeMillis());
            map.put("list",employees);
            map.put("size",employees.size());
            map.put("status", status);
        }
        return map;
    }
    /**
     * 违规记录
     */
    @Autowired
    RecordService recordService;

    @ResponseBody
    @GetMapping("/admin/find/one/record")
    //测试路径：/admin/find/one/record?recordID=1
    public Record findOneRecord(@RequestParam("recordID") int recordID){
        return recordService.findOneRecord(System.currentTimeMillis(),recordID);
    }
    @ResponseBody
    @GetMapping("/admin/add/one/record")
    //测试路径：/admin/add/one/record?usrID=5&type=2&location=3&time=2022-10-22-14-33&duration=30
    public String addOneRecord(
            @RequestParam("usrID") int usrID,
            @RequestParam("type") int type,
            @RequestParam("location") int location,
            @RequestParam("time") String time,
            @RequestParam("duration") int duration
    ){
        if(recordService.addOneRecord(System.currentTimeMillis(),
                usrID,type,location,time,duration
        )==true) return "违规记录添加成功";
        else return "违规记录添加失败";

    }
    @ResponseBody
    @GetMapping("/admin/delete/one/record")
    //测试路径：/admin/delete/one/record?recordID=1
    public String deleteOneRecord(
            @RequestParam("recordID") int recordID){
        if(recordService.deleteOneRecord(System.currentTimeMillis(),recordID)==true)
            return "违规记录删除成功";
        else return "违规记录删除失败";
    }
    @ResponseBody
    @GetMapping("/admin/find/employee/record")
    //测试路径：/admin/find/employee/record?usrID=5
    public Collection<Record> findEmployeeRecord(@RequestParam("usrID") int usrID){
        return recordService.findEmployeeRecord(System.currentTimeMillis(),usrID);
    }

}

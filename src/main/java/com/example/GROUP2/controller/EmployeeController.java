package com.example.GROUP2.controller;

import com.example.GROUP2.anno.SysLogAnno;
import com.example.GROUP2.bean.Employee;
import com.example.GROUP2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 员工信息
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /** 管理员.1.1查找某员工信息的接口 */
    @SysLogAnno("管理员：查找某员工信息")
    @ResponseBody
    @GetMapping("/admin/find/employee/info")//测试路径：/admin/find/employee/info?usrID=1
    public Employee findEmployeeInfo(@RequestParam("usrID") int usrID){
        return employeeService.findEmployeeInfo(usrID);
    }

    /** 管理员.1.2增加某员工信息的接口 */
    @SysLogAnno("管理员：增加某员工信息")
    @ResponseBody
    @GetMapping("/admin/add/employee/info")//测试路径：/admin/add/employee/info?usrID=12345&name=Zhangsan&gender=1&age=25&department=HR&admin=0
    public String addOneRecord(
            @RequestParam("usrID") int usrID,
            @RequestParam("name") String name,
            @RequestParam("gender") boolean gender,
            @RequestParam("age") int age,
            @RequestParam("department") String department,
            @RequestParam("admin") boolean admin
    ){
        if(employeeService.addEmployeeInfo(
                usrID, name, gender, age, department, admin
        )) return "员工信息添加成功";
        else return "员工信息添加失败";

    }
    /** 管理员.1.3删除某员工信息的接口 */
    @SysLogAnno("管理员：删除某员工信息")
    @ResponseBody
    @GetMapping("/admin/delete/employee/info")//测试路径：/admin/delete/employee/info?usrID=12345
    public String deleteEmployeeInfo(
            @RequestParam("usrID") int usrID){
        if(employeeService.deleteEmployeeInfo(usrID)==true)
            return "员工信息删除成功";
        else return "员工信息删除失败";
    }
    /** 管理员.1.4增加某员工为管理员的接口 */
    @SysLogAnno("管理员：增加某员工为管理员")
    @ResponseBody
    @GetMapping("/admin/add/right")//测试路径：/admin/add/right?usrID=12345
    public String addRight(
            @RequestParam("usrID") int usrID){
        if(employeeService.addRight(usrID)==true)
            return "增加管理员成功";
        else return "增加管理员失败";
    }
    /** 管理员.1.5删除某员工为管理员的接口 */
    @SysLogAnno("管理员：删除某员工为管理员")
    @ResponseBody
    @GetMapping("/admin/delete/right")//测试路径：/admin/delete/right?usrID=12345
    public String deleteRight(
            @RequestParam("usrID") int usrID){
        if(employeeService.deleteRight(usrID)==true)
            return "删除管理员成功";
        else return "删除管理员失败";
    }
    /** 管理员.1.6展示所有员工信息的接口 */
    @SysLogAnno("管理员：展示所有员工信息")
    @ResponseBody
    @GetMapping("/admin/show/all/employees")//测试路径：/admin/show/all/employees
    public Map<String, Object> showAllEmployees(
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize,
            @RequestParam("selectKey") int selectKey,
            @RequestParam("selectValue") int selectValue,
            HttpServletRequest request
    ){
        String token = request.getHeader("token");
        Map<String,Object> map = new HashMap<String,Object>();
        if (token != null) {
//            Collection<Employee> employees= new ArrayList<>();
//            employees.add(new Employee(1,"a",false,30,"kaifa",true));
//            employees.add(new Employee(2,"b",true,25,"sheji",false));
            Collection<Employee> employees= employeeService.showAllEmployees();
            HttpServletResponse httpServletResponse = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
            map.put("list",employees);
            map.put("size",employees.size());
            map.put("status", httpServletResponse.getStatus());
        }
        return map;
    }
}

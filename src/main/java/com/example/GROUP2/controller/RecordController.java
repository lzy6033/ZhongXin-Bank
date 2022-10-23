package com.example.GROUP2.controller;

import com.example.GROUP2.anno.SysLogAnno;
import com.example.GROUP2.bean.Record;
import com.example.GROUP2.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Collection;

/**
 * 违规记录
 */
@Controller
public class RecordController {
    @Autowired
    RecordService recordService;
    /** 普通员工.1.1展示自己所有违规记录的接口 */
    @SysLogAnno("普通员工：展示自己所有违规记录")
    @ResponseBody//!!!!!!!!!!!!!!!!!!!这里应直接取值吧？登录之后就可以
    @GetMapping("/employee/show/my/record")//测试路径：/employee/show/my/record?recordID=3
    public Record showMyRecord(@RequestParam("recordID") int recordID){
        return recordService.showMyRecord(recordID);
    }

    /** 管理员.4.1查找某条违规记录的接口 */
    @SysLogAnno("管理员：查找某条违规记录")
    @ResponseBody
    @GetMapping("/admin/find/one/record")//测试路径：/admin/find/one/record?recordID=1
    public Record findOneRecord(@RequestParam("recordID") int recordID){
        return recordService.findOneRecord(recordID);
    }
    /** 管理员.4.2增加一条违规记录的接口 */
    @SysLogAnno("管理员：增加一条违规记录")
    @ResponseBody
    @GetMapping("/admin/add/one/record")//测试路径：/admin/add/one/record?usrID=5&type=2&location=3&time=2022-10-22-14-33&duration=30
    public String addOneRecord(
            @RequestParam("usrID") int usrID,
            @RequestParam("type") int type,
            @RequestParam("location") int location,
            @RequestParam("time") String time,
            @RequestParam("duration") int duration
    ){
        if(recordService.addOneRecord(
                usrID,type,location,time,duration
        )==true) return "违规记录添加成功";
        else return "违规记录添加失败";

    }
    /** 管理员.4.3删除一条违规记录的接口 */
    @SysLogAnno("管理员：删除一条违规记录")
    @ResponseBody
    @GetMapping("/admin/delete/one/record")//测试路径：/admin/delete/one/record?recordID=1
    public String deleteOneRecord(
            @RequestParam("recordID") int recordID){
        if(recordService.deleteOneRecord(recordID)==true)
            return "违规记录删除成功";
        else return "违规记录删除失败";
    }
    /** 管理员.4.4查找某员工所有违规记录的接口 */
    @SysLogAnno("管理员：查找某员工所有违规记录")
    @ResponseBody
    @GetMapping("/admin/find/employee/record")//测试路径：/admin/find/employee/record?usrID=5
    public Collection<Record> findEmployeeRecord(@RequestParam("usrID") int usrID){
        return recordService.findEmployeeRecord(usrID);
    }
}

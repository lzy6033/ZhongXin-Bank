package com.example.GROUP2.controller;

import com.example.GROUP2.bean.Record;
import com.example.GROUP2.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@Controller
public class IndexController {

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
        )==true) return "添加成功";
        else return "添加失败";

    }
    @ResponseBody
    @GetMapping("/admin/delete/one/record")
    //测试路径：/admin/delete/one/record?recordID=1
    public String deleteOneRecord(@RequestParam("recordID") int recordID){
        if(recordService.deleteOneRecord(System.currentTimeMillis(),recordID)==true)
            return "删除成功";
        else return "删除失败";
    }
    @ResponseBody
    @GetMapping("/admin/find/employee/record")
    //测试路径：/admin/find/employee/record?usrID=5
    public Collection<Record> findEmployeeRecord(@RequestParam("usrID") int usrID){
        return recordService.findEmployeeRecord(System.currentTimeMillis(),usrID);
    }

}

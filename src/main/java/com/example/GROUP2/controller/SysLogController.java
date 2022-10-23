package com.example.GROUP2.controller;

import com.example.GROUP2.anno.SysLogAnno;
import com.example.GROUP2.bean.SysLog;
import com.example.GROUP2.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Collection;

/**
 * 系统日志
 */
@Controller
public class SysLogController {

    @Autowired
    SysLogService sysLogService;

    /** 管理员.3.1:展示10条最新系统日志的接口 */
    @SysLogAnno("管理员：展示10条最新系统日志的接口")
    @ResponseBody
    @GetMapping("/usr/show/logs")//测试路径：/usr/show/logs
    public Collection<SysLog> showLogs(){
        return sysLogService.showLogs();
    }
    /** 管理员.3.2:展示10条panic日志的接口 */

    /** 管理员.3.3:查找某条日志的接口 */
    @SysLogAnno("管理员：查找某条日志的接口")
    @ResponseBody
    @GetMapping("/usr/find/logs")//测试路径：/usr/find/logs?targetLogID=1
    public SysLog findLog(@RequestParam("targetLogID") int targetLogID){
        return sysLogService.findLog(targetLogID);
    }

}

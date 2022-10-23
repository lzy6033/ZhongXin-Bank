package com.example.GROUP2.controller;

import com.example.GROUP2.anno.SysLogAnno;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统计分析
 */
@Controller
public class AnalysisController {
    /** 管理员.2.1展示统计分析结果的接口 */
    @SysLogAnno("管理员：展示统计分析结果")
    @ResponseBody
    @GetMapping("/admin/show/analysis")//测试路径：/admin/show/analysis
    public String showAnalysis(){
        return "统计结果";
    }

}

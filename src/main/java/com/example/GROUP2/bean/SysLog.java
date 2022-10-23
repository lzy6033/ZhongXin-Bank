package com.example.GROUP2.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysLog {
    private Long logID;

    private int usrID;
    private String usrName;
    private boolean usrAdmin;

    private String remark;
    private String time;
    private String params;

}

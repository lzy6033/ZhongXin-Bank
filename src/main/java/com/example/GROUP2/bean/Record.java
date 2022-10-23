package com.example.GROUP2.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Record {
    private int recordID;

    private int usrID;
    private int type;
    private int position;
    private String time;
    private int duration;

}
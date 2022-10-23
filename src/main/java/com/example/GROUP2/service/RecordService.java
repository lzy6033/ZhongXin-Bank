package com.example.GROUP2.service;

import com.example.GROUP2.bean.Record;
import com.example.GROUP2.mapper.RecordMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class RecordService {
    @Autowired
    RecordMapper recordMapper;
    public Record showMyRecord(int recordID){
        return recordMapper.findOneRecord(recordID);
    }

    public Record findOneRecord(int recordID){
        return recordMapper.findOneRecord(recordID);
    }
    public boolean addOneRecord(int usrID,int type,int location,
                               String time,int duration){
        return recordMapper.addOneRecord(usrID,type,location,time,duration);
    }
    public boolean deleteOneRecord(int recordID){
        return recordMapper.deleteOneRecord(recordID);
    }
    public Collection<Record> findEmployeeRecord(int usrID){
        return recordMapper.findEmployeeRecord(usrID);

    }

}


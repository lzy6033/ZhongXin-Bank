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

    public Record findOneRecord(long logID,int recordID){
        log.info("Log:"+logID+"查找recordID="+recordID+"的违规记录");
        return recordMapper.findOneRecord(recordID);
    }
    public boolean addOneRecord(long logID,int usrID,int type,int location,
                               String time,int duration){
        log.info("Log:"+logID+"增加一条违规记录usrID="+usrID+",type="+type+",location="+location+",time="+time+",duration="+duration);
        return recordMapper.addOneRecord(usrID,type,location,time,duration);
    }
    public boolean deleteOneRecord(long logID,int recordID){
        log.info("Log:"+logID+"删除recordID="+recordID+"的违规记录");
        return recordMapper.deleteOneRecord(recordID);
    }
    public Collection<Record> findEmployeeRecord(long logID,int usrID){
        log.info("Log:"+logID+"查找usrID="+usrID+"的员工所有违规记录");
        return recordMapper.findEmployeeRecord(usrID);

    }

}


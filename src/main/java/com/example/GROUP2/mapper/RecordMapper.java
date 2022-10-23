package com.example.GROUP2.mapper;

import com.example.GROUP2.bean.Record;
import org.apache.ibatis.annotations.Mapper;
import java.util.Collection;

@Mapper
public interface RecordMapper {

    public Record findOneRecord(int recordID);
    public boolean addOneRecord(int usrID,int type,int location,
                               String time,int duration);
    public boolean deleteOneRecord(int recordID);
    public Collection<Record> findEmployeeRecord(int usrID);
}
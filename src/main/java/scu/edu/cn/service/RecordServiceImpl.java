package scu.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import scu.edu.cn.dao.entity.Record;
import scu.edu.cn.dao.entity.StaffInfo;
import scu.edu.cn.dao.mapper.CustomerInfoMapper;
import scu.edu.cn.dao.mapper.RecordMapper;
import scu.edu.cn.dao.mapper.StaffInfoMapper;
import scu.edu.cn.dto.BriefRecord;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import java.util.ArrayList;
import java.util.List;

import static scu.edu.cn.util.Constant.*;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    RecordMapper mapper;
    @Autowired
    StaffInfoMapper staffInfoMapper;
    @Autowired
    CustomerInfoMapper customerInfoMapper;

    @Override
    public Error insertRecord(Record record) {
        Error error;
        try {
            mapper.insertSelective(record);
            error = new Error(OPERATION_SUCCESS, "插入合同信息成功");
        } catch (DataAccessResourceFailureException e) {
            e.printStackTrace();
            error = new Error(DB_ACCESS_ERROR, "访问数据库失败");
        } catch (Exception e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "插入合同信息异常");
        }
        return error;
    }

    @Override
    public Error updateRecord(Record record) {
        Error error;
        try {
            mapper.updateByPrimaryKeySelective(record);
            error = new Error(OPERATION_SUCCESS, "更新合同信息成功");
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            error = new Error(DUPLICATE_INFO, "合同信息已存在");
        } catch (DataAccessResourceFailureException e) {
            e.printStackTrace();
            error = new Error(DB_ACCESS_ERROR, "访问数据库失败");
        } catch (Exception e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "更新合同信息异常");
        }
        return error;
    }

    @Override
    public Error deleteRecord(int id) {
        Error error;
        try {
            mapper.deleteByPrimaryKey(id);
            error = new Error(OPERATION_SUCCESS, "删除合同信息成功");
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            error = new Error(DUPLICATE_INFO, "合同信息已存在");
        } catch (DataAccessResourceFailureException e) {
            e.printStackTrace();
            error = new Error(DB_ACCESS_ERROR, "访问数据库失败");
        } catch (Exception e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "删除合同信息异常");
        }
        return error;
    }

    @Override
    public Error deleteRecords(Record[] list) {
        Error error;
        try {
            for (int i = 0; i < list.length; i++) {
                mapper.deleteByPrimaryKey(list[i].getRecordId());
            }
            error = new Error(OPERATION_SUCCESS, "删除合同信息成功");
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            error = new Error(DUPLICATE_INFO, "合同信息已存在");
        } catch (DataAccessResourceFailureException e) {
            e.printStackTrace();
            error = new Error(DB_ACCESS_ERROR, "访问数据库失败");
        } catch (Exception e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "删除合同信息异常");
        }
        return error;
    }

    @Override
    public Response getAllRecord() {
        List<Record> list = null;
        Error error;
        try {
            list = mapper.selectAll();
            error = new Error(OPERATION_SUCCESS, "获取列表成功");
        } catch (DataAccessResourceFailureException e) {
            e.printStackTrace();
            error = new Error(DB_ACCESS_ERROR, "访问数据库失败");
        } catch (Exception e) {
            error = new Error(OPERATION_ERROR, "获取合同信息异常");
            e.printStackTrace();
        }
        Response response = new Response(error, list);
        return response;
    }

    @Override
    public Record getRecordById(int id) {
        Record record = null;
        try {
            record = mapper.selectByPrimaryKey(id);
        } catch (DataAccessResourceFailureException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return record;
    }

    @Override
    public Response getBriefRecord(int count) {
        List<Record> list = null;
        Error error;
        Record item;
        String staffName;
        String customerName;
        List<BriefRecord> result = new ArrayList<>();
        int len;
        try {
            list = mapper.selectAll();
            len = list.size() > count ? count : list.size();
            for (int i = 0; i < len; i++) {
                item = list.get(i);
                staffName = staffInfoMapper.selectByPrimaryKey(item.getStaffId()).getStaffName();
                customerName = customerInfoMapper.selectByPrimaryKey(item.getCustomerId()).getCustomerName();
                result.add(new BriefRecord(item.getRecordDate(), customerName, item.getRecordContent(), staffName));
            }
            error = new Error(OPERATION_SUCCESS, "获取列表成功");
        } catch (DataAccessResourceFailureException e) {
            e.printStackTrace();
            error = new Error(DB_ACCESS_ERROR, "访问数据库失败");
        } catch (Exception e) {
            error = new Error(OPERATION_ERROR, "获取合同信息异常");
            e.printStackTrace();
        }
        Response response = new Response(error, result);
        return response;
    }


}

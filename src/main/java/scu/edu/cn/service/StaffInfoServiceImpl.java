package scu.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scu.edu.cn.dao.entity.StaffInfo;
import scu.edu.cn.dao.mapper.StaffInfoMapper;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import java.util.List;

import static scu.edu.cn.util.Constant.OPERATION_ERROR;
import static scu.edu.cn.util.Constant.OPERATION_SUCCESS;

@Service
public class StaffInfoServiceImpl implements StaffInfoService {

    @Autowired
    StaffInfoMapper mapper;

    @Override
    public Error insertStaff(StaffInfo info) {
        Error error;
        try {
            mapper.insertSelective(info);
            error = new Error(OPERATION_SUCCESS, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "增加失败");
        }
        return error;
    }

    @Override
    public Error updateStaff(StaffInfo info) {
        Error error;
        try {
            mapper.updateByPrimaryKeySelective(info);
            error = new Error(OPERATION_SUCCESS, "更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "更新失败");
        }
        return error;
    }

    @Override
    public Error deleteStaffById(Integer staffId) {
        Error error;
        try {
            mapper.deleteByPrimaryKey(staffId);
            error = new Error(OPERATION_SUCCESS, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "删除失败");
        }
        return error;
    }

    @Override
    public List<StaffInfo> selectAllStaff() {
        List<StaffInfo> list = mapper.selectAllStaff();
        Response<List<StaffInfo>> response = new Response<List<StaffInfo>>();
        response.setData(list);
        response.setError(new Error(OPERATION_SUCCESS, "操作成功"));
        return mapper.selectAllStaff();
    }

    @Override
    public StaffInfo selectStaffById(Integer staffId) {
        return mapper.selectByPrimaryKey(staffId);
    }

    @Override
    public List<StaffInfo> selectOnDutyStaff() {
        List<StaffInfo> list = mapper.selectOnDutyStaff();
        int len =list.size()>7?7:list.size();
        return list.subList(0, len);

    }
}



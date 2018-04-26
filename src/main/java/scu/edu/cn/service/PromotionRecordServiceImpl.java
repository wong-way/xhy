package scu.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scu.edu.cn.dao.entity.PromotionRecord;
import scu.edu.cn.dao.mapper.PromotionRecordMapper;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import java.util.List;

import static scu.edu.cn.util.Constant.OPERATION_ERROR;
import static scu.edu.cn.util.Constant.OPERATION_SUCCESS;

@Service
public class PromotionRecordServiceImpl implements PromotionRecordService {

    @Autowired
    PromotionRecordMapper mapper;

    @Override
    public Error insertPromotionRecord(PromotionRecord info) {
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
    public Error updatePromotionRecord(PromotionRecord info) {
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
    public Error deletePromotionRecordById(Integer promotionRecordId) {
        Error error;
        try {
            mapper.deleteByPrimaryKey(promotionRecordId);
            error = new Error(OPERATION_SUCCESS, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "删除失败");
        }
        return error;
    }

    @Override
    public List<PromotionRecord> selectAllPromotionRecord() {
        List<PromotionRecord> list = mapper.selectAllPromotionRecord();
        Response<List<PromotionRecord>> response = new Response<List<PromotionRecord>>();
        response.setData(list);
        response.setError(new Error(OPERATION_SUCCESS, "操作成功"));
        return mapper.selectAllPromotionRecord();
    }

    @Override
    public PromotionRecord selectPromotionRecordById(Integer promotionRecordId) {
        return mapper.selectByPrimaryKey(promotionRecordId);
    }
}

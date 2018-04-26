package scu.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scu.edu.cn.dao.entity.PromotionRemind;
import scu.edu.cn.dao.mapper.PromotionRemindMapper;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import java.util.List;

import static scu.edu.cn.util.Constant.OPERATION_ERROR;
import static scu.edu.cn.util.Constant.OPERATION_SUCCESS;

@Service
public class PromotionRemindServiceImpl implements PromotionRemindService {

    @Autowired
    PromotionRemindMapper mapper;

    @Override
    public Error insertPromotionRemind(PromotionRemind info) {
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
    public Error updatePromotionRemind(PromotionRemind info) {
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
    public Error deletePromotionRemindById(Integer promotionRemindId) {
        Error error;
        try {
            mapper.deleteByPrimaryKey(promotionRemindId);
            error = new Error(OPERATION_SUCCESS, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "删除失败");
        }
        return error;
    }

    @Override
    public List<PromotionRemind> selectAllPromotionRemind() {
        List<PromotionRemind> list = mapper.selectAllPromotionRemind();
        Response<List<PromotionRemind>> response = new Response<List<PromotionRemind>>();
        response.setData(list);
        response.setError(new Error(OPERATION_SUCCESS, "操作成功"));
        return mapper.selectAllPromotionRemind();
    }

    @Override
    public PromotionRemind selectPromotionRemindById(Integer promotionRemindId) {
        return mapper.selectByPrimaryKey(promotionRemindId);
    }
}

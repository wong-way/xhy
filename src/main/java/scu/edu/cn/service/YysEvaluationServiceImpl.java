package scu.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scu.edu.cn.dao.entity.YysEvaluation;
import scu.edu.cn.dao.entity.YysEvaluationKey;
import scu.edu.cn.dao.mapper.YysEvaluationMapper;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import java.util.List;

import static scu.edu.cn.util.Constant.DUPLICATE_USERNAME;
import static scu.edu.cn.util.Constant.OPERATION_ERROR;
import static scu.edu.cn.util.Constant.OPERATION_SUCCESS;

@Service
public class YysEvaluationServiceImpl implements YysEvaluationService{
    @Autowired
    YysEvaluationMapper mapper;
    @Override
    public Error insertYysEvaluation(YysEvaluation yysEvaluation){
        Error error ;
        YysEvaluation yysEvaluation1;
        YysEvaluationKey yysEvaluationKey=new YysEvaluationKey();
        try{
            yysEvaluationKey.setYysId(yysEvaluation.getYysId());
            yysEvaluationKey.setContractId(yysEvaluation.getContractId());
            yysEvaluation1=mapper.selectByPrimaryKey(yysEvaluationKey);
            if(yysEvaluation1 != null)
            {
                error= new Error(DUPLICATE_USERNAME,"结算与评价记录已存在");
            }else{
                mapper.insert(yysEvaluation);
                error= new Error(OPERATION_SUCCESS,"增加成功");
            }

        }catch (Exception e){
            e.printStackTrace();
            error= new Error(OPERATION_ERROR,"增加失败");
        }
        return error;
    }

    @Override
    public Error updateYysEvaluation(YysEvaluation yysEvaluation){
        Error error ;
        try{
            mapper.updateByPrimaryKeySelective(yysEvaluation);
            error= new Error(OPERATION_SUCCESS,"更新成功");
        }catch (Exception e){
            e.printStackTrace();
            error= new Error(OPERATION_ERROR,"更新失败");
        }
        return error;
    }

    @Override
    public Error deleteYysEvaluation(YysEvaluationKey yysEvaluationKey){
        Error error ;
        try{
            mapper.deleteByPrimaryKey(yysEvaluationKey);
            error= new Error(OPERATION_SUCCESS,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            error= new Error(OPERATION_ERROR,"删除失败");
        }
        return error;
    }

    @Override
    public List<YysEvaluation> selectAllYysEvaluation(){
        List<YysEvaluation> list = mapper.selectAllYysEvaluation();
        Response<List<YysEvaluation>> response = new Response<List<YysEvaluation>>();
        response.setData(list);
        response.setError(new Error(OPERATION_SUCCESS," "));
        return mapper.selectAllYysEvaluation();
    }
}

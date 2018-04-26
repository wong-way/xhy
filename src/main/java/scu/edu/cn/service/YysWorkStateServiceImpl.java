package scu.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scu.edu.cn.dao.entity.YysWorkState;
import scu.edu.cn.dao.mapper.YysWorkStateMapper;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import java.util.List;

import static scu.edu.cn.util.Constant.*;

@Service
public class YysWorkStateServiceImpl implements YysWorkStateService {

    YysWorkStateMapper yysWorkStateMapper;

    @Autowired
    public YysWorkStateServiceImpl(YysWorkStateMapper yysWorkStateMapper) {
        this.yysWorkStateMapper = yysWorkStateMapper;
    }

    @Override
    public Error insertYysWorkState(YysWorkState yysWorkState) {
        Error error;
        YysWorkState yysWorkState1;
        try {
            yysWorkState1 = yysWorkStateMapper.selectByPrimaryKey(yysWorkState.getYysId());

            if (yysWorkState1 != null){
                error = new Error(DUPLICATE_USERNAME,"数据已存在");
            }
            else{
                yysWorkStateMapper.insertSelective(yysWorkState);
                error = new Error(OPERATION_SUCCESS,"数据插入成功");
            }
        }
        catch (Exception e){
            error= new Error(OPERATION_ERROR,"增加失败");
            e.printStackTrace();
        }
        return error;
    }

    @Override
    public Response<YysWorkState> selectYysWorkStateById(int yysId) {
        Response<YysWorkState> response = new Response<YysWorkState>();
        Error error ;
        YysWorkState yysWorkState;
        try {
            yysWorkState =yysWorkStateMapper.selectByPrimaryKey(yysId);
            if(yysWorkState == null){
                error = new Error(NOT_EXIST,"数据不存在");
                response.setError(error);
            }


            else{
                error = new Error(OPERATION_SUCCESS,"操作成功");
                response.setError(error);
                response.setData(yysWorkState);
            }
            return response;
        }
        catch (Exception e){
            error = new Error(OPERATION_ERROR,"操作失败");
            e.printStackTrace();
            response.setError(error);
        }
        return response;
    }

    @Override
    public Error updateYysWorkState(YysWorkState yysWorkState) {
        Error error;
        YysWorkState yysWorkState1;
        try{
            yysWorkState1 = yysWorkStateMapper.selectByPrimaryKey(yysWorkState.getYysId());
            if(yysWorkState1==null){
                error = new Error(NOT_EXIST,"数据不存在");
            }
            else{
                yysWorkStateMapper.updateByPrimaryKeySelective(yysWorkState);
                error = new Error(OPERATION_SUCCESS,"操作成功");
            }
        }
        catch (Exception e){
            error = new Error(OPERATION_ERROR,"操作失败");
            e.printStackTrace();
        }
        return  error;
    }

    @Override
    public Error deleteYysWorkStateById(int yysId) {
        Error error;
        YysWorkState yysWorkState ;
        try {
            yysWorkState = yysWorkStateMapper.selectByPrimaryKey(yysId);
            if(yysWorkState == null)
                error = new Error(NOT_EXIST,"数据不存在");
            else{
                yysWorkStateMapper.deleteByPrimaryKey(yysId);
                error = new Error(OPERATION_SUCCESS,"操作成功");
            }
        }
        catch (Exception e){
            error = new Error(OPERATION_ERROR,"操作失败");
            e.printStackTrace();
        }
        return  error;
    }

    @Override
    public Response<List<YysWorkState>> selectAllYysWorkState() {
        Error error;
        List<YysWorkState> list ;
        Response<List<YysWorkState>> response = new Response<List<YysWorkState>>();
        try {
            list =  yysWorkStateMapper.selectAllYysWorkState();
            error = new Error(OPERATION_SUCCESS,"操作成功");
            response.setError(error);
            response.setData(list);

        }
        catch (Exception e){
            error = new Error(OPERATION_ERROR,"操作失败");
            response.setError(error);
        }
        return response;
    }
}

package scu.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scu.edu.cn.dao.entity.ReceptionSituation;
import scu.edu.cn.dao.mapper.ReceptionSituationMapper;
import scu.edu.cn.dto.Reception;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import java.util.ArrayList;
import java.util.List;

import static scu.edu.cn.util.Constant.*;
@Service
public class ReceptionSituationServiceImpl implements ReceptionSituationService {

    ReceptionSituationMapper receptionSituationMapper;

    @Autowired
    public ReceptionSituationServiceImpl(ReceptionSituationMapper receptionSituationMapper) {
        this.receptionSituationMapper = receptionSituationMapper;
    }

    @Override
    public Error insertReceptionSituation(ReceptionSituation receptionSituation) {
        Error error;
        ReceptionSituation receptionSituation1;
        try {
            receptionSituation1 = receptionSituationMapper.selectByPrimaryKey(receptionSituation.getReceptionId());

            if (receptionSituation1 != null){
                error = new Error(DUPLICATE_USERNAME,"数据已存在");
            }
            else{
                receptionSituationMapper.insertSelective(receptionSituation);
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
    public Error updateReceptionSituation(ReceptionSituation receptionSituation) {
        Error error;
        ReceptionSituation receptionSituation1;
        try{
            receptionSituation1 = receptionSituationMapper.selectByPrimaryKey(receptionSituation.getReceptionId());
            if(receptionSituation1==null){
                error = new Error(NOT_EXIST,"数据不存在");
            }
            else{
                receptionSituationMapper.updateByPrimaryKeySelective(receptionSituation);
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
    public Error deleteReceptionSituationById(int id) {
        Error error;
        ReceptionSituation receptionSituation ;
        try {
            receptionSituation = receptionSituationMapper.selectByPrimaryKey(id);
            if(receptionSituation == null)
                error = new Error(NOT_EXIST,"数据不存在");
            else{
                receptionSituationMapper.deleteByPrimaryKey(id);
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
    public Response<ReceptionSituation> selectReceptionSituationById(int id) {
        Response<ReceptionSituation> response = new Response<ReceptionSituation>();
        Error error ;
        ReceptionSituation receptionSituation;
        try {
            receptionSituation =receptionSituationMapper.selectByPrimaryKey(id);
            if(receptionSituation == null){
                error = new Error(NOT_EXIST,"数据不存在");
                response.setError(error);
            }


            else{
                error = new Error(OPERATION_SUCCESS,"操作成功");
                response.setError(error);
                response.setData(receptionSituation);
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
    public Response<List<ReceptionSituation>> selectAllReceptionSituation() {
        Error error;
        List<ReceptionSituation> list ;
        Response<List<ReceptionSituation>> response = new Response<List<ReceptionSituation>>();
        try {
            list =  receptionSituationMapper.selectAllReceptionSituation();
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

    @Override
    public List<Reception> selectTopFive() {
        List<ReceptionSituation> list ;
        List<Reception> result= new ArrayList<>();
        Response<List<ReceptionSituation>> response = new Response<List<ReceptionSituation>>();
        int len;
        try {
            list =  receptionSituationMapper.selectAllReceptionSituation();
            len=list.size()>6?6:list.size();
            for(int i = 0;i<len;i++)
            {
                ReceptionSituation temp = list.get(i);
                result.add(new Reception(temp.getCustomerName(),temp.getCustomerContact(),temp.getRequiredRequirements(),temp.getStaffId(),temp.getMode()));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}

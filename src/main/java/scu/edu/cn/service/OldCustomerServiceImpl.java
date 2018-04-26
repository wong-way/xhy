package scu.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scu.edu.cn.dao.entity.Oldcustomer;
import scu.edu.cn.dao.mapper.OldcustomerMapper;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import java.util.List;

import static scu.edu.cn.util.Constant.*;

@Service
public class OldCustomerServiceImpl implements  OldCustomerService{

    OldcustomerMapper oldcustomerMapper;

    @Autowired
    public OldCustomerServiceImpl(OldcustomerMapper oldcustomerMapper) {
        this.oldcustomerMapper = oldcustomerMapper;
    }

    public Error insertOldCustomer(Oldcustomer oldcustomer){
        Error error;
        Oldcustomer oldcustomer1;
        try {
          oldcustomer1 = oldcustomerMapper.selectByPrimaryKey(oldcustomer.getCustomerId());

          if (oldcustomer1 != null){
              error = new Error(DUPLICATE_USERNAME,"数据已存在");
          }
          else{
              oldcustomerMapper.insertSelective(oldcustomer);
              error = new Error(OPERATION_SUCCESS,"数据插入成功");
          }
        }
        catch (Exception e){
            error= new Error(OPERATION_ERROR,"增加失败");
            e.printStackTrace();
        }
        return error;
    }

    public Error updateOldCustomer(Oldcustomer oldcustomer){
        Error error;
        Oldcustomer oldcustomer1;
        try{
            oldcustomer1 = oldcustomerMapper.selectByPrimaryKey(oldcustomer.getCustomerId());
            if(oldcustomer1==null){
                error = new Error(NOT_EXIST,"用户名不存在");
            }
            else{
                oldcustomerMapper.updateByPrimaryKeySelective(oldcustomer);
                error = new Error(OPERATION_SUCCESS,"操作成功");
            }
        }
        catch (Exception e){
            error = new Error(OPERATION_ERROR,"操作失败");
            e.printStackTrace();
        }
        return  error;
    }

    public Error deleteOldCustomer(int customerId){
        Error error;
        Oldcustomer oldcustomer ;
        try {
            oldcustomer = oldcustomerMapper.selectByPrimaryKey(customerId);
            if(oldcustomer == null)
                error = new Error(NOT_EXIST,"用户名不存在");
            else{
                oldcustomerMapper.deleteByPrimaryKey(customerId);
                error = new Error(OPERATION_SUCCESS,"操作成功");
            }
        }
        catch (Exception e){
            error = new Error(OPERATION_ERROR,"操作失败");
            e.printStackTrace();
        }
        return  error;
    }

    public Response<Oldcustomer> selectOldCustomerById(int id){
        Response<Oldcustomer> response = new Response<Oldcustomer>();
        Error error ;
        Oldcustomer oldcustomer;
        try {
            oldcustomer =oldcustomerMapper.selectByPrimaryKey(id);
            if(oldcustomer == null){
                error = new Error(NOT_EXIST,"用户名不存在");
                response.setError(error);
            }


            else{
                error = new Error(OPERATION_SUCCESS,"操作成功");
                response.setError(error);
                response.setData(oldcustomer);
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

    public List<Oldcustomer> selectAllOldCustomer(){
        Error error;
        List<Oldcustomer> list ;
        Response<List<Oldcustomer>> response = new Response<List<Oldcustomer>>();
        try {
           list =  oldcustomerMapper.selectAllOldCustomer();
           error = new Error(OPERATION_SUCCESS,"操作成功");
           response.setError(error);
           response.setData(list);

        }
        catch (Exception e){
            error = new Error(OPERATION_ERROR,"操作失败");
            response.setError(error);
        }
        return oldcustomerMapper.selectAllOldCustomer();

    }

}

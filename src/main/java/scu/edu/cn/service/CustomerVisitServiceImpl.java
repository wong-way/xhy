package scu.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scu.edu.cn.dao.entity.CustomerVisit;
import scu.edu.cn.dao.entity.CustomerVisitKey;
import scu.edu.cn.dao.mapper.CustomerVisitMapper;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import java.util.List;

import static scu.edu.cn.util.Constant.DUPLICATE_USERNAME;
import static scu.edu.cn.util.Constant.OPERATION_ERROR;
import static scu.edu.cn.util.Constant.OPERATION_SUCCESS;

@Service
public class CustomerVisitServiceImpl implements CustomerVisitService{
    @Autowired
    CustomerVisitMapper mapper;
    @Override
    public Error insertCustomerVisit(CustomerVisit customerVisit){
        Error error ;
        CustomerVisit customerVisit1;
        CustomerVisitKey customerVisitKey=new CustomerVisitKey();
        try{
            customerVisitKey.setCustomerId(customerVisit.getCustomerId());
            customerVisitKey.setVisitDate(customerVisit.getVisitDate());
            customerVisit1=mapper.selectByPrimaryKey(customerVisitKey);
            if(customerVisit1 != null)
            {
                error= new Error(DUPLICATE_USERNAME,"客户回访记录已存在");
            }else{
                mapper.insert(customerVisit);
                error= new Error(OPERATION_SUCCESS,"增加成功");
            }

        }catch (Exception e){
            e.printStackTrace();
            error= new Error(OPERATION_ERROR,"增加失败");
        }
        return error;
    }

    @Override
    public Error updateCustomerVisit(CustomerVisit customerVisit){
        Error error ;
        try{
            mapper.updateByPrimaryKeyWithBLOBs(customerVisit);
            System.out.println(customerVisit.getContent());
            error= new Error(OPERATION_SUCCESS,"更新成功");
        }catch (Exception e){
            e.printStackTrace();
            error= new Error(OPERATION_ERROR,"更新失败");
        }
        return error;
    }

    @Override
    public Error deleteCustomerVisit(CustomerVisitKey customerVisitKey){
        Error error ;
        try{
            mapper.deleteByPrimaryKey(customerVisitKey);
            error= new Error(OPERATION_SUCCESS,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            error= new Error(OPERATION_ERROR,"删除失败");
        }
        return error;
    }

    @Override
    public List<CustomerVisit> selectAllCustomerVisit(){
        List<CustomerVisit> list = mapper.selectAllCustomerVisit();
        Response<List<CustomerVisit>> response = new Response<List<CustomerVisit>>();
        response.setData(list);
        response.setError(new Error(OPERATION_SUCCESS," "));
        return mapper.selectAllCustomerVisit();
    }

}

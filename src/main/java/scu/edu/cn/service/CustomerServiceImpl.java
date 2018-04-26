package scu.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scu.edu.cn.dao.entity.CustomerInfo;
import scu.edu.cn.dao.mapper.CustomerInfoMapper;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import java.util.List;

import static scu.edu.cn.util.Constant.*;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerInfoMapper mapper;


    @Override
    public Error insertCustomer(CustomerInfo info) {
        Error error;
        try {
            mapper.insertSelective(info);
            error = new Error(OPERATION_SUCCESS, "插入成功");
        } catch (Exception e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "插入失败");
        }
        return error;
    }

    @Override
    public Error updateCustomer(CustomerInfo info) {
        Error error;
        CustomerInfo customer;
        try {
            customer = mapper.selectByPrimaryKey(info.getCustomerId());
            if (customer == null)
                error = new Error(NOT_EXIST, "信息不存在");
            else {
                mapper.updateByPrimaryKeySelective(info);
                error = new Error(OPERATION_SUCCESS, "更新成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "更新失败");
        }
        return error;
    }

    @Override
    public Error deleteCustomerById(int id) {
        Error error;
        try {
            mapper.deleteByPrimaryKey(id);
            error = new Error(OPERATION_SUCCESS, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "删除失败");
        }
        return error;
    }

    @Override
    public Response getAllCustomer() {
        Response response = new Response();
        List<CustomerInfo> list = null;
        Error error;
        try {
            list = mapper.selectAll();
            error = new Error(OPERATION_SUCCESS, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "删除失败");
        }
        response.setError(error);
        response.setData(list);

        return response;
    }

    @Override
    public Error deleteCustomers(CustomerInfo[] list) {
        Error error;
        try {
            for (int i = 0; i < list.length; i++) {
                mapper.deleteByPrimaryKey(list[i].getCustomerId());
            }
            error = new Error(OPERATION_SUCCESS, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "删除失败");
        }
        return error;
    }

    @Override
    public Response<CustomerInfo> getCustomer(Integer id) {
        CustomerInfo info = null;
        Error error;
        Response response=new Response() ;
        try {
            info =mapper.selectByPrimaryKey(id);
            error = new Error(OPERATION_SUCCESS, "获取成功");
            response .setError(error);
            response.setData(info);
        } catch (Exception e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "获取成功");
            response.setError(error);
        }
        return response;
    }


}

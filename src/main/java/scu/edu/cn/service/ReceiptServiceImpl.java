package scu.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scu.edu.cn.dao.entity.Receipt;
import scu.edu.cn.dao.mapper.ReceiptMapper;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import java.util.List;

import static scu.edu.cn.util.Constant.*;

@Service
public class ReceiptServiceImpl implements ReceiptService{
    ReceiptMapper receiptMapper;

    @Autowired
    public ReceiptServiceImpl(ReceiptMapper receiptMapper) {
        this.receiptMapper = receiptMapper;
    }

    @Override
    public Error insertReceipt(Receipt receipt) {
        Error error;
        Receipt receipt1;
        try {
            receipt1 = receiptMapper.selectByPrimaryKey(receipt.getReceiptId());

            if (receipt1 != null){
                error = new Error(DUPLICATE_USERNAME,"数据已存在");
            }
            else{
                receiptMapper.insertSelective(receipt);
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
    public Error updateReceipt(Receipt receipt) {
        Error error;
        Receipt receipt1;
        try{
            receipt1 = receiptMapper.selectByPrimaryKey(receipt.getReceiptId());
            if(receipt1==null){
                error = new Error(NOT_EXIST,"数据不存在");
            }
            else{
                receiptMapper.updateByPrimaryKeySelective(receipt);
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
    public Error deleteReceiptById(int id) {
        Error error;
        Receipt receipt ;
        try {
            receipt = receiptMapper.selectByPrimaryKey(id);
            if(receipt == null)
                error = new Error(NOT_EXIST,"数据不存在");
            else{
                receiptMapper.deleteByPrimaryKey(id);
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
    public Response<Receipt> selectReceptById(int id) {
        Response<Receipt> response = new Response<Receipt>();
        Error error ;
        Receipt receipt;
        try {
            receipt =receiptMapper.selectByPrimaryKey(id);
            if(receipt == null){
                error = new Error(NOT_EXIST,"数据不存在");
                response.setError(error);
            }


            else{
                error = new Error(OPERATION_SUCCESS,"操作成功");
                response.setError(error);
                response.setData(receipt);
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
    public Response<List<Receipt>> selectAllReceipt() {
        Error error;
        List<Receipt> list ;
        Response<List<Receipt>> response = new Response<List<Receipt>>();
        try {
            list =  receiptMapper.selectAllReceipt();
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

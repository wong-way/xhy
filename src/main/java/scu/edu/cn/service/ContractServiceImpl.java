package scu.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import scu.edu.cn.dao.entity.Contract;
import scu.edu.cn.dao.mapper.ContractMapper;
import scu.edu.cn.dto.DetailContract;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import java.util.List;

import static scu.edu.cn.util.Constant.*;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractMapper mapper;

    @Override
    public Error insertContract(Contract contract) {
        Error error;
        try {
            mapper.insertSelective(contract);
            error = new Error(OPERATION_SUCCESS, "插入合同数据成功");
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            error = new Error(DUPLICATE_INFO, "合同信息已存在");
        } catch (DataAccessResourceFailureException e) {
            e.printStackTrace();
            error = new Error(DB_ACCESS_ERROR, "访问数据库失败");
        } catch (Exception e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "插入数据异常");
        }
        return error;
    }

    @Override
    public Error updateContract(Contract contract) {
        Error error;
        try {
            mapper.updateByPrimaryKeySelective(contract);
            error = new Error(OPERATION_SUCCESS, "更新合同数据成功");
        } catch (DataAccessResourceFailureException e) {
            e.printStackTrace();
            error = new Error(DB_ACCESS_ERROR, "访问数据库失败");
        } catch (Exception e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "插入数据异常");
        }
        return error;
    }

    @Override
    public Error deleteContract(int id) {
        Error error;
        try {
            mapper.deleteByPrimaryKey(id);
            error = new Error(OPERATION_SUCCESS, "删除合同数据成功");
        } catch (DataAccessResourceFailureException e) {
            e.printStackTrace();
            error = new Error(DB_ACCESS_ERROR, "访问数据库失败");
        } catch (Exception e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "删除数据异常");
        }
        return error;
    }

    @Override
    public Response<List<Contract>> getAll() {
        Response response = new Response();
        List<Contract> list = null;
        Error error;
        try {
            list = mapper.selectAll();
            error = new Error(OPERATION_SUCCESS, "删除合同数据成功");
        } catch (DataAccessResourceFailureException e) {
            e.printStackTrace();
            error = new Error(DB_ACCESS_ERROR, "访问数据库失败");
        } catch (Exception e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "获取数据异常");
        }
        response.setData(list);
        response.setError(error);
        return response;
    }

    @Override
    public Contract getContractById(int id) {
        Contract contract = null;
        try {
            contract = mapper.selectByPrimaryKey(id);
        } catch (DataAccessResourceFailureException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contract;
    }

    @Override
    public Error deleteContracts(Contract[] list) {
        Error error = null;
        try {
            for (int i = 0; i < list.length; i++) {
                mapper.deleteByPrimaryKey(list[i].getContractId());
                error = new Error(OPERATION_SUCCESS, "删除合同数据成功");
            }
        } catch (DataAccessResourceFailureException e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "访问数据异常");
        } catch (Exception e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "获取数据异常");
        }
        return error;
    }

    @Override
    public Response<List<Contract>> getRecent() {
        Response response = new Response();
        Error error;
        List<Contract> list = null;
        try {
            list = mapper.selectRecent();
            error = new Error(OPERATION_SUCCESS, "查询数据成功");
        } catch (DataAccessResourceFailureException e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "访问数据异常");
        } catch (Exception e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "获取数据异常");
        }
        response.setError(error);
        response.setData(list);
        return response;
    }
    @Override
    public Response<List<DetailContract>> getEachDayDetail() {
        Response response = new Response();
        Error error;
        List<DetailContract> list = null;
        try {
            list = mapper.getEachDayDetail();
            error = new Error(OPERATION_SUCCESS, "查询数据成功");
        } catch (DataAccessResourceFailureException e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "访问数据异常");
        } catch (Exception e) {
            e.printStackTrace();
            error = new Error(OPERATION_ERROR, "获取数据异常");
        }
        response.setError(error);
        response.setData(list);
        return response;
    }

    @Override
    public Double getAllContractPrice() {
        List<Contract> list = null;
        Double price=0.0;
        try {
            list = mapper.selectAll();
            for(int i = 0;i<list.size();i++){
                price+=list.get(i).getContractAmount();
            }
        } catch (DataAccessResourceFailureException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return price;
    }
}

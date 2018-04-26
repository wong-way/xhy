package scu.edu.cn.service;

import scu.edu.cn.dao.entity.Contract;
import scu.edu.cn.dto.DetailContract;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import java.util.List;

/**
 * @author 黄伟
 * 处理合同信息相关业务逻辑
 */
public interface ContractService {
    /**
     * 根据传入的实体，插入数据库
     *
     * @param contract 合同实体
     * @return Error对象
     */
    Error insertContract(Contract contract);

    /**
     * 根据传入的参数，更新数据库数据
     *
     * @param contract 合同的实体
     * @return Error对象
     */
    Error updateContract(Contract contract);

    /**
     * 根据传入的合同号，删除合同
     *
     * @param id 合同号
     * @return Error对象
     */
    Error deleteContract(int id);

    /**
     * 获取所有合同信息
     *
     * @return Response对象
     */
    Response<List<Contract>> getAll();

    /**
     * 根据传入的合同号，获取合同
     *
     * @param id 合同号
     * @return 合同实体
     */
    Contract getContractById(int id);

    /**
     * 批量删除合同信息
     * @param list 包含合同的list
     * @return
     */
    Error deleteContracts(Contract[] list);

    /**
     * 获取最近一个月的数据
     * @return response对象
     */
    Response<List<Contract>> getRecent();

    /**
     * 获取所有订单的总金额
     * @return
     */
    Double getAllContractPrice();

    /**
     * 获取每日订单数量
     * @return 每日成交订单数量
     */
    Response<List<DetailContract>> getEachDayDetail();

}

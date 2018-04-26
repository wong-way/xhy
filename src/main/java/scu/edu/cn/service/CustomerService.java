package scu.edu.cn.service;

import scu.edu.cn.dao.entity.CustomerInfo;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import java.util.List;

/**
 * @author 黄伟
 * 处理顾客信息相关业务逻辑
 */
public interface CustomerService {
    /**
     * 插入一条顾客信息
     *
     * @param info 顾客实体
     * @return Error对象
     */
    Error insertCustomer(CustomerInfo info);

    /**
     * 更新顾客信息
     *
     * @param info 顾客实体
     * @return Error对象
     */
    Error updateCustomer(CustomerInfo info);

    /**
     * 根据顾客id删除顾客信息
     *
     * @param id 顾客id
     * @return Error对象
     */
    Error deleteCustomerById(int id);

    /**
     * 获取所有顾客信息列表
     *
     * @return Response对象，包含List和Error
     */
    Response<List<CustomerInfo>> getAllCustomer();

    /**
     * 批量删除
     * @return
     */
    Error deleteCustomers(CustomerInfo[] list);

    /**
     *
     * @param id 顾客编号
     * @return 顾客信息
     */
    Response<CustomerInfo> getCustomer(Integer id);

}

package scu.edu.cn.service;
import scu.edu.cn.dao.entity.Oldcustomer;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import java.util.List;

/**
 * Author:韩正博
 */
public interface OldCustomerService {

    /**
     * 插入一个OldCustomer对象
     * @param oldcustomer
     * @return
     */
     Error insertOldCustomer(Oldcustomer oldcustomer);

    /**
     * 更新一个OldCustomer对象
     * @param oldcustomer
     * @return
     */
     Error updateOldCustomer(Oldcustomer oldcustomer);

    /**
     * 通过ID删除一个OldCustomer对象
     * @param customerId
     * @return
     */
     Error deleteOldCustomer(int customerId);

    /**
     * 通过ID查找一个OldCustomer对象
     * @param customerId
     * @return
     */
     Response<Oldcustomer> selectOldCustomerById(int customerId);

    /**
     * 查找所有OldCustomer对象
     * @return
     */
     List<Oldcustomer> selectAllOldCustomer();
}
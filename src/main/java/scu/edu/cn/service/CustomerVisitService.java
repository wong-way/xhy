package scu.edu.cn.service;

import scu.edu.cn.dao.entity.CustomerVisit;
import scu.edu.cn.dao.entity.CustomerVisitKey;
import scu.edu.cn.util.Error;

import java.util.List;

public interface CustomerVisitService {

    /**
     * 插入一条客户回访记录
     *
     * @param customerVisit 客户回访记录
     * @return Error对象
     */
    Error insertCustomerVisit(CustomerVisit customerVisit);

    /**
     * 更新一条客户回访记录
     *
     * @param customerVisit 客户回访记录
     * @return Error对象
     */
    Error updateCustomerVisit(CustomerVisit customerVisit);

    /**
     * 删除一条客户回访记录
     *
     * @param customerVisitKey 客户回访记录的主键
     * @return Error对象
     */
    Error deleteCustomerVisit(CustomerVisitKey customerVisitKey);

    /**
     * 列出客户回访记录
     *
     * @return 客户回访记录列表
     */
    public List<CustomerVisit> selectAllCustomerVisit();
}

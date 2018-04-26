package scu.edu.cn.dao.mapper;

import org.springframework.stereotype.Repository;
import scu.edu.cn.dao.entity.CustomerVisit;
import scu.edu.cn.dao.entity.CustomerVisitKey;

import java.util.List;

@Repository
public interface CustomerVisitMapper {
    int deleteByPrimaryKey(CustomerVisitKey key);

    int insert(CustomerVisit record);

    int insertSelective(CustomerVisit record);

    CustomerVisit selectByPrimaryKey(CustomerVisitKey key);

    int updateByPrimaryKeySelective(CustomerVisit record);

    int updateByPrimaryKeyWithBLOBs(CustomerVisit record);

    int updateByPrimaryKey(CustomerVisit record);

    List<CustomerVisit> selectAllCustomerVisit();
}
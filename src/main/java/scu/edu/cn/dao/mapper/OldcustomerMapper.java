package scu.edu.cn.dao.mapper;

import org.springframework.stereotype.Repository;
import scu.edu.cn.dao.entity.Oldcustomer;

import java.util.List;

@Repository
public interface OldcustomerMapper {
    /**
     * 通过主键删除一条老客户的信息
     * @param customerId
     * @return
     */
    int deleteByPrimaryKey(Integer customerId);

    /**
     * 插入一条老客户的信息
     * @param record
     * @return
     */
    int insert(Oldcustomer record);

    /**
     * 插入一条老客户的信息（空字段忽略）
     * @param record
     * @return
     */
    int insertSelective(Oldcustomer record);

    /**
     * 通过主键搜索一条老客户的信息
     * @param customerId
     * @return
     */
    Oldcustomer selectByPrimaryKey(Integer customerId);

    /**
     * 更新一条老客户的信息（空字段忽略）
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Oldcustomer record);

    /**
     * 通过主键更新一条老客户的信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Oldcustomer record);

    /**
     * 查找所有老客户的信息
     * @return
     */
    List<Oldcustomer> selectAllOldCustomer();
}
package scu.edu.cn.dao.mapper;

import org.springframework.stereotype.Repository;
import scu.edu.cn.dao.entity.Receipt;

import java.util.List;

@Repository
public interface ReceiptMapper {
    /**
     * 通过主键删除一条收款记录
     * @param receiptId
     * @return
     */
    int deleteByPrimaryKey(Integer receiptId);

    /**
     * 插入一条收款记录
     * @param record
     * @return
     */
    int insert(Receipt record);

    /**
     * 插入一条收款记录（空字段忽略）
     * @param record
     * @return
     */
    int insertSelective(Receipt record);

    /**
     * 通过主键查找一条收款记录
     * @param receiptId
     * @return
     */
    Receipt selectByPrimaryKey(Integer receiptId);

    /**
     * 通过主键更新一条收款记录（空字段忽略）
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Receipt record);

    /**
     * 通过主键更新一条收款记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(Receipt record);

    /**
     * 查找所有的收款记录
     * @return
     */
    List<Receipt> selectAllReceipt();
}
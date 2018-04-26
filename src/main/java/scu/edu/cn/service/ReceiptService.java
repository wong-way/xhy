package scu.edu.cn.service;

import scu.edu.cn.dao.entity.Receipt;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import java.util.List;

/**
 * Author:韩正博
 */
public interface ReceiptService {

    /**
     * 插入一条收款信息
     * @param receipt
     * @return
     */
    public Error insertReceipt(Receipt receipt);

    /**
     * 更新一条收款信息
     * @param receipt
     * @return
     */
    public Error updateReceipt(Receipt receipt);

    /**
     * 通过id删除一条收款信息
     * @param id
     * @return
     */
    public Error deleteReceiptById(int id);

    /**
     * 查询一条收款信息
     * @param id
     * @return
     */
    public Response<Receipt> selectReceptById(int id);

    /**
     * 查询所有收款信息
     * @return
     */
    public Response<List<Receipt>> selectAllReceipt();
}

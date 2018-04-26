package scu.edu.cn.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.Receipt;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml","classpath:spring-mvc.xml"})
public class ReceiptServiceTest {

    @Autowired
    ReceiptService receiptService;

    /**
     * 测试在Service层能否调用数据库插入收款信息
     * @throws Exception
     */
    @Test
    public void insertReceipt() throws Exception {
        Receipt receipt = new Receipt();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Date date =new Date();
        String receiveTime = "2016-06-08";
        receipt.setContractId(113);
        receipt.setReceiptId(1123);
        receipt.setReceivedMoney(12345);
        receipt.setRealReceivedTime(new java.sql.Date(date.getTime()));
        receiptService.insertReceipt(receipt);
    }

    /**
     * 测试在Service层能否调用数据库更新收款信息
     * @throws Exception
     */
    @Test
    public void updateReceipt() throws Exception {
        Receipt receipt = receiptService.selectReceptById(1).getData();
        receipt.setContractId(4);
        receipt.setReceivedMoney(55555);
        receiptService.updateReceipt(receipt);
    }

    /**
     * 测试在Service层能否调用数据库通过主键删除收款信息
     * @throws Exception
     */
    @Test
    public void deleteReceiptById() throws Exception {
        receiptService.deleteReceiptById(10);
    }

    /**
     * 测试在Service层能否调用数据库通过主键查找收款信息
     * @throws Exception
     */
    @Test
    public void selectReceptById() throws Exception {
        receiptService.selectReceptById(2).getData();
    }

    /**
     * 测试在Service层能否调用数据库通过查找所有收款信息
     * @throws Exception
     */
    @Test
    public void selectAllReceipt() throws Exception {
        receiptService.selectAllReceipt();
    }
}
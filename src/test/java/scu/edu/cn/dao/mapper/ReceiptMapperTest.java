package scu.edu.cn.dao.mapper;

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
public class ReceiptMapperTest {

    @Autowired
    ReceiptMapper receiptMapper;

    /**
     * 测试在DAO层能否调用数据库通过主键删除收款记录
     * @throws Exception
     */
    @Test
    public void deleteByPrimaryKey() throws Exception {
        assertEquals(1,receiptMapper.deleteByPrimaryKey(1));
    }

    /**
     * 测试在DAO层能否调用数据库插入收款记录
     * @throws Exception
     */
    @Test
    public void insert() throws Exception {
        Receipt receipt = new Receipt();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        String receiveTime = "2016-6-6";
        receipt.setContractId(1);
        receipt.setReceiptId(1);
        receipt.setReceivedMoney(12345);
        receipt.setRealReceivedTime(format.parse(receiveTime));
        receiptMapper.insert(receipt);
    }

    /**
     * 测试在DAO层能否调用数据库插入收款记录（空字段忽略）
     * @throws Exception
     */
    @Test
    public void insertSelective() throws Exception {
        Receipt receipt = new Receipt();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Date date =new Date();
        String receiveTime = "2016-06-08";
        receipt.setContractId(11);
        receipt.setReceiptId(112);
        receipt.setReceivedMoney(12345);
        receipt.setRealReceivedTime(new java.sql.Date(date.getTime()));
        receiptMapper.insert(receipt);
    }

    /**
     * 测试在DAO层能否调用数据库通过主键查找收款记录
     * @throws Exception
     */
    @Test
    public void selectByPrimaryKey() throws Exception {
        receiptMapper.selectByPrimaryKey(1);
    }

    /**
     * 测试在DAO层能否调用数据库通过主键更新收款记录（空字段忽略）
     * @throws Exception
     */
    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        Receipt receipt = receiptMapper.selectByPrimaryKey(1);
        receipt.setContractId(4);
        receipt.setReceivedMoney(55555);
        receiptMapper.updateByPrimaryKey(receipt);
    }

    /**
     * 测试在DAO层能否调用数据库通过主键更新收款记录
     * @throws Exception
     */
    @Test
    public void updateByPrimaryKey() throws Exception {
        Receipt receipt = receiptMapper.selectByPrimaryKey(1);
        receipt.setContractId(3);
        receiptMapper.updateByPrimaryKey(receipt);
    }

    /**
     * 测试在DAO层能否调用数据库查找收款记录
     * @throws Exception
     */
    @Test
    public void selectAllReceipt() throws Exception{
        receiptMapper.selectAllReceipt();
    }

}
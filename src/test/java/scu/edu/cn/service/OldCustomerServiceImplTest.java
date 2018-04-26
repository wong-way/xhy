package scu.edu.cn.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.Oldcustomer;
import scu.edu.cn.dao.mapper.OldcustomerMapper;

import java.text.SimpleDateFormat;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml","classpath:spring-mvc.xml"})
public class OldCustomerServiceImplTest {

    @Autowired
    OldCustomerService oldCustomerService;

    /**
     * 测试在Service层能否调用数据库插入收款信息
     * @throws Exception
     */
    @Test
    public void insertOldCustomer() throws Exception {
        Oldcustomer oldcustomer = new Oldcustomer();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        String contractTime = "2017-1-1";
        oldcustomer.setBabyBasicInformation("情况良好");
        oldcustomer.setCustomerId(35);
        oldcustomer.setRequiredRequirements("育婴");
        oldcustomer.setContractTime(format.parse(contractTime));
        assertEquals(1,oldCustomerService.insertOldCustomer(oldcustomer));

    }

    /**
     * 测试在Service层能否调用数据库更新收款信息
     * @throws Exception
     */
    @Test
    public void updateOldCustomer() throws Exception {
        Oldcustomer oldcustomer = oldCustomerService.selectOldCustomerById(35).getData();
        oldcustomer.setBabyBasicInformation("不怎么样");
        oldCustomerService.updateOldCustomer(oldcustomer);
    }

    /**
     * 测试在Service层能否调用数据库通过主键删除收款信息
     * @throws Exception
     */
    @Test
    public void deleteOldCustomer() throws Exception {
        oldCustomerService.deleteOldCustomer(35);
    }

    /**
     * 测试在Service层能否调用数据库通过主键查找收款信息
     * @throws Exception
     */
    @Test
    public void selectOldCustomerById() throws Exception {
        oldCustomerService.selectOldCustomerById(1).getData();
    }

    /**
     * 测试在Service层能否调用数据库通过查找所有收款信息
     * @throws Exception
     */
    @Test
    public void selectAllOldCustomer() throws Exception {
        oldCustomerService.selectAllOldCustomer();
    }

}
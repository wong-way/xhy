package scu.edu.cn.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.CustomerInfo;

import java.sql.Date;

import static org.junit.Assert.*;

/**
 * @author 黄伟
 * 测试顾客相关操作
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml", "classpath:spring-mvc.xml"})
public class CustomerInfoMapperTest {
    @Autowired
    CustomerInfoMapper mapper;
    private Logger logger = LoggerFactory.getLogger(CustomerInfoMapperTest.class);

    /**
     * 插入操作
     * @throws Exception
     */
    @Test
    public void insert() throws Exception {
        java.util.Date date = new java.util.Date();
        CustomerInfo info = new CustomerInfo();
        info.setCustomerAddress("成都市金牛区");
        info.setCustomerDemandDate(new Date(date.getTime()));
        info.setCustomerDemandService("育婴师");
        info.setCustomerExpectedDate(new Date(date.getTime() + 12));
        info.setCustomerId(1);
        info.setCustomerName("张三");
        info.setCustomerPhone("133-9640-0321");
        info.setStaffId(1001);
        info.setYysId(12);
        mapper.insert(info);
    }

    /**
     * 插入操作
     * @throws Exception
     */
    @Test
    public void insertSelective() throws Exception {
        java.util.Date date = new java.util.Date();
        CustomerInfo info = new CustomerInfo();
        info.setCustomerAddress("成都市金牛区");
        info.setCustomerDemandDate(new Date(date.getTime()));
        info.setCustomerDemandService("育婴师");
        info.setCustomerExpectedDate(new Date(date.getTime() + 12));

        info.setCustomerName("李四");
        info.setCustomerPhone("133-9640-0321");
        info.setStaffId(1001);
        info.setYysId(12);
        mapper.insert(info);
    }

    /**
     * 根据主键选择对象
     * @throws Exception
     */
    @Test
    public void selectByPrimaryKey() throws Exception {

        logger.info(mapper.selectByPrimaryKey(1).getCustomerDemandDate().toString());
    }

    /**
     * 根据主键更新
     * @throws Exception
     */
    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        java.util.Date date = new java.util.Date();
        CustomerInfo info = new CustomerInfo();
        info.setCustomerAddress("成都市金牛区");
        info.setCustomerDemandDate(new Date(date.getTime()));
        info.setCustomerDemandService("育婴师");
        info.setCustomerExpectedDate(new Date(date.getTime() + 12));

        info.setCustomerName("李四憨包");

        info.setStaffId(1001);
        info.setYysId(12);
        mapper.updateByPrimaryKey(info);
    }

    /**
     * 根据主键更新数据库
     * @throws Exception
     */
    @Test
    public void updateByPrimaryKey() throws Exception {
        java.util.Date date = new java.util.Date();
        CustomerInfo info = new CustomerInfo();
        info.setCustomerAddress("成都市金牛区");
        info.setCustomerDemandDate(new Date(date.getTime()));
        info.setCustomerDemandService("育婴师");
        info.setCustomerExpectedDate(new Date(date.getTime() + 12));
        info.setCustomerId(2);
        info.setCustomerName("李四憨包猪");
        info.setCustomerPhone("133-9640-0321");
        info.setStaffId(1001);
        info.setYysId(12);
        mapper.updateByPrimaryKey(info);
    }

    /**
     * 根据主键删除数据
     * @throws Exception
     */
    @Test
    public void deleteByPrimaryKey() throws Exception {
        mapper.deleteByPrimaryKey(2);
    }


}
package scu.edu.cn.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.CustomerInfo;
import scu.edu.cn.util.Response;

/**
 * @author 黄伟
 * 测试顾客相关业务逻辑
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml", "classpath:spring-mvc.xml"})
public class CustomerServiceImplTest {
    @Autowired
    CustomerService service;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 测试插入顾客
     *
     * @throws Exception
     */
    @Test
    public void insertCustomer() throws Exception {
        java.util.Date date = new java.util.Date();
        CustomerInfo info = new CustomerInfo();
        info.setCustomerAddress("成都市金牛区");
        info.setCustomerDemandDate(new java.sql.Date(date.getTime()));
        info.setCustomerDemandService("育婴师");
        info.setCustomerExpectedDate(new java.sql.Date(date.getTime() + 12));

        info.setCustomerName("李四");
        info.setCustomerPhone("133-9640-0321");
        info.setStaffId(1001);
        info.setYysId(12);
        service.insertCustomer(info);
    }

    /**
     * 测试更新顾客
     * @throws Exception
     */

    @Test
    public void updateCustomer() throws Exception {
        java.util.Date date = new java.util.Date();
        CustomerInfo info = new CustomerInfo();
        info.setCustomerAddress("成都市双流县");
        info.setCustomerDemandDate(new java.sql.Date(date.getTime()));
        info.setCustomerDemandService("育婴师");
        info.setCustomerExpectedDate(new java.sql.Date(date.getTime() + 12));
        info.setCustomerName("李四1");
        info.setCustomerPhone("133-9640-0321");
        info.setStaffId(1002);
        info.setYysId(12);
        service.updateCustomer(info).toString();
    }

    /**
     * 测试获取所有顾客
     * @throws Exception
     */
    @Test
    public void getAllCustomer() throws Exception {
        Response response = service.getAllCustomer();
        logger.info(response.getError().toString());
        logger.info(response.getData().toString());

    }

    /**
     * 测试根据id来查用户
     * @throws Exception
     */
    @Test
    public void deleteCustomerById() throws Exception {
        service.deleteCustomerById(2);
    }


}
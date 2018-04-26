package scu.edu.cn.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.Record;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import java.sql.Date;

/**
 * @author 黄伟
 * 测试跟进记录业务逻辑
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml", "classpath:spring-mvc.xml"})
public class RecordServiceImplTest {
    @Autowired
    RecordService service;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 测试插入数据
     * @throws Exception
     */
    @Test
    public void insertRecord() throws Exception {
        Record record = new Record();
        record.setCustomerId(1001);
        record.setRecordContent("客户交流沟通");
        record.setRecordDate(new Date(new java.util.Date().getTime()));
        record.setRecordId(1);
        record.setStaffId(110);
        Error error = service.insertRecord(record);
        logger.info(error.getMessage());
    }

    /**
     * 测试更新数据
     * @throws Exception
     */
    @Test
    public void updateRecord() throws Exception {
        Record record = new Record();
        record.setCustomerId(1001);
        record.setRecordContent("客户交流沟通333333");
        record.setRecordDate(new Date(new java.util.Date().getTime()));
        record.setRecordId(1);
        record.setStaffId(110);
        Error error =service.updateRecord(record);
        logger.info(error.getMessage());
    }

    /**
     * 测试删除数据
     * @throws Exception
     */
    @Test
    public void deleteRecord() throws Exception {
        Error error = service.deleteRecord(1);
        logger.info(error.getMessage());
    }

    /**
     * 测试获取数据
     * @throws Exception
     */
    @Test
    public void getAllRecord() throws Exception {
        Response response = service.getAllRecord();
        logger.info(response.getError().getMessage());
        logger.info(response.getData().toString());

    }

    /**
     * 测试获取数据
     * @throws Exception
     */
    @Test
    public void getRecordById() throws Exception {
        Error error = service.deleteRecord(1);
        logger.info(error.getMessage());
    }

}
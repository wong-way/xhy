package scu.edu.cn.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.Record;

import java.sql.Date;

import static org.junit.Assert.*;

/**
 * @author 黄伟
 * 测试记录操作
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml", "classpath:spring-mvc.xml"})
public class RecordMapperTest {


    @Autowired
    RecordMapper mapper;
    private Logger logger = LoggerFactory.getLogger(RecordMapperTest.class);

    /**
     * 根据主键删除
     * @throws Exception
     */
    @Test
    public void deleteByPrimaryKey() throws Exception {
        mapper.deleteByPrimaryKey(1);
    }

    /**
     * 获取所有数据
     * @throws Exception
     */
    @Test
    public void selectAll() throws Exception {
        logger.info(mapper.selectAll().get(0).getRecordContent().toString());
    }

    /**
     * 插入数据
     * @throws Exception
     */
    @Test
    public void insert() throws Exception {
        Record record = new Record();
        record.setCustomerId(1001);
        record.setRecordContent("客户交流沟通");
        record.setRecordDate(new Date(new java.util.Date().getTime()));
        record.setRecordId(1);
        record.setStaffId(110);
        mapper.insert(record);
    }

    /**
     * 插入数据
     * @throws Exception
     */
    @Test
    public void insertSelective() throws Exception {
        Record record = new Record();

        record.setRecordContent("客户交流沟通");
        record.setRecordDate(new Date(new java.util.Date().getTime()));

        record.setStaffId(110);
        mapper.insert(record);
    }

    /**
     * 选取数据
     * @throws Exception
     */
    @Test
    public void selectByPrimaryKey() throws Exception {
        logger.info(mapper.selectByPrimaryKey(1).toString());

    }

    /**
     * 更新数据
     * @throws Exception
     */
    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        Record record = new Record();
        record.setCustomerId(1001);
        record.setRecordContent("客户交流沟通更新");
        record.setRecordDate(new Date(new java.util.Date().getTime()));
        record.setRecordId(1);
        record.setStaffId(110);
        mapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 更新数据
     * @throws Exception
     */
    @Test
    public void updateByPrimaryKeyWithBLOBs() throws Exception {
        Record record = new Record();
        record.setCustomerId(1001);
        record.setRecordContent("客户交流沟通更新aaaa");
        record.setRecordDate(new Date(new java.util.Date().getTime()));
        record.setRecordId(1);
        record.setStaffId(110);
        mapper.updateByPrimaryKeyWithBLOBs(record);
    }

    /**
     * 根据主键更新数据
     * @throws Exception
     */
    @Test
    public void updateByPrimaryKey() throws Exception {
        Record record = new Record();

        record.setStaffId(2);
        record.setRecordId(1);
        mapper.updateByPrimaryKeySelective(record);
    }

}
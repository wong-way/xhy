package scu.edu.cn.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.PromotionRecord;


import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml","classpath:spring-mvc.xml"})

public class PromotionRecordServiceImplTest {

    @Autowired
    PromotionRecordService service;

    @Autowired
    PromotionRecord promotionRecord;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String time = "2017-02-14";

    private Logger logger = LoggerFactory.getLogger(PromotionRecordServiceImplTest.class);

    /**
     * 测试插入晋升记录
     *
     * @throws Exception
     */
    @Test
    public void insertPromotionRecord() throws Exception {
        promotionRecord.setYysId(1);
        promotionRecord.setPromotionRecordId(5);
        promotionRecord.setYysCurrentLevel("A");
        promotionRecord.setYysPreviousLevel("B");
        promotionRecord.setYysPromotionTime(format.parse(time));
        service.insertPromotionRecord(promotionRecord);
        logger.info(promotionRecord.toString());
    }

    /**
     * 测试更新晋升记录
     *
     * @throws Exception
     */
    @Test
    public void updatePromotionRecord() throws Exception {
        promotionRecord.setYysId(2);
        promotionRecord.setPromotionRecordId(5);
        service.updatePromotionRecord(promotionRecord);
        logger.info(promotionRecord.toString());
    }

    /**
     * 测试删除晋升记录
     *
     * @throws Exception
     */
    @Test
    public void deletePromotionRecord() throws Exception {
        service.deletePromotionRecordById(5);
    }

    /**
     * 获取晋升记录列表
     *
     * @throws Exception
     */
    @Test
    public void selectAllPromotionRecord() throws Exception {
        List<PromotionRecord> list = service.selectAllPromotionRecord();
        logger.info(String.valueOf(list.size()));
    }

    /**
     * 获取晋升记录
     *
     * @throws Exception
     */
    @Test
    public void selectPromotionRecord() throws Exception {
        promotionRecord = service.selectPromotionRecordById(2);
        logger.info(promotionRecord.toString());
    }

}
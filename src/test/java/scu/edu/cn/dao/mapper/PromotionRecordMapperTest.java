package scu.edu.cn.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.PromotionRecord;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml","classpath:spring-mvc.xml"})

public class PromotionRecordMapperTest {

    @Autowired
    PromotionRecord promotionRecord;

    @Autowired
    PromotionRecordMapper promotionRecordMapper;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String time = "2017-02-14";

    /**
     *测试删除晋升记录根据晋升记录Id
     *
     * @throws Exception
     */
    @Test
    public void deleteByPrimaryKey() throws Exception {
      assertEquals(1,promotionRecordMapper.deleteByPrimaryKey(1));
    }

    /**
     * 测试插入晋升记录信息
     *
     * @throws Exception
     */
    @Test
    public void insert() throws Exception {
        promotionRecord.setYysId(1);
        promotionRecord.setPromotionRecordId(1);
        promotionRecord.setYysCurrentLevel("A");
        promotionRecord.setYysPreviousLevel("B");
        promotionRecord.setYysPromotionTime(format.parse(time));
        promotionRecordMapper.insert(promotionRecord);
        System.out.println(promotionRecord.toString());
    }

    /**
     * 测试插入部分晋升记录信息
     *
     * @throws Exception
     */
    @Test
    public void insertSelective() throws Exception {
        promotionRecord.setYysId(2);
        promotionRecord.setPromotionRecordId(2);
        promotionRecord.setYysPromotionTime(format.parse(time));
        promotionRecordMapper.insertSelective(promotionRecord);
        System.out.println(promotionRecord.toString());
    }

    /**
     * 测试获取晋升记录信息根据晋升记录Id
     *
     * @throws Exception
     */
    @Test
    public void selectByPrimaryKey() throws Exception {
        promotionRecord = promotionRecordMapper.selectByPrimaryKey(2);
        System.out.println(promotionRecord.getYysId());
        System.out.println(promotionRecord.getPromotionRecordId());
    }

    /**
     *测试更新晋升记录部分信息
     *
     * @throws Exception
     */
    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        promotionRecord = promotionRecordMapper.selectByPrimaryKey(2);
        promotionRecord.setYysId(3);
        promotionRecordMapper.updateByPrimaryKeySelective(promotionRecord);
        System.out.println(promotionRecord.toString());
    }

    /**
     *测试更新晋升记录信息
     *
     * @throws Exception
     */
    @Test
    public void updateByPrimaryKey() throws Exception {
        promotionRecord = promotionRecordMapper.selectByPrimaryKey(2);
        promotionRecord.setYysId(4);
        promotionRecordMapper.updateByPrimaryKey(promotionRecord);
        System.out.println(promotionRecord.toString());
    }

}
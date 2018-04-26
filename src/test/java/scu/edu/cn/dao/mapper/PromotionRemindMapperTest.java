package scu.edu.cn.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.PromotionRemind;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml","classpath:spring-mvc.xml"})

public class PromotionRemindMapperTest {

    @Autowired
    PromotionRemind promotionRemind;

    @Autowired
    PromotionRemindMapper promotionRemindMapper;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String time = "2017-02-14";

    /**
     * 测试删除晋升提醒根据晋升提醒Id
     *
     * @throws Exception
     */
    @Test
    public void deleteByPrimaryKey() throws Exception {
        assertEquals(1,promotionRemindMapper.deleteByPrimaryKey(1));
    }

    /**
     *测试插入晋升提醒信息
     *
     * @throws Exception
     */
    @Test
    public void insert() throws Exception {
        promotionRemind.setYysId(1);
        promotionRemind.setPromotionRemindId(1);
        promotionRemind.setYysCurrentLevel("A");
        promotionRemind.setYysCurrentLevel("B");
        promotionRemind.setYysPromotionalTime(format.parse(time));
        promotionRemindMapper.insert(promotionRemind);
        System.out.println(promotionRemind.toString());
    }

    /**
     * 测试插入部分晋升提醒信息
     *
     * @throws Exception
     */
    @Test
    public void insertSelective() throws Exception {
        promotionRemind.setYysId(2);
        promotionRemind.setPromotionRemindId(2);
        promotionRemind.setYysPromotionalTime(format.parse(time));
        promotionRemindMapper.insertSelective(promotionRemind);
        System.out.println(promotionRemind.toString());
    }

    /**
     *测试获取晋升提醒信息根据晋升提醒Id
     *
     * @throws Exception
     */
    @Test
    public void selectByPrimaryKey() throws Exception {
        promotionRemind = promotionRemindMapper.selectByPrimaryKey(2);
        System.out.println(promotionRemind.getYysId());
        System.out.println(promotionRemind.getPromotionRemindId());
    }

    /**
     * 测试更新晋升提醒部分信息
     *
     * @throws Exception
     */
    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        promotionRemind = promotionRemindMapper.selectByPrimaryKey(2);
        promotionRemind.setYysId(3);
        promotionRemindMapper.updateByPrimaryKeySelective(promotionRemind);
        System.out.println(promotionRemind.toString());
    }

    /**
     *测试更新晋升提醒信息
     *
     * @throws Exception
     */
    @Test
    public void updateByPrimaryKey() throws Exception {
        promotionRemind = promotionRemindMapper.selectByPrimaryKey(2);
        promotionRemind.setYysId(4);
        promotionRemindMapper.updateByPrimaryKey(promotionRemind);
        System.out.println(promotionRemind.toString());
    }

}
package scu.edu.cn.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.PromotionRemind;


import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml","classpath:spring-mvc.xml"})

public class PromotionRemindServiceImplTest {

    @Autowired
    PromotionRemindService service;

    @Autowired
    PromotionRemind promotionRemind;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String time = "2017-02-14";

    private Logger logger = LoggerFactory.getLogger(PromotionRemindServiceImplTest.class);

    /**
     * 测试插入晋升提醒
     *
     * @throws Exception
     */
    @Test
    public void insertPromotionRemind() throws Exception {
        promotionRemind.setYysId(1);
        promotionRemind.setPromotionRemindId(5);
        promotionRemind.setYysCurrentLevel("A");
        promotionRemind.setYysNextLevel("B");
        promotionRemind.setYysPromotionalTime(format.parse(time));
        service.insertPromotionRemind(promotionRemind);
        logger.info(promotionRemind.toString());
    }

    /**
     * 测试更新晋升提醒
     *
     * @throws Exception
     */
    @Test
    public void updatePromotionRemind() throws Exception {
        promotionRemind.setYysId(2);
        promotionRemind.setPromotionRemindId(5);
        service.updatePromotionRemind(promotionRemind);
        logger.info(promotionRemind.toString());
    }

    /**
     * 测试删除晋升提醒
     *
     * @throws Exception
     */
    @Test
    public void deletePromotionRemind() throws Exception {
        service.deletePromotionRemindById(5);
    }


    /**
     * 获取晋升提醒列表
     *
     * @throws Exception
     */
    @Test
    public void selectAllPromotionRemind() throws Exception {
        List<PromotionRemind> list = service.selectAllPromotionRemind();
        logger.info(String.valueOf(list.size()));
    }

    /**
     * 获取晋升提醒
     *
     * @throws Exception
     */
    @Test
    public void selectPromotionRemind() throws Exception {
        promotionRemind = service.selectPromotionRemindById(2);
        logger.info(promotionRemind.toString());
    }

}
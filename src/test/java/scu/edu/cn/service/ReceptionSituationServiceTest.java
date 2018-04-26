package scu.edu.cn.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.ReceptionSituation;

import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml", "classpath:spring-mvc.xml"})
public class ReceptionSituationServiceTest {

    @Autowired
    ReceptionSituationService receptionSituationService;

    /**
     * 测试在Service层能否调用数据库插入接待情况
     * @throws Exception
     */
    @Test
    public void insertReceptionSituation() throws Exception {
        ReceptionSituation receptionSituation = new ReceptionSituation();
        Date date = new Date();
        receptionSituation.setCustomerAddress("成都");
        receptionSituation.setCustomerContact("12345678");
        receptionSituation.setCustomerName("张三");
        receptionSituation.setMode(1);
        receptionSituation.setRequiredRequirements("育婴");
        receptionSituation.setStaffId(123);
        receptionSituation.setRequiredTime(new java.sql.Date(date.getTime()));
        receptionSituation.setReceptionId(55);
        receptionSituationService.insertReceptionSituation(receptionSituation);
    }

    /**
     * 测试在Service层能否调用数据库更新接待情况
     * @throws Exception
     */
    @Test
    public void updateReceptionSituation() throws Exception {
        ReceptionSituation receptionSituation= receptionSituationService.selectReceptionSituationById(55).getData();
        receptionSituation.setMode(2);
        receptionSituationService.updateReceptionSituation(receptionSituation);
    }

    /**
     * 测试在Service层能否调用数据库通过主键删除接待情况
     * @throws Exception
     */
    @Test
    public void deleteReceptionSituationById() throws Exception {
        receptionSituationService.deleteReceptionSituationById(3);
    }

    /**
     * 测试在Service层能否调用数据库通过主键查找接待情况
     * @throws Exception
     */
    @Test
    public void selectReceptionSituationById() throws Exception {
        receptionSituationService.selectReceptionSituationById(2).getData();
        System.out.println(receptionSituationService.selectReceptionSituationById(2).getData().getReceptionId());
    }

    /**
     * 测试在Service层能否调用数据库通过查找所有接待情况
     * @throws Exception
     */
    @Test
    public void selectAllReceptionSituation() throws Exception {
        receptionSituationService.selectAllReceptionSituation();
    }

}
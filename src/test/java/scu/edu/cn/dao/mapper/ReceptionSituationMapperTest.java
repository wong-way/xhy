package scu.edu.cn.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.ReceptionSituation;

import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml","classpath:spring-mvc.xml"})
public class ReceptionSituationMapperTest {


    @Autowired
    ReceptionSituationMapper receptionSituationMapper;


    /**
     * 测试在DAO层能否调用数据库通过主键删除接待情况
     * @throws Exception
     */
    @Test
    public void deleteByPrimaryKey() throws Exception {
        assertEquals(1,receptionSituationMapper.deleteByPrimaryKey(1));
    }

    /**
     * 测试在DAO层能否调用数据库插入接待情况
     * @throws Exception
     */
    @Test
    public void insert() throws Exception {
        ReceptionSituation receptionSituation = new ReceptionSituation();
        Date date = new Date();
        receptionSituation.setContent("123456");
        receptionSituation.setCustomerAddress("成都");
        receptionSituation.setCustomerContact("12345678");
        receptionSituation.setCustomerName("张三");
        receptionSituation.setMode(1);
        receptionSituation.setRequiredRequirements("育婴");
        receptionSituation.setStaffId(123);
        receptionSituation.setRequiredTime(new java.sql.Date(date.getTime()));
        receptionSituation.setReceptionId(1);
        receptionSituationMapper.insert(receptionSituation);
    }

    /**
     * 测试在DAO层能否调用数据库插入接待情况（空字段忽略）
     * @throws Exception
     */
    @Test
    public void insertSelective() throws Exception {
        ReceptionSituation receptionSituation = new ReceptionSituation();
        Date date = new Date();
        receptionSituation.setCustomerAddress("成都");
        receptionSituation.setCustomerContact("12345678");
        receptionSituation.setCustomerName("张三");
        receptionSituation.setMode(1);
        receptionSituation.setRequiredRequirements("育婴");
        receptionSituation.setStaffId(123);
        receptionSituation.setRequiredTime(new java.sql.Date(date.getTime()));
        receptionSituation.setReceptionId(3);
        receptionSituationMapper.insertSelective(receptionSituation);
    }

    /**
     * 测试在DAO层能否调用数据库通过主键查找接待情况
     * @throws Exception
     */
    @Test
    public void selectByPrimaryKey() throws Exception {
        receptionSituationMapper.selectByPrimaryKey(2);
        System.out.println(receptionSituationMapper.selectByPrimaryKey(2));
    }

    /**
     * 测试在DAO层能否调用数据库通过主键更新接待情况（空字段忽略）
     * @throws Exception
     */
    @Test
    public void updateByPrimaryKeySelective() throws Exception {
       ReceptionSituation receptionSituation= receptionSituationMapper.selectByPrimaryKey(1);
       receptionSituation.setStaffId(222);
       receptionSituationMapper.updateByPrimaryKeySelective(receptionSituation);
    }

    /**
     * 测试在DAO层能否调用数据库通过主键更新接待情况
     * @throws Exception
     */
    @Test
    public void updateByPrimaryKey() throws Exception {
        ReceptionSituation receptionSituation= receptionSituationMapper.selectByPrimaryKey(1);
        receptionSituation.setStaffId(223);
        receptionSituationMapper.updateByPrimaryKey(receptionSituation);
    }

    /**
     * 测试在DAO层能否调用数据库查找接待情况
     * @throws Exception
     */
    @Test
    public void selectAllReceptionSituation() throws Exception{
        receptionSituationMapper.selectAllReceptionSituation();
        System.out.println(receptionSituationMapper.selectAllReceptionSituation());
    }

}
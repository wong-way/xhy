package scu.edu.cn.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.Oldcustomer;

import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml","classpath:spring-mvc.xml"})
public class OldcustomerMapperTest {

    @Autowired
    OldcustomerMapper oldcustomerMapper;


    /**
     * 测试在DAO层能否调用数据库通过主键删除老客户记录
     * @throws Exception
     */
    @Test
    public void deleteByPrimaryKey() throws Exception {
        assertEquals(1,oldcustomerMapper.selectByPrimaryKey(1));
    }

    /**
     * 测试在DAO层能否调用数据库插入老客户记录
     * @throws Exception
     */
    @Test
    public void insert() throws Exception {
        Oldcustomer oldcustomer = new Oldcustomer();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        String contractTime = "2017-1-1";
        oldcustomer.setBabyBasicInformation("情况良好");
        oldcustomer.setCustomerId(3);
        oldcustomer.setRequiredRequirements("育婴");
        oldcustomer.setContractTime(format.parse(contractTime));
        assertEquals(1,oldcustomerMapper.insert(oldcustomer));
    }

    /**
     * 测试在DAO层能否调用数据库插入老客户记录（空字段忽略）
     * @throws Exception
     */
    @Test
    public void insertSelective() throws Exception {
        Oldcustomer oldcustomer = new Oldcustomer();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        String contractTime = "2017-1-1";
        oldcustomer.setCustomerId(2);
        oldcustomer.setRequiredRequirements("育婴");
        oldcustomer.setContractTime(format.parse(contractTime));
        assertEquals(1,oldcustomerMapper.insert(oldcustomer));
    }

    /**
     * 测试在DAO层能否调用数据库通过主键查找老客户记录
     * @throws Exception
     */
    @Test
    public void selectByPrimaryKey() throws Exception {
        oldcustomerMapper.selectByPrimaryKey(1);
        System.out.println(oldcustomerMapper.selectByPrimaryKey(1));
    }

    /**
     * 测试在DAO层能否调用数据库通过主键更新老客户记录（空字段忽略）
     * @throws Exception
     */
    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Oldcustomer oldcustomer = new Oldcustomer();
        String contractTime = "2017-2-2";
        oldcustomer.setCustomerId(3);
        oldcustomer.setContractTime(format.parse(contractTime));
        oldcustomer.setRequiredRequirements("月嫂");
        oldcustomerMapper.updateByPrimaryKeySelective(oldcustomer);
    }

    /**
     * 测试在DAO层能否调用数据库通过主键更新老客户记录
     * @throws Exception
     */
    @Test
    public void updateByPrimaryKey() throws Exception {
        SimpleDateFormat format1 = new SimpleDateFormat("YYYY-MM-DD");
        Oldcustomer oldcustomer = new Oldcustomer();
        String contractTime = "2017-2-2";
        oldcustomer.setCustomerId(2);
        oldcustomer.setContractTime(format1.parse(contractTime));
        oldcustomer.setBabyBasicInformation("不错");
        oldcustomer.setRequiredRequirements("月嫂");
        oldcustomerMapper.updateByPrimaryKeySelective(oldcustomer);

    }

    /**
     * 测试在DAO层能否调用数据库查找老客户记录
     * @throws Exception
     */
    @Test
    public void selectAllOldCustomer() throws Exception{
       List<Oldcustomer> list= oldcustomerMapper.selectAllOldCustomer();
        System.out.println(list);
    }

}
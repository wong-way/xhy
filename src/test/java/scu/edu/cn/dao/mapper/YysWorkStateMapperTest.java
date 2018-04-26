package scu.edu.cn.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.YysInfo;
import scu.edu.cn.dao.entity.YysWorkState;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml","classpath:spring-mvc.xml"})
public class YysWorkStateMapperTest {

    @Autowired
    YysWorkStateMapper yysWorkStateMapper;

    @Autowired
    YysInfoMapper yysInfoMapper;


    /**
     * 测试在DAO层能否调用数据库通过主键删除育婴师工作状态记录
     * @throws Exception
     */
    @Test
    public void deleteByPrimaryKey() throws Exception {
        assertEquals(1,yysWorkStateMapper.deleteByPrimaryKey(1));
    }

    /**
     * 测试在DAO层能否调用数据库插入育婴师工作状态记录
     * @throws Exception
     */
    @Test
    public void insert() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        YysWorkState yysWorkState = new YysWorkState();
        String starttime = "2017-02-14";
        String endtime = "2018-2-14";
        yysWorkState.setYysId(1);
        yysWorkState.setCustomerId(1);
        yysWorkState.setStartTime(format.parse(starttime));
        yysWorkState.setEndTime(format.parse(endtime));
        yysWorkState.setWorkPlace("chengdu");
        yysWorkState.setWorkState(true);
        yysWorkStateMapper.insert(yysWorkState);
        System.out.println(yysWorkState.toString());
        //assertEquals(1,yysWorkStateMapper.insert(yysWorkState));
    }

    /**
     * 测试在DAO层能否调用数据库插入育婴师工作状态记录（空字段忽略）
     * @throws Exception
     */
    @Test
    public void insertSelective() throws Exception {
        YysWorkState yysWorkState = new YysWorkState();
        yysWorkState.setYysId(2);
        yysWorkState.setCustomerId(2);
        yysWorkState.setWorkPlace("chengdu");
        yysWorkState.setWorkState(true);


        assertEquals(1,yysWorkStateMapper.insertSelective(yysWorkState));
    }

    /**
     * 测试在DAO层能否调用数据库通过主键查找育婴师工作状态记录
     * @throws Exception
     */
    @Test
    public void selectByPrimaryKey() throws Exception {
        YysWorkState yysWorkState = yysWorkStateMapper.selectByPrimaryKey(1);

        System.out.println(yysWorkState.getYysId());
        System.out.println(yysWorkState.getCustomerId());
        System.out.println(yysWorkState.getStartTime());
        System.out.println(yysWorkState.getEndTime());

    }

    /**
     * 测试在DAO层能否调用数据库通过主键更新育婴师工作状态记录（空字段忽略）
     * @throws Exception
     */
    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        YysWorkState yysWorkState = yysWorkStateMapper.selectByPrimaryKey(2);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String startTime = "2006-1-2";
        String endTime ="2017-1-1";
        yysWorkState.setCustomerId(2);
        yysWorkState.setStartTime(format.parse(startTime));
        yysWorkState.setYysId(2);
        yysWorkState.setWorkPlace("chengdu");
        yysWorkState.setEndTime(format.parse(endTime));
        yysWorkState.setWorkState(false);
        assertEquals(1,yysWorkStateMapper.updateByPrimaryKey(yysWorkState));
    }

    /**
     * 测试在DAO层能否调用数据库通过主键更新育婴师工作状态记录
     * @throws Exception
     */
    @Test
    public void updateByPrimaryKey() throws Exception {
        YysWorkState yysWorkState = yysWorkStateMapper.selectByPrimaryKey(1);
        yysWorkState.setCustomerId(2);
        assertEquals(1,yysWorkStateMapper.updateByPrimaryKey(yysWorkState));
    }

    /**
     * 测试在DAO层能否调用数据库查找育婴师工作状态记录
     * @throws Exception
     */
    @Test
    public void selectAllYysWorkState() throws Exception{
        yysWorkStateMapper.selectAllYysWorkState();
    }

}
package scu.edu.cn.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.YysWorkState;

import java.text.SimpleDateFormat;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml","classpath:spring-mvc.xml"})
public class YysWorkStateServiceTest {

    @Autowired
    YysWorkStateService yysWorkStateService;

    /**
     * 测试在Service层能否调用数据库插入育婴师工作状态记录
     * @throws Exception
     */
    @Test
    public void insertYysWorkState() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        YysWorkState yysWorkState = new YysWorkState();
        String starttime = "2017-02-14";
        String endtime = "2018-2-14";
        yysWorkState.setYysId(34);
        yysWorkState.setCustomerId(34);
        yysWorkState.setStartTime(format.parse(starttime));
        yysWorkState.setEndTime(format.parse(endtime));
        yysWorkState.setWorkPlace("chengdu");
        yysWorkState.setWorkState(true);
        yysWorkStateService.insertYysWorkState(yysWorkState);
        System.out.println(yysWorkState.toString());
        //assertEquals(1,yysWorkStateMapper.insert(yysWorkState));
    }

    /**
     * 测试在Service层能否调用数据库通过主键查找育婴师工作状态记录
     * @throws Exception
     */
    @Test
    public void selectYysWorkStateById() throws Exception {
        YysWorkState yysWorkState = new YysWorkState();
        yysWorkState=yysWorkStateService.selectYysWorkStateById(34).getData();
        System.out.println(yysWorkState.getCustomerId());
    }

    /**
     *  测试在Service层能否调用数据库更新育婴师工作状态记录
     * @throws Exception
     */
    @Test
    public void updateYysWorkState() throws Exception {
        YysWorkState yysWorkState = yysWorkStateService.selectYysWorkStateById(34).getData();
        yysWorkState.setWorkPlace("伦敦");
        yysWorkStateService.updateYysWorkState(yysWorkState);
    }

    /**
     *  测试在Service层能否调用数据库通过主键删除育婴师工作状态记录
     * @throws Exception
     */
    @Test
    public void deleteYysWorkStateById() throws Exception {
        yysWorkStateService.deleteYysWorkStateById(33);
    }

    /**
     *  测试在Service层能否调用数据库通过查找所有育婴师工作状态记录
     * @throws Exception
     */
    @Test
    public void selectAllYysWorkState() throws Exception {
        yysWorkStateService.selectAllYysWorkState().getData();
    }

}
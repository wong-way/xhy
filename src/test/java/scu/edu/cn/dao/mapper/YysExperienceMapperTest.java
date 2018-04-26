package scu.edu.cn.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.YysExperience;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml","classpath:spring-mvc.xml"})
public class YysExperienceMapperTest {
    @Autowired
    YysExperienceMapper mapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {
        int row = mapper.deleteByPrimaryKey(2);
        System.out.println("It deletes the number of records is: "+row);
    }

    @Test
    public void insert() throws Exception {
        YysExperience info=new YysExperience();
        info.setYysId(7);
        info.setYysWorkTime("周一至周五8:00-17:00");
        info.setYysExperienceId(2);
        info.setYysWorkContent("育婴");
        info.setYysCustomerEvaluation("负责");
        int row = mapper.insert(info);
        System.out.println("It inserts the number of records is: "+row);
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        YysExperience info=mapper.selectByPrimaryKey(1);
        System.out.println(info.getYysCustomerEvaluation());
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
        YysExperience info=mapper.selectByPrimaryKey(1);
        info.setYysWorkContent("检查婴儿疾病");
        int row = mapper.updateByPrimaryKey(info);
        System.out.println(info.getYysWorkContent());
    }

}
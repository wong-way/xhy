package scu.edu.cn.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.YysInfo;
import scu.edu.cn.dao.mapper.YysInfoMapper;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml","classpath:spring-mvc.xml"})
public class YysInfoTest {
    @Autowired
    YysInfoMapper mapper;


    @Test
    public void test1(){
        int row = mapper.deleteByPrimaryKey(2);
        System.out.println("It deletes the number of records is: "+row);
    }


    @Test
    public void test2(){
        YysInfo info=new YysInfo();
        info.setYysId(2);
        info.setYysName("赵信");
        info.setYysPhoto("暂无");
        info.setYysAge(34);
        info.setYysConstellation("处女座");
        info.setYysEducation("大学");
        info.setYysMarriage(true);
        info.setYysCertificate("高级育婴证书");
        int row = mapper.insert(info);
        System.out.println("It inserts the number of records is: "+row);
    }

    @Test
    public void test3(){
        YysInfo info=mapper.selectByPrimaryKey(1);
        System.out.println(info.getYysConstellation());
    }

    @Test
    public void test4(){
        YysInfo info=mapper.selectByPrimaryKey(1);
        info.setYysName("赵王");
        int row = mapper.updateByPrimaryKey(info);
        System.out.println(info.getYysName());
    }



    @Test
    public void test6(){
        List<YysInfo> list = mapper.selectAllYysInfo();
        System.out.println(list.get(2).getYysRecommendedReason());
    }
}

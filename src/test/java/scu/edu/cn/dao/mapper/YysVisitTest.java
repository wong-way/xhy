package scu.edu.cn.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.YysVisit;
import scu.edu.cn.dao.entity.YysVisitKey;
import scu.edu.cn.dao.mapper.YysVisitMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml", "classpath:spring-mvc.xml"})
public class YysVisitTest {
    @Autowired
    YysVisitMapper mapper;

    @Test
    public void test1() {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateformat.parse("2018-4-7");
            YysVisitKey yysVisitKey = new YysVisitKey();
            yysVisitKey.setYysId(3);
            yysVisitKey.setVisitDate(date);
            int row = mapper.deleteByPrimaryKey(yysVisitKey);
            System.out.println("It deletes the number of records is: " + row);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test2() {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            YysVisit yysVisit = new YysVisit();
            Date date = dateformat.parse("2018-3-2");
            yysVisit.setYysId(5);
            yysVisit.setVisitDate(date);
            yysVisit.setContent("婴儿情况良好");
            mapper.insert(yysVisit);
            System.out.println(yysVisit.getContent() + "  " + yysVisit.getVisitDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test3() {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateformat.parse("2018-3-30");
            YysVisitKey yysVisitKey = new YysVisitKey();
            yysVisitKey.setYysId(2);
            yysVisitKey.setVisitDate(date);
            YysVisit visit = mapper.selectByPrimaryKey(yysVisitKey);
            System.out.println(visit.getContent());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test4() {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateformat.parse("2018-3-30");
            YysVisitKey yysVisitKey = new YysVisitKey();
            yysVisitKey.setYysId(2);
            yysVisitKey.setVisitDate(date);
            YysVisit visit = mapper.selectByPrimaryKey(yysVisitKey);
            visit.setContent("婴儿出现过感冒症状");
            mapper.updateByPrimaryKeySelective(visit);
            System.out.println(visit.getContent());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test5() {
        List<YysVisit> list = mapper.selectAllYysVisit();
        System.out.println(list.get(0).getContent());
    }
}

package scu.edu.cn.dao.mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.CustomerVisit;
import scu.edu.cn.dao.entity.CustomerVisitKey;
import scu.edu.cn.dao.mapper.CustomerVisitMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml","classpath:spring-mvc.xml"})
public class CustomerVisitTest {
    @Autowired
    CustomerVisitMapper mapper;

    @Test
    public void test1(){
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateformat.parse("2018-3-27");
            CustomerVisitKey customerVisitKey=new CustomerVisitKey();
            customerVisitKey.setCustomerId(2);
            customerVisitKey.setVisitDate(date);
            int row= mapper.deleteByPrimaryKey(customerVisitKey);
            System.out.println("It deletes the number of records is: "+row);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test2(){
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            CustomerVisit customerVisit=new CustomerVisit();
            Date date = dateformat.parse("2018-5-30");
            customerVisit.setCustomerId(4);
            customerVisit.setVisitDate(date);
            customerVisit.setContent("询问育婴师的服务态度");
            customerVisit.setStaffId(6);
            mapper.insert(customerVisit);
            System.out.println(customerVisit.getContent()+"  "+customerVisit.getVisitDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test3(){
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateformat.parse("2018-5-30");
            CustomerVisitKey customerVisitKey=new CustomerVisitKey();
            customerVisitKey.setCustomerId(4);
            customerVisitKey.setVisitDate(date);
            CustomerVisit visit= mapper.selectByPrimaryKey(customerVisitKey);
            System.out.println(visit.getContent());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test4(){
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateformat.parse("2018-4-5");
            CustomerVisitKey customerVisitKey=new CustomerVisitKey();
            customerVisitKey.setCustomerId(3);
            customerVisitKey.setVisitDate(date);
            CustomerVisit visit= mapper.selectByPrimaryKey(customerVisitKey);
            visit.setStaffId(7);
            visit.setCustomerId(2);
            mapper.updateByPrimaryKey(visit);
            System.out.println(visit.getStaffId()+"  "+visit.getCustomerId());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test5(){
        List<CustomerVisit> list = mapper.selectAllCustomerVisit();
        System.out.println(list.get(0).getContent()+" "+list.get(0).getCustomerId());
    }
}

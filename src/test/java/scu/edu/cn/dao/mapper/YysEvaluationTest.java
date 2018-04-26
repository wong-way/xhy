package scu.edu.cn.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.YysEvaluation;
import scu.edu.cn.dao.entity.YysEvaluationKey;
import scu.edu.cn.dao.mapper.YysEvaluationMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml","classpath:spring-mvc.xml"})
public class YysEvaluationTest {
    @Autowired
    YysEvaluationMapper mapper;


    @Test
    public void deleteByPrimaryKey() throws Exception {
        YysEvaluationKey yysEvaluationKey=new YysEvaluationKey();
        yysEvaluationKey.setYysId(1);
        yysEvaluationKey.setContractId(3);
        int row = mapper.deleteByPrimaryKey(yysEvaluationKey);
        System.out.println("It deletes the number of records is: "+row);
    }

    @Test
    public void insert() throws Exception {
        YysEvaluation yysEvaluation=new YysEvaluation();
        yysEvaluation.setYysId(6);
        yysEvaluation.setContractId(9);
        yysEvaluation.setYysSalary(7000.00);
        int row = mapper.insert(yysEvaluation);
        System.out.println("It inserts the number of records is: "+row);
    }


    @Test
    public void selectByPrimaryKey() throws Exception {
        YysEvaluationKey yysEvaluationKey=new YysEvaluationKey();
        yysEvaluationKey.setYysId(3);
        yysEvaluationKey.setContractId(6);
        YysEvaluation yysEvaluation=mapper.selectByPrimaryKey(yysEvaluationKey);
        System.out.println(yysEvaluation.getYysCustomerEvaluation());
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
        YysEvaluation yysEvaluation=new YysEvaluation();
        yysEvaluation.setYysId(6);
        yysEvaluation.setContractId(9);
        yysEvaluation.setYysSalary(10000.00);
        mapper.updateByPrimaryKey(yysEvaluation);
    }

}

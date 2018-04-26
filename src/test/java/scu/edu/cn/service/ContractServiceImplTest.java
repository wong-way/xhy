package scu.edu.cn.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.Contract;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import java.util.Date;

/**
 * @author 黄伟
 * 测试业务逻辑
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml", "classpath:spring-mvc.xml"})
public class ContractServiceImplTest {
    @Autowired
    ContractService service;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    Error error;

    /**
     * 测试插入数据
     * @throws Exception
     */
    @Test
    public void insertContract() throws Exception {
        Date date = new Date();
        Contract contract = new Contract();
        contract.setContractAmount(120.00);
        contract.setContractCollectionTime(new java.sql.Date(date.getTime()));
        contract.setContractId(2);
        contract.setContractServiceContent("一年时间育婴aaaaaaaaaa");
        contract.setCustomerId(1);
        error = service.insertContract(contract);
        logger.info(error.getMessage());

    }

    /**
     * 测试更新数据
     * @throws Exception
     */
    @Test
    public void updateContract() throws Exception {
        Date date = new Date();
        Contract contract = new Contract();
        contract.setContractAmount(120.00);
        contract.setContractCollectionTime(new java.sql.Date(date.getTime()));
        contract.setContractId(2);
        contract.setContractServiceContent("一年时间育婴");
        contract.setCustomerId(1);
        error = service.updateContract(contract);
        logger.info(error.getMessage());

    }

    /**
     * 测试获取数据
     * @throws Exception
     */
    @Test
    public void getAll() throws Exception {
        Response response = service.getAll();
        logger.info(response.getError().getMessage());
        logger.info(response.getData().toString());

    }

    /**
     * 测试根据id获取合同数据
     * @throws Exception
     */
    @Test
    public void getContractById() throws Exception {
        logger.info(service.getContractById(1).toString());

    }

    /**
     * 测试删除数据
     * @throws Exception
     */
    @Test
    public void deleteContract() throws Exception {
        logger.info(service.deleteContract(1).getMessage());
    }


}